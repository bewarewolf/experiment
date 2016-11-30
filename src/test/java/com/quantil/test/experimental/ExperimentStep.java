package com.quantil.test.experimental;

import java.lang.reflect.InvocationTargetException;

import org.apache.logging.log4j.Logger;

import com.quantil.global.TestData;
import com.quantil.runners.QuantilTestRunner;

import net.thucydides.core.annotations.Step;

public class ExperimentStep {

	static Logger LOG = QuantilTestRunner.LOG;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Step
	public void run() throws Exception {

		String methName = TestData.getCurrentStep().getFramework_method();
		String className = methName.substring(0, methName.lastIndexOf("."));

		try {

			Class stepClass = Class.forName(className);

			Object inv = stepClass.newInstance();

			java.lang.reflect.Method method = stepClass.getMethod(methName.substring(methName.lastIndexOf(".") + 1));

			method.invoke(inv, new Object[0]);
		} catch (InvocationTargetException x) {
		    Throwable cause = x.getCause();
		    LOG.error(cause.getMessage());
		    throw new Exception(cause);
		}
	}
}
