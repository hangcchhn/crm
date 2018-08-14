package hn.cch.service.impl;

import hn.cch.dao.CustomerDao;
import hn.cch.entity.Customer;
import hn.cch.entity.Page;
import hn.cch.service.CustomerService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public List<Customer> selectAll() {
		return customerDao.selectAll();
	}

	public void insert(Customer customer) {
		customerDao.insert(customer);
	}

	@Override
	public Customer selectOne(int customerId) {
		return customerDao.selectOne(customerId);
	}

	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}

	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}

	@Override
	public Page selectPage(int pageCode) {
		
		Page page = new Page();
		//页码
		page.setPageCode(pageCode);
		//总记录数
		page.setTotalRecord(customerDao.selectCount());
		
		//每页记录数量（最后一页例外）
		int size = 7;
		page.setPageInit((page.getPageCode() - 1) * size);
		
		if (page.getTotalRecord() % size == 0) {
			page.setTotalPage(page.getTotalRecord() / size);
			page.setPageSize(size);
		} else {
			page.setTotalPage(page.getTotalRecord() / size + 1);
			if (page.getPageCode() == page.getTotalPage()) {
				page.setPageSize(page.getTotalRecord() % size);
			}else {
				page.setPageSize(size);
			}
		}
		
		page.setPageList(customerDao.selectPage(page.getPageInit(), page.getPageSize()));
		 
		
		return page;
	}



	@Override
	public List<Customer> selectName(String name) {
		return customerDao.selectName(name);
	}

	@Override
	public List<Customer> selectWhere(Customer customer) {
		return customerDao.selectWhere(customer);
	}

	@Override
	public List countLevel() {
		return customerDao.countLevel();
	}

	@Override
	public List countSource() {
		return customerDao.countSource();
	}


}
