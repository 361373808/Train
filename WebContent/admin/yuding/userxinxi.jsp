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
        </script>
	</head>
	<body>
			<form action="<%=path %>/userReg.action" name="form1" method="post">
				<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9">
							用户名：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="userName" id="userName" value="${requestScope.user.u_name}" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							真实姓名：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="userRealname" value="${requestScope.user.u_realname}" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							住址：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="userAddress" value="${requestScope.user.u_address}" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							性别：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="userSex" value="${requestScope.user.u_sex}" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							联系方式：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="userTel" value="${requestScope.user.u_tel}" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							E-mail：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="userEmail" value="${requestScope.user.u_email}" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							QQ：
						</td>
						<td bgcolor="#FFFFFF">
							&nbsp;
							<input type="text" name="userQq" value="${requestScope.user.u_qq}" readonly="readonly"/>
						</td>
					</tr>
				</table>
			</form>
	</body>
</html>
