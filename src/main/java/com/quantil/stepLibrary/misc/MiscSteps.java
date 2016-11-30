package com.quantil.stepLibrary.misc;

import java.io.StringReader;

import javax.xml.bind.JAXB;

import org.junit.Assert;

import net.thucydides.core.annotations.Step;

import com.quantil.client.http.APIMiscClient;
import com.quantil.client.sdk.SDKDomainClient;
import com.quantil.entities.objectModel.misc.IpCidrsList;
import com.quantil.entities.response.GenericResponse;
import com.quantil.entities.response.domain.DomainResponse;
import com.quantil.exceptions.TestInitializationException;
import com.quantil.global.TestData;
import com.quantil.global.TestDataKey;
import com.quantil.service.ProjectData;

public class MiscSteps {

static APIMiscClient client;

	static {

		client = APIMiscClient.getClient(ProjectData.selectedAPIEndpoint);
	}


	@Step
	public void queryCIDRs() {

		GenericResponse resp = client.getCacheIPList();

		IpCidrsList response = JAXB.unmarshal(new StringReader(resp.getXmlResult()), IpCidrsList.class);

		Assert.assertTrue("API returned empty response", !response.isEmpty());

		Assert.assertTrue("API returned incorrect data: " + resp.getXmlResult(), response.validate());
	}
}
