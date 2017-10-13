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
		<script language="javascript">
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
	               document.form1.submit();
             }
        </script>
	</head>
	<body>
			<form action="<%=path %>/userEdit.action" name="form1" method="post">
				<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9">
							用户名：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="userName" id="userName" value="${sessionScope.user.u_name}" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							密 码：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="password" name="userPw" value="${sessionScope.user.u_pw}" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							真实姓名：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="userRealname" value="${sessionScope.user.u_realname}"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							住址：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="userAddress" value="${sessionScope.user.u_address}"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							性别：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="userSex" value="${sessionScope.user.u_sex}"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							联系方式：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="userTel" value="${sessionScope.user.u_tel}"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							E-mail：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="userEmail" value="${sessionScope.user.u_email}"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							QQ：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="userQq" value="${sessionScope.user.u_qq}"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							&nbsp;
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="submit" value="修改" onclick="return check()"/>
							<input type="button" value="取消" onclick="closeOpen()"/>
						</td>
					</tr>
				</table>
			</form>
	</body>
</html>
