package com.qa.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class JSONArrayConverter {

	private JsonParser parser;
	private JsonArray jsonArray;
	private Gson gson;

	public JSONArrayConverter(String prettyJsonString) {
		this.parser = new JsonParser();
		this.jsonArray = parser.parse(this.replace("fsa_id", "idBar", prettyJsonString)).getAsJsonArray();
		this.gson = new GsonBuilder().setLenient().create();
	}
	
	public String getArrayString() {
		return gson.toJson(jsonArray);
	}
	
	public String getString(int i) {
		return gson.toJson(jsonArray.get(i));		
	}

	public int size() {
		return jsonArray.size();
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
