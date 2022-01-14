package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import dao.EmployeeDao;
import model.Employee;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeDao employeeDao;
	@RequestMapping("/index")
	public String index(ModelMap map) {
		List<Employee> employees = employeeDao.listAllEmployees();
		map.put("elist",employees);
		return "employees";
	}
	@RequestMapping("/delete")
	public String deleteEmployeeByID(int eid){
		employeeDao.delete(eid);
		return "redirect:index"; 
	}
	@RequestMapping("/edit")
	public String editEmployeeByID(int eid,ModelMap map){
		Employee e=employeeDao.queryEmployeeById(eid);
		map.put("em", e);
		return "editEmployee";
	}
	@RequestMapping("/toadd")
	public String toAdd() {
		return "addEmployee";
	}
	@RequestMapping("/add")
	public String addEmployee(String name,String phone,String email,int type,int pid,ModelMap map){
		Employee e=new Employee();
		e.setName(name);e.setPhone(phone);e.setEmail(email);
		e.setType(type);e.setPid(pid);
		employeeDao.save(e);
		return "redirect:index"; 
	}
	@RequestMapping("/update")
	public String updateCustomer(int eid,String name,String phone,String email,int type,int pid,Float bonus,ModelMap map){
		Employee e=new Employee(eid, name, phone, email, type, pid, bonus);
		employeeDao.update(e);;
		return "redirect:index"; 
	}
}
