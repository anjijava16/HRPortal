package com.iwinner.belk.hrportal.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iwinner.belk.hrportal.exceptions.ServiceException;
import com.iwinner.belk.hrportal.form.EmployeePrimaryVO;
import com.iwinner.belk.hrportal.helper.HRPortalConstants;
import com.iwinner.belk.hrportal.helper.PasswordEncoder;
import com.iwinner.belk.hrportal.service.EmployeeServiceIF;
import com.iwinner.belk.hrportal.service.LoginServiceIF;
import com.iwinner.belk.hrportal.service.ValidationServiceIF;

@Controller
public class LoginController {

	@Autowired
	private ValidationServiceIF validateServiceIF;
   
	@Autowired
	private EmployeeServiceIF employeeServiceIF;

	@Autowired
	private LoginServiceIF loginServiceIF;
	
	
	@RequestMapping(value = "loginVerification.action")
	public String loginVerification(HttpServletRequest request) {
		String target = "login";
        String message="";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		List<Integer> listOfConditions=new ArrayList<Integer>();
		try {
			Map<String, Integer> loginVerficationDetails = validateServiceIF.verifyAllServices(username,PasswordEncoder.encodePassword(password));
			
			
			Set set = loginVerficationDetails.entrySet();
			for (Iterator it = set.iterator(); it.hasNext();) {
				Map.Entry mapEntry = (Map.Entry) it.next();
                Integer keyValue=(Integer)mapEntry.getValue();
                listOfConditions.add(keyValue);
			}
			if(listOfConditions.contains(HRPortalConstants.LDAP_CONNECTION_ERROR)){
				request.setAttribute("message", HRPortalConstants.LDPA_CONNECTION_FAILED_ERROR);
				return target;
			}
			if(listOfConditions.contains(HRPortalConstants.PASSWORD_DISABLE_TODAY)){
				request.setAttribute("message", HRPortalConstants.PASSWORD_DISABLE_TODAY_ERRORS);
				return target;
			}
			if(listOfConditions.contains(HRPortalConstants.PASSWORD_BLOCKED)){
				request.setAttribute("message", HRPortalConstants.PASSWORD_BLOCKED_ERRORS);
				return target;
			}
			if(listOfConditions.contains(HRPortalConstants.DATE_CORRECT)){
				 if(listOfConditions.contains(HRPortalConstants.ACTIVE_STATUS)){
            		 if(listOfConditions.contains(HRPortalConstants.LOGIN_SUCCESS)){
            			 request.getSession().setAttribute("username", username);
            			    if(listOfConditions.contains(HRPortalConstants.ADMIN_ROLE_ID)){
            			    	EmployeePrimaryVO employeeVO=employeeServiceIF.getEmployeePriamryDetails(username);
            			    	request.setAttribute("employeeVO", employeeVO);
            			    	request.getSession().setAttribute("username", employeeVO.getEmpName());
            			    		target="profileFinal";            			 	
            			    	}else if(listOfConditions.contains(HRPortalConstants.NORMA_USER_ID)){
            			    		target="userHomePage";            			 
            			    	}else if(listOfConditions.contains(HRPortalConstants.HR_USER_ID)){
            			    		target="hrHomePage";            			 
            			    	}else if(listOfConditions.contains(HRPortalConstants.CUSTOMER_USER_ID)){
            			    		target="homePage";            			 
            			    	}
            		 }else{
            			 request.setAttribute("message", HRPortalConstants.LOGIN_INACTIVE_STATUS);
            			 return target;
            		 }
            	 }
			}else if(listOfConditions.contains(HRPortalConstants.DATE_EXPIRED)){
				 request.setAttribute("message", HRPortalConstants.PASSWORD_EXPIRED_FAILED_ERROR);
    			 return target;
			}
			if(listOfConditions.contains(HRPortalConstants.LOGIN_FAILED)){
				request.setAttribute("message", HRPortalConstants.INVALID_CRDS_ERRORS);
				return target;
			}
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return target;
	}
@RequestMapping("ChangePwd.action")
public String passwordChange(HttpServletRequest request){
	return "ChangePwd";
}

@RequestMapping("passwordUpdate.action")
public String passwordUpdate(HttpServletRequest request){
	String password=request.getParameter("currentpwd");
	String newPassword=request.getParameter("newpwd");
	String confirmPassword=request.getParameter("confirmpwd");
	if(!newPassword.equals(confirmPassword)){
		request.setAttribute("pmessage", "Please enter newpassword and confirm password equal");
		return "ChangePwd";
	}
	try {
		Integer id=loginServiceIF.passwordUpdate((String)request.getSession().getAttribute("username"), PasswordEncoder.encodePassword(password), PasswordEncoder.encodePassword(confirmPassword));
		if(id==HRPortalConstants.PASSWORD_CHANGED_SUCCESS){
			request.setAttribute("pmessage", "Password Changed successfully");
			return "profileFinal";
		}else if(id==HRPortalConstants.CURRENT_PASSWORD_INCORRECT){
			request.setAttribute("pmessage", "Your current password is incorrect,Please enter correct password");
			return "ChangePwd";
		}else if(id==HRPortalConstants.PASSWORD_CHANGED_ERROR){
			request.setAttribute("pmessage", "Error occur,please contact system admin");
			return "ChangePwd";
		}else if(id==HRPortalConstants.PASSWORD_USED_BEFORE){
			request.setAttribute("pmessage", "Password alredy exist ,Please use another password");
			return "ChangePwd";
		}
	} catch (ServiceException e) {
		e.printStackTrace();
	}
	return "";
}

}
