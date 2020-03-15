package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.beans.Reporter;
import com.daos.ReporterDao;
import com.utilities.FileUploader;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ReporterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String op = request.getParameter("op");
        
        if (op != null && op.equalsIgnoreCase("check_userid")) {
            String userid = request.getParameter("userid");
            ReporterDao rd = new ReporterDao();
            if (userid == null || userid.equals("")) {
                out.println("<font size='4'>Please provide Userid</font>");
                return;
            }
            if (rd.isUserIdExist(userid)) {
                out.println("<font color='red' size='4'>Sorry This Userid already exist!!!</font>");
            } else {
                out.println("<font color='blue' size='4'>Congratulations! This Userid is available!!!</font>");
            }
        }
        
        if (op != null && op.equalsIgnoreCase("check_email")) {
            String email = request.getParameter("email");
            ReporterDao rd = new ReporterDao();
            if (email == null || email.equals("")) {
                out.println("<font size='4'>Please provide Email</font>");
                return;
            }
            if (rd.isEmailExist(email)) {
                out.println("<font color='red' size='4'>Sorry This Email already exist!!!</font>");
            } else {
                out.println("<font color='blue' size='4'>Congratulations! This Email is not registered!!!</font>");
            }
        }
        
        if (op != null && op.equalsIgnoreCase("check_contact")) {
            String contact = request.getParameter("contact");
            ReporterDao rd = new ReporterDao();
            if (contact == null || contact.equals("")) {
                out.println("<font size='4'>Please provide Contact no</font>");
                return;
            }
            if (rd.isContactExist(contact)) {
                out.println("<font color='red' size='4'>Sorry This Contact no already exist!!!</font>");
            } else {
                out.println("<font color='blue' size='4'>Congratulations! this Contact no is not registered!!!</font>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String op = request.getParameter("op");

        if (op != null && op.equalsIgnoreCase("add")) {
            HttpSession session = request.getSession();
            Reporter reporter = (Reporter) session.getAttribute("reporter");
            ReporterDao rd = new ReporterDao();

            String ImagePath = "";
            ImagePath = FileUploader.getUploadedPath(getServletContext(), "media/reporter", request);
            reporter.setImage(ImagePath);

            if (rd.add(reporter)) {
                session.removeAttribute("reporter");
                out.println("Reporter Added Successfully !");
            }
        }
        
        if (op != null && op.equalsIgnoreCase("update")) {
            System.out.println("Request Found......");
                 ReporterDao pd = new ReporterDao();
                HttpSession session = request.getSession();
                Reporter reporter = (Reporter) session.getAttribute("reporter1");
                System.out.println("Beans received reporter1 " + reporter);
           
            try {
                //check the enctype of the incomming request -
                boolean isMultipart = ServletFileUpload.isMultipartContent(request);
                //String encodedPassword = "";
                String msg="";
                if (isMultipart) {
                    msg = FileUploader.getUploadedPath(getServletContext(), "media/reporter", request);
                    System.out.println("Message:"+msg);
                 }
//JDBC Code
                
                // encodedPassword = Base64.getEncoder().encodeToString(person.getPassword().getBytes("UTF-8"));
                //person.setPassword(encodedPassword);
                reporter.setImage(msg);
                if (pd.update(reporter)) {
                    System.out.println("sdlfnkfnlk");
                    session.removeAttribute("reporter1");
                    response.sendRedirect("reporter/dashboard.jsp");
                }

            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }

        }
    }

}
