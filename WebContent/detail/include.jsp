<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="mft" class="cn.et.model.foodType.MyFoodType"></jsp:useBean>
<c:forEach var="temp" items="${pageScope.mft.allFoodType}">			
	<li>
		<a href="${pageContext.request.contextPath }/ShowFood?typeId=${pageScope.temp.TYPEID}">${pageScope.temp.TYPENAME}</a>
	</li>
</c:forEach>
