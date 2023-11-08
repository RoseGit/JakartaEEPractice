/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chapter6;

import com.chapter2.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rose
 */
@WebServlet(name = "EmailListJSTL", urlPatterns = {"/emailListjstl"})
public class EmailListJSTL extends HttpServlet{
    public static List<User> listUsers = new ArrayList<>();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/joinemailjstl.jsp";
        
        //get action
        String action = request.getParameter("action");
        if(action == null){
            action = "join";
        }
        
        if(action.equals("join")){
            url = "/joinemailjstl.jsp";
        }else if(action.equals("add")){
            //get parameters
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            User user = new User(firstName, lastName, email);
            
            //Validate the parameters
            String message;
            if(firstName == null || firstName.isEmpty()||
               lastName == null || lastName.isEmpty() ||
                    email == null || email.isEmpty()){
                message = "Please fill oput all three text boxes";
                url = "/joinemailjstl.jsp";
            }else{
                message = "";
                url = "/thanks.jsp";
                listUsers.add(user);
            }
            
            request.setAttribute("user", user);
            request.setAttribute("message",message);
        }
        
        //Re dirigimos a la url especificada, el request tiene el objeto User cuando se guarda por tanto se puede utilizar en el thanks.jsp 
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
