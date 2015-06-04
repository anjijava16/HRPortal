package com.iwinner.belk.hrportal.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iwinner.belk.hrportal.dto.Employee_PrimaryDTO;

public class EmployeePrimaryRowmapper implements RowMapper<Employee_PrimaryDTO>{
 public Employee_PrimaryDTO mapRow(ResultSet rs, int arg1)
		throws SQLException {
	 Employee_PrimaryDTO employeeDTO=new Employee_PrimaryDTO();
	 employeeDTO.setEmpID(rs.getString("EMP_ID"));
	 employeeDTO.setEmpName(rs.getString("EMP_NAME"));
	 employeeDTO.setEmpEmail(rs.getString("EMP_EMAIL"));
	 employeeDTO.setEmpRole(rs.getString("EMP_ROLE"));
	 employeeDTO.setEmpImgLocation(rs.getString("EMP_IMG_LOCATION"));
	 employeeDTO.setEmpPhone(rs.getLong("EMP_PHONE"));
	 employeeDTO.setEmpOrgName(rs.getString("EMP_IMG_LOCATION"));
	 employeeDTO.setEmpRegDate(rs.getDate("EMP_REG_DATE"));
	 employeeDTO.setEmpRegTime(rs.getTimestamp("EMP_REG_TIMESTAMP"));
     employeeDTO.setEmpProjectName(rs.getString("epr.EMP_PROJECT_NAME"));
     employeeDTO.setEmpTechModule(rs.getString("epr.EMP_TECH_MODULE"));
     employeeDTO.setEmpLocation(rs.getString("EMP_LOCATION"));
	 return employeeDTO;
}
}
