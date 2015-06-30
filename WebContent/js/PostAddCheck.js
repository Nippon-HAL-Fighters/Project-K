/**
 * 役職情報が入力されているかどうかをチェックするためのJavaScript
 */
$(function() {

	// ボタンが押された時にcheck()を呼び出す
	$("#add").click(function() {
		errReset();
		var postname = $("input[name='postaddtext']");
		var errflug = 0;
		
		/** 役職名**/
		if (postname.val() == "") {
			document.getElementById("errpostname").innerText = '役職名が入力されていません';
			document.getElementById("errpostname").style.display = "block";
			errflug = 1;
		}
		
		if(errflug == 0){
			$(this).submit();
			event.preventdefault();
		}else{
			return false;
		}	
	});

	/** ボタンが押された時にエラーメッセージを初期化する */
	function errReset() {
		document.getElementById("errpostname").style.display = "none";
	}
});