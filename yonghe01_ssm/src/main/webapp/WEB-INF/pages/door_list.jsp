<%@ page pageEncoding="utf-8"%>
<%-- 引入JSTL标签库 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<title>门店管理</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<style type="text/css">
	body{ font-family: "微软雅黑"; background-color: #EDEDED; }
	h2{ text-align: center;}
	table{ margin: 0 auto; text-align: center; border-collapse:collapse; font-size:16px;width:90%;}
	td, th{ padding: 7px;}
	th{ background-color: #DCDCDC; width:120px; }
	th.order{ width: 30px; }
	th.tel{ width: 80px; }
	th.opt{ width: 70px; }
	th.addr{ width: 250px; }
	hr{ margin-bottom:20px; border:1px solid #aaa; }
	#add-door{text-align:center;font-size:20px;}
</style>
	
<script type="text/javascript">
	
</script>
</head>
<body>
	<h2>门店管理</h2>
	<div id="add-door">
		<a href="door_add" target="rightFrame">新增门店</a>
	</div>
	<hr/>
	<table border="1">
		<tr>
			<th class="order">序号</th>
			<th>门店名称</th>
			<th class="tel">联系电话</th>
			<th class="addr">门店地址</th>
			<th class="opt">操 作</th>
		</tr>

		<!-- 模版数据 -->
		<c:forEach items="${ list }" var="door" varStatus="status">
		<tr>
			<td>${ door.id }</td>
			<td>${ door.name }</td>
			<td>${ door.tel }</td>
			<td>${ door.addr }</td>
			<td>
				<a href="doorDelete?id=${ door.id }">删除</a>
				&nbsp;|&nbsp;
				<a href="doorInfo?id=${ door.id }">修改</a>
			</td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>



