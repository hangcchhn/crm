package hn.cch.service;

import hn.cch.entity.Customer;
import hn.cch.entity.Page;

import java.util.List;

//业务层接口
public interface CustomerService {

	public List<Customer> selectAll();

	public void insert(Customer customer);
	
	public Customer selectOne(int customerId);
	
	public void delete(Customer customer);
	
	public void update(Customer customer);
	
	public Page selectPage(int pageCode);

	public List<Customer> selectName(String name);

	public List<Customer> selectWhere(Customer customer);

	List countLevel();

	List countSource();
}
