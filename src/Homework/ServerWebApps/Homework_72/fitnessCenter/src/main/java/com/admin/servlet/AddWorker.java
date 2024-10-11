package com.admin.servlet;

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

@WebServlet("/addWorker")
public class AddWorker extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String fullName = req.getParameter("full_name");
            String dob = req.getParameter("dob");
            String qualification = req.getParameter("qualification");
            String spec = req.getParameter("spec");
            String email = req.getParameter("email");
            String phone = req.getParameter("mobphone");
            String password = req.getParameter("password");

            Worker worker = new Worker(fullName, dob, qualification, spec, email, phone, password);
            WorkerDao dao = new WorkerDao(DBConnect.getConn());
            HttpSession session = req.getSession();
            if(dao.registerWorker(worker)) {
                session.setAttribute("sucсMsg", "Сотрудник добавлен");
                resp.sendRedirect("admin/worker.jsp");
            } else {
                session.setAttribute("errorMsg", "Ошибка сервера");
                resp.sendRedirect("admin/worker.jsp");
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}