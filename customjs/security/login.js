$(document).ready(function() {
			

			toastr.options = {
						"preventDuplicates" : true,
						"preventOpenDuplicates" : true,
						"positionClass": "toast-bottom-right",
					 };

			var contextPath = $('#app-context-path').val();
			var iterationCount = 1000;
			var keySize = 128;
			var passphrase = "1234567abcdef";
			var contextPath = $('#app-context-path').val();
			var hiddenStatus = $('#hidden_status').val();
			var hiddenMessage = $('#hidden_message').val();
			
			if (typeof hiddenStatus != 'undefined' && hiddenStatus != null && hiddenStatus != ""
					&& typeof hiddenMessage != 'undefined'
					&& hiddenMessage != null && hiddenMessage != "") {
				if (hiddenStatus == "Success") {
					toastr.info(hiddenMessage);
				} else {
					toastr.error(hiddenMessage);
				}

			}
			$('#btn-id-login').click(
					function(e) {
						
					e.preventDefault();
						var userId = $('#id-login-userId').val();
						var password = $('#id-login-password').val();
						var iv = CryptoJS.lib.WordArray.random(128 / 8)
								.toString(CryptoJS.enc.Hex);
						var salt = CryptoJS.lib.WordArray.random(128 / 8)
								.toString(CryptoJS.enc.Hex);
						var aesUtil = new AesUtil(keySize, iterationCount);
						var ciphertext = aesUtil.encrypt(salt, iv, passphrase,
								userId);
						var hashtext = aesUtil.encrypt(salt, iv, passphrase,
								password);
					
						$('#login-user-id-hidden').val(ciphertext);
						$('#login-user-password-hidden').val(hashtext);
						$('#login-user-iv-hidden').val(iv);
						$('#login-user-salt-hidden').val(salt);
//						$('#already-loggedin-user').val("0");

						
						if (userId == "") {
							toastr.warning("Please provide User Name");
						} else if (password == "") {
							toastr.warning("Please provide Password");
						} else {
							$("#formId-login-form").submit();
		
						}
					});
			

			$("#btn-id-register").click(function() {
				location.href = contextPath + "/user/registerNewCustomer";
			})
			
			$("#id-result1").hide();
			$("#id-result2").hide();
			
			$("#id-forgot-submit").click(function() {
				var emailId=$("#id-forgot-emailId").val();
				 	if (emailId.trim() == "") {
						toastr.warning("Please provide Email ID");
					} else if (!validateEmail(emailId)) {
						toastr.warning("Please provide valid Email ID");
					}else{
						$.ajax({
							url :contextPath+"/user/forgotPassWordMail",
							type : 'POST',
							dataType : "json",
							data : {emailId:emailId},
							beforeSend: function() {
						        $("#id-gif-loader").show();
						    },success : function(data) {
						    	 $("#id-gif-loader").hide();
								if (data.status == "Success") { 
									$("#id-forgot-emailId").val("");
									$("#id-result1").show();
									$("#id-result2").hide();
									$("#id-result3").hide();
									$("#id-result4").hide();
									$("#id-forgot-submit").hide();
								} else if(data.status == "error") {
									$("#id-result1").hide();
									$("#id-result2").hide();
									$("#id-result3").show();
									$("#id-result4").show();
								}else {
									$("#id-result1").hide();
									$("#id-result2").show();
									$("#id-result3").show();
									$("#id-result4").show();
									 
								}
							},
							error : function() {
								 toastr.error("Unable to contact the server, Please try after some time");
							}
						});
					}
			})
			
			var validateEmail = function(email) {
				var re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
				return re.test(email);
			}
			
			$("#id-a-forgot-password").click(function() {
				$("#id-result1").hide();
				$("#id-result2").hide();
				$("#id-result4").hide();
				$("#id-result3").show();
				$("#id-forgot-submit").show();
				$("#id-forgot-emailId").val("");
				
			})
		});
