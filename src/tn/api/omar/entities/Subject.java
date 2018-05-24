package tn.api.omar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Subject")
public class Subject {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="subid")
	private Integer subid;
	
	@Column(name="subname")
	private String subname;
	
	public Subject() {
	}
	
	public Subject(String subname) {
		super();
		this.subname = subname;
	}

	public Subject(Integer subid, String subname) {
		super();
		this.subid = subid;
		this.subname = subname;
	}

	public Integer getSubid() {
		return subid;
	}

	public void setSubid(Integer subid) {
		this.subid = subid;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	@Override
	public String toString() {
		return "Subject [subid=" + subid + ", subname=" + subname + "]";
	}
}
