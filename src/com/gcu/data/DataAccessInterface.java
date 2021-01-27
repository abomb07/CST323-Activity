/*
 * Adam Bender
 * CST 323 Activity 2
 * 1/17/2021
 * Data Interface
 */

package com.gcu.data;

import java.util.List;

import com.gcu.model.User;

public interface DataAccessInterface <T>{

	public List<T> findAll();
	public boolean create(User user);
}
