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
        Trash
      </h1>
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="breadcrumb-item active">Mailbox</li>
      </ol>
    </section>
	    <!-- Main content -->
    <section class="content">
    
        <div class="row">
        <div class="col-lg-3">
          <a href="${pageContext.request.contextPath}/user/compose" class="btn btn-success btn-block btn-shadow margin-bottom">Compose</a>
          <div class="box box-solid">
            <div class="box-header with-border">
              <h3 class="box-title">Folders</h3>

              <div class="box-tools">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
              </div>
            </div>
            <div class="box-body no-padding mailbox-nav">
              <ul class="nav nav-pills flex-column">
                     <li class="nav-item" id="id_notification"></li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/user/sentMail"><i class="ion ion-paper-airplane"></i> Sent</a></li>
                <li class="nav-item"><a class="nav-link" href="javascript:void(0)"><i class="ion ion-email-unread"></i> Drafts</a></li>
                <li class="nav-item"><a class="nav-link" href="javascript:void(0)"><i class="ion ion-star"></i>  Starred <span class="label label-warning pull-right">14</span></a>
                </li>
                <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/user/trash"><i class="ion ion-trash-a"></i> Trash</a></li>
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
              <ul class="nav nav-pills flex-column">
                <li class="nav-item"><a class="nav-link" href="#"><i class="fa fa-circle-o text-red"></i> Important</a></li>
                <li class="nav-item"><a class="nav-link" href="#"><i class="fa fa-circle-o text-yellow"></i> Promotions</a></li>
                <li class="nav-item"><a class="nav-link" href="#"><i class="fa fa-circle-o text-light-blue"></i> Social</a></li>
              </ul>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
        <div class="col-lg-9">
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Trash</h3>

              <div class="box-tools pull-right">
                <div class="has-feedback">
                  <input type="text" class="form-control input-sm" placeholder="Search Mail">
                  <span class="glyphicon glyphicon-search form-control-feedback"></span>
                </div>
              </div>
              <!-- /.box-tools -->
            </div>
            <!-- /.box-header -->
            <div class="box-body no-padding">
              <div class="mailbox-controls">
                <!-- Check all button -->
                <button type="button" class="btn btn-default btn-outline btn-sm checkbox-toggle"><i class="ion ion-android-checkbox-outline-blank"></i>
                </button>
                <div class="btn-group">
                  <button type="button" class="btn btn-default btn-outline btn-sm" id="delete-mail-id"><i class="ion ion-trash-a"></i></button>
                  <button type="button" class="btn btn-default btn-outline btn-sm"><i class="ion ion-reply"></i></button>
                  <button type="button" class="btn btn-default btn-outline btn-sm"><i class="ion ion-share"></i></button>
                </div>
                <!-- /.btn-group -->
                <div class="btn-group">
				  <div class="btn-group">
					<button type="button" class="btn btn-default btn-outline btn-sm dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
				      <i class="ion ion-flag margin-r-5"></i>
					  <span class="caret"></span>
					</button>
					<div class="dropdown-menu">
					    <a class="dropdown-item" href="#">Action</a><br>
						<a class="dropdown-item" href="#">Another action</a><br>
						<a class="dropdown-item" href="#">Something else here</a>
					</div>
				  </div>
				  <div class="btn-group">
					<button type="button" class="btn btn-default btn-outline btn-sm dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
				  	  <i class="ion ion-folder margin-r-5"></i>
					  <span class="caret"></span>
					</button>
					<div class="dropdown-menu">
					    <a class="dropdown-item" href="#">Action</a>
						<a class="dropdown-item" href="#">Another action</a>
						<a class="dropdown-item" href="#">Something else here</a>
					</div>
				  </div>
				</div>
                <!-- /.btn-group -->
                <button type="button" class="btn btn-default btn-outline btn-sm"><i class="fa fa-refresh"></i></button>
                <div class="pull-right">
                  1-50/200
                  <div class="btn-group">
                    <button type="button" class="btn btn-default btn-outline btn-sm"><i class="fa fa-chevron-left"></i></button>
                    <button type="button" class="btn btn-default btn-outline btn-sm"><i class="fa fa-chevron-right"></i></button>
                  </div>
                  <!-- /.btn-group -->
                </div>
                <!-- /.pull-right -->
              </div>
              <div class="table-responsive mailbox-messages">
                <table class="table table-hover table-striped">
                  <tbody id="id-trash-messages">
                   
                    </tbody>
                  </table>
                    
                   
                    
                    
              </div>
              <!-- /.mail-box-messages -->
            </div>
            <!-- /.box-body -->
            <div class="box-footer no-padding">
              <div class="mailbox-controls">
                <!-- Check all button -->
                <button type="button" class="btn btn-default btn-outline btn-sm checkbox-toggle"><i class="ion ion-android-checkbox-outline-blank"></i>
                </button>
                <div class="btn-group">
                  <button type="button" class="btn btn-default btn-outline btn-sm" id="delete-mail-id1"><i class="ion ion-trash-a"></i></button>
                  <button type="button" class="btn btn-default btn-outline btn-sm"><i class="ion ion-reply"></i></button>
                  <button type="button" class="btn btn-default btn-outline btn-sm"><i class="ion ion-share"></i></button>
                </div>
                <!-- /.btn-group -->
                <div class="btn-group">
				  <div class="btn-group">
					<button type="button" class="btn btn-default btn-outline btn-sm dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
				      <i class="ion ion-flag margin-r-5"></i>
					  <span class="caret"></span>
					</button>
					<div class="dropdown-menu">
					    <a class="dropdown-item" href="#">Action</a>
					     <div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Another action</a>
						 <div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Something else here</a>
					</div>
				  </div>
				  <div class="btn-group">
					<button type="button" class="btn btn-default btn-outline btn-sm dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
				  	  <i class="ion ion-folder margin-r-5"></i>
					  <span class="caret"></span>
					</button>
					<div class="dropdown-menu">
					    <a class="dropdown-item" href="#">Action</a>
					     <div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Another action</a>
						 <div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Something else here</a>
					</div>
				  </div>
				</div>
                <!-- /.btn-group -->
                <button type="button" class="btn btn-default btn-outline btn-sm"><i class="fa fa-refresh"></i></button>
                <div class="pull-right">
                  1-50/200
                  <div class="btn-group">
                    <button type="button" class="btn btn-default btn-outline btn-sm"><i class="fa fa-chevron-left"></i></button>
                    <button type="button" class="btn btn-default btn-outline btn-sm"><i class="fa fa-chevron-right"></i></button>
                  </div>
                  <!-- /.btn-group -->
                </div>
                
              </div>
            </div>
          </div>
          <!-- /. box -->
        </div>
        <!-- /.col -->
      </div>
    
         <div class="modal fade" id="modal-default">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Default Modal</h4>
              </div>
             	<div class="modal-body">
					<h4>
						<!-- <span name="38" ></span> -->
						<c:out value="Are you sure, you want to delete ?" />

						
					</h4>
				</div>
				<div class="modal-footer">
					<div style="float: right; margin-right: 3px;">
						<form id="id-supportdepartment-form">
							<input type="hidden" class="form-control" name="msgid"
									id="id-msgid-id_delete" readonly>
									
							<button id="id-delete-mailinbox" type="button"
								class="btn btn-primary btn_user">
								<input type="hidden" name="cardGrp"
								id="hidden-giftCard-theme-id-delete" >
								<!-- 	<span name="39" ></span> -->
								<i class="fa fa-check"></i>
								<c:out value="Yes" />
							</button>
						</form>
					</div>
					<div style="margin-right: 77px;">
						<button type="button" class="btn btn-primary btn_user" data-dismiss="modal"
							>
							<!-- <span name="40" ></span> -->
							<i class="fa fa-times"></i>
							<c:out value="No" />
						</button>
					</div>
				</div>
            </div>
            <!-- /.modal-content -->
          </div>
          <!-- /.modal-dialog -->
        </div>
    
    </section>
	
	</div>
	</tiles:putAttribute>
</tiles:insertDefinition>

<script src="${pageContext.request.contextPath}/resources/customjs/trash.js"></script> 