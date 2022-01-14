package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.ProjectDao;
import dao.UserDao;
import model.Project;
import model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserDao userDao;
	@Autowired
	ProjectDao projectDao;
	//index 从数据库中查找用户表，并显示在users.jsp
	@RequestMapping("/index")
	public String index(ModelMap map) {
		List<User> users = userDao.listAllUsers();
		map.put("ulist",users);
		return "users";
	}
	//toadd和add是搭配的,toadd访问WEB-INF中不能直接访问的addUser.jsp，
	//add则是将addUser.jsp中填的信息插入到数据库中，并重定向到index
	@RequestMapping("/toadd")
	public String toAdd() {
		return "addUser";
	}
	@RequestMapping("/register")
	public String addUser(String uname,String upwd,int eid) {
		//更多检查略
		User u=new User();
		u.setUname(uname);u.setUpwd(upwd);u.setEid(eid);
		userDao.save(u);
		return "redirect:login";
	}
	//edit是和update搭配的，edit是根据id得到用户信息，并显示到editUser.jsp
	//update则是提交在editUser.jsp修改的信息并重定向到index
	@RequestMapping("edit")
	public String editUserByID(int uid,ModelMap map) {
		User user=userDao.queryUserById(uid);
		map.put("user",user);
		return "editUser";
	}
	@RequestMapping("/update")
	public String updateUser(int uid,String uname,String upwd,int eid,ModelMap map) {
		User u=new User(uid, uname, upwd, eid);
		userDao.update(u);
		return "redirect:index";
	}
	//删除，获取uid可以直接调用dao删除
	@RequestMapping("/delete")
	public String deleteUserByID(int uid) {
		userDao.delete(uid);
		return "redirect:index";
	}
	@RequestMapping("/login")
	public String Login(HttpSession session,String uname,String upwd,ModelMap map) {
		List<User> users = userDao.listAllUsers();
		//检查登录
		boolean match = userDao.checkLogin(users, uname, upwd);
		if (match) {  //登录成功，进入主页
			map.put("uname", uname);
			session.setAttribute("uname",uname);
			//设置默认项目
			Project project=projectDao.GetDefaultProject();
			session.setAttribute("project",project);
			return "redirect:../projectView/index";
		}
		else {  //登录失败，回到login并显示错误
			map.put("lerror", "用户名或密码错误");
			return "login";
		}
	}
	@RequestMapping("/toregister")
	public String toRegister() {
		return "register";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("uname");
		return "login";
	}
}
