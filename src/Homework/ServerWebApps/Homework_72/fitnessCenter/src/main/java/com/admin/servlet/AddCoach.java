package com.admin.servlet;

import com.dao.CoachDao;
import com.db.DBConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/addCoach")
public class AddCoach extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String coachName = req.getParameter("coachname");
        CoachDao dao = new CoachDao(DBConnect.getConn());
        boolean f = dao.addCoach(coachName);
        HttpSession session = req.getSession();
        if (f){
            session.setAttribute("succMsg", "Инструктор добавлен");
            resp.sendRedirect("admin/index.jsp");
        } else {
            session.setAttribute("errorMsg", "Ошибка сервера");
            resp.sendRedirect("admin/index.jsp");
        }
    }
}
