package com.iwinner.belk.hrportal.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.iwinner.belk.hrportal.helper.HRPortalConstants;

public class DateUtils {
	private static Logger LOGGER = Logger.getLogger(DateUtils.class);
	public static String YYYYMMDDHHMMSS="yyyy-MM-dd HH:mm:ss";
	public static Date getExpireDateFormat(String expireDate){
		LOGGER.info(" ##### stared  getExpireDateFormat() #####");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate=null;
		try {
			currentDate = sdf.parse(expireDate);
		} catch (ParseException e) {
			e.printStackTrace();
			LOGGER.error("Error into the "+e.getMessage());
		}
		LOGGER.info(" ##### ended  getExpireDateFormat() #####");
		return currentDate;
	}
	/***
	 * set th current Date to after 2 years EX:current Date is 2015 jan 1 will be 2017 jan 1
	 * @author anji@iWinner.com
	 * @since 1st May 2015
	 * @return Date
	 */
	public static Date afterTwoYearsFromCurrentDate(){
		LOGGER.info(" ##### stared  afterTwoYearsFromCurrentDate() #####");
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.YEAR,2);
		Date afterTwoYears=cal.getTime();
		LOGGER.info(" ##### stared  afterTwoYearsFromCurrentDate() #####");
		return afterTwoYears;
	}
	
	public static Date after60DaysFromCurrentDate(){
		LOGGER.info(" ##### stared  afterTwoYearsFromCurrentDate() #####");
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE,60);
		Date after60DaysFromCurrentDate=cal.getTime();
		LOGGER.info(" ##### stared  afterTwoYearsFromCurrentDate() #####");
		return after60DaysFromCurrentDate;
	}
	public static Date setBirthDate(Integer dayOf,Integer month,Integer year){
		LOGGER.info(" ##### stared  setBirthDate() #####");
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.MONTH, month-HRPortalConstants.COUNT_PLUS);
	    cal.set(Calendar.YEAR, year);
	    cal.set(Calendar.DATE, dayOf);
	    Date dateOfBirth=cal.getTime();
	    LOGGER.info(" ##### stared  setBirthDate() #####");
        return	 dateOfBirth;	
	}
	public static Date processDate(String date){
		Date updateDate =new Date();
		String time="2015-05-01 06:31:08";
		try{
			SimpleDateFormat sdf=new SimpleDateFormat(YYYYMMDDHHMMSS);
			updateDate=sdf.parse(time);
			}catch(Exception e){
				e.printStackTrace();
			}
		return updateDate;
	}
	public static Timestamp processTimestamp(){
		Date updateDate =new Date();
		Timestamp timestampInf=null;
		String time="2015-05-01 06:31:08";
		try{
			SimpleDateFormat sdf=new SimpleDateFormat(YYYYMMDDHHMMSS);
			updateDate=sdf.parse(time);
			long updateTime = updateDate.getTime();
			timestampInf= new Timestamp(updateTime);
			System.out.println(timestampInf);
			}catch(Exception e){
				e.printStackTrace();
			}
	      return timestampInf;	
		}

}
