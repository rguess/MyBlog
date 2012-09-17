/**
 * 自定义显示twitter 的alert
 * @param nodeId 节点ID （必须） 示例： #test   ,.waw,类似于jqeury
 * @param type 类型   （可选）
 * @param string 需要显示的字符串 （必须）
 * @param seconds 多少秒后关闭字符串 (可选，默认3秒)
 */
function myAlert(nodeId,type,string,second){
	
	
	 var target = $('<div></div>');
	//将其变成jquery对象
	var node = $(nodeId);
    // target.insertBefore(node);
     node.append(target);
	var alertType = type ? type : 'success';
	var timeout = second ? second : 4;
	
	switch (alertType){
			case 'success':
				  target.attr('class','alert alert-success');
				break;
			case 'error' :
				target.attr('class', 'alert alert-error');
				break;
			default :
					target.attr('class','alert alert-info');
				break;
		}
	target.html(string+'<a class="close" data-dismiss="alert" href="#">&times;</a>');
	target.alert();
	setTimeout(function (){
		target.alert('close');
		
	},(timeout*1000));
	
}

/**
 * 向一个节点添加class属性
 * 
 * @param className
 * @param node
 * @returns {String}
 */
function addClass(className, node) {

	return node.className += " " + className;

}
/**
 * 向一个节点移除class属性
 * 
 * @param className
 * @param node
 */
function removeClass(className, node) {
	var tmpClassName = node.className;
	node.className = null; // 清除类名
	node.className = tmpClassName.split(
			new RegExp(" " + className + "|" + className + " " + "|" + "^"
					+ className + "$", "ig")).join("");
}

/**
 * 清除对象子节点
 */
function cleanTable(node){
	var tBody = document.getElementById(node);
		  while(tBody.firstChild) {
			tBody.removeChild(tBody.firstChild);
		}
}