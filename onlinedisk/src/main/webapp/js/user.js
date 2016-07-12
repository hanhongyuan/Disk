$(document).ready(function() {
	$("input[name='username']").blur(function() {
		var userid = $(this).val();
		var jsondata = [ {
			"userid" : userid
		} ];
		$.ajax({
			type : "POST",
			url : "user/couldregiset.do",
			dataType : "text",
			data : {
				userId : userid
			},
			success : function(data) {
				if (data == "true") {
					var label = document.getElementById("reg");
					if (userid != "") {
						label.innerText = "可以注册";
						$("#reg").css("color", "green");						
					} else {
						label.innerText = "请输入帐号";
						$("#reg").css("color", "red");						
					}
				}

				else {
					var label = document.getElementById("reg");
					label.innerText = "该帐号已被注册";
					$("#reg").css("color", "red");
					var button = document.getElementById("submit");
					button.disabled = true;
				}
			},
			error : function(data) {
				alert("请求失败");
			}
		});
	});

	$("input").blur(function() {
		var password1 = $("input[name=password]").val();
		var password2 = $("input[name=passwordagain]").val();
		var userid = $("input[id=username]").val();
		if (userid == ""){
			var label = document.getElementById("reg");
			label.innerText = "请输入帐号";
			$("#reg").css("color", "red");						
		}
		if(password1==""){
			var label = document.getElementById("psw");
			label.innerText = "请输入密码";
		}
		else if (password1 != password2) {
			var label = document.getElementById("psw");
			label.innerText = "两次密码不相同";
			var button = document.getElementById("submit");
			button.disabled = true;
		} else {
			var label = document.getElementById("psw");
			label.innerText = "";
			var button = document.getElementById("submit");
			button.disabled = false;
		}
		var idtry = $("label[id=reg]").text();
		var pswtry = $("label[id=psw]").text();
		

		if(pswtry==""&&idtry=="可以注册"){
			var button = document.getElementById("submit");
			button.disabled = false;
		}else{
			var button = document.getElementById("submit");
			button.disabled = true;
		}
	})

})