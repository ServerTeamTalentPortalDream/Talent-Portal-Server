package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "certification")
public class Certifications {

	@Id
	@Column(name ="cert_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "cert_name")
	private String certificationName;

	public Certifications() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Certifications(int id, String certificationName) {
		super();
		this.id = id;
		this.certificationName = certificationName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCertificationName() {
		return certificationName;
	}

	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((certificationName == null) ? 0 : certificationName.hashCode());
		result = prime * result + id;
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
		Certifications other = (Certifications) obj;
		if (certificationName == null) {
			if (other.certificationName != null)
				return false;
		} else if (!certificationName.equals(other.certificationName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Certifications [id=" + id + ", certificationName=" + certificationName + "]";
	}
	
}
