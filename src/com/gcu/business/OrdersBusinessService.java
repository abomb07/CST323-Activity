/*
 * Adam Bender
 * CST 323 Activity 2
 * 1/17/2021
 * Business Service
 */

package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataAccessInterface;
import com.gcu.model.User;
import com.gcu.utility.MyLogger;

public class OrdersBusinessService implements OrdersBusinessInterface{

	DataAccessInterface<?> ods;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllVisitors() {
		// TODO Auto-generated method stub
		MyLogger.getInstance().Info("Entering getAllVisitors method", OrdersBusinessService.class);
		MyLogger.getInstance().Info("Exiting getAllVisitors method", OrdersBusinessService.class);
		return (List<User>) ods.findAll();
	}
	
	@Autowired
	public void setOrdersDataService(DataAccessInterface<?> ods) {
		this.ods = ods;
	}

	public boolean create(User user) {
		// TODO Auto-generated method stub
		MyLogger.getInstance().Info("Entering create method", OrdersBusinessService.class);
		MyLogger.getInstance().Info("Exiting create method", OrdersBusinessService.class);
		return ods.create(user);
	}
}
