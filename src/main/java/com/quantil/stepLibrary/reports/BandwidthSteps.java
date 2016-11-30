package com.quantil.stepLibrary.reports;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;

import com.quantil.client.http.APIBandwidthReportClient;
import com.quantil.entities.response.GenericResponse;
import com.quantil.exceptions.TestInitializationException;
import com.quantil.exceptions.ValidationException;
import com.quantil.global.TestData;
import com.quantil.service.ProjectData;
import com.quantil.validation.ResponseValidator;

import net.thucydides.core.annotations.Step;

public class BandwidthSteps {

	static APIBandwidthReportClient client;

	static {

		client = APIBandwidthReportClient.getClient(ProjectData.selectedAPIEndpoint);
	}

	@Step
	public void allDomainsBandwidthReport() throws ValidationException {

		GenericResponse r = client.allDomainsBandwidthReport();
		//System.out.println(r);
		ResponseValidator.validateResponse(r);
	}

	@Step
	public void flowAlldomainsTest() throws TestInitializationException, ValidationException {

		Date dateFrom = TestData.get("dateFrom", Date.class);
		Date dateTo = TestData.get("dateTo", Date.class);

		GenericResponse r = client.allDomainsBandwidthReport();
		System.out.println(r);
		ResponseValidator.validateResponse(r);
	}
}
