package edu.miu.cs544.team6.dto;



public class UserRoleDTO {
	
	
	private int id;
	
	private UserDTO userId;
	
	private String userRole;
	
	public UserRoleDTO(UserDTO userId, String userRole) {
		this.userId = userId;
		this.userRole = userRole;
	}
	
	public UserRoleDTO() {}

	public int getId() {
		return id;
	}


	public UserDTO getUserId() {
		return userId;
	}

	public void setUserId(UserDTO userId) {
		this.userId = userId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	


}
