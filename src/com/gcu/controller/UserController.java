/*
 * Adam Bender
 * CST 323 Activity 2
 * 1/17/2021
 * User Controller
 */

package com.gcu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.OrdersBusinessInterface;
import com.gcu.model.User;

@Controller
@RequestMapping("")
public class UserController 
{
	OrdersBusinessInterface service;
	
	/**
	 * Home landing page
	 * @return
	 */
	@RequestMapping(path="/", method=RequestMethod.GET)
	public ModelAndView displayForm()
	{
		return new ModelAndView("visitorForm", "user", new User("", "", ""));
	}
	
	/**
	 * Post request to add visitor to database
	 * @param user
	 * @param result
	 * @return
	 */
	@RequestMapping(path="/adduser", method=RequestMethod.POST)
	public ModelAndView addUser(@Valid @ModelAttribute("user")User user, BindingResult result)
	{		
		if(result.hasErrors())
		{
			return new ModelAndView("addUser", "user", user);
		}
		service.create(user);
		
		List<User> users = service.getAllVisitors();
		
		return new ModelAndView("displayUsers", "users", users);
	}
	
	@Autowired
	public void setOrdersService(OrdersBusinessInterface service) {
		this.service = service;
	}
}
