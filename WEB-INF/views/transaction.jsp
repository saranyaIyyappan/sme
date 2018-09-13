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
				<h1>Transaction Management</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Transaction</li>
				</ol>
			</section>
			<!-- Main content -->
			<section class="content">


				<div class="box">
					<div class="box-body">
						<div class="col-md-3">
							<div class="form-group">
								<label>Date range:</label>

								<div class="input-group">
									<div class="input-group-addon">
										<i class="fa fa-calendar"></i>
									</div>
									<input type="text" class="form-control" id="id-date-range">
								</div>
							</div>

						</div>

						<div class="col-md-3">
						<label>Transaction Id:</label>
							<div class="form-group ">
								<div class="input-group">
									<input type="text" class="form-control" >
								</div>
							</div>

						</div>
						<div class="col-md-3">
							<div class="form-group ">
								<label>Merchant Id:</label>
						
								<div class="input-group">
									<input type="text" class="form-control">
								</div>
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<div class="input-group">
									<input type="button" class="btn btn-block btn-primary btn-lg" value="Search">
								</div>
							</div>
						</div>
						
					</div>
				</div>
				
				<div class="row">

					<div class="col-md-4">
						<ul id="id-transaction-list"
							class="products-list product-list-in-box list-group  selList box">


						</ul>
					</div>



					<div class="col-md-8">

						<div class="box">


							<div class="box-header with-border ui-sortable-handle">
								<h3 id="id-status" class="box-title"></h3>

							</div>

							<div class="box-body">
								<ul id="id-transaction-oprn" class="timeline">


								</ul>
							</div>
						</div>

					</div>

				</div>



			</section>

		</div>
		<script
			src="${pageContext.request.contextPath}/resources/customjs/transactions.js"></script>
	</tiles:putAttribute>
</tiles:insertDefinition>