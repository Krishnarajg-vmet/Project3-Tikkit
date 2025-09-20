package com.kay.Tikkit.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.*;

import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
@Table(name="area")
public class Area {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="area_id")
	private Long areaId;
	
	@Column(name="area_name", unique=true, nullable=false)
	private String areaName;
	
	@Column(name="pincode", nullable=false)
	private String pincode;
	
	@ManyToOne
	@JoinColumn(name="country_id", nullable=false)
	private Country country;
	
	@ManyToOne
	@JoinColumn(name="state_id", nullable=false)
	private State state;
	
	@ManyToOne
	@JoinColumn(name="district_id", nullable=false)
	private District district;
	
	@ManyToOne
	@JoinColumn(name="city_id", nullable=false)
	private City city;
	
	@Column(name="is_active", nullable=false)
	private Boolean isActive;
	
	@Column(name="created_dt")
	@CreationTimestamp
	private LocalDateTime createdDt;
	
	@Column(name="modified_dt")
	@UpdateTimestamp
	private LocalDateTime modifiedDt;

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDateTime getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(LocalDateTime createdDt) {
		this.createdDt = createdDt;
	}

	public LocalDateTime getModifiedDt() {
		return modifiedDt;
	}

	public void setModifiedDt(LocalDateTime modifiedDt) {
		this.modifiedDt = modifiedDt;
	}
	
	

}
