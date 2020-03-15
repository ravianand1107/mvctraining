
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*,com.daos.PersonDao,com.beans.Person"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Person's Detail</title>
        <jsp:include page="base.jsp"></jsp:include>
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
            </script>
        </head>
        <body>
        <jsp:useBean id="person1" class="com.beans.Person" scope="session"></jsp:useBean>
            <div class="container">
                <div class="row">
                    <div class="col">
                    <%
                        int id = request.getParameter("id") != null ? Integer.parseInt(request.getParameter("id")) : 0;
                        PersonDao pd = new PersonDao();
                        person1 = pd.getById(id);
                       session.setAttribute("person1", person1);
                    %>

                    <center><h2> Updation page </h2>

                    <form method='post' class="form"> 
                        <input type="text" value="<%=person1.getId()%>" readonly="readonly" name="id"/>
                        <table width="800" class="table">
                            <tr>
                                <td>Enter name</td>
                                <td><input type="text" name="name" required="reqiured" class="form-control" value="${person1.name}"></td>
                            </tr>
                            <tr>
                                <td>Enter father's name</td>
                                <td><input type="text" name="fname"class="form-control" value="${person1.fname}"></td>
                            </tr>
                            <tr>
                                <td>Enter Age</td>
                                <td><input type="number" name="age" min="10" max="100"class="form-control" value="${person1.age}"></td>
                            </tr>

                            <tr>
                                <td>Your UserID</td>
                                <td><input type="text" name="userid"  value="${person1.userid}" readonly="readonly"></td>
                            </tr>
                            <tr>
                                <td>Select gender</td>
                                <td><input type="radio" name="gender"  value="male" ${person1.gender eq "Male" ? "checked":""} >Male
                                    <input type="radio" name="gender"  value="female" ${person1.gender eq "Female" ? "checked":""}>Female</td>
                            </tr>
                            <tr>
                                <td>Select Your Hobbies : </td>
                                <td>
                                    <input type="checkbox" name="hobbies" value="Dancing" ${person1.hobbies.contains ("Dancing") ? "checked":""}>Dancing
                                    <input type="checkbox" name="hobbies" value="Singing" ${person1.hobbies.contains ("Singing") ? "checked":""}>Singing <br/>
                                    <input type="checkbox" name="hobbies" value="Cooking" ${person1.hobbies.contains ("Cooking") ? "checked":""}>Cooking
                                    <input type="checkbox" name="hobbies" value="Drawing" ${person1.hobbies.contains ("Drawing") ? "checked":""}>Drawing <br/>
                                </td>
                            </tr>
                        </table>
                        <input type="submit" name="submit" value="Click here to Check Profile Image " class="btn btn-primary form-control"/>
                    </form>
                    <%if (request.getParameter("submit") != null) {%> 
                    <jsp:setProperty name="person1" property="*"></jsp:setProperty>
                    
                        <form action="PersonController?op=update" method="post" enctype="multipart/form-data" class="form"> 
                            <img src="${person1.image}" class="img img-thumbnail" width="20%" height="20%" id="preview"/> <br/>
                        <input type="file" name="photo" onchange="readURL(this);"/><br/><br>
                        <input type="submit" value="Update" class="btn btn-primary form-control"/>
                    </form>  

                    <%
                      session.setAttribute("person1", person1); }
                    %>

                    </center>

                </div>
            </div>
        </div>



    </body>
</html>