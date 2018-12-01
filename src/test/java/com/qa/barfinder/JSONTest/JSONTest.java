package com.qa.barfinder.JSONTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.qa.persistence.domain.Bar;
import com.qa.util.JSONArrayConverter;
import com.qa.util.JSONConverter;
import com.qa.util.JSONUtil;

public class JSONTest {
	
	private String JSONArray = "[\r\n" + 
			"  {\r\n" + 
			"    \"fsa_id\": 240693,\r\n" + 
			"    \"name\": \"Anglesey Arms\",\r\n" + 
			"    \"address\": \"Halnaker, Boxgrove, West Sussex\",\r\n" + 
			"    \"postcode\": \"PO18 0NQ\",\r\n" + 
			"    \"easting\": 490846,\r\n" + 
			"    \"northing\": 108134,\r\n" + 
			"    \"latitude\": 50.865585,\r\n" + 
			"    \"longitude\": -0.710445,\r\n" + 
			"    \"local_authority\": \"Chichester\"\r\n" + 
			"  },\r\n" + 
			"  {\r\n" + 
			"    \"fsa_id\": 240709,\r\n" + 
			"    \"name\": \"Badgers Tavern\",\r\n" + 
			"    \"address\": \"Station Road, Petworth, West Sussex\",\r\n" + 
			"    \"postcode\": \"GU28 0JF\",\r\n" + 
			"    \"easting\": 497048,\r\n" + 
			"    \"northing\": 119162,\r\n" + 
			"    \"latitude\": 50.963717,\r\n" + 
			"    \"longitude\": -0.619411,\r\n" + 
			"    \"local_authority\": \"Chichester\"\r\n" + 
			"  },\r\n" + 
			"  {\r\n" + 
			"    \"fsa_id\": 240719,\r\n" + 
			"    \"name\": \"Barley Mow\",\r\n" + 
			"    \"address\": \"Breakneck Lane, Walderton, Chichester, West Sussex\",\r\n" + 
			"    \"postcode\": \"PO18 9ED\",\r\n" + 
			"    \"easting\": 479004,\r\n" + 
			"    \"northing\": 110627,\r\n" + 
			"    \"latitude\": 50.889736,\r\n" + 
			"    \"longitude\": -0.878145,\r\n" + 
			"    \"local_authority\": \"Chichester\"\r\n" + 
			"  },\r\n" + 
			"  {\r\n" + 
			"    \"fsa_id\": 240723,\r\n" + 
			"    \"name\": \"Basmati Restaurant\",\r\n" + 
			"    \"address\": \"Swan House, Market Square, Petworth, West Sussex\",\r\n" + 
			"    \"postcode\": \"GU28 0AH\",\r\n" + 
			"    \"easting\": 497651,\r\n" + 
			"    \"northing\": 121679,\r\n" + 
			"    \"latitude\": 50.986243,\r\n" + 
			"    \"longitude\": -0.610152,\r\n" + 
			"    \"local_authority\": \"Chichester\"\r\n" + 
			"  }\r\n" +
			"]";
	
	private String firstElementInJSONArray = "  {\r\n" + 
			"  \"fsa_id\": 240693,\r\n" + 
			"  \"name\": \"Anglesey Arms\",\r\n" + 
			"  \"address\": \"Halnaker, Boxgrove, West Sussex\",\r\n" + 
			"  \"postcode\": \"PO18 0NQ\",\r\n" + 
			"  \"easting\": 490846,\r\n" + 
			"  \"northing\": 108134,\r\n" + 
			"  \"latitude\": 50.865585,\r\n" + 
			"  \"longitude\": -0.710445,\r\n" + 
			"  \"local_authority\": \"Chichester\"\r\n" + 
			"}";
	
	private String firstElementFlattened = "{"
			+ "\"fsa_id\":240693,"
			+ "\"name\":\"Anglesey Arms\","
			+ "\"address\":\"Halnaker, Boxgrove, West Sussex\","
			+ "\"postcode\":\"PO18 0NQ\","
			+ "\"easting\":490846," 
			+ "\"northing\":108134,"
			+ "\"latitude\":50.865585," 
			+ "\"longitude\":-0.710445," 
			+ "\"local_authority\":\"Chichester\""
			+ "}";
	
	@Test
	public void FlattenTest() {
		JSONUtil gson = new JSONUtil();
		Bar testBar = new Bar("Anglesey Arms", "Halnaker, Boxgrove, West Sussex", "PO18 0NQ", 490846L, 108134L, 50.865585, -0.710445, "Chichester");
		testBar.setIdBar(240693L);
		JSONConverter jc = new JSONConverter(firstElementFlattened);
		assertEquals(jc.getString(), gson.toJSON(testBar));
		
	}
	
	@Test
	public void GSONTest() {
		JSONUtil gson = new JSONUtil();
		Bar testBar = new Bar("Anglesey Arms", "Halnaker, Boxgrove, West Sussex", "PO18 0NQ", 490846L, 108134L, 50.865585, -0.710445, "Chichester");
		testBar.setIdBar(240693L);
		JSONConverter jc = new JSONConverter(firstElementInJSONArray);
		assertEquals(gson.toJSON(testBar), jc.getString());
	}
	
	@Test
	public void JSONArrayTest() {
		JSONUtil gson = new JSONUtil();
		Bar testBar = new Bar("Anglesey Arms", "Halnaker, Boxgrove, West Sussex", "PO18 0NQ", 490846L, 108134L, 50.865585, -0.710445, "Chichester");
		testBar.setIdBar(240693L);
		JSONArrayConverter jc = new JSONArrayConverter(JSONArray);
		assertEquals(gson.toJSON(testBar), jc.getString(0));
	}
	
	@Test
	public void JSONArraySizeTest() {
		JSONArrayConverter jc = new JSONArrayConverter(JSONArray);
		assertEquals(4, jc.size());
	}

}
