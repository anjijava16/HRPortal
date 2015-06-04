package com.iwinner.belk.hrportal.dao;

import com.iwinner.belk.hrportal.dto.UserDTO;
import com.iwinner.belk.hrportal.exceptions.DaoException;

public interface LDAPLoginDaoIF {
	public Integer verifyCreds(String username, String password)
			throws DaoException ;
	public UserDTO userInfo(String username)throws DaoException;
	public int countLoginTimes(String username)throws DaoException;
	public void updatenNumberOfLoginTimes(String username)throws DaoException;
	public void updatLastLoginTime(String username)throws DaoException;
	public Integer updateConsectiveFailures(String username)throws DaoException;
	public Integer findConsetiveFailureCount(String username)throws DaoException;
	public Integer expireDateVerification(String username)throws DaoException;
	public void updateConsetiveFailureZero(String username)throws DaoException;
	public String userRole(String username)throws DaoException;
}
