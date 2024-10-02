package com.worker.servlet;

import com.dao.WorkerDao;
import com.db.DBConnect;
import com.entity.Worker;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/coachLogin")
public class WorkerLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        WorkerDao workerDao = new WorkerDao(DBConnect.getConn());
        Worker worker = workerDao.login(email, password);
        if (worker != null) {
          session.setAttribute("workerObj", worker);
          resp.sendRedirect("worker/index.jsp");
        } else {
            session.setAttribute("errorObj", "Некорректный email или пароль");
            resp.sendRedirect("coach_login.jsp");
        }
    }
}
