package com.lujun.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.cxf.transport.servlet.CXFServlet;

public class Util {

	private static final int FILE_SIZE = 16 * 1024;

	// 写入文件时候用到的函数
	public static void upLoadFile(File source, File target) {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(source), FILE_SIZE);
			out = new BufferedOutputStream(new FileOutputStream(target),
					FILE_SIZE);
			// in-->image-->out
			byte[] image = new byte[FILE_SIZE];
			while (in.read(image) > 0) {
				out.write(image);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		CXFServlet cxfServlet = new CXFServlet();
	}

}
