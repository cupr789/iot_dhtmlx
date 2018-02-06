<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
	var au = new AjaxUtil("${root}/emp/lista", null, "GET", "json");
	function callback(res) {
		$("#empTable").bootstrapTable('load',{data:res.empList});
		$("#userTable").bootstrapTable('load',{data:res.userList});
	}
	au.setCallbackSuccess(callback);
	au.send();
</script>
<body>
	<div class="container">
			<table data-toggle="table" id="empTable">
				<thead>
					<tr>
						<th data-field="empNo">번호</th>
						<th data-field="empName">이름</th>
						<th data-field="empSal">월급</th>
					</tr>
				</thead>
				<tbody id="tBody">
				</tbody>
				<c:forEach items="${empList}" var="emp">

					<tr>
						<td><input type="checkbox" name="deleteEmpNo" value="${emp.empNo}" /></td>
						<td><a href="${root}/emp/view?param=${emp.empName}">${emp.empNo}</a></td>
						<td><a href="${root}/emp/view?param=${emp.empName}">${emp.empName}</a></td>
						<td><a href="${root}/emp/view?param=${emp.empName}">${emp.empSal}</a></td>
					</tr>

				</c:forEach>
			</table>
			<a href="${pPath}/emp/write"><button>사원정보추가</button></a> 
			<a href="${root}/emp/delete"><button>사원정보삭제</button></a>
			
			<table data-toggle="table" id="userTable">
				<thead>
					<tr>
						<th data-field="uino">번호</th>
						<th data-field="uiname">이름</th>
						<th data-field="uiid">아이디</th>
					</tr>
				</thead>
				<tbody id="tBody">
				</tbody>
				<c:forEach items="${empList}" var="emp">

					<tr>
						<td><input type="checkbox" name="deleteEmpNo"
							value="${emp.empNo}" /></td>
						<td><a href="${root}/emp/view?param=${emp.empName}">${emp.empNo}</a></td>
						<td><a href="${root}/emp/view?param=${emp.empName}">${emp.empName}</a></td>
						<td><a href="${root}/emp/view?param=${emp.empName}">${emp.empSal}</a></td>
					</tr>

				</c:forEach>
			</table>
			<a href="${pPath}/emp/write"><button>사원정보추가</button></a> 
			<a href="${root}/emp/delete"><button>사원정보삭제</button></a>
	</div>
</body>
</html>