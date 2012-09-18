
function getWeather() {
	
	$.ajax({
		url : 'rest/weather/get',
		type : 'GET',
		success : function(meta) {
			var w = meta.weatherinfo;
			$("#w1").empty().append("今天:"+w.weather1+"  "+w.temp1+"  <img src='http://www.weather.com.cn/m/i/weatherpic/29x20/d"+w.img1+".gif'></img>");
			$("#w2").empty().append("明天:"+w.weather2+"  "+w.temp2+"  <img src='http://www.weather.com.cn/m/i/weatherpic/29x20/d"+w.img3+".gif'></img>");
			$("#w3").empty().append("后天:"+w.weather3+"  "+w.temp3+"  <img src='http://www.weather.com.cn/m/i/weatherpic/29x20/d"+w.img5+".gif'></img>");
		}
	});
}

getWeather();