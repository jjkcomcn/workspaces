package com.cn.jjk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FileToolController {

    @RequestMapping("index")
    public void index() {
        System.out.println("前端已进入！");
    }
}
