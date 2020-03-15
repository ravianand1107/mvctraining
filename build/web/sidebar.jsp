<%@page import="java.sql.*, com.beans.Subscribers" %>
<div class="col-lg-3">

    <h1 class="my-4"><b>Top News</b></h1>
    <div class="list-group">
        <a href="home.jsp" class="list-group-item <%if (request.getParameter("cat_id") == null) {
                out.println(" active ");
            }%>"> All News</a>
        <%
            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "ravi");
                String sql = "select * from news_category";
                PreparedStatement smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                int i = 1;
                while (rs.next()) {%>
        <a href="home.jsp?cat_id=<%=rs.getString("id")%>" class="list-group-item <%if (rs.getString("id").equals(String.valueOf(request.getParameter("cat_id")))) {
                out.println(" active ");
            }%>"><%=rs.getString("name")%></a>

        <% }
                con.close();
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        %>
    </div>
    <br/><center><button type="button" class="btn btn-dark" data-toggle="modal" data-target="#myModal">
            Subscribe Us
        </button></center>

    <!-- The Modal -->
    <div class="modal" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Fill the Basic Details</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <form method="post" class="form bg-light">
                        <input type="text" placeholder="Enter Name" name="name" class="form-control"> <br/><br/>
                        <input type="email" name="email" placeholder="Enter your email" class="form-control"/> <br/><br/>
                        <input type="submit" value="Subscribe" class="btn btn-dark form-control" name="submit"/>
                    </form>
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                </div>

            </div>           
        </div>        

    </div>
</div>
<%if (request.getParameter("submit") != null) {%>
<jsp:useBean id="subscriber" class="com.beans.Subscribers"></jsp:useBean>
<jsp:setProperty name="subscriber" property="*"></jsp:setProperty>

<%
        Connection con = null;
        PreparedStatement smt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "ravi");
            String sql = "Insert into subscribers (name,email) values(?,?)";
            smt = con.prepareStatement(sql);
            smt.setString(1, subscriber.getName());
            smt.setString(2, subscriber.getEmail());
            int n = smt.executeUpdate();
            con.close();
            smt.close();
            if (n > 0) {
                out.println("<script>alert('Thanks for subscription !');</script>");
            }
        } catch (Exception e) {
            if(e.getMessage().contains("Duplicate"))
                out.println("<script>alert('You have already subscribed to this website!!!');</script>");
            System.out.println("Error: "+e.getMessage());
        }
     }%>