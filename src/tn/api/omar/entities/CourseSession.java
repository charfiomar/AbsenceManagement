package tn.api.omar.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import tn.api.omar.entities.embeddable.CourseSessionEmbeddedPK;

@Entity
@Table(name = "CourseSession")
public class CourseSession {

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "pid", column = @Column(name = "pid")),
			@AttributeOverride(name = "gid", column = @Column(name = "gid")),
			@AttributeOverride(name = "crid", column = @Column(name = "crid")),
			@AttributeOverride(name = "sid", column = @Column(name = "sid")) })
	private CourseSessionEmbeddedPK csid;

	@Column(name = "subid")
	private Integer subid;

	public CourseSession() {
	}

	public CourseSession(Integer subid) {
		super();
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
