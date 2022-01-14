package controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.CustomerDao;
import dao.EmployeeDao;
import dao.EventDao;
import dao.ProjectDao;
import model.Customer;
import model.Employee;
import model.Event;
import model.Project;

@Controller
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	ProjectDao projectDao;
	@Autowired
	CustomerDao customerDao;
	@Autowired
	EventDao eventDao;
	@Autowired
	EmployeeDao employeeDao;
	@RequestMapping("/info")
	public String info(int pid,ModelMap map,HttpSession session) {
		//根据pid获取project对象和对应customer对象
		Project project=projectDao.queryProjectById(pid);
		session.setAttribute("project", project);
		Customer customer=customerDao.queryCustomerById(project.getCid());
		map.put("customer",customer);
		return "projectInfo";
	}
	@RequestMapping("/toadd")
	public String toAdd(HttpSession session,ModelMap map) {
		Project project = (Project) session.getAttribute("project");
		List<Customer> customers=customerDao.listAllCustomers();
		//新增项目页面的选择框需要客户列表
		map.put("clist",customers);
		return "addProject";
	}
	@RequestMapping("/add")
	public String addProject(String pname,String btime,int cid) {
		//注意表单的日期为String，需要转换为Timestamp
		Timestamp time = Timestamp.valueOf(btime);
		Project p=new Project();
		p.setPname(pname);p.setBtime(time);
		p.setCid(cid);
		projectDao.save(p);
		return "redirect:../projectView/index";
	}
	@RequestMapping("/delete")
	public String deleteProjectByID(int pid){
		projectDao.delete(pid);
		return "redirect:../projectView/index"; 
	}
	@RequestMapping("/count")
	public String count(int pid) {  
		//计算收支和利润率
		float cost=0,profit=0;
		float prate=0;  
		//获取project对象
		Project p=projectDao.queryProjectById(pid);
		//获取该项目Event列表
		List<Event> elist=eventDao.listAllCustomersByPid(pid);
		//计算成本和盈亏
		for(Event e:elist) {
			profit+=e.getAmount();
			if(e.getAmount()<0)
				cost-=e.getAmount();
		}
		if(cost!=0)
			prate=profit/cost;
		p.setProfit(profit);
		p.setPrate(prate);
		projectDao.update(p);
		return "redirect:info?pid="+p.getPid();
	}
	@RequestMapping("/staff")
	public String staff(int pid,ModelMap map) {
		List<Employee> elist=employeeDao.listAllEmployeesByPid(pid);
		map.put("elist",elist);
		//获取不在这个项目的员工列表
		List<Employee> elist2= employeeDao.listNotStaffByPid(pid);
		map.put("elist2",elist2);
		return "staff";
	}
	@RequestMapping("addstaff")
	public String addstaff(int eid,int pid) {
		//获取员工对象
		Employee e=employeeDao.queryEmployeeById(eid);
		//修改pid
		e.setPid(pid);
		//保存
		employeeDao.update(e);
		//重定向到成员页面
		return "redirect:staff?pid="+pid;
	}
	@RequestMapping("removestaff")
	public String RemoveStaff(int eid) {
		//获取员工对象
		Employee e=employeeDao.queryEmployeeById(eid);
		//暂存当前pid
		int pid=e.getPid();
		//获取默认项目
		Project p=projectDao.GetDefaultProject();
		//修改pid为默认项目
		e.setPid(p.getPid());
		//保存
		employeeDao.update(e);
		//重定向到成员页面
		return "redirect:staff?pid="+pid;
	}
	@RequestMapping("/tofinish")
	public String toFinish() {
		return "finishProject";
	}
	@RequestMapping("/finish")
	public String finishProject(int pid,String etime,HttpSession session) {
		Timestamp time = Timestamp.valueOf(etime);
		Project p=projectDao.queryProjectById(pid);
		p.setEtime(time);p.setFinish(1);
		projectDao.update(p);
		//更新Project
		session.setAttribute("project", p);
		return "redirect:../projectView/index";
	}
	@RequestMapping("/bonus")
	public String CalBonus(int pid) {
		//获取项目对象
		Project p=projectDao.queryProjectById(pid);
		float profit=(float) (p.getProfit()*0.01);  //获取利润1%
		//获取项目参与员工列表
		List<Employee> elist=employeeDao.listAllEmployeesByPid(pid);
		float mb=0,nb=0;  //项目经理与普通员工的奖金
		//只有项目盈利才计算奖金，而且至少有两个员工
		if(profit>0 && elist.size()>1) {
			mb=(float) (profit*0.3);
			nb=(float)(profit*0.7/(elist.size()-1));
			//更新奖金
			for(Employee e:elist) {
				if(e.getType()==0)
					e.setBonus(mb);
				if(e.getType()==1)
					e.setBonus(nb);
				employeeDao.update(e);
			}
		}
		return "redirect:staff?pid="+pid;
	}
}
