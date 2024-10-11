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

@WebServlet("/workerUpdateProfile")
public class EditProfile extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String fullName = req.getParameter("full_name");
            String dob = req.getParameter("dob");
            String qualification = req.getParameter("qualification");
            String section = req.getParameter("spec");
            String email = req.getParameter("email");
            String phone = req.getParameter("mobphone");
            int id = Integer.parseInt(req.getParameter("id"));
            Worker worker = new Worker(id, fullName, dob, qualification, section, email, phone, "");
            WorkerDao dao = new WorkerDao(DBConnect.getConn());
            HttpSession session = req.getSession();
            if(dao.editWorkerProfile(worker)){
                Worker updateWorker = dao.getWorkersById(id);
                session.setAttribute("succMsg", "Данные обновлены");
                session.setAttribute("workerObj", updateWorker);
                resp.sendRedirect("worker/edit_profile.jsp");
            } else {
                session.setAttribute("errorMsg", "Ошибка сервера");
                resp.sendRedirect("worker/edit_profile.jsp");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
