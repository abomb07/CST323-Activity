package com.gcu.utility;

import org.apache.log4j.Logger;

public class MyLogger implements Ilogger{

	private static Logger logger;
	private static MyLogger instance;
	
	public static Logger getLogger(Class<?> theClass) 
	{
        MyLogger.logger = Logger.getLogger(theClass);
        
        return MyLogger.logger;
	}

	public static MyLogger getInstance() 
	{
		if (instance == null)
		{
			instance = new MyLogger();
		}
		return instance;
	}

	public void Info(String message, Class<?> theClass)
	{
		getLogger(theClass).info(message);
	}
}
