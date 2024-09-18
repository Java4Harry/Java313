package org.ee.jakarta.homework_70;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private static final String query = "UPDATE user_data SET user_secondname=?,user_firstname=?,user_fathername=?, user_city=?, user_phone=?, user_email=? WHERE id=?";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        String userSecondName = req.getParameter("userSecondName");
        String userFirstName = req.getParameter("userFirstName");
        String userFatherName = req.getParameter("userFatherName");
        String userCity = req.getParameter("userCity");
        long userPhone = Long.parseLong(req.getParameter("userPhone"));
        String userEmail = req.getParameter("userEmail");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        out.println("<html><head><link rel='stylesheet' href='css/style.css'></head><body><div class='userTable'>");
        try(Connection connection = DriverManager.getConnection("jdbc:mysql:///user_dates", "root", "haRRy1423");
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, userSecondName);
            preparedStatement.setString(2, userFirstName);
            preparedStatement.setString(3, userFatherName);
            preparedStatement.setString(4, userCity);
            preparedStatement.setLong(5, userPhone);
            preparedStatement.setString(6, userEmail);
            preparedStatement.setInt(7, id);
            int row = preparedStatement.executeUpdate();
            if(row == 1) {
                out.println("<h2>Изменения в пользователя внесены!</h2>");
            } else {
                out.println("<h2>Возникла ошибка! Изменения не внесены!</h2>");
            }
        } catch (
                SQLException e){
            e.printStackTrace();
            out.println("<h2>" + e.getMessage() + "</h2>");
        }
        out.println("<br><a href='index.html'>Главная страница</a>");
        out.println("<br><a href='user'>Список пользователей</a>");
        out.println("</div></body></html>");

    }
}
