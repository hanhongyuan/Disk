package com.linkyuji.service;

import java.util.List;

import com.linkyuji.pojo.Users;

public interface UserService {
	public boolean getLoginUser(Users users);
	public Users getUserById(String id);
	public boolean regiest(Users users);
	public List<Users> loadAllUsers();
}
