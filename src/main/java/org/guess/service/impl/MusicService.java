package org.guess.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.guess.util.MusicXMLParser;

@Path("Music")
public class MusicService {

	@Path("queryMusic")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String queryMusic(@Context HttpServletRequest request) {
		
		String name = request.getParameter("mName");
		System.out.println(name);
		try {
			HttpURLConnection huc;
			huc = (HttpURLConnection) new URL(
					"http://box.zhangmen.baidu.com/x?op=12&count=1&title="+name+"$$")
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
			System.out.println(MusicXMLParser.getPath(temp.toString()));
			is.close();
			reader.close();
			return MusicXMLParser.getPath(temp.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
