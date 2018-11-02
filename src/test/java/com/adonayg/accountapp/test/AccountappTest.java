package com.adonayg.accountapp.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.adonayg.entitiy.Account;
import com.adonayg.repository.AccountMapRepository;

public class AccountappTest {


	@Test
	public void countByFirstNameTest() {

		
		Account account1 = new Account("John", "Doe", "123");
		Account account2 = new Account("Smithy", "Dunn", "134");
		Account account3 = new Account("John", "Smith", "341");
		AccountMapRepository service = new AccountMapRepository();
	
		service.addAccount(account1);
		service.addAccount(account2);
		service.addAccount(account3);
		
		int actual = service.countByFirstName("John");
		assertEquals(2, actual);
		
	}

}
