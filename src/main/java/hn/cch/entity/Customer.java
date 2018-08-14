package hn.cch.entity;

import java.util.HashSet;
import java.util.Set;

//客户类
public class Customer {

	private Integer customerId;// 编号
	private String customerName;// 名称
	private Level customerLevel;// 级别
	private Source customerSource;// 来源
	private String customerPhone;// 电话
	private String customerMoblie;// 手机
	// 一个客户可以有多个联系人，使用集合
	private Set<Contacter> customerContacters = new HashSet<Contacter>();
	
	private Set<Visit> CustomerVisits = new HashSet<Visit>();
	
	public Customer() {
		super();
	}

	public Customer(String customerName, Level customerLevel,
					Source customerSource, String customerPhone, String customerMoblie) {
		super();
		this.customerName = customerName;
		this.customerLevel = customerLevel;
		this.customerSource = customerSource;
		this.customerPhone = customerPhone;
		this.customerMoblie = customerMoblie;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Level getCustomerLevel() {
		return customerLevel;
	}

	public void setCustomerLevel(Level customerLevel) {
		this.customerLevel = customerLevel;
	}

	public Source getCustomerSource() {
		return customerSource;
	}

	public void setCustomerSource(Source customerSource) {
		this.customerSource = customerSource;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerMoblie() {
		return customerMoblie;
	}

	public void setCustomerMoblie(String customerMoblie) {
		this.customerMoblie = customerMoblie;
	}

	public Set<Contacter> getCustomerContacters() {
		return customerContacters;
	}

	public void setCustomerContacters(Set<Contacter> contacters) {
		this.customerContacters = contacters;
	}

	public Set<Visit> getCustomerVisits() {
		return CustomerVisits;
	}

	public void setCustomerVisits(Set<Visit> visits) {
		this.CustomerVisits = visits;
	}

}
