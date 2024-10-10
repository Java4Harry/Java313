package com.dao;

import com.entity.Worker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public List<Worker> getAllWorkers() {
        List<Worker> workers = new ArrayList<Worker>();
        Worker worker = null;
        try{
            String sql = "SELECT * FROM worker ORDER BY id DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                worker = new Worker();
                worker.setId(rs.getInt(1));
                worker.setFullName(rs.getString(2));
                worker.setDob(rs.getString(3));
                worker.setQualification(rs.getString(4));
                worker.setSection(rs.getString(5));
                worker.setEmail(rs.getString(6));
                worker.setPhone(rs.getString(7));
                worker.setPassword(rs.getString(8));
                workers.add(worker);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return workers;
    }

    public Worker getWorkersById(int id) {
        Worker worker = null;
        try{
            String sql = "SELECT * FROM worker WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                worker = new Worker();
                worker.setId(rs.getInt(1));
                worker.setFullName(rs.getString(2));
                worker.setDob(rs.getString(3));
                worker.setQualification(rs.getString(4));
                worker.setSection(rs.getString(5));
                worker.setEmail(rs.getString(6));
                worker.setPhone(rs.getString(7));
                worker.setPassword(rs.getString(8));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return worker;
    }

    public boolean updateWorker(Worker worker) {
        boolean flag = false;
        try{
            String sql = "UPDATE worker SET full_name=?, dob=?, qualification=?, section=?, email=?, phone=?, password=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, worker.getFullName());
            ps.setString(2, worker.getDob());
            ps.setString(3, worker.getQualification());
            ps.setString(4, worker.getSection());
            ps.setString(5, worker.getEmail());
            ps.setString(6, worker.getPhone());
            ps.setString(7, worker.getPassword());
            ps.setInt(8, worker.getId());
            int row = ps.executeUpdate();
            if (row == 1) {
                flag = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public boolean deleteWorker(int id) {
        boolean flag = false;
        try{
            String sql = "DELETE FROM worker WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int row = ps.executeUpdate();
            if (row == 1) {
                flag = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public Worker login(String email, String password) {
        Worker worker = null;
        try{
            String sql = "SELECT * FROM worker WHERE email=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                worker = new Worker();
                worker.setId(rs.getInt(1));
                worker.setFullName(rs.getString(2));
                worker.setDob(rs.getString(3));
                worker.setQualification(rs.getString(4));
                worker.setSection(rs.getString(5));
                worker.setEmail(rs.getString(6));
                worker.setPhone(rs.getString(7));
                worker.setPassword(rs.getString(8));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return worker;
    }

    public int countWorkers(){
        int i = 0;
        try{
            String sql = "SELECT * FROM worker";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                i++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    public int countAppointments(){
        int i = 0;
        try{
            String sql = "SELECT * FROM appointment";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                i++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    public int countClients(){
        int i = 0;
        try{
            String sql = "SELECT * FROM client_data";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                i++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    public int countCoach(){
        int i = 0;
        try{
            String sql = "SELECT * FROM coach";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                i++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }

    public int countAppointmentWorkerId(int cid){
        int i = 0;
        try{
            String sql = "SELECT * FROM appointment WHERE worker_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                i++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }
}
