<%-- 
    Document   : adminPasswordCheck
    Created on : 19.05.2015, 0:06:53
    Author     : Katya Omelyashchik
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/passwordcheck.css">
        <link rel="stylesheet" type="text/css" href="css/admin.css">
        <title>Вход на страницу администратора</title>
        <script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/passwordCheck.js"></script> 
    </head>
    <body>
        <div>
            <form  action="ServletPage" method="post">
                <button type="submit" id="gotosite" name="command" value="go_to_website_main_page">
                    <h3>Перейти на сайт</h3>
                    <img src="${pageContext.request.contextPath}/img/icon/sites.png"
                         width="50px"title="сайт Спортивной атрибутики"/>
                </button>
            </form>
        </div>
        <div id="login">
            <h2><span class="fontawesome-lock"></span>Вход на страницу администратора</h2>
            <form action="ServletPage" method="post">
                <fieldset>		

                    <p><label for="password">Пароль:</label></p>
                    <p>
                        <input type="password" id="password" name="password" required="required" title="Ведите пароль!">
                        <c:if test="${pass}">
                            <a>Неверный пароль!</a>
                        </c:if>
                    </p>                                                              
                    <p><button id ="entry" type="submit" name="command" value="passwordcheck">                                 
                                           Войти </button>  </p>
                </fieldset>
            </form>
        </div>
    </body>
</html>
