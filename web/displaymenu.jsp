<%-- 
    Document   : displaymenu
    Created on : Sep 15, 2013, 2:22:06 PM
    Author     : Mark
--%>

<%@page import="model.MenuItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The Sandwich Shop Menu</title>
    </head>
    <body>
        <form id="choices" name="choices" 
                    method="POST" action="OrderController">
        <h1>Choose from the menu and then submit</h1>
        <br/>
        <%
            List menu = (List)request.getAttribute("menu");
            Iterator it = menu.iterator();
            int count = -1; //So that when I increment count, it will be zero.
            
            while(it.hasNext()) {
                count++;
                MenuItem item = (MenuItem)it.next();
                String outItem = item.getItem() + "    $" + item.getPrice();
        %>
                
                <input type="checkbox" name="item" value="<%= count %>"><%= outItem %><br>
        <%
            }
        %>
            <br/><br/>
            <input type='submit' name="submit" 
                value="Place your order" class="mybutton1" />
        </form>
    </body>
</html>
