<%-- 
    Document   : adminMain
    Created on : 13.05.2015, 17:27:29
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Администратор: интернет магазин спортивной атрибутики</title>
        <link rel="stylesheet" type="text/css" href="css/admin.css">
    </head>
    <body>
        <div>
            <form  action="ServletPage" method="post">
                <button type="submit" id="gotosite"name="command" value="go_to_website_main_page">
                    <h3>Перейти на сайт</h3>
                    <img src="${pageContext.request.contextPath}/img/icon/sites.png"
                         width="50px"title="сайт Спортивной атрибутики"/>
                </button><br>

            </form>
        </div>
        <div style="margin-left: 95%;margin-top: -100px">
            <form  action="ServletPage" method="post">
                <button type="submit" id="gotosite"name="command" value="exit">
                    <h3>Выход</h3>
                    <img src="${pageContext.request.contextPath}/img/icon/exit.png"
                         width="50px"title="Выйти со страницы админа"/>
                </button> 
            </form>
        </div>
                         
        <div id="container">
            <ul id="nav-bar">
                <li><a href="ServletPage?command=go_to_admin_main_page" class="active">Главная</a></li>
                <li><a href="ServletPage?command=go_to_admin_orders_received">Поступившие заказы</a></li>
                <li><a href="ServletPage?command=go_to_executes_orders">Выполняющиеся заказы</a></li>
                <li><a href="ServletPage?command=go_to_admin_add_goods">Доавить товар</a></li>
                <li><a href="ServletPage?command=go_to_admin_delete_edit_goods">Удалить/Редактировать товар</a></li>
            </ul>

            <div class="box">

            </div>
        </div>
    </body>
</html>
