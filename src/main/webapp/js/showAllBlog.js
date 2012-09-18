function showAllBlog() {
	//清空
	$("#content").empty();
	//获取节点
	var body = document.getElementById("content");
	//创建节点
	var table = document.createElement("table");
	//设置table属性
	table.setAttribute("class", "table table-striped table-bordered table-condensed");
	//append入body
	//创建thead节点
	var thead = document.createElement("thead");
	//创建thead下tr节点
	var headTr = document.createElement("tr");
	//创建td节点
	for(var i = 0;i<3;i++){
		var td = document.createElement("th");
		headTr.appendChild(td);
	}
	//设置td中的值
	headTr.childNodes[0].innerHTML = "title";
	headTr.childNodes[1].innerHTML = "time";
	headTr.childNodes[2].innerHTML = "author";
	thead.appendChild(headTr);
	
	$.ajax({
		url : 'rest/Blog/listBlog',
		type : 'GET',
		success : function(meta) {
			var tbody = document.createElement("tbody");
			for(var i = 0;i<meta.length;i++){
				var tbodyTr = document.createElement("tr");
				for(var j = 0;j<3;j++){
					var td = document.createElement("td");
					//td.innerHTML = "head";
					tbodyTr.appendChild(td);
				}
				tbodyTr.childNodes[0].innerHTML = "<a href='showblog.html?id="+meta[i].id+"'>"+meta[i].title+"</a>";
				tbodyTr.childNodes[1].innerHTML = "<a href='#'>"+meta[i].time+"</a>";
				tbodyTr.childNodes[2].innerHTML = "<a href='#'>"+meta[i].author+"</a>";
				tbody.appendChild(tbodyTr);
			}
			table.appendChild(thead);
			table.appendChild(tbody);
			body.appendChild(table);
		}
	});
	
	return false;
}

$(function() {
	showAllBlog();
});




















