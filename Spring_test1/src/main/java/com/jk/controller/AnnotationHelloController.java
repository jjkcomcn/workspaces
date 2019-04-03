package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/req/")
public class AnnotationHelloController {

	@RequestMapping("doSayHello")
	public ModelAndView doSayHello() {
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("message", "helloworld");
		return mv;
	}

	@RequestMapping("doSayWelcome") 
	public String doSayWelcome() {
		return "index";
	}

	@RequestMapping("doHandleRequest")
	public String doHandleRequest(Model m) {
		m.addAttribute("message", "<a href='http://localhost:8091/req/doSayHello.do'style='text-decoration:none;'target='_blank'>欢迎界面</a>");
		return "index";
	}
}
