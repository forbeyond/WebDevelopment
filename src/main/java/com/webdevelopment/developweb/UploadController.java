package com.webdevelopment.developweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/upload")
public class UploadController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String upload() {
		return "upload";
	}

}
