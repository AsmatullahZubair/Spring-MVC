//Code created on 17 April 2024 by Asmatullah
package com.luv2code.springboot.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

	//controller method to show initial HTML from
	@PostMapping("/show")
	public String showForm(Model model) {
		model.addAttribute("theDate", new Date());
		return "hello-form";
	}
	
	//controller method to process HTML form
	@RequestMapping("/process")
	public String processForm(Model model) {
		model.addAttribute("theDate", new Date());
		return "hello";
	}
	
	@RequestMapping("/process2")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		//read the request parameter from HTML form
		String theName = request.getParameter("studentName");
		
		//convert the data to all caps
		theName = theName.toUpperCase();
		
		//create the message
		String result = "Yo! "+ theName;
		
		//add message to the model
		model.addAttribute("message", result);
		model.addAttribute("theDate", new Date());
		
		return "hello";
	}
	
	@RequestMapping("/process3")
	public String processForm3(@RequestParam("studentName") String theName, Model model) {
		
		//convert the data to all caps
		theName = theName.toUpperCase();
		
		//create the message
		String result = "Hey! "+ theName;
		
		//add message to the model
		model.addAttribute("message", result);
		model.addAttribute("theDate", new Date());
		
		return "hello";
	}
	
}
