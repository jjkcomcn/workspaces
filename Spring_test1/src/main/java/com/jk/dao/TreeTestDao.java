package com.jk.dao;

import java.io.Serializable;

public class TreeTestDao implements Serializable {
	private static final long serialVersionUID = 6804508030379452306L;
	String id;
	String pId;
	String name;
	String open;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	@Override
	public String toString() {
		return "TreeTestDao [id=" + id + ", pId=" + pId + ", name=" + name + ", open=" + open + "]";
	}
}
