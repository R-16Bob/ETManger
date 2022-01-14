package model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="event")
public class Event implements Serializable{
	@Id
	@Column(name="id")
	private int id;
	@Column(name="pid")
	private int pid;
	@Column(name="item")
	private String item;
	@Column(name="amount")
	private float amount;
	@Column(name="time")
	private Timestamp time;
	public Event() {
	}
	public Event(int id, int pid, String item, float amount, Timestamp time) {
		this.id = id;
		this.pid = pid;
		this.item = item;
		this.amount = amount;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
}
