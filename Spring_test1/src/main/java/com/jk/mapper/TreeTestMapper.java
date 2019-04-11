package com.jk.mapper;

import java.util.List;

import com.jk.dao.PicUploadResult;
import com.jk.dao.TreeTestDao;

public interface TreeTestMapper {

	List<TreeTestDao> findTreeTest();

	int updatezTree(TreeTestDao tree);

	List<PicUploadResult> fingPhotoById(String id);

	List<PicUploadResult> fingPhotoBypId(String pId);

	List<PicUploadResult> fingPhotoAll();
}
