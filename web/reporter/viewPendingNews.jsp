

<%@page contentType="text/html" pageEncoding="UTF-8"import="com.daos.NewsDao, com.beans.News, java.util.ArrayList, com.beans.Reporter"%>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v3.8.6">
        <title>Reporter Dashboard</title>

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
            if (session.getAttribute("reporter") == null) {
                response.sendRedirect("../login.jsp");
                return;
            }
        %>
        <jsp:include page="navbar.jsp"></jsp:include>

            <div class="container-fluid">
                <div class="row">
                <jsp:include page="sidebar.jsp"></jsp:include>

                    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                        <center><h3>List Of Pending News</h3></center>
                        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                            
                            <table width='700' border='1' cellspacing='0' class="table table-striped">
                                <tr>
                                    <th>Title</th><th>Status</th>
                                </tr>
                            <%
                                Reporter reporter = (Reporter) session.getAttribute("reporter");
                                NewsDao ndo = new NewsDao();
                                ArrayList<News> newsList = new ArrayList();
                                newsList = ndo.getNewsStatusByReporterID(reporter.getId(), "pending");
                                for (News news : newsList) {%>
                            <tr>
                                <td><%=news.getTitle()%></td>
                                <td><%=news.getStatus()%></td>
                            </tr>
                            <%}
                            %>
                        </table>



                    </div>
            </div>
        </main>
    </div>
</div>

</body>
</html>
