package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{
	@Id
	@Column(name="uid")
	private int uid;
	@Column(name="uname")
	private String uname;
	@Column(name="upwd")
	private String upwd;
	@Column(name="eid")
	private int eid;
	public User() {
	}
	
	public User(int uid, String uname, String upwd, int eid) {
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.eid = eid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	
	
}
