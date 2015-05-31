<%-- 
    Document   : adminAddGoods
    Created on : 17.05.2015, 17:06:01
    Author     : Katya Omelyashchik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/valid.js"></script>

</script>
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
                <button type="submit"id="gotosite" name="command" value="go_to_website_main_page">
                    <h3>Перейти на сайт</h3>
                    <img src="${pageContext.request.contextPath}/img/icon/sites.png"
                         width="50px"title="сайт Спортивной атрибутики"/>
                </button>
            </form>
        </div>
        <div style="margin-left: 95%;margin-top: -113px">
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
                <li><a href="ServletPage?command=go_to_admin_main_page">Главная</a></li>
                <li><a href="ServletPage?command=go_to_admin_orders_received">Поступившие заказы</a></li>
                <li><a href="ServletPage?command=go_to_executes_orders">Выполняющиеся заказы</a></li>
                <li><a href="ServletPage?command=go_to_admin_add_goods" class="active">Доавить товар</a></li>
                <li><a href="ServletPage?command=go_to_admin_delete_edit_goods">Удалить/Редактировать товар</a></li>
            </ul>

            <div class="box">

                <form  action="ServletPage" method="post" onsubmit="return (ValidFormGoods())">                        
                    <div id="editorder">
                        <c:if test="${!empty added}">
                            <center>
                                <h2>Товар добавлен!!!</h2>       
                            </center>                
                        </c:if>
                        <fieldset>
                            <legend><span id="span">Информация о товаре:</span></legend>
                            <table>
                                <tr> 
                                <tr>
                                    <td>Картинка*</td>
                                    <td>
                                        <input type="text" name="img" id="img" readonly="true" value="${image}"/>
                                        <c:if test="${empty image}">
                                            <button type="submit" class="checkoutButton"name="command" value="open_img">Загрузить</button>
                                        </c:if>
                                        <c:if test="${!empty image}">
                                            <button type="submit" class="checkoutButton"name="command" value="open_img" disabled="true">Загрузить</button>
                                        </c:if>
                                    </td>
                                </tr>
                                <c:if test="${!empty image}">
                                    <td>Название*</td>
                                    <td>  
                                        <textarea name="nameGoods" id="nameGoods" maxlength="30"></textarea>                                           
                                    </td>
                                    </tr>
                                    <tr>
                                        <td>Категория*</td>
                                        <td>
                                            <select name="category" id="category" >       
                                                <option id="emptyCategory" value="emptyCategory"></option>
                                                <option id="clothing" value="Элементы одежды"> Элементы одежды </option>
                                                <option id="souvenirs" value="Сувениры"> Сувениры </option>  
                                                <option id="sound_attributes"value="Звуковые атрибуты"> Звуковые атрибуты </option>  
                                                <option id="books_and_media" value="Книги и мультимедиа"> Книги и мультимедиа </option>
                                                <option id="flags_and_pennants" value="Флаги и вымпелы"> Флаги и вымпелы </option>                                                
                                            </select>                                           
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Клуб</td>
                                        <td>
                                            <select name="club" id="club" >   
                                                <option id="emptyClub" value="emptyClub"></option>
                                                <option id="Chelsea" value="Chelsea"> Chelsea </option>
                                                <option id="ManchesterUnited" value="Manchester United"> Manchester United </option>  
                                                <option id="Arsenal"value="Arsenal"> Arsenal </option>  
                                            </select>   
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Цена*</td>
                                        <td>
                                            <input type="text" name="price" id="price"
                                                   pattern="[0-9]{1,10}" title="Только числа"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Информация*</td>
                                        <td><textarea  name="inf" id="inf" maxlength="60">${goods.information}</textarea></td>
                                    </tr>
                                </c:if>
                            </table>           
                        </fieldset >
                        <br>
                        <c:if test="${!empty image}">
                            <p id="message" style="color: red">Поля с * должны быть заполнены!</p>                                                  
                        </c:if>
                    </div>

                    <div>
                        <c:if test="${!empty image}">
                            <center>
                                <button type="submit" class="checkoutButton"name="command" value="add_goods_by_admin">Сохранить</button>       
                            </center>                
                        </c:if>
                    </div>
                </form>

            </div>
        </div>

    </body>
</html>
