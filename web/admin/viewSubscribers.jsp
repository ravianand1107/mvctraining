<%@page import="com.daos.SubscriberDao, java.util.ArrayList, com.beans.Subscribers"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>List of Subscribers</title>

  <!-- Custom fonts for this template-->
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

          <center><h2>List of Subscribers</h2> </center>
        <table width='700' border='1' cellspacing='0' class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
            </tr>
        <%
            SubscriberDao sd = new SubscriberDao();
            ArrayList<Subscribers> rows = new ArrayList();

            int start = request.getParameter("start") != null ? Integer.parseInt(request.getParameter("start")) : 0;
            int end = 3;
            int total = sd.getSubscribersCount();
            rows = sd.getSubscribersByLimit(start, end);

            for (Subscribers subscribers : rows) {%>
        <tr>
            <td><%=subscribers.getId()%> </td>
            <td><%=subscribers.getName()%> </td>
            <td><%=subscribers.getEmail()%> </td>
        </tr>

        <%}%>
    </table>
    <br/>
    <span style="float:left"><a href="viewSubscribers.jsp?start=<%=start - end%>" class="btn btn-primary <%if (start == 0) {
            out.println("disabled");
        }%>">Previous</a></span>
    <center>
        <%
            int pages = total / end + (total % end == 0 ? 0 : 1);
            for (int i = 0; i < pages; i++) {%>
        <span style="text-decoration: none; align-content: center;  <% if (Math.floor(start / end) == i) {
               out.println("background-color: orange");
        }%>" class="btn btn-dark"><a href="viewSubscribers.jsp?start=<%=end * i%>"><%=i + 1%></a></span> 
        <%}
        %>
        <span style="float:right"><a href="viewSubscribers.jsp?start=<%=start + end%>" class="btn btn-primary <% if (start + end >= total) {
             out.println(" disabled");
         }%>">Next</a></span>

    </center> 
    
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
</body>

</html>
