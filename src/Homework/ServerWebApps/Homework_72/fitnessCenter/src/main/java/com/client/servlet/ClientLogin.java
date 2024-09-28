package com.client.servlet;

import com.dao.ClientDao;
import com.db.DBConnect;
import com.entity.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/clientLogin")
public class ClientLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        ClientDao clientDao = new ClientDao(DBConnect.getConn());
        Client client = clientDao.login(email, password);
        if (client != null) {
            session.setAttribute("clientObj", client);
            resp.sendRedirect("index.jsp");
        } else{
            session.setAttribute("errorMsg", "Некорректный email или пароль");
            resp.sendRedirect("client_login.jsp");
        }
    }
}
