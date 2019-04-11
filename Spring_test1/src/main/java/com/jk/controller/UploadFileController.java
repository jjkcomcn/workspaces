package com.jk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jk.dao.PicUploadResult;
import com.jk.service.FileService;

@Controller
@RequestMapping("/")
public class UploadFileController {

	@Autowired
	private FileService fileService;

	@RequestMapping("doUploadFile")
	public String fileUpload(@RequestParam(value = "file", required = false) MultipartFile uploadFile, String id,
			String pId, String name) {
		System.out.println(pId);
		PicUploadResult str = fileService.UploadFile(uploadFile, id, pId, name);
		if (str.getError() == 1) {
			return "error";
		}
		return "uploadok";
	}
}
