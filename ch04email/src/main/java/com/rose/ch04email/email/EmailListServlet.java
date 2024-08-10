package com.rose.ch04email.email;

import com.rose.ch04email.business.User;
import com.rose.ch04email.data.UserDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Shows the main page or the information that the user captured from the main
 * page.
 *
 * @author rose
 */
@WebServlet(urlPatterns = {"/emailList"})
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

        String action = request.getParameter("action");
        if (action == null) {
            action = "join";
        }

        if (action.equals("add")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            // use regular Java classes
            User user = new User(firstName, lastName, email);
            UserDB.insert(user);

            // store the User object in request and set URL
            request.setAttribute("user", user);
            url = "/thanks.jsp";
        } else if (action.equals("join")) {
            // set URL to index page
            url = "/index.html";
        }

        // forward request and response objects
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
