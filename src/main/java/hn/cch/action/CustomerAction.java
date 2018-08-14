package hn.cch.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import hn.cch.entity.Customer;
import hn.cch.entity.Level;
import hn.cch.entity.Page;
import hn.cch.entity.Source;
import hn.cch.service.CustomerService;
import hn.cch.service.LevelService;
import hn.cch.service.SourceService;
import org.apache.struts2.ServletActionContext;

import java.util.List;

@SuppressWarnings("serial")
public class CustomerAction extends ActionSupport implements
		ModelDriven<Customer> {

	private CustomerService customerService;
	private LevelService levelService;
	private SourceService sourceService;

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public LevelService getLevelService() {
		return levelService;
	}

	public void setLevelService(LevelService levelService) {
		this.levelService = levelService;
	}

	public SourceService getSourceService() {
		return sourceService;
	}

	public void setSourceService(SourceService sourceService) {
		this.sourceService = sourceService;
	}

	private Customer customer = new Customer();

	@Override
	public Customer getModel() {
		return customer;
	}

	// 使用值栈
	// List<Customer> customers;
	//
	// public List<Customer> getCustomers() {
	// return customers;
	// }
	//
	// public void setCustomers(List<Customer> customers) {
	// this.customers = customers;
	// }

	private int pageCode;

	public int getPageCode() {
		return pageCode;
	}

	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}

	// 页面跳转
	public String add() {
		//查询所有客户级别
		List<Level> levels = levelService.selectAll();
		ServletActionContext.getRequest().setAttribute("levels", levels);

		//查询所有客户来源
		List<Source> sources = sourceService.selectAll();
		ServletActionContext.getRequest().setAttribute("sources", sources);

		return "add";
	}

	// 新增客户
	public String insert() {
		customerService.insert(customer);
		return "insert";
	}

	// 客户列表
	public String list() {
		// 使用struts域对象
		List<Customer> customers = customerService.selectAll();
		ServletActionContext.getRequest().setAttribute("customers", customers);

		// 使用struts值栈
		// customers = customerService.selectAll();
		return "list";
	}

	public String delete() {

		Customer c = customerService.selectOne(customer.getCustomerId());
		if (c != null) {
			customerService.delete(c);
		}
		return "delete";
	}

	public String edit() {
		Customer c = customerService.selectOne(customer.getCustomerId());
		ServletActionContext.getRequest().setAttribute("customer", c);

		//查询所有客户级别
		List<Level> levels = levelService.selectAll();
		ServletActionContext.getRequest().setAttribute("levels", levels);

		//查询所有客户来源
		List<Source> sources = sourceService.selectAll();
		ServletActionContext.getRequest().setAttribute("sources", sources);

		return "edit";
	}

	public String update() {
		customerService.update(customer);
		return "update";
	}

	public String page() {
		Page page = customerService.selectPage(pageCode);
		ServletActionContext.getRequest().setAttribute("page", page);
		return "page";
	}
	//客户名称查询
	public String name() {

		String name = customer.getCustomerName();
		List<Customer> customers = null;


		if (name != null && !name.trim().equals("")) {
			customers = customerService.selectName(name);
		} else {
			customers = customerService.selectAll();
		}
		ServletActionContext.getRequest().setAttribute("customers", customers);

		return "name";
	}

	//组合条件查询

	public String where(){
		return "where";
	}

	public String select(){

		List<Customer> customers = customerService.selectWhere(customer);
		ServletActionContext.getRequest().setAttribute("customers", customers);

		return "select";
	}

	public String level(){

		List list = customerService.countLevel();
		ServletActionContext.getRequest().setAttribute("list", list);

		return "level";
	}

	public String source(){

		List list = customerService.countSource();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "source";
	}



}
