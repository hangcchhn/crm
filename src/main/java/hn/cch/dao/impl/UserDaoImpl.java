package hn.cch.dao.impl;

import hn.cch.dao.UserDao;
import hn.cch.entity.User;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User login(User user) {
		String sql = "FROM User WHERE userName = ? AND userPwd = ?";
		List<User> users = (List<User>) hibernateTemplate.find(sql,
				user.getUserName(), user.getUserPwd());
		if (users != null && users.size() != 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> selectAll() {
		List<User> users = (List<User>) hibernateTemplate.find("FROM User");
		return users;
	}

}
