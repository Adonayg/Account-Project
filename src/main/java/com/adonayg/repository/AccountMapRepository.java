package com.adonayg.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.adonayg.entitiy.Account;
import com.adonayg.util.JSONConverter;

@ApplicationScoped
@Alternative
public class AccountMapRepository implements AccountRepository {
	private Map<Long, Account> accountMap = new HashMap<>();
	Long id = (long) 0;

	@Inject
	private JSONConverter jsonConverter;

	public Map<Long, Account> addAccount(Account account) {
		if (account.getId() != null) {
			Long id = account.getId();
		}
		accountMap.put(id, account);
		id++;
		return accountMap;
	}

	public int countByFirstName(String fname) {
		return (int) accountMap.entrySet().stream().filter(i -> i.getValue().getFirstName().equals(fname)).count();
	}

	@Override
	public String getAllAccounts() {
		Collection<Account> accounts = accountMap.values();
		return jsonConverter.convertAccount(accounts);
	}

	@Override
	public String getAccount(Long id) {
		return jsonConverter.convertAccount(accountMap.get(id));
	}

	@Override
	public String createAccount(String account) {
		addAccount(jsonConverter.convertJsonToAccount(account));
		return "{\"message\": \"account created succesfully\"}";
	}

	@Override
	public String deleteAccount(Long id) {
		accountMap.remove(id);
		return "{\"message\": \"account deleted succesfully\"}";
	}

	@Override
	public String updateAccount(String account) {
		return null;
	}

	public void setJsonConverter(JSONConverter jsonConverter) {
		this.jsonConverter = jsonConverter;
	}

}
