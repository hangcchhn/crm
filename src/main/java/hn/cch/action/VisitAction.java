package hn.cch.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import hn.cch.entity.Customer;
import hn.cch.entity.User;
import hn.cch.entity.Visit;
import hn.cch.service.CustomerService;
import hn.cch.service.UserService;
import hn.cch.service.VisitService;
import org.apache.struts2.ServletActionContext;

import java.util.List;

public class VisitAction extends ActionSupport implements ModelDriven<Visit> {

	private VisitService visitService;
	private CustomerService customerService;
	private UserService userService;

	

	public VisitService getVisitService() {
		return visitService;
	}

	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private Visit visit = new Visit();
	
	@Override
	public Visit getModel() {
		return visit;
	}

	public String add() {

		//用户
		List<User> users = userService.selectAll();
		ServletActionContext.getRequest().setAttribute("users", users);
		//客户
		List<Customer> customers = customerService.selectAll();
		ServletActionContext.getRequest().setAttribute("customers", customers);

		return "add";
	}
	
	public String insert(){
		
		visitService.insert(visit);
		return "insert";
	}
	
	public String list(){
		List<Visit> visits = visitService.selectAll();
		ServletActionContext.getRequest().setAttribute("visits", visits);
		return "list";
	}

	public String edit(){

		Visit v = visitService.selectOne(visit.getVisitId());
		ServletActionContext.getRequest().setAttribute("visit", v);

		//用户
		List<User> users = userService.selectAll();
		ServletActionContext.getRequest().setAttribute("users", users);
		//客户
		List<Customer> customers = customerService.selectAll();
		ServletActionContext.getRequest().setAttribute("customers", customers);

		return "edit";
	}

	public String update(){
		visitService.update(visit);
		return "update";
	}

	public String delete(){
		Visit v = visitService.selectOne(visit.getVisitId());
		if(v != null){
			visitService.delete(v);
		}
		return "delete";
	}



	public String content(){

		String content = visit.getVisitContent();
		List<Visit> visits = null;

		if(content != null && !content.trim().equals("")){
			visits = visitService.selectContent(content);
		}else {
			visits = visitService.selectAll();
		}
		ServletActionContext.getRequest().setAttribute("visits", visits);
		return "content";
	}

	public String where(){

		//用户
		List<User> users = userService.selectAll();
		ServletActionContext.getRequest().setAttribute("users", users);
		//客户
		List<Customer> customers = customerService.selectAll();
		ServletActionContext.getRequest().setAttribute("customers", customers);

		return "where";
	}

	public String select(){

		List<Visit> visits = visitService.selectWhere(visit);
		ServletActionContext.getRequest().setAttribute("visits", visits);
		return "select";
	}

}
