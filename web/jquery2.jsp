<%-- 
    Document   : jquery2
    Created on : 28 Feb, 2020, 11:05:51 AM
    Author     : ravi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JQuery2</title>
        <jsp:include page="base.jsp"></jsp:include>
    </head>
    <body>
        <pre>
            Enter First no.: <input type="text" id="t1"/><br/>
            Enter Second no.: <input type="text" id="t2"><br/>
            <input type="button" value="Find Sum" id="b1"/>
            <span id="result"></span>
        </pre>
        
        <script>
            $("#b1").click(function(){
                //$("#t1").val(200);
                a= Number($("#t1").val()) + Number($("#t2").val());
                $("#result").html("<b>SUM = "+ a +"</b>");
            });
            
            $("input").focus(function(){
                $("#result").html("");
            });
        </script>
    </body>
</html>
