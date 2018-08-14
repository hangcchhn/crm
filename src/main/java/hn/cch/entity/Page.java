package hn.cch.entity;

import java.util.List;

public class Page {

	private int totalRecord;
	private int totalPage;

	private int pageCode;
	private int pageInit;
	private int pageSize;
	private List<Customer> pageList;

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageCode() {
		return pageCode;
	}

	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}

	public int getPageInit() {
		return pageInit;
	}

	public void setPageInit(int pageInit) {
		this.pageInit = pageInit;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<Customer> getPageList() {
		return pageList;
	}

	public void setPageList(List<Customer> pageList) {
		this.pageList = pageList;
	}

}
