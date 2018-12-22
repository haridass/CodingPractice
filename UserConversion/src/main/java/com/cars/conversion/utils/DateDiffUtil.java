package com.cars.conversion.utils;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Seconds;

public class DateDiffUtil {

	
	public static  DateDiff getTimeDiff(String t1,String t2){


		Date d1 = null;
		Date d2 = null;
		DateDiff dateDiff = new DateDiff();

		try {
			d1 = Constants.SDF_yyyyMMddhhmmss.parse(t1);
			d2 = Constants.SDF_yyyyMMddhhmmss.parse(t2);

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

	public static boolean isWithinTimeRange(DateDiff dateDiff,int seconds){

		//for 5 second rule pass 5
		//for 2 second rule for pc comparison, pass 1 ( we need >= seconds)
		//greater than passed seconds 
		if( (dateDiff.getSeconds() > seconds) || (dateDiff.getMinutes() > 0) || (dateDiff.getHours() > 0) ||
				(dateDiff.getDays() > 0)){ //greater than passed seconds
			return true;
		}


		return false;
	}
	
	public static boolean isWithinDateRange(DateDiff dateDiff,int numdays){
		
		
//		if(countType.equalsIgnoreCase("CTC")){//within past 30 days
			//

			if( ((dateDiff.getDays() > 0) && (dateDiff.getDays() < numdays )) ||
					((dateDiff.getDays() == 0) && (dateDiff.getHours() > 0 || dateDiff.getMinutes() > 0 || dateDiff.getSeconds() > 0)) ) {//what if the difference is exactly 30 days 0 hours 0 mins 0 seconds
				return true;
			}

//		}else if(countType.equalsIgnoreCase("VTC")){//with in 7 days
//			// within past 7 days
//			if( ((dateDiff.getDays() > 0) && (dateDiff.getDays() < 7 )) ||
//					((dateDiff.getDays() == 0) && (dateDiff.getHours() >= 0 || dateDiff.getMinutes() >= 0 || dateDiff.getSeconds() >= 0)) ) {//what if the difference is exactly 7 days 0 hours 0 mins 0 seconds
//				return true;
//			}
//		}

		return false;
	}
}
