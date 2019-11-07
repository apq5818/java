package com.jcombat.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController
public class DemoController {

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		return "welcome";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request,Map<String, Object> model) {
		model.put("username",request.getParameter("firstname"));
		//return "login";
		return "viewpage";
	}
	
	
	@RequestMapping("/logincheck")
	public String logincheck(HttpServletRequest request,Map<String,Object>model) {
		String pass=request.getParameter("password");
		System.out.println(pass);
		if(pass.equals("ashish123"))
		{
			model.put("name",request.getParameter("username"));
			return "viewpage";
		}
		else
			return "Errorpage";
	}
	
	/*
	@RequestMapping(value = "/logincheck", method = RequestMethod.GET)
    public String authenticateUser(@RequestParam("username") String username, @RequestParam("password") String password ,Model model) {
        System.out.println("coming in controller    " +username +" : "+ password);  
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "success";
    }
    */
}