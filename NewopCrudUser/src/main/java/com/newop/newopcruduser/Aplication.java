package com.newop.newopcruduser;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.ws.rs.GET;

@WebServlet(name = "aplication", value = "/aplication-servlet")
public class Aplication extends HttpServlet {
    private String message;


    public void init() {
        message = "Realizada aplicação";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // mostra a msg em html
        PrintWriter valorSaida = response.getWriter();
        valorSaida.println("<html><body>");
        valorSaida.println("<h1>" + message + "</h1>");
        valorSaida.println("</body></html>");
    }

    public void destroy() {
    }
}