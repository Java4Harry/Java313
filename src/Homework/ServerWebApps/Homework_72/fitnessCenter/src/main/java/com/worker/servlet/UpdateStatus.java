package com.worker.servlet;

import com.dao.AppointmentDao;
import com.db.DBConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/updateStatus")
public class UpdateStatus extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
        int id = Integer.parseInt(req.getParameter("id"));
        int cid = Integer.parseInt(req.getParameter("cid"));
        String comment = req.getParameter("comment");
        AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
        HttpSession session = req.getSession();
        if(dao.updateCommentStatus(id, cid, comment)){
            session.setAttribute("succMsg", "Комментарий обновлен");
            resp.sendRedirect("worker/client.jsp");
        } else {
            session.setAttribute("errorMsg", "Ошибка сервера");
            resp.sendRedirect("worker/client.jsp");
        }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
