package com.quantil.stepLibrary.domains;

import net.thucydides.core.annotations.Step;

import com.quantil.client.sdk.SDKDomainClient;
import com.quantil.entities.response.domain.DomainResponse;
import com.quantil.exceptions.TestInitializationException;
import com.quantil.global.TestData;
import com.quantil.global.TestDataKey;
import com.quantil.service.ProjectData;

public class CancelRestoreDomainSteps {

	static SDKDomainClient client;

	static {

		client = SDKDomainClient.getClient(ProjectData.selectedAPIEndpoint);
	}

	@Step
	public void cancelDomain() throws TestInitializationException {

		String domainId = TestData.get(TestDataKey.DOMAIN_ID.getValue(), String.class);

		DomainResponse resp = client.cancelDomain(domainId);
	}
}
