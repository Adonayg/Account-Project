package com.adonayg.repository;

import com.adonayg.entitiy.Account;

public interface AccountRepository {
	
	String getAllAccounts();
	String getAccount(Long id);
	String updateAccount(String account);
	String createAccount(String account);
	String deleteAccount(Long id);
	
	


}
