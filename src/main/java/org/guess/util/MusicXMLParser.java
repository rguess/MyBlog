package org.guess.util;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 解析XML获取歌曲地址
 * @author guess
 *
 */
public class MusicXMLParser {

	public static String getPath(String xml) throws UnsupportedEncodingException{
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(new ByteArrayInputStream(xml.getBytes("UTF-8")));
			Element root = document.getRootElement();
			Element p2p = root.element("p2p");
			Element url = p2p.element("url");
			String u = p2p.asXML();
			String path = u.substring(u.indexOf("http://"), u.lastIndexOf("]]>"));
			System.out.println(path);
			return path;
		} catch (DocumentException e) {
			e.printStackTrace();
			return "xml error";
		}
	}
}
