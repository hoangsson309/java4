package com.example.java4_Fpoly;

import model.ChucVu;
import service.iml.Service;

import java.util.*;

public class MainTest {
	public static void main(String[] args) {
		Date date = new Date();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int min = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		String timeNow =  day + "" + month + "" + year +""+hour + "" + min + "" + second;
		System.out.println(timeNow);
	}
}
