package hn.cch.service;

import java.util.List;

import hn.cch.entity.User;

public interface UserService {
	public User login(User user);

	public List<User> selectAll();
}
