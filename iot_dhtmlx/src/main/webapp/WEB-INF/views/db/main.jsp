<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
    html, body {
        width: 100%;      /*provides the correct work of a full-screen layout*/ 
        height: 100%;     /*provides the correct work of a full-screen layout*/
        overflow: hidden; /*hides the default body's space*/
        margin: 0px;      /*hides the body's scrolls*/
    }      
    div.controls {
         margin: 0px 10px;
         font-size: 14px;
         font-family: Tahoma;
         color: #404040;
         height: 80px;
      }
</style>
<script>

var formObj = [{type:"settings",offsetTop:12,name:"connectionInfo",lableAlign:"left"},
		  {type:"input",name:"ciName",label:"컨넥션이름",required:true},
		  {type:"input",name:"ciUrl",label:"접속URL",required:true},
		  {type:"input",name:"ciPort",label:"PORT번호",validate:"ValidInteger",required:true},
		  {type:"input",name:"ciDatabase",label:"Database",required:true},
		  {type:"input",name:"ciUser",label:"DB접속ID",required:true},
	      {type:"password",name:"ciPwd",label:"비밀번호",required:true},
	      {type:"password",name:"uiId",label:"사용자ID",required:true},
	      {type:"input",name:"ciEtc",label:"기타"},
		  {type:"block", blockOffset: 0, list:[
			  {type:"button",name:"saveBtn",value:"저장"},
			  {type:"newcolumn"},
			  {type:"button",name:"cancelBtn",value:"취소"}
		  ]}
	];



var bodyLayout;
dhtmlxEvent(window,"load",function(){
	bodyLayout = new dhtmlXLayoutObject(document.body,"3L");
	bodyLayout.cells("a").setWidth(300);
	bodyLayout.cells("a").setText("Connection Info List");
	bodyLayout.cells("b").setWidth(700);
	bodyLayout.cells("b").setText("bbbb");
	bodyLayout.cells("b").attachForm(formObj,true);
	bodyLayout.cells("c").setWidth(700);
	bodyLayout.cells("c").setText("cccc");
	
})
</script>
<body>
	<div class="controls"></div>
</body>
</html>