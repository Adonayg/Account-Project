package com.adonayg.services;

public interface AccountService {
	String getAllAccounts();
	
	String getAccount(Long id);

	String addAccount(String account);

	String deleteAccount(Long id);
	
	String updateAccount(String account);
}
