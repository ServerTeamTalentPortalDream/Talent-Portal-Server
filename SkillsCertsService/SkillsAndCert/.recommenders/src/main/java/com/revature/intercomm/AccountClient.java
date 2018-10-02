package com.revature.intercomm;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "account-service")
public class AccountClient {
@GetMapping("/customers/{id}");
List<Account> getAccountsByCustomer(@PathVariable("id")int id);
}
