package com.in.cafe.POJO;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@NamedQuery(name= "User.findByEmailId", query= "select u from User u where u.email= :email")

@NamedQuery(name= "User.getAllUser", query= "select new com.in.cafe.wrapper.UserWrapper(u.id,u.name,u.contactNumber,u.email,u.status) from User u where u.role= 'user'")

@NamedQuery(name= "User.updateStatus", query= "update User u set u.status= :status where u.id= :id")

@NamedQuery(name= "User.getAllAdmin", query= "select u.email from User u where u.role= 'admin'")

@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name= "user")
public class User implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String contactNumber;
	private String email;
	private String password;
	private String status;
	private String role;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setStaus(String string) {
		// TODO Auto-generated method stub

	}


}
