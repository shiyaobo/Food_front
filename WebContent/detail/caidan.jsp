﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="${pageContext.request.contextPath }/detail/style/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/detail/style/js/page_common.js"></script>
<link href="${pageContext.request.contextPath }/detail/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/detail/style/css/index_1.css" />
	<link href="${pageContext.request.contextPath }/detail/style/css/index.css" rel="stylesheet" type="text/css" />
</head>
<body style="text-align: center">
	<div id="all">
		<div id="menu">
			<!-- 显示菜品的div -->
			<div id="top">
				<ul>
					<!-- 循环列出餐品 -->
						<c:forEach var="tmp" items="${requestScope.foodList.data }">
						<li>
							<dl>
								<dt>
									<a href="${pageContext.request.contextPath }/detail/caixiangxi.jsp?fid=${pageScope.tmp.FOODID}&fname=${pageScope.tmp.FOODNAME }&price=${pageScope.tmp.PRICE}&imagePath=${pageScope.tmp.IMAGEPATH}">
										<img width="214px" height="145px" src="${pageContext.request.contextPath }/ic?imageName=${pageScope.tmp.IMAGEPATH}" />
									</a>
								</dt>
								<dd class="f1">
									<a href="${pageContext.request.contextPath }/detail/caixiangxi.jsp?fid=${pageScope.tmp.FOODID}&fname=${pageScope.tmp.FOODNAME }&price=${pageScope.tmp.PRICE}&imagePath=${pageScope.tmp.IMAGEPATH}">${pageScope.tmp.FOODNAME }</a>
								</dd>
								<dd class="f2">
									<a href="${pageContext.request.contextPath }/detail/caixiangxi.jsp?fid=${pageScope.tmp.FOODID}&fname=${pageScope.tmp.FOODNAME }&price=${pageScope.tmp.PRICE}&imagePath=${pageScope.tmp.IMAGEPATH}">&yen;${pageScope.tmp.PRICE }</a>
								</dd>
							</dl>
						</li>
						</c:forEach>
				</ul>
			</div>
			
			<!-- 底部分页导航条div -->
			<div id="foot">
						<span
							style="float:left; line-height:53PX; margin-left:-50px; font-weight:bold; ">
							<span style="font-weight:bold">&lt;&lt;</span>
						</span>
					
				
				<div id="btn">
					<ul>
						<!-- 参看 百度, 谷歌是 左 5 右 4 -->
						
							<li><a
								href="#">1</a></li>
						
							<li><a
								href="#">2</a></li>
						
					</ul>
				</div>
				
					
						<span style="float:right; line-height:53px; margin-right:10px;  ">
							<a
							href="#"
							style=" text-decoration:none;color:#000000; font-weight:bold">&gt;&gt;</a>
						</span>
					
			</div>
			
		</div>

		<!-- 右边菜系列表，菜品搜索框  -->
		<div id="dish_class">
			<div id="dish_top">
				<ul>
				<li class="dish_num"></li>
					<li>
						<a href="${pageContext.request.contextPath }/detail/clientOrderList.html">
							<img src="${pageContext.request.contextPath }/detail/style/images/call2.gif" />
						</a>
					</li>
				</ul>
			</div>

			<div id="dish_2">
				<ul>
					<jsp:include page="include.jsp"></jsp:include>
					
				</ul>
			</div>
			<div id="dish_3">
				<!-- 搜索菜品表单  -->
				<form action="#" method="post">
					<table width="166px">
						<tr>
							<td>
								<input type="text" id="dish_name" name="foodName" class="select_value" /> 
								<input type="hidden" value="selectFood" name="method">
							</td>
						</tr>
						<tr>
							<td><input type="submit" id="sub" value="" /></td>
						</tr>
						<tr>
							<td>
								<a href="#">
									<img src="style/images/look.gif" />
								</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>
