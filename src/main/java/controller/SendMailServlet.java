package controller;

import util.MailUtil;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/sendMail")
public class SendMailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String to = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            MailUtil.sendMail(to, subject, message, false);
            out.println("<h3 style='color:blue;'>Mail sent successfully!</h3>");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h3 style='color:red;'>Failed to send mail: " + e.getMessage() + "</h3>");
        }
    }
}
