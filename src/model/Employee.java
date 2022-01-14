package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee implements Serializable{
	@Id
	@Column(name="eid")
	private int eid;
	@Column(name = "name")
	private String name;
	@Column(name="phone")
	private String phone;
	@Column(name="email")
	private String email;
	@Column(name="type")
	private int type;
	@Column(name="pid")
	private int pid;
	@Column(name="bonus")
	private float bonus;
	public Employee() {
	}
	public Employee(int eid, String name, String phone, String email, int type, int pid, float bonus) {
		this.eid = eid;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.type = type;
		this.pid = pid;
		this.bonus = bonus;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public float getBonus() {
		return bonus;
	}
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	
	
}
