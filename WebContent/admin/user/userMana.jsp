<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
        <script language="javascript">
           function userDel(u_id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/LGAction?op=delete&u.u_id="+u_id;
               }
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="12" background="<%=path %>/img/tbg.gif">&nbsp;注册用户维护&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="8%">ID</td>
					<td width="8%">用户名</td>
					<td width="8%">密码</td>
					<td width="8%">真实姓名</td>
					<td width="10%">住址</td>
					<td width="8%">性别</td>
					<td width="10%">联系方式</td>
					<td width="8%">E-mail</td>
					<td width="8%">QQ</td>
					<td width="8%">会员等级</td>
					<td width="8%">积分</td>
					<td width="8%">操作</td>
		        </tr>	
				<s:iterator value="#request.all" id="user">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#user.u_id"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#user.u_name"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#user.u_pw"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#user.u_realname"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#user.u_address"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#user.u_sex"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#user.u_tel"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#user.u_email"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#user.u_qq"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    	<s:property value="#user.u_type"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#user.u_score"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="userDel(<s:property value="#user.u_id"/>)" class="pn-loperator">删除</a>
					</td>
				</tr>
				</s:iterator>
			</table>
	</body>
</html>
