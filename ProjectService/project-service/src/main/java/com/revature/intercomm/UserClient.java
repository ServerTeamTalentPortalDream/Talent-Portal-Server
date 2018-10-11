package com.revature.intercomm;

import java.util.List;

// import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.model.User;

// @FeignClient(name="user-service", fallback=UserClientFallback.class)
public interface UserClient {

	@GetMapping("/users/project/{id}")
	List<User> getUsersByProject(@PathVariable("id") int id);
	
}