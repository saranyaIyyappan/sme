<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<tiles:insertDefinition name="base.definition">
	<tiles:putAttribute name="title" value="Login" />
	<tiles:putAttribute name="body">
	<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>  Compose
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Dashboard</li>
      </ol>
    </section>

	    <!-- Main content -->
    <section class="content">
     <div class="row">
        <div class="col-md-3">
          <a href="${pageContext.request.contextPath}/user/mailbox" class="btn btn-success btn-block btn-shadow margin-bottom">Back to Inbox</a>

          <div class="box box-solid">
            <div class="box-header with-border">
              <h3 class="box-title">Folders</h3>

              <div class="box-tools">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
              </div>
            </div>
            <div class="box-body no-padding mailbox-nav">
              <ul class="nav nav-pills nav-stacked">
                  <li class="nav-item" id="id_notification"></li>
                <li><a href="${pageContext.request.contextPath}/user/sentMail"><i class="ion ion-paper-airplane"></i> Sent</a></li>
                <li><a href="#"><i class="ion ion-email-unread"></i> Drafts</a></li>
                <li><a href="#"><i class="ion ion-star"></i>  Starred <span class="label label-warning pull-right">14</span></a>
                </li>
                <li><a href="${pageContext.request.contextPath}/user/trash"><i class="ion ion-trash-a"></i> Trash</a></li>
              </ul>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /. box -->
          <div class="box box-solid">
            <div class="box-header with-border">
              <h3 class="box-title">Labels</h3>

              <div class="box-tools">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body no-padding mailbox-nav">
              <ul class="nav nav-pills nav-stacked">
                <li><a href="#"><i class="fa fa-circle-o text-red"></i> Important</a></li>
                <li><a href="#"><i class="fa fa-circle-o text-yellow"></i> Promotions</a></li>
                <li><a href="#"><i class="fa fa-circle-o text-light-blue"></i> Social</a></li>
              </ul>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
        <div class="col-md-9">
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Compose New Message</h3>
            </div>
            <!-- /.box-header -->
             <form id="id-compose-form">
             <div class="box-body">
            <input type="hidden" class="form-control" name="REPLY" id="id_reply_status" value="${STATUS}">
            <input type="hidden" class="form-control" name="msgid" id="id-msg-id" value="${hidden_msgid}">
            <input type="hidden" class="form-control" name="seqid" id="id-seq-id" value="${hidden_seqId}">
              <div class="form-group">
                <input class="form-control" placeholder="To:" name="toid" id="to_id" value="${hidden_toid}">
              </div>
              <div class="form-group">
                <input type="text" class="form-control" placeholder="Subject:" name="subject" id="id_subject" value="${hidden_subject}">
              </div>
              <!--  <div class="form-group">
                <input class="form-control" placeholder="Subject:" name="subject" id="id_subjectnew">
              </div> --> 
              <div class="form-group">
                <input type="hidden" class="form-control" placeholder="senttime" name="senttime" id="id_senttime" value="${hidden_senttime}" >
              </div>
             <%--  <div class="form-group">
                <input type="hidden" class="form-control" name="seqid" id="id_seqid" value="${hidden_sequenceId}" >
              </div> --%>
              <div class="form-group">
                  <textarea id="compose-textarea" class="form-control"  rows="4" cols="50" placeholder="type your text..."  name="body" style="display:none;"> ${hidden_body}
                  </textarea>
                  
                  <textarea id="compose-textarea-new" class="form-control"  rows="4" cols="50" placeholder="type your text..."  name="body" > </textarea>
              </div>
       <%--        <div class="form-group">
               <input type="text" class="form-control" placeholder="Subject:" name="subject" id="">
              </div>
               <div class="form-group">
               <input type="text" class="form-control" placeholder="Subject:" name="subject" id="">
              </div>
               <div class="form-group">
               <input type="text" class="form-control" placeholder="Subject:" name="subject" id="">
              </div>
              <div class="form-group">
                  <textarea id="compose-textarea" class="form-control"  rows="4" cols="50" placeholder="type your text..."  name="body" style="display:none;"> ${hidden_body}
                  </textarea>
                  
                  <textarea id="compose-textarea-new" class="form-control"  rows="4" cols="50" placeholder="type your text..."  name="body" > </textarea>
              </div> --%>
              <div id="append-div-reply"></div>
              <div id="append-div-reply1"></div>
               <div class="form-group">
              
             
               <div class="buttoninfo">
                <div class="box-footer" id="id-attachment-size">
             	
              <ul class="mailbox-attachments clearfix" id="id_attachments">
                  
                <li id="id_attachments1">
                  
                </li>
                <li id="id_attachments2">
                  
                </li>
              </ul>
            </div>
            <div class="upload-btn-wrapper">`
            
            
                <button class="btn btn-success btn-sm">Upload</button>
                <input type="file" id="id-Files"   multiple />
                </div>
              <div class="selct-box-body" id ="appendMultipleFile">
            
              <!-- <div class="col-md-10">
              <h6 class="headfile">upload.jpg <span class="badge badgefile">2.6(kb)</span></h6>
               </div>
              <div class="col-md-2">
              <button class="btn btn-danger btnfileupload"><i class="fa fa-times"></i></button>
             
              </div> -->
              </div>
               <p class="help-block">Max. 32MB</p>
              
               </div>
                <!-- <div class="btn btn-info btn-file">
                  <i class="fa fa-paperclip"></i> Attachment
                  <input type="file"  id="fileuploader" name="attachment">
                </div> -->
    

              </div>
            </div>
            <!-- /.box-body -->
            <div class="box-footer">
              <div class="pull-right">
                <button type="button" class="btn btn-default"><i class="fa fa-pencil"></i> Draft</button>
                <button type="button" class="btn btn-success" id="send-compose-id"><i class="fa fa-envelope-o"></i> Send</button>
              </div>
              <a href="${pageContext.request.contextPath}/user/mailbox"> <button type="button"  class="btn btn-danger"><i class="fa fa-times"></i> Discard</button></a>
            </div>
            
            </form>
            
            <!-- /.box-footer -->
          </div>
          <!-- /. box -->
        </div>
        <!-- /.col -->
      </div>
    
    
    
    </section>
	
	</div>
	</tiles:putAttribute>
</tiles:insertDefinition>
<script>
	  $(function () {
		//Add text editor YOUR_FILE_UPLOAD_URL
		$("#compose-textarea").wysihtml5();
	  });
	 
</script>
<style>
.user-block1{
padding-left:0px;
}
.user-block1>p{
float:left;
}
</style>

<script src="${pageContext.request.contextPath}/resources/customjs/compose.js"></script>