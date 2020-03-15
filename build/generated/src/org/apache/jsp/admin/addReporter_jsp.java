package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.beans.Reporter;

public final class addReporter_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("  <meta name=\"description\" content=\"\">\n");
      out.write("  <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("  <title>Adding Reporter</title>\n");
      out.write("\n");
      out.write("  <!-- Custom fonts for this template-->\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "base.jsp", out, false);
      out.write("\n");
      out.write("  \n");
      out.write("  \n");
      out.write("  <script>\n");
      out.write("                \n");
      out.write("                function matchPwd(x, y) {\n");
      out.write("                    if (x === y)\n");
      out.write("                        return true;\n");
      out.write("                    else\n");
      out.write("                    {\n");
      out.write("                        alert('sorry! password and confirm password not matched');\n");
      out.write("                        return false;\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                function readURL(input, preview) {\n");
      out.write("                    if (input.files && input.files[0]) {\n");
      out.write("                        var reader = new FileReader();\n");
      out.write("\n");
      out.write("                        reader.onload = function (e) {\n");
      out.write("                            preview.src = e.target.result;\n");
      out.write("                        };\n");
      out.write("\n");
      out.write("                        reader.readAsDataURL(input.files[0]);\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                function checkUserid(x, y) {\n");
      out.write("                    ajax1 = new XMLHttpRequest();\n");
      out.write("                    ajax1.open(\"GET\", \"../ReporterController?op=check_userid&userid=\" + x, true);\n");
      out.write("                    ajax1.send();\n");
      out.write("\n");
      out.write("                    ajax1.onreadystatechange = function () {\n");
      out.write("                        if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                            y.innerHTML = this.responseText;\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                function checkEmail(x, y) {\n");
      out.write("                    ajax2 = new XMLHttpRequest();\n");
      out.write("                    ajax2.open(\"GET\", \"../ReporterController?op=check_email&email=\" + x, true);\n");
      out.write("                    ajax2.send();\n");
      out.write("\n");
      out.write("                    ajax2.onreadystatechange = function () {\n");
      out.write("                        if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                            y.innerHTML = this.responseText;\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                function checkContact(x, y) {\n");
      out.write("                    ajax3 = new XMLHttpRequest();\n");
      out.write("                    ajax3.open(\"GET\", \"../ReporterController?op=check_contact&contact=\" + x, true);\n");
      out.write("                    ajax3.send();\n");
      out.write("\n");
      out.write("                    ajax3.onreadystatechange = function () {\n");
      out.write("                        if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                            y.innerHTML = this.responseText;\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            </script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body id=\"page-top\">\n");
      out.write("    ");

        if (session.getAttribute("admin")==null){
            response.sendRedirect("../login.jsp");
            return;
        }
        
      out.write('\n');
      com.beans.Reporter reporter = null;
      synchronized (session) {
        reporter = (com.beans.Reporter) _jspx_page_context.getAttribute("reporter", PageContext.SESSION_SCOPE);
        if (reporter == null){
          reporter = new com.beans.Reporter();
          _jspx_page_context.setAttribute("reporter", reporter, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("  <!-- Page Wrapper -->\n");
      out.write("  <div id=\"wrapper\">\n");
      out.write("\n");
      out.write("    <!-- Sidebar -->\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "sidebar.jsp", out, false);
      out.write("\n");
      out.write("    <!-- End of Sidebar -->\n");
      out.write("\n");
      out.write("    <!-- Content Wrapper -->\n");
      out.write("    <div id=\"content-wrapper\" class=\"d-flex flex-column\">\n");
      out.write("\n");
      out.write("      <!-- Main Content -->\n");
      out.write("      <div id=\"content\">\n");
      out.write("\n");
      out.write("        <!-- Topbar -->\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "topbar.jsp", out, false);
      out.write("\n");
      out.write("        <!-- End of Topbar -->\n");
      out.write("\n");
      out.write("        <!-- Begin Page Content -->\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col col-md-3\" style=\"position: fixed; right: 0px;\">\n");
      out.write("                    ");
if (request.getParameter("submit") != null) {
      out.write("\n");
      out.write("                    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("reporter"), request);
      out.write("<center>\n");
      out.write("                            <form action=\"../ReporterController?op=add\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("                                <img src=\"\" style=\"width:200px;height: 200px\" border=\"2\" id=\"preview\" class=\"form-control\"/><br/>\n");
      out.write("                                <input type=\"file\" class=\"btn btn-success form-control\" name=\"image\" onchange=\"readURL(this, preview);\"/>\n");
      out.write("                                <br/><br/>\n");
      out.write("                                <input type=\"submit\" class=\"btn btn-primary form-control\" value=\"Add to Database\" name=\"submit\"/>\n");
      out.write("                            </form></center>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"col col-md-9\">\n");
      out.write("                    <form method=\"post\" class=\"form\" onsubmit=\"return matchPwd(password.value, cpassword.value);\">\n");
      out.write("                        <table class=\"table\">\n");
      out.write("                            <tr><th colspan=\"2\"><center><h2>Fill the Reporter Details Here </h2></center></th></tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Enter Reporter Name </td>\n");
      out.write("                                <td><input type=\"text\" name=\"name\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reporter.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                            </tr> \n");
      out.write("                            <tr>\n");
      out.write("                                <td>Enter Reporter DOB </td>\n");
      out.write("                                <td><input type=\"date\" name=\"dob\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reporter.dob}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                            </tr> \n");
      out.write("                            <tr>\n");
      out.write("                                <td>Select Gender  </td><br/>\n");
      out.write("                                <td><input type=\"radio\" name=\"gender\" value=\"Male\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reporter.gender eq \"Male\" ? \"checked\" : \"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/> Male \n");
      out.write("                                    <input type=\"radio\" name=\"gender\" value=\"Female\" ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reporter.gender eq \"Female\" ? \"checked\" : \"\"}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/> Female \n");
      out.write("                                </td>\n");
      out.write("                            </tr> <br/>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Enter Reporter's Contact </td>\n");
      out.write("                                <td><input type=\"text\" name=\"contact\" class=\"form-control\" required=\"required\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reporter.contact}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" maxlength=\"10\" id=\"contact\" onblur=\"checkContact(this.value,sp3);\"/>\n");
      out.write("                                <span id =\"sp3\"></span></td>\n");
      out.write("                            </tr> \n");
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Enter Reporter's Email </td>\n");
      out.write("                                <td><input type=\"email\" name=\"email\" class=\"form-control\" required=\"required\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reporter.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" id=\"email\" onblur=\"checkEmail(this.value,sp1);\" />\n");
      out.write("                                <span id =\"sp1\"> </span></td>\n");
      out.write("                            </tr> \n");
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Enter Reporter's Userid </td>\n");
      out.write("                                <td><input type=\"text\" name=\"userid\" class=\"form-control\" id=\"userid\" required=\"required\" onblur=\"checkUserid(this.value,sp2);\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reporter.userid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                                <span id =\"sp2\"> </span></td>\n");
      out.write("                            </tr> \n");
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Enter Reporter's Password </td>\n");
      out.write("                                <td><input type=\"password\" name=\"password\" id=\"password\" class=\"form-control\" required=\"required\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reporter.password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>Confirm Reporter's Password</td>\n");
      out.write("                                <td><input type=\"password\" name=\"cpassword\" id=\"cpassword\" required=\"required\" class=\"form-control\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${reporter.password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"></td>\n");
      out.write("                            </tr>\n");
      out.write("\n");
      out.write("                            <input type=\"hidden\" name=\"status\" value=\"approved\"/>\n");
      out.write("                        </table>\n");
      out.write("                        <input type=\"submit\" value=\"Save and Next\" name=\"submit\" id =\"submit\" class=\"form-control btn btn-primary\"/>\n");
      out.write("                    </form>                \n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- /.container-fluid -->\n");
      out.write("\n");
      out.write("      </div>\n");
      out.write("      <!-- End of Main Content -->\n");
      out.write("\n");
      out.write("      <!-- Footer -->\n");
      out.write("      ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("      <!-- End of Footer -->\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <!-- End of Content Wrapper -->\n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("  <!-- End of Page Wrapper -->\n");
      out.write("\n");
      out.write("</body>\n");
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
