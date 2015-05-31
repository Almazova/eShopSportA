<%-- 
    Document   : 404
    Created on : 20.05.2015, 10:14:42
    Author     : Katya Omelyashchik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
﻿<!DOCTYPE html>
<html>
    <head>
        <title>Ошибка 404 - Страница не найдена</title>
        <meta name="robots" content="noindex" />
        <style type="text/css">
            html {height: 100%;}
            body {height:100%;margin:0; padding:0;background:#FFF url('/404.png') right bottom no-repeat ;}
            a {color:#27579E;text-decoration:none}
            a:hover {color:#0E1D34;text-decoration:none}
            @media only screen and (max-width: 1000px) {body {background:#FFF !important}}
        </style>
    </head>
    <body>
        <img src="img/404.png" border="0" alt="" width="480" style="display: block; margin-left: auto; margin-right: auto; margin-top: 60px;">
        <p>&nbsp;</p>
        <p style="text-align: center;"><a href="${pageContext.request.contextPath}/index.jsp" title="Вернуться на Главную">Главная</a> </p>
    </body>
</html>