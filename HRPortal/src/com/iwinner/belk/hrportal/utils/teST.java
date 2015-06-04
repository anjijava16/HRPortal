package com.iwinner.belk.hrportal.utils;

import java.util.Calendar;
import java.util.Date;

public class teST {
public static void main(String[] args) {
	
	Calendar cal=Calendar.getInstance();
    cal.set(Calendar.MONTH, 1);
    cal.set(Calendar.YEAR, 1989);
    cal.set(Calendar.DATE, 10);
    Date date=cal.getTime();
    System.out.println(date);
	
		
}
}
