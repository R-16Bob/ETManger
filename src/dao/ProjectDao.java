package dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Customer;
import model.Project;

@Repository("projectDao")
public class ProjectDao {
	@Resource  
	private SessionFactory sessionFactory; 
	@SuppressWarnings("unchecked")  //忽略unchecked警告
	@Transactional(propagation= Propagation.NEVER)
    public List<Project> listAllProjects(){
		String hql="from Project";
		List<Project> list=(List<Project>)sessionFactory.getCurrentSession().createQuery(hql).list();
		return list;
	}
	@Transactional(propagation= Propagation.REQUIRED)
	public Project queryProjectById(int pid) {
		return (Project)sessionFactory.getCurrentSession().get(Project.class, pid);
	}
    @Transactional(propagation= Propagation.REQUIRED)
    public void save(Project entity){
    	sessionFactory.getCurrentSession().save(entity);
    	}
    @Transactional(propagation= Propagation.REQUIRED)
    public void delete(int pid){
    	Project p=queryProjectById(pid);
    	sessionFactory.getCurrentSession().delete(p);
    }
    @Transactional(propagation= Propagation.REQUIRED)
    public void update(Project entity){
    	sessionFactory.getCurrentSession().update(entity);
    }
    @Transactional(propagation= Propagation.REQUIRED)
    public Project GetDefaultProject(){
		String hql="from Project";
		List<Project> list=(List<Project>)sessionFactory.getCurrentSession().createQuery(hql).list();
		return list.get(0);
	}
}
