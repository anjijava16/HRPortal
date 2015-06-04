package com.iwinner.belk.hrportal.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iwinner.belk.hrportal.dto.EmployeeDTO;

public class EmployeeRowmapper implements RowMapper<EmployeeDTO> {
	public EmployeeDTO mapRow(ResultSet rs, int arg1) throws SQLException {
		EmployeeDTO empDTO = new EmployeeDTO();
		empDTO.setEmpName(rs.getString("EPR.EMP_NAME"));
		empDTO.setEmpID(rs.getString("EPR.EMP_ID"));
		empDTO.setEmpDesg(rs.getString("EPS.empDesignation"));
		empDTO.setEmpModule(rs.getString("EPS.EMP_TECH_MODULE"));
		empDTO.setEmpDOBDate(rs.getDate("EPS.EMP_DOB"));
		empDTO.setJoinDate(rs.getDate("EPS.EMP_JOIN_DATE"));
		empDTO.setEmpRegDate(rs.getDate("EPS.EMP_REL_DATE"));
		empDTO.setEmpProjectName(rs.getString("EPS.EMP_PROJECT_NAME"));
		empDTO.setAddress(rs.getString("EPS.EMP_ADDRESS"));
		empDTO.setEmpBondDate(rs.getDate("EPS.EMP_BOND_START_DATE"));
		empDTO.setEmpBondEndDate(rs.getDate("EPS.EMP_BOND_END_DATE"));
		empDTO.setEmpLocation(rs.getString("EPR.EMP_LOCATION"));
		empDTO.setEmpPhone(rs.getLong("EPR.EMP_PHONE"));
		empDTO.setEmpSkypeId(rs.getString("EPS.EMP_SKYPE_ID"));
		empDTO.setEmpDouc(rs.getString("EPS.EMP_DOCUMENTS"));
		empDTO.setEmpComments(rs.getString("EPS.EMP_COMMENTS"));
		empDTO.setEmpCardType(rs.getString("EPS.EMP_CARD_TYPE"));
		empDTO.setEmpRegTime(rs.getTimestamp("EMP_REG_TIMESTAMP"));
		empDTO.setEmpDOBDate(rs.getDate("EPS.EMP_DOB"));
		return empDTO;
	}
}
