package com.simplilearn.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
@SequenceGenerator(name = "course_seq", sequenceName = "course_seq", initialValue = 1000)
public class Course {
	
	@Id
	@GeneratedValue(generator = "course_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "course_id")
	private int id;
	
	private String courseName;
	private String description;
	
	// can take instructor as User object TODO
	private String instructorName;
	private int price;
	private String technology;
	private String tag;
	
	//One course will have multiple Students enrolled
	@JsonManagedReference
	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private  List<Users> enrolledStudents = new ArrayList<Users>();

	
	@OneToMany(mappedBy = "cid" ,cascade = CascadeType.ALL,fetch = FetchType.LAZY,  orphanRemoval = true)
	@JsonIgnore
	private List<Section> section = new ArrayList<>();
	 
	
	public Course() {
		super();
	}

	public Course(int id, String courseName, String description, String instructorName, int price, String technology,
			String tag, List<Users> enrolledStudents) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.description = description;
		this.instructorName = instructorName;
		this.price = price;
		this.technology = technology;
		this.tag = tag;
		this.enrolledStudents = enrolledStudents;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public List<Users> getEnrolledStudents() {
		return enrolledStudents;
	}

	public void setEnrolledStudents(List<Users> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}
	
	

}
