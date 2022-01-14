package model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project implements Serializable{
	@Id
	@Column(name="pid")
	private int pid;
	@Column(name="cid")
	private int cid;
	@Column(name="pname")
	private String pname;
	@Column(name="btime")
	private Timestamp btime;
	@Column(name="etime")
	private Timestamp etime;
	@Column(name="finish")
	private int finish;
	@Column(name="profit")
	private float profit;
	@Column(name="prate")
	private float prate;
	public Project() {
	}
	public Project(int pid, int cid, String pname, Timestamp btime, Timestamp etime, int finish, float profit,
			float prate) {
		this.pid = pid;
		this.cid = cid;
		this.pname = pname;
		this.btime = btime;
		this.etime = etime;
		this.finish = finish;
		this.profit = profit;
		this.prate = prate;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Timestamp getBtime() {
		return btime;
	}
	public void setBtime(Timestamp btime) {
		this.btime = btime;
	}
	public Timestamp getEtime() {
		return etime;
	}
	public void setEtime(Timestamp etime) {
		this.etime = etime;
	}
	public int getFinish() {
		return finish;
	}
	public void setFinish(int finish) {
		this.finish = finish;
	}
	public float getProfit() {
		return profit;
	}
	public void setProfit(float profit) {
		this.profit = profit;
	}
	public float getPrate() {
		return prate;
	}
	public void setPrate(float prate) {
		this.prate = prate;
	}
	
}
