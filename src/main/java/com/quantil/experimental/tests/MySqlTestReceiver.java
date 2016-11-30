package com.quantil.experimental.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Dictionary;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.quantil.experimental.model.InputData;
import com.quantil.experimental.model.Test;
import com.quantil.experimental.model.TestStep;
import com.quantil.annotations.Environment;

/**
 *
 * @author plakhotnichenko
 */
public class MySqlTestReceiver {
    
    private String connectionString;
    private Connection conn;
    
    public MySqlTestReceiver(String strConn)
    {
        connectionString = strConn;
    }
    
    public void connect(String username, String password) throws SQLException
    {
        conn = DriverManager.getConnection(connectionString, username, password);
    }
    
    public List<Test> getTests() throws Exception {
    	
    	List<Test> out = new ArrayList<Test>();
    	
    	List<HashMap<String, String>> tests = getDBData("select * from test");
    	
    	for (HashMap<String, String> testRec : tests) {
    		
    		String testId = testRec.get("test_id");
    		
    		Test t = new Test();
    		t.setArea(testRec.get("area"));
    		t.setEnvironment(testRec.get("environment"));
    		t.setTest_description(testRec.get("test_description"));
    		t.setTest_id(Integer.valueOf(testId));
    		t.setTest_name(testRec.get("test_name"));
    		
    		List<HashMap<String, String>> steps = getDBData("select * from test_step where test_id = " + testId);
    		
    		for (HashMap<String, String> stepRec : steps) {
    			
    			String stepId = stepRec.get("step_id");
    			
    			TestStep step = new TestStep();
    			step.setFramework_method(stepRec.get("framework_method"));
    			step.setStep_description(testRec.get("step_description"));
    			step.setStep_id(Integer.valueOf(stepId));
    			step.setStep_name(stepRec.get("step_name"));
    			step.setTest_id(Integer.valueOf(testId));
    			
    			List<HashMap<String, String>> input = getDBData("select * from input_data where step_id = " + stepId);
    			
    			InputData i = new InputData();
    			
    			for (HashMap<String, String> inputRec : input) {
    				
    				String className = inputRec.get("type");
    				String var = inputRec.get("var_name");
    				
    				Class c = Class.forName(className);
    				
    				if (className.contains("Date")) {
    					
    					DateFormat format = new SimpleDateFormat("yyyy-MM-ddHH:mm:ssZ");
    					i.put(var, format.parse(inputRec.get("data")));
    				}
    					//i.put(var, format.parse("2016-02-01"));
    			}
    			
    			step.setData(i);
    			
    			t.addStep(step);
    		}
    		
    		out.add(t);
    	}
    	
    	return out;
    }
    
    public List<HashMap<String, String>> getDBData(String strQuery) throws Exception
    {
        
        try
        {
            List<HashMap<String, String>> out = new ArrayList();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(strQuery);

            ResultSetMetaData meta = rs.getMetaData();
            int cols = meta.getColumnCount();
            while (rs.next()) {

                HashMap<String, String> dict = new HashMap();
                for (int i = 1; i <= cols; i++)
                {
                    dict.put(meta.getColumnName(i), rs.getString(i));
                }
                out.add(dict);
            } 
            
            return out;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            throw new Exception(ex);
        }
    }
    
    public void executeUpdateStatement(String strStatement) throws Exception
    {
        try
        {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(strStatement);
        }
        catch (SQLException ex)
        {
            throw new Exception(ex);
        }   
    }
    
    public void executeBatch(String... strStatement) throws Exception
    {
        try
        {
            Statement stmt = conn.createStatement();
            for (String s : strStatement) {
                stmt.addBatch(s);
            }
            
            stmt.executeBatch();
        }
        catch (SQLException ex)
        {
            throw new Exception(ex);
        }   
    }
}