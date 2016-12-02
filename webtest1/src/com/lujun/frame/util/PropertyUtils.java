package com.lujun.frame.util;

import java.util.HashMap;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.junit.Test;

public class PropertyUtils {

	private static Map<String, ResourceBundle> props = new HashMap();

	  private static ResourceBundle getResource(String prop) {
	    return PropertyResourceBundle.getBundle(prop);
	  }

	  public static String read(String prop, String key) {
	    if (props.containsKey(prop)) {
	      return ((ResourceBundle)props.get(prop)).getString(key);
	    }
	    ResourceBundle bundle = getResource(prop);
	    props.put(prop, bundle);

	    return bundle.getString(key);
	  }
	  
	  @Test
	  public void test1(){
		  System.out.println(PropertyUtils.read("common", "path"));
	  }
}
