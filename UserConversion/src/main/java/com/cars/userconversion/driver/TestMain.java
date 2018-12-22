package com.cars.userconversion.driver;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Seconds;

public class TestMain {


	class DateDiff{
		int days;
		int hours;
		int minutes;
		int seconds;
		public int getDays() {
			return days;
		}
		public void setDays(int days) {
			this.days = days;
		}
		public int getHours() {
			return hours;
		}
		public void setHours(int hours) {
			this.hours = hours;
		}
		public int getMinutes() {
			return minutes;
		}
		public void setMinutes(int minutes) {
			this.minutes = minutes;
		}
		public int getSeconds() {
			return seconds;
		}
		public void setSeconds(int seconds) {
			this.seconds = seconds;
		}
		
		public String toString(){
			return " Days : " + days + " Hours :"+ hours + " Minutes :"+minutes + " Seconds :"+seconds;
		}
		
		
	}
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
	
	static DateDiff dateDiff = new TestMain().new DateDiff();
	
	public static void main(String[] args){
		
		String d1 = "2015-09-13-23:50:29 ";
		String d2 = "2015-09-13-23:50:31";
		
		System.out.println(dateDiff = getTimeDiff(d1,d2));
		
		System.out.println(" " + TestMain.isWithinDateRange("VTC"));
	
		DecimalFormat df = new DecimalFormat("#.##");
		
	
		
	}
	
	
	private static boolean isWithinDateRange(String countType){
		if(countType.equalsIgnoreCase("CTC")){//within past 30 days
			//

			if( ((dateDiff.getDays() > 0) && (dateDiff.getDays() < 30 )) ||
					((dateDiff.getDays() == 0) && (dateDiff.getHours() > 0 || dateDiff.getMinutes() > 0 || dateDiff.getSeconds() > 0)) ) {//what if the difference is exactly 30 days 0 hours 0 mins 0 seconds
				return true;
			}

		}else if(countType.equalsIgnoreCase("VTC")){//with in 7 days
			// within past 7 days
			if( ((dateDiff.getDays() > 0) && (dateDiff.getDays() < 7 )) ||
					((dateDiff.getDays() == 0) && (dateDiff.getHours() >= 0 || dateDiff.getMinutes() >= 0 || dateDiff.getSeconds() >= 0)) ) {//what if the difference is exactly 7 days 0 hours 0 mins 0 seconds
				return true;
			}
		}

		return false;
	}
	
	private static int isInPast(String t1,String t2){
		  try{
			  	Date d1 = sdf.parse(t1);
				Date d2 = sdf.parse(t2);
				
				System.out.println( " D1 " + d1.toString());
				System.out.println( " D2 " + d2.toString());
				return d1.compareTo(d2);
		  }catch(Exception ex){
			  
		  }
		  
		  return 0;
	  }	
	
	private static DateDiff getTimeDiff(String t1,String t2){
		

		Date d1 = null;
		Date d2 = null;
		DateDiff dateDiff = new TestMain().new DateDiff();
		try {
			d1 = sdf.parse(t1);
			d2 = sdf.parse(t2);

			DateTime dt1 = new DateTime(d1);
			DateTime dt2 = new DateTime(d2);

			int days = Days.daysBetween(dt1, dt2).getDays();
			int hours = Hours.hoursBetween(dt1, dt2).getHours() % 24;
			int minutes = Minutes.minutesBetween(dt1, dt2).getMinutes() % 60 ;
			int seconds = Seconds.secondsBetween(dt1, dt2).getSeconds() % 60;
			
			dateDiff.setDays(days);
			dateDiff.setHours(hours);
			dateDiff.setMinutes(minutes);
			dateDiff.setSeconds(seconds);
			
			
		 } catch (Exception e) {
			e.printStackTrace();
		 }
		
		return dateDiff;
	}
}

