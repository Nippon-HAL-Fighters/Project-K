$(function(){		
	//ボタンが押された時にcheck()を呼び出す
	$("input[type='submit']").click(function(){
		var updatetype = $("input[name='updatetype']");
		var errflug = 0;
		
		if(updatetype.val() == "org"){
			var orgid = $("input[name='orgid']");
			var orgname = $("input[name='orgname']");
			errOrgReset();
			/**組織ID**/
			if(orgid.val() == ""){//何も入力されなかったら
				document.getElementById("errorgid").innerText = '組織IDが入力されていません';
				document.getElementById("errorgid").style.display="block";
				errflug = 1;
			}else if (orgid.val().length < 4 ||  orgid.val().length > 4) {//入力された桁が4桁未満もしくは4桁より多かったら
				document.getElementById("errorgid").innerText = '組織IDは半角数字4桁で入力してください';
				document.getElementById("errorgid").style.display = "block";
				errflug = 1;
			} 
			else if(!orgid.val().match(/^[0-9]+$/)){//数字で入力されてなかったら	
				document.getElementById("errorgid").innerText = '組織IDは半角数字4桁で入力してください';
				document.getElementById("errorgid").style.display="block";
				errflug = 1;
			}
			/**組織名**/
			if(orgname.val() == ""){//何も入力されてなかったら
				document.getElementById("errorgname").innerText = '組織名が入力されていません';
				document.getElementById("errorgname").style.display="block";
				errflug = 1;
			}else if(orgname.length > 40){
				document.getElementById("errorgname").innerText = '組織名は40文字以内で入力してください';
				document.getElementById("errorgname").style.display="block";
				errflug = 1;
			}
			
		}else if(updatetype.val() == "post"){//役職だったら
			/**役職名**/
			var postname = $("input[name='postname']");
			errPostReset();
			if(postname.val() == ""){//何も入力されてなかったら
				document.getElementById("errpost").innerText = '役職名が入力されていません';
				document.getElementById("errpost").style.display="block";
				errflug = 1;
			}else if(postname.length > 40){
				document.getElementById("errpost").innerText = '役職名は40文字以内で入力してください';
				document.getElementById("errpost").style.display="block";
				errflug = 1;
			}
			
		}else if(updatetype.val() == "comp"){
			/**会社名**/
			var comp = $("input[name='compname']");
			errCompReset();
			if(comp.val() == ""){
				document.getElementById("errcomp").innerText = '会社名が入力されていません';
				document.getElementById("errcomp").style.display="block";
				errflug = 1;
			}else if(comp.length > 40){
				document.getElementById("errcomp").innerText = '会社名は40文字以内で入力してください';
				document.getElementById("errcomp").style.display="block";
				errflug = 1;
			}
		}
				
		if(errflug == 0){
			return true;
		}else{
			return false;
		}	
	});	
	
	function errOrgReset(){
		document.getElementById("errorgid").style.display="none";
		document.getElementById("errorgname").style.display="none";
	}
	
	function errPostReset(){
		document.getElementById("errpost").style.display="none";
	}
	
	function errCompReset(){
		document.getElementById("errcomp").style.display="none";
	}
});