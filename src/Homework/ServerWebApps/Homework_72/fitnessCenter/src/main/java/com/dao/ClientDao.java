package com.dao;

import com.entity.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
