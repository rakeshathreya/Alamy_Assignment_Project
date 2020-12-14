/**
 * 
 */
package com.assignmentsdemo.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO: DEFINE ME!! Rakesh
 * @author Rakesh
 * 14-Dec-2020 
 * 
 */
public class DateFormat {
	
	public String convertDateFormat(String date) throws ParseException
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
		  SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy/MM/dd");
		  Date Dateformat=formatter.parse(date);
		  String dateconvert=formatter1.format(Dateformat).toString();
		return dateconvert;
	}

}
