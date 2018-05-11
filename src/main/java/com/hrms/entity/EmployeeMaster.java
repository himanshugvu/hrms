package com.hrms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the employee_master database table.
 * 
 */
@Entity
@Table(name="employee_master")
@NamedQuery(name="EmployeeMaster.findAll", query="SELECT e FROM EmployeeMaster e")
public class EmployeeMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="blood_group")
	private String bloodGroup;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;

	@Column(name="email_id")
	private String emailId;

	@Column(name="emergency_contact")
	private String emergencyContact;

	@Column(name="father_name")
	private String fatherName;

	@Column(name="first_name")
	private String firstName;

	private String gender;

	@Column(name="last_name")
	private String lastName;

	@Column(name="middle_name")
	private String middleName;

	private String mobile;

	@Column(name="mother_name")
	private String motherName;

	@Column(name="spouse_name")
	private String spouseName;

	private String status;

	//bi-directional many-to-one association to EmployeeAddress
	@OneToMany(mappedBy="employeeMaster")
	private List<EmployeeAddress> employeeAddresses;

	//bi-directional many-to-one association to OfficeInfo
	@OneToMany(mappedBy="employeeMaster")
	private List<OfficeInfo> officeInfos;

	//bi-directional many-to-one association to PaymentInfo
	@OneToMany(mappedBy="employeeMaster")
	private List<PaymentInfo> paymentInfos;

	//bi-directional many-to-one association to PfInfo
	@OneToMany(mappedBy="employeeMaster")
	private List<PfInfo> pfInfos;

	public EmployeeMaster() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBloodGroup() {
		return this.bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEmergencyContact() {
		return this.emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getSpouseName() {
		return this.spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<EmployeeAddress> getEmployeeAddresses() {
		return this.employeeAddresses;
	}

	public void setEmployeeAddresses(List<EmployeeAddress> employeeAddresses) {
		this.employeeAddresses = employeeAddresses;
	}

	public EmployeeAddress addEmployeeAddress(EmployeeAddress employeeAddress) {
		getEmployeeAddresses().add(employeeAddress);
		employeeAddress.setEmployeeMaster(this);

		return employeeAddress;
	}

	public EmployeeAddress removeEmployeeAddress(EmployeeAddress employeeAddress) {
		getEmployeeAddresses().remove(employeeAddress);
		employeeAddress.setEmployeeMaster(null);

		return employeeAddress;
	}

	public List<OfficeInfo> getOfficeInfos() {
		return this.officeInfos;
	}

	public void setOfficeInfos(List<OfficeInfo> officeInfos) {
		this.officeInfos = officeInfos;
	}

	public OfficeInfo addOfficeInfo(OfficeInfo officeInfo) {
		getOfficeInfos().add(officeInfo);
		officeInfo.setEmployeeMaster(this);

		return officeInfo;
	}

	public OfficeInfo removeOfficeInfo(OfficeInfo officeInfo) {
		getOfficeInfos().remove(officeInfo);
		officeInfo.setEmployeeMaster(null);

		return officeInfo;
	}

	public List<PaymentInfo> getPaymentInfos() {
		return this.paymentInfos;
	}

	public void setPaymentInfos(List<PaymentInfo> paymentInfos) {
		this.paymentInfos = paymentInfos;
	}

	public PaymentInfo addPaymentInfo(PaymentInfo paymentInfo) {
		getPaymentInfos().add(paymentInfo);
		paymentInfo.setEmployeeMaster(this);

		return paymentInfo;
	}

	public PaymentInfo removePaymentInfo(PaymentInfo paymentInfo) {
		getPaymentInfos().remove(paymentInfo);
		paymentInfo.setEmployeeMaster(null);

		return paymentInfo;
	}

	public List<PfInfo> getPfInfos() {
		return this.pfInfos;
	}

	public void setPfInfos(List<PfInfo> pfInfos) {
		this.pfInfos = pfInfos;
	}

	public PfInfo addPfInfo(PfInfo pfInfo) {
		getPfInfos().add(pfInfo);
		pfInfo.setEmployeeMaster(this);

		return pfInfo;
	}

	public PfInfo removePfInfo(PfInfo pfInfo) {
		getPfInfos().remove(pfInfo);
		pfInfo.setEmployeeMaster(null);

		return pfInfo;
	}

}