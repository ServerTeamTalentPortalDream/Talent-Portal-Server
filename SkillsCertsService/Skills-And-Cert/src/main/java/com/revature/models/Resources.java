package com.revature.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="resources")
public class Resources {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="resource_id")
	private int resourceId;
	@Column(name="assoc_id")
	private int associateId;
	@Column(name="aup_cert")
	private boolean aupCert;
	@Column(name="project_id")
	private int projectId;
	@Column(name="competency_tag")
	private String competencyTag;
	private String grade;
	@Column(name="join_date")
	private Date joinDate;
	@Column(name="leave_date")
	private Date leaveDate;
	@Column(name="skill_group_id")
	private int skillGroupId;
	
	@OneToMany(mappedBy = "resourceId")
	private List<Certs> certs;
	
	@OneToMany(mappedBy = "resourceId")
	private List<Skills> skills;
	
	@OneToMany(mappedBy = "resourceId")
	private List<Resumes> resumes;

	public Resources() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Resources(int resourceId, int associateId, boolean aupCert, int projectId, String competencyTag,
			String grade, Date joinDate, Date leaveDate, int skillGroupId, List<Certs> certs, List<Skills> skills,
			List<Resumes> resumes) {
		super();
		this.resourceId = resourceId;
		this.associateId = associateId;
		this.aupCert = aupCert;
		this.projectId = projectId;
		this.competencyTag = competencyTag;
		this.grade = grade;
		this.joinDate = joinDate;
		this.leaveDate = leaveDate;
		this.skillGroupId = skillGroupId;
		this.certs = certs;
		this.skills = skills;
		this.resumes = resumes;
	}

	/**
	 * @return the resourceId
	 */
	public int getResourceId() {
		return resourceId;
	}

	/**
	 * @param resourceId the resourceId to set
	 */
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * @return the associateId
	 */
	public int getAssociateId() {
		return associateId;
	}

	/**
	 * @param associateId the associateId to set
	 */
	public void setAssociateId(int associateId) {
		this.associateId = associateId;
	}

	/**
	 * @return the aupCert
	 */
	public boolean isAupCert() {
		return aupCert;
	}

	/**
	 * @param aupCert the aupCert to set
	 */
	public void setAupCert(boolean aupCert) {
		this.aupCert = aupCert;
	}

	/**
	 * @return the projectId
	 */
	public int getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	/**
	 * @return the competencyTag
	 */
	public String getCompetencyTag() {
		return competencyTag;
	}

	/**
	 * @param competencyTag the competencyTag to set
	 */
	public void setCompetencyTag(String competencyTag) {
		this.competencyTag = competencyTag;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the joinDate
	 */
	public Date getJoinDate() {
		return joinDate;
	}

	/**
	 * @param joinDate the joinDate to set
	 */
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	/**
	 * @return the leaveDate
	 */
	public Date getLeaveDate() {
		return leaveDate;
	}

	/**
	 * @param leaveDate the leaveDate to set
	 */
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	/**
	 * @return the skillGroupId
	 */
	public int getSkillGroupId() {
		return skillGroupId;
	}

	/**
	 * @param skillGroupId the skillGroupId to set
	 */
	public void setSkillGroupId(int skillGroupId) {
		this.skillGroupId = skillGroupId;
	}

	/**
	 * @return the certs
	 */
	public List<Certs> getCerts() {
		return certs;
	}

	/**
	 * @param certs the certs to set
	 */
	public void setCerts(List<Certs> certs) {
		this.certs = certs;
	}

	/**
	 * @return the skills
	 */
	public List<Skills> getSkills() {
		return skills;
	}

	/**
	 * @param skills the skills to set
	 */
	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}

	/**
	 * @return the resumes
	 */
	public List<Resumes> getResumes() {
		return resumes;
	}

	/**
	 * @param resumes the resumes to set
	 */
	public void setResumes(List<Resumes> resumes) {
		this.resumes = resumes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + associateId;
		result = prime * result + (aupCert ? 1231 : 1237);
		result = prime * result + ((certs == null) ? 0 : certs.hashCode());
		result = prime * result + ((competencyTag == null) ? 0 : competencyTag.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((joinDate == null) ? 0 : joinDate.hashCode());
		result = prime * result + ((leaveDate == null) ? 0 : leaveDate.hashCode());
		result = prime * result + projectId;
		result = prime * result + resourceId;
		result = prime * result + ((resumes == null) ? 0 : resumes.hashCode());
		result = prime * result + skillGroupId;
		result = prime * result + ((skills == null) ? 0 : skills.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resources other = (Resources) obj;
		if (associateId != other.associateId)
			return false;
		if (aupCert != other.aupCert)
			return false;
		if (certs == null) {
			if (other.certs != null)
				return false;
		} else if (!certs.equals(other.certs))
			return false;
		if (competencyTag == null) {
			if (other.competencyTag != null)
				return false;
		} else if (!competencyTag.equals(other.competencyTag))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (joinDate == null) {
			if (other.joinDate != null)
				return false;
		} else if (!joinDate.equals(other.joinDate))
			return false;
		if (leaveDate == null) {
			if (other.leaveDate != null)
				return false;
		} else if (!leaveDate.equals(other.leaveDate))
			return false;
		if (projectId != other.projectId)
			return false;
		if (resourceId != other.resourceId)
			return false;
		if (resumes == null) {
			if (other.resumes != null)
				return false;
		} else if (!resumes.equals(other.resumes))
			return false;
		if (skillGroupId != other.skillGroupId)
			return false;
		if (skills == null) {
			if (other.skills != null)
				return false;
		} else if (!skills.equals(other.skills))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Resources [resourceId=" + resourceId + ", associateId=" + associateId + ", aupCert=" + aupCert
				+ ", projectId=" + projectId + ", competencyTag=" + competencyTag + ", grade=" + grade + ", joinDate="
				+ joinDate + ", leaveDate=" + leaveDate + ", skillGroupId=" + skillGroupId + ", certs=" + certs
				+ ", skills=" + skills + ", resumes=" + resumes + "]";
	}
}
