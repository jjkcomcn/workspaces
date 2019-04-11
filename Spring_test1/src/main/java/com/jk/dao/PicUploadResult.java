package com.jk.dao;

public class PicUploadResult {
	private Integer error = 0; // 图片上传错误不能抛出，抛出就无法进行jsp页面回调，所以设置这个标识，0表示无异常，1代表异常
	private String id;
	private String pId;
	private String name;
	private String url;
	private String width;
	private String height;

	public Integer getError() {
		return error;
	}

	public void setError(Integer error) {
		this.error = error;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	@Override
	public String toString() {
		return "PicUploadResult [error=" + error + ", id=" + id + ", pId=" + pId + ", name=" + name + ", url=" + url
				+ ", width=" + width + ", height=" + height + "]";
	}

}
