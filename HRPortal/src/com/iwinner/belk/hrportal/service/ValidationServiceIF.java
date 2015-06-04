package com.iwinner.belk.hrportal.service;

import java.util.Map;

import com.iwinner.belk.hrportal.exceptions.ServiceException;


public interface ValidationServiceIF {

	public Map<String,Integer> verifyAllServices(String username,String password)throws ServiceException;
}
