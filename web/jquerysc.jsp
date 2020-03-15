<%-- 
    Document   : jquerysc
    Created on : 28 Feb, 2020, 10:18:44 AM
    Author     : ravi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="base.jsp"></jsp:include>
        
        
    </head>
    <body>
        <input type="button" value="Hide div" id="b1"/>
        <input type="button" value="Show div" id="b2"/>
        <input type="button" value="Show/Hide" id="b3"/>
        <div id="div1" style="background-color: orangered; height: 200px" ></div>
        <div id="div2" style="background-color: whitesmoke; height: 200px" >
            <center><img src="media/Ashoka_Chakra.svg" height="200px" width="200px"</center>
        </div>
        <div id="div3" style="background-color: green; height: 200px" ></div>
        
        <script>
           /* $(document).ready(function(){ //it is used on script tag outside body in the head tag
                //alert("hello");
                $("#b1").click(function(){
                    //$("#div1").hide();
                    $("#div1").slideUp(2000);
                    $("#div2").slideUp(2000);
                    $("#div3").slideUp(2000);
                });
                
                $("#b2").click(function(){
                    //$("#div1").show();
                    $("#div1").slideDown(2000);
                    $("#div2").slideDown(2000);
                    $("#div3").slideDown(2000);
                });
                
               //$("input").click(function(){alert("OK");});
            });*/
    
                $("#b1").click(function(){
                    //$("#div1").hide();
                    $("#div1").slideUp(2000);
                    $("#div2").slideUp(2000);
                    $("#div3").slideUp(2000, function(){alert("Div is hidden now");});
                });
                
                $("#b2").click(function(){
                    //$("#div1").show();
                    $("#div1").slideDown(2000);
                    $("#div2").slideDown(2000);
                    $("#div3").slideDown(2000, function(){alert("Div is shown now");});
                });
                
                $("#b3").click(function(){
                    //$("#div1").show();
                    $("#div1").slideToggle(2000);
                    $("#div2").slideToggle(2000);
                    $("#div3").slideToggle(2000);
                });
                
                
        </script>
    </body>
</html>
