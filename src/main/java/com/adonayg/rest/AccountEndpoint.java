package com.adonayg.rest;

import javax.inject.Inject;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.adonayg.services.AccountService;

@Path("/account")
public class AccountEndpoint {

	@Inject
	private AccountService service;

	@Path("/getAllAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return service.getAllAccounts();
	}

	@Path("/getAccount/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAccount(Long id) {
		return service.getAccount(id);
	}

	@Path("/createAccount")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) {
		return service.addAccount(account);
	}

	@Path("/deleteAccount/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long id) {
		return service.deleteAccount(id);
	}

	@Path("/updateAccount")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(String account) {
		return service.updateAccount(account);
	}

	public void setService(AccountService service) {
		this.service = service;
	}

}