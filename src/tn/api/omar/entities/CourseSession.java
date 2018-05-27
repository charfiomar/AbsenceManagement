package tn.api.omar.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import tn.api.omar.entities.embeddable.CourseSessionEmbeddedPK;

@Entity
@Table(name = "CourseSession")
public class CourseSession {

	@EmbeddedId
	private CourseSessionEmbeddedPK csid;

	@Column(name = "subid")
	private Integer subid;

	public CourseSession() {
	}

	public CourseSession(Integer subid) {
		super();
		this.subid = subid;
	}
	
	public CourseSession(CourseSessionEmbeddedPK pk,Integer subid) {
		super();
		this.csid = pk;
		this.subid = subid;
	}
	
	public CourseSession(Integer pid,Integer gid,Integer crid,Integer sid,Integer subid) {
		super();
		CourseSessionEmbeddedPK pk = new CourseSessionEmbeddedPK(pid, gid, crid, sid);
		this.csid = pk;
		this.subid = subid;
	}

	public CourseSessionEmbeddedPK getCsid() {
		return csid;
	}

	public void setCsid(CourseSessionEmbeddedPK csid) {
		this.csid = csid;
	}

	public Integer getSubid() {
		return subid;
	}

	public void setSubid(Integer subid) {
		this.subid = subid;
	}

	@Override
	public String toString() {
		return "CourseSession [csid=" + csid + ", subid=" + subid + "]";
	}

}
