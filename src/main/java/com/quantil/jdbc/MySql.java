package com.quantil.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Table;

/**
 *
 * @author plakhotnichenko
 */
public class MySql {
    
    private String connectionString;
    private Connection conn;
    
    public MySql(String strConn) {
        connectionString = strConn;
    }
    
    public void connect(String username, String password) 
    		throws SQLException {
        conn = DriverManager.getConnection(connectionString, username, password);
    }
    
    public Table<Integer, String, String> getDBData(String strQuery) 
    		throws Exception {        
        try {
        	Table<Integer, String, String> dbData = ArrayTable.create(new ArrayList<Integer>(), new ArrayList<String>());
        	            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(strQuery);

            ResultSetMetaData meta = rs.getMetaData();
            int cols = meta.getColumnCount();
            int rows = 0;
            
            while (rs.next()) {
                for (int i = 1; i <= cols; i++) {
                	dbData.put(rows, meta.getColumnName(i), rs.getString(i));
                }

                rows++;
            } 
            
            return dbData;
        } catch(SQLException ex) {
            throw new Exception(ex);
        }
    }
    
    public void executeUpdateStatement(String strStatement) 
    		throws Exception {
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(strStatement);
        } catch (SQLException ex) {
            throw new Exception(ex);
        }   
    }
    
    public void executeBatch(String... strStatement)
    		throws Exception {
        try {
            Statement stmt = conn.createStatement();
            for (String s : strStatement) {
                stmt.addBatch(s);
            }
            
            stmt.executeBatch();
        } catch (SQLException ex) {
            throw new Exception(ex);
        }   
    }
}

