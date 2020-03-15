

<%@page import="com.beans.Reporter"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v3.8.6">
        <title>Reporter's News</title>

        <link rel="canonical" href="https://getbootstrap.com/docs/4.4/examples/dashboard/">

        <!-- Bootstrap core CSS -->
        <jsp:include page="base.jsp"></jsp:include>
        <!-- Favicons -->
        <link rel="apple-touch-icon" href="/docs/4.4/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
        <link rel="icon" href="/docs/4.4/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
        <link rel="icon" href="/docs/4.4/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
        <link rel="manifest" href="/docs/4.4/assets/img/favicons/manifest.json">
        <link rel="mask-icon" href="/docs/4.4/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
        <link rel="icon" href="/docs/4.4/assets/img/favicons/favicon.ico">
        <meta name="msapplication-config" content="/docs/4.4/assets/img/favicons/browserconfig.xml">
        <meta name="theme-color" content="#563d7c">

        <script type="text/javascript">
                function submitForm() {
                    document.getElementById("form1").submit();
                }
            </script>
            
            
        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>

    </head>
    <body>
        <%
            if(session.getAttribute("reporter")==null){
                response.sendRedirect("../login.jsp");
                return;
            }
        %>
    <jsp:include page="navbar.jsp"></jsp:include>

        <div class="container-fluid">
            <div class="row">
            <jsp:include page="sidebar.jsp"></jsp:include>

                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <%
                String cat_id= request.getParameter("cat_id");
                Reporter reporter = (Reporter)session.getAttribute("reporter");
                if(cat_id==null)
                    cat_id ="-1";
            %>
            <form id="form1" method="get" class='form-control'>
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
                                  sql = "select * from news where status='approved' and reporter_id=?";
                                  
                                  smt = con.prepareStatement(sql);
                                  smt.setInt(1, reporter.getId());
                            } 
                            else {
                                sql = "select * from news where id in (select news_id from newstype where cat_id=?) and status='approved' and reporter_id=?";
                                 smt = con.prepareStatement(sql);
                                 smt.setString(1,cat_id);
                                 smt.setInt(2, reporter.getId());
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
                </main>
            </div>
        </div>

    </body>
</html>
