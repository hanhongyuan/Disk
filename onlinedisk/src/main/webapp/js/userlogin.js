$(document).ready(function() {
	$("#sub").click(function() {
		var userid = $("input[name=username]").val();
		var userpassword = $("input[name=password]").val();

		$.ajax({
			type : "POST",
			url : "user/trylogin.do",
			dataType : "text",
			data : {
				userId : userid,
				password : userpassword
			},
			success : function(data) {
				if (data == "true") {

					$("#userlogin").submit();
				} else {
					alert("用户名/密码错误");
				}

			},
			error : function(data) {

			}
		});
	})
})