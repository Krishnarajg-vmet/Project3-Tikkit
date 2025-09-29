package com.kay.Tikkit.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="company_id")
	private Long companyId;
	
	@Column(name="company_name", unique = true, nullable = false)
	private String companyName;
	
	@ManyToOne
    @JoinColumn(name="area_id", nullable = false)
    private Area area;
	
	@Column(name="is_active", nullable=false)
	private Boolean isActive;
	
	@Column(name="created_dt")
	@CreationTimestamp
	private LocalDateTime createdDt;
	
	@Column(name="modified_dt")
	@UpdateTimestamp
	private LocalDateTime modifiedDt;

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
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
