<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		
		<link href="<%=path %>/css/layout.css" type="text/css" rel="stylesheet" />
		
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		<script type="text/javascript">
	        function yuding(checiId)
	        {
	            <s:if test="#session.tu==null">
				     alert("请先登录");
				</s:if>
				<s:else>
				     var url="<%=path %>/LGAction?op=buy&id="+checiId;
	                 var n="";
	                 var w="520px";
	                 var h="300px";
	                 var s="resizable:no;help:no;status:no;scroll:no";
					 openWin(url,n,w,h,s);
				</s:else>
	        }
		</script>
	</head>

	<body>
		<jsp:include flush="true" page="/qiantai/inc/incTop.jsp"></jsp:include>
		<div class="page_row">
		    <!--左边的 -->
			<div class="page_main_msg left">
				<div class="page_main_msg left">
			         <div class="left_row">
			              <div class="list pic_news">
					          <div class="list_bar">车次信息</div>
					          <div class="list_content">
	                              <div class="c1-body">
                                      <table border="0" width="100%">
                                         <tr align="left" height="22">
											<td width="15%">车次路线</td>
											<td width="15%">车票日期</td>
											<td width="15%">发车时间</td>
											<td width="15%">到达时间</td>
											<td width="12%">票价</td>
											<td width="13%">票数</td>
											<td width="15%">操作</td>
								         </tr>
                                         <s:iterator value="#session.list" id="checi">
										 <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
											<td bgcolor="#FFFFFF" align="left">
												<s:property value="#checi.shifazhan"/>--<s:property value="#checi.daodazhan"/>
											</td>
											<td bgcolor="#FFFFFF" align="left">
												<s:property value="#checi.piaoshijian"/>
											</td>
											<td bgcolor="#FFFFFF" align="left">
												<s:property value="#checi.startshijian"/>
											</td>
											<td bgcolor="#FFFFFF" align="left">
											    <s:property value="#checi.endshijian"/>
											</td>
											<td bgcolor="#FFFFFF" align="left">
												<s:property value="#checi.piaojia"/>
											</td>
											<td  bgcolor="#FFFFFF" align="left">
											    <s:property value="#checi.piaoshu"/>
											</td>
											<td bgcolor="#FFFFFF" align="left">
												<a href="#" onclick="yuding(<s:property value="#checi.id"/>)" class="pn-loperator">预定</a>
											</td>
										  </tr>
										  </s:iterator>
                                      </table>
									  <div class="pg-3">
										   <!--  分页-->
									  </div>		  
							      </div>
							  </div>
						  </div>	
					      <div style="clear:both;"></div>
				     </div>
				</div>
			</div>
			<!--左边的 -->
			
			<!-- 右边的用户登录。留言。投票 -->
			<div class="page_other_msg right">
				<jsp:include flush="true" page="/qiantai/inc/incLeft.jsp"></jsp:include>
			</div>
			<div style="clear: both"></div>
			<!-- 右边的用户登录。留言。投票 -->
		</div>
		
		<div class="foot">
		   <jsp:include flush="true" page="/qiantai/inc/incFoot.jsp"></jsp:include>
	    </div>
	</body>
</html>
