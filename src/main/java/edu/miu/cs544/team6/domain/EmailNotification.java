package edu.miu.cs544.team6.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EMAIL_NOTIFICATION")
public class EmailNotification {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(name = "appointment_id")
	private Integer appointmentId;

	private String subject;

	private String content;

	private String status;

	@Temporal(TemporalType.DATE)
	@Column(name = "created_datetime")
	private Date createdDatetime;

	@Temporal(TemporalType.DATE)
	@Column(name = "modified_datetime")
	private Date modifiedDatetime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public Date getModifiedDatetime() {
		return modifiedDatetime;
	}

	public void setModifiedDatetime(Date modifiedDatetime) {
		this.modifiedDatetime = modifiedDatetime;
	}

	@Override
	public String toString() {
		return "id: " + id + " appointmentId: " + appointmentId + " subject: " + subject + " content: " + content
				+ " status: " + status;
	}
}
