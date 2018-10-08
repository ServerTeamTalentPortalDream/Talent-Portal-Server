package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_table")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="assoc_id")
	private int associateId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	private String email;
	private String pass;
	@Column(name="user_role")
	private int role;
	@Column(name="user_id")
	private int userId;
	
	@OneToMany(mappedBy = "associateId")
	private List<Resources> resources;
	
	@OneToMany(mappedBy = "associateId")
	private List<UserSkills> userSkills;
	
	@OneToMany(mappedBy = "associateId")
	private List<UserCerts> userCerts;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int associateId, String firstName, String lastName, String email, String pass, int role, int userId,
			List<Resources> resources, List<UserSkills> userSkills, List<UserCerts> userCerts) {
		super();
		this.associateId = associateId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.pass = pass;
		this.role = role;
		this.userId = userId;
		this.resources = resources;
		this.userSkills = userSkills;
		this.userCerts = userCerts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + associateId;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((resources == null) ? 0 : resources.hashCode());
		result = prime * result + role;
		result = prime * result + ((userCerts == null) ? 0 : userCerts.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userSkills == null) ? 0 : userSkills.hashCode());
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
		User other = (User) obj;
		if (associateId != other.associateId)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (resources == null) {
			if (other.resources != null)
				return false;
		} else if (!resources.equals(other.resources))
			return false;
		if (role != other.role)
			return false;
		if (userCerts == null) {
			if (other.userCerts != null)
				return false;
		} else if (!userCerts.equals(other.userCerts))
			return false;
		if (userId != other.userId)
			return false;
		if (userSkills == null) {
			if (other.userSkills != null)
				return false;
		} else if (!userSkills.equals(other.userSkills))
			return false;
		return true;
	}

	public int getAssociateId() {
		return associateId;
	}

	public void setAssociateId(int associateId) {
		this.associateId = associateId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Resources> getResources() {
		return resources;
	}

	public void setResources(List<Resources> resources) {
		this.resources = resources;
	}

	public List<UserSkills> getUserSkills() {
		return userSkills;
	}

	public void setUserSkills(List<UserSkills> userSkills) {
		this.userSkills = userSkills;
	}

	public List<UserCerts> getUserCerts() {
		return userCerts;
	}

	public void setUserCerts(List<UserCerts> userCerts) {
		this.userCerts = userCerts;
	}

	@Override
	public String toString() {
		return "User [associateId=" + associateId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", pass=" + pass + ", role=" + role + ", userId=" + userId + ", resources=" + resources
				+ ", userSkills=" + userSkills + ", userCerts=" + userCerts + "]";
	}

	
	
}
