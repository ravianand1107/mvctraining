package org.apache.jsp.reporter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.beans.Reporter;
import java.sql.*;

public final class viewNews_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"Mark Otto, Jacob Thornton, and Bootstrap contributors\">\n");
      out.write("        <meta name=\"generator\" content=\"Jekyll v3.8.6\">\n");
      out.write("        <title>Reporter's News</title>\n");
      out.write("\n");
      out.write("        <link rel=\"canonical\" href=\"https://getbootstrap.com/docs/4.4/examples/dashboard/\">\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\n");
      out.write("        <!-- Favicons -->\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"/docs/4.4/assets/img/favicons/apple-touch-icon.png\" sizes=\"180x180\">\n");
      out.write("        <link rel=\"icon\" href=\"/docs/4.4/assets/img/favicons/favicon-32x32.png\" sizes=\"32x32\" type=\"image/png\">\n");
      out.write("        <link rel=\"icon\" href=\"/docs/4.4/assets/img/favicons/favicon-16x16.png\" sizes=\"16x16\" type=\"image/png\">\n");
      out.write("        <link rel=\"manifest\" href=\"/docs/4.4/assets/img/favicons/manifest.json\">\n");
      out.write("        <link rel=\"mask-icon\" href=\"/docs/4.4/assets/img/favicons/safari-pinned-tab.svg\" color=\"#563d7c\">\n");
      out.write("        <link rel=\"icon\" href=\"/docs/4.4/assets/img/favicons/favicon.ico\">\n");
      out.write("        <meta name=\"msapplication-config\" content=\"/docs/4.4/assets/img/favicons/browserconfig.xml\">\n");
      out.write("        <meta name=\"theme-color\" content=\"#563d7c\">\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("                function submitForm() {\n");
      out.write("                    document.getElementById(\"form1\").submit();\n");
      out.write("                }\n");
      out.write("            </script>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("        <style>\n");
      out.write("            .bd-placeholder-img {\n");
      out.write("                font-size: 1.125rem;\n");
      out.write("                text-anchor: middle;\n");
      out.write("                -webkit-user-select: none;\n");
      out.write("                -moz-user-select: none;\n");
      out.write("                -ms-user-select: none;\n");
      out.write("                user-select: none;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            @media (min-width: 768px) {\n");
      out.write("                .bd-placeholder-img-lg {\n");
      out.write("                    font-size: 3.5rem;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            if(session.getAttribute("reporter")==null){
                response.sendRedirect("../login.jsp");
                return;
            }
        
      out.write("\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "navbar.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sidebar.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("                <main role=\"main\" class=\"col-md-9 ml-sm-auto col-lg-10 px-4\">\n");
      out.write("                    <div class=\"d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom\">\n");
      out.write("                        ");

                String cat_id= request.getParameter("cat_id");
                Reporter reporter = (Reporter)session.getAttribute("reporter");
                if(cat_id==null)
                    cat_id ="-1";
            
      out.write("\n");
      out.write("            <form id=\"form1\" method=\"get\" class='form-control'>\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row\" >\n");
      out.write("                        <select onchange=\"submitForm();\" name=\"cat_id\" id=\"cat_id\" class=\"dropdown dropdown-header form-control\">\n");
      out.write("                            <option value=\"-1\">Select news Category </option>\n");
      out.write("                        ");

                            try {

                                Class.forName("com.mysql.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "ravi");
                                String sql = "select * from news_category";
                                PreparedStatement smt = con.prepareStatement(sql);
                                ResultSet rs = smt.executeQuery();
                                  int i = 1;
                                  while (rs.next()) {
      out.write("\n");
      out.write("                        <option value=\"");
      out.print(rs.getString("id"));
      out.write('"');
if(cat_id.equals(rs.getString("id"))) out.println("selected");
      out.write('>');
      out.write(' ');
      out.print(rs.getString("name"));
      out.write(" </option>\n");
      out.write("                        <br/>\n");
      out.write("                        ");
}
                                con.close();
                            } catch (Exception e) {
                                System.out.println("Error " + e.getMessage());
                            }
                        
      out.write("\n");
      out.write("                    </select>\n");
      out.write("\n");
      out.write("                    <br/>\n");
      out.write("                    <br/>\n");
      out.write("\n");
      out.write("                    <!-- COde for Loading the News -->                 \n");
      out.write("\n");
      out.write("                    ");

                        
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
                            while (rs.next()) {
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"card col col-md-4\" style=\"width:200px\">\n");
      out.write("                        <h2>");
      out.print(i++);
      out.write("</h2>\n");
      out.write("                        <img class=\"card-img-top\" src=\"../");
      out.print(rs.getString("image"));
      out.write("\" alt=\"Card image\" style=\"width:50%\">\n");
      out.write("                        <div class=\"card-body\">\n");
      out.write("                            <h4 class=\"card-title\"> ");
      out.print(rs.getString("title"));
      out.write(" </h4>\n");
      out.write("                            ");
 String news = rs.getString("description").trim();
      out.write("\n");
      out.write("                            <p class=\"card-text\"> ");
      out.print( news.length() > 100 ? news.substring(0, 100) : news);
      out.write(" ... </p>\n");
      out.write("                            ");
      out.write("\n");
      out.write("                            <a href=\"detailedNews.jsp?id=");
      out.print(rs.getString("id"));
      out.write("\" class=\"btn btn-success\">View Detailed news</a>\n");
      out.write("                            <br/>\n");
      out.write("                            <a href=\"editNews.jsp?id=");
      out.print(rs.getString("id"));
      out.write("\"><i class=\"fa fa-pencil\" aria-hidden=\"true\"></i></a> \n");
      out.write("                            <a href=\"NewsController?id=");
      out.print(rs.getString("id"));
      out.write("&op=delete\"> <i class=\"fa fa-trash\" aria-hidden=\"true\"></i> </a>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    ");
  System.out.println(rs.getString("title") + "<br/>");
                            }
                            con.close();
                        } catch (Exception e) {
                            System.out.println("Error :" + e.getMessage());
                        }
                    
      out.write("\n");
      out.write("                </div>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                </main>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
