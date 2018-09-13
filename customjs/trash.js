var contextPath = $('#app-context-path').val();
$(document).ready(function() {
	var msgid = [];
	var getTrashMail=function(){
		$.ajax({
		     url : contextPath + "/mailBox/getTrashMessages",
		     type : 'POST',
		     dataType : "json",
		     success : function(data){
				  $("#id-trash-messages").empty();
				     for ( var i in data) {
				    	 var messageId=data[i].messageId;
						var toid = data[i].toid;
						var subject = data[i].subject;
						var body = data[i].body;
						var senttime = data[i].senttime;
						
						$("#id-trash-messages").append('<tr><td> <input id=id-check-'+i+' type="checkbox" value="'+data[i].messageId+'"></td><td class="mailbox-star"><a href="#"><i class="fa fa-star-o text-yellow"></i></a></td><td class="mailbox-name">'
												+ toid
												+ '</td> <td class="mailbox-subject"><a href='+contextPath+'/user/readMail?messageId='+messageId+'><b>'
												+ subject
												+ '</b><span class="datadot">'
												+ body
												+ '</span></a></td><td class="mailbox-attachment"></td><td class="mailbox-date">'+senttime+'</td></tr>');
						
						
						$("#id-check-"+i).iCheck({
						      checkboxClass: 'icheckbox_flat-blue',
						      radioClass: 'iradio_flat-blue'
						    });
				 		}
				     
		     },  error : function() {
		         toastr.error("Server problem");
		        }
		       });
	}
	
	 var getinboxMail=function(){
			$.ajax({
			     url : contextPath + "/mailBox/getInboxMessages",
			     type : 'POST',
			     dataType : "json",
			     success :function(data){
					  $("#id_notification").empty();

					     for ( var i in data) {
					    	 var Count=data[i].count;
					 		}
					     if(Count== undefined){
						     $("#id_notification").append('<a class="nav-link active" href='+contextPath+'/user/mailbox><i class="ion ion-ios-email-outline"></i> Inbox<span class="label label-success pull-right">0</span></a>');
						     }else{
						    	 $("#id_notification").append('<a class="nav-link active" href='+contextPath+'/user/mailbox><i class="ion ion-ios-email-outline"></i> Inbox<span class="label label-success pull-right">'+Count+'</span></a>');	 
						     }
			     },  error : function() {
			         toastr.error("Server problem");
			        }
			       });
		}
	  
	  getinboxMail();
	getTrashMail();
	
	$("#delete-mail-id").click(function() {
		msgid.length=0;
		$("div.checked").each(function () {
			$.each($(this).children("input:checkbox"), function (index, value) {
				msgid.push(Number(value.value));
				 
			});
	     });
		if(msgid.length>0){
			$("#modal-default").modal('show');
		}else{
			toastr.warning("Please Check The messages to be Deleted");
		}
		 
		});
	
	$("#delete-mail-id1").click(function() {
		msgid.length=0;
		$("div.checked").each(function () {
			$.each($(this).children("input:checkbox"), function (index, value) {
				msgid.push(Number(value.value));
				 
			});
	     });
		if(msgid.length>0){
			$("#modal-default").modal('show');
		}else{
			toastr.warning("Please Check The messages to be Deleted");
		}
		 
		});
	
	$("#id-delete-mailinbox").click(function() {
		if (msgid.length>0) {
			$.ajax({
				type : 'POST',
				url : contextPath+ "/mailBox/deletetrash",
				dataType : "json",
				cache: false, 
				data : { msgIdList : msgid},
				traditional: true, 
				
				success : function(data) {
					if (data.status == "Success") {
						$("#modal-default").modal('hide');
						toastr.success(data.message);
						getTrashMail();
					} else {
						toastr.warning(data.message);
					}
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert("Exception in deleting file" + errorThrown);
				}
			});
		} else{
			console.log("Select Some Messages");
		}

	});	
});