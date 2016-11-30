package com.quantil.runners;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import java.lang.reflect.Method;
import java.util.ArrayList;
import org.junit.Test;

public class MethodScanner {

    private final EnvironmentVariables environmentVariables;

    public MethodScanner(EnvironmentVariables environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    public boolean shouldRunClass(Class<?> testClass) {
        List<TestName> expectedNames = expectedNames();

        if (expectedNames.isEmpty()) {
            return true;
        } else {
            return testClassInList(testClass, expectedNames);
        }
    }

    public boolean shouldRunMethod(Class<?> testClass, String methodName) {
        List<TestName> expectedNames = expectedNames();

        if (expectedNames.isEmpty()) {
            return true;
        } else {
            return testMethodInList(testClass, methodName, expectedNames);
        }
    }

    private boolean testClassInList(Class<?> testClass, List<TestName> expectedNames) {
        TestName tn = new TestName(testClass.getSimpleName(), new String());
        return expectedNames.contains(tn);
    }

    private boolean testMethodInList(Class<?> testClass, String methodName, List<TestName> expectedNames) {
        TestName tn = new TestName(testClass.getSimpleName(), methodName);
        TestName classTn = new TestName(testClass.getSimpleName(), new String());
        //System.out.println("Test name: " + tn);
        return expectedNames.contains(tn) || expectedNames.contains(classTn);
    }

    private boolean tagsMatch(List<TestName> expectedTags, List<TestName> tags) {
        for (TestName expectedTag : expectedTags) {
            
            if (tags.contains(expectedTag)) {
                return true;
            }
        }
        return false;
    }

    private List<TestName> getTestsForClass(Class<?> testClass) {
        
        List<TestName> out = new ArrayList();
        
        for (Method m : testClass.getMethods()) {
            
            if (m.getAnnotation(Test.class) != null) {
                
                out.add(new TestName(testClass.getSimpleName(), m.getName()));
            }
        }
        
        return out;
    }
    
    private List<TestName> expectedNames() {
        String testListValue = environmentVariables.getProperty("thucydides.tests_to_run");
        
        //System.out.println("===================\n" + testListValue);
        
        if (StringUtils.isNotEmpty(testListValue)) {
            List<String> classList = Lists.newArrayList(Splitter.on(",").trimResults().split(testListValue));
            
            List<TestName> out = new ArrayList<>();
            
            for (String klass : classList) {
                
                if (klass.contains("#")) {
                    
                    String[] class_test = klass.split("#");                
                                
                    for (String test : class_test[1].split("\\+")) {

                        out.add(new TestName(class_test[0], test));
                    }
                } else {
                    out.add(new TestName(klass, new String()));
                }                
            }
            
//            for (TestName t : out) {
//                
//                System.out.println(t.toString());
//            }
            
            return out;
        } else {
            return Lists.newArrayList();
        }
    }

    private class TestName implements Comparable<TestName> {
        
        private String className;
        private String testName;

        public TestName() {}
        
        public TestName(String className, String testName) {
            this.className = className;
            this.testName = testName;
        }

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public String getTestName() {
            return testName;
        }

        public void setTestName(String testName) {
            this.testName = testName;
        }
        
        @Override
        public int compareTo(TestName otherTag) {
            int typeComparison = getClassName().compareToIgnoreCase(otherTag.getClassName());
            if (typeComparison != 0) {
                return typeComparison;
            } else {
                return getTestName().compareToIgnoreCase(otherTag.getTestName());
            }
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TestName testTag = (TestName) o;

            if (!testName.equalsIgnoreCase(testTag.testName)) return false;

            return className.equalsIgnoreCase(testTag.className);
        }

    @Override
    public int hashCode() {
        int result = testName.toLowerCase().hashCode();
        result = 31 * result + className.toLowerCase().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + testName + '\'' +
                ", class='" + className + '\'' +
                '}';
    }
    }
}