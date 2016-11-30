package com.quantil.ssh;

import java.io.File;

import org.apache.logging.log4j.Logger;

import com.quantil.runners.QuantilTestRunner;
import com.quantil.service.ProjectData;

public class ReportDeployer {

	static Logger LOG = QuantilTestRunner.LOG;
	
	public static void main(String[] args) {
		
		LOG.info("Preparing reports to deploy on VM");
		
		try {
			
			File in = new File(args[0]).getCanonicalFile();
			File out = new File(args[1]).getCanonicalFile();
			
			SshClient cli = new SshClient(ProjectData.mwtrialEp, ProjectData.mwtrialUser, ProjectData.mwtrialPass);
						
			if (out.exists()) out.delete();		
		
			Zip.zipDir(in, out);			
			
			LOG.info("Deploying reports");
					
			
			cli.executeCommand("rm -r " + ProjectData.mwtrialLocation + "/*");
			
			LOG.info(cli.sendFile(out));
			
			LOG.info("Unzipping");
			
			cli.executeCommand("unzip " + ProjectData.mwtrialLocation + "/" + out.getName() + " -d " + ProjectData.mwtrialLocation);
			
			LOG.info("Done");
			LOG.info("Test reports are available on http://mwtrial.info/thucydides");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
	}
}
