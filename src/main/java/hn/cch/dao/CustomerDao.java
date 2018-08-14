package hn.cch.dao;

import hn.cch.entity.Customer;

import java.util.List;

public interface CustomerDao {


	void insert(Customer customer);

	void delete(Customer customer);

	void update(Customer customer);

	List<Customer> selectAll();

	Customer selectOne(int customerId);

	int selectCount();
	
	List<Customer> selectPage(int pageInit, int pageSize);

	List<Customer> selectName(String name);
	
	List<Customer> selectWhere(Customer customer);

	List countLevel();

	List countSource();

}
