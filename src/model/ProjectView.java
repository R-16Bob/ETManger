package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="projectView")
public class ProjectView implements Serializable{
	@Id
	@Column(name="pid")
	private int pid;
	@Column(name="pname")
	private String pname;
	@Column(name="cid")
	private int cid;
	@Column(name="cname")
	private String cname;
	@Column(name="finish")
	private int finish;
	public ProjectView() {
	}
	public ProjectView(int pid, String pname, int cid, String cname, int finish) {
		this.pid = pid;
		this.pname = pname;
		this.cid = cid;
		this.cname = cname;
		this.finish = finish;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
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
	public int getFinish() {
		return finish;
	}
	public void setFinish(int finish) {
		this.finish = finish;
	}
	
}
