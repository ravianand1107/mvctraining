

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Shop Homepage - Start Bootstrap Template</title>

  <!-- Bootstrap core CSS -->
  <jsp:include page="base.jsp"></jsp:include>
  <!-- Custom styles for this template -->
  <link href="assets/css/shop-homepage.css" rel="stylesheet">

</head>

<body>

  <!-- Navigation -->
<jsp:include page="nav.jsp"></jsp:include>

  <!-- Page Content -->
  <div class="container">

    <div class="row">

    <jsp:include page="sidebar.jsp"></jsp:include>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">

       

         <%
    int id = Integer.parseInt(request.getParameter("id"));
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training","root","ravi");
        String sql = "select * from news where id=?";
        PreparedStatement smt = con.prepareStatement(sql);
        smt.setInt(1, id);
        ResultSet rs = smt.executeQuery();
        if(rs.next())
{%>       <center>
            <br/>
            <h2><%=rs.getString("title")%></h2>
            <br/>
            <img src="<%=rs.getString("image")%>" width=30% class="img img-thumbnail"/>
            <br/>
            </center>
            <p><%=rs.getString("description")%></p>
            <br/><br/>
            <center><a href="home.jsp" class="btn btn-danger">Close</a></center>
          
        
        <%}
    }
    catch(Exception e){
        System.out.println("Error : "+ e.getMessage());
    }
    %>
          

          

        </div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
      <jsp:include page="footer.jsp"></jsp:include>

  <!-- Bootstrap core JavaScript -->
  <script src="assets/jquery/jquery.min.js"></script>
  <script src="assets/js/bootstrap.bundle.min.js"></script>

</body>

</html>
