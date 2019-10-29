var uk ="_uk_",pk="_pk_",rk="_rk_";
$(function(){
	$("#username").focus();
	$("#username").val($.localStorage.get(uk));
	$("#password").val($.localStorage.get(pk));
	if($.localStorage.get(rk)){
		$("#rememberPwd").attr("checked",true);
	}
	
});
function subLogin(){
    var $msg = $("#message"),$usrname=$("#username"),$pwd=$("#password"),$rememberPwd = $("#rememberPwd");
    var usrname = $usrname.val()||"";

    if(usrname.trim().length==0){
        $("#tishi").html("用户名不能为空");
        return false;
    }
    var pwd = $pwd.val()||"";
    if(pwd.trim().length==0){
    	$("#tishi").html("密码不能为空!");
        return false;
    }
    if($rememberPwd.is(':checked')){
    	$.localStorage.set(uk, usrname);
    	$.localStorage.set(pk, pwd);
    	$.localStorage.set(rk, true);
    }else{
    	$.localStorage.remove(uk);
    	$.localStorage.remove(pk);
    	$.localStorage.remove(rk);
    }
    

	

    return true;
        		
        		//alert(JSON.stringify(json));
   

}





if(window !=top){
	top.location.href=location.href;
}
function subReg(){
	var userName=$("#regusername").val();
	var password=$("#regpassword").val();
	var passwordCon=$("#regpasswordCon").val()
	var regSex=$("#regsex").val();
	var regAge=$("#regAge").val();
	var regEmial=$("#regEmial").val();
	if(typeof (userName) == 'undefined' || userName.trim()=="" ){
		$("#zucetishi").html("用户名不能为空");
		return false;
	}
	if(userName.trim().length>20){
		$("#zucetishi").html("用户名不能大于20个字符");
		return false;
	}
	if(typeof (password) == 'undefined' || password.trim()==""  ){
		$("#zucetishi").html("密码不能为空");
		return false;
	}
	if(password.trim().length!=6){
		$("#zucetishi").html("密码必须为6位");
		return false;
	}
	if(typeof (passwordCon) == 'undefined' || passwordCon.trim()==""){
		$("#zucetishi").html("确认密码不能为空");
		return false;
	}
	if(password.trim()!=passwordCon.trim()){
		$("#zucetishi").html("密码与确认密码必须保持一致");
		return false;
	}
	if(typeof (regEmial) == 'undefined' || regEmial.trim()==""){
		$("#zucetishi").html("邮箱地址不能为空");
		return false;
	}

	if(!(/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(regEmial.trim()))){
		$("#zucetishi").html("邮箱地址格式不正确");
		return false;
	}

 	$.ajax({
		type:"POST",
		url:"register",
		data:{
			"userName":userName,
			"password":password,
			"regSex":regSex,
			"regAge":regAge,
			"regEmail":regEmial
		},
		success:function (data) {
			if(data){
				$.MsgBox.Alert("消息", "注册成功，请重新登录！");
				gotoLogin();
			}else{
				$.MsgBox.Alert("消息", "注册失败，请重新注册！");
			}
		},
		error:function (data) {
			$.MsgBox.Alert("消息", data);
		}

	})



       
}

function gotoregister(){
	$("#loginbox").hide();
	$("#registerbox").show();
 
    $("#regusername").val("");
	$("#regpassword").val("");
	$("#regpasswordCon").val("")
	$("#regsex").val("0");
	$("#zucetishi").html("");
	var regage=$("#regAge");
	var selectPotion=$("#regAge option");
	
	if(selectPotion.length=="0"){
		for(var i=14;i<100;i++){
    		regage.append("<option value='"+i+"'>"+i+"</option>");
    	}
	}else{
		regage.val("14");
	}
	
	$("#regEmial").val("");
}

function gotoLogin(){
	$("#loginbox").show();
	$("#registerbox").hide();
	
	layui.use("layer");
	$("#username").focus();
	$("#username").val($.localStorage.get(uk));
	$("#password").val($.localStorage.get(pk));
	 $("#tishi").html("");
	if($.localStorage.get(rk)){
		$("#rememberPwd").attr("checked",true);
	}
}