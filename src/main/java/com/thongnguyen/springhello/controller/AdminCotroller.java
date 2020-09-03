package com.thongnguyen.springhello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class AdminCotroller {
	
	
	@RequestMapping("/")
	public String admin(){		
		return "admin";
	}
	
}
