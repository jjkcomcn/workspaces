package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
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
		m.addAttribute("message",
				"<a href='http://localhost:8091/doSayHello.do'style='text-decoration:none;'target='_blank'>欢迎界面</a>");
		return "index";
	}

	@RequestMapping(value = "doConterTest", produces = "application/json;charset=utf-8")
	@ResponseBody
	public String doConterTest() {
		return "<a href='http://localhost:8091/doSayHello.do'style='text-decoration:none;'target='_blank'>欢迎界面</a>";
	}

	@RequestMapping("doConterTest01")
	@ResponseBody
	public JsonResult doConterTest01(String data, Integer id,String str) {
		System.out.println(str);
		data = "<h5 align='center' style='color:green'>" + data + "</h5>";
		String top = "<div align='center' style='margin:5px'><img src='photo/";
		String butt = ".jpg' width='65%' height='65%'/></div>";
		if (id > 110 && id < 120) {
			switch (id % 10) {
			case 1:
				data = data + top + "timg" + 1 + butt;
				break;
			case 2:
				data = data + top + "timg" + 2 + butt;
				break;
			case 3:
				data = data + top + "timg" + 3 + butt;
				break;
			}
		}
		if (id > 120) {
			switch (id % 10) {
			case 1:
				data = data + top + 21 + butt;
				break;
			case 2:
				data = data + top + 22 + butt;
				break;
			case 3:
				data = data + top + 23 + butt;
				break;
			case 4:
				data = data + top + 24 + butt;
				break;
			}
		}
		if (id > 10 && id < 100) {
			switch (id % 10) {
			case 1:
				data = data + top + "timg" + 1 + butt + top + "timg" + 2 + butt + top + "timg" + 3 + butt;
				break;
			case 2:
				data = data + top + 21 + butt + top + 22 + butt + top + 23 + butt + top + 24 + butt;
				break;
			case 3:
				data = data + top + "timg" + 1 + butt;
				break;
			case 4:
				data = data + top + "timg" + 3 + butt;
				break;
			case 5:
				data = data + top + 2 + butt;
				break;
			}
		}
		return new JsonResult(data);
	}
}
