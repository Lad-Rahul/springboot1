package com.springboot1.request;

public class CreateSubjectRequest {
	
	private String subjectName;
	
	private Double marksObtained;

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

	public CreateSubjectRequest(String subjectName, Double marksObtained) {
		super();
		this.subjectName = subjectName;
		this.marksObtained = marksObtained;
	}

}
