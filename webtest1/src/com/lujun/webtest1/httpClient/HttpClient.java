package com.lujun.webtest1.httpClient;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/client")
public class HttpClient {

	@Qualifier("restTemplate")
	private RestTemplate restTemplate;
	
	@RequestMapping("/str")
	@ResponseBody
	public String testGetStr(){
		String url="http://localhost:8080/webtest1/api/str?id={id}";
				//PropertyUtils.read("common", "getListUrl");
		String result = null;
		restTemplate = new RestTemplate();
		String id = "1";
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			result = restTemplate.getForObject(url, String.class,id);
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		System.out.println(String.format("OK,rest success, result is %s", result));
		return result;
	}
}
