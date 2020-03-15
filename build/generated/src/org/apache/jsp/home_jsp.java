package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.daos.NewsDao;
import com.beans.News;
import java.sql.*;
import java.util.ArrayList;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("        <title>News</title>\n");
      out.write("        <link rel=\"icon\" href=\"assets/images/favicon2.ico\" type=\"x/image\"/>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\n");
      out.write("            <!-- Custom styles for this template -->\n");
      out.write("            <link href=\"assets/css/shop-homepage.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        </head>\n");
      out.write("\n");
      out.write("        <body>\n");
      out.write("\n");
      out.write("            <!-- Navigation -->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "nav.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("            <!-- Page Content -->\n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sidebar.jsp", out, false);
      out.write("\n");
      out.write("                    <!-- /.col-lg-3 -->\n");
      out.write("\n");
      out.write("                    <div class=\"col-lg-9\">\n");
      out.write("\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "carousel.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("                        <div class=\"row\" id=\"livenews\">\n");
      out.write("\n");
      out.write("                        ");

                            NewsDao nd = new NewsDao();
                            
                            String cat_id = request.getParameter("cat_id");
                            if (cat_id == null) {
                                cat_id = "-1";
                            }

                            int i = 1;
                            for (News news : (cat_id == null || cat_id.equals("") || cat_id.equals("-1")) ? nd.getAllNews() : nd.getNewsByCatId(Integer.parseInt(cat_id))) {
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"col-lg-4 col-md-6 mb-4\">\n");
      out.write("                            <div class=\"card h-100\">\n");
      out.write("                                <a href=\"#\"><img class=\"card-img-top\" src=\"");
      out.print(news.getImage());
      out.write("\" height=200 alt=\"\"></a>\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <h4 class=\"card-title\">\n");
      out.write("                                        <a href=\"detailedNews2.jsp?id=");
      out.print(news.getId());
      out.write('"');
      out.write('>');
      out.print(news.getTitle());
      out.write("</a>\n");
      out.write("                                    </h4>\n");
      out.write("                                    ");
 String news1 = news.getDescription().trim();
      out.write("\n");
      out.write("                                    <p class=\"card-text\"> ");
      out.print( news1.length() > 100 ? news1.substring(0, 100) : news1);
      out.write(" ... </p>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"card-footer\">\n");
      out.write("                                    <a href=\"detailedNews2.jsp?id=");
      out.print(news.getId());
      out.write("\" class=\"btn btn-success\">View Detailed news</a>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        ");
  System.out.println(news.getTitle() + "<br/>");
                            }

                        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.row -->\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <!-- /.col-lg-9 -->\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!-- /.row -->\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- /.container -->\n");
      out.write("\n");
      out.write("        <!-- Footer -->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Bootstrap core JavaScript -->\n");
      out.write("\n");
      out.write("        <script src=\"assets/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("\n");
      out.write("\n");
      out.write("                $(\"#search\").click(function () {\n");
      out.write("                    $(\"#livenews\").html(\"\");\n");
      out.write("                    $.get(\"http://newsapi.org/v2/everything?q=\" + $(\"#keyword\").val() + \"&from=2020-03-03&to=2020-03-03&sortBy=popularity&apiKey=ba6f203462264afd97b02e38745225e3\", function (responseText) {\n");
      out.write("                        news = responseText;\n");
      out.write("                        articals = news['articles'];\n");
      out.write("                        for (i = 0; i < articals.length; i++) {\n");
      out.write("                            article = '<div class=\"col-lg-4 col-md-6 mb-4\">\\\n");
      out.write("                            <div class=\"card h-100\">\\\n");
      out.write("                                <a href=\"#\"><img class=\"card-img-top\" src=\"' + articals[i].urlToImage + '\"  alt=\"\"></a>\\\n");
      out.write("                                <div class=\"card-body\">\\\n");
      out.write("                                    <h4 class=\"card-title\">\\\n");
      out.write("                                        <a href=\"' + articals[i].url + '\">' + articals[i].title + '</a>\\\n");
      out.write("                                    </h4>\\\n");
      out.write("\\\n");
      out.write("                                    <p class=\"card-text\"> ' + articals[i].description + ' </p>\\\n");
      out.write("                                </div>\\\n");
      out.write("                                <div class=\"card-footer\">\\\n");
      out.write("                                    <small class=\"text-muted\"> <a href=\"' + articals[i].url + '\" class=\"btn btn-primary\"> View More </a>\\\n");
      out.write("                            </small>\\\n");
      out.write("                                </div>\\\n");
      out.write("                            </div>\\\n");
      out.write("                        </div>';\n");
      out.write("                            $(\"#livenews\").append(article);\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
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
