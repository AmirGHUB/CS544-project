package edu.miu.cs544.team6.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private User userId;
	
	private String userRole;
	
//	public UserRole(User userId, String userRole) {
//		this.userId = userId;
//		this.userRole = userRole;
//	}
	
	public UserRole() {}

	public int getId() {
		return id;
	}


	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	


}
