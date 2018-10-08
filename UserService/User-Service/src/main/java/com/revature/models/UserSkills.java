package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_has_skills")
public class UserSkills {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="assoc_id")
	private int associateId;
	@Column(name="skill_id")
	private int skillId;
	public UserSkills() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserSkills(int id, int associateId, int skillId) {
		super();
		this.id = id;
		this.associateId = associateId;
		this.skillId = skillId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + associateId;
		result = prime * result + id;
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
		UserSkills other = (UserSkills) obj;
		if (associateId != other.associateId)
			return false;
		if (id != other.id)
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
	public int getAssociateId() {
		return associateId;
	}
	public void setAssociateId(int associateId) {
		this.associateId = associateId;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	@Override
	public String toString() {
		return "UserSkills [id=" + id + ", associateId=" + associateId + ", skillId=" + skillId + "]";
	}
	
	

}
