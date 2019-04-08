package com.jk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

		// for(int i=1;i<5;i++){
		// JSONObject jo = new JSONObject();
		// jo.put("id", i);
		// jo.put("pId", "null");
		// jo.put("name", "父节点"+i+" - 展开");
		// jo.put("open", "true");
		// jo.put("isParent", "true");
		// myList.add(JSON.toJSONString(jo));
		// for(int j=1;j<4;j++){
		// JSONObject jo1 = new JSONObject();
		// jo1.put("id",i+""+j);
		// jo1.put("pId", i+"");
		// jo1.put("name", "子节点"+j);
		// jo1.put("open", "false");
		// jo1.put("isParent", "false");
		// myList.add(JSON.toJSONString(jo1));
		// }
		// }
		//
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

	@RequestMapping(value = "updatezTree", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public JsonResult updatezTree(@RequestBody String tree) {
		System.out.println(tree.toString());
		return new JsonResult("update ok");
	}
}
