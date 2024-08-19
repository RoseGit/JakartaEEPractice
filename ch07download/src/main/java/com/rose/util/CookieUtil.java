package com.rose.util;

import jakarta.servlet.http.Cookie;

/**
 * Class that allows us to manage cookie information.
 *
 * @author Rose
 */
public class CookieUtil {

    /**
     * Gets a specific value from an existing cookie
     *
     * @param cookies List of cookies
     * @param cookieName cookie name to get its value.
     * @return The cookie value
     */
    public static String getCookieValue(
            Cookie[] cookies, String cookieName) {

        String cookieValue = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    cookieValue = cookie.getValue();
                }
            }
        }
        return cookieValue;
    }
}
