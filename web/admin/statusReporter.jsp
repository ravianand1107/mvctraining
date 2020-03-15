<%-- 
    Document   : updateReporter
    Created on : 8 Mar, 2020, 11:13:27 PM
    Author     : ravi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.beans.Reporter, com.daos.ReporterDao, java.util.ArrayList"%>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Status of Reporters</title>

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
            <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Status of Reporters</h1>
            <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
          </div>
        <table width='700' border='1' cellspacing='0' class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>UserId</th>
                <th>Contact</th>
                <th>Email </th>
                <th>Status</th>
                <th>Image</th>
                <th>Operations</th>
                <th>Select</th>
            </tr>
        <%
            ReporterDao rd = new ReporterDao();
            ArrayList<Reporter> rows = new ArrayList();

            int start = request.getParameter("start") != null ? Integer.parseInt(request.getParameter("start")) : 0;
            int end = 3;
            int total = rd.getRecordsCount();
            rows = rd.getAllRecords();

            for (Reporter reporter : rows) {%>
        <tr>
            <td><%=reporter.getId()%> </td>
            <td><%=reporter.getName()%> </td>
            <td><%=reporter.getUserid()%></td>
            <td><%=reporter.getContact()%> </td>
            <td><%=reporter.getEmail()%> </td>
            <td><%=reporter.getStatus()%> </td>
            <td><img src="../<%=reporter.getImage()%>" style="width:60px; height: 60px;"></td>
            <td><input type="radio" name="status<%=reporter.getId()%>" value="approved" ${reporter.status eq "approved" ? "checked" : ""}/>Approved
                <input type="radio" name="status<%=reporter.getId()%>" value="rejected" ${reporter.status eq "rejected" ? "checked" : ""}/>Rejected
            </td>
            <td><input type="checkbox" name="select" value="select"/></td>
            
        </tr>

        <%}%>
    </table>
    <br/>
   <%-- <span style="float:left"><a href="statusReporter.jsp?start=<%=start - end%>" class="btn btn-primary <%if (start == 0) {
            out.println("disabled");
        }%>">Previous</a></span>
    <center>
        <%
            int pages = total / end + (total % end == 0 ? 0 : 1);
            for (int i = 0; i < pages; i++) {%>
        <span style="text-decoration: none; align-content: center;  <% if (Math.floor(start / end) == i) {
               out.println("background-color: orange");
        }%>" class="btn btn-dark"><a href="statusReporter.jsp?start=<%=end * i%>"><%=i + 1%></a></span> 
        <%}
        %>
        <span style="float:right"><a href="statusReporter.jsp?start=<%=start + end%>" class="btn btn-primary <% if (start + end >= total) {
             out.println(" disabled");
         }%>">Next</a></span>

    </center> 
    <br/><br/> --%>
   <center><input type="submit" name="submit" value="submit" class="form-control btn-primary"/></center>
          

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
