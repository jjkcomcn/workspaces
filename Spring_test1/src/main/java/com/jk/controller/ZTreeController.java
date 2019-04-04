package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class ZTreeController {

	@RequestMapping("dozTree")
	public String dozTree() {
		return "zTree";
	}

	@RequestMapping("doZnodes")
	@ResponseBody
	public JsonResult getZnodes() {
		String nodes = "[{\"name\":\"父节点1 - 展开\",\"open\":\"true\",\"children\":[{\"name\":\"父节点11 - 折叠\",\"children\":[{\"name\":\"叶子节点111\"},{\"name\":\"叶子节点112\"},{\"name\":\"叶子节点113\"},{\"name\":\"叶子节点114\"}]}]},{\"name\":\"父节点2 - 没有子节点\",\"isParent\":\"true\"},{\"name\":\"父节点3 - 没有子节点\",\"isParent\":\"true\"}]";
		return new JsonResult(nodes);
	}
}
