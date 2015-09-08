function changeSelect() {
	var select = document.getElementById('select');
	var options = document.getElementById('select').options;
	var value = options.item(select.selectedIndex).value;

	if (value == "東京") {
		document.getElementById("0").style.display = 'none';
		document.getElementById("1").style.display = 'block';
	} else if (value == "大阪") {
		document.getElementById("0").style.display = 'block';
		document.getElementById("1").style.display = 'none';
	}
}