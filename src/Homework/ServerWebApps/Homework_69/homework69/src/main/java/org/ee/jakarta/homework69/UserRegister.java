package org.ee.jakarta.homework69;

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

@WebServlet("/register")
public class UserRegister extends HttpServlet {
    private static final String query = "INSERT INTO user_data (user_secondname, user_firstname, user_fathername, user_city, user_phone, user_email) VALUES (?, ?, ?, ?, ?, ?)";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String userSecondName = req.getParameter("userSecondName");
        String userFirstName = req.getParameter("userFirstName");
        String userFatherName = req.getParameter("userFatherName");
        String userCity = req.getParameter("userCity");
        long userPhone = Long.parseLong(req.getParameter("userPhone"));
        String userEmail = req.getParameter("userEmail");
        try(Connection connection = DriverManager.getConnection("jdbc:mysql:///user_dates", "root", "haRRy1423");
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, userSecondName);
            preparedStatement.setString(2, userFirstName);
            preparedStatement.setString(3, userFatherName);
            preparedStatement.setString(4, userCity);
            preparedStatement.setLong(5, userPhone);
            preparedStatement.setString(6, userEmail);
            int rows = preparedStatement.executeUpdate();
            out.println("<html><head><link rel='stylesheet' href='css/style.css'></head><body><div class='userAdded'>");
            if (rows == 1) {
                out.println("<h2>Пользователь зарегистрирован успешно</h2>");
            } else {
                out.println("<h2>Ошибка регистрации</h2>");
            }

        } catch (SQLException e){
            e.printStackTrace();
            out.println("<h2>" + e.getMessage() + "</h2>");
        }
        out.println("<br><a href='index.html'>Главная страница</a>");
        out.println("<br><a href='user'>Список пользователей</a>");
        out.println("</div></body></html>");
    }
}
