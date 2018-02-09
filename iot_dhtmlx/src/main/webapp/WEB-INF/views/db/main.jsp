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

/* var formObj = [{type:"settings",offsetTop:12,name:"connectionInfo",lableAlign:"left"},
		  {type:"input",name:"uiId",label:"사용자 ID",required:true},
		  {type:"password",name:"uiPwd",label:"사용자 PWD",required:true},
		  {type:"block", blockOffset: 0, list:[
			  {type:"button",name:"signupBtn",value:"회원가입"},
			  {type:"newcolumn"},
			  {type:"button",name:"loginBtn",value:"로그인"},
			  {type:"newcolumn"},
			  {type:"button",name:"cancelBtn",value:"초기화"}
		  ]}
	]; */

var bodyLayout, aLay,bLay,cLay,dLay,dbTree;
function callback(res){

   dbTree = aLay.attachTreeView({
       items: res.dbList
   });
   //dbTree.setImagePath("${rPath}/dx/skins/web/imgs/dhxtree_web/");
   dbTree.enableDragAndDrop(true);
}


function callbackInsertUser(res){
	
}

function callbackLoginUser(loader,res){
	var res=JSON.parse(res);
 	alert(res.msg);
}

dhtmlxEvent(window,"load",function(){
   bodyLayout = new dhtmlXLayoutObject(document.body,"3L");
   //aLay= bodyLayout.cells("a");
  // aLay.setWidth(300);
   //aLay.setText("Login");
   //var aForm = aLay.attachForm(formObj,true);
   
   aLay = bodyLayout.cells("a");
   aLay.setWidth(300);
   aLay.setText("DataBaseTree");
   var aToolbar = aLay.attachToolbar();
   aToolbar.addButton("adddb",1,"add Connector");
   aToolbar.addButton("condb",2,"Connection");
   aToolbar.attachEvent("onClick",function(id){
      alert(id);
   })
   
   
   bLay = bodyLayout.cells("b");
   bLay.setText("Insert Query");
   cLay = bodyLayout.cells("c");
   cLay.setText("Result Query");
   
   var au = new AjaxUtil("${root}/connection/db_list",null,"get");
   au.setCallbackSuccess(callback);
   au.send(); 
    
   		
/*     aForm.attachEvent("onButtonClick",function(id){
				if(id=="loginBtn"){
					
				 	if(aForm.validate()){ 
						aForm.send("${root}/user/login","POST",callbackLoginUser);
					}
				}else if(id=="cancelBtn"){
					aForm.clear();
				}else if(id=="signupBtn"){
					alert("???");
					document.location.href="dx_form";
				}
		}); */
})
</script>
<body>

</body>
</html>