package com.quantil.ssh;

import java.io.*;
import java.util.zip.*;

public class Zip {
   static final int BUFFER = 2048;
   
   public static void compress(File inFile, File outFile) {
      try {
         BufferedInputStream origin = null;
         FileOutputStream dest = new 
           FileOutputStream(outFile);
         ZipOutputStream out = new ZipOutputStream(new 
           BufferedOutputStream(dest));
         //out.setMethod(ZipOutputStream.DEFLATED);
         byte data[] = new byte[BUFFER];
         // get a list of files from current directory
         
         String files[] = inFile.list();

         for (int i=0; i<files.length; i++) {
            System.out.println("Adding: "+files[i]);
            FileInputStream fi = new 
              FileInputStream(files[i]);
            origin = new 
              BufferedInputStream(fi, BUFFER);
            ZipEntry entry = new ZipEntry(files[i]);
            out.putNextEntry(entry);
            int count;
            while((count = origin.read(data, 0, 
              BUFFER)) != -1) {
               out.write(data, 0, count);
            }
            origin.close();
         }
         out.close();
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   public static void zipDir(File inFile, File outFile) throws Exception {
	    //File dirObj = new File(dir);
	    ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outFile));
	    //System.out.println("Creating : " + outFile.getName());
	    addDir(inFile, out, "");
	    out.close();
	  }

	  static void addDir(File dirObj, ZipOutputStream out, String dirName) throws IOException {
	    File[] files = dirObj.listFiles();
	    byte[] tmpBuf = new byte[1024];

	    for (int i = 0; i < files.length; i++) {
	      if (files[i].isDirectory()) {
	        addDir(files[i], out, dirName + files[i].getName() + "/");
	        continue;
	      }
	      FileInputStream in = new FileInputStream(files[i]);
	      //System.out.println(" Adding: " + dirName + files[i].getName());
	      out.putNextEntry(new ZipEntry(dirName + files[i].getName()));
	      int len;
	      while ((len = in.read(tmpBuf)) > 0) {
	        out.write(tmpBuf, 0, len);
	      }
	      out.closeEntry();
	      in.close();
	    }
	  }
} 