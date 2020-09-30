package com.cn.jjk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FileToolController {

    @RequestMapping("index")
    public String index() {
        return "getfile";
    }
}
