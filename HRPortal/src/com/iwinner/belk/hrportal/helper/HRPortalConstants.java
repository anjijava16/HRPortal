package com.iwinner.belk.hrportal.helper;

import java.util.ResourceBundle;

public class HRPortalConstants {
	
	public static ResourceBundle CONFIG = ResourceBundle.getBundle("com.iwinner.belk.hrportal.utils.hrPortal");
	
	public static String YYYYMMDD=CONFIG.getString("YYYYMMDD");
	public static String USER_AGENT = CONFIG.getString("USER_AGENT");
	public static String FORWARD_SLASH = CONFIG.getString("FORWARD_SLASH");
	public static String CHROME_BROWSER = CONFIG.getString("CHROME_BROWSER");
	public static String INTERNETEXPLORE_BROWSER = CONFIG.getString("INTERNET_EXPLORE_BROWSER");
	public static String FIREFOX_BROWSER = CONFIG.getString("FIREFOX_BROWSER");
	public static String OS_NAME = CONFIG.getString("OS_NAME");

	
	public static Integer DATE_CORRECT=1000;
	public static Integer DATE_EXPIRED=1001;
	public static Integer DATE_EQUAL=1002;

	public static Integer ACTIVE_STATUS=2000;
	public static Integer INACTIVE_STATUS=2001;
	public static Integer DISABLE_STATUS=2002;

	public static Integer LOGIN_SUCCESS=3000;
	public static Integer LOGIN_FAILED=30001;
	
	public static Integer PASSWORD_DISABLE_TODAY=4000;
	
	public static Integer ADMIN_ROLE_ID=5000;
	public static Integer NORMA_USER_ID=50001;
	public static Integer HR_USER_ID=5002;
	public static Integer CUSTOMER_USER_ID=5003;
	public static Integer PASSWORD_BLOCKED=5004;
	
	public static Integer LDAP_SUCCESS_LOGIN=6000;
	public static Integer LDAP_FAILED_LOGIN=6001;
	public static Integer LDAP_CONNECTION_ERROR=6002;

	public static Integer EMPLOYEE_FOUND=7000;
	public static Integer EMPLOYEE_NOT_FOUND=7001;
	public static Integer EMPLOYEE_FOUND_ERROR=7003;
	
	public static Integer PASSWORD_CHANGED_SUCCESS=50;
	public static Integer CURRENT_PASSWORD_INCORRECT=51;
	public static Integer PASSWORD_CHANGED_ERROR=52;
	public static Integer PASSWORD_USED_BEFORE=53;
	
	public static String EMPLOYEE_FOUND_MESSAGE="Emp Found";
	public static String EMPLOYEE_NOT_FOUND_MESSAGE="Emp not found";
	public static String EMPLOYEE_FOUND_ERROR_MESSAGE="There was a system error while processing your request.Please try again later";
	public static Integer RANDOM_KEY_DIGIT=6;
	public static String LDPA_CONNECTION_FAILED_ERROR="LDAP Connection failed ,please try again";
	public static String PASSWORD_EXPIRED_FAILED_ERROR="Your password date is expired,please contact (admin@iwinner.com)";
	public static String INVALID_CRDS_ERRORS="Invalid cred's,Please enter valid creds";
	public static String LOGIN_ACTIVE_STATUS="LDAP Connection failed ,please try again";
	public static String LOGIN_INACTIVE_STATUS="Your not active user ,please contact (admin@iwinner.com)";
	public static String LOGIN_DISABLE_STATUS="Your not active user ,please contact (admin@iwinner.com)";
	public static String PASSWORD_DISABLE_TODAY_ERRORS="Your password is blocked try after 24 hours";
	public static String PASSWORD_BLOCKED_ERRORS="Your password is blocked try after 24 hours";
    public static String USER_NOT_FOUND="User Name is not found";	
    public static String USER_NOT_FOUND_ERROR="User Name found time error ,please contact system admin";
	//SQL QUERIES
	public static String INSERT_AUDIT_QUERY=CONFIG.getString("INSERT_QUERY");
	public static String SELECT_USER_VERIFY=CONFIG.getString("SELECT_USER_VERIFY");
	public static String SELECT_USER_DETAILS=CONFIG.getString("SELECT_USER_INFO");
	public static String SELECT_LAST_HITS_COUNT=CONFIG.getString("SELECT_COUNT_HITS");
	public static String UPDATE_LOGIN_COUNT=CONFIG.getString("UPDATE_LOGIN_COUNT");
	public static String UPDATE_LAST_LOGIN_TIMES=CONFIG.getString("UPDATE_LAST_LOGIN_TIMES");
	public static String UPDATE_CONSERTIVE_FAILUR=CONFIG.getString("UPDATE_CONSERTIVE_FAILUR");
	public static String SELECT_CONSERTIVE_FAILURE_COUNT=CONFIG.getString("SELECT_CONSERTIVE_FAILURE_COUNT");
	public static String UPDATE_CONSERTIVE_SUCCESS=CONFIG.getString("UPDATE_CONSERTIVE_SUCCESS");
	public static String UPDATE_CONSERTIVE_FAILURE_ZERO=CONFIG.getString("UPDATE_CONSERTIVE_FAILURE_ZERO");
	public static String INSERT_EMPLOYEE_PRIMARY_INFO=CONFIG.getString("INSERT_EMPLOYEE_BASIC");
	public static String INSERT_EMPLOYEE_PERSONAL=CONFIG.getString("INSERT_EMPLOYEE_PERSONAL");
	public static String INSERT_EMPLOYEE_REPORT=CONFIG.getString("INSERT_EMPLOYEE_REPORT");
	public static String SELECT_EMPLOYEE_BASIC_INFO=CONFIG.getString("SELECT_EMPLOYEE_BASIC_INFO");
	public static String SELECT_EMPLOYEE_INFO=CONFIG.getString("SELECT_EMPLOYEE_INFO");
	public static String SELECT_FIND_EMPLOYEE_EXIST_OR_NOT=CONFIG.getString("SELECT_FIND_EMPLOYEE_EXIST_OR_NOT");
	public static String SELECT_PAST_PASSWORD=CONFIG.getString("SELECT_PAST_PASSWORD");
	public static String SELECT_FIND_CURRENT_PASSWORD=CONFIG.getString("SELECT_FIND_CURRENT_PASSWORD");
	public static String UPDATE_PASSWORD_CHANGED_DETAILS=CONFIG.getString("UPDATE_PASSWORD_CHANGED_DETAILS");
	public static String UPDATE_PASSWORD=CONFIG.getString("UPDATE_PASSWORD");
	public static Integer COUNT_PLUS=1;
	public static Integer COUNT_ZERO=0;
	
}
