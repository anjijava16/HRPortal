package com.iwinner.belk.hrportal.service;

import com.iwinner.belk.hrportal.exceptions.ServiceException;
import com.iwinner.belk.hrportal.form.EmployeePrimaryVO;
import com.iwinner.belk.hrportal.form.EmployeeVO;

public interface EmployeeServiceIF {

	public EmployeePrimaryVO getEmployeePriamryDetails(String empName)throws ServiceException;
	public Integer verifyUserName(String username)throws ServiceException;
	public EmployeeVO getEmployeeHrEFillDetails(String empName)throws ServiceException;
}
