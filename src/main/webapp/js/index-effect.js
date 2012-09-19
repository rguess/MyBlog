$(function() {
	$("a.login").click(function() {
		$("#logindiv").toggle();
		return false;
	});
	$("a.about").click(function() {
		$("p.about").toggle();
		return false;
	});
	$("a.weather").click(function() {
		$("ul.weather").toggle();
		return false;
	});
	$("a.latest").click(function() {
		$("ul.latest").toggle();
		return false;
	});
});