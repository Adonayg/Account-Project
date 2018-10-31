package com.adonayg.accountapp.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.adonayg.entitiy.Account;
import com.adonayg.services.Services;

public class AccountappTest {


	@Test
	public void countByFirstNameTest() {

		
		Account account1 = new Account("John", "Doe", "123");
		Account account2 = new Account("Smithy", "Dunn", "134");
		Account account3 = new Account("John", "Smith", "341");
		Services service = new Services();
	
		service.addAccount(1, account1);
		service.addAccount(2, account2);
		service.addAccount(3, account3);
		
		int actual = service.countByFirstName("John");
		assertEquals(2, actual);
		
	}

}
