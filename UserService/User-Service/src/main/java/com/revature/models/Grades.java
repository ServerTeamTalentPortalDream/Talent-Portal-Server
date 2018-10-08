package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grade")
public class Grades {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="grade_id")
	private int gradeId;
	private String grade;
	public Grades() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Grades(int gradeId, String grade) {
		super();
		this.gradeId = gradeId;
		this.grade = grade;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + gradeId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grades other = (Grades) obj;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (gradeId != other.gradeId)
			return false;
		return true;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Grades [gradeId=" + gradeId + ", grade=" + grade + "]";
	}
	
	

}
