package tn.api.omar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Professor")
public class Professor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "pid")
	private Integer pid;

	public Professor(Integer pid, String pfname, String plname, String pmail) {
		super();
		this.pid = pid;
		this.pfname = pfname;
		this.plname = plname;
		this.pmail = pmail;
	}

	@Column(name = "pfname")
	private String pfname;

	@Column(name = "plname")
	private String plname;

	@Column(name = "pmail")
	private String pmail;

	public Professor() {
	}

	public Professor(String pfname, String plname, String pmail) {
		super();
		this.pfname = pfname;
		this.plname = plname;
		this.pmail = pmail;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPfname() {
		return pfname;
	}

	public void setPfname(String pfname) {
		this.pfname = pfname;
	}

	public String getPlname() {
		return plname;
	}

	public void setPlname(String plname) {
		this.plname = plname;
	}

	public String getPmail() {
		return pmail;
	}

	public void setPmail(String pmail) {
		this.pmail = pmail;
	}

	@Override
	public String toString() {
		return "Professor [pid=" + pid + ", pfname=" + pfname + ", plname=" + plname + ", pmail=" + pmail + "]";
	}

	
}
