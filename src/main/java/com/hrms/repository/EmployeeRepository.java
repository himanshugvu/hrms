package com.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.entity.EmployeeMaster;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeMaster, Long> {

}
