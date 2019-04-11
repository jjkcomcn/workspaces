package com.jk.service;

import java.util.List;

import com.jk.dao.TreeTestDao;

public interface TreeService {

	public List<TreeTestDao> findTreeTest();

	public int updatezTree(TreeTestDao tree);

	public String findPhotoByIds(String id);

	public String findPhotoBypId(String pId);

	public String findPhotoAll();
}
