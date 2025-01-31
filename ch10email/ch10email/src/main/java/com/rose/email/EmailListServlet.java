package com.rose.email;

import java.io.IOException;

import com.rose.business.User;
import com.rose.data.UserDB;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EmailListServlet extends HttpServlet
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8657891280659152348L;

	@Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException
    {
        String url = "/index.html";
        
        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.jsp";    // the "join" page
        } 
        else if (action.equals("add")) {
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");

            // create the User object
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);

            // store the User object in the session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty())
            {
                // forward to the view to get missing parameters
                url = "/index.jsp";
            }
            else
            {
                // write the User object to a file
                UserDB.insert(user);

                // forward to the view
                url = "/thanks.jsp";
            }        
        }

        getServletContext().getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException
    {
        this.doPost(request, response);
    }
}