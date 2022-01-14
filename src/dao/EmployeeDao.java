package dao;



import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import model.Employee;
import java.util.List;
import javax.annotation.Resource;

@Repository("employeeDao")
public class EmployeeDao{
	@Resource  
	private SessionFactory sessionFactory; 
	@SuppressWarnings("unchecked")  //忽略unchecked警告
	@Transactional(propagation= Propagation.NEVER)
    public List<Employee> listAllEmployees(){
        String hql="from Employee";     
        List<Employee> list = (List<Employee>)sessionFactory.getCurrentSession().createQuery(hql).list();     
        return list;
     } 
    @Transactional(propagation= Propagation.REQUIRED)
    public void save(Employee entity){
    	sessionFactory.getCurrentSession().save(entity);
    	}
    @Transactional(propagation= Propagation.REQUIRED)
    public void delete(int eid){
    	Employee e=queryEmployeeById(eid);
    	sessionFactory.getCurrentSession().delete(e);
    }
    @Transactional(propagation= Propagation.REQUIRED)
    public void update(Employee entity){
    	sessionFactory.getCurrentSession().update(entity);
    }
    @Transactional(propagation= Propagation.REQUIRED)
	public Employee queryEmployeeById(int eid) {  	
		return (Employee)sessionFactory.getCurrentSession().get(Employee.class, eid);		
	}
    @Transactional(propagation= Propagation.REQUIRED)
    public List<Employee> listAllEmployeesByPid(int pid){
        String hql="from Employee e where e.pid=?";
        List<Employee> list=(List<Employee>)sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, pid).list();   
        return list;
     }
    @Transactional(propagation= Propagation.REQUIRED)
    public List<Employee> listNotStaffByPid(int pid){
        String hql="from Employee e where e.pid!=?";
        List<Employee> list=(List<Employee>)sessionFactory.getCurrentSession().createQuery(hql).setParameter(0, pid).list();   
        return list;
     }
}

