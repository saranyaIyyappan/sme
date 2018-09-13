
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
  
     <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
     
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">

  <li class="active">
          <a href="index.html">
            <i class="fa fa-dashboard"></i> <span>Dashboard</span>
          </a>
        </li>

        <c:forEach items="${screenPermission}" var="menuMap">
					<c:if test="${menuMap.key != 'NoSubMenu'}">
					
					<li class="treeview" id="${menuMap.key}">
					<a href="#"> 
								 <i class="fa fa-user"></i><span>${menuMap.key}</span>
										<i class="fa fa-angle-left pull-right"></i>					
						</a>
						<ul class="treeview-menu">
								<c:forEach items="${menuMap.value}" var="subMenu">
									<li><a
										href="${pageContext.request.contextPath}${subMenu.url}"><i
											class="fa ${subMenu.cls}"></i> <span>${subMenu.screenName}</span></a>
									</li>
								</c:forEach>
							</ul></li>
		
					</c:if>	
					
			<c:if test="${menuMap.key == 'NoSubMenu'}">
						<c:forEach items="${menuMap.value}" var="subMenu">
							<li id="${subMenu.screenId}"><a
								href="${pageContext.request.contextPath}${subMenu.url}"><i
									class="fa ${subMenu.cls}"></i> <span>${subMenu.screenName}</span></a></li>
						</c:forEach>
					</c:if>	
        </c:forEach>
        </ul>
    </section>
    <!-- /.sidebar -->

    <div class="sidebar-footer">
		<!-- item-->
		<a href="" class="link" data-toggle="tooltip" title="" data-original-title="Settings"><i class="fa fa-cog fa-spin"></i></a>
		<!-- item-->
		<a href="" class="link" data-toggle="tooltip" title="" data-original-title="Email"><i class="fa fa-envelope"></i></a>
		<!-- item-->
		<a href="${pageContext.request.contextPath}/user/logOut" class="link" data-toggle="tooltip" title="" data-original-title="Logout"><i class="fa fa-power-off"></i></a>
	</div>
  </aside>
  <script type="text/javascript">
  
  $("#MAILBOX").hide();
  $("#MAILBOXS").show();
  
  </script>