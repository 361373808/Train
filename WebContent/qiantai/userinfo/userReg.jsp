<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <base target="_self"/>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<script language="javascript" >
		
            function closeOpen()
		    {
		       window.returnValue=false;
		       window.close();
		    }
		   
		    function check()
             {
                   if( document.form1.userName.value=="")
	               {
	                   alert("请输入用户名");
	                   return false;
		           }
	               if( document.form1.userPw.value=="")
	               {
	                   alert("请输入密码");
	                   return false;
	               }
	               window.close();
             }
		    /*
function f(){
		    var name=$("#userName").val();
		    $.ajax({
		    	url:'getStreamResult.action',
		    	type:"post",
		    	data:"name="+name,
		    	dataType:"text",
		        success:function(data){$('#msg').html(data);},
		        error:function(){$('#msg').html("请求失败");}
		    });
		    */
		    /*
	            //注册文本框事件  
	            $('#userName').keyup(function () {  
	                var username = $(this).val();//获取当前文本框内容  
	                if ($.trim.$(this).val() == "") {  
	                    $(this).addClass('UserText');//为空时添加红色边框  
	                }  
	                else {  
	                    $(this).removeClass('UserText');//不为空则移除  
	                }  
	            }); 
} */
        </script>
        <script type="text/javascript">
			function f(){
				var name=$("#userName").val();
				$.ajax({
				  	url : 'getStreamResult.action', //要提交的URL路径
					type : "post",                   //发送请求的方式
					data : 'name='+name,            //要发送到服务器的数据
					dataType : "text",              //指定传输的数据格式
					success : function(data) {//请求成功后要执行的代码
						$('#msg').html(data);
					},
					error : function() { //请求失败后要执行的代码
						$('#msg').html("请求失败!");
					}
				});
			}
		</script>
	</head>
	<body>
			<form action="LGAction?op=u_reg" name="form1" method="post">
				<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
					<tr>
						<th height="40" colspan="2" bgcolor="#FFFFFF" class="f12b-red">
							用 户 注 册
						</th>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9">
							用户名：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="u.u_name" id="userName"  onblur="f()" /><span id="msg"></span>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							密 码：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="password" name="u.u_pw"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							真实姓名：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="u.u_realname"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							住址：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="u.u_address"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							性别：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="u.u_sex"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							联系方式：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="u.u_tel"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							E-mail：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="u.u_email"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							QQ：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="u.u_qq"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							&nbsp;
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="submit" value="确定" onclick="return check()"/>
							<input type="button" value="取消" onclick="closeOpen()"/>
						</td>
					</tr>
				</table>
			</form>
	</body>
</html>
