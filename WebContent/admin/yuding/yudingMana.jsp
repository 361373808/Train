<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		
        <script language="javascript">
           function yudingDel(yudingId)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/ManagerAction?op=deldd&id="+yudingId;
               }
           }
           function yudingShouli(id)
           {
               if(confirm('您确定受理该订单吗？'))
               {
                   window.location.href="<%=path %>/ManagerAction?op=shouli&id="+id;
               }
           }
           
           function chepiaoxinxi(c_id)
	        {
	             var url="<%=path %>/ManagerAction?op=ec2&c_id="+c_id;
                 var n="";
                 var w="520px";
                 var h="400px";
                 var s="resizable:no;help:no;status:no;scroll:no";
				 openWin(url,n,w,h,s);
	        }
	        
	        
	        function userxinxi(userId)
	        {
	             var url="<%=path %>/ManagerAction?op=uxx&u_id="+userId;
                 var n="";
                 var w="520px";
                 var h="400px";
                 var s="resizable:no;help:no;status:no;scroll:no";
				 openWin(url,n,w,h,s);
	        }
           
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan=7" background="<%=path %>/img/tbg.gif">&nbsp;车票预定&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="16%">预定时间</td>
					<td width="13%">预定车票</td>
					<td width="13%">预定用户</td>
					<td width="10%">预定数量</td>
					<td width="13%">支付方式</td>
					<td width="13%">状态</td>
					<td width="22%">操作</td>
		        </tr>	
				<s:iterator value="#session.list1" id="yuding">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#yuding.yuding_shijian"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="chepiaoxinxi(<s:property value="#yuding.c_id"/>)">车票信息</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <a href="#" onclick="userxinxi(<s:property value="#yuding.u_id"/>)">用户信息</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#yuding.yudingshumu"/>
					</td>
					<td  bgcolor="#FFFFFF" align="center">
					    <s:property value="#yuding.zhifufangshi"/>
					</td>
					<td  bgcolor="#FFFFFF" align="center" style="color: red">
					    <!--<s:if test="#yuding.yuding_zhuantai==0">
					        未受理
					    </s:if>
                        <s:if test="#yuding.yuding_zhuantai==1">
					        已受理
					    </s:if>-->
					    <s:property value="#yuding.zhuangtai"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="yudingDel(<s:property value="#yuding.id"/>)" class="pn-loperator">删除订单</a>
					    &nbsp;&nbsp;&nbsp;&nbsp;
					    <s:if test="#yuding.zhuangtai=='未受理'">
					        <a href="#" onclick="yudingShouli(<s:property value="#yuding.id"/>)" class="pn-loperator">受理订单</a>
					    </s:if>
					</td>
				</tr>
				</s:iterator>
			</table>
	</body>
</html>
