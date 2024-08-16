package com.rose.ch05email.email;

import com.rose.ch05email.data.UserDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.rose.ch05email.business.User;

/**
 *
 * Shows the main page or the information that the user captured from the main
 * page.
 *
 * @author rose
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
            url = "/index.jsp";    // the "join" page
        } else if (action.equals("add")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            // store data in User object
            User user = new User(firstName, lastName, email);

            // validate the parameters
            String message;
            if (firstName == null || lastName == null || email == null
                    || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                message = "Please fill out all three text boxes.";
                url = "/index.jsp";
            } else {
                message = "";
                url = "/thanks.jsp";
                UserDB.insert(user);
            }
            request.setAttribute("user", user);
            request.setAttribute("message", message);
        }
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
