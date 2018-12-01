package com.qa.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSONConverter {
	
	private JsonParser parser;
	private JsonObject jsonObject;
	private Gson gson;

	public JSONConverter(String prettyJsonString) {
		this.parser = new JsonParser();
		this.jsonObject = parser.parse(this.replace("fsa_id", "idBar",prettyJsonString)).getAsJsonObject();
		this.gson = new GsonBuilder().setLenient().create();
	}
	
	public String getString() {
		return gson.toJson(jsonObject);
	}
	
	public String replace(String removeThis, String addThis, String input) {
		int rtl = removeThis.length();
		int start=0;
		int end=rtl;
		StringBuilder output=new StringBuilder();
		while(end<input.length()) {
			String tracker=input.substring(start, end);
			if(tracker.equals(removeThis)) {
				output.append(addThis);
				start+=rtl;
				end+=rtl;
			} else {
				output.append(input.charAt(start));
				start++;
				end++;
			}
		}
		while(start<input.length()) {
			output.append(input.charAt(start));
			start++;
		}
		return output.toString();
	}
}
