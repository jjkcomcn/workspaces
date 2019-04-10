package com.jk.service;

import java.util.List;

import com.jk.dao.TreeTestDao;

public interface TreeService {

	public List<TreeTestDao> findTreeTest();

	public int updatezTree(TreeTestDao tree);
}
