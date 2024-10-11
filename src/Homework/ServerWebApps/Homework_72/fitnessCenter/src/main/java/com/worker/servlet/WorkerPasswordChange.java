package com.worker.servlet;

import com.dao.ClientDao;
import com.dao.WorkerDao;
import com.db.DBConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/workerChangePassword")
public class WorkerPasswordChange extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int wid = Integer.parseInt(req.getParameter("wid"));
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");

        WorkerDao dao = new WorkerDao(DBConnect.getConn());
        HttpSession session = req.getSession();
        if(dao.checkOldPassword(wid, oldPassword)) {
            if(dao.changePassword(wid, newPassword)) {
                session.setAttribute("succMsg", "Пароль изменен успешно");
                resp.sendRedirect("worker/edit_profile.jsp");
            } else{
                session.setAttribute("error", "Ошибка сервера");
                resp.sendRedirect("worker/edit_profile.jsp");
            }

        } else{
            session.setAttribute("errorMsg", "Старый пароль не верный");
            resp.sendRedirect("worker/edit_profile.jsp");
        }
    }
}
