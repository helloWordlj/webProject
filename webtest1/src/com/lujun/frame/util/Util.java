package com.lujun.frame.util;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

public class Util {

	@Test
	public void getProp(){
		Properties prop = new Properties();
		InputStream in = Properties.class.getResourceAsStream("/"+"common"+".properties");
		try {
			prop.load(in);
		} catch (Exception e) {
			
		}
		System.out.println(prop.getProperty("path").trim());
	}
	
	//@Test
	public void createDir(){
		File file = new File("e:/LCT");
		if(!file.exists()){
			file.mkdir();
		}
		boolean flag=false;
		for(File f : file.listFiles()){
			if(f.getName().equals("aa")){
				flag=true;
				break;
			}
		}
		if(!flag){
			file = new File("aa");
			if(!file.exists()){
				file.mkdir();
			}
		}
	} 
}
