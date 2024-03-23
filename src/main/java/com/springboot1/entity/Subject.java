package com.springboot1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "subject")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "subject_name")
	private String subjectName;
	
	@Column(name = "marks_obtained")
	private Double marksObtained;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Double getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(Double marksObtained) {
		this.marksObtained = marksObtained;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Subject() {
		super();
	}

	public Subject(Long id, String subjectName, Double marksObtained, Student student) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.marksObtained = marksObtained;
		this.student = student;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", subjectName=" + subjectName + ", marksObtained=" + marksObtained + ", student="
				+ student + "]";
	}
	
}
