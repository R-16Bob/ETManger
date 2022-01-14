package dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import model.ProjectView;

@Repository("projectViewDao")
public class ProjectViewDao {
	@Resource
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")  //忽略unchecked警告
	@Transactional(propagation= Propagation.NEVER)
    public List<ProjectView> listAllProjectViews(){
		String hql="from ProjectView";
		List<ProjectView> list=(List<ProjectView>)sessionFactory.getCurrentSession().createQuery(hql).list();
		return list;
	}
}
