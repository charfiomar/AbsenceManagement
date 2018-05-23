package tn.api.omar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Groups")
public class Groups {

	@Id
	@Column(name="gid")
	private Integer gid;
	
	@Column(name="gnumber")
	private Integer gnumber;
	
	@Column(name="gyear")
	private Integer gyear;
	
	@Column(name="gmail")
	private String gmail;
	
	@Column(name="spid")
	private Integer spid;
	
	public Groups() {
	}
	
	public Groups(Integer gnumber, Integer gyear, String gmail, Integer spid) {
		super();
		this.gnumber = gnumber;
		this.gyear = gyear;
		this.gmail = gmail;
		this.spid = spid;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Integer getGnumber() {
		return gnumber;
	}

	public void setGnumber(Integer gnumber) {
		this.gnumber = gnumber;
	}

	public Integer getGyear() {
		return gyear;
	}

	public void setGyear(Integer gyear) {
		this.gyear = gyear;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public Integer getSpid() {
		return spid;
	}

	public void setSpid(Integer spid) {
		this.spid = spid;
	}
	
	@Override
	public String toString() {
		return "Groups [gid=" + gid + ", gnumber=" + gnumber + ", gyear=" + gyear + ", gmail=" + gmail + ", spid="
				+ spid + "]";
	}
	
}
