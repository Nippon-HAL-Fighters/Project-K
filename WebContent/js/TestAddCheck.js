/**
 * 組織情報が入力されているかどうかをチェックするためのJavaScript
 */
$(function() {
	
	// ボタンが押された時にcheck()を呼び出す
	$("#add").click(function(event) {
		
		var addtype = $("input[name='addtype']");
		var errflug = 0;

		if(addtype.val() == "1"){
			orgerrReset();
			var organaizationid = $("input[name='orgid']");//入力された組織IDを受け取る
			var organaizationname = $("input[name='orgaddtext']");//入力された組織名を受け取る
		
			/** 組織番号* */
			if (organaizationid.val() == "") {
				document.getElementById("errorgid").innerText = '※エラーメッセージを出力';
				document.getElementById("errorgid").style.display = "block";
				errflug = 1;
			} else if (!organaizationid.val().match(/^[0-9]+$/)) {
				document.getElementById("errorgid").innerText = '※エラーメッセージを出力';
				document.getElementById("errorgid").style.display = "block";
				errflug = 1;
			} else if (organaizationid.val().length < 4 || organaizationid.val().length > 4 ) {
				document.getElementById("errorgid").innerText = '※エラーメッセージを出力';
				document.getElementById("errorgid").style.display = "block";
				errflug = 1;
			} 
			/** 組織名* */
			if (organaizationname.val() == "") {
				document.getElementById("errorgname").innerText = '※エラーメッセージを出力';
				document.getElementById("errorgname").style.display = "block";
				errflug = 1;
			} else if (organaizationname.val().length > 40 ) {
				document.getElementById("errorgname").innerText = '※エラーメッセージを出力';
				document.getElementById("errorgname").style.display = "block";
				errflug = 1;
			} 
		}else if(addtype.val() == "2"){
			posterrReset();
			var postname = $("input[name='postaddtext']");			
			/** 役職名**/
			if (postname.val() == "") {
				document.getElementById("errpostname").innerText = '※エラーメッセージを出力';
				document.getElementById("errpostname").style.display = "block";
				errflug = 1;
			}	else if (postname.val().length > 40 ) {
				document.getElementById("errpostname").innerText = '※エラーメッセージを出力';
				document.getElementById("errpostname").style.display = "block";
				errflug = 1;
			} 	
			
		}else if(addtype.val() == "3"){
			comperrReset();
			var companyname = $("input[name='compaddtext']");
						
			/** 組織名* */
			if (companyname.val() == "") {
				document.getElementById("errcompname").innerText = '※エラーメッセージを出力';
				document.getElementById("errcompname").style.display = "block";
				errflug = 1;
			} else if (companyname.val().length > 40 ) {
				document.getElementById("errcompname").innerText = '※エラーメッセージを出力';
				document.getElementById("errcompname").style.display = "block";
				errflug = 1;
			} 	
		}
				
		if(errflug == 0){
			$(this).submit();
			event.preventdefault();
		}else{
			return false;
		}	
	});

	/** ボタンが押された時にエラーメッセージを初期化する */
	//組織
	function orgerrReset() {
		document.getElementById("errorgid").style.display = "none";
		document.getElementById("errorgname").style.display = "none";
	}
	//役職
	function posterrReset() {
		console.log(document.getElementById("errpostname"));
		document.getElementById("errpostname").style.display = "none";
	}
	//会社
	function comperrReset() {
		document.getElementById("errcompname").style.display = "none";
	}
	
});