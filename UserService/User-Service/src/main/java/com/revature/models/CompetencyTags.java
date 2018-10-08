package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="competency_tagging")
public class CompetencyTags {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ct_id")
	private int ctId;
	private String ct;
	public CompetencyTags() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompetencyTags(int ctId, String ct) {
		super();
		this.ctId = ctId;
		this.ct = ct;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ct == null) ? 0 : ct.hashCode());
		result = prime * result + ctId;
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
		CompetencyTags other = (CompetencyTags) obj;
		if (ct == null) {
			if (other.ct != null)
				return false;
		} else if (!ct.equals(other.ct))
			return false;
		if (ctId != other.ctId)
			return false;
		return true;
	}
	public int getCtId() {
		return ctId;
	}
	public void setCtId(int ctId) {
		this.ctId = ctId;
	}
	public String getCt() {
		return ct;
	}
	public void setCt(String ct) {
		this.ct = ct;
	}
	@Override
	public String toString() {
		return "CompetencyTags [ctId=" + ctId + ", ct=" + ct + "]";
	}
	
	

}
