package com.webdevelopment.developweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@Controller
public class IndexController {

	@RequestMapping("/login")
	public String login() {
	
		return "login";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String create(@RequestParam("username") String username,
			             @RequestParam("password") String password,Model model) {
		model.addAttribute("username",username);
		model.addAttribute("posts", Data.posts);
		for(Users user :Data.users) {
			if(username.equals(user.getUsername())) {
				if(password.equals(user.getPassword())) {
					return "index";
				}else {
					model.addAttribute("Error", "Password");
					return "error";
				}
			}else {
				model.addAttribute("Error", "Username");
				return "error";
			}
		}
		return "login";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(IndexController.class, args);
	}
}
