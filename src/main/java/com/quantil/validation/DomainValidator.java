package com.quantil.validation;

import net.thucydides.core.annotations.Step;

import org.junit.Assert;

import com.mileweb.sdk.cloudcdn.model.Domain;
import com.quantil.exceptions.TestInitializationException;
import com.quantil.global.TestData;
import com.quantil.global.TestDataKey;

public class DomainValidator {

	@Step
	public void isEnabled() throws TestInitializationException {
		
		Domain domain = TestData.get(TestDataKey.DOMAIN.getValue(), Domain.class);
		
		Assert.assertTrue("Domain is not enabled", domain.isEnabled());
	}
	
	@Step
	public void isDisabled() throws TestInitializationException {
		
		Domain domain = TestData.get(TestDataKey.DOMAIN.getValue(), Domain.class);
		
		Assert.assertTrue("Domain is not disabled", !domain.isEnabled());
	}
	
	@Step
	public void isRestored() throws TestInitializationException {
		
		Domain domain = TestData.get(TestDataKey.DOMAIN.getValue(), Domain.class);
		
		Assert.assertTrue("Domain is not enabled", domain.isEnabled());
	}
	
	@Step
	public void isCancelled() throws TestInitializationException {
		
		Domain domain = TestData.get(TestDataKey.DOMAIN.getValue(), Domain.class);
		
		Assert.assertTrue("Domain is not disabled", !domain.isEnabled());
	}
}
