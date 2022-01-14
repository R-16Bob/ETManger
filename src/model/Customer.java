package model;

import javax.persistence.*;
import java.io.Serializable;
 
@Entity
@Table(name="customer")
public class Customer implements Serializable {
	@Id
    @Column(name="cid")
    private int cid;
    @Column(name="cname")
    private String cname;
    @Column(name="phone")
    private String phone;
    @Column(name="email")
    private String email;
	public Customer() {
	}
	public Customer(int cid, String cname, String phone, String email) {
		this.cid = cid;
		this.cname = cname;
		this.phone = phone;
		this.email = email;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
}
