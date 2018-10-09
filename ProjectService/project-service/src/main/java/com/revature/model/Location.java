package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity 
@Table(name="location")
public class Location {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "location_name")
	private String locationName;
	public Location() {
		super();
	}
	public Location(String locationName) {
		super();
		this.locationName = locationName;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locationName == null) ? 0 : locationName.hashCode());
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
		Location other = (Location) obj;
		if (locationName == null) {
			if (other.locationName != null)
				return false;
		} else if (!locationName.equals(other.locationName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Location [locationName=" + locationName + "]";
	}
	
}
