package com.adonayg.repository;

public interface AccountRepository {

	String getAllAccounts();

	String getAccount(Long id);

	String updateAccount(String account);

	String createAccount(String account);

	String deleteAccount(Long id);

}
