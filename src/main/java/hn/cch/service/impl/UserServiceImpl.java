package hn.cch.service.impl;

import java.util.List;

import hn.cch.dao.UserDao;
import hn.cch.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import hn.cch.entity.User;


@Transactional
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User login(User user) {
		return userDao.login(user);
	}

	@Override
	public List<User> selectAll() {
		
		return userDao.selectAll();
	}

}
