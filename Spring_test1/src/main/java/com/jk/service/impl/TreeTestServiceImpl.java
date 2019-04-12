package com.jk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.dao.PicUploadResult;
import com.jk.dao.TreeTestDao;
import com.jk.mapper.TreeTestMapper;
import com.jk.service.TreeService;

@Service
public class TreeTestServiceImpl implements TreeService {

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

	@Override
	public String findPhotoByIds(String id) {
		String htm = "";
		List<PicUploadResult> pics = treeTestMapper.fingPhotoById(id);
		if (pics.size() != 0) {
			for (PicUploadResult pic : pics) {
				String ids = pic.getUrl().substring(21, 53);
				htm = htm
						+ "<div style='margin-top:10px;width:20%;height:300px;border: 5px solid #E0E0E0; float: left;'><img src='"
						+ pic.getUrl() + "' name ='" + pic.getName() + "' id ='" + ids + "' onclick='openpic(" + '"'
						+ ids + '"' + ")'/></div>";
				;
			}
		}
		return htm;
	}

	@Override
	public String findPhotoBypId(String pId) {
		String htm = "";
		List<PicUploadResult> pics = treeTestMapper.fingPhotoBypId(pId);
		if (pics.size() != 0) {
			for (PicUploadResult pic : pics) {
				String id = pic.getUrl().substring(21, 53);
				htm = htm
						+ "<div style='margin-top:10px;width:20%;height:300px;border: 5px solid #E0E0E0; float: left;'><img src='"
						+ pic.getUrl() + "' name ='" + pic.getName() + "' id ='" + id + "' onclick='openpic(" + '"' + id
						+ '"' + ")'/></div>";
				;
			}
		}
		return htm;
	}

	@Override
	public String findPhotoAll() {
		String htm = "";
		List<PicUploadResult> pics = treeTestMapper.fingPhotoAll();
		if (pics.size() != 0) {
			for (PicUploadResult pic : pics) {
				String id = pic.getUrl().substring(21, 53);
				htm = htm
						+ "<div style='margin-top:10px;width:20%;height:300px;border: 5px solid #E0E0E0; float: left;'><img src='"
						+ pic.getUrl() + "' name ='" + pic.getName() + "' id ='" + id + "' onclick='openpic(" + '"' + id
						+ '"' + ")'/></div>";
				;
			}
		}
		return htm;
	}

}
