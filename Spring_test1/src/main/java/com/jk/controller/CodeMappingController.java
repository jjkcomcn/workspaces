package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ck.dbo.Students;
import com.jk.codemapper.CodeMapperTools;
import com.jk.service.impl.ReaderFileImpl;

@Controller
@RequestMapping("/")
public class CodeMappingController {

    @RequestMapping("doReaderFile")
    public ModelAndView doSayHello() {
        // 方法code
        String code = "GDB01";
        // 数据库实体对象
        Class clazz = Students.class;
        // 方法实体对象
        Class clazd = ReaderFileImpl.class;
        // 文件路径
        String fileUrl = "D:\\shorttime\\1.txt";
        // 文件分割符
        String splitstr = "\\|";
        // 字段列表
        String[] names = { "Id", "Name", "Sex", "Adress", "InDate", "InTime", "UpDate", "UpTime" };
        Class[] clazzs = { clazd, Class.class, String.class, String.class, String[].class };
        Object[] strs = { code, clazz, fileUrl, splitstr, names };
        CodeMapperTools tools = new CodeMapperTools();
        Object result = tools.getResult(clazzs, strs);
        System.out.println(result);
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("message", result);
        return mv;
    }
}
