package com.revature.dto;

public class ResourcesCred {
	private int skillId;
	private int certId;
	public ResourcesCred() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResourcesCred(int skillId, int certId) {
		super();
		this.skillId = skillId;
		this.certId = certId;
	}
	/**
	 * @return the skillId
	 */
	public int getSkillId() {
		return skillId;
	}
	/**
	 * @param skillId the skillId to set
	 */
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	/**
	 * @return the certId
	 */
	public int getCertId() {
		return certId;
	}
	/**
	 * @param certId the certId to set
	 */
	public void setCertId(int certId) {
		this.certId = certId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + certId;
		result = prime * result + skillId;
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
		ResourcesCred other = (ResourcesCred) obj;
		if (certId != other.certId)
			return false;
		if (skillId != other.skillId)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResourcesCred [skillId=" + skillId + ", certId=" + certId + "]";
	}
	
	
}
