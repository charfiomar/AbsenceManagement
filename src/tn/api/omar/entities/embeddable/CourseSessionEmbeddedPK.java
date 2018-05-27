package tn.api.omar.entities.embeddable;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CourseSessionEmbeddedPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "pid")
	protected Integer pid;
	
	@Column(name = "gid")
	protected Integer gid;
	
	@Column(name = "crid")
	protected Integer crid;
	
	@Column(name = "sid")
	protected Integer sid;
	
	public CourseSessionEmbeddedPK() {
	}

	public CourseSessionEmbeddedPK(Integer pid, Integer gid, Integer crid, Integer sid) {
		super();
		this.pid = pid;
		this.gid = gid;
		this.crid = crid;
		this.sid = sid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Integer getCrid() {
		return crid;
	}

	public void setCrid(Integer crid) {
		this.crid = crid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "CourseSessionEmbeddedPK [pid=" + pid + ", gid=" + gid + ", crid=" + crid + ", sid=" + sid + "]";
	}
	
}
