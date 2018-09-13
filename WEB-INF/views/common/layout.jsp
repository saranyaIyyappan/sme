<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="referrer" content="no-referrer" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
      	<!-- bootstrap 3.3.7 -->
      		
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
	<!-- font awesome -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
	<!-- ionicons -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ionicons.min.css">

	<!-- theme style -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/master_style.css">
	
	<!-- mpt_admin skins. choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/_all-skins.min.css">
 	
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/blue.css">
 	
 	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap3-wysihtml5.min.css">
	<!-- jvectormap -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-jvectormap.css">
	
    <link href="${pageContext.request.contextPath}/resources/toastr/toastr.min.css" rel='stylesheet' type='text/css' />
	 
	<!-- date picker -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-datepicker.min.css">
	<!-- daterange picker -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/daterangepicker.css">
	<!-- bootstrap wysihtml5 - text editor -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/uploadfile.css">

	<!-- google font -->
	<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet"> 
	 <link href="${pageContext.request.contextPath}/resources/css/custom.css" rel="stylesheet"> 

	<!-- jQuery 3 -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
 	<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	
	<!-- Bootstrap v4.0.0-beta -->
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	
	<!-- Slimscroll -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery.slimscroll.min.js"></script>
	<!-- maximum_admin App -->
	<script src="${pageContext.request.contextPath}/resources/js/template.js"></script>

	 <script src="${pageContext.request.contextPath}/resources/js/icheck.js"></script> 
	 <script src="${pageContext.request.contextPath}/resources/js/bootstrap3-wysihtml5.all.min.js"></script>
	
	
	<script src="${pageContext.request.contextPath}/resources/js/mailboxplugin.js"></script>
	
	<script src="${pageContext.request.contextPath}/resources/js/raphael.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/morris.min.js"></script>
	<!-- Sparkline -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery.sparkline.min.js"></script>
	<!-- jvectormap -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery-jvectormap-1.2.2.min.js"></script>	
	<script src="${pageContext.request.contextPath}/resources/js/jquery-jvectormap-world-mill-en.js"></script>
	<!-- jQuery Knob Chart -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery.knob.min.js"></script>
	<!-- daterangepicker -->
	<script src="${pageContext.request.contextPath}/resources/js/moment.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/daterangepicker.js"></script>
	<!-- datepicker -->
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap-datepicker.min.js"></script>

	<script src="${pageContext.request.contextPath}/resources/toastr/toastr.min.js"></script>
	<!-- popper -->
	<script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
	<!-- Bootstrap WYSIHTML5 -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery.uploadfile.js"></script>
	<!-- Morris.js charts -->
	
<script>
	  $.widget.bridge('uibutton', $.ui.button);
</script> 
	
        <tiles:insertAttribute name="customJs" defaultValue="" />
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
    </head>
    <body  class="hold-transition skin-blue sidebar-mini">

	        <div class="wrapper">
	            <tiles:insertAttribute name="header" />
	            <tiles:insertAttribute name="leftbar" /> 
	            <tiles:insertAttribute name="body" />
	            <tiles:insertAttribute name="footer" />
	        </div>
</body>
</html>