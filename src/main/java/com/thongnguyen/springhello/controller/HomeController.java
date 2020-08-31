package com.thongnguyen.springhello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController{
	
	@RequestMapping("/")
	public String hello(){		
		return "homePage";
	}
	
	@RequestMapping("/hello")
	public ModelAndView hello(@RequestParam(value="name") String name,
							  @RequestParam(value="age") int age){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("homePage");
		
		mav.addObject("msg", name);
		mav.addObject("age", age);
		
		return mav;
	}
}
