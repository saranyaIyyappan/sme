<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico">
    <title>Payment Portal</title>
	<!-- bootstrap 3.3.7 -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
	<!-- font awesome -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
	<!-- ionicons -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ionicons.min.css">
	<!-- theme style -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/master_style.css">
	<!-- mpt_admin skins. choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/_all-skins.min.css">
	<!-- morris chart -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/morris.min.css">
	<!-- jvectormap -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-jvectormap.css">
	<!-- date picker -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-datepicker.min.css">
	<!-- daterange picker -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/daterangepicker.css">
	<!-- bootstrap wysihtml5 - text editor -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap3-wysihtml5.min.css">
    <link href="${pageContext.request.contextPath}/resources/toastr/toastr.min.css" rel='stylesheet' type='text/css' />
	<!-- google font -->
	<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet"> 
	
	<!-- jQuery 3 -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
	  $.widget.bridge('uibutton', $.ui.button);
	</script>
	<!-- Bootstrap v4.0.0-beta -->
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<!-- Morris.js charts -->
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
	<!-- Bootstrap WYSIHTML5 -->
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap3-wysihtml5.all.min.js"></script>
	<!-- Slimscroll -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery.slimscroll.min.js"></script>
	<!-- maximum_admin App -->
	<script src="${pageContext.request.contextPath}/resources/js/template.js"></script>
	<!-- popper -->
	<script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/customjs/security/login.js"></script>
	 <script src="${pageContext.request.contextPath}/resources/toastr/toastr.min.js"></script>
	 <script src="${pageContext.request.contextPath}/resources/js/crypto-js/aes.js"></script>
     <script src="${pageContext.request.contextPath}/resources/js/crypto-js/AesUtil.js"></script>
     <script src="${pageContext.request.contextPath}/resources/js/crypto-js/pbkdf2.js"></script>
	 
  </head>

<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href=""><b>Payment</b>Portal</a>
		</div>
		<!-- /.login-logo -->

		<c:if test="${not empty status}">
			<input type="hidden" id="hidden_status" value="${status}" />
			<input type="hidden" id="hidden_message" value="${message}" />
		</c:if>
	

		<div class="login-box-body">
			<p class="login-box-msg">Sign in to start your session</p>

			<form id="formId-login-form" class="form-element" method="post"
				action="${pageContext.request.contextPath}/user/login">
				<div class="form-group has-feedback">
					<input id="id-login-userId" type="text" class="form-control"
						placeholder="User Id"> <span
						class="ion ion-email form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input id="id-login-password" type="password" class="form-control"
						placeholder="Password"> <input id="login-user-id-hidden"
						type="hidden" name="cipher"> <input
						id="login-user-password-hidden" type="hidden" name="hash">
					<input id="login-user-iv-hidden" type="hidden" name="iv"> <input
						id="login-user-salt-hidden" type="hidden" name="salt"> <span
						class="ion ion-locked form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<div class="checkbox">
							<input type="checkbox" id="basic_checkbox_1"> <label
								for="basic_checkbox_1">Remember Me</label>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-lg-6">
						<div class="fog-pwd">
							<a href="javascript:void(0)"><i class="ion ion-locked"></i>
								Forgot pwd?</a><br>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-12 text-center">
						<button id="btn-id-login" type="button"
							class="btn btn-info btn-block btn-flat margin-top-10">SIGN
							IN</button>
					</div>
					<!-- /.col -->
				</div>
			</form>

			<div class="social-auth-links text-center">
				<p>- OR -</p>
				<a href="#" class="btn btn-social-icon btn-circle btn-facebook"><i
					class="fa fa-facebook"></i></a> <a href="#"
					class="btn btn-social-icon btn-circle btn-google"><i
					class="fa fa-google-plus"></i></a>
			</div>
			<!-- /.social-auth-links -->

			<div class="margin-top-30 text-center">
				<p>
					Don't have an account? <a href="register.html"
						class="text-info m-l-5">Sign Up</a>
				</p>
			</div>

		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->





</body>
</html>
