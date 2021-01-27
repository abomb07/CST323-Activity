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

public class OrdersBusinessService implements OrdersBusinessInterface{

	DataAccessInterface<?> ods;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllVisitors() {
		// TODO Auto-generated method stub
		return (List<User>) ods.findAll();
	}
	
	@Autowired
	public void setOrdersDataService(DataAccessInterface<?> ods) {
		this.ods = ods;
	}

	public boolean create(User user) {
		// TODO Auto-generated method stub
		return ods.create(user);
	}
}
