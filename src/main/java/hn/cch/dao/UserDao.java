package hn.cch.dao;

import hn.cch.entity.User;

import java.util.List;

public interface UserDao {
	
	public User login(User user);

	public List<User> selectAll();

}
