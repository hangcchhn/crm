package hn.cch.entity;

//联系人类
public class Contacter {
	private Integer contacterId;// 编号

	// 一个联系人只属于一个客户
	private Customer contacterCustomer;

	private String contacterName;// 名称
	private String contacterGender;// 性别
	private String contacterPhone;// 电话


	public Contacter() {
		super();
	}


	public Contacter(Integer contacterId, Customer contacterCustomer, String contacterName, String contacterGender, String contacterPhone) {
		this.contacterId = contacterId;
		this.contacterCustomer = contacterCustomer;
		this.contacterName = contacterName;
		this.contacterGender = contacterGender;
		this.contacterPhone = contacterPhone;

	}

	public Integer getContacterId() {
		return contacterId;
	}

	public void setContacterId(Integer contacterId) {
		this.contacterId = contacterId;
	}

	public Customer getContacterCustomer() {
		return contacterCustomer;
	}

	public void setContacterCustomer(Customer contacterCustomer) {
		this.contacterCustomer = contacterCustomer;
	}

	public String getContacterName() {
		return contacterName;
	}

	public void setContacterName(String contacterName) {
		this.contacterName = contacterName;
	}

	public String getContacterGender() {
		return contacterGender;
	}

	public void setContacterGender(String contacterGender) {
		this.contacterGender = contacterGender;
	}

	public String getContacterPhone() {
		return contacterPhone;
	}

	public void setContacterPhone(String contacterPhone) {
		this.contacterPhone = contacterPhone;
	}


}
