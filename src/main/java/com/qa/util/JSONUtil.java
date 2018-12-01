package com.qa.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONUtil {

	private Gson gson;

	public JSONUtil() {
		this.gson = new GsonBuilder().setLenient().create();
	}

	public String toJSON(Object obj) {
		return gson.toJson(obj);
	}

	public <T> T fromJSON(String jsonString, Class<T> clazz) {
		return gson.fromJson(jsonString, clazz);
	}

}
