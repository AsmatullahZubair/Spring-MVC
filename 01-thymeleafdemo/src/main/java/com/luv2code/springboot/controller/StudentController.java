package com.luv2code.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.luv2code.springboot.model.Student;

@Controller
public class StudentController {
	
	@Value ("${countries}")
	private List<String> countries;
	
	@Value ("${languages}")
	private List<String> languages;
	
	@Value ("${courses}")
	private List<String> courses;
	
	@GetMapping("/showStudentForm")
	public String showStudentForm(Model theModel) {
		
	//create new student object
	Student theStudent = new Student();
	
	//add student object to the model
	theModel.addAttribute("student", theStudent);
	
	//add list of countries to the model
	theModel.addAttribute("countries", countries);
	
	//add list of languages to the model
	theModel.addAttribute("languages", languages);
	
	//add list of courses to the model
	theModel.addAttribute("courses", courses);
		
	return "student-form";	
	}
	
	@PostMapping("/processStudentForm")
	public String processStudentForm(@ModelAttribute("student")Student theStudent) {
		
		//log the input data
		System.out.printf("theStudent: "+theStudent.getFirstName()+", "+theStudent.getLastName());
		
		return "student-confirmation";
	}
	

}
