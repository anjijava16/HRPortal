package com.iwinner.belk.hrportal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.iwinner.belk.hrportal.exceptions.ServiceException;
import com.iwinner.belk.hrportal.form.EmployeeVO;
import com.iwinner.belk.hrportal.helper.HRPortalConstants;
import com.iwinner.belk.hrportal.service.EmployeeServiceIF;

@Controller
public class EmployeeOperationController {

	@Autowired
	private EmployeeServiceIF employeeServiceIF;

	private static Logger LOGGER = Logger.getLogger(EmployeeOperationController.class);
	
	
	@RequestMapping("hrForm.action")
	public  String hrEfilePageRedirect(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		return "hrProfile";
	}
	
	@RequestMapping("hrEfileNameCheck.action")
	public  void getEmployeeDetails(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		JsonObject myObj = new JsonObject();
		System.out.println("From HRFileName====>>>>>>>>>>");
		String username=request.getParameter("username");
	 int id=0;
	try {
		id = employeeServiceIF.verifyUserName(username);
	} catch (ServiceException e) {
		e.printStackTrace();
	}
	LOGGER.info("#############################");
	LOGGER.info("Employee ID =["+id+"]");
	LOGGER.info(id==HRPortalConstants.EMPLOYEE_FOUND);
	LOGGER.info("#############################");
	 if(id==HRPortalConstants.EMPLOYEE_FOUND){
		 try {
			EmployeeVO emploveeVO=employeeServiceIF.getEmployeeHrEFillDetails(username);
			LOGGER.info("EmployeeVO values =["+emploveeVO+"]");
			Gson gson = new Gson(); 
	        JsonElement employeeVoObj = gson.toJsonTree(emploveeVO);
	        myObj.addProperty("success", true);
	        myObj.add("employeeVo", employeeVoObj);
	        response.getWriter().write(myObj.toString());
	        return ;
		} catch (ServiceException e) {
		}
	 }else if(id==HRPortalConstants.EMPLOYEE_NOT_FOUND){
		 response.getWriter().write(HRPortalConstants.USER_NOT_FOUND);
		 myObj.addProperty("success", false);
		 return ;
	 }else if(id==HRPortalConstants.EMPLOYEE_FOUND_ERROR){
		 response.getWriter().write(HRPortalConstants.USER_NOT_FOUND_ERROR);
		 myObj.addProperty("success", false);
		 return ;
	 }
	}
}
