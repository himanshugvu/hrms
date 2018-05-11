package com.hrms.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the pf_info database table.
 * 
 */
@Entity
@Table(name="pf_info")
@NamedQuery(name="PfInfo.findAll", query="SELECT p FROM PfInfo p")
public class PfInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String contribution;

	private String pf;

	private String uan;

	//bi-directional many-to-one association to EmployeeMaster
	@ManyToOne
	@JoinColumn(name="emp_id")
	private EmployeeMaster employeeMaster;

	public PfInfo() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContribution() {
		return this.contribution;
	}

	public void setContribution(String contribution) {
		this.contribution = contribution;
	}

	public String getPf() {
		return this.pf;
	}

	public void setPf(String pf) {
		this.pf = pf;
	}

	public String getUan() {
		return this.uan;
	}

	public void setUan(String uan) {
		this.uan = uan;
	}

	public EmployeeMaster getEmployeeMaster() {
		return this.employeeMaster;
	}

	public void setEmployeeMaster(EmployeeMaster employeeMaster) {
		this.employeeMaster = employeeMaster;
	}

}