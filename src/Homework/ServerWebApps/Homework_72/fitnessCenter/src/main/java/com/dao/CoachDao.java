package com.dao;

import com.entity.Coach;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CoachDao {
    private Connection con;

    public CoachDao(Connection con) {
        this.con = con;
    }

    public boolean addCoach(String coach) {
        boolean flag = false;
        try{
            String sql = "INSERT INTO coach (coach_name) VALUES(?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, coach);
            int row = ps.executeUpdate();
            if (row == 1) {
                flag = true;
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public List<Coach> getAllCoach() {
        List<Coach> list = new ArrayList<Coach>();
        Coach coach = null;
        try{
            String sql = "SELECT * FROM coach";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                coach = new Coach();
                coach.setId(rs.getInt(1));
                coach.setCoachName(rs.getString(2));
                list.add(coach);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
