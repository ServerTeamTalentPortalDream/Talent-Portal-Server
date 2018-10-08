package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="resource_has_certs")
public class Certs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="resource_id")
	private int resourceId;
	@Column(name="cert_id")
	private int certId;
	public Certs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Certs(int id, int resourceId, int certId) {
		super();
		this.id = id;
		this.resourceId = resourceId;
		this.certId = certId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + certId;
		result = prime * result + id;
		result = prime * result + resourceId;
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
		Certs other = (Certs) obj;
		if (certId != other.certId)
			return false;
		if (id != other.id)
			return false;
		if (resourceId != other.resourceId)
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
	public int getCertId() {
		return certId;
	}
	public void setCertId(int certId) {
		this.certId = certId;
	}
	@Override
	public String toString() {
		return "Certs [id=" + id + ", resourceId=" + resourceId + ", certId=" + certId + "]";
	}
	
	
	

}
