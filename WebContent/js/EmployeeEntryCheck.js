$(function(){		
	//ボタンが押された時にcheck()を呼び出す
	$("input[type='submit']").click(function(){
		errReset();
		var employeeid = $("input[name='employeeid']");
		var employeename = $("input[name='employeename']");
		var employeestatus = $("[name=koyo] option:selected").val();
		var admin = $("[name=admin] option:selected").val();
		var posts = $("[name=posts] option:selected").val();
		var org = $("[name=org] option:selected").val();
		var comp = $("[name=comp] option:selected").val();
		var phonein = $("input[name='phoneinside']");
		var phoneout = $("input[name='phoneout']");
		var errflug = 0;
		
		/**社員番号**/
		if(employeeid.val() == ""){
			document.getElementById("errid").innerText = '社員番号が入力されていません';
			document.getElementById("errid").style.display="block";
			errflug = 1;
		}else if(!employeeid.val().match(/^[0-9]+$/)){
			document.getElementById("errid").innerText = '社員番号は数字で入力してください';
			document.getElementById("errid").style.display="block";
			errflug = 1;
		}
		
		/**社員氏名**/
		if(employeename.val() == ""){
			document.getElementById("errname").innerText = '氏名が入力されていません';
			document.getElementById("errname").style.display="block";
			errflug = 1;
		}else if(employeename.length > 20){
			document.getElementById("errname").innerText = '氏名は20文字以内で入力してください';
			document.getElementById("errname").style.display="block";
			errflug = 1;
		}	
		
		/**雇用状態**/
		if(employeestatus == "none"){
			document.getElementById("errstatus").innerText = '雇用状態が選択されていません';
			document.getElementById("errstatus").style.display="block";
			errflug = 1;
		}
		
		/**管理者権限**/
		if(admin == "none"){
			document.getElementById("erradmin").innerText = '管理者権限が選択されていません';
			document.getElementById("erradmin").style.display="block";
			errflug = 1;
		}
		
		/**役職**/
		if(posts == "none"){
			document.getElementById("errpost").innerText = '役職が選択されていません';
			document.getElementById("errpost").style.display="block";
			errflug = 1;
		}
		
		/**部署**/
		if(org == "none"){
			document.getElementById("errorg").innerText = '部署が選択されていません';
			document.getElementById("errorg").style.display="block";
			errflug = 1;
			//return false;
		}
		
		/**内線番号**/
		if(phonein.val() == ""){
			document.getElementById("errphonein").innerText = '内線番号が入力されていません';
			document.getElementById("errphonein").style.display="block";
			errflug = 1;
		}else if(!phonein.val().match(/(^#\d{3}$)|(^\d{4}$)/)){
			document.getElementById("errphonein").innerText = '内線番号は数字4桁で入力してください';
			document.getElementById("errphonein").style.display="block";
			errflug = 1;
		}
		
		/**外線番号**/
		if(phoneout.val() == ""){
			document.getElementById("errphoneout").innerText = '外線番号が入力されていません';
			document.getElementById("errphoneout").style.display="block";
			errflug = 1;
		}else if(!phoneout.val().match(/(^\d{10}$)|(^\d{11}$)/)){
			document.getElementById("errphoneout").innerText = '外線番号は数字10桁または11桁で入力してください';
			document.getElementById("errphoneout").style.display="block";
			errflug = 1;
		}
		
		/**所属会社**/
		if(comp == "none"){
			document.getElementById("errcomp").innerText = '所属会社が選択されていません';
			document.getElementById("errcomp").style.display="block";
			errflug = 1;
		}
		
		if(errflug == 0){
			return true;
		}else{
			return false;
		}	
	});	
	
	/**ボタンが押された時にエラーメッセージを初期化する*/
	function errReset(){
			document.getElementById("errid").style.display="none";
			document.getElementById("errname").style.display="none";
			document.getElementById("errstatus").style.display="none";
			document.getElementById("erradmin").style.display="none";
			document.getElementById("errpost").style.display="none";
			document.getElementById("errorg").style.display="none";
			document.getElementById("errphonein").style.display="none";
			document.getElementById("errphoneout").style.display="none";
			document.getElementById("errcomp").style.display="none";
	}
});