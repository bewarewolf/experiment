package com.quantil.stepLibrary.domains;


import java.util.Random;

import com.quantil.client.sdk.SDKDomainClient;
import com.quantil.entities.response.domain.DomainSummaryListResponse;
import com.quantil.global.TestData;
import com.quantil.global.TestDataKey;
import com.quantil.service.ProjectData;

import net.thucydides.core.annotations.Step;

public class ListDomainsSteps {

	static SDKDomainClient client;

	static {

		client = SDKDomainClient.getClient(ProjectData.selectedAPIEndpoint);
	}

	@Step
	public void listDomains() {

		DomainSummaryListResponse resp = client.getDomainList();

		TestData.put("domainSummaryList", resp.getSummaryList());
	}

	@Step
	public void randomDomain() {

		//client = SDKDomainClient.getClient(ProjectData.selectedAPIEndpoint);

		DomainSummaryListResponse resp = client.getDomainList();

		Random r = new Random();

		int index = r.nextInt(resp.getSummaryList().size());

		TestData.put(TestDataKey.DOMAIN_ID.getValue(), resp.getSummaryList().get(index).getDomainId());

		TestData.put(TestDataKey.DOMAIN_NAME.getValue(), resp.getSummaryList().get(index).getDomainName());
	}
}
