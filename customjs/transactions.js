$(document).ready(function(){
	
	var contextPath = $('#app-context-path').val();
	   toastr.options = {
				"preventDuplicates" : true,
				"preventOpenDuplicates" : true,
				"positionClass": "toast-bottom-right",
			};
	   
		 //Date range picker
	    $('#id-date-range').daterangepicker();  
	   
	   var getTransactions = function() {
			$.ajax({
				url : contextPath+ "/transaction/getAllTranactions",
				type : 'POST',
				dataType : "json",
				data:{
					startCount:0,
					nextCount:10
				},
				success : function(data) {
					
					var data = data.Data;
					 $("#id-transaction-list").empty();
			    	 for ( var i in data) {
						$("#id-transaction-list").append('<li  class="item" onclick="javascript:getOperations(\''+data[i].transactionId+'\',\''+data[i].status+'\');"><div><strong>'+data[i].transactionId+'<span class="pull-right">'+data[i].amount+' '+data[i].currencyCode+'</span></strong></div><div class="text-muted">'+data[i].merchantReference+'<span class="pull-right">'+data[i].dateCre+'</span></div></li>'); 
					
			    	 }
					
			    	 },
						error : function() {
							toastr.error("Unable to contact the server, Please try after some time");
						}
					});
		}
	      
	   
	   getTransactions();
	   
	
	
	  
	   
});

function getOperations(transactionId,status) {
	

	
	var contextPath = $('#app-context-path').val();
		$.ajax({
			url : contextPath+ "/transaction/getOperationforTransaction",
			type : 'POST',
			dataType : "json",
			data:{
				transactionId:transactionId
			},
			success : function(data) {
				var data = data.Data;
				
				 $("#id-transaction-oprn").empty();
					$("#id-status").html("Status : "+status);
		    	 for ( var i in data) {
					$("#id-transaction-oprn").append('<li class="time-label"> <span class="bg-red">'+data[i].dateCreated+'</span></li><li><i class="ion  bg-blue"></i><div class="timeline-item"><span class="time"><span class="badge label-success">accepted</span> </span><h3 class="timeline-header">'+data[i].amount+' '+data[i].currencyCode+'</h3><div class="timeline-body"><p> Autherization Code :'+data[i].authorizationCode+'</p><p>Operation :'+data[i].operation+'</p></div></div></li>'); 
				
		    	 }
		
	    	 },
					error : function() {
						toastr.error("Unable to contact the server, Please try after some time");
					}
				});
		


	   

	}
  