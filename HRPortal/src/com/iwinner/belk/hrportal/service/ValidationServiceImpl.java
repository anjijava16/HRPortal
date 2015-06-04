package com.iwinner.belk.hrportal.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.iwinner.belk.hrportal.dao.LDAPLoginDaoIF;
import com.iwinner.belk.hrportal.dto.UserDTO;
import com.iwinner.belk.hrportal.exceptions.DaoException;
import com.iwinner.belk.hrportal.exceptions.ServiceException;
import com.iwinner.belk.hrportal.helper.DaoFactory;
import com.iwinner.belk.hrportal.helper.HRPortalConstants;

@Service
public class ValidationServiceImpl implements ValidationServiceIF {

	private LDAPLoginDaoIF ldapLoginDaoIF = null;

	public Map<String, Integer> verifyAllServices(String username,String password) throws ServiceException {
		
		Map<String, Integer> userService = new LinkedHashMap<String, Integer>();
		
		ldapLoginDaoIF = DaoFactory.ldapLoginDaoFactory();
		try {
			Integer verifyLoginCreds = ldapLoginDaoIF.verifyCreds(username,password);
			if (HRPortalConstants.LDAP_SUCCESS_LOGIN==verifyLoginCreds) {
				// Expire Date Checking
				Integer expireDate=ldapLoginDaoIF.expireDateVerification(username);
				if(HRPortalConstants.DATE_CORRECT==expireDate){
					userService.put("PASSWORD_EXPIRE",HRPortalConstants.DATE_CORRECT);
				}else if(HRPortalConstants.DATE_EXPIRED==expireDate){
					userService.put("PASSWORD_EXPIRE",HRPortalConstants.DATE_EXPIRED);
					return userService;
				}
				UserDTO userDTO = ldapLoginDaoIF.userInfo(username);
				if ("ACTIVE".equals(userDTO.getAccountStatus())) {
					userService.put("ACTIVE_STATUS",HRPortalConstants.ACTIVE_STATUS);

				} else if ("INACTIVE".equals(userDTO.getAccountStatus())) {
					userService.put("ACTIVE_STATUS",HRPortalConstants.INACTIVE_STATUS);
					return userService;
				} else if ("DISABLE".equals(userDTO.getAccountStatus())) {
					userService.put("ACTIVE_STATUS",HRPortalConstants.DISABLE_STATUS);
					return userService;
				}
				
				Integer count = ldapLoginDaoIF.findConsetiveFailureCount(username);
				System.out.println("Count values "+count);
				if (count < 3) {
					ldapLoginDaoIF.updatenNumberOfLoginTimes(username);
					ldapLoginDaoIF.updateConsetiveFailureZero(username);
                 String role=ldapLoginDaoIF.userRole(username);
                 System.out.println("ROle OF S"+role);
                 if(Integer.parseInt(role)==5000){
                	 userService.put("USER_CREDS_VERFICATION",HRPortalConstants.LOGIN_SUCCESS);
                	 userService.put("USER_ROLE",Integer.parseInt(role));
                	 return userService;
                 }else if(Integer.parseInt(role)==5001){
                	 userService.put("USER_CREDS_VERFICATION",HRPortalConstants.LOGIN_SUCCESS);
                	 userService.put("USER_ROLE",Integer.parseInt(role));
                	 return userService;
                 }else if(Integer.parseInt(role)==5002){
                	 userService.put("USER_CREDS_VERFICATION",HRPortalConstants.LOGIN_SUCCESS);
                	 userService.put("USER_ROLE",Integer.parseInt(role));
                	 return userService;
                 }else if(Integer.parseInt(role)==5003){
                	 userService.put("USER_CREDS_VERFICATION",HRPortalConstants.LOGIN_SUCCESS);
                	 userService.put("USER_ROLE",Integer.parseInt(role));
                	 return userService;
                 }
				} else {
					userService.put("PASSWORD_DIASABLE_TODAY",HRPortalConstants.PASSWORD_DISABLE_TODAY);
					return userService;
				}
			} else if(HRPortalConstants.LDAP_FAILED_LOGIN==verifyLoginCreds){
				int count=ldapLoginDaoIF.updateConsectiveFailures(username);
				//PASSWORD_DISABLE
				if(count==3){
					userService.put("PASSWORD_BLOCKED",HRPortalConstants.PASSWORD_BLOCKED);
				}
				userService.put("USER_CREDS_VERFICATION",HRPortalConstants.LOGIN_FAILED);
				return userService;
			} else if(HRPortalConstants.LDAP_CONNECTION_ERROR==verifyLoginCreds){
				userService.put("LDAP_CONNECTION_ERROR",HRPortalConstants.LDAP_CONNECTION_ERROR);
				return userService;
			}

		} catch (DaoException e) {
			e.printStackTrace();
		}
		return userService;
	}

}
