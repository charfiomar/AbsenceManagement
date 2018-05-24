package tn.api.omar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Classroom")
public class Classroom {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "crid")
	private Integer crid;

	public Classroom(Integer crid, String crname) {
		super();
		this.crid = crid;
		this.crname = crname;
	}

	@Column(name = "crname")
	private String crname;
	
	public Classroom() {
	}
	
	public Classroom(String crname) {
		super();
		this.crname = crname;
	}

	public Integer getCrid() {
		return crid;
	}

	public void setCrid(Integer crid) {
		this.crid = crid;
	}

	public String getCrname() {
		return crname;
	}

	public void setCrname(String crname) {
		this.crname = crname;
	}
	
	@Override
	public String toString() {
		return "Classroom [crid=" + crid + ", crname=" + crname + "]";
	}

}
