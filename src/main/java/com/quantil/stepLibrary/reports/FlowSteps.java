package com.quantil.stepLibrary.reports;

import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXB;

import com.quantil.client.http.APIHdtClient;
import org.junit.Assert;

import net.thucydides.core.annotations.Step;

import com.mileweb.sdk.cloudview.model.Timezone;
import com.quantil.client.http.APIFlowReportClient;
import com.quantil.entities.objectModel.reports.RangeFlowReport;
import com.quantil.entities.response.GenericResponse;
import com.quantil.exceptions.TestInitializationException;
import com.quantil.exceptions.ValidationException;
import com.quantil.global.TestData;
import com.quantil.global.TestDataKey;
import com.quantil.service.ProjectData;
import com.quantil.validation.ResponseValidator;

public class FlowSteps {

static APIFlowReportClient client;
	public static String xmlResponse = "";//den
	static {

		client = APIFlowReportClient.getClient(ProjectData.selectedAPIEndpoint);
	}

	@Step
	public void prepareTestData() {

		TestData.put(TestDataKey.SERVICE_TYPE.getValue(), ProjectData.serviceType);
		TestData.put(TestDataKey.DATE_FROM.getValue(), ProjectData.dateFrom);
		TestData.put(TestDataKey.DATE_TO.getValue(), ProjectData.dateTo);
		TestData.put(TestDataKey.RANGE_START.getValue(), ProjectData.rangeStart);
		TestData.put(TestDataKey.RANGE_END.getValue(), ProjectData.rangeEnd);
		TestData.put(TestDataKey.TIMEZONE.getValue(), ProjectData.timezone);
		TestData.put(TestDataKey.DOMAIN_ID.getValue(), ProjectData.domainId);//den
	}

	@Step
	public void swapDateRanges() throws TestInitializationException {

		String start = TestData.get(TestDataKey.RANGE_START.getValue(), String.class);
		String end = TestData.get(TestDataKey.RANGE_END.getValue(), String.class);

		TestData.put(TestDataKey.RANGE_START.getValue(), end);
		TestData.put(TestDataKey.RANGE_END.getValue(), start);
	}

	@Step
	public void rangeFlowReport() throws TestInitializationException, ValidationException {

		GenericResponse r = client.rangeFlowReport(TestData.get(TestDataKey.SERVICE_TYPE.getValue(), String.class),
													TestData.get(TestDataKey.DATE_FROM.getValue(), Date.class),
													TestData.get(TestDataKey.DATE_TO.getValue(), Date.class),
													TestData.get(TestDataKey.RANGE_START.getValue(), String.class),
													TestData.get(TestDataKey.RANGE_END.getValue(), String.class),
													TestData.get(TestDataKey.TIMEZONE.getValue(), Timezone.class));

		ResponseValidator.validateResponse(r);



		RangeFlowReport rep = JAXB.unmarshal(new StringReader(r.getXmlResult()), RangeFlowReport.class);

		if (!TestData.contains(TestDataKey.REPORT_DATA.getValue()))
			TestData.put(TestDataKey.REPORT_DATA.getValue(), rep);
		else
			TestData.put("repData2nd", rep);
	}

	@Step
	public void compareReportData() throws TestInitializationException {

		RangeFlowReport data1 = TestData.get(TestDataKey.REPORT_DATA.getValue(), RangeFlowReport.class);
		RangeFlowReport data2 = TestData.get("repData2nd", RangeFlowReport.class);

		Assert.assertTrue("Flow summary is not equal", data1.getFlowSummary().doubleValue() == data2.getFlowSummary().doubleValue());
//        Assert.assertTrue("Flow in range is not equal", data1.getFlowOutRange() == data2.getFlowOutRange());
//        Assert.assertTrue("flow out range is not equal", data1.getFlowInRange() == data2.getFlowInRange());
		Assert.assertTrue("Flow in range is not equal", data1.getFlowInRange() == data2.getFlowOutRange());//den
        Assert.assertTrue("flow out range is not equal", data1.getFlowOutRange() == data2.getFlowInRange());//den

	}

	@Step//den
	public void getRangeFlowReport() throws TestInitializationException, ValidationException {

		GenericResponse r = client.rangeFlowReport(TestData.get(TestDataKey.DATE_FROM.getValue(), Date.class),
				TestData.get(TestDataKey.DATE_TO.getValue(), Date.class),
				TestData.get(TestDataKey.RANGE_START.getValue(), String.class),
				TestData.get(TestDataKey.RANGE_END.getValue(), String.class));

		ResponseValidator.validateResponse(r);
		TestData.put("xmlResponse", r.getXmlResult());


	}

	@Step//den
	public void getRangeFlowReportWithFractions() throws TestInitializationException, ValidationException {

		DateFormat formatter = ProjectData.format;
		Random random = new Random();
		int secondsFractions = random.nextInt(999999999);
		String dateFr = formatter.format(ProjectData.dateFrom).replaceAll("\\+","."+secondsFractions+"%2B");
		String dateT = formatter.format(ProjectData.dateTo).replaceAll("\\+","."+secondsFractions+"%2B");

		GenericResponse r = client.rangeFlowReport(TestData.get(dateFr, String.class),
				TestData.get(dateT, String.class),
				TestData.get(TestDataKey.RANGE_START.getValue(), String.class),
				TestData.get(TestDataKey.RANGE_END.getValue(), String.class));

		ResponseValidator.validateResponse(r);
		TestData.put("xmlResponse", r.getXmlResult());

//		RangeFlowReport rep = JAXB.unmarshal(new StringReader(r.getXmlResult()), RangeFlowReport.class);

	}

	@Step//den
	public void getDomainRangeFlowReport() throws TestInitializationException, ValidationException{

		try {

			GenericResponse r = client.rangeFlowReport(TestData.get(TestDataKey.DOMAIN_ID.getValue(), String.class),
					TestData.get(TestDataKey.DATE_FROM.getValue(), Date.class),
					TestData.get(TestDataKey.DATE_TO.getValue(), Date.class),
					TestData.get(TestDataKey.RANGE_START.getValue(), String.class),
					TestData.get(TestDataKey.RANGE_END.getValue(), String.class));

			ResponseValidator.validateResponse(r);

			TestData.put("xmlResponse", r.getXmlResult());
		} catch (Exception ex) {
			Assert.fail(ex.toString());
		}
	}

	@Step//den
	public void responseContain(String content) throws TestInitializationException, ValidationException {

		Assert.assertTrue(TestData.get("xmlResponse", String.class), TestData.get("xmlResponse", String.class).contains(content));
	}


}
