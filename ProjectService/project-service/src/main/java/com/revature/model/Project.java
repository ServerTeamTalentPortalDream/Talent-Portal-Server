package com.revature.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
@Table(name="project")
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="project_id")
	private int projectId;
	private String competency;
	private String customer;
	@Column(name="project_name")
	private String projectName;
	@Column(name="start_date")
	private java.sql.Date startDate;
	@Column(name="end_date")
	private java.sql.Date endDate;
	private String details;
	private String supervisor;
	@Column(name="supervisor_id")
	private int supervisorId;
	@Column(name="project_location")
	private String projectLocation;
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(int projectId, String competency, String customer, String projectName, Date startDate, Date endDate,
			String details, String supervisor, int supervisorId, String projectLocation) {
		super();
		this.projectId = projectId;
		this.competency = competency;
		this.customer = customer;
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.details = details;
		this.supervisor = supervisor;
		this.supervisorId = supervisorId;
		this.projectLocation = projectLocation;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getCompetency() {
		return competency;
	}
	public void setCompetency(String competency) {
		this.competency = competency;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public java.sql.Date getStartDate() {
		return startDate;
	}
	public void setStartDate(java.sql.Date startDate) {
		this.startDate = startDate;
	}
	public java.sql.Date getEndDate() {
		return endDate;
	}
	public void setEndDate(java.sql.Date endDate) {
		this.endDate = endDate;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public int getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}
	public String getProjectLocation() {
		return projectLocation;
	}
	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((competency == null) ? 0 : competency.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + projectId;
		result = prime * result + ((projectLocation == null) ? 0 : projectLocation.hashCode());
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((supervisor == null) ? 0 : supervisor.hashCode());
		result = prime * result + supervisorId;
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
		Project other = (Project) obj;
		if (competency == null) {
			if (other.competency != null)
				return false;
		} else if (!competency.equals(other.competency))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (projectId != other.projectId)
			return false;
		if (projectLocation == null) {
			if (other.projectLocation != null)
				return false;
		} else if (!projectLocation.equals(other.projectLocation))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (supervisor == null) {
			if (other.supervisor != null)
				return false;
		} else if (!supervisor.equals(other.supervisor))
			return false;
		if (supervisorId != other.supervisorId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", competency=" + competency + ", customer=" + customer
				+ ", projectName=" + projectName + ", startDate=" + startDate + ", endDate=" + endDate + ", details="
				+ details + ", supervisor=" + supervisor + ", supervisorId=" + supervisorId + ", projectLocation="
				+ projectLocation + "]";
	}

	
}
