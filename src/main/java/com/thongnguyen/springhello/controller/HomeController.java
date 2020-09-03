package com.thongnguyen.springhello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController{
	
	@RequestMapping("/")
	public String hello(){		
		return "homePage";
	}
	
	@RequestMapping("/login")
	public String login(){		
		return "login";
	}
	
	@RequestMapping("/accessDenied")
	public String accessDenied(){		
		return "accessDenied";
	}
	
	
}
