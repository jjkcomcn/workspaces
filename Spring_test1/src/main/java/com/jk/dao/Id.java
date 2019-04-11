package com.jk.dao;

public class Id {

	private String id;
	private String pId;

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Id [id=" + id + ", pId=" + pId + "]";
	}

}
