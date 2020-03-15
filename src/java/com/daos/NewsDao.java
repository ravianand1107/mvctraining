package com.daos;

import com.beans.News;
import com.beans.News_Category;
import com.jdbc.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NewsDao {

    public boolean add(News news, String[] catids) {
        boolean status = false;

        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                String sql = "Insert into news(title, description, image, reporter_id, status, status_text) values (?,?,?,?,?,?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, news.getTitle());
                smt.setString(2, news.getDescription());
                smt.setString(3, news.getImage());
                smt.setInt(4, news.getReporter_id());
                smt.setString(5, news.getStatus());
                smt.setString(6, news.getStatus_text());

                smt.executeUpdate();

                sql = "select id from news order by id desc limit 1";
                smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                int news_id = -1;
                if (rs.next()) {
                    news_id = rs.getInt("id");

                    for (String catid : catids) {
                        sql = "insert into newstype (news_id, cat_id) values(?,?)";
                        smt = con.prepareStatement(sql);
                        smt.setInt(1, news_id);
                        smt.setInt(2, Integer.parseInt(catid));
                        smt.executeUpdate();
                    }
                }
                con.commit();
                status = true;
                smt.close();

            } catch (Exception e) {
                try {
                    con.rollback();
                } catch (Exception ex) {
                    System.out.println("Rollback error");
                }
                System.out.println("Error " + e.getMessage());
            } finally {
                cp.putConnection(con);
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
                String sql = "Delete from news where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);

                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                    System.out.println("News Removed !!");
                }

                cp.putConnection(con);
                smt.close();

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return status;
    }

    public News getById(int id) {
        News news = null;

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from news where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    news = new News();
                    news.setId(rs.getInt("id"));
                    news.setTitle(rs.getString("title"));
                    news.setDescription(rs.getString("description"));
                    news.setImage(rs.getString("image"));
                    news.setReporter_id(rs.getInt("reporter_id"));
                    news.setStatus(rs.getString("status"));
                    news.setStatus_text(rs.getString("status_text"));

                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return news;
    }

    public ArrayList<News> getAllNews() {
        ArrayList<News> newsList = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from news";
                PreparedStatement smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    News news = new News();
                    news = new News();
                    news.setId(rs.getInt("id"));
                    news.setTitle(rs.getString("title"));
                    news.setDescription(rs.getString("description"));
                    news.setImage(rs.getString("image"));
                    news.setReporter_id(rs.getInt("reporter_id"));
                    news.setStatus(rs.getString("status"));
                    news.setStatus_text(rs.getString("status_text"));

                    newsList.add(news);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return newsList;
    }

    public ArrayList<News> getNewsByLimit(int start, int stop) {
        ArrayList<News> newsList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from news limit ?, ?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, start);
                smt.setInt(2, stop);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    News news = new News();
                    news.setId(rs.getInt("id"));
                    news.setTitle(rs.getString("title"));
                    news.setDescription(rs.getString("description"));
                    news.setImage(rs.getString("image"));
                    news.setReporter_id(rs.getInt("reporter_id"));
                    news.setStatus(rs.getString("status"));
                    news.setStatus_text(rs.getString("status_text"));

                    newsList.add(news);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return newsList;
    }
    
    
    public ArrayList<News> getNewsByLimit(int start, int end,int reporter_id) {
        ArrayList<News> AllNews = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from news where reporter_id =? limit ?,?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1,reporter_id);
                ps.setInt(2, start);
                ps.setInt(3, end);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    News news = new News();
                    news.setId(rs.getInt("id"));
                    news.setTitle(rs.getString("title"));
                    news.setDescription(rs.getString("description"));
                    news.setImage(rs.getString("image"));
                    news.setReporter_id(rs.getInt("reporter_id"));
                    news.setStatus(rs.getString("status"));
                    news.setStatus_text(rs.getString("status_text"));

                    AllNews.add(news);
                }
                cp.putConnection(con);
                ps.close();
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        return AllNews;
    }
    
    
    public ArrayList<News> getNewsByLimit(int start, int end,String status) {
        ArrayList<News> AllNews = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from news where status = ? limit ?,?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1,status);
                ps.setInt(2, start);
                ps.setInt(3, end);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    News news = new News();
                    news.setId(rs.getInt("id"));
                    news.setTitle(rs.getString("title"));
                    news.setDescription(rs.getString("description"));
                    news.setImage(rs.getString("image"));
                    news.setReporter_id(rs.getInt("reporter_id"));
                    news.setStatus(rs.getString("status"));
                    news.setStatus_text(rs.getString("status_text"));

                    AllNews.add(news);
                }
                cp.putConnection(con);
                ps.close();
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        return AllNews;
    }

    public int getNewsCount() {
        int total = 0;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();

            if (con != null) {
                String sql = "select count(*) from news";
                PreparedStatement smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();

                if (rs.next()) {
                    total = rs.getInt(1);
                    System.out.println("total records:" + total);
                }

                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
        }
        return total;
    }

    public ArrayList<News> getNewsByCatId(int catid) {
        ArrayList<News> newsList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from news where id in (select news_id from newstype where cat_id =?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, catid);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    News news = new News();
                    news.setId(rs.getInt("id"));
                    news.setTitle(rs.getString("title"));
                    news.setDescription(rs.getString("description"));
                    news.setImage(rs.getString("image"));
                    news.setReporter_id(rs.getInt("reporter_id"));
                    news.setStatus(rs.getString("status"));
                    news.setStatus_text(rs.getString("status_text"));

                    newsList.add(news);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return newsList;
    }

    public ArrayList<News> getNewsByReporterId(int reporterid) {
        ArrayList<News> newsList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from news where reporter_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, reporterid);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    News news = new News();
                    news.setId(rs.getInt("id"));
                    news.setTitle(rs.getString("title"));
                    news.setDescription(rs.getString("description"));
                    news.setImage(rs.getString("image"));
                    news.setReporter_id(rs.getInt("reporter_id"));
                    news.setStatus(rs.getString("status"));
                    news.setStatus_text(rs.getString("status_text"));

                    newsList.add(news);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return newsList;
    }

    public ArrayList<News> getNewsByReporterId(int reporterid, String status) {
        ArrayList<News> newsList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from news where reporter_id=? and status=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, reporterid);
                smt.setString(2, status);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    News news = new News();
                    news.setId(rs.getInt("id"));
                    news.setTitle(rs.getString("title"));
                    news.setDescription(rs.getString("description"));
                    news.setImage(rs.getString("image"));
                    news.setReporter_id(rs.getInt("reporter_id"));
                    news.setStatus(rs.getString("status"));
                    news.setStatus_text(rs.getString("status_text"));

                    newsList.add(news);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return newsList;
    }
    
    
     public ArrayList<News> getNewsByCategory(String cat_id,int reporter_id) {
        ArrayList<News> AllNews = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from news where id in(select news_id from newstype where cat_id=? ) and reporter_id=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, cat_id);
                ps.setInt(2, reporter_id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    News news = new News();
                    news.setTitle(rs.getString("title"));
                    news.setDescription(rs.getString("description"));
                    news.setImage(rs.getString("image"));
                    news.setReporter_id(rs.getInt("reporter_id"));
                    news.setStatus(rs.getString("status"));
                    news.setStatus_text(rs.getString("status_text"));

                    AllNews.add(news);
                }
                cp.putConnection(con);
                ps.close();
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        return AllNews;
    }
    
    
     public ArrayList<News> getNewsByCategory(String cat_id,String status) {
        ArrayList<News> AllNews = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from news where id in(select news_id from newstype where cat_id=? ) and status=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, cat_id);
                ps.setString(2, status);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    News news = new News();
                    news.setTitle(rs.getString("title"));
                    news.setDescription(rs.getString("description"));
                    news.setImage(rs.getString("image"));
                    news.setReporter_id(rs.getInt("reporter_id"));
                    news.setStatus(rs.getString("status"));
                    news.setStatus_text(rs.getString("status_text"));

                    AllNews.add(news);
                }
                cp.putConnection(con);
                ps.close();
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        return AllNews;
    }
     
       public ArrayList<News> getNewsByCategory(String cat_id) {
        ArrayList<News> AllNews = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from news where id in(select news_id from newstype where cat_id=? )";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, cat_id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    News news = new News();
                    news.setTitle(rs.getString("title"));
                    news.setDescription(rs.getString("description"));
                    news.setImage(rs.getString("image"));
                    news.setReporter_id(rs.getInt("reporter_id"));
                    news.setStatus(rs.getString("status"));
                    news.setStatus_text(rs.getString("status_text"));

                    AllNews.add(news);
                }
                cp.putConnection(con);
                ps.close();
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        return AllNews;
    }
    
    public ArrayList<News_Category> getNewsCategory() {
        ArrayList<News_Category> AllNewsCategory = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from news_category";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    News_Category news_cat = new News_Category();
                    news_cat.setId(rs.getInt("id"));
                    news_cat.setName(rs.getString("name"));

                    AllNewsCategory.add(news_cat);
                }
                cp.putConnection(con);
                ps.close();
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }

        return AllNewsCategory;
    }

    public int getNewsCountByCategory(int catid) {
        int total = 0;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select count(*) from newstype where cat_id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, catid);
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

    public boolean update(News news, String[] catids) {
        boolean status = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();

        if (con != null) {
            try {
                con.setAutoCommit(false);

                String sql = "update news set title=?, description=?, image=? where id = ?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, news.getTitle());
                smt.setString(2, news.getDescription());
                smt.setString(3, news.getImage());
                smt.setInt(4, news.getId());
                smt.executeUpdate();

                sql = "delete from newstype where news_id=?";
                smt = con.prepareStatement(sql);
                smt.setInt(1, news.getId());
                smt.executeUpdate();

                for (String catid : catids) {
                    sql = "insert into newstype (news_id,cat_id) values(?,?)";
                    smt = con.prepareStatement(sql);
                    smt.setInt(1, news.getId());
                    smt.setInt(2, Integer.parseInt(catid));
                    smt.executeUpdate();
                }

                con.commit();
                status = true;
                smt.close();

            } catch (Exception e) {
                try {
                    con.rollback();
                } catch (Exception ex) {
                    System.out.println("Rollback error");
                }
                System.out.println("Error " + e.getMessage());
            } finally {
                cp.putConnection(con);
            }
        }

        return status;
    }

    public boolean updateNewsStatus(News news, String status, String statusText) {
        boolean sts = false;
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();

        if (con != null) {
            try {
                String sql = "update news set status=?, status_text=? where id = ?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, status);
                smt.setString(2, statusText);
                smt.setInt(3, news.getId());
                smt.executeUpdate();
                cp.putConnection(con);
                sts = true;
                smt.close();

            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }
        return sts;
    }
    
    
    public ArrayList<News> getNewsStatusByReporterID(int reporter_id, String status) {
        ArrayList<News> newsList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from news where reporter_id=? and status= ?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, reporter_id);
                smt.setString(2, status);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    News news = new News();
                    news.setId(rs.getInt("id"));
                    news.setTitle(rs.getString("title"));
                    news.setDescription(rs.getString("description"));
                    news.setImage(rs.getString("image"));
                    news.setReporter_id(rs.getInt("reporter_id"));
                    news.setStatus(rs.getString("status"));
                    news.setStatus_text(rs.getString("status_text"));

                    newsList.add(news);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return newsList;
    }

}
