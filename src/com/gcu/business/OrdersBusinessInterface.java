/*
 * Adam Bender
 * CST 323 Activity 2
 * 1/17/2021
 * Business Interface
 */

package com.gcu.business;

import java.util.List;

import com.gcu.model.User;

public interface OrdersBusinessInterface {

	public List<User> getAllVisitors();
	public boolean create(User user);
}
