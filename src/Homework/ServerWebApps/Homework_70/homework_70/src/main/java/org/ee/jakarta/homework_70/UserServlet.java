package org.ee.jakarta.homework_70;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private static final String query = "SELECT * FROM user_data";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection("jdbc:mysql:///user_dates", "root", "haRRy1423");
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            out.println("<html><head><link rel='stylesheet' href='css/style.css'></head><body><div class='userTable'>");
            out.println("<table><tr>");
            out.println("<th>ID</th>");
            out.println("<th>Фамилия</th>");
            out.println("<th>Имя</th>");
            out.println("<th>Отчество</th>");
            out.println("<th>Город проживания</th>");
            out.println("<th>Телефон</th>");
            out.println("<th>Электронная почта</th>");
            out.println("<th>Редактирование</th>");
            out.println("<th>Удаление</th>");
            out.println("</tr>");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                out.println("<tr>");
                out.println("<td>" + resultSet.getInt(1) + "</td>");
                out.println("<td>" + resultSet.getString(2) + "</td>");
                out.println("<td>" + resultSet.getString(3) + "</td>");
                out.println("<td>" + resultSet.getString(4) + "</td>");
                out.println("<td>" + resultSet.getString(5) + "</td>");
                out.println("<td>" + resultSet.getLong(6) + "</td>");
                out.println("<td>" + resultSet.getString(7) + "</td>");
                out.println("<td><a href='editOnScreen?id=" + resultSet.getInt(1) + "'>Редактировать</a></td>");
                out.println("<td><a href='delete?id=" + resultSet.getInt(1) + "'>Удалить</a></td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (SQLException e){
            e.printStackTrace();
            out.println("<h2>" + e.getMessage() + "</h2>");
        }
        out.println("<br><a href='index.html'>Главная страница</a>");
        out.println("</div></body></html>");
    }
}
