$(function(){
  $.ajax({
	  type:"GET",
	  url:"audio",
	  success:function (data) {
	  	if(data){
			$("#auSetVoiPer option[value='" + data.auSetVoiPer + "']").attr("selected", true);
			$("#auSetSpd option[value='" + data.auSetSpd + "']").attr("selected", true);
			$("#auSetPit option[value='" + data.auSetPit + "']").attr("selected", true);
			$("#auSetVol option[value='" + data.auSetVol + "']").attr("selected", true);
		}else{
	  		alert(data);
		}
	  },
	  error:function (data) {
		  alert(data);
	  }
  })


	    		

});

function updateAudioSetUp(){
	var p={};
	p.userID=$("#auSetUUID").val();
	p.auSetVoiPer=$("#auSetVoiPer").val();
	p.auSetSpd=$("#auSetSpd").val();
	p.auSetPit=$("#auSetPit").val();
	p.auSetVol=$("#auSetVol").val();

	$.ajax({
		type:'PUT',
		url:"audio",
		data:p,
		success:function (data) {
			if(data){
				$.MsgBox.Alert("信息","提交成功");
			}else{
				$.MsgBox.Alert("信息","修改失败");

			}
		},
		error:function (data) {
			alert(data);
		}
	})
	
}