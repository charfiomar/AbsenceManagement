package tn.api.omar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Speciality")
public class Speciality {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="spid")
	private Integer spid;
	
	public Speciality(Integer spid, String spname) {
		super();
		this.spid = spid;
		this.spname = spname;
	}

	@Column(name="spname")
	private String spname;
	
	public Speciality() {
	}
	
	public Speciality(String spname) {
		super();
		this.spname = spname;
	}

	public Integer getSpid() {
		return spid;
	}

	public void setSpid(Integer spid) {
		this.spid = spid;
	}

	public String getSpname() {
		return spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
	}

	@Override
	public String toString() {
		return "Speciality [spid=" + spid + ", spname=" + spname + "]";
	}
	
}
