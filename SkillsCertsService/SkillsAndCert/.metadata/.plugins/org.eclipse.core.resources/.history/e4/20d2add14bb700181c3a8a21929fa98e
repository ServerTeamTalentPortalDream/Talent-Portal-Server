package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Account;
import com.revature.services.AccountService;

@RestController
@RequestMapping("accounts")
public class AccountController {
	@Autowired
	private AccountService accountServcie;

	@PostMapping
	public int save(@RequestBody Account a) {
		return accountServcie.save(a);
	}

	@GetMapping
	public List<Account> findAll() {
		List<Account> accounts = accountServcie.findAll();
		accounts.forEach(account -> {
			if (account.getOwner() != null) {
				account.getOwner().setAccounts(null);
			}
		});
		return accounts;
	}

}
