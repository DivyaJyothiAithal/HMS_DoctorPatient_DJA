package com.MIT.HMS_DJ.WebDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber()
	{
		Random random=new Random();
		int ranNum=random.nextInt(1000);
		return ranNum;		
	}
	
	public String getCustomizedRandomCharacters(String data,int size)
	{// size: value generated is of this length
		
		StringBuilder sb=new StringBuilder(size);
		for(int j=0;j<size;j++)
		{
			int index=(int) (data.length()*Math.random());//Math.random() generates a random number b/w 0.0 to 1.0  ..... so for example 10*0.67=6.7 ~=6 => 6th char='6'
			sb.append(data.charAt(index));// Concatenate each of these randomly picked character to StringBuilder object
		}
			String value=new String(sb);		
			 return  value;
	}
	
	public String getSystemDateyyyyMMdd()
	{
		//Choose Date using SimpleDate and Calendar
		Date date=new Date();//gives Today's Date
		//Display in yyyy-MM-dd format
		SimpleDateFormat simpldate=new SimpleDateFormat("yyyy-MM-dd");
		String TodayDate=simpldate.format(date);
		return TodayDate;
	}
	
	public String getCustomizedDate(int days)
	{
		Date date=new Date();
		SimpleDateFormat simpldate=new SimpleDateFormat("yyyy-MM-dd");
		String TodayDate=simpldate.format(date);
		//Add 30 days
		Calendar cal=simpldate.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String After30Days=simpldate.format(cal.getTime());
		return After30Days;
	}
}
