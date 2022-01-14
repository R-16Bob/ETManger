package dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import model.Customer;
import model.User;

//Dao 数据库操作几乎只需要修改实体类即可
@Repository("userDao")
public class UserDao {
	@Resource
	private SessionFactory sessionFactory; 
	@SuppressWarnings("unchecked")  //忽略unchecked警告
	@Transactional(propagation= Propagation.NEVER)
   public List<User> listAllUsers(){
		String hql="from User";
		List<User> ulist = (List<User>)sessionFactory.getCurrentSession().createQuery(hql).list();
		return ulist;
	}
	@Transactional(propagation= Propagation.REQUIRED)
	public void save(User entity) {
		sessionFactory.getCurrentSession().save(entity);
	}
	 @Transactional(propagation= Propagation.REQUIRED)
	    public void update(User entity){
	    	sessionFactory.getCurrentSession().update(entity);
	    }
	 @Transactional(propagation= Propagation.REQUIRED)
		public User queryUserById(int uid) {  	
			return (User)sessionFactory.getCurrentSession().get(User.class, uid);		
		}
	 @Transactional(propagation= Propagation.REQUIRED)
	    public void delete(int uid){
	    	User u=queryUserById(uid);
	    	sessionFactory.getCurrentSession().delete(u);
	    }
	 //检查登录
	 	public boolean checkLogin(List<User> users,String uname,String upwd) {
			boolean flag=false; 
	 		for(User u:users) {
				if(u.getUname().equals(uname)&&u.getUpwd().equals(upwd))
					flag=true;
			}
	 		return flag;
		}
}
