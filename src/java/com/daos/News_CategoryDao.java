
package com.daos;

import java.sql.*;
import com.beans.News_Category;
import com.jdbc.ConnectionPool;
import java.util.ArrayList;


public class News_CategoryDao {
     public boolean add(News_Category newsCategory) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();

        if (con != null) {
            try {
                String sql = "Insert into news_category(name) values(?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, newsCategory.getName());
                smt.executeUpdate();

                status = true;
                cp.putConnection(con);
                smt.close();

            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }

        }
        return status;
    }
     
     
     public boolean removeById(int id) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "Delete from news_category where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);

                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                    System.out.println("Category Removed !!");
                }

                cp.putConnection(con);
                smt.close();

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return status;
    }

     
      public News_Category getById(int id) {
        News_Category newsCategory = null;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from news_category where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    newsCategory = new News_Category();
                    newsCategory.setId(rs.getInt("id"));
                    newsCategory.setName(rs.getString("name"));
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return newsCategory;
    }
      
      
       public ArrayList<News_Category> getAllNewsCategory() {
        ArrayList<News_Category> newsCategoryList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from news_category";
                PreparedStatement smt = con.prepareStatement(sql);

                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    News_Category newsCategory = new News_Category();
                    newsCategory.setId(rs.getInt("id"));
                    newsCategory.setName(rs.getString("name"));
                    newsCategoryList.add(newsCategory);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return newsCategoryList;
    }
       
       
       public ArrayList<News_Category> getNewsCategoryByLimit(int start, int stop) {
        ArrayList<News_Category> newsCategoryList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from news_category limit ?, ?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, start);
                smt.setInt(2, stop);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    News_Category newsCategory = new News_Category();
                    newsCategory.setId(rs.getInt("id"));
                    newsCategory.setName(rs.getString("name"));
                    newsCategoryList.add(newsCategory);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return newsCategoryList;
    }

    public int getNewsCategoryCount() {
        int total = 0;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select count(*) from news_category";
                PreparedStatement smt = con.prepareStatement(sql);

                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    total = rs.getInt(1);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return total;

    }

    public boolean update(News_Category newsCategory) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();

        if (con != null) {
            try {
                String sql = "update news_category set name=?  where id = ?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, newsCategory.getName());
                smt.setInt(2, newsCategory.getId());
                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                }
                smt.close();

            } catch (Exception e) {

                System.out.println("Error " + e.getMessage());
            }

        }

        return status;
    }

   
}
