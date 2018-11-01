package com.adonayg.services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.adonayg.entitiy.Account;

public class Services {

	private Map<Integer, Account> accountMap = new HashMap<>();
	private Integer id;

	public Map<Integer, Account> addAccount(int id, Account account) {
		accountMap.put(id, account);

		return accountMap;
	}

	public int countByFirstName(String fname) {
		return (int) accountMap.entrySet().stream().filter(i -> i.getValue().getFirstName().equals(fname)).count();
	}
}
