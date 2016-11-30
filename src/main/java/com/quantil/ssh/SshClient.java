package com.quantil.ssh;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;

import org.apache.logging.log4j.Logger;

import com.jcabi.ssh.SSHByPassword;
import com.jcabi.ssh.Shell;
import com.quantil.runners.QuantilTestRunner;
import com.quantil.service.ProjectData;

public class SshClient {

	String endpoint;
	String username;
	String password;
	
	Shell ssh;
	
	static Logger LOG = QuantilTestRunner.LOG;
	
	public SshClient(String endpoint, String username, String password) throws UnknownHostException {
		super();
		this.endpoint = endpoint;
		this.username = username;
		this.password = password;
		
		ssh = new Shell.Safe(
				  new SSHByPassword(
						  endpoint, 22,
						  username, password
				  )
				);
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String executeCommand(String cmd) {
		
		try {
			return new Shell.Plain(ssh).exec(cmd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LOG.error(e);
			return e.getMessage();
		}
	}
	
	public String sendFile(File file) {
	
	try {
		
		ssh.exec("cat > " + ProjectData.mwtrialLocation + "/" + file.getName(), 
				new FileInputStream(file), 
				null, 
				null);
		
		return "success";
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return e.getMessage();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return e.getMessage();
	}
	
	
	}
}
