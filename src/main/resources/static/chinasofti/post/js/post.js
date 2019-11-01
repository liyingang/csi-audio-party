var everyPageDataCount=7;
var postPageIndex=0;
var postAllPage=0;
$(document).ready(function () {
	KindEditor.options.cssData = 'body {font-family:微软雅黑;}',
	editor = KindEditor.create('textarea[id="POST_ADD_DES"]', {
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
	             'table', 'hr', 'emoticons' ]
	});
	
	
	var searchNameVal=$("#SEARCH_POST_NAME_HIDDEN").val().trim();
	if(searchNameVal==="")searchNameVal="all";
	getPostList(0,everyPageDataCount,"/article/title/"+searchNameVal);

});
function getPostList(pageIndex,everyPageDataCount,url){
	  	$("#SEARCH_POST_NAME_HIDDEN").val(url.split("/article/title/")[1].trim());
	  	$.ajax({
			type:"GET",
			url:url,
			success:function (data) {
				if(data){
					var body=$("#POST_LIST_TBODY_ID");
					body.empty();
						data.forEach(function (vo,i) {
							body.append(` <tr bgcolor="#FFFFFF" ">
                                        <td align="center" width="20">
                                            <input name="DELETE_CHECK_NAME" type="checkbox" value="${vo.articleID}">
                                        </td>
                                        <td valign="center" align="center" width="30">${vo.postPageviews}</td>
                                        <td valign="center" align="center" width="30">${vo.postCom}</td>
                                        <td valign="center" align="center" width="110">
                                            <a href="" onclick="post_detailed(${vo.articleID}); return false;" >${vo.postTitle}</a>
                                        </td>
                                        <td valign="center" align="center" width="110" >${vo.user.userName}</td>
                                        <td valign="center" align="center" width="100" >${vo.postTime}</td>
                                        <td valign="center" align="center" width="100" >${vo.lastCom==null?"":vo.lastCom}</td>
                                    </tr>`);
						});

					}
				}

		})
	  		
}

function returnPostList(){
	$("#POST_ADD_TITLE").val("");
	editor.html("");
	$("#tishi").html("");
	$("#POST_LIST_DIV_ID").attr("style","display:block;");//隐藏div
	$("#POST_ADD_DIV_ID").attr("style","display:none;");//隐藏div
	// window.location.reload();
}

function ADD_POST(){
	 $("#POST_LIST_DIV_ID").attr("style","display:none;");//隐藏div
	 $("#POST_ADD_DIV_ID").attr("style","display:block;");//隐藏div
}



function addPostCheck(){
	var title=$("#POST_ADD_TITLE").val().trim();
	var text=editor.html().trim();
	
	if(title==""){
		$("#tishi").html("文章标题不能为空");
		return;
	}
	if(title.length>16){
		$("#tishi").html("文章标题最多16个字符");
		return;
	}
	if(text==""){
		$("#tishi").html("文章内容不能为空");
		return;
	}
	$.ajax({
		type:"POST",
		url:"/article/article",
		data:{"title":title,"text":text},
		async:false,
		success:function (data) {
			if(data){
				alert("成功插入！");
				returnPostList();
				var searchNameVal=$("#SEARCH_POST_NAME_HIDDEN").val().trim();
				getPostList(postPageIndex,everyPageDataCount,"/article/title/"+searchNameVal);
			}else{
				alert("插入失败！");

			}
		}
	})
	    



	    	


}

function showPostlist(admin,postList,postAllNum,allPage,pageIndex){
	
}

function GOTO_POST_NEXT_PAGE(){

	var searchNameVal=$("#SEARCH_POST_NAME_HIDDEN").val().trim();
	getPostList(postPageIndex,everyPageDataCount,"/article"+searchNameVal);
}

function GOTO_POST_TAIL_PAGE(){
	var searchNameVal=$("#SEARCH_POST_NAME_HIDDEN").val().trim();
	getPostList(postPageIndex,everyPageDataCount,"/article"+searchNameVal);
}

function GOTO_POST_PAGE(){
	var jumpVal=$("#JUMP_INPUT_ID").val().trim();
	if(jumpVal==""){
		$.MsgBox.Alert("消息","跳转页不能为空");
		return;
	}
	if(!(/^[0-9]+$/.test(jumpVal))){
		$.MsgBox.Alert("消息","页码必须为数字");
		return;
	}
	if(jumpVal<=0){
		$.MsgBox.Alert("消息","页码必须大于等于1");
		return;
	}
	if(jumpVal>postAllPage){
		$.MsgBox.Alert("消息","页码超出上限");
		return;
	}
	var searchNameVal=$("#SEARCH_POST_NAME_HIDDEN").val().trim();
	getPostList(jumpVal-1,everyPageDataCount,"/article"+searchNameVal);
}


function GOTO_POST_HOME_PAGE(){
	var searchNameVal=$("#SEARCH_POST_NAME_HIDDEN").val().trim();
	getPostList(0,everyPageDataCount,"/article"+searchNameVal);
}

function GOTO_POST_PREVIOUS_PAGE(){
	var searchNameVal=$("#SEARCH_POST_NAME_HIDDEN").val().trim();
	getPostList(postPageIndex-1,everyPageDataCount,"/article"+searchNameVal);
	 
}
function searchByPostName(){
	var searchNameVal=$("#SEARCH_POST_NAME").val().trim();
	if(searchNameVal=="")searchNameVal="all";
	getPostList(0,everyPageDataCount,"/article/title/"+searchNameVal);
}

function post_detailed(postUUID){
	$.ajax({
		type:"PUT",
		url:"article/addView",
		data:{"id":postUUID}
	})
	window.location.replace("comment.html?postId="+postUUID);

}

function DELETE_POST(){
	var chk_value =[]; 
    $('input[name="DELETE_CHECK_NAME"]:checked').each(function(){ 
        chk_value.push($(this).val()); 
    }); 
    if(chk_value.length==0){
    	$.MsgBox.Alert("消息","请先选择需要删除的文章");
    	return;
    }
    
	$.ajax({
		type:"DELETE",
		url:"article/article",
		data: {"array":chk_value},
		success:function (data) {
			if(data){
				alert("删除成功");
				window.location.reload();
			}
		}
	});

}



