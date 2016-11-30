package com.quantil.experimental.model;

import java.util.HashMap;
import java.util.Map;

import com.quantil.exceptions.TestInitializationException;

public class InputData {

	HashMap<String, Object> data;
	
	public InputData() {
		
		data = new HashMap<String, Object>();
	}
	
	public <T> T get(String key, Class<T> type) throws TestInitializationException {
		
		if (!data.containsKey(key))
			throw new TestInitializationException("Variable '" + key + "' was not provided");
		
		try {
			
			return type.cast(data.get(key));
			
		} catch (Exception ex) {
			
			throw new TestInitializationException("Mismatch in variable type. Expected: '" + type.getName() + 
					"; Actual: " + data.get(key).getClass().getName());
		}
	}
	
	public void put(String key, Object item) {
		
		if (data == null) data = new HashMap<String, Object>();
		
		data.put(key, item);
	}
	
	public Map<String, Object> getAll() {
		
		return data;
	}
}
