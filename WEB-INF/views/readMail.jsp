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
      <h1>
        Read Mail
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
          <a href="${pageContext.request.contextPath}/user/compose" class="btn btn-success btn-block btn-shadow margin-bottom">Compose</a>

          <div class="box box-solid">
            <div class="box-header with-border">
              <h3 class="b-ox-title">Folders</h3>

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
              <h3 class="box-title">Read Mail</h3>

              <div class="box-tools pull-right">
                <a href="#" class="btn btn-box-tool" data-toggle="tooltip" title="Previous"><i class="fa fa-chevron-left"></i></a>
                <a href="#" class="btn btn-box-tool" data-toggle="tooltip" title="Next"><i class="fa fa-chevron-right"></i></a>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body no-padding">
             <!--  <div class="mailbox-read-info">
                <h3>Your message title goes here</h3>
              </div> -->
              <div class="mailbox-read-info clearfix" id="id_readmail">
				<!-- <div class="left-float margin-r-5"><a href="#"><img src="../../images/1.jpg" alt="user" width="40" class="img-circle"></a></div> -->
               
                     
                  
              </div>
              <!-- /.mailbox-read-info -->
              <div class="mailbox-controls with-border clearfix">                
                <div class="left-float">
                  <button type="button" class="btn btn-default btn-outline btn-sm" data-toggle="tooltip" title="Print">
                  <i class="fa fa-print"></i></button>
                </div>
                <div class="right-float">
                <div class="btn-group">
                  <button type="button" class="btn btn-default btn-outline btn-sm" data-toggle="tooltip" data-container="body" title="Delete">
                    <i class="fa fa-trash-o"></i></button>
                  <button type="button" class="btn btn-default btn-outline btn-sm" data-toggle="tooltip" data-container="body" title="Reply">
                    <i class="fa fa-reply"></i></button>
                  <button type="button" class="btn btn-default btn-outline btn-sm" data-toggle="tooltip" data-container="body" title="Forward">
                    <i class="fa fa-share"></i></button>
                </div>
                </div>
                <!-- /.btn-group -->
                
              </div>
              <!-- /.mailbox-controls -->
              <div id="mailCommonDiv">
             <!--  <div class="mailbox-read-message" id="id_msg_body">
             
              </div>
               -->
              <!-- /.mailbox-read-message -->
           
            <!-- /.box-body -->
            
            
            <form id="id-download-form-attchments"
			action="${pageContext.request.contextPath}/readMail/downloadFile"
			method="post">
			<input type="hidden" name="fileId" id="id-download-form-fileId">
			<input type="hidden" name="fileName" id="id-download-form-fileName">
		</form>
            
            <!-- <div class="box-footer" id="id-attachment-size">
             	
              <ul class="mailbox-attachments clearfix" id="id_attachments">
                 
              </ul>
            </div> --></div>
            <!-- /.box-footer -->
            <div class="box-footer">
              <div class="pull-right">
              <form method="POST" action="${pageContext.request.contextPath}/readMail/gettoid">
              
              <input type="hidden" id="id-hidden-toid" name="hidden_toid"> 
 				<input type="hidden" id="id-hidden-fromid" name="hidden_fromid"> 
 				<input type="hidden" id="id-hidden-msgid" name="hidden_msgid">
 				<input type="hidden" id="id-hidden-status" name="hidden_reply">
 				<input type="hidden" id="id-hidden-subject" name="hidden_subject">
 				<input type="hidden" id="id-hidden-body" name="hidden_body">
 				<input type="hidden" id="id-hidden-senttime" name="hidden_senttime">    
 				 <input type="hidden" id="id-hidden-seqId" name="hidden_seqId">  
                <button type="submit" class="btn btn-success" id="id-reply-mail"><i class="fa fa-reply"></i> Reply</button>
                <button type="submit" formaction="${pageContext.request.contextPath}/readMail/forwardMessage" class="btn btn-info" id="id-forward-mail"><i class="fa fa-share"></i> Forward</button>
                </form>
              </div>
              <button type="button" class="btn btn-danger"><i class="fa fa-trash-o"></i> Delete</button>
              <button type="button" class="btn btn-warning"><i class="fa fa-print"></i> Print</button>
            </div>
            <!-- /.box-footer -->
          </div>
          <!-- /. box -->
        </div>
        <!-- /.col -->
      </div>
      <form method="post">
    <input type="hidden" name="msgid" id="id-msgid"
					value="${messageId}"></form>
	
					
    </section>
	</div>
	
	
	</tiles:putAttribute>
</tiles:insertDefinition>
<script src="${pageContext.request.contextPath}/resources/customjs/readMail.js"></script> 



