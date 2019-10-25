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
	             'table', 'hr', 'emoticons', ]
	});
	
	
	var searchNameVal=$("#SEARCH_POST_NAME_HIDDEN").val().trim();
	getPostList(searchNameVal,0,everyPageDataCount,true,"/postbar/postController/getPostList");
	
});
function getPostList(postTitle,pageIndex,everyPageDataCount,SynOrAsyn,url){

	  	$("#SEARCH_POST_NAME_HIDDEN").val(postTitle.trim());
	  		
}

function returnPostList(){
	$("#POST_ADD_TITLE").val("");
	editor.html("");
	$("#tishi").html("");
	$("#POST_LIST_DIV_ID").attr("style","display:block;");//隐藏div
	$("#POST_ADD_DIV_ID").attr("style","display:none;");//隐藏div
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

	    

	    		returnPostList();
	    		var searchNameVal=$("#SEARCH_POST_NAME_HIDDEN").val().trim();
	    		getPostList(searchNameVal,postPageIndex,everyPageDataCount,true,"/postbar/postController/getPostList");

	    	


}

function showPostlist(admin,postList,postAllNum,allPage,pageIndex){
	
}

function GOTO_POST_NEXT_PAGE(){

	var searchNameVal=$("#SEARCH_POST_NAME_HIDDEN").val().trim();
	getPostList(searchNameVal,postPageIndex+1,everyPageDataCount,true,"/postbar/postController/getPostList");
}

function GOTO_POST_TAIL_PAGE(){
	var searchNameVal=$("#SEARCH_POST_NAME_HIDDEN").val().trim();
	getPostList(searchNameVal,postAllPage-1,everyPageDataCount,true,"/postbar/postController/getPostList");
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
	getPostList(searchNameVal,jumpVal-1,everyPageDataCount,true,"/postbar/postController/getPostList");
}


function GOTO_POST_HOME_PAGE(){
	var searchNameVal=$("#SEARCH_POST_NAME_HIDDEN").val().trim();
	getPostList(searchNameVal,0,everyPageDataCount,true,"/postbar/postController/getPostList");
}

function GOTO_POST_PREVIOUS_PAGE(){
	var searchNameVal=$("#SEARCH_POST_NAME_HIDDEN").val().trim();
	getPostList(searchNameVal,postPageIndex-1,everyPageDataCount,true,"/postbar/postController/getPostList");
	 
}
function searchByPostName(){
	var searchNameVal=$("#SEARCH_POST_NAME").val().trim();
	getPostList(searchNameVal,0,everyPageDataCount,true,"/postbar/postController/getPostList");
}

function post_detailed(postUUID){

	window.location.replace("comment.html?page=post&postid=0000000000000");

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
    


	    		var searchNameVal=$("#SEARCH_POST_NAME_HIDDEN").val().trim();
	    		getPostList(searchNameVal,0,everyPageDataCount,true,"/postbar/postController/getPostList");
	   

}



