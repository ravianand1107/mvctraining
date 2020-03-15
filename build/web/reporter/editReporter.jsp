<%-- 
    Document   : editReporter
    Created on : 9 Mar, 2020, 12:17:21 AM
    Author     : ravi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.beans.Reporter, com.daos.ReporterDao, java.util.ArrayList"%>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Jekyll v3.8.6">
        <title>Edit Reporter's details</title>

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

            <script type="text/javascript">

                function readURL(input) {
                    //       alert('hello');
                    if (input.files && input.files[0]) {
                        var reader = new FileReader();

                        reader.onload = function (e) {
                            preview.src = e.target.result;
                        };

                        reader.readAsDataURL(input.files[0]);
                    }
                }

                function checkEmail(x, y) {
                    ajax2 = new XMLHttpRequest();
                    ajax2.open("GET", "../ReporterController?op=check_email&email=" + x, true);
                    ajax2.send();

                    ajax2.onreadystatechange = function () {
                        if (this.readyState == 4 && this.status == 200) {
                            y.innerHTML = this.responseText;
                        }
                    }
                }

                function checkContact(x, y) {
                    ajax3 = new XMLHttpRequest();
                    ajax3.open("GET", "../ReporterController?op=check_contact&contact=" + x, true);
                    ajax3.send();

                    ajax3.onreadystatechange = function () {
                        if (this.readyState == 4 && this.status == 200) {
                            y.innerHTML = this.responseText;
                        }
                    }
                }
            </script>

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
                        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <jsp:useBean id="reporter1" class="com.beans.Reporter" scope="session"></jsp:useBean>
                            <div class="container">
                                <div class="row">
                                    <div class="col">
                                    <%
                                        reporter1 = (Reporter) session.getAttribute("reporter");
                                        ReporterDao rd = new ReporterDao();
                                        Reporter reporter = rd.getById(reporter1.getId());
                                        session.setAttribute("reporter1", reporter1);
                                    %>

                                    <center><h2>Edit Reporter's Details</h2>

                                        <form method='post' class="form">
                                            <table width="800" class="table">
                                                <tr>
                                                    <td>Reporter's Id</td>
                                                    <td><input type="text" class="form-control" value="${reporter1.id}" readonly="readonly" name="id"></td>
                                                </tr>
                                                <tr>
                                                    <td>Enter name</td>
                                                    <td><input type="text" name="name" required="reqiured" class="form-control" value="${reporter1.name}"></td>
                                                </tr>
                                                <tr>
                                                    <td>Enter DOB</td>
                                                    <td><input type="date" name="dob" class="form-control" value="${reporter1.dob}"></td>
                                                </tr>
                                                <tr>
                                                    <td>Select Gender</td>
                                                    <td><input type="radio" name="gender"   value="male" ${reporter1.gender eq "male" ? "checked":""} >Male
                                                        <input type="radio" name="gender" value="female" ${reporter1.gender eq "female" ? "checked":""}>Female</td>
                                                </tr>

                                                <tr>
                                                    <td>Your UserID</td>
                                                    <td><input type="text" name="userid" class="form-control" value="${reporter1.userid}" readonly="readonly"></td>
                                                </tr>

                                                <tr>
                                                    <td>Your Contact</td>
                                                    <td><input type="number" name="contact" maxlength="10" id="contact" class="form-control" value="${reporter1.contact}" onblur="checkContact(this.value, sp3);" >
                                                    <span id ="sp3"></span></td>
                                                </tr>

                                                <tr>
                                                    <td>Your Email</td>
                                                    <td><input type="email" name="email"  value="${reporter1.email}" id="email" class="form-control" onblur="checkEmail(this.value, sp1);" >
                                                    <span id ="sp1"></span></td>
                                                </tr>

                                                <tr>
                                                    <td>Your Status</td>
                                                    <td><input type="text" name="status"  value="${reporter1.status}" class="form-control" readonly="readonly"></td>
                                                </tr>
                                            </table>
                                            <input type="submit" name="submit" value="Click here to Check Profile Image " class="btn btn-primary form-control"/>
                                        </form>
                                        <%if (request.getParameter("submit") != null) {%> 
                                        <jsp:setProperty name="reporter1" property="*"></jsp:setProperty>

                                            <form action="../ReporterController?op=update" method="post" enctype="multipart/form-data" class="form"> 
                                                <img src="../${reporter1.image}" class="img img-thumbnail" width="20%" height="20%" id="preview"/> <br/>
                                            <input type="file" name="photo" onchange="readURL(this);"/><br/><br>
                                            <input type="submit" value="Update" class="btn btn-primary form-control"/>
                                        </form>  

                                        <%
                                                session.setAttribute("reporter1", reporter1);
                                            }
                                        %>

                                    </center>

                                </div>
                            </div>
                        </div>

                    </div>
                </main>
            </div>
        </div>

    </body>
</html>
