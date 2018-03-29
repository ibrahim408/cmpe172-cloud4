package com.Weather.Services;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import com.Weather.Entities.Root;
import com.google.gson.*;

public class OWMService {
	private static final String appid="884300434e6f86e64102db6d13434312";
	private static final String baseUrl = "http://api.openweathermap.org/data/2.5/weather?q=";
	
	public static Root getWeatherInfo(String cityName) {
		String jsonResult = getWeatherJsonString(cityName);
		Root weatherInfoObject = toEntity(jsonResult);
		return weatherInfoObject;
	}
	
	private static Root toEntity(String jsonString) {
		try {
			Gson gson = new GsonBuilder().create();
			Root weatherInfo = gson.fromJson(jsonString, Root.class);
			return weatherInfo;
		} catch (JsonSyntaxException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	private static String getWeatherJsonString(String cityName) throws RuntimeException {
		String urlDefault = baseUrl + "London";
		try {
			if (cityName != null && cityName != "") {
				urlDefault = baseUrl + URLEncoder.encode(cityName, "utf-8");
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		StringBuilder strBuf = new StringBuilder();
		HttpURLConnection conn = null;
		BuffferedReader reader = null;
		try {
			URL url = new URL(urlDefault);
			conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("appid", appid);
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("HTTP GET Request Failed with Error code : " + conn.getResponseCode());
			}
			
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			String output = null;
			while ((output = reader.readLine()) != null) {
				strBuf.append(output);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (conn != null) {
					conn.disconnect();
				}
			}
		}
		return strBuf.toString();
	}
}
