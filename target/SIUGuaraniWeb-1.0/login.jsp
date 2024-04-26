<%-- 
    Document   : login
    Created on : 25 abr 2024, 11:20:53
    Author     : orell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action=Login method=post >
            <table>
                <tr><td>Ingrese usuario</td> <td><input type="text" name="txtUser"> </td></tr>
                <tr><td>Ingrese contra</td> <td><input type="password" name="txtPwd"></td> </tr>
                <tr><td><input type="submit" value="login" > </td><td> <input type="reset"> </td></tr>

            </table>
            
        </form>
    </body>
</html>
