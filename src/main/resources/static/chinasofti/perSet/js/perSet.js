$(document).ready(function () {
	var regage=$("#regAge");
	for(var i=14;i<100;i++){
		regage.append("<option value='"+i+"'>"+i+"</option>");
	}
	$.ajax({
		type:"GET",
		url:"user",
		success:function (data) {
			if(data){
				$("#regUUID").val(data.userID);
				$("#userName").val(data.userName);
				$("#regSex option[value='" + data.regSex + "']").attr("selected", true);
				$("#regAge option[value='" + data.regAge + "']").attr("selected", true);
				$("#regEmial").val(data.regEmail);
				$("#oldUserName").val(data.userName);
			}else{
				alert(data);
			}
		},
		error:function (data) {
			alert(data);
		}
	})






});


function subReg(){
	var regUUID=$("#regUUID").val();
	var userName=$("#userName").val();
	var regSex=$("#regSex").val();
	var regAge=$("#regAge").val();
	var regEmial=$("#regEmial").val();
	if(typeof (userName) == 'undefined' || userName.trim()=="" ){
		$("#tishi").html("用户名不能为空");
		return;
	}
	if(userName.trim().length>20){
		$("#tishi").html("用户名不能大于20个字符");
		return;
	}
	

	if(typeof (regEmial) == 'undefined' || regEmial.trim()==""){
		$("#tishi").html("邮箱地址不能为空");
		return;
	}

	if(!(/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(regEmial.trim()))){
		$("#tishi").html("邮箱地址格式不正确");
		return false;
	}

	$.ajax({
		type:"PUT",
		url:"user",
		data:{
			"userName":userName,
			"regSex":regSex,
			"regAge":regAge,
			"regEmail":regEmial
		},
		success:function (data) {
			if(data){
				$.MsgBox.Alert("信息","修改成功");
				window.parent.location.replace("login.html");
			}else{
				alert(data);
			}
		},
		error:function (data) {
			alert(data);
		}
	});
	


}