package com.iwinner.belk.hrportal.dao;

import com.iwinner.belk.hrportal.dto.EmployeeDTO;
import com.iwinner.belk.hrportal.dto.Employee_PrimaryDTO;
import com.iwinner.belk.hrportal.exceptions.DaoException;

public interface EmployeeDaoIF {
	public Integer insertNewEmployeeRegister(EmployeeDTO employeeDTO)	throws DaoException;
	public Employee_PrimaryDTO getEmployeePrimaryDetails(String empName) throws DaoException;
	public Integer verifyUserName(String username)throws DaoException;
	public EmployeeDTO getEmployeeHrEFillDetails(String empName)throws DaoException;
}
