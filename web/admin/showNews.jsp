<%-- 
    Document   : showNews
    Created on : 8 Mar, 2020, 12:08:28 AM
    Author     : ravi
--%>
<%@page import="com.daos.ReporterDao"%>
<%@page import="com.beans.News"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.daos.NewsDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>All News</title>

  <jsp:include page="base.jsp"></jsp:include>
</head>

<body id="page-top">
    <%
        if (session.getAttribute("admin")==null){
            response.sendRedirect("../login.jsp");
            return;
        }
        %>
  <!-- Page Wrapper -->
  <div id="wrapper">

    <!-- Sidebar -->
  <jsp:include page="sidebar.jsp"></jsp:include>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
      <jsp:include page="topbar.jsp"></jsp:include>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">List of All News </h1>
            
          <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Export News</a>
          </div>

          <div class="row table-responsive">
              
              <table class="table">
                  <tr>
                      <td>Title</td><td>Uploaded By </td><td>Current Status</td><td>Action </td>
                  </tr>
                      <%
                          NewsDao nd = new NewsDao();
                          ArrayList<News> newsList = nd.getAllNews();
                          ReporterDao rd = new ReporterDao(); 
                          for(News news : newsList){%>
                  <tr>
                      <td><%=news.getTitle()%></td>
                      <td><%=rd.getById(news.getReporter_id()).getName()%></td>
                      <td><%=news.getStatus()%></td>
                      <td><a href="changeNewsStatus.jsp?newsid=<%=news.getId()%>" class="btn btn-primary"> View and Change Status</a></td>
                  </tr>
                          
                          <%}%>
                    
              </table>
          </div>

          
        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <jsp:include page="footer.jsp"></jsp:include>
      <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>
  <!-- Bootstrap core JavaScript-->
  
</body>

</html>

