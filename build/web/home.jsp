

<%@page import="com.daos.NewsDao, com.beans.News"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*, java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>News</title>
        <link rel="icon" href="assets/images/favicon2.ico" type="x/image"/>

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

                    <jsp:include page="carousel.jsp"></jsp:include>

                    
                    
                        <div class="row" id="livenews">

                        <%
                            NewsDao nd = new NewsDao();
                            
                            String cat_id = request.getParameter("cat_id");
                            if (cat_id == null) {
                                cat_id = "-1";
                            }

                            int i = 1;
                            for (News news : (cat_id == null || cat_id.equals("") || cat_id.equals("-1")) ? nd.getAllNews() : nd.getNewsByCatId(Integer.parseInt(cat_id))) {%>

                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card h-100">
                                <a href="#"><img class="card-img-top" src="<%=news.getImage()%>" height=200 alt=""></a>
                                <div class="card-body">
                                    <h4 class="card-title">
                                        <a href="detailedNews2.jsp?id=<%=news.getId()%>"><%=news.getTitle()%></a>
                                    </h4>
                                    <% String news1 = news.getDescription().trim();%>
                                    <p class="card-text"> <%= news1.length() > 100 ? news1.substring(0, 100) : news1%> ... </p>
                                </div>
                                <div class="card-footer">
                                    <a href="detailedNews2.jsp?id=<%=news.getId()%>" class="btn btn-success">View Detailed news</a>

                                </div>
                            </div>
                        </div>
                        <%  System.out.println(news.getTitle() + "<br/>");
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

        <script src="assets/js/bootstrap.bundle.min.js"></script>

        <script>
            $(document).ready(function () {


                $("#search").click(function () {
                    $("#livenews").html("");
                    $.get("http://newsapi.org/v2/everything?q=" + $("#keyword").val() + "&from=2020-03-03&to=2020-03-03&sortBy=popularity&apiKey=ba6f203462264afd97b02e38745225e3", function (responseText) {
                        news = responseText;
                        articals = news['articles'];
                        for (i = 0; i < articals.length; i++) {
                            article = '<div class="col-lg-4 col-md-6 mb-4">\
                            <div class="card h-100">\
                                <a href="#"><img class="card-img-top" src="' + articals[i].urlToImage + '"  alt=""></a>\
                                <div class="card-body">\
                                    <h4 class="card-title">\
                                        <a href="' + articals[i].url + '">' + articals[i].title + '</a>\
                                    </h4>\
\
                                    <p class="card-text"> ' + articals[i].description + ' </p>\
                                </div>\
                                <div class="card-footer">\
                                    <small class="text-muted"> <a href="' + articals[i].url + '" class="btn btn-primary"> View More </a>\
                            </small>\
                                </div>\
                            </div>\
                        </div>';
                            $("#livenews").append(article);
                        }


                    });
                });

            });
        </script>

    </body>

</html>
