package com.quantil.experimental.model;

import java.util.ArrayList;
import java.util.List;

import com.quantil.annotations.Environment;

public class Test {

	int test_id;
	String test_name;
	String test_description;
	String area;
	String environment;
	
	List<TestStep> steps;
	
	TestStatus status;
	String message;

	public Test() {
		
		steps = new ArrayList<TestStep>();
	}
	
	public int getTest_id() {
		return test_id;
	}

	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}

	public String getTest_name() {
		return test_name;
	}

	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}

	public String getTest_description() {
		return test_description;
	}

	public void setTest_description(String test_description) {
		this.test_description = test_description;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	public void addStep(TestStep step) {
		
		steps.add(step);
	}
	
	public List<TestStep> getSteps() {
		
		return steps;
	}
}
