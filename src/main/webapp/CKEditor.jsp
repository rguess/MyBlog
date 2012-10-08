<%@page import="com.ckeditor.CKEditorConfig"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>编写博客</title>
<link href="/blog/css/bootstrap.css" rel="stylesheet" type="text/css"
	media="screen" />
</head>
<body style="background-color: #e5f4f8">
	<div class="container">
		<div style="margin-top: 50px">
		<form action="/blog/rest/ckeditor/save" method="post">
			<p>
				<label for="title">标题</label> <input type="text"
					name="title">
			</p>
			<p>
				<label for="editor1">正文内容</label>
				<textarea cols="50" id="editor1" name="editor1" rows="80"></textarea>
			</p>
			<p>
				<input type="submit" value="Submit" class="btn btn-primary"/>
			</p>
		</form>

		<%-- <%
		Map<String, String> attr = new HashMap<String, String>();
		attr.put("rows", "8");
		attr.put("cols", "50");
	%> --%>
		<%-- 	<%
	CKEditorConfig settings = new CKEditorConfig();
	List<Object> mainList = new ArrayList<Object>();				
	HashMap<String, Object> toolbarSectionMap = new HashMap<String, Object>();
	List<String> subList = new ArrayList<String>();
	subList.add("Source");
	subList.add("-");
	subList.add("NewPage");	
	toolbarSectionMap.put("name", "document");	
	toolbarSectionMap.put("items", subList);	
	mainList.add(toolbarSectionMap);		
	mainList.add("/");
	toolbarSectionMap = new HashMap<String, Object>();
	subList = new ArrayList<String>();
	subList.add("Styles");				
	subList.add("Format");
	toolbarSectionMap.put("name", "styles");
	toolbarSectionMap.put("items", subList);
	mainList.add(toolbarSectionMap);	
	settings.addConfigValue("toolbar", mainList);
%> --%>
		<%-- 	<ckeditor:editor textareaAttributes="<%= attr%>" basePath="/blog/ckeditor/"
		editor="editor"/> --%>
		<%-- <ckeditor:replace replace="editor1" basePath="/blog/ckeditor/" config="<%=settings %>"/> --%>
		<ckeditor:replace replace="editor1" basePath="/blog/ckeditor/" />
		</div>
	</div>
</body>
</html>