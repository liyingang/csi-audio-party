var everyPageDataCount=7;
var postPageIndex=0;
var postAllPage=0;
var postUUID="";
var returnpage="";
var ppcount=0;
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}
$(function(){
  
	KindEditor.options.cssData = 'body {font-family:微软雅黑;}',
	editor = KindEditor.create('textarea[id="COM_ADD_DES"]', {
		allowUpload : true,
	    uploadJson: '/postbar/postController/kindEditorImgInput',
	    allowFileManager: false,
	    width:'900px',
	    height: '300px',
	    items: [ 'fullscreen','|','undo', 'redo', '|', 'preview', 'print', 'cut', 'copy', 'paste',
	            'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
	            'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
	            'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
	            'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image',
	             'table', 'hr', 'emoticons', ]
	});
	
	postUUID=GetQueryString("postId");
	returnpage=GetQueryString("page");
	// $.ajax({
	// 	type:"GET",
	// 	url:"article/article",
	// 	data:{"id":postUUID},
	// 	success:function (data) {
	// 		let info=$("#postInfo");
	// 		info.empty();
	// 		info.append(`<table>
	// 						<tbody>
	// 						<tr>
	// 							<td>主题：${data.postTitle}</td>
	// 						</tr>
	// 						<tr>
	// 							<td>发帖人：${data.userName}</td>
	// 						</tr>
	// 						<tr>
	// 							<td>发帖时间：${data.postTime}</td>
	// 						</tr>
	// 						</tbody>
	// 					</table>`);
	// 		$("#postText").children("span").text(data.postText);
	// 		$("#postAtt").children("audio").attr("src",data.postAudio);
	// 		$("#aid").val(data.articleID);
	// 		$("#az").val(data.zan);
	// 	}
	// })
});



function showPostlist(post,user,register,postPraise,myUserUUID,myAdmin){
	

}

function allCommentlist(allCommentlist,admin){
	
}

function hotsPraiseClick(id){
	
	
}
function addComCheck(aid,uid){
var cmText=editor.html().trim();

	if(cmText==""){
		$("#tishi").html("评论内容不能为空");
		return;
	}
	$.ajax({
		type:"POST",
		url:"comment",
		data:{"text":cmText,"aid":aid,"uid":uid},
		success:function (data) {
			if(data){
				alert("评论成功！");
				window.location.replace("comment.html?postId="+aid);

			}
		}
	})


	
}
function returnComList(){
	editor.html("");
	$("#tishi").html("");
	$("#COM_LIST_DIV_ID").attr("style","display:block;");//隐藏div
	$("#COM_ADD_DIV_ID").attr("style","display:none;");//隐藏div
}
function ADD_COM(){
	 $("#COM_LIST_DIV_ID").attr("style","display:none;");//隐藏div
	 $("#COM_ADD_DIV_ID").attr("style","display:block;");//隐藏div
}
function praiseclick(id){
	if(count===1){
		alert("您已经点过赞了");return ;
	}
	$.ajax({
		type:"PUT",
		url:"article/article",
		data:{"aid":id},
		success:function (data) {
			if(data){
				let vv=$("#az");
				vv.text(parseInt(vv.text())+1);
			}
		}
	})



}
function DELETE_COM(){
	var chk_value =[]; 
    $('input[name="DELETE_CHECK_NAME"]:checked').each(function(){ 
        chk_value.push($(this).val()); 
    }); 
    if(chk_value.length==0){
    	$.MsgBox.Alert("消息","请先选择需要删除的评论！");
    	return;
    }
	$.ajax({
		type:"DELETE",
		url:"comment",
		data: {"array":chk_value},
		success:function (data) {
			if(data){
				alert("删除成功");
				window.location.reload();
			}
		}
	});
	    		
	
}
function returnPostList(){
		window.location.replace("post.html");
}