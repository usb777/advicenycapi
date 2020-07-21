package com.advicenyc.springbootcrudrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.advicenyc.springbootcrudrest.model.Role;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Users 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "id")
    private int id;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	/*
	@Column(name = "role")
    private int role;
	*/

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="role")
	private Role role;
	
	public Users()
	{
		super();
	}
	
	public Users(int id, String fullname, String email, String username, String password, Role role)
	{super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
		
	}
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
/*
	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
*/
	public Role getRole() {
		return role;
	}

	public void setRole(Role role1) {
		this.role = role1;
	}
	

}
