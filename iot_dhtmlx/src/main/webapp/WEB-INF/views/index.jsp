<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
</head>
<body>
<a href="${root}/emp/list">사원조회</a>
</body>
</html> --%>
<html>
<head>
	<meta charset="utf-8">
	<title>jQuery Square Menu by Pete R. | The Pete Design</title>
	<meta name="title" content="jQuery Square Menu by Pete R. | The Pete Design" />
	<meta name="description" content="Create a Square-like Menu Animation for Website using jQuery and CSS3" />
	<link rel="image_src" href="/images/square_menu_image.png" />

	<meta content="http://www.thepetedesign.com/demos/square_menu_demo.html" property="og:url" />
	<meta content="http://www.thepetedesign.com/images/square_menu_image.png" property="og:image" />
	<link rel="shortcut icon" id="favicon" href="favicon.png"> 
	<meta name="author" content="Pete R.">
	<link rel="canonical" href="http://www.thepetedesign.com/demos/square_menu_demo.html" />
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,700' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Noto+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Pacifico' rel='stylesheet' type='text/css'>
	<link href='${rPath}/ui/css/square_menu.css' rel='stylesheet' type='text/css'>
	<link href='${rPath}/ui/css/square_menu_my.css' rel='stylesheet' type='text/css'>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script type="text/javascript" src="${rPath}/ui/js/jquery.square_menu.js"></script>
  
	<script>
	  $(document).ready( function() {
	    $(".sidemenu").square_menu();
	  });
		
	</script>
</head>
<body>
  <div class="wrapper">
	  <div class="main">
	    <div class="header">
        <!-- <h1>jQuery Square Menu</h1>
        <h2>Create a Square-like Menu Animation for Website using jQuery and CSS3</h2>
        <p class="credit">Created by <a href="http://www.thepetedesign.com">Pete R.</a>, Founder of <a href="http://www.bucketlistly.com" target="_blank">BucketListly</a></p> -->
        <div class="btns">
   	     <!--  <a class="reload btn" href="https://github.com/peachananr/square_menu">Download on Github</a>  -->
  	    </div>
  	  </div>
  	  
      <div class="page-container">
        <div class="sidemenu">
          <nav class="left">
            <a href="#">사원목록</a>
            <a href="#">TO DO1</a>
            <a href="#">TO DO2</a>
          </nav>
          <nav class="right">
            <a href="${root}/emp/list">사원 리스트</a>
            <a href="${pPath}/emp/write">사원 등록</a>
            <a href="${root}/emp/list">사원 검색</a>
            <a href="${root}/emp/list">사원 삭제</a>
<!--             <a href="#">Incredible India 1/2</a>
            <a href="#">Inspiring Indonesia</a>
            <a href="#">Curious Cambodia</a> -->
          </nav>
        </div>
      </div>
    </div>
  <!--   <a class="back" href="http://www.thepetedesign.com/#design">Back to The Pete Design</a> -->
    <!-- <a href="https://github.com/peachananr/square_menu"><img style="position: absolute; top: 0; right: 0; border: 0; z-index: 15;" src="https://s3.amazonaws.com/github/ribbons/forkme_right_darkblue_121621.png" alt="Fork me on GitHub"></a> -->
  </div>
</body>
</html>