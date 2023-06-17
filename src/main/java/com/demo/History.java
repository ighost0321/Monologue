package com.demo;

import java.util.List;

public class History extends JsonResponseHead{
	
	private List<String> data;

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}
}
