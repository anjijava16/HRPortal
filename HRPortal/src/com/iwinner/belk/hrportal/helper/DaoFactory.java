package com.iwinner.belk.hrportal.helper;

import com.iwinner.belk.hrportal.dao.EmployeeDaoIF;
import com.iwinner.belk.hrportal.dao.EmployeeDaoImpl;
import com.iwinner.belk.hrportal.dao.LDAPLoginDaoIF;
import com.iwinner.belk.hrportal.dao.LDAPLoginDaoImpl;
import com.iwinner.belk.hrportal.dao.LoginDaoIF;
import com.iwinner.belk.hrportal.dao.LoginDaoImpl;
import com.iwinner.belk.hrportal.dao.StartUpDaoIF;
import com.iwinner.belk.hrportal.dao.StartUpDaoImpl;

public class DaoFactory {

	private static StartUpDaoIF startUpDaoIF = null;
	private static LoginDaoIF loginDaoIF = null;
	private static LDAPLoginDaoIF ldapLoginDaoIF=null;
	private static EmployeeDaoIF employeeDaoIF=null;
	static {
		startUpDaoIF = new StartUpDaoImpl();
		loginDaoIF=new LoginDaoImpl();
		ldapLoginDaoIF=new LDAPLoginDaoImpl();
		employeeDaoIF=new EmployeeDaoImpl();
	}
	public static StartUpDaoIF startUpDaoFactory() {
		return startUpDaoIF;
	}
	public static LoginDaoIF loginDaoFactory(){
		return loginDaoIF;
	}
	public static LDAPLoginDaoIF ldapLoginDaoFactory(){
		return ldapLoginDaoIF;
	}
	public static EmployeeDaoIF getEmployeeDaoFactory(){
		return employeeDaoIF;
	}
}
