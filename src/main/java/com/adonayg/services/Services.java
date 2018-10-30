package com.adonayg.services;

import java.util.HashMap;
import java.util.Map;

import com.adonayg.entitiy.Account;

public class Services {

	private Map<Integer, Account> accountMap = new HashMap<>();

	private Integer id;

	public Map<Integer, Account> getAccountMap() {
		return accountMap;
	}

	public void setAccountMap(Map<Integer, Account> accountMap) {
		this.accountMap = accountMap;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountDetails(Account account) {
		return account.toString();
	}

	public Map<Integer, Account> addAccount(Account account) {
		accountMap.put(id, account);
		id++;
		return accountMap;
	}

	public String greetAccount(Account account) {
		return "Hello " + account.getFirstName();
	}
}
