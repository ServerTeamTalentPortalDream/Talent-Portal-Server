package com.revature.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
	@JoinColumn(name="ct_id")
	private CompetencyTags competencyTags;
	@ManyToOne
	@JoinColumn(name="grade_id")
	private Grades grades;
	
	@Column(name="join_date")
	private Date joinDate;
	@Column(name="leave_date")
	private Date leaveDate;
	
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

	public Resources(int resourceId, int associateId, boolean aupCert, int projectId, CompetencyTags competencyTags,
			Grades grades, Date joinDate, Date leaveDate, List<Certs> certs, List<Skills> skills,
			List<Resumes> resumes) {
		super();
		this.resourceId = resourceId;
		this.associateId = associateId;
		this.aupCert = aupCert;
		this.projectId = projectId;
		this.competencyTags = competencyTags;
		this.grades = grades;
		this.joinDate = joinDate;
		this.leaveDate = leaveDate;
		this.certs = certs;
		this.skills = skills;
		this.resumes = resumes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + associateId;
		result = prime * result + (aupCert ? 1231 : 1237);
		result = prime * result + ((certs == null) ? 0 : certs.hashCode());
		result = prime * result + ((competencyTags == null) ? 0 : competencyTags.hashCode());
		result = prime * result + ((grades == null) ? 0 : grades.hashCode());
		result = prime * result + ((joinDate == null) ? 0 : joinDate.hashCode());
		result = prime * result + ((leaveDate == null) ? 0 : leaveDate.hashCode());
		result = prime * result + projectId;
		result = prime * result + resourceId;
		result = prime * result + ((resumes == null) ? 0 : resumes.hashCode());
		result = prime * result + ((skills == null) ? 0 : skills.hashCode());
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
		if (competencyTags == null) {
			if (other.competencyTags != null)
				return false;
		} else if (!competencyTags.equals(other.competencyTags))
			return false;
		if (grades == null) {
			if (other.grades != null)
				return false;
		} else if (!grades.equals(other.grades))
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
		if (skills == null) {
			if (other.skills != null)
				return false;
		} else if (!skills.equals(other.skills))
			return false;
		return true;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public int getAssociateId() {
		return associateId;
	}

	public void setAssociateId(int associateId) {
		this.associateId = associateId;
	}

	public boolean isAupCert() {
		return aupCert;
	}

	public void setAupCert(boolean aupCert) {
		this.aupCert = aupCert;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public CompetencyTags getCompetencyTags() {
		return competencyTags;
	}

	public void setCompetencyTags(CompetencyTags competencyTags) {
		this.competencyTags = competencyTags;
	}

	public Grades getGrades() {
		return grades;
	}

	public void setGrades(Grades grades) {
		this.grades = grades;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}

	public List<Certs> getCerts() {
		return certs;
	}

	public void setCerts(List<Certs> certs) {
		this.certs = certs;
	}

	public List<Skills> getSkills() {
		return skills;
	}

	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}

	public List<Resumes> getResumes() {
		return resumes;
	}

	public void setResumes(List<Resumes> resumes) {
		this.resumes = resumes;
	}

	@Override
	public String toString() {
		return "Resources [resourceId=" + resourceId + ", associateId=" + associateId + ", aupCert=" + aupCert
				+ ", projectId=" + projectId + ", competencyTags=" + competencyTags + ", grades=" + grades
				+ ", joinDate=" + joinDate + ", leaveDate=" + leaveDate + ", certs=" + certs + ", skills=" + skills
				+ ", resumes=" + resumes + "]";
	}

}
