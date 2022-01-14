package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.CustomerDao;
import dao.ProjectViewDao;
import model.Customer;
import model.ProjectView;

@Controller
@RequestMapping("/projectView")
public class ProjectViewController {
	@Autowired
	ProjectViewDao projectViewDao;
	@RequestMapping("/index")
	public String index(ModelMap map) {
		map.get("uname");
		List<ProjectView> projectViews = projectViewDao.listAllProjectViews();
		map.put("pvlist",projectViews);
		return "index";
	}
}
