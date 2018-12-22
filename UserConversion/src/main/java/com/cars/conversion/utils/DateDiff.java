package com.cars.conversion.utils;

public class DateDiff{
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
	
	@Override
	public String toString(){
		return " Days : " + days + " Hours :"+ hours + " Minutes :"+minutes + " Seconds :"+seconds;
	}
	
	public void clear(){
		days = 0;
		hours = 0;
		minutes = 0;
		seconds = 0;
	}
	
}
