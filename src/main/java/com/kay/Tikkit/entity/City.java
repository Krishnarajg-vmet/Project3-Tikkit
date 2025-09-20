package com.kay.Tikkit.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name="city")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="city_id")
	private Long cityId;
	
	@Column(name="city_name", unique=true, nullable=false)
	private String cityName;
	
	@ManyToOne
	@JoinColumn(name="country_id", nullable=false)
	private Country country;
	
	@ManyToOne
	@JoinColumn(name="state_id", nullable=false)
	private State state;
	
	@ManyToOne
	@JoinColumn(name="district_id", nullable=false)
	private District district;
	
	@Column(name="is_active", nullable=false)
	private Boolean isActive;
	
	@Column(name="created_dt")
	@CreationTimestamp
	private LocalDateTime createdDt;
	
	@Column(name="modified_dt")
	@UpdateTimestamp
	private LocalDateTime modifiedDt;

	

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
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
