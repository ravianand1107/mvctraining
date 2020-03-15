<%-- 
    Document   : add
    Created on : 26-Jan-2020, 12:05:54
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="com.beans.Person, com.daos.PersonDao"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
        <link rel="icon" href="assets/images/favicon.ico" type="x/image"/>
        <jsp:include page="base.jsp"></jsp:include>
            <script type="text/javascript">

                function matchPwd(x, y) {
                    if (x === y)
                        return true;
                    else
                    {
                        alert('sorry! password and confirm password not matched');
                        return false;
                    }

                }

                function checkValue(x, y) {

                    if (x.checked == true)
                    {
                        y.disabled = false;
                    } else {
                        y.disabled = true;
                    }
                }

                function checkUserid(x, y) {
                    ajax = new XMLHttpRequest();
                    ajax.open("GET", "PersonController?op=check_userid&userid=" + x, true);
                    ajax.send();

                    ajax.onreadystatechange = function () {
                        if (this.readyState == 4 && this.status == 200) {
                            y.innerHTML = this.responseText;
                        }
                    }
                }

            </script>
        </head>
        <body>
        <jsp:useBean class="com.beans.Person" id="person" scope="session"></jsp:useBean>
    <center><h2>Registration page </h2></center>
    <form action="addpic.jsp" method='post' class="form"  onsubmit="return matchPwd(password.value, cpassword.value);"> 
        <table width="600" class="table">
            <tr>
                <td>Enter Name </td>
                <td><input type="text" name="name" required="required" class="form-control" value="${person.name}"></td>
            </tr>
            <tr>
                <td>Enter Father Name </td>
                <td><input type="text" name="fname" required="required"  class="form-control" value="${person.fname}"></td>
            </tr>   
            <tr>
                <td>Enter UserID </td>
                <td><input type="text" name="userid" required="required" class="form-control" id="userid" onblur="checkUserid(this.value, sp1);" value="${person.userid}">
                    <span id ="sp1"> </span>
                </td>
            </tr>
            <tr>
                <td>Enter Password</td>
                <td><input type="password" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" name="password" id="password" required="required" class="form-control" value="${person.password}">
                    <br/>
                    <b>Password must contains atleast one uppercase,one lowercase , one special char and more than 8 characters</b>
                </td>
            </tr>
            <tr>
                <td>Confirm Password</td>
                <td><input type="password" name="cpassword" id="cpassword" required="required" class="form-control" value="${person.password}"></td>
            </tr>
            <tr>
                <td>Enter Age</td>
                <td><input type="number" name="age"class="form-control" value="${person.age}"></td>
            </tr>
            <tr>
                <td>Select Gender </td>
                <td>
                    <input type="radio" name="gender"  value="Male" ${person.gender eq "Male"?"checked":""}/>Male
                    <br/>
                    <input type="radio" name="gender"  value="Female" ${person.gender eq "Female"?"checked":""}/> Female
                </td>
            </tr>
            <tr>
                <td>Select Your Hobbies : </td>
                <td>
                    <input type="checkbox" name="hobbies" value="Dancing" ${person.hobbies.contains("Dancing")? "checked":""}>Dancing
                    <input type="checkbox" name="hobbies" value="Singing" ${person.hobbies.contains("Singing")? "checked":""}>Singing <br/>
                    <input type="checkbox" name="hobbies" value="Cooking" ${person.hobbies.contains("Cooking")? "checked":""}>Cooking
                    <input type="checkbox" name="hobbies" value="Drawing" ${person.hobbies.contains("Drawing")? "checked":""}>Drawing <br/>

                </td>
            </tr>

            <tr>
                <th> <input type="checkbox" value="accept" name="accept" id="accept" onchange="checkValue(this, submit)"/> Accept Terms and Condition.</th>
                <th><input type="submit" name="submit" id="submit" value="Next Page" class="btn btn-primary" disabled="disabled"> </th>
            </tr>
        </table>

    </form>
</body>
</html>