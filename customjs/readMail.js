

$(document).ready(function(){
	
	var contextPath = $('#app-context-path').val();
	var msgid=$("#id-msgid").val();
	var id=$("#id-createdby").val();
	var createdby;
	mail(msgid);
//	replymail(id);
	//attachments(msgid);
	
	 $("#MAILBOX").show();
	  $("#MAILBOXS").hide();
});

function mail(msgid){
	var contextPath = $('#app-context-path').val();
	$.ajax({
  	     url : contextPath +"/readMail/getreadmail",
  	     type : 'POST',
  	     dataType : "json",
  	     data : {msgid : msgid},
  	     success : function(data) {
  	    	 $("#id_readmail").empty();
  	    	/* $("#id_msg_body").empty();
  	    	 $("#id_attachments").empty();*/
  	      for ( var i in data.aaData) {
  	     var body=data.aaData[i].Body;
  	     var createdby=data.aaData[i].Createdby;
  	     var toid=data.aaData[i].Toid;
  	     var senttime=data.aaData[i].Senttime;
  	     var status=data.aaData[i].Status;
  	     var messageId=data.aaData[i].msgid;
  	     var sequenceId=data.aaData[i].seqid;
  	    
  	   //attachments(messageId,sequenceId);
  	     var Count=data.aaData[i].count;
  	   var subject=data.aaData[i].Subject;  	
  	 $("#id_readmail").empty();
  	   $("#id_readmail").append('<h4 class="no-margin">'+data.aaData[0].Toid+'<br><small>From:'+data.aaData[0].Createdby+'</small>');  
  	 $("#mailCommonDiv").append('<div class="mailbox-read-message"><p>'+body+'</p><span class="mailbox-read-time pull-right">'+senttime+'</span></h4></div>');
  	  for(var x in data.aData){
  		  var StrImg=data.aData[x].filename;
 	      var  fileid=data.aData[x].fileID; 
 	      var msgId=data.aData[x].msgId;
 	     if(StrImg!="null" && messageId==msgId){
 	     	 $("#mailCommonDiv").append('<div class="box-footer"><ul class="mailbox-attachments clearfix"><li><span class="mailbox-attachment-icon"><i class="fa fa-file-pdf-o"></i></span><div class="mailbox-attachment-info"><a class="mailbox-attachment-name"><i class="fa fa-paperclip"></i>'+StrImg+'</a><span class="mailbox-attachment-size">5,215 KB<a href="javascript:attachment(\''+fileid+'\',\''+StrImg+'\')" class="btn btn-default btn-xs pull-right"><i class="fa fa-cloud-download"></i></a></span></div></li></ul> </div>');
 	     	 }
  	  }
  	
   	$("#id-reply-mail").click(function(){
  		replymail(createdby,toid,messageId,body,subject,senttime,sequenceId);
  		});  
  	
  	$("#id-forward-mail").click(function(){
  	forwardMessage(sequenceId);  });  
  	      }if(Count== undefined){
			     $("#id_notification").append('<a class="nav-link active" href='+contextPath+'/user/mailbox><i class="ion ion-ios-email-outline"></i> Inbox<span class="label label-success pull-right">0</span></a>');
		     }else{
		    	 $("#id_notification").append('<a class="nav-link active" href='+contextPath+'/user/mailbox><i class="ion ion-ios-email-outline"></i> Inbox<span class="label label-success pull-right">'+Count+'</span></a>');	 
		     } },
  	     error : function() {
  	         toastr.error("Server problem");
  	        }
  	       });
}
/*function attachments(msgid,sequenceId){
	var contextPath = $('#app-context-path').val();
	$.ajax({
  	     url : contextPath +"/readMail/fileId",
  	     type : 'POST',
  	     dataType : "json",
  	     data : {messageId : msgid,
  	    	sequenceId:sequenceId},
  	     success : function(data) {
  	    	
  	    	// $("#id_attachments_size").empty();
  	    	//$("#id_attachments1").empty();
  	    	//$("#id_attachments2").empty();
  	      for ( var i in data) {
  	    StrImg=data[i].filename;
  	    fileid=data[i].fileID;
  	    filecheck=data[i].FileCheck;
  	//$("#mailCommonDiv").append('<div class="box-footer"><ul class="mailbox-attachments clearfix"><li><span class="mailbox-attachment-icon"><i class="fa fa-file-pdf-o"></i></span><div class="mailbox-attachment-info"><a class="mailbox-attachment-name"><i class="fa fa-paperclip"></i>'+StrImg+'</a><span class="mailbox-attachment-size">5,215 KB<a href="javascript:attachment(\''+fileid+'\',\''+StrImg+'\')" class="btn btn-default btn-xs pull-right"><i class="fa fa-cloud-download"></i></a></span></div></li></ul> </div>');
  	 
  	 // $("#id_attachments_size").append('<h4><i class="fa fa-paperclip m-r-10 m-b-10"></i> Attachments <span>(3)</span></h4>');
  	 	$("#id_attachments1").append('<span class="mailbox-attachment-icon"><i class="fa fa-file-word-o"></i></span><div class="mailbox-attachment-info"><a href="#" class="mailbox-attachment-name"><i class="fa fa-paperclip"></i>'+StrImg+'</a><span class="mailbox-attachment-size"> 2,145 KB<a href="#" class="btn btn-default btn-xs pull-right"><i class="fa fa-cloud-download"></i></a> </span></div>');
  	$("#id_attachments2").append('<span class="mailbox-attachment-icon has-img"><img src="../../images/photo1.png" alt="Attachment"></span><div class="mailbox-attachment-info"><a href="#" class="mailbox-attachment-name"><i class="fa fa-camera"></i> Image.png</a><span class="mailbox-attachment-size"> 2.67 MB <a href="#" class="btn btn-default btn-xs pull-right"><i class="fa fa-cloud-download"></i></a></span></div>');
  	      }
  	   // $("#id-attachment-size").append('<h4><i class="fa fa-paperclip m-r-10 m-b-10"></i> Attachments <span>('+fileid+')</span></h4>');
  	     },
  	     error : function() {
  	         toastr.error("Server problem");
  	        }
  	       });
}*/

function replymail(createdby,toid,messageId,body,subject,senttime,sequenceId){
	alert("replyyyyyyyy");
	$("#id-hidden-toid").val(createdby);
	$("#id-hidden-fromid").val(toid);
	$("#id-hidden-msgid").val(messageId);
	$("#id-hidden-subject").val(subject);
	$("#id-hidden-body").val(body);
	$("#id-hidden-senttime").val(senttime);
	$("#id-hidden-seqId").val(sequenceId);
	alert($("#id-hidden-seqId").val())
	 $("#id-reply-mail").submit();
	
}
function forwardMessage(sequenceId){
	alert(sequenceId+"function frw");
	$("#id-hidden-seqId").val(sequenceId);
/*	var contextPath = $('#app-context-path').val();
	$.ajax({
 	     url : contextPath +"/readMail/forwardMessage",
 	     type : 'POST',
 	     dataType : "json",
 	     data : {sequenceId : sequenceId},
 	    success : function(data) {
 	    	
 	    }
 	    
	});*/
}

function attachment(fileid,StrImg){
	alert(fileid+"fileid"+StrImg);
	 $("#id-download-form-fileId").val(fileid);
	 $("#id-download-form-fileName").val(StrImg);
	 $("#id-download-form-attchments").submit();
}