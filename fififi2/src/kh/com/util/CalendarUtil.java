package kh.com.util;

import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {
	//3 ->03
	public static String two(int tt){
		return (tt+"").length()>1?(tt+""):"0"+tt;
	}
	// 201703
	public static String yyyymm(int year, int month){
		return ""+year+two(month);
	}
	// 20170325
	public static String yyyymmdd(int year, int month, int day){
		return yyyymm(year,month)+two(day);
	}
	// 201703251435
	public static String yyyymmddhhmm(int year, int month, int day,
			int hour, int min){
		return yyyymmdd(year,month,day)+two(hour)+two(min);
	}
	// 01 -> 1
	public static int one(String tt){
		if(tt.charAt(0)=='0'){
			return Integer.parseInt(""+tt.charAt(1));
		}else{
			return Integer.parseInt(tt);
		}
	}
	// 01 -> 1
	public static int toOne(String tt){
		if(tt.charAt(0)=='0'){
			return Integer.parseInt(""+tt.charAt(1));
		}else{
			return Integer.parseInt(tt);
		}
	}
	// 오늘 날짜
	public static Calendar toCalendar(int year, int month, int day){
		Calendar cal=Calendar.getInstance();
		cal.set(year, month-1, day);
		return cal;
	}
	// 오늘 Date
	public static Date toDate(int year, int month, int day){
		return toCalendar(year,month,day).getTime();
	}
	// yyyy-MM-dd
	public static java.sql.Date toSqlDate(int year, int month, int day){
		//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String s=""+year+"-"+two(month)+"-"+two(day);
		return java.sql.Date.valueOf(s);
	}	
}
