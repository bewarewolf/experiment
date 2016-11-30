package com.quantil.global;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.quantil.exceptions.TestInitializationException;
import com.quantil.experimental.model.TestStep;

public class TestData {

	static HashMap<String, Object> data;
	static TestStep currentStep;
	
	public static void init() {
		
		if (data == null) data = new HashMap<String, Object>();
		else data.clear();		
	}
	
	public static <T> T get(String key, Class<T> type) throws TestInitializationException {
		
		if (!data.containsKey(key))
			throw new TestInitializationException("Variable '" + key + "' was not provided");
		
		try {
			
			return type.cast(data.get(key));
			
		} catch (Exception ex) {
			
			throw new TestInitializationException("Mismatch in variable type. Expected: '" + type.getName() + 
					"; Actual: " + data.get(key).getClass().getName());
		}
	}
	
	
	public static boolean contains(String key) {
		
		return data.containsKey(key);
	}
	
	public static void put(String key, Object item) {
		
		if (data == null) data = new HashMap<String, Object>();
		
		data.put(key, item);
	}
	
	public static void putAll(Map<? extends String, ? extends Object> in) {
		
		if (data == null) data = new HashMap<String, Object>();
		
		data.putAll(in);
	}

	public static TestStep getCurrentStep() {
		return currentStep;
	}

	public static void setCurrentStep(TestStep currentStep) {
		TestData.currentStep = currentStep;
		putAll(currentStep.getData().getAll());
	}
}
