package telran.spring.data;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import telran.spring.data.model.Dto;

public class AccountApp {
	private static String roleTmp[] = { "ADMIN", "STATIST", "USER", "APPL_ADMIN" };
	private final static int nAccounts = 50;
	private static List<Dto> accounts;
	private static Dto oneAccount= new Dto();

	public static void main(String[] args) {

		addAccounts();
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("accounts.json"), accounts);
		} catch (StreamWriteException e) {

			e.printStackTrace();
		} catch (DatabindException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	private static void addAccounts() {
	int i = 0;
		while (i < nAccounts) {
			
			addOneAccount(i++);
		}

	}

	private static void addOneAccount(Integer i) {
		
		oneAccount.setUserName("name" + String.valueOf(i));
		oneAccount.setPassword(passwordGenerate());		
		oneAccount.setRoles(roleTmp);
		oneAccount.setExperation(LocalDateTime.now().plusHours(getRandomNumber(100, 400)));
		accounts.add(oneAccount);
	
		
	}

	private static String passwordGenerate() {
		String res = null;
		int i = 0;
		while (i <= 8) {
			res = res + (char) getRandomNumber(1, 127);
		}
		return res;

	}

	private static int getRandomNumber(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}

}
