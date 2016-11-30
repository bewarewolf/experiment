package com.quantil.stepLibrary;

import com.quantil.exceptions.TestInitializationException;
import com.quantil.global.TestData;

import net.thucydides.core.annotations.Step;

public class GenericSteps {

	@Step	
	public void description(String html) {
	    //do nothing
	}
	
	
	/**
	 * Generates description for test. Must be the 1st step in test method
	 * @param description - try to describe what the test does
	 * @param remarks - additional comments (e.g. input data details)
	 * @throws TestInitializationException 
	 */
	public void about(String description, String...remarks) throws TestInitializationException {
	    String html =
	    "<h2 style=\"font-style:italic;color:black\">" + description + "</h2>" +
	    "<div><p>Remarks:</p>" +
	    "<ul style=\"margin-left:5%; font-weight:200; color:#434343; font-size:10px;\">";

	    if (remarks != null)	    
	    	for (String li : remarks) html += "<li>" + li + "</li>";

	    html += "<ul></div>";
	    

	    description(html);
	}
}
