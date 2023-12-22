/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chapter7;

import com.chapter2.model.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Rose
 */

@WebServlet(name = "download", urlPatterns = {"/download"})
public class DownloadServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        //get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "viewAlbums";
        }

        //perform action and set URL to appropiate page
        String url = "/index.jsp";
        if (action.equals("viewAlbums")) {
            url = "/index.jsp";
        } else if (action.equals("checkUser")) {
            url = checkUser(request, response);
        }

        //forward to the view
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String action = request.getParameter("action");

        //performa action and set URL to appropiate page
        String url = "index.jsp";
        if (action.equals("registerUser")) {
            url = registerUser(request, response);
        }

        //forward to the view
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private String checkUser(HttpServletRequest request, HttpServletResponse response) {
        String productCode = request.getParameter("productCode");
        HttpSession session = request.getSession();
        session.setAttribute("productCode", productCode);
        User user = (User) session.getAttribute("user");

        String url;

        //if the user does not exist 
        if (user == null) {
            Cookie[] cookies = request.getCookies();
            String emailAddress = CookieUtil.getCookieValue(cookies, "emailCookie");

            //If cookie does not exist, go to registration page 
            if (emailAddress == null || emailAddress.equals("")) {
                url = "/register.jsp";
            } else {
                //If cookie exist, create user object and go to Downloads page
                ServletContext servletContext = getServletContext();
                String path = servletContext.getRealPath("/WEB-INF/EmailList.txt");
                user = UserIO.getUser(emailAddress, path);
                session.setAttribute("user", user);
                url = "/" + productCode + "_download.jsp";
            }
        } else {
            //If the user object exist, go to download page
            url = "/" + productCode + "_download.jsp";
        }
        return url;
    }

    private String registerUser(HttpServletRequest request, HttpServletResponse response) {
        //get the user data 
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        //Store the data in a User Object
        User user = new User(firstName, lastName, email);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        //Write user object to a file 
        ServletContext servletContext = getServletContext();
        String path = servletContext.getRealPath("/WEB-INF/EmailList.txt");
        UserIO.add(user, path);

        //store the User object as a session atribute 
        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        //add a cookie that stores the user's email to browser 
        Cookie cookie = new Cookie("emailCookie", email);
        cookie.setMaxAge(60 * 60 * 24 * 365 * 2);
        cookie.setPath("/");
        response.addCookie(cookie);

        //create an return URL for the appropiate Download page
        String productCode = (String) session.getAttribute("productCode");
        String url = "/" + productCode + "_download.jsp";
        return url;
    }

}
