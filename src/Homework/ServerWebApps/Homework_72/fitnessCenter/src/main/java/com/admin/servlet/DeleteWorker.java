package com.admin.servlet;

import com.dao.WorkerDao;
import com.db.DBConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/deleteWorker")
public class DeleteWorker extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        WorkerDao dao = new WorkerDao(DBConnect.getConn());
        HttpSession session = req.getSession();
        if(dao.deleteWorker(id)){
            session.setAttribute("succMsg", "Врач удален успешно");
            resp.sendRedirect("admin/worker.jsp");
        } else {
            session.setAttribute("errorMsg", "Ошибка сервера");
            resp.sendRedirect("admin/worker.jsp");
        }
    }
}