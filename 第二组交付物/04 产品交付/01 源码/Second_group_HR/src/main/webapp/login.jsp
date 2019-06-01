<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>点点登录</title>
<link href="page-profile/css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
</head>
<body>
<!-- contact-form -->	
<div class="message warning">
<div class="inset">
	<div class="login-head">
		<h1>登录窗</h1>
		 <!--<div class="alert-close"> </div>-->
	</div>
		<form action="login" method="get" id="login_form">
			<li>
				<input id="name" name="name" type="text" class="text" value="请输入账号和密码"  onfocus="if (this.value == '请输入账号和密码'||this.value == '请输入账号'){this.value = '';}" onblur="if (this.value == '') {this.value = '请输入账号';}"><a href="#" class=" icon user"></a>
			</li>
				<div class="clear"> </div>
			<li>
				<input id="password" name="password" type="password" value="请输入密码" onfocus="if (this.value == '请输入密码'){this.value = '';}" onblur="if (this.value == '') {this.value = '请输入密码';}"> <a href="#" class="icon lock"></a>
			</li>
			<div class="clear"> </div>
			<div class="submit">
				<input type="button" onclick="chee()" value="登录" >
				<input type="reset" value="重置">
			</div>
            <div class="clear"> </div>				
		</form>						
	</div>
	</div>
	<div class="clear"> </div>
<!--- footer --->
<div class="footer">
	<p>第二组制作，于2019年5月27日</p>
</div>
<script type="text/javascript">
	function chee()
	{
		var name =  document.getElementById("name").value;
		var password = document.getElementById("password").value;
		var form = document.getElementById('login_form');
		console.log(name+"  "+password)
		if( (name!=null&&name!=undefined&&name!=""&&name!="请输入账号")&&
		    (password!=null&&password!=undefined&&password!=""&&password!="请输入密码")){			
			form.submit();
		}else{
			form.reset();
			alert("请检查账号和密码,重新输出");
		}
	}
</script>
</body>
</html>