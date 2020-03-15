<%@page import="java.net.ConnectException"%>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload" %>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="java.util.*, java.io.*" %>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.io.File"%>
<%@ page import="java.sql.*"%> 
<%@ page contentType="text/html;charset=UTF-8" %>


<%
    Connection con = null;
    PreparedStatement smt = null;

    List<String> checkboxValues = new ArrayList<String>();

    try {

        String ImageFile = "";
        String itemName = "";
        String title = "";
        String description = "";
        String cat_id = "";
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
        } else {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List items = null;
            try {
                items = upload.parseRequest(request);
            } catch (FileUploadException e) {
                e.getMessage();
            }

            Iterator itr = items.iterator();
            while (itr.hasNext()) {
                FileItem item = (FileItem) itr.next();
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    String value = item.getString();
                    if (name.equals("title")) {
                        title = value;
                    } else if (name.equals("description")) {
                        description = value;
                    } else if (name.equals("category_id")) {
                        checkboxValues.add(value);
                    }
                } else {
                    try {
                        itemName = item.getName();
                        File savedFile = new File(config.getServletContext().getRealPath("/") + "\\media\\" + itemName);
                        item.write(savedFile);
                    } catch (Exception e) {
                        out.println("Error  " + e.getMessage());
                    }
                }
            }

            System.out.println("Categories  : " + cat_id);
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "ravi");
            con.setAutoCommit(false);

            String sql = "insert into news(title,description,image)values(?,?,?)";
            smt = con.prepareStatement(sql);
            smt.setString(1, title);
            smt.setString(2, description);
            smt.setString(3, itemName);

            int n = smt.executeUpdate();

            sql = "select id from news order by id desc limit 1 ";
            smt = con.prepareStatement(sql);
            ResultSet rs = smt.executeQuery();
            String news_id = "";
            if (rs.next()) {
                news_id = rs.getString("id");
            }

            for (String catid : checkboxValues) {
                sql = "insert into newstype (cat_id,news_id) values(?,?)";
                smt = con.prepareStatement(sql);
                smt.setString(1, catid);
                smt.setString(2, news_id);
                smt.executeUpdate();
                System.out.println("Category : " + catid);
            }

            out.println("Image Uploaded...");

            con.commit();

        }
    } catch (Exception e) {
        con.rollback();
        out.println("Error : " + e.getMessage());
    } finally {
        con.close();
        smt.close();
    }

%>


