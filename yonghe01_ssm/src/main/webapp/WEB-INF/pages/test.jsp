<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
	<div style="background-color: #E0FEEB; text-align: center">
		<h1>test springmvc!!!</h1>
		${ list } <span>遍历</span>
		<c:forEach items="${ list }" var="door">
			<div style="background-color: #FFDFFE">
				${ door.id }<br> ${ door.name }<br> ${ door.tel }<br>
				${ door.addr }<br>
			</div>
		</c:forEach>
	</div>
</body>
</html>