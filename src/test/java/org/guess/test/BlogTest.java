package org.guess.test;

import java.util.Date;

import org.guess.util.TimeTools;
import org.junit.Test;

public class BlogTest {

//	@Test
//	public void test01() {
//
//		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
//				"classpath:applicationContext.xml");
//		BlogDao blogDao = context.getBean(BlogDao.class);
//		Blog blog = new Blog();
//		blog.setAuthor("guess");
//		
////		Date date = new Date();//获得系统时间.
////        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);//将时间格式转换成符合Timestamp要求的格式.
////        Timestamp goodsC_date = Timestamp.valueOf(nowTime);//把时间转换
//		
//		blog.setTime(TimeTools.getCurrentTimeNoSeconds());
//		blog.setTitle("Welcome to Sky Blue");
//		blog.setContent("This is Sky Blue, a standards-compliant CSS template designed by 100 Web Hosting. This web template is released under a Creative Commons Attribution 3.0 license, so you are free to use it for your website (even use it commercially) provided you keep the links in the footer intact. Other than that, you can customize it freely."
//				+ "If you plan to get a web hosting plan, make sure you check out 100 Web Hosting - an independent web hosting reviews, ratings and comparison resource.");
//		blogDao.saveBlog(blog);
//	}

	@Test
	public void test02() {
		java.sql.Date sqldate = new java.sql.Date(new Date().getTime());
		System.out.println(new Date().getTime());
		System.out.println(sqldate);
		System.out.println(new Date(System.currentTimeMillis()));
		
		System.out.println(TimeTools.getCurrentTimeNoSeconds());
		System.out.println(TimeTools.getCurrentDate());
	}
	
	@Test
	public void test03(){
		String str = "This is Sky Blue, a standards-compliant CSS template designed by 100 Web Hosting. This web template is released under a Creative Commons Attribution 3.0 license, so you are free to use it for your website (even use it commercially) provided you keep the links in the footer intact. Other than that, you can customize it freely."
				+ "If you plan to get a web hosting plan, make sure you check out 100 Web Hosting - an independent web hosting reviews, ratings and comparison resource.";
		System.out.println(str.length());
	}
}
