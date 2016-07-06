package com.webdevelopment.developweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostController {
	
	@RequestMapping("/post/{id}")
	public String getPost(@PathVariable("id") int id,Model model) {
		model.addAttribute("post", Data.getById(id));
		
		return "post";
	}

}
