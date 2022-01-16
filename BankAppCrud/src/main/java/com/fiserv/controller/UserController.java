package com.fiserv.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fiserv.model.UserDetails;
import com.fiserv.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String user(Model model) {
		model.addAttribute("user", new UserDetails());
		model.addAttribute("userList", userService.listUsers());
		return "user";
	}
	@RequestMapping(value = "/users/add", method = RequestMethod.POST)
	public String adduser(@ModelAttribute("user") UserDetails user) {
		if ( user.getAccountNumber() == 0)  {

			
			// new employee, add it
			userService.createAccount(user);
		}
		return "redirect:/users";
	}
	
	
	@RequestMapping("/user/remove/{accountNum}")
	public String removeuser(@PathVariable("accountNum") int accountNum) {

		userService.removeUser(accountNum);
		return "redirect:/users";
	}
}

