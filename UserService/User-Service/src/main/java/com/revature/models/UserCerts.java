package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_has_certs")
public class UserCerts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="assoc_id")
	private int associateId;
	@Column(name="cert_id")
	private int certId;
	public UserCerts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserCerts(int id, int associateId, int certId) {
		super();
		this.id = id;
		this.associateId = associateId;
		this.certId = certId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + associateId;
		result = prime * result + certId;
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
		UserCerts other = (UserCerts) obj;
		if (associateId != other.associateId)
			return false;
		if (certId != other.certId)
			return false;
		if (id != other.id)
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
	public int getCertId() {
		return certId;
	}
	public void setCertId(int certId) {
		this.certId = certId;
	}
	@Override
	public String toString() {
		return "UserCerts [id=" + id + ", associateId=" + associateId + ", certId=" + certId + "]";
	}
	
	

}
