package dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import model.Event;

@Repository("eventDao")
public class EventDao {
	@Resource  
	private SessionFactory sessionFactory; 
	@SuppressWarnings("unchecked")  //忽略unchecked警告
	@Transactional(propagation= Propagation.NEVER)
	 public List<Event> listAllCustomersByPid(int pid){
        String hql="from Event e where e.pid=?";     
        List<Event> list = (List<Event>)sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, pid).list();     
        return list;
     }
    @Transactional(propagation= Propagation.REQUIRED)
    public void save(Event entity){
    	sessionFactory.getCurrentSession().save(entity);
    	}
    @Transactional(propagation= Propagation.REQUIRED)
    public void delete(int id){
    	Event e=queryEventById(id);
    	sessionFactory.getCurrentSession().delete(e);
    }
    @Transactional(propagation= Propagation.REQUIRED)
    public void update(Event entity){
    	sessionFactory.getCurrentSession().update(entity);
    }
    @Transactional(propagation= Propagation.REQUIRED)
	public Event queryEventById(int id) {  	
		return (Event)sessionFactory.getCurrentSession().get(Event.class, id);		
	}
}
