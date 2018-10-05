package com.revature.dto;

public class ResetPass {
	private String currentPassword;
	private int userId;
	private String newPassword;
	public ResetPass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResetPass(String currentPassword, int userId, String newPassword) {
		super();
		this.currentPassword = currentPassword;
		this.userId = userId;
		this.newPassword = newPassword;
	}
	/**
	 * @return the currentPassword
	 */
	public String getCurrentPassword() {
		return currentPassword;
	}
	/**
	 * @param currentPassword the currentPassword to set
	 */
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}
	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentPassword == null) ? 0 : currentPassword.hashCode());
		result = prime * result + ((newPassword == null) ? 0 : newPassword.hashCode());
		result = prime * result + userId;
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
		ResetPass other = (ResetPass) obj;
		if (currentPassword == null) {
			if (other.currentPassword != null)
				return false;
		} else if (!currentPassword.equals(other.currentPassword))
			return false;
		if (newPassword == null) {
			if (other.newPassword != null)
				return false;
		} else if (!newPassword.equals(other.newPassword))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResetPass [currentPassword=" + currentPassword + ", userId=" + userId + ", newPassword=" + newPassword
				+ "]";
	}
}
