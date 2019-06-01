<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CSI员工之家</title>
</head>
<!-- import easyui-css -->
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<!-- 引入easyu的js文件 -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript">
var theRequest = new Object();
window.onload = function(){
	var gurl = location.search;  
	if ( gurl.indexOf( "?" ) != -1 ) {  
		var str = gurl.substr( 1 ); //substr()方法返回从参数值开始到结束的字符串；  
		var strs = str.split( "&" );  
		for ( var i = 0; i < strs.length; i++ ) {  
			theRequest[ strs[ i ].split( "=" )[ 0 ] ] = decodeURI( strs[ i ].split( "=" )[ 1 ] );   //decodeURI()解决中文乱码
		}
	}
	console.log(theRequest);
	document.getElementsByName('tb')[0].value = theRequest["uname"];
	document.getElementsByName('ta')[0].value = theRequest["usname"];
	console.log(theRequest["uname"]);
	console.log(theRequest["usname"]);

}
$( function(){
   $('#aa').click(function(){
			var uname = $('#tb').val();
			var usname = $('#ta').val();
			$.ajax({  
			    type : 'POST',  
			    url: 'xgBms',
			    contentType: "application/x-www-form-urlencoded",
			    data: {"uname":uname,"usname":usname,"uid":theRequest["uid"]},
			    success : function(data) {
			    	$.messager.alert('提示','修改部门成功！','info',function(){
			    		window.location.href="bmcx.jsp";
			    	});
			    }  
			});  
   });
   $('#bb').click( function(){
	     $('#ww').form('clear');
   });
});

 </script> 
<body class="easyui-layout">   
    <div data-options="region:'center',title:'当前位置：部门管理 > 修改部门'" style="padding:5px;background:#eee;"> 
    <form id="ww">
    <label>部门名称：</label>
    <input id="tb" type="text"  style="width:120px;height:20px" name="tb">
    
    <label style="margin-left:50px">详细信息：</label>
    <input id="ta" type="text"  style="width:120px;height:20px" name="ta">
    <br>
    <br>
    <br>
    <a id="aa" class="easyui-linkbutton" >修改</a>
   	<a id="bb" style="margin-left:15px"  class="easyui-linkbutton">取消</a>
    </form>
    </div> 
    
</body> 

</html>