package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="resource_has_resumes")
public class Resumes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="resource_id")
	private int resourceId;
	private String resume;
	public Resumes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Resumes(int id, int resourceId, String resume) {
		super();
		this.id = id;
		this.resourceId = resourceId;
		this.resume = resume;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + resourceId;
		result = prime * result + ((resume == null) ? 0 : resume.hashCode());
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
		Resumes other = (Resumes) obj;
		if (id != other.id)
			return false;
		if (resourceId != other.resourceId)
			return false;
		if (resume == null) {
			if (other.resume != null)
				return false;
		} else if (!resume.equals(other.resume))
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	@Override
	public String toString() {
		return "Resumes [id=" + id + ", resourceId=" + resourceId + ", resume=" + resume + "]";
	}
	
	
	

}
