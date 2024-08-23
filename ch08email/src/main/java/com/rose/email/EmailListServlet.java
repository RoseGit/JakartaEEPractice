/*
 */
package com.rose.email;

import com.rose.business.User;
import com.rose.data.UserDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Shows the main page or the information that the user captured from the main
 * page.
 *
 * @author Rose
 */
public class EmailListServlet extends HttpServlet {

    /**
     * Redirects to another web page depending on the action specified.
     *
     * @param request @see {@link HttpServletRequest}
     * @param response @see {@link HttpServletResponse}
     * @throws ServletException @see {@link ServletException}
     * @throws IOException @see {@link IOException}
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.html";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.html";    // the "join" page
        } else if (action.equals("add")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            // store data in User object and save User object in database
            User user = new User(firstName, lastName, email);
            UserDB.insert(user);

            // set User object in request object and set URL
            request.setAttribute("user", user);
            url = "/thanks.jsp";   // the "thanks" page
        }

        // forward request and response objects to specified URL
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    /**
     * Redirects to another web page depending on the action specified, using
     * {@link #doPost(HttpServletRequest, HttpServletResponse)} method.
     *
     * @param request @see {@link HttpServletRequest}
     * @param response @see {@link HttpServletResponse}
     * @throws ServletException @see {@link ServletException}
     * @throws IOException @see {@link IOException}
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
