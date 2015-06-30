function ChangeTab(tabname) {
	// 全部消す
	document.getElementById('0').style.display = 'none';
	document.getElementById('1').style.display = 'none';
	// 指定箇所のみ表示
	if (tabname == 1) {
		document.getElementById(tabname).style.display = 'block';
		document.getElementById("tab2").style.display = 'none';
		document.getElementById("tab1").style.display = 'block';
		tabname = 0;
	} else {
		document.getElementById(tabname).style.display = 'block';
		document.getElementById("tab1").style.display = 'none';
		document.getElementById("tab2").style.display = 'block';
	}
}

function changeSelect(){
    var select = document.getElementById('select');
    var options =
        document.getElementById('select').options;
    var value = options.item(select.selectedIndex).value;

    if (value == "東京") {
        alert(value);
		document.getElementById("大阪").style.display = 'none';
		document.getElementById("東京").style.display = 'block';
	} else if (value == "大阪"){
	    alert(value);
		document.getElementById("大阪").style.display = 'none';
		document.getElementById("東京").style.display = 'block';
	}
}