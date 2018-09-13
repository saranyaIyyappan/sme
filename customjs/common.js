var exchangeDataArr=[];
var exchangeBuyRate = 1;
var exchangeSellRate = 1;   
var fromCurrency="XRP";
var toCurrency="USD";
var market = "coinbase";

$(document).ready(function(){
	   var contextPath = $('#app-context-path').val();
	  $('ul.navbar-left li a').click(function(){
	     $('li a').removeClass("active");
	     $(this).addClass("active");
	 });
	  
	  toastr.options = {
				"preventDuplicates" : true,
				"preventOpenDuplicates" : true,
				"positionClass": "toast-bottom-right",
			};
	  
	   var headerProfilePic = function() {
			$.ajax({
				url : contextPath+ "/profile/getProfileDetails",
				type : 'POST',
				dataType : "json",
				success : function(data) {
					var profileImage = data.profileImage;
							if (profileImage != "") {
								$("#id-header-profilePic").attr("src", data.profileImage);
							}
						},
						error : function() {
							toastr.error("Unable to contact the server, Please try after some time");
						}
					});
		}
	   
	   headerProfilePic();
	   
 
 	   
	 });
 