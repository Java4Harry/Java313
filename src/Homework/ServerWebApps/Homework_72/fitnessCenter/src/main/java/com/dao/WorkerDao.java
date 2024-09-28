package com.dao;

import com.entity.Worker;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class WorkerDao {
    private Connection conn;

    public WorkerDao(Connection conn) {
        this.conn = conn;
    }

    public boolean registerWorker(Worker worker) {
        boolean flag = false;
        try{
            String sql = "INSERT INTO worker(full_name, dob, qualification, section, email, phone, password) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, worker.getFullName());
            ps.setString(2, worker.getDob());
            ps.setString(3, worker.getQualification());
            ps.setString(4, worker.getSection());
            ps.setString(5, worker.getEmail());
            ps.setString(6, worker.getPhone());
            ps.setString(7, worker.getPassword());
            int row = ps.executeUpdate();
            if (row == 1) {
                flag = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
