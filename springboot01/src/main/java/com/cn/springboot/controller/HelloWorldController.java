package com.cn.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

	@ResponseBody
	@RequestMapping("/hello")
	public String hello(){
		return "Hello World!";
	}
}
