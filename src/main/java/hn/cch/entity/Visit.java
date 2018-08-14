package hn.cch.entity;

public class Visit {
	private Integer visitId;
	private String visitAddress;
	private String visitContent;

	//用户与客户的拜访
	private User visitUser;
	private Customer visitCustomer;

	public Integer getVisitId() {
		return visitId;
	}

	public void setVisitId(Integer visitId) {
		this.visitId = visitId;
	}

	public String getVisitAddress() {
		return visitAddress;
	}

	public void setVisitAddress(String visitAddress) {
		this.visitAddress = visitAddress;
	}

	public String getVisitContent() {
		return visitContent;
	}

	public void setVisitContent(String visitContent) {
		this.visitContent = visitContent;
	}

	public User getVisitUser() {
		return visitUser;
	}

	public void setVisitUser(User user) {
		this.visitUser = user;
	}

	public Customer getVisitCustomer() {
		return visitCustomer;
	}

	public void setVisitCustomer(Customer customer) {
		this.visitCustomer = customer;
	}

}
