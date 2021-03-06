package org.guess.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/weather")
public class WeatherService {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public String getWeather() {

		try {
			HttpURLConnection huc;
			huc = (HttpURLConnection) new URL(
					"http://m.weather.com.cn/data/101270101.html")
					.openConnection();
			huc.setRequestMethod("GET");
			huc.setUseCaches(true);
			huc.connect();
			InputStream is = huc.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(is));
			StringBuffer temp = new StringBuffer();
			String str;
			while ((str = reader.readLine()) != null) {
				temp.append(str + "\n");
			}
			System.out.println(temp.toString());
			is.close();
			reader.close();
			return temp.toString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
