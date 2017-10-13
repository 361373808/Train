<%@ page language="java" pageEncoding="UTF-8"%>

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
		
		<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
        <script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
		<script language="javascript">
            function closeOpen()
		    {
		       window.returnValue=false;
		       window.close();
		    }
		    function yingfujine()
		    {
		        var userId=document.getElementById("u_Id").value;
		        var checiId=document.getElementById("c_d").value;
		        var yudingShumu=document.getElementById("yudingshumu").value;
		        loginService.yingfujine(userId,checiId,yudingShumu,callback);
		    }
		    function callback(data)
		    {
		        document.getElementById("div1").innerHTML=data;
		    }
		    
        </script>
	</head>
	<body>
			<form action="<%=path %>/LGAction?op=buy" name="form1" method="post">
				<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
					<tr>
						<th height="40" colspan="2" bgcolor="#FFFFFF" class="f12b-red"> 
							预定车票 
						</th>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9">
							预定数量：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<input type="text"  size="10" onblur="yingfujine()"  name="y.yudingshumu" id="yudingShumu" value="1" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
						    &nbsp;&nbsp;&nbsp;<span id="div1" style="font-size: 11px;">应付金额:</span><input type="hidden" name="yudingjine"/>
						</td>
					</tr>
					<tr>
						<td width="20%" height="30" align="right" bgcolor="#F9F9F9">
							支付方式：
						</td>
						<td width="80%" bgcolor="#FFFFFF">
							&nbsp;
							<select name="y.zhifufangshi">
							    <option value="票到付款">票到付款</option>
							    <option value="银行付款">银行付款</option>
							</select>
						</td>
					</tr>
					<tr>
						<td height="30" align="right" bgcolor="#F9F9F9">
							&nbsp;
						</td>
						<td bgcolor="#FFFFFF">
							<input type="hidden" name="y.c_id" id="checiId" value="<%=request.getParameter("c_id") %>"/>
							<input type="hidden" name="y.u_id" id="userId" value="${sessionScope.tu.u_id}"/>
							<input type="submit" value="确定"/>
						</td>
					</tr>
				</table>
			</form>
	</body>
</html>
