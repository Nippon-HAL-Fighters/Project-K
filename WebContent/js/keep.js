function changeSelected(area) {
	var value = area;
	console.log(area);

	if (area == "東京") {
		document.getElementById("0").style.display = 'none';
		document.getElementById("1").style.display = 'block';
	} else if (area == "大阪") {
		document.getElementById("0").style.display = 'block';
		document.getElementById("1").style.display = 'none';
	}
}