function pulishBlog() {

	// 清空
	$("#content").empty();
	// 获取节点
	var body = document.getElementById("content");
	// 第一个div
	var d1 = document.createElement("div");
	var h1 = document.createElement("h2");
	var input = document.createElement("input");

	h1.setAttribute("style", "color: blue");
	h1.innerHTML = "标题";

	input.setAttribute("type", "text");
	input.setAttribute("name", "title");
	input.setAttribute("style",
			"width: 600px; height: 30px; font-size: 25px;color: red");
	input.setAttribute("id", "title");

	d1.appendChild(h1);
	d1.appendChild(input);

	body.appendChild(d1);

	// 第二个div
	var d2 = document.createElement("div");
	var h2 = document.createElement("h2");
	var text = document.createElement("textarea");

	d2.setAttribute("style", "margin-top: 50px");

	h2.setAttribute("style", "color: blue");
	h2.innerHTML = "内容";

//	text.setAttribute("rows", "20");
//	text.setAttribute("cols", "60");
	text.setAttribute("style",
			"width: 600px; height: 400px; font-size: 25px;color: pink");
	text.setAttribute("id", "cont");

	d2.appendChild(h2);
	d2.appendChild(text);

	body.appendChild(d2);

	// 第三个div
	var d3 = document.createElement("div");
	var button = document.createElement("button");

	d3.setAttribute("style", "margin-top: 50px");

	button.setAttribute("class", "btn btn-primary");
	button.setAttribute("id", "submit");
	button.setAttribute("onclick", "javascript:saveBlog()");
	button.innerHTML = "提交";

	d3.appendChild(button);

	body.appendChild(d3);

	return false;
}

function saveBlog() {

	var title = $("#title").val();
	var content = $("#cont").val();
	$.ajax({
		url : 'rest/Blog/saveBlog',
		type : 'POST',
		data : {
			"title" : title,
			"content" : content
		},
		success : function(id) {
			alert("添加成功");
			window.location.href="/blog/showblog.html?id="+id;
		}
	});
}
