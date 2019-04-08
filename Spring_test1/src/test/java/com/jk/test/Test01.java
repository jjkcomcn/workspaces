package com.jk.test;

import java.util.ArrayList;
import java.util.Arrays;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Test01 {
	
	public static void main(String[] args) {		
		String arr[] = null;
		ArrayList<String> myList = new ArrayList<String>();		
		
		
		for(int i=1;i<5;i++){
			JSONObject jo = new JSONObject();
			jo.put("tId", i);
			jo.put("parentTId", "null");
			jo.put("name", "父节点"+i+" - 展开");
			jo.put("open", "true");
			jo.put("isParent", "true");
			myList.add(JSON.toJSONString(jo));			
			for(int j=1;j<4;j++){
				JSONObject jo1 = new JSONObject();
				jo1.put("tId",i+""+j);
				jo1.put("parentTId", "1");
				jo1.put("name", "子节点"+j+" - 展开");
				jo1.put("open", "true");
				jo1.put("isParent", "true");
				myList.add(JSON.toJSONString(jo1));
			}
		}
		
		arr = myList.toArray(new String[myList.size()]);
		String string = Arrays.toString(arr);
		System.out.println(string);
	}

}
