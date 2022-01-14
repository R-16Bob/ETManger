package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import dao.CustomerDao;
import model.Customer;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerDao customerDao;
	@RequestMapping("/index")
	public String index(ModelMap map) {
		List<Customer> customers = customerDao.listAllCustomers();
		map.put("clist",customers);
		return "customers";
	}
	@RequestMapping("/delete")
	public String deleteCustomerByID(int cid){
		customerDao.delete(cid);
		return "redirect:index"; 
	}
	@RequestMapping("/edit")
	public String editCustomerByID(int cid,ModelMap map){
		Customer c=customerDao.queryCustomerById(cid);
		map.put("cus", c);
		return "editCustomer";
	}
	@RequestMapping("/toadd")
	public String toAdd() {
		return "addCustomer";
	}
	@RequestMapping("/add")
	public String addCustomer(String cname,String phone,String email,ModelMap map){
		Customer c=new Customer();
		c.setCname(cname);
		c.setPhone(phone);c.setEmail(email);
		customerDao.save(c);
		return "redirect:index"; 
	}
	@RequestMapping("/update")
	public String updateCustomer(int cid,String cname,String phone,String email,ModelMap map){
		Customer c=new Customer(cid, cname, phone, email);
		customerDao.update(c);
		return "redirect:index"; 
	}
}