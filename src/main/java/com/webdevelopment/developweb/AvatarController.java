package com.webdevelopment.developweb;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.io.ByteStreams;

@Controller
@RequestMapping("/avatar")
public class AvatarController {
	
	private ClassPathResource resource = new ClassPathResource("static/img/head.jpg");

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public byte[] avatar() throws IOException {
		return Data.avatar == null ? ByteStreams.toByteArray(resource.getInputStream()) : Data.avatar;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile file) throws IOException {
		Data.avatar = file.getBytes();
		return "redirect:/index";
	}
}
