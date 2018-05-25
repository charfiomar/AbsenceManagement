package tn.api.omar.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;

@Entity
@Table(name = "Session")
public class Session {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sid")
	private Integer sid;

	@Column(name = "startTime")
	private Time startTime;

	@Column(name = "endTime")
	private Time endTime;

	@Column(name = "day")
	private String day;

	public Session() {
	}

	public Session(Integer sid, Time startTime, Time endTime, String day) {
		super();
		this.sid = sid;
		this.startTime = startTime;
		this.endTime = endTime;
		this.day = day;
	}

	public Session(Time startTime, Time endTime, String day) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.day = day;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "Session [sid=" + sid + ", startTime=" + startTime + ", endTime=" + endTime + ", day=" + day + "]";
	}

}