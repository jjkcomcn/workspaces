package com.jk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.dao.Id;
import com.jk.dao.TreeTestDao;
import com.jk.service.TreeService;

@Controller
@RequestMapping("/")
public class ZTreeController {

	@Autowired
	private TreeService treeServide;

	/**
	 * 加载首页
	 * 
	 * @return
	 */
	@RequestMapping("dozTree")
	public String dozTree() {
		return "zTree";
	}

	/**
	 * 获取初始树数据
	 * 
	 * @return
	 */
	@RequestMapping("doZnodes")
	@ResponseBody
	public JsonResult getZnodes() {
		List<TreeTestDao> findTreeTest = treeServide.findTreeTest();
		return new JsonResult(findTreeTest);
	}

	/**
	 * 访问树修改页面
	 * 
	 * @return
	 */
	@RequestMapping("findTreeList")
	public String findTreeList() {
		return "treeUpdate";
	}

	@RequestMapping("model")
	public String doModel() {
		return "model";
	}

	/**
	 * 修改树数据
	 * 
	 * @param tree
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("updatezTree")
	@ResponseBody
	public JsonResult updatezTree(TreeTestDao tree) throws Exception {
		tree.setName(new String(tree.getName().getBytes("ISO-8859-1"), "utf-8"));
		int updatezTree = treeServide.updatezTree(tree);
		if (updatezTree == 1) {
			return new JsonResult("update ok");
		}
		return new JsonResult("update error");

	}

	@RequestMapping("doGetStr")
	@ResponseBody
	public JsonResult doGetStr(Id data) {
		String ht;
		if (!(StringUtils.isEmpty(data.getId()))) {
			String id = data.getId();
			ht = treeServide.findPhotoByIds(id);
		} else {
			String pId = data.getpId();
			if ("1".equals(pId)) {
				ht = treeServide.findPhotoAll();
			} else {
				ht = treeServide.findPhotoBypId(pId);
			}
		}
		return new JsonResult(ht);
	}
}
