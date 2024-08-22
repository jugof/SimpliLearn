package com.simplilearn.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", initialValue = 1)
public class Users {
	
	@Id
	@GeneratedValue(generator = "user_seq", strategy = GenerationType.SEQUENCE)
	private int id;
	private String username;
	private String password;
	
	private String name;
	
	private String email;
	
//	0-> student, 1-> admin
	private int isAdmin;
	
	// Student, Admin, Instructor
	private String accountType;
	
	@ManyToOne
    @JoinColumn(name = "course_id")
	@JsonBackReference // This annotation indicates the back part of the reference
    private Course course;
	
	public Users() {
		super();
	}
	
	public Users(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	

	public Users(int id, String username, String password, String name, String email, int isAdmin, String accountType,
			Course course) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.isAdmin = isAdmin;
		this.accountType = accountType;
		this.course = course;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", email="
				+ email + ", isAdmin=" + isAdmin + ", accountType=" + accountType + ", course=" + course + "]";
	}
	
}
