$(document).ready(function() {
   	toastr.options = {
	 	"preventDuplicates" : true,	
	 	"preventOpenDuplicates" : true,
	    "positionClass": "toast-bottom-right",
	 };
      var contextPath = $('#app-context-path').val();
      
      $("#id-div-change-password").hide();
      
  	$("#id-new-password").on('keyup keydown', function() {
		$("#id-div-change-password").show();
	 	passwordStrength($(this).val());
	});		
				
  	var passwordStrength = function(password) {
			var desc = [{'width':'0px'}, {'width':'20%'}, {'width':'40%'}, {'width':'60%'}, {'width':'80%'}, {'width':'100%'}];
			var descClass = ['', 'progress-bar-danger', 'progress-bar-danger', 'progress-bar-warning', 'progress-bar-success', 'progress-bar-success'];
			var score = 1;
			if (password.length > 6) score++;
			if ((password.match(/[a-z]/)) && (password.match(/[A-Z]/))) score++;
			if (password.match(/d+/)) score++;
			if ( password.match(/.[!,@,#,$,%,^,&,*,?,_,~,-,(,)]/) )	score++;
			if (password.length< 6) score = 1;
			if (password.length== 0) score=0;
			$("#id-change-password").removeClass().addClass("progress-bar"+" "+descClass[score]).css(desc[score]);
				
					
	}
  	
   $("#id-profile-change-password").click(function() {
		var newPassword = $('#id-new-password').val();
		var confirmPassword = $('#id-new-confirm-password').val();
		var progressBarClass=$("#id-change-password").attr('class');
		var array = progressBarClass.split(" ");
		 if (newPassword.trim() == "" || newPassword == null) {
			toastr .warning("Please provide New Password");
		}else if (confirmPassword.trim() == "" || confirmPassword == null) {
			toastr .warning("Please provide Confirm password");
		} else if (newPassword != confirmPassword) {
			toastr .warning("Both New Password and Confirm Password must be match");
		}else if(progressBarClass=="progress-bar progress-bar-danger"||progressBarClass=="progress-bar"||array[array.length-1]=="progress-bar-danger"){
			toastr.warning("Please choose a more secure password.");
		}else {
			var iterationCount = 1000;
			var keySize = 128;
			var passphrase = "1234567abcdef";
			var iv = CryptoJS.lib.WordArray .random(128 / 8).toString(CryptoJS.enc.Hex);
			var salt = CryptoJS.lib.WordArray .random(128 / 8).toString(CryptoJS.enc.Hex);
			var aesUtil = new AesUtil(keySize, iterationCount);
			var newPasswordHash = aesUtil.encrypt(salt, iv, passphrase, confirmPassword);
			 $('#id-new-password').val("");
			 $('#id-new-confirm-password').val("");
			 $('#login-user-iv-hidden').val("");
			 $('#login-user-salt-hidden').val("");
		    $('#id-new-password').val(newPasswordHash);
		    $('#id-new-confirm-password').val(newPasswordHash);
		    $('#login-user-iv-hidden').val(iv);
			$('#login-user-salt-hidden').val(salt);
			$.ajax({
				url :contextPath+"/user/changePassword",
				type : 'POST',
				dataType : "json",
				data :$("#id-form-changePassword").serialize(),
				beforeSend: function() {
			        $("#id-gif-loader").show();
			    },success : function(data) {
			    	 $("#id-gif-loader").hide();
			       if (data.status == 'Success') {
			    	   $("#id-profile-change-password").attr("disabled","disabled");
		     			toastr.success(data.message);
		     			 var timer = setTimeout(function() {
		     	            window.location=contextPath+'/user/index'
		     	        }, 3000);
		     			
				  }else{
					  $('#id-new-password').val("");
					  $('#id-new-confirm-password').val("");
					  $("#id-change-password").removeClass();
					  $("#id-change-password").css("'width':'0px'");
					  toastr.warning(data.message);
				  }
					
				},error : function() {
					 toastr.error("Unable to contact the server, Please try after some time");
				}
			});
		
			
			
			
			
			
			
			
		}

	});
  	
  	
  	
      
      
      
});