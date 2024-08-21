package com.simplilearn.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "section")
@SequenceGenerator(name = "section_seq", sequenceName = "section_seq", initialValue = 2000)
public class Section {

	@Id
	@GeneratedValue(generator = "section_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "section_id")
	private int id;
	
	private String sectionName;
	
	private String title;
	private String timeDuration;
	private String description;
	
	@Column(name = "url")
	private String videoUrl;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	@JsonIgnore
	private Course cid;

	public Section() {
		super();
	}

	public Section(int id, String sectionName, String title, String timeDuration, String description, String videoUrl,
			Course cid) {
		super();
		this.id = id;
		this.sectionName = sectionName;
		this.title = title;
		this.timeDuration = timeDuration;
		this.description = description;
		this.videoUrl = videoUrl;
		this.cid = cid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTimeDuration() {
		return timeDuration;
	}

	public void setTimeDuration(String timeDuration) {
		this.timeDuration = timeDuration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public Course getCid() {
		return cid;
	}

	public void setCid(Course cid) {
		this.cid = cid;
	}
	
	
}
