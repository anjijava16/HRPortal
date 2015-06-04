package com.iwinner.belk.hrportal.service;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.iwinner.belk.hrportal.dao.EmployeeDaoIF;
import com.iwinner.belk.hrportal.dto.EmployeeDTO;
import com.iwinner.belk.hrportal.dto.Employee_PrimaryDTO;
import com.iwinner.belk.hrportal.exceptions.DaoException;
import com.iwinner.belk.hrportal.exceptions.ServiceException;
import com.iwinner.belk.hrportal.form.EmployeePrimaryVO;
import com.iwinner.belk.hrportal.form.EmployeeVO;
import com.iwinner.belk.hrportal.helper.DaoFactory;
import com.iwinner.belk.hrportal.helper.HRPortalConstants;

@Service
public class EmployeeServiceImpl implements EmployeeServiceIF {
	private static Logger LOGGER = Logger.getLogger(StartUpServiceImpl.class);
	private EmployeeDaoIF employeeDaoIF=null;
	public EmployeePrimaryVO getEmployeePriamryDetails(String empName)throws ServiceException {
		LOGGER.info("getEmployeePriamryDetails is started empName=["+empName+"]");
		employeeDaoIF=DaoFactory.getEmployeeDaoFactory();
		EmployeePrimaryVO employeeVo=new EmployeePrimaryVO();
		try {
			Employee_PrimaryDTO employeeDTO=(Employee_PrimaryDTO)employeeDaoIF.getEmployeePrimaryDetails(empName);
			try {
				BeanUtils.copyProperties(employeeVo, employeeDTO);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				LOGGER.error("Error at the "+e.getMessage()+"BeanUtils is conversion not working");
			} catch (InvocationTargetException e) {
				e.printStackTrace();
				LOGGER.error("Error at the "+e.getMessage()+"BeanUtils is conversion not working");
			}
		} catch (DaoException e) {
			e.printStackTrace();
			LOGGER.error("Error at the "+e.getMessage());
		}
		LOGGER.info("getEmployeePriamryDetails is ended employeeVo=["+employeeVo+"]");
		return employeeVo;
	}
	public Integer verifyUserName(String username) throws ServiceException {
		LOGGER.info("getEmployeePriamryDetails is started empName=["+username+"]");
		employeeDaoIF=DaoFactory.getEmployeeDaoFactory();
		Integer userNameFind=0;
		try {
			userNameFind=employeeDaoIF.verifyUserName(username);
		} catch (DaoException e) {
			e.printStackTrace();
			userNameFind=HRPortalConstants.EMPLOYEE_FOUND_ERROR;
			LOGGER.error("Error at the "+e.getMessage());
		}
		LOGGER.info("getEmployeePriamryDetails is ended username=["+username+"]");
		return userNameFind;
	}
	public EmployeeVO getEmployeeHrEFillDetails(String empName)
			throws ServiceException {
		LOGGER.info("getEmployeeHrEFillDetails is started empName=["+empName+"]");
		employeeDaoIF=DaoFactory.getEmployeeDaoFactory();
		EmployeeVO employeeVO=new EmployeeVO();
		try {
			EmployeeDTO employeeDTO=employeeDaoIF.getEmployeeHrEFillDetails(empName);
				employeeVO.setEmpRegTime(new Timestamp(new Date().getTime()));
				employeeVO.setEmpName(employeeDTO.getEmpName());
				employeeVO.setEmpID(employeeDTO.getEmpID());
				employeeVO.setEmpDesg(employeeDTO.getEmpDesg());
				employeeVO.setEmpModule(employeeDTO.getEmpModule());
				employeeVO.setEmpDOBDate(employeeDTO.getEmpDOBDate());
				employeeVO.setJoinDate(employeeDTO.getJoinDate());
				employeeVO.setEmpRegDate(employeeDTO.getEmpRegDate());
				employeeVO.setEmpProjectName(employeeDTO.getEmpProjectName());
				employeeVO.setAddress(employeeDTO.getAddress());
				employeeVO.setEmpBondDate(employeeDTO.getEmpBondDate());
				employeeVO.setEmpBondEndDate(employeeDTO.getEmpBondEndDate());
				employeeVO.setEmpLocation(employeeDTO.getEmpLocation());
				employeeVO.setEmpPhone(employeeDTO.getEmpPhone());
				employeeVO.setEmpSkypeId(employeeDTO.getEmpSkypeId());
				employeeVO.setEmpDouc(employeeDTO.getEmpDouc());
				employeeVO.setEmpComments(employeeDTO.getEmpComments());
				employeeVO.setEmpCardType(employeeDTO.getEmpCardType());
				employeeVO.setEmpRegTime(employeeDTO.getEmpRegTime());
		} catch (DaoException e) {
			LOGGER.error("Error at the "+e.getMessage());
			throw new ServiceException(e);
		}
		LOGGER.info("getEmployeeHrEFillDetails is ended EmployeeVO=["+employeeVO+"]");
		return employeeVO;
	}
}
