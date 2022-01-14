package dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import model.Customer;
import java.util.List;
import javax.annotation.Resource;

@Repository("customerDao")
public class CustomerDao{
	@Resource  
	private SessionFactory sessionFactory; 
	@SuppressWarnings("unchecked")  //忽略unchecked警告
	@Transactional(propagation= Propagation.NEVER)
    public List<Customer> listAllCustomers(){
        String hql="from Customer";     
        List<Customer> list = (List<Customer>)sessionFactory.getCurrentSession().createQuery(hql).list();     
        return list;
     } 
    @Transactional(propagation= Propagation.REQUIRED)
    public void save(Customer entity){
    	sessionFactory.getCurrentSession().save(entity);
    	}
    @Transactional(propagation= Propagation.REQUIRED)
    public void delete(int cid){
    	Customer c=queryCustomerById(cid);
    	sessionFactory.getCurrentSession().delete(c);
    }
    @Transactional(propagation= Propagation.REQUIRED)
    public void update(Customer entity){
    	sessionFactory.getCurrentSession().update(entity);
    }
    @Transactional(propagation= Propagation.REQUIRED)
	public Customer queryCustomerById(int cid) {  	
		return (Customer)sessionFactory.getCurrentSession().get(Customer.class, cid);		
	}
}
