package com.iwinner.belk.hrportal.service;

import org.springframework.stereotype.Service;

import com.iwinner.belk.hrportal.dao.LoginDaoIF;
import com.iwinner.belk.hrportal.exceptions.DaoException;
import com.iwinner.belk.hrportal.exceptions.ServiceException;
import com.iwinner.belk.hrportal.helper.DaoFactory;
import com.iwinner.belk.hrportal.helper.HRPortalConstants;

@Service
public class LoginServiceImpl implements LoginServiceIF{
	private LoginDaoIF loginDaoIF=null;
	public Integer passwordUpdate(String username, String currentpassword,	String newPassword) throws ServiceException {
	loginDaoIF=DaoFactory.loginDaoFactory();
	Integer passwordChangeId=HRPortalConstants.COUNT_ZERO;
	try {
		 passwordChangeId=loginDaoIF.passwordUpdate(username, currentpassword, newPassword);
	} catch (DaoException e) {
		e.printStackTrace();
	}
	return passwordChangeId;
}
}
