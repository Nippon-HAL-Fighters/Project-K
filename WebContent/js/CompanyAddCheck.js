/**
 * 会社情報が入力されているかどうかをチェックするためのJavaScript
 */
$(function() {

	// ボタンが押された時にcheck()を呼び出す
	$("#add").click(function() {
		errReset();
		var companyname = $("input[name='compaddtext']");
		var errflug = 0;
		
		/** 組織名* */
		if (companyname.val() == "") {
			document.getElementById("errcompname").innerText = '役職名が入力されていません';
			document.getElementById("errcompname").style.display = "block";
			errflug = 1;
		}
		
		if(errflug == 0){
			$(this).submit();
			event.preventdefault();
			//return true;
		}else{
			return false;
		}	
	});

	/** ボタンが押された時にエラーメッセージを初期化する */
	function errReset() {
		document.getElementById("errcompname").style.display = "none";
	}
});