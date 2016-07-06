package com.webdevelopment.developweb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String login(HttpServletRequest request) {
		
		return "login";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String index(@RequestParam("username")  String username,
			             @RequestParam("password") String password,Model model,
			            // @RequestParam("next") String next,
			             HttpSession session) {
		
		//HttpSession session = request.getSession();

		model.addAttribute("username",username);
		model.addAttribute("posts", Data.posts);
		
		String next = (String) session.getAttribute("next");
		if(next == null) next = "/index";
		
		for(Users user :Data.users) {
			if(username.equals(user.getUsername())) {
				if(password.equals(user.getPassword())) {
					session.setAttribute("username", username);
					return "redirect:".concat(next);
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
	
	@RequestMapping("/create")
	public String create(HttpSession session) {
		
//		if(session.getAttribute("username") == null) {
//			return "redirect:/login";
//		}
		
		return "create";
	}
	
	@RequestMapping(value="/create",method = RequestMethod.POST)
	public String backindex(@RequestParam("title") String title,
							@RequestParam("content") String content, Model model,
							HttpSession session) {
		Data.posts.add(new Post(title,content));
		model.addAttribute("posts", Data.posts);
		model.addAttribute("username",session.getAttribute("username"));
			
		return "redirect:/index";
	}
	
	@RequestMapping(value="/index")
	public String goindex(Model model,HttpSession session) {
		model.addAttribute("username",session.getAttribute("username"));
		model.addAttribute("posts",Data.posts);
		
//		if(session.getAttribute("username") == null) {
//			return "redirect:/login";
//		}
		return "index";
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(IndexController.class, args);
	}
}
