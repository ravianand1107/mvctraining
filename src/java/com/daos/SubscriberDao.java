/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daos;

import com.beans.Subscribers;
import com.jdbc.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ravi
 */
public class SubscriberDao {
    
    public boolean add(Subscribers subscribers) {
        boolean status = false;

        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
        if (con != null) {
            try {
                con.setAutoCommit(false);
                String sql = "Insert into subscribers(name,email) values (?,?)";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, subscribers.getName());
                smt.setString(2, subscribers.getEmail());
                

                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                    System.out.println("Record Inserted!!!");
                }
                cp.putConnection(con);
                smt.close();

            }
        catch (Exception e) {
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
                String sql = "Delete from subscribers where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);

                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                    System.out.println("Subscriber Removed !!");
                }

                cp.putConnection(con);
                smt.close();

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return status;
    }

    public Subscribers getById(int id) {
        Subscribers subscribers = null;

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from subscribers where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    subscribers = new Subscribers();
                    subscribers.setId(rs.getInt("id"));
                    subscribers.setName(rs.getString("name"));
                    subscribers.setEmail(rs.getString("email"));
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return subscribers;
    }

    public ArrayList<Subscribers> getAllSubscribers() {
        ArrayList<Subscribers> subscribersList = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from subscribers";
                PreparedStatement smt = con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Subscribers subscribers = new Subscribers();
                    subscribers = new Subscribers();
                    subscribers.setId(rs.getInt("id"));
                    subscribers.setName(rs.getString("name"));
                    subscribers.setEmail(rs.getString("email"));
                  
                    subscribersList.add(subscribers);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return subscribersList;
    }

    public ArrayList<Subscribers> getSubscribersByLimit(int start, int stop) {
        ArrayList<Subscribers> subscribersList = new ArrayList();
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from subscribers limit ?, ?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, start);
                smt.setInt(2, stop);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Subscribers subscribers = new Subscribers();
                    subscribers.setId(rs.getInt("id"));
                    subscribers.setName(rs.getString("name"));
                    subscribers.setEmail(rs.getString("email"));
                   
                    subscribersList.add(subscribers);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return subscribersList;
    }

    public int getSubscribersCount() {
        int total = 0;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();

            if (con != null) {
                String sql = "select count(*) from subscribers";
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


     public boolean update(Subscribers subscribers) {
        boolean status = false;
        
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "update subscribers set name=?,email=? where id=?";
                PreparedStatement smt = con.prepareStatement(sql);
                smt.setString(1, subscribers.getName());
                smt.setString(2, subscribers.getEmail());
                smt.setInt(3, subscribers.getId());
                int n = smt.executeUpdate();
                System.out.println("n:"+n);
                if (n > 0) {
                    //System.out.println("Subscribers:"+subscribers);
                    status = true;
                    System.out.println("Subscriber's Record Updated!!!");
                }
                cp.putConnection(con);
                smt.close();

            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return status;
    }

}
