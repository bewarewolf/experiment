package com.quantil.enums;

public enum TestPriority {

	P1 ("P1"),
	P2 ("P2"),
	P3 ("P3"),
	P4 ("P4"),
	REGRESSION ("REGRESSION");
	
	private String value;
	
	TestPriority(String value) {
		
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		
		return this.value;
	}
}
