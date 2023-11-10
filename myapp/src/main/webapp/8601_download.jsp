<%-- 
    Document   : 8601_download
    Created on : 10 nov. 2023, 16:33:30
    Author     : Rose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Download page</title>
    </head>
    <body>
        <h1>Downloads</h1>
        
        <table>
            <tr>
                <th>Song title</th>
                <th>Audio Format</th>
            </tr>
            <tr>
                <td>You are a star</td>    
                <td>
                    <a href="/musicStore/sound/${productCode}/start.mp3">MP3</a>
                </td>
            </tr>
            <tr>
                <td>Don't Make No Difference</td>    
                <td>
                    <a href="/musicStore/sound/${productCode}/no_difference.mp3">MP3</a>
                </td>
            </tr>
        </table>
    </body>
</html>
