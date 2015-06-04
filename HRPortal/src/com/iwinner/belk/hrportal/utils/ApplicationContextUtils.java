package com.iwinner.belk.hrportal.utils;


import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iwinner.belk.hrportal.dao.EmployeeDaoIF;
import com.iwinner.belk.hrportal.dao.LoginDaoIF;
import com.iwinner.belk.hrportal.dto.EmployeeDTO;
import com.iwinner.belk.hrportal.dto.Employee_PrimaryDTO;
import com.iwinner.belk.hrportal.exceptions.DaoException;
import com.iwinner.belk.hrportal.helper.HRPortalConstants;
import com.iwinner.belk.hrportal.helper.PasswordEncoder;
import com.iwinner.belk.hrportal.helper.RandomStringGenerator;

public class ApplicationContextUtils {

	public void insertEmployee(){
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");

		EmployeeDaoIF loginDao=(EmployeeDaoIF)context.getBean("loginDao");
		EmployeeDTO empDTO=new EmployeeDTO();
			empDTO.setEmpID(RandomStringGenerator.getGenerateKey(HRPortalConstants.RANDOM_KEY_DIGIT));
			empDTO.setEmpName("shekar");
			empDTO.setAddress("Hyderabad,Ambeeta,Hanuman Template opp,5600031");
			empDTO.setEmpBondDate(new Date());
			empDTO.setEmpBondEndDate(DateUtils.afterTwoYearsFromCurrentDate());
			empDTO.setEmpCardType("Green");
			empDTO.setEmpComments("Employee Creation Done");
			empDTO.setEmpDOBDate(DateUtils.setBirthDate(16, 6, 1988));
			empDTO.setEmpDouc("NA");
			empDTO.setEmpEmail("shekarreddy4047@gmail.com");
			empDTO.setEmpImgLocation("http://localhost:2626/images/iwinner.jpg");
			empDTO.setEmpImgSize(4000);
			empDTO.setEmpImgType("jpg");
			empDTO.setEmployeeUpdateBy("ksreddy");
			empDTO.setEmpModule("hrportalmodule");
			empDTO.setEmpOrgName("iwinner");
			empDTO.setEmpPhone(91998999l);
			empDTO.setEmpProjectName("HrPortal");
			empDTO.setEmpRegDate(new Date());
			empDTO.setEmpRegTime(new Timestamp(new Date().getTime()));
			empDTO.setEmpRelDate(new Date());
			empDTO.setEmpReportInfo("Report Added");
			empDTO.setEmpReportName("Emp_Report");
			empDTO.setEmpRole("HR");
			empDTO.setEmpReportYear(2014);
			empDTO.setEmpSkypeId("shekarreddy4047");
			empDTO.setEmpWorkDetails("Dev");
			empDTO.setJoinDate(new Date());
			empDTO.setEmpDesg("BSC");
			
			try {
				Integer count=loginDao.insertNewEmployeeRegister(empDTO);
				System.out.println("Count is "+count);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

	}
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		EmployeeDaoIF empolyeeDaoIF=(EmployeeDaoIF)context.getBean("loginDao");
		try {
        LoginDaoIF login=(LoginDaoIF)context.getBean("loginDaoImpl");
        Integer id=login.passwordUpdate("anjaiahspr", PasswordEncoder.encodePassword("anji"), PasswordEncoder.encodePassword("anjaiahspr"));
        System.out.println("PasswordEncorder::>>>>>>>>"+id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
      }
	
		
}
