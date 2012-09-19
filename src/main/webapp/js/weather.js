
function getWeather() {
	
	$.ajax({
		url : 'rest/weather/get',
		type : 'GET',
		success : function(meta) {
			var w = meta.weatherinfo;
			$("#today").empty().append("今天:"+w.week+" "+w.temp1+" "+w.weather1);
			$("#tomororw").empty().append("明天:"+parseInt(w.week)+1+" "+w.temp2+" "+w.weather2);
			$("#w1").empty().append("明天:"+parseInt(w.week)+1+" "+w.temp2+" "+w.weather2);
			$("#w2").empty().append("明天:"+parseInt(w.week)+1+" "+w.temp2+" "+w.weather2);
			$("#w3").empty().append("明天:"+parseInt(w.week)+1+" "+w.temp2+" "+w.weather2);
			$("#w4").empty().append("明天:"+parseInt(w.week)+1+" "+w.temp2+" "+w.weather2);
		}
	});
}

getWeather();