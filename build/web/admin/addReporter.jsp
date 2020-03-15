<%-- 
    Document   : addReporter
    Created on : 6 Mar, 2020, 4:56:48 PM
    Author     : ravi
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="com.beans.Reporter"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Adding Reporter</title>

  <!-- Custom fonts for this template-->
  <jsp:include page="base.jsp"></jsp:include>
  
  
  <script>
                
                function matchPwd(x, y) {
                    if (x === y)
                        return true;
                    else
                    {
                        alert('sorry! password and confirm password not matched');
                        return false;
                    }

                }

                function readURL(input, preview) {
                    if (input.files && input.files[0]) {
                        var reader = new FileReader();

                        reader.onload = function (e) {
                            preview.src = e.target.result;
                        };

                        reader.readAsDataURL(input.files[0]);
                    }
                }
                
                function checkUserid(x, y) {
                    ajax1 = new XMLHttpRequest();
                    ajax1.open("GET", "../ReporterController?op=check_userid&userid=" + x, true);
                    ajax1.send();

                    ajax1.onreadystatechange = function () {
                        if (this.readyState == 4 && this.status == 200) {
                            y.innerHTML = this.responseText;
                        }
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

<body id="page-top">
    <%
        if (session.getAttribute("admin")==null){
            response.sendRedirect("../login.jsp");
            return;
        }
        %>
<jsp:useBean id="reporter" class="com.beans.Reporter" scope="session"></jsp:useBean>
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


                <div class="row">
                    <div class="col col-md-3" style="position: fixed; right: 0px;">
                    <%if (request.getParameter("submit") != null) {%>
                    <jsp:setProperty name="reporter" property="*"></jsp:setProperty><center>
                            <form action="../ReporterController?op=add" method="post" enctype="multipart/form-data">
                                <img src="" style="width:200px;height: 200px" border="2" id="preview" class="form-control"/><br/>
                                <input type="file" class="btn btn-success form-control" name="image" onchange="readURL(this, preview);"/>
                                <br/><br/>
                                <input type="submit" class="btn btn-primary form-control" value="Add to Database" name="submit"/>
                            </form></center>
                        <%}%>
                </div>

                <div class="col col-md-9">
                    <form method="post" class="form" onsubmit="return matchPwd(password.value, cpassword.value);">
                        <table class="table">
                            <tr><th colspan="2"><center><h2>Fill the Reporter Details Here </h2></center></th></tr>
                            <tr>
                                <td>Enter Reporter Name </td>
                                <td><input type="text" name="name" class="form-control" value="${reporter.name}"/></td>
                            </tr> 
                            <tr>
                                <td>Enter Reporter DOB </td>
                                <td><input type="date" name="dob" class="form-control" value="${reporter.dob}"/></td>
                            </tr> 
                            <tr>
                                <td>Select Gender  </td><br/>
                                <td><input type="radio" name="gender" value="Male" ${reporter.gender eq "Male" ? "checked" : ""}/> Male 
                                    <input type="radio" name="gender" value="Female" ${reporter.gender eq "Female" ? "checked" : ""}/> Female 
                                </td>
                            </tr> <br/>
                            <tr>
                                <td>Enter Reporter's Contact </td>
                                <td><input type="text" name="contact" class="form-control" required="required" value="${reporter.contact}" maxlength="10" id="contact" onblur="checkContact(this.value,sp3);"/>
                                <span id ="sp3"></span></td>
                            </tr> 

                            <tr>
                                <td>Enter Reporter's Email </td>
                                <td><input type="email" name="email" class="form-control" required="required" value="${reporter.email}" id="email" onblur="checkEmail(this.value,sp1);" />
                                <span id ="sp1"> </span></td>
                            </tr> 

                            <tr>
                                <td>Enter Reporter's Userid </td>
                                <td><input type="text" name="userid" class="form-control" id="userid" required="required" onblur="checkUserid(this.value,sp2);" value="${reporter.userid}"/>
                                <span id ="sp2"> </span></td>
                            </tr> 

                            <tr>
                                <td>Enter Reporter's Password </td>
                                <td><input type="password" name="password" id="password" class="form-control" required="required" value="${reporter.password}"/></td>
                            </tr>
                            <tr>
                                <td>Confirm Reporter's Password</td>
                                <td><input type="password" name="cpassword" id="cpassword" required="required" class="form-control" value="${reporter.password}"></td>
                            </tr>

                            <input type="hidden" name="status" value="approved"/>
                        </table>
                        <input type="submit" value="Save and Next" name="submit" id ="submit" class="form-control btn btn-primary"/>
                    </form>                
                </div>

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

</body>

</html>
