package com.kay.Tikkit.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.kay.Tikkit.enums.BloodGroup;
import com.kay.Tikkit.enums.EmployeeCategory;
import com.kay.Tikkit.enums.EmployeeType;
import com.kay.Tikkit.enums.Gender;
import com.kay.Tikkit.enums.MaritalStatus;
import com.kay.Tikkit.enums.Title;

import jakarta.persistence.*;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	private Long employeeId;
	
	@Column(name="first_name", nullable = false)
	private String firstName;
	
	@Column(name="last_name", nullable = false)
	private String lastName;
	
	@Column(name="employee_code", nullable = false, unique = true)
	private String employeeCode;
	
	@Enumerated(EnumType.STRING)
	@Column(name="title", nullable = false)
	private Title title;
	
	@Column(name="dob", nullable = false)
	private LocalDate dob;
	
	@Column(name = "age", nullable = false)
	private Byte age;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "gender", nullable = false)
	private Gender gender;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "marital_status", nullable = false)
	private MaritalStatus maritalStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(name="blood_group", nullable = false)
	private BloodGroup bloodGroup;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "employee_type", nullable = false)
	private EmployeeType employeeType;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "employee_category", nullable = false)
	private EmployeeCategory employeeCategory;
	
	@ManyToOne
	@JoinColumn(name = "branch_id", nullable = false)
	private Branch location;
	
	@ManyToOne
	@JoinColumn(name = "designation_id", nullable = false)
	private Designation designation;
	
	@Column(name="joiningDate")
	private LocalDate joiningDate;
	
	@ManyToOne
	@JoinColumn(name="department_id", nullable = false)
	private Department department;
	
	@Column(name="qualification")
	private String qualification;
	
	@Column(name="address_1", nullable = false)
	private String address1;
	
	@Column(name="address_2")
	private String address2;
	
	@ManyToOne
	@JoinColumn(name="area_id", nullable = false)
	private Area area;
	
	@Column(name="mobile_number", nullable = false, unique = true)
	private String mobileNumber;
	
	@Column(name="alternate_number")
	private String alternateNumber;
	
	@Column(name="email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "reporting_to")
	private String reportingTo;
	
	@Column(name = "reporting_department")
	private String reportingDepartment;
	
	@Column(name = "reporting_designation")
	private String reportingDesignation;
	
	@Column(name="resignation_date")
	private LocalDate resignationDate;
	
	@Column(name="is_active", nullable = false)
	private Boolean isActive;
	
	@Column(name="created_dt", nullable = false)
	private LocalDateTime createdDt;
	
	@Column(name="modified_dt")
	private LocalDateTime modifiedDt;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Byte getAge() {
		return age;
	}

	public void setAge(Byte age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public EmployeeCategory getEmployeeCategory() {
		return employeeCategory;
	}

	public void setEmployeeCategory(EmployeeCategory employeeCategory) {
		this.employeeCategory = employeeCategory;
	}

	public Branch getLocation() {
		return location;
	}

	public void setLocation(Branch location) {
		this.location = location;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAlternateNumber() {
		return alternateNumber;
	}

	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReportingTo() {
		return reportingTo;
	}

	public void setReportingTo(String reportingTo) {
		this.reportingTo = reportingTo;
	}

	public String getReportingDepartment() {
		return reportingDepartment;
	}

	public void setReportingDepartment(String reportingDepartment) {
		this.reportingDepartment = reportingDepartment;
	}

	public String getReportingDesignation() {
		return reportingDesignation;
	}

	public void setReportingDesignation(String reportingDesignation) {
		this.reportingDesignation = reportingDesignation;
	}

	public LocalDate getResignationDate() {
		return resignationDate;
	}

	public void setResignationDate(LocalDate resignationDate) {
		this.resignationDate = resignationDate;
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

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}
	
		

}
