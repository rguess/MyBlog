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
			String url = p2p.asXML();
			String path = url.substring(url.indexOf("http://"), url.lastIndexOf("]]>"));
			System.out.println(path);
			return p2p.asXML();
		} catch (DocumentException e) {
			e.printStackTrace();
			return "xml error";
		}
	}
}
