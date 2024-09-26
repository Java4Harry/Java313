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

@WebServlet("/client_register")
public class ClientRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String fullName = req.getParameter("fullname");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            Client client = new Client(fullName, email, password);
            ClientDao clientDao = new ClientDao(DBConnect.getConn());
            HttpSession session = req.getSession();
            boolean f = clientDao.register(client);
            if (f) {
                session.setAttribute("sucMsg", "Регистрация прошла успешно!");
                resp.sendRedirect("/signup.jsp");
            } else {
                session.setAttribute("errorMsg", "Ошибка регистрации!");
                resp.sendRedirect("/signup.jsp");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
