<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/icon.css">
<!-- 引入easyu的js文件 -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript">
var pwer = '<%=session.getAttribute("pwer")%>';
	$(function() {
		$("#btn2").click(function(){
			$("#title").val('');
			$("#describe").val('');
			var file = $('#file');
			file.after(file.clone().val(''));      
			file.remove(); 
		})
		$("#btn").click(
				function() {
					
					if(pwer == 0){
						alert("你没有该权限！！")
					}else{
						var title = $("#title").val();
						var describe = $("#describe").val();
						if (title == null || title == '') {
							alert("标题不能为空!");

						} else {
							if (describe.length < 100 || describe == null
									|| describe == '' || describe.length > 255) {
								alert("描述不能为空!长度必须大于100且小于255");
							} else {
								$.ajax({
									url : "saveFile",
									type : "post",
									data : {
										"title" : title,
										"describe" : describe
									},
									dataType : "text",
									success : function(res) {
										//获取通过resp回写的数据
										if (res == "true") {
											alert("上传成功")
										} else {
											alert("上传失败")
										}

									}

								})
							}
						}
					}
				})

	})
</script>
<body class="easyui-layout">
	<div id="wecx" data-options="region:'center',title:'当前位置:文档管理>文档上传'"
		style="padding: 5px; background: #eee;">
		<tr valign="top">
			    <td>
			    
				 
                        <!-- 隐藏表单，flag表示添加标记 -->
    	 			<input type="hidden" name="flag" value="2">
				  <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
                        
					    <tbody><tr><td class="font3 fftd">
					              
					                
					                文档标题：<input type="text" name="title" size="30" id="title"></td>
					    </tr>
						<tr><td class="main_tdbor"></td></tr>
						
						
						<tr><td class="font3 fftd">文档描述：<br>
							<textarea name="remark" cols="88" rows="11" id="describe"></textarea>
						</td></tr>
						<tr><td class="main_tdbor"></td></tr>
						
							<tr><td class="font3 fftd">文档：<br>
							<input type="file" name="file" id="file" size="30">
						</td></tr>
						<tr><td class="main_tdbor"></td></tr>
						
                      
						
						<tr><td class="font3 fftd">
								<input type="button" id="btn" value="上传">
								<input type="reset" id="btn2" value="重置">
						</td></tr>
						<tr><td class="main_tdbor"></td></tr>
					

				  </tbody></table>
				 
				</td>
		  	</tr>

	</div>
</body>
</html>