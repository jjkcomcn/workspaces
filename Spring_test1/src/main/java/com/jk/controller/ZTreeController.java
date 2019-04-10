package com.jk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.dao.TreeTestDao;
import com.jk.service.TreeService;

@Controller
@RequestMapping("/")
public class ZTreeController {

	@Autowired
	private TreeService treeServide;

	@RequestMapping("dozTree")
	public String dozTree() {
		return "zTree";
	}

	@RequestMapping("doZnodes")
	@ResponseBody
	public JsonResult getZnodes() {
		List<TreeTestDao> findTreeTest = treeServide.findTreeTest();
		return new JsonResult(findTreeTest);
	}

	@RequestMapping("findTreeList")
	public String findTreeList(Model model) {
		List<TreeTestDao> findTreeTest = treeServide.findTreeTest();
		model.addAttribute("findTreeTest", findTreeTest);
		return "treeUpdate";
	}

	@RequestMapping("model")
	public String doModel() {
		return "model";
	}

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
}
