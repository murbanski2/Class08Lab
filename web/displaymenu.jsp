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
        
        <title>${myTitle }</title>
        <script type="text/javascript" language="JavaScript">
<!--
            function checkCheckBoxes() {
                var checkBoxes = document.getElementsByClassName("checkbox");

                for (var i = 0; i < checkBoxes.length; i++) {
                    if (checkBoxes[i].checked) {
                        return true;
                    }
                }

                alert("Select at least one menu item");
                return false;
            }
//-->
        </script> 
    </head>
    <body>
        <form id="choices" name="choices" 
              method="POST" action="OrderController"
              onsubmit="return checkCheckBoxes();">
            <h1>Choose from the menu and then submit</h1>
            <br/>
            <%
                List menu = (List) request.getAttribute("menu");
                Iterator it = menu.iterator();
                //int count = -1; //So that when I increment count, it will be zero.

                while (it.hasNext()) {
                    //count++;
                    MenuItem item = (MenuItem) it.next();
                    int id = item.getId();
                    String outItem = item.getName() + "    $" + item.getPrice();
            %>

            <input type="checkbox" name="item" 
                   value="<%= id%>" class="checkbox">
            <%= outItem%><br>
            <%
                }
            %>
            <br/><br/>
            <input type='submit' name="submit" 
                   value="Place your order" class="mybutton1" />
        </form>
    </body>
</html>
