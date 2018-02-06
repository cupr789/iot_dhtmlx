<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<form action="${root}/emp/delete">
<table border="1" class="table table-bordered">
	<tr>
		<th>선택</th>
		<th>번호</th>
		<th>이름</th>
		<th>월급</th>
	</tr>
	<c:forEach items="${empList}" var="emp">
		
		<tr>
			<td><input type="checkbox" name="deleteEmpNo" value="${emp.empNo}"/></td>
			<td><a href="${root}/emp/view?param=${emp.empName}">${emp.empNo}</a></td>
			<td><a href="${root}/emp/view?param=${emp.empName}">${emp.empName}</a></td>
			<td><a href="${root}/emp/view?param=${emp.empName}">${emp.empSal}</a></td>
		</tr>

	</c:forEach>
	
</table>
<button>사원정보삭제</button>
</form>	
<a href="${pPath}/emp/write"><button>사원정보추가</button></a>

</div>
</body>
</html>