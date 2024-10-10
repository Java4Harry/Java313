package com.client.servlet;

import com.dao.ClientDao;
import com.db.DBConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/clientChangePassword")
public class ChangePassword extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cid = Integer.parseInt(req.getParameter("cid"));
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");

        ClientDao clientDao = new ClientDao(DBConnect.getConn());
        HttpSession session = req.getSession();
        if(clientDao.checkOldPassword(cid, oldPassword)) {
            if(clientDao.changePassword(cid, newPassword)) {
                session.setAttribute("succMsg", "Пароль изменен успешно");
                resp.sendRedirect("change_password.jsp");
            } else{
                session.setAttribute("error", "Ошибка сервера");
                resp.sendRedirect("change_password.jsp");
            }

        } else{
            session.setAttribute("error", "Старый пароль не верный");
            resp.sendRedirect("change_password.jsp");
        }
    }
}
