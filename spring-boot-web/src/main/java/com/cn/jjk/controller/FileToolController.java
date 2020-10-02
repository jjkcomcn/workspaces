package com.cn.jjk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.jjk.dbo.Students;
import com.cn.jjk.service.impl.ReaderFileImpl;
import com.cn.jjk.tool.CodeMapperTools;

@Controller
@RequestMapping("/")
public class FileToolController {

    @RequestMapping("getfile")
    public String index() {
        return "getfile";
    }

    @SuppressWarnings("rawtypes")
    @RequestMapping("getString")
    @ResponseBody
    public JsonResult returnResult() {
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
        // 返回赋值
        return new JsonResult("this is ok!", new CodeMapperTools().getResult(clazzs, strs));
    }
}
