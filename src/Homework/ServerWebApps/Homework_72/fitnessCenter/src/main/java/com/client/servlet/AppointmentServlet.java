package com.client.servlet;

import com.dao.AppointmentDao;
import com.db.DBConnect;
import com.entity.Appointment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/addAppointment")
public class AppointmentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int clientId = Integer.parseInt(req.getParameter("clientid"));
        String fullName = req.getParameter("fullname");
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");
        String appointDate = req.getParameter("appoint_date");
        String email = req.getParameter("email");
        String phone = req.getParameter("number");
        String like = req.getParameter("like");
        int workerId = Integer.parseInt(req.getParameter("sect"));
        String address = req.getParameter("address");
        Appointment ap = new Appointment(clientId, fullName, gender, age, appointDate, email, phone, like, workerId, address, "В обработке");
        AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
        HttpSession session = req.getSession();
        if(dao.addAppointment(ap)){
            session.setAttribute("succMsg", "Запись создана");
            resp.sendRedirect("client_appointment.jsp");
        } else{
            session.setAttribute("errorMsg", "Ошибка сервера");
            resp.sendRedirect("client_appointment.jsp");
        }
    }
}
