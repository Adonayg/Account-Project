package com.adonayg.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.adonayg.entitiy.Account;
import com.adonayg.util.JSONConverter;

@Transactional(SUPPORTS)
@Default
public class AccountDBRepository implements AccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONConverter jsonConverter;

	@Override
	public String getAllAccounts() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return jsonConverter.convertAccount(accounts);

	}

	@Override
	public String getAccount(Long id) {
		Account accountInDB = findAccount(id);
		if (accountInDB != null) {
			return jsonConverter.convertAccount(accountInDB);
		}
		return "{\"message\": \"No account with that id\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateAccount(String account) {
		Account accountUpdates = jsonConverter.convertJsonToAccount(account);
		Account accountInDB = findAccount(accountUpdates.getId());
		if (accountInDB != null) {
			accountInDB.setFirstName(accountUpdates.getFirstName());
			accountInDB.setSecondName(accountUpdates.getSecondName());
			accountInDB.setAccountNumber(accountUpdates.getAccountNumber());
			return jsonConverter.convertAccount(accountInDB);
		}
		return "{\"message\": \"account doesn't exsist\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account anAccount = jsonConverter.convertJsonToAccount(account);
		manager.persist(anAccount);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account accountInDB = findAccount(id);
		if (accountInDB != null) {
			manager.remove(accountInDB);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}

	public Account findAccount(Long id) {
		return manager.find(Account.class, id);

	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setJsonConverter(JSONConverter jsonConverter) {
		this.jsonConverter = jsonConverter;
	}

}
