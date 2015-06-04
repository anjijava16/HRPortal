package com.iwinner.belk.hrportal.service;

import com.iwinner.belk.hrportal.exceptions.ServiceException;

public interface LoginServiceIF {
	public Integer passwordUpdate(String username,String currentpassword,String newPassword)throws ServiceException;
}
