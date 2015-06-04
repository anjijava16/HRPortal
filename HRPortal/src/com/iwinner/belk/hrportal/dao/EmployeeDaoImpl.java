package com.iwinner.belk.hrportal.dao;

import java.util.List;


import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.iwinner.belk.hrportal.dao.mapper.EmployeePrimaryRowmapper;
import com.iwinner.belk.hrportal.dao.mapper.EmployeeRowmapper;
import com.iwinner.belk.hrportal.dto.EmployeeDTO;
import com.iwinner.belk.hrportal.dto.Employee_PrimaryDTO;
import com.iwinner.belk.hrportal.exceptions.DaoException;
import com.iwinner.belk.hrportal.helper.HRPortalConstants;

public class EmployeeDaoImpl implements EmployeeDaoIF {
	private static Logger LOGGER = Logger.getLogger(EmployeeDaoImpl.class);

	private static DataSource dataSource = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Integer insertNewEmployeeRegister(EmployeeDTO employeeDTO)
			throws DaoException {
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			int primaryInfo = jdbcTemplate.update(
					HRPortalConstants.INSERT_EMPLOYEE_PRIMARY_INFO,
					new Object[] { employeeDTO.getEmpID(),
							employeeDTO.getEmpName(),
							employeeDTO.getEmpOrgName(),
							employeeDTO.getEmpImgLocation(),
							employeeDTO.getEmpImgType(),
							employeeDTO.getEmpImgSize(),
							employeeDTO.getEmpRole(),
							employeeDTO.getEmpRegTime(),
							employeeDTO.getEmpRegDate(),
							employeeDTO.getEmpComments(),
							employeeDTO.getEmpPhone(),
							employeeDTO.getEmpEmail() });
			if (primaryInfo == 1) {
				int personalInfo = jdbcTemplate.update(
						HRPortalConstants.INSERT_EMPLOYEE_PERSONAL,
						new Object[] { employeeDTO.getEmpID(),
								employeeDTO.getEmpName(),
								employeeDTO.getEmpProjectName(),
								employeeDTO.getEmpModule(),
								employeeDTO.getEmpDOBDate(),
								employeeDTO.getJoinDate(),
								employeeDTO.getEmpRelDate(),
								employeeDTO.getAddress(),
								employeeDTO.getEmpBondDate(),
								employeeDTO.getEmpBondEndDate(),
								employeeDTO.getEmpSkypeId(),
								employeeDTO.getEmpDouc(),
								employeeDTO.getEmpComments(),
								employeeDTO.getEmpCardType(),
								employeeDTO.getEmpDesg(),
								employeeDTO.getEmployeeUpdateBy() });
				if (personalInfo == 1) {
					int reportInfo = jdbcTemplate.update(
							HRPortalConstants.INSERT_EMPLOYEE_REPORT,
							new Object[] { employeeDTO.getEmpID(),
									employeeDTO.getEmpName(),
									employeeDTO.getEmpReportYear(),
									employeeDTO.getEmpReportName(),
									employeeDTO.getEmpReportInfo(),
									employeeDTO.getEmpReportComments(),
									employeeDTO.getEmpWorkDetails() });
				}
			}

		} catch (Exception e) {
			LOGGER.error("insertion  failed " + e.getMessage());
			throw new DaoException(e);
		}
		return null;
	}

	public Employee_PrimaryDTO getEmployeePrimaryDetails(String empName)
			throws DaoException {
		Employee_PrimaryDTO employeePrimaryDTO = new Employee_PrimaryDTO();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<Employee_PrimaryDTO> empPriList = (List<Employee_PrimaryDTO>) jdbcTemplate	.query(HRPortalConstants.SELECT_EMPLOYEE_BASIC_INFO,new Object[] { empName },
							new EmployeePrimaryRowmapper());
			for (Employee_PrimaryDTO employeePrimaryDTOInfo : empPriList) {
				employeePrimaryDTO = employeePrimaryDTOInfo;
			}
		} catch (Exception e) {
			LOGGER.error("getEmployeePrimaryDetails  failed " + e.getMessage());
			throw new DaoException(e);
		}
		return employeePrimaryDTO;
	}

	public EmployeeDTO getEmployeeHrEFillDetails(String empName)throws DaoException {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<EmployeeDTO> employeeDTOList = (List<EmployeeDTO>) jdbcTemplate.query(	HRPortalConstants.SELECT_EMPLOYEE_INFO,
					new Object[] { empName }, new EmployeeRowmapper());
			for(EmployeeDTO empD:employeeDTOList){
				employeeDTO=empD;
			}
		} catch (Exception e) {
			LOGGER.error("getEmployeeHrEFillDetails  failed " + e.getMessage());
			throw new DaoException(e);
		}
		return employeeDTO;
	}

	public String employeeDetailsUpdated(EmployeeDTO employeeDTO)
			throws DaoException {

		return null;
	}

	public Integer verifyUserName(String username)throws DaoException {
		LOGGER.info("$$$verifyUserName() $$$$ username=["+username+"]");
		Integer verifyUserName=0;
		try {
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			int count=jdbcTemplate.queryForInt(HRPortalConstants.SELECT_FIND_EMPLOYEE_EXIST_OR_NOT,new Object[]{username});
			if(count==1){
				verifyUserName=HRPortalConstants.EMPLOYEE_FOUND;
			}else{
				verifyUserName=HRPortalConstants.EMPLOYEE_NOT_FOUND;
			}
		} catch (Exception e) {
			LOGGER.error("Error into the verifyUserName(String username) userName=["+username+"]"+e.getMessage());
			verifyUserName=HRPortalConstants.EMPLOYEE_FOUND_ERROR;
			return verifyUserName;
		}
		return verifyUserName;
	}
	
}
