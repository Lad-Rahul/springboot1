package com.springboot1.response;

import com.springboot1.entity.Subject;

public class SubjectResponse {
	
	private Long id;
	
	private String subjectName;
	
	private Double marksObtained;

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

	public SubjectResponse(Long id, String subjectName, Double marksObtained) {
		super();
		this.id = id;
		this.subjectName = subjectName;
		this.marksObtained = marksObtained;
	}

	public SubjectResponse(Subject subject) {
		this.id = subject.getId();
		this.subjectName = subject.getSubjectName();
		this.marksObtained = subject.getMarksObtained();
	}

	@Override
	public String toString() {
		return "SubjectResponse [id=" + id + ", subjectName=" + subjectName + ", marksObtained=" + marksObtained + "]";
	}
	
}
