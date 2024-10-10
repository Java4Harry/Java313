package com.dao;

import com.entity.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientDao {
    private Connection conn;

    public ClientDao(Connection conn) {
        this.conn = conn;
    }

    public boolean register(Client c) {
        boolean flag = false;
        try{
            String sql = "INSERT INTO client_data(full_name, email, password) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,c.getName());
            ps.setString(2,c.getEmail());
            ps.setString(3,c.getPassword());
            int row = ps.executeUpdate();
            if(row == 1) {
                flag = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public Client login(String email, String password) {
        Client client = null;
        try {
            String sql = "SELECT * FROM client_data WHERE email = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                client = new Client();
                client.setId(rs.getInt(1));
                client.setName(rs.getString(2));
                client.setEmail(rs.getString(3));
                client.setPassword(rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client;
    }

    public boolean checkOldPassword(int clientId, String oldPassword) {
        boolean flag = false;
            try{
                String sql = "SELECT * FROM client_data WHERE id = ? AND password = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, clientId);
                ps.setString(2, oldPassword);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    flag = true;
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        return flag;
    }

    public boolean changePassword(int clientId, String newPassword) {
        boolean flag = false;
        try{
            String sql = "UPDATE client_data SET password = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setInt(2, clientId);
            int row = ps.executeUpdate();
            if(row == 1) {
                flag = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
