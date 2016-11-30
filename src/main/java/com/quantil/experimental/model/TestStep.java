package com.quantil.experimental.model;

public class TestStep {

	int step_id;
	int test_id;
	String step_name;
	String step_description;
	String framework_method;
	
	InputData data;
	
	TestStatus status;
	String message;

	public int getStep_id() {
		return step_id;
	}

	public void setStep_id(int step_id) {
		this.step_id = step_id;
	}

	public int getTest_id() {
		return test_id;
	}

	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}

	public String getStep_name() {
		return step_name;
	}

	public void setStep_name(String step_name) {
		this.step_name = step_name;
	}

	public String getStep_description() {
		return step_description;
	}

	public void setStep_description(String step_description) {
		this.step_description = step_description;
	}

	public String getFramework_method() {
		return framework_method;
	}

	public void setFramework_method(String framework_method) {
		this.framework_method = framework_method;
	}

	public InputData getData() {
		return data;
	}

	public void setData(InputData data) {
		this.data = data;
	}
	
	
}
