package accountapp;

import java.io.IOException;

import com.adonayg.entitiy.Account;
import com.adonayg.util.JSONConverter;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

	public static void main(String[] args){
		Account account1 = new Account("John", "Smith", "123");
		JSONConverter jsonConverter = new JSONConverter();
		jsonConverter.convertAccount(account1);

		
		Account account2 = jsonConverter.convertJsonToAccount(jsonConverter.convertAccount(account1));
		jsonConverter.convertAccount(account2);
		
		
		
	
	}
}