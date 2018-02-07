<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function inputTextBox(mNum){
	var check = document.getElementById("empCheckBox"+mNum);
	var name = document.getElementById("empName"+mNum).innerHTML;
	var sal = document.getElementById("empSal"+mNum).innerHTML;
	$('#empCheckBox'+mNum).attr("checked","checked");	
	$('#empName'+mNum).contents().unwrap().wrap('<td><input name="updateName" type="text" size="7" value="'+name+'"/></td>');
	$('#empSal'+mNum).contents().unwrap().wrap('<td><input name="updateSal" type="text" size="10" value="'+sal+'"/></td>');
	document.getElementById("tdId"+mNum).innerHTML+="<td><button name='updateId' value='"+mNum+"' type='submit'>수정완료</button></td>";

}
</script>
<body>
<div class="container">
<form action="${root}/emp/update">
<table border="1" class="table table-bordered">
	<tr>
		<th>선택</th>
		<th>번호</th>
		<th>이름</th>
		<th>월급</th>
		<th>버튼</th>
	</tr>
	<c:forEach items="${empList}" var="emp">
		
		<tr>
			<td><input id="empCheckBox${emp.empNo}" type="checkbox" name="deleteEmpNo" value="${emp.empNo}"/></td>
			<td><a href="${root}/emp/view?param=${emp.empName}">${emp.empNo}</a></td>
			<td><a id="empName${emp.empNo}" href="${root}/emp/view?param=${emp.empName}">${emp.empName}</a></td>
			<td><a id="empSal${emp.empNo}" href="${root}/emp/view?param=${emp.empName}">${emp.empSal}</a></td>
			<td id="tdId${emp.empNo}"><button type="button" onclick="inputTextBox(${emp.empNo})">수정</button></td>
		</tr>

	</c:forEach>
	
</table>
<button>사원정보삭제</button>
</form>	
<a href="${pPath}/emp/write"><button>사원정보추가</button></a>

</div>
</body>
</html>