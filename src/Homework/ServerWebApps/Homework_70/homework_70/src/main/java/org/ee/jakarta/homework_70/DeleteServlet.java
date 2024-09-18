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

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private static final String query = "DELETE FROM user_data WHERE id=?";
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
            int row = preparedStatement.executeUpdate();
            if(row == 1) {
                out.println("<h2>Пользователь удален!</h2>");
            } else {
                out.println("<h2>Возникла ошибка! Пользователь не удален!</h2>");
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
