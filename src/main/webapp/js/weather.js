
function getWeather() {
	
	$.ajax({
		url : 'rest/weather/get',
		type : 'GET',
		success : function(meta) {
			alert(meta.weatherinfo.city);
		}
	});
}

getWeather();