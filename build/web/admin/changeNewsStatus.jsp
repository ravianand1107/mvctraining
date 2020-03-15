<%-- 
    Document   : changeNewsStatus
    Created on : 8 Mar, 2020, 12:16:35 AM
    Author     : ravi
--%>

<%@page import="com.beans.News"%>
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

        <title> Update Status</title>

        <jsp:include page="base.jsp"></jsp:include>
        </head>

        <body id="page-top">
        <%
            if (session.getAttribute("admin") == null) {
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
                            <div class="row">
                                <%
                                    int newsid = request.getParameter("newsid") != null ? Integer.parseInt(request.getParameter("newsid")) : 0;
                                    NewsDao nd = new NewsDao();
                                    News news = nd.getById(newsid);
                                %>
                                <div class="card col col-md-10" style=" text-align: justify;text-justify: inter-word;">
                                    <div class="card-body">
                                        <h4 class="card-title"><%=news.getTitle() %></h4>
                                        <p class="card-text"><%=news.getDescription()%></p>
                                    </div>
                                    <img class="card-img-bottom" src="../<%=news.getImage()%>" alt="Card image" style="width:20%">
                                    <br/><br/>
                                    <a href="<%=request.getHeader("referer")%>" class="btn btn-primary">Back </a>
                                    <form method="post">
                                    <h4>Change Status </h4>
                                    <p><input type="radio" name="status" value="pending" <%if(news.getStatus().equals("pending"))out.println(" checked"); %>/>Pending </p>  
                                    <p><input type="radio" name="status" value="approved" <%if(news.getStatus().equals("approved"))out.println(" checked"); %>/>Approved </p>
                                    <p><input type="radio" name="status" value="rejected" <%if(news.getStatus().equals("rejected"))out.println(" checked"); %>/>Rejected </p>
                                     
                                    <p>Reason to Change Status :</p>
                                    <p><input type="text" name="status_text" /> </p>
                                    <p><input type="submit" name="submit" value="Save and Return" class="btn btn-primary form-control"/></p>
                                    </form>
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
<%
    if(request.getParameter("submit")!=null){
         String status = request.getParameter("status");
         String status_text  = request.getParameter("status_text");
         if(nd.updateNewsStatus(news, status, status_text)) 
             response.sendRedirect("showNews.jsp");
         else 
             out.println("<script>alert('Status cannot be Updated');</script>");
    }
    
    %>
    </body>

</html>
