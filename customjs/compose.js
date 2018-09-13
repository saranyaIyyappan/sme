var fileUpload=[];
var fileDelete=[];
$(document).ready(function(){
	var contextPath = $('#app-context-path').val();
	 var reqData = new FormData();
	 var attachment=[];
	  var  filename=null;
	  var   publicKey=null;
	 var fileName=[];
	
	 var fileCount=0;
	 $("#MAILBOX").show();
	  $("#MAILBOXS").hide();
	var status=  $("#id_reply_status").val();
	  var getinboxMail=function(){
			$.ajax({
			     url : contextPath + "/mailBox/getInboxMessages",
			     type : 'POST',
			     dataType : "json",
			     success :function(data){
					  $("#id_notification").empty();
					 
					     for ( var i in data) {
					    	 var Count=data[i].count;
					    	 var Body=data[i].body;
					    	 var status=data[i].Status;
					    	 
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
	  replymail();
/*	  $("#MAILBOX").click(function() {

			 $("#glypi_id").removeClass("fa fa-user");
			 $("#glypi_mail_id").addClass("fa fa-envelope");
			
		});*/
	  $('input:file').change(function(){
		  
			      filename = this.files[0].name;
			      publicKey = ($('input:file').prop("files")[0]);
			     reqData.append("docFile"+fileCount,publicKey);
			     fileCount=fileCount+1;
			     
			     $('#appendMultipleFile').append('<div id ="id-removes'+fileCount+'"><div class="col-md-10"><h6 class="headfile">'+filename+'<span class="badge badgefile">2.6(kb)</span></h6></div>'
		                   +'<div class="col-md-2" ><button type="button" class="btn btn-danger btnfileupload" onclick="removeLine(\''+fileCount+'\',\''+filename+'\')" ><i class="fa fa-times" id ="id-remove'+filename+'"></i></button></div></div>');
			     
			    /* $(document).on('click', '.btnfileupload', function(e) {
					  //alert("haiii"+$('#id-remove'+filename).val());
					  $(filename).remove();
					
					
					});*/
		  });
	  
	  
	

	if(status=="REPLY"){
		
	$("#send-compose-id").click(function() {
		 var formData =$("#id-compose-form").serializeArray();
	 	 if(null!=reqData && typeof reqData!='undefined'){
	 		 
	 	$.each(formData,function(key,input){      
	       reqData.append(input.name,input.value);
	      console.log(reqData)
	    });
	 }
	 	reqData.append("fileCount",fileCount);
	 	/*reqData.append("attachment",attachment);
	 	reqData.append("fileName",fileName);*/
	 	reqData.append("fileUpload",fileUpload);
	var toid=$("#to_id").val();
	var subject=$("#id_subject").val();
	if (toid == "") {
		toastr.warning("Please specify recipient");
	} else{
		$.ajax({
			type : 'POST',   
			url : contextPath+"/compose/replysentmail",
			dataType : "json",
			   contentType : false,
	           processData: false,
	           data : reqData,
	           enctype: 'multipart/form-data',
			success : function(data) {
				alert("rfafii"+data);
				if (data.status == "Success") {
					toastr.success(data.message);
					$("#id-compose-form")[0].reset();
					$("#appendMultipleFile").empty();
					$('#compose-textarea, textarea').val('');
					setTimeout(function() {
						 window.location =contextPath+'/user/mailbox';
			      		
	            }, 1500);
					
					
				} else {
					toastr.warning(data.message);
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert("Exception in rejecting file" + errorThrown);
			}
		});
	}

	
	});
	}	
	else if(status=="FORWARD"){
		
		$("#send-compose-id").click(function() {

			 var formData =$("#id-compose-form").serializeArray();
		 	 if(null!=reqData && typeof reqData!='undefined'){
		 		 
		 	$.each(formData,function(key,input){      
		       reqData.append(input.name,input.value);
		      console.log(reqData)
		      
		    });
		 }
		 	reqData.append("fileCount",fileCount);
		 	if(fileName!=null){
		 	reqData.append("attachment",attachment);
		 	reqData.append("fileName",fileName);
			reqData.append("fileDelete",fileDelete);}
		 	reqData.append("fileUpload",fileUpload);
		var toid=$("#to_id").val();
		var subject=$("#id_subject").val();
		if (toid == "") {
			toastr.warning("Please specify recipient");
		} else{
			$.ajax({
				type : 'POST',   
				url : contextPath+"/compose/composemail",
				dataType : "json",
				   contentType : false,
		           processData: false,
		           data : reqData,
		           enctype: 'multipart/form-data',
				success : function(data) {
					alert("rfafii"+data);
					if (data.status == "Success") {
						toastr.success(data.message);
						$("#id-compose-form")[0].reset();
						$("#appendMultipleFile").empty();
						$('#compose-textarea, textarea').val('');
						setTimeout(function() {
							 window.location =contextPath+'/user/mailbox';
				      		
		            }, 1500);
						
						
					} else {
						toastr.warning(data.message);
					}
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert("Exception in rejecting file" + errorThrown);
				}
			});
		}

		
		});
		}else{
		$("#send-compose-id").click(function() {
			 var formData =$("#id-compose-form").serializeArray();
		 	 if(null!=reqData && typeof reqData!='undefined'){
		 		 
		 	$.each(formData,function(key,input){      
		       reqData.append(input.name,input.value);
		      console.log(reqData)
		    });
		 }
		reqData.append("fileCount",fileCount);	
		reqData.append("fileUpload",fileUpload);	
		var toid=$("#to_id").val();
		alert(toid);
		var subject=$("#id_subject").val();
		var compose=$("#id_compose_status").val();
		if (toid == "") {
			toastr.warning("Please specify recipient");
		} else{
			$.ajax({
				type : 'POST',   
				url : contextPath+"/compose/composemail",
				dataType : "json",
				   contentType : false,
		           processData: false,
		           data : reqData,
		           enctype: 'multipart/form-data',
				success : function(data) {
					alert("rfafii"+data);
					if (data.status == "Success") {
						toastr.success(data.message);
						$("#id-compose-form")[0].reset();
						$("#appendMultipleFile").empty();
						$('#compose-textarea, textarea').val('');
						setTimeout(function() {
							 window.location =contextPath+'/user/mailbox';
				      		
		            }, 1500);
						
						
					} else {
						toastr.warning(data.message);
					}
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert("Exception in rejecting file" + errorThrown);
				}
			});
		}

		});
	}
	function replymail(){
		var contextPath = $('#app-context-path').val();
		var status=  $("#id_reply_status").val();
		if(status=="REPLY"){		
						 // $("#append-div-reply").empty();
			var sequenceId=$("#id-seq-id").val();
		
			$.ajax({
				type : 'POST',   
				url : contextPath+"/compose/getListOfMessage",
				dataType : "json",			 
		           data : {
		        	   sequenceId:sequenceId
		        	   },	        
				success : function(data) {				
						 for ( var i in data.aaData){
							 var toid=data.aaData[i].toid;
							 var subject=data.aaData[i].subject;
							 var sentime=data.aaData[i].senttime;
							 var body=data.aaData[i].body;
							 $( "#compose-textarea-new").append("----------------------------------------------------------------------------------------------\n");
								$( "#compose-textarea-new").append("From:"+toid+"\n"+"Subject :"+subject+"\n"+"Sent Time :"+sentime+"\n"+body+"\n");
								$( "#compose-textarea-new").append("----------------------------------------------------------------------------------------------\n");
								
					
					
					} 
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert("Exception in rejecting file" + errorThrown);
				}
			});
		}
		else if(status=="FORWARD"){		
				 // $("#append-div-reply").empty();
		 $('#appendMultipleFile').empty();
	var sequenceId=$("#id-seq-id").val();
	$.ajax({
		
		type : 'POST',   
		url : contextPath+"/compose/getListOfMessage",
		dataType : "json",			 
	      data : {
	   	   sequenceId:sequenceId
	   	   },	        
		success : function(data) {		
			
				 for ( var i in data.aaData){
					 var toid=data.aaData[i].toid;
					 var subject=data.aaData[i].subject;
					 var sentime=data.aaData[i].senttime;
					 var body=data.aaData[i].body;
					 var messageId=data.aaData[i].messageId;
					 alert(data.aaData[i].fileID);
					 $( "#compose-textarea-new").append("----------------------------------------------------------------------------------------------\n");
						$( "#compose-textarea-new").append("From :"+toid+"\n"+"Subject :"+subject+"\n"+"Sent Time :"+sentime+"\n"+body+"\n");
						$( "#compose-textarea-new").append("----------------------------------------------------------------------------------------------\n");
						
						
					for(var x in data.aData){     
						  var msgId=data.aData[x].msgId;
					if(data.aData[x].fileID!="null" && messageId==msgId)	{ 
						
						 //  fileName=data.aData[x].filename;
						 //  attachment=data.aData[x].fileID;
						   fileName.push(data.aData[x].filename);
						   attachment.push(data.aData[x].fileID);
						 
						   
						// $('#appendMultipleFile').append('<div id="remove-btn"><div class="col-md-10"><h6 class="headfile">'+data.aData[x].filename+'<span class="badge badgefile">2.6(kb)</span></h6></div>'
				        //           +'<div class="col-md-2" ><button type="button" class="btn btn-danger btnfileupload" onclick="removeLines(\''+data.aData[x].fileID+'\')"><i class="fa fa-times" id ="id-remove'+filename+'"></i></button></div></div>');
						  
					     $('#appendMultipleFile').append('<div id ="id-removes'+data.aData[x].fileID+'"><div class="col-md-10"><h6 class="headfile">'+data.aData[x].filename+'<span class="badge badgefile">2.6(kb)</span></h6></div>'
				                   +'<div class="col-md-2" ><button type="button" class="btn btn-danger btnfileupload" onclick="removeLines(\''+data.aData[x].fileID+'\')" ><i class="fa fa-times" id ="id-remove'+filename+'"></i></button></div></div>');
						
					}
					}
					/* $(document).on('click', '.btnfileupload', function(e) {
						  alert(data.aData[x].fileID);
						$("#remove-btn").empty();
						 fileDelete.push(data.aData[x].fileID);
						 
						});*/
					 
					 /* $('input:file').change(function(){
						  
					      filename = this.files[0].name;
					      publicKey = ($('input:file').prop("files")[0]);
					     reqData.append("docFile"+fileCount,publicKey);
					     fileCount=fileCount+1;
					     
					     $('#appendMultipleFile').append('<div id ="id-removes'+fileCount+'"><div class="col-md-10"><h6 class="headfile">'+filename+'<span class="badge badgefile">2.6(kb)</span></h6></div>'
				                   +'<div class="col-md-2" ><button type="button" class="btn btn-danger btnfileupload" onclick="removeLine(\''+fileCount+'\',\''+filename+'\')" ><i class="fa fa-times" id ="id-remove'+filename+'"></i></button></div></div>');
					     
					     $(document).on('click', '.btnfileupload', function(e) {
							  //alert("haiii"+$('#id-remove'+filename).val());
							  $(filename).remove();
							
							
							});
				  });	*/				
					
			} 
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert("Exception in rejecting file" + errorThrown);
		}
	});
			
			
						   
						    	// var messageId=data[i].messageId;
						    	/* var toid=$("#to_id").val();
						    	 alert(toid);
						    	 var subject=$("#id_subject").val();
						    	 var sentime=$("#id_senttime").val();
						    	 var body=$("#compose-textarea").val();*/
						    	//$( "#compose-textarea-new").val("From:"+toid+"\n"+"Sent Time :"+sentime+"\n"+"Body :"+body);
						 		
						     //$("#append-div-reply").append('<div class="row"><div class="col-md-12"><p class="description"><span><b>From:</b></span>'+toid+'</p><p class="description"><span><b>Senttime:</b></span>'+sentime+'</p><p class="description"><span><b>Body:</b></span>'+body+'</p></div></div>');
		}
	}
	
});

function removeLine(obj,filename){ 
	alert(filename);
	$('#id-removes'+obj).remove();
	 fileUpload.push(filename);
	
  }
function removeLines(obj){ 
	alert(obj);
	$('#id-removes'+obj).remove();
	fileDelete.push(obj);
	
  }
 
