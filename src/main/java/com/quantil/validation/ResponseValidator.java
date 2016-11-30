package com.quantil.validation;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.quantil.entities.response.GenericResponse;
import com.quantil.exceptions.ValidationException;
import com.quantil.runners.QuantilTestRunner;

public class ResponseValidator {

	static Logger LOG = QuantilTestRunner.LOG;
	
	public static void validateResponse(GenericResponse resp) throws ValidationException {
		
		LOG.info("Validating response");
		
		if (!(resp.getStatusCode() == 200 || resp.getStatusCode() == 201 || resp.getStatusCode() == 202))
			throw new ValidationException(resp.toString());
	}
	
	public static void validateResponseFailed(GenericResponse resp) throws ValidationException {
		
		LOG.info("Validating response");
		
		if ((resp.getStatusCode() == 200 || resp.getStatusCode() == 201 || resp.getStatusCode() == 202))
			throw new ValidationException("Response was successfull");
	}
}
