package com.hrms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.entity.EmployeeMaster;
import com.hrms.exception.ResourceNotFoundException;
import com.hrms.repository.EmployeeRepository;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
    EmployeeRepository employeeRepository;

	@ApiOperation(value = "get all employee", notes = "get all employee")
    @GetMapping("/")
    public List<EmployeeMaster> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @ApiOperation(value = "save employee", notes = "save employee")
	@ApiParam(name = "employeeMaster", value = "employee to save", required = true)
    @PostMapping("/")
    public EmployeeMaster createEmployee(@Valid @RequestBody EmployeeMaster employeeMaster) {
        return employeeRepository.save(employeeMaster);
    }

    @ApiOperation(value = "get employee by id", notes = "get employee by id")
	@ApiImplicitParam(name = "id", value = "employee id", required = true, dataType = "Long", paramType = "path")
    @GetMapping("/{id}")
    public EmployeeMaster getEmployeeById(@PathVariable(value = "id") Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("EmployeeMaster", "id", employeeId));
    }

    @ApiOperation(value = "update employee", notes = "update employee")
	@ApiImplicitParam(name = "id", value = "employee id", required = true, dataType = "Long")
    @PutMapping("/{id}")
    public EmployeeMaster updateEmployee(@PathVariable(value = "id") Long employeeId,
                                           @Valid @RequestBody EmployeeMaster employeeMaster) {

    	EmployeeMaster employeeInfo = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("EmployeeMaster", "id", employeeId));

        EmployeeMaster updatedEmployee = employeeRepository.save(employeeInfo);
        return updatedEmployee;
    }

    @ApiOperation(value = "delete employee", notes = "delete employee")
	@ApiImplicitParam(name = "id", value = "employee id", required = true, dataType = "Long")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Long employeeId) {
    	EmployeeMaster employeeMaster = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("EmployeeMaster", "id", employeeId));

    	employeeRepository.delete(employeeMaster);

        return ResponseEntity.ok().build();
    }

}
