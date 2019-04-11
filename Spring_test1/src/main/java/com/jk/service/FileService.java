package com.jk.service;

import org.springframework.web.multipart.MultipartFile;

import com.jk.dao.PicUploadResult;

public interface FileService {
	PicUploadResult UploadFile(MultipartFile uploadFile, String id, String pId, String name);

}
