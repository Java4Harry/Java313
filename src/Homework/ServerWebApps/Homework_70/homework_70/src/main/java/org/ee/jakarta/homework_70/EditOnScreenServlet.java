package org.ee.jakarta.homework_70;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/editOnScreen")
public class EditOnScreenServlet extends HttpServlet {
    private static final String query = "SELECT user_secondname,user_firstname,user_fathername, user_city, user_phone, user_email FROM user_data WHERE id = ?";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        out.println("<html><head><link rel='stylesheet' href='css/style.css'></head><body><div class='userTable'>");
        try(Connection connection = DriverManager.getConnection("jdbc:mysql:///user_dates", "root", "haRRy1423");
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            out.println("<form action='edit?id=" + id + "' method='post'>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td>Фамилия</td>");
            out.println("<td><input type='text' name='userSecondName' value='" +  resultSet.getString(1) + "'</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Имя</td>");
            out.println("<td><input type='text' name='userFirstName' value='" +  resultSet.getString(2) + "'</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Отчество</td>");
            out.println("<td><input type='text' name='userFatherName' value='" +  resultSet.getString(3) + "'</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Город проживания</td>");
            out.println("<td><input type='text' name='userCity' value='" +  resultSet.getString(4) + "'</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Телефон</td>");
            out.println("<td><input type='text' name='userPhone' value='" +  resultSet.getLong(5) + "'</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Электронная почта</td>");
            out.println("<td><input type='text' name='userEmail' value='" +  resultSet.getString(6) + "'</td>");
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td><input type='submit' value='изменить' class='submit'></td>");
            out.println("<td><input type='reset' value='отменить' class='reset'></td>");
            out.println("</tr>");

            out.println("</table>");
            out.println("</form>");
        } catch (
                SQLException e){
            e.printStackTrace();
            out.println("<h2>" + e.getMessage() + "</h2>");
        }
        out.println("<br><a href='index.html'>Главная</a>");
        out.println("</div></body></html>");
    }
}
