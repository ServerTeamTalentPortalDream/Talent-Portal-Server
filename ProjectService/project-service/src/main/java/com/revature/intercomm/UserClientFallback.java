
package com.revature.intercomm;

import java.util.List;

import org.springframework.stereotype.Component;

import com.revature.model.User;

@Component
public class UserClientFallback implements UserClient {

	@Override
	public List<User> getUsersByProject(int id) {
		return null;
	}

}