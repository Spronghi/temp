package com.smart_museum.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="operator")
public class Operator implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private int id;  
	@Column(name="name")
    private String name;
	@Column(name="surname")
	private String surname;
	@Column(name="is_admin")	
	private boolean isAdmin;
	@Column(name="username")	
	private String username;
	@Column(name="password")	
	private String password;
	@Column(name="email")	
	private String email;
	@ManyToOne
    @JoinColumn(name = "museum_id")
	private Museum museum;
	
	public Operator() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Museum getMuseum() {
		return museum;
	}
	public void setMuseum(Museum museum) {
		this.museum = museum;
	}
	@Override
	public String toString() {
		return "Operator [id=" + id + ", name=" + name + ", surname=" + surname + ", isAdmin=" + isAdmin + ", username="
				+ username + ", password=" + password + ", email=" + email + ", museum=" + museum + "]";
	}
	
}
