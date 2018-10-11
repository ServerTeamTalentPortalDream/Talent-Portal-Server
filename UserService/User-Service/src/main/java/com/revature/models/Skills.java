package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="resource_has_skills")
public class Skills {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="resource_id")
	private int resourceId;
	@Column(name="skill_id")
	private int skillId;
	public Skills() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Skills(int id, int resourceId, int skillId) {
		super();
		this.id = id;
		this.resourceId = resourceId;
		this.skillId = skillId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + resourceId;
		result = prime * result + skillId;
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
		Skills other = (Skills) obj;
		if (id != other.id)
			return false;
		if (resourceId != other.resourceId)
			return false;
		if (skillId != other.skillId)
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
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	@Override
	public String toString() {
		return "Skills [id=" + id + ", resourceId=" + resourceId + ", skillId=" + skillId + "]";
	}
	
	
	

}
