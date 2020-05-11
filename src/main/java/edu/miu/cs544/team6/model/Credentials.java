package com.cs5446.tm.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;


@Entity(name = "credentials")
public class Credentials {

	 @Size(min = 4, max = 40, message = "{default.size}")
	 @Id
	 @Column(name = "username", nullable = false, unique = true, length = 150)
     String username;
	 @Size(min = 4,max = 254,message = "{default.size}")
	 @Column(name = "PASSWORD", nullable = false)
     String password;

	 @Size(min = 4,max = 254,message = "{default.size}")
	 @Column(name = "VERIFYPASSWORD", nullable = false)
     String verifyPassword;


	 Boolean enabled;

     @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
     @JoinColumn(name="username", referencedColumnName= "username")
     List<Authority> authority;
	
  	 public String getUsername() {
		return username;
	}
	 public void setUsername(String username) {
		this.username = username;
	}
	 public String getPassword() {
		return password;
	}
	 public void setPassword(String password) {
		this.password = password;
	}
	 public String getVerifyPassword() {
		return verifyPassword;
	}
	 public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}
	 public Boolean getEnabled() {
		return enabled;
	}
	 public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	 public List<Authority> getAuthority() {
		return authority;
	}
	 public void setAuthority(List<Authority> authority) {
		this.authority = authority;
	}
	
}
