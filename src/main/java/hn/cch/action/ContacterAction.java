package hn.cch.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import hn.cch.entity.Contacter;
import hn.cch.entity.Customer;
import hn.cch.service.ContacterService;
import hn.cch.service.CustomerService;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.util.List;

@SuppressWarnings("serial")
public class ContacterAction extends ActionSupport implements
        ModelDriven<Contacter> {

    private ContacterService contacterService;
    private CustomerService customerService;

    public ContacterService getContacterService() {
        return contacterService;
    }

    public void setContacterService(ContacterService contacterService) {
        this.contacterService = contacterService;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    private Contacter contacter = new Contacter();

    @Override
    public Contacter getModel() {
        return contacter;
    }

    private File fileupload;
    private String fileuploadFileName;

    public File getFileupload() {
        return fileupload;
    }

    public void setFileupload(File fileupload) {
        this.fileupload = fileupload;
    }

    public String getFileuploadFileName() {
        return fileuploadFileName;
    }

    public void setFileuploadFileName(String fileuploadFileName) {
        this.fileuploadFileName = fileuploadFileName;
    }


    public String add() {
        // 查询所有客户
        List<Customer> customers = customerService.selectAll();
        ServletActionContext.getRequest().setAttribute("customers", customers);
        return "add";
    }

    // 新增客户
    public String insert() {
        // 文件上传
        // if (fileupload == null) {
        //
        // }

        // 原始做法
        // int customerId = Integer.parseInt(ServletActionContext.getRequest()
        // .getParameter("customerId"));
        // Customer customer = new Customer();
        // customer.setCustomerId(customerId);
        // contacter.setCustomer(customer);

        // 简化做法
        contacterService.insert(contacter);

        return "insert";
    }

    public String list() {

        List<Contacter> contacters = contacterService.selectAll();
        ServletActionContext.getRequest()
                .setAttribute("contacters", contacters);
        return "list";
    }

    public String edit() {

        List<Customer> customers = customerService.selectAll();
        ServletActionContext.getRequest().setAttribute("customers", customers);

        int contacterId = contacter.getContacterId();
        Contacter contacter = contacterService.selectOne(contacterId);
        ServletActionContext.getRequest().setAttribute("contacter", contacter);

        return "edit";
    }

    public String update() {
        contacterService.update(contacter);
        return "update";
    }

    public String delete() {

        Contacter c = contacterService.selectOne(contacter.getContacterId());
        if (c != null) {
            contacterService.delete(c);
        }
        return "update";
    }

    public String where() {

        // 查询所有客户
        List<Customer> customers = customerService.selectAll();
        ServletActionContext.getRequest().setAttribute("customers", customers);

        return "where";
    }

    public String select() {
        List<Contacter> contacters = contacterService.selectWhere(contacter);
        ServletActionContext.getRequest().setAttribute("contacters", contacters);
        return "select";

    }

}
