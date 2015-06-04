package com.iwinner.belk.hrportal.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iwinner.belk.hrportal.dto.UserDTO;

public class PasswordMapper implements RowMapper<UserDTO>{
@Override
public UserDTO mapRow(ResultSet rs, int arg1) throws SQLException {

	UserDTO uDTO=new UserDTO();
	 uDTO.setPassword(rs.getString("PASSWORD"));
	 uDTO.setPastPasswordOne(rs.getString("PAST_PASSWORDOne"));
	 uDTO.setPastPasswordTwo(rs.getString("PAST_PASSWORDTwo"));
	 uDTO.setPastPasswordThree(rs.getString("PAST_PASSWORDThree"));
	return uDTO;
}
	
}
