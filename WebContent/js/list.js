function getCELL() {
	var myTbl = document.getElementById('TBL');
	// trをループ。rowsコレクションで,行位置取得。
	for (var i = 0; i < myTbl.rows.length; i++) {
		// tr内のtdをループ。cellsコレクションで行内セル位置取得。
		for (var j = 0; j < myTbl.rows[i].cells.length; j++) {
			var Cells = myTbl.rows[i].cells[j]; // i番行のj番列のセル "td"
			// onclickで 'Mclk'を実行。thisはクリックしたセル"td"のオブジェクトを返す。
			Cells.onclick = function() {
				Mclk(this);
			}
		}
	}
}

function Mclk(Cell) {
	var rowINX = '行位置：' + Cell.parentNode.rowIndex;// Cellの親ノード'tr'の行位置
	var cellINX = 'セル位置：' + Cell.cellIndex;
	var cellVal = 'セルの内容：' + Cell.innerHTML;
	// 取得した値の書き出し

	res = rowINX + '<br/> ' + cellINX + '<br/>' + cellVal;
	document.getElementById('Mbox0').innerHTML = res;
	var Ms1 = document.getElementById('Mbox1');
	Ms1.innerText = Cell.innerHTML;
	Ms1.textContent = Cell.innerHTML;

	document.form.cell.value = Cell.innerHTML;

}

// try ～ catch 例外処理、エラー処理
// イベントリスナーaddEventListener,attachEventメソッド
try {
	window.addEventListener("load", getCELL, false);
} catch (e) {
	window.attachEvent("onload", getCELL);
}