package com.dao;


import com.db.DBConnect;
import com.entity.Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDao {
    private Connection conn;

    public AppointmentDao(Connection conn) {
        this.conn = conn;
    }

    public boolean addAppointment(Appointment appointment) {
        boolean flag = false;
        try{
            String sql = "INSERT INTO appointment(client_id, fullname, gender, age, appoint_date, email, phone, likes, worker_id, address, status) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, appointment.getClientId());
            ps.setString(2, appointment.getFullName());
            ps.setString(3, appointment.getGender());
            ps.setString(4, appointment.getAge());
            ps.setString(5, appointment.getAppointDate());
            ps.setString(6, appointment.getEmail());
            ps.setString(7, appointment.getPhone());
            ps.setString(8, appointment.getLikes());
            ps.setInt(9, appointment.getWorkerId());
            ps.setString(10, appointment.getAddress());
            ps.setString(11, appointment.getStatus());
            int row = ps.executeUpdate();
            if (row == 1) {
                flag = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public List<Appointment> getAllAppointmentsByLoginClientId(int clientId) {
        List<Appointment> appointments = new ArrayList<Appointment>();
        Appointment app = null;
        try{
            String sql = "SELECT * FROM appointment WHERE client_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, clientId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                app = new Appointment();
                app.setId(rs.getInt(1));
                app.setClientId(rs.getInt(2));
                app.setFullName(rs.getString(3));
                app.setGender(rs.getString(4));
                app.setAge(rs.getString(5));
                app.setAppointDate(rs.getString(6));
                app.setEmail(rs.getString(7));
                app.setPhone(rs.getString(8));
                app.setLikes(rs.getString(9));
                app.setWorkerId(rs.getInt(10));
                app.setAddress(rs.getString(11));
                app.setStatus(rs.getString(12));
                appointments.add(app);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return appointments;
    }

    public List<Appointment> getAllAppointmentsByWorkerLogin(int workerId) {
        List<Appointment> appointments = new ArrayList<Appointment>();
        Appointment app = null;
        try{
            String sql = "SELECT * FROM appointment WHERE worker_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, workerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                app = new Appointment();
                app.setId(rs.getInt(1));
                app.setClientId(rs.getInt(2));
                app.setFullName(rs.getString(3));
                app.setGender(rs.getString(4));
                app.setAge(rs.getString(5));
                app.setAppointDate(rs.getString(6));
                app.setEmail(rs.getString(7));
                app.setPhone(rs.getString(8));
                app.setLikes(rs.getString(9));
                app.setWorkerId(rs.getInt(10));
                app.setAddress(rs.getString(11));
                app.setStatus(rs.getString(12));
                appointments.add(app);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return appointments;
    }

    public Appointment getAppointmentById(int id) {
        Appointment app = null;
        try{
            String sql = "SELECT * FROM appointment WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                app = new Appointment();
                app.setId(rs.getInt(1));
                app.setClientId(rs.getInt(2));
                app.setFullName(rs.getString(3));
                app.setGender(rs.getString(4));
                app.setAge(rs.getString(5));
                app.setAppointDate(rs.getString(6));
                app.setEmail(rs.getString(7));
                app.setPhone(rs.getString(8));
                app.setLikes(rs.getString(9));
                app.setWorkerId(rs.getInt(10));
                app.setAddress(rs.getString(11));
                app.setStatus(rs.getString(12));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return app;
    }

    public boolean updateCommentStatus(int id, int workerId, String comment) {
        boolean flag = false;
            try{
                String sql = "UPDATE appointment SET status = ? WHERE id = ? AND worker_id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, comment);
                ps.setInt(2, id);
                ps.setInt(3, workerId);
                int row = ps.executeUpdate();
                if (row == 1) {
                    flag = true;
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        return flag;
    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<Appointment>();
        Appointment app = null;
        try{
            String sql = "SELECT * FROM appointment ORDER BY id DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                app = new Appointment();
                app.setId(rs.getInt(1));
                app.setClientId(rs.getInt(2));
                app.setFullName(rs.getString(3));
                app.setGender(rs.getString(4));
                app.setAge(rs.getString(5));
                app.setAppointDate(rs.getString(6));
                app.setEmail(rs.getString(7));
                app.setPhone(rs.getString(8));
                app.setLikes(rs.getString(9));
                app.setWorkerId(rs.getInt(10));
                app.setAddress(rs.getString(11));
                app.setStatus(rs.getString(12));
                appointments.add(app);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return appointments;
    }
}
