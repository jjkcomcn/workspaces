package com.jk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.dao.TreeTestDao;
import com.jk.mapper.TreeTestMapper;
import com.jk.service.TreeService;

@Service
public class TreeTestServiceImpl implements TreeService{
	
	@Autowired
	private TreeTestMapper treeTestMapper;

	@Override
	public List<TreeTestDao> findTreeTest() {
		List<TreeTestDao> findTreeTest = treeTestMapper.findTreeTest();
		return findTreeTest;
	}

	@Override
	public int updatezTree(TreeTestDao tree) {
		int up = treeTestMapper.updatezTree(tree);
		return up;
	}

}
