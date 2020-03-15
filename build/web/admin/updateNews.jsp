<%-- 
    Document   : shownews
    Created on : 02-Feb-2020, 15:32:22
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Admin Dashboard</title>

  <!-- Custom fonts for this template-->
  <jsp:include page="base.jsp"></jsp:include>
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

            <script type="text/javascript">
                function loadNews(x, y) {

                    ajax = new XMLHttpRequest();
                    ajax.open("GET", "AjaxServlet?op=searchnews&id=" + x, true);
                    ajax.send();

                    ajax.onreadystatechange = function () {

                        if (this.readyState == 4 && this.status == 200) {
                            y.innerHTML = this.responseText;
                        }

                    };
                }


                function submitForm() {
                    document.getElementById("form1").submit();
                }
            </script>
  

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
          
 <%
                String cat_id= request.getParameter("cat_id");
                if(cat_id==null)
                    cat_id ="-1";
            %>
            <form id="form1" method="get">
                <div class="container">
                    <div class="row" >
                        <select onchange="submitForm();" name="cat_id" id="cat_id" class="dropdown dropdown-header form-control">
                            <option value="-1">Select news Category </option>
                        <%
                            try {

                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "ravi");
                                String sql = "select * from news_category";
                                PreparedStatement smt = con.prepareStatement(sql);
                                ResultSet rs = smt.executeQuery();
                                  int i = 1;
                                  while (rs.next()) {%>
                        <option value="<%=rs.getString("id")%>"<%if(cat_id.equals(rs.getString("id"))) out.println("selected");%>> <%=rs.getString("name")%> </option>
                        <br/>
                        <%}
                                con.close();
                            } catch (Exception e) {
                                System.out.println("Error " + e.getMessage());
                            }
                        %>
                    </select>

                    <br/>
                    <br/>

                    <!-- COde for Loading the News -->                 

                    <%
                        
                        String sql = "";

                        try {

                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "ravi");
                            PreparedStatement smt=null;
                            
                            if (cat_id == null || cat_id.equals("")|| cat_id.equals("-1")) {
                                  sql = "select * from news";
                                  smt = con.prepareStatement(sql);
                            } 
                            else {
                                sql = "select * from news where id in (select news_id from newstype where cat_id=?)";
                                 smt = con.prepareStatement(sql);
                                 smt.setString(1,cat_id);
                            }
                           

                            
                            ResultSet rs = smt.executeQuery();
                            int i = 1;
                            while (rs.next()) {%>


                    <div class="card col col-md-4" style="width:200px">
                        <h2><%=i++%></h2>
                        <img class="card-img-top" src="../<%=rs.getString("image")%>" alt="Card image" style="width:50%">
                        <div class="card-body">
                            <h4 class="card-title"> <%=rs.getString("title")%> </h4>
                            <% String news = rs.getString("description").trim();%>
                            <p class="card-text"> <%= news.length() > 100 ? news.substring(0, 100) : news%> ... </p>
                            <%--<button onclick="loadNews('<%=rs.getString("id")%>', newspara);" class="btn btn-primary" data-toggle="modal" data-target="#myModal" > view Detailed news</button>--%>
                            <a href="detailedNews.jsp?id=<%=rs.getString("id")%>" class="btn btn-success">View Detailed news</a>
                            <br/>
                            <a href="editNews.jsp?id=<%=rs.getString("id")%>"><i class="fa fa-pencil" aria-hidden="true"></i></a> 
                            <a href="NewsController?id=<%=rs.getString("id")%>&op=delete"> <i class="fa fa-trash" aria-hidden="true"></i> </a>

                        </div>
                    </div>

                    <%  System.out.println(rs.getString("title") + "<br/>");
                            }
                            con.close();
                        } catch (Exception e) {
                            System.out.println("Error :" + e.getMessage());
                        }
                    %>
                </div>
                </div>
            </form>

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
