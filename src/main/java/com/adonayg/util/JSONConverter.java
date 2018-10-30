package com.adonayg.util;

import java.io.IOException;
import java.util.logging.Logger;

import com.adonayg.entitiy.Account;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONConverter {
	Account dummyAccount = new Account();
	Logger logger;
	private ObjectMapper mapper = new ObjectMapper();

	public String convertAccount(Account account) {
		try {
			return mapper.writeValueAsString(account);
		} catch (JsonProcessingException e) {

			e.printStackTrace();
			return "Micheal Jackson says Ohhhh something went wrong";
		}
	}

	public Account convertJsonToAccount(String json) {
		Account account;
		try {
			account = mapper.readValue(json, Account.class);
		} catch (JsonParseException e) {

			e.printStackTrace();
			return dummyAccount;
		} catch (JsonMappingException e) {

			e.printStackTrace();
			return dummyAccount;
		} catch (IOException e) {

			e.printStackTrace();
			return dummyAccount;
		}
		return account;
	}
}
