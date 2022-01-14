package controller;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.EventDao;
import model.Customer;
import model.Event;
import model.Project;;

@Controller
@RequestMapping("/event")
public class EventController {
	@Autowired
	EventDao eventDao;
	@RequestMapping("/index")
	public String index(int pid,ModelMap map) {
		List<Event> events = eventDao.listAllCustomersByPid(pid);
		map.put("elist",events);
		return "events";
	}
	@RequestMapping("/toadd")
	public String toAdd() {
		return "addEvent";
	}
	@RequestMapping("/add")
	public String addEvent(String item,int pid,float amount,String time,HttpSession session) {
		System.out.println("time"+time);
		Timestamp t=Timestamp.valueOf(time);
		System.out.println("time: "+t);
		Event e=new Event();
		e.setItem(item);e.setPid(pid);
		e.setAmount(amount);e.setTime(t);
		eventDao.save(e);
		Project project=(Project) session.getAttribute("project");
		return "redirect:index?pid="+project.getPid();
	}
	@RequestMapping("/delete")
	public String deleteEventrByID(int id,HttpSession session){
		eventDao.delete(id);
		Project project=(Project) session.getAttribute("project");
		return "redirect:index?pid="+project.getPid();
	}
	@RequestMapping("/edit")
	public String editEventByID(int id,ModelMap map){
		Event e=eventDao.queryEventById(id);
		map.put("event", e);
		return "editEvent";
	}
	@RequestMapping("/update")
	public String updateCustomer(int id,String item,String time,int pid,float amount,HttpSession session){
		Timestamp timestamp=Timestamp.valueOf(time);
		Event e=new Event(id, pid, item, amount, timestamp);
		eventDao.update(e);
		Project project=(Project) session.getAttribute("project");
		return "redirect:index?pid="+project.getPid();
	}
}
