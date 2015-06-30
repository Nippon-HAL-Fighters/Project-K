/**
 * 組織情報が入力されているかどうかをチェックするためのJavaScript
 */
$(function() {

	// ボタンが押された時にcheck()を呼び出す
	$("#add").click(function(event) {
		
		var addtype = $("input[name='addtype']");
		System.out.println(addtype);
		var errflug = 0;
		
		if(addtype == 1){
			errReset();
			var organaizationid = $("input[name='orgid']");
			var organaizationname = $("input[name='orgaddtext']");
		
			/** 社員番号* */
			if (organaizationid.val() == "") {
				document.getElementById("errorgid").innerText = '組織番号が入力されていません';
				document.getElementById("errorgid").style.display = "block";
				errflug = 1;
			} else if (!organaizationid.val().match(/^[0-9]+$/)) {
				document.getElementById("errorgid").innerText = '組織番号は数字で入力してください';
				document.getElementById("errorgid").style.display = "block";
				errflug = 1;
			} else if (!organaizationid.val().length < 4 || !organaizationid.val().length > 4 ) {
				document.getElementById("errorgid").innerText = '組織番号は4桁で入力してください';
				document.getElementById("errorgid").style.display = "block";
				errflug = 1;
			} 
			/** 組織名* */
			if (organaizationname.val() == "") {
				document.getElementById("errorgname").innerText = '組織名が入力されていません';
				document.getElementById("errorgname").style.display = "block";
				errflug = 1;
			}
		}else if(addtype == 2){
			var postname = $("input[name='postaddtext']");			
			/** 役職名**/
			if (postname.val() == "") {
				document.getElementById("errpostname").innerText = '役職名が入力されていません';
				document.getElementById("errpostname").style.display = "block";
				errflug = 1;
			}		
			
		}else if(addtype == 3){
			
			var companyname = $("input[name='compaddtext']");
						
			/** 組織名* */
			if (companyname.val() == "") {
				document.getElementById("errcompname").innerText = '役職名が入力されていません';
				document.getElementById("errcompname").style.display = "block";
				errflug = 1;
			}
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
		document.getElementById("errorgid").style.display = "none";
		document.getElementById("errorgname").style.display = "none";
	}
});