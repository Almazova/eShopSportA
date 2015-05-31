<%-- 
    Document   : adminEditGoods
    Created on : 17.05.2015, 17:24:47
    Author     : Katya Omelyashchik
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Администратор: интернет магазин спортивной атрибутики</title>
        <link rel="stylesheet" type="text/css" href="css/admin.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/valid.js"></script>
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
                <li><a href="ServletPage?command=go_to_admin_main_page">Главная</a></li>
                <li><a href="ServletPage?command=go_to_admin_orders_received">Поступившие заказы</a></li>
                <li><a href="ServletPage?command=go_to_executes_orders">Выполняющиеся заказы</a></li>
                <li><a href="ServletPage?command=go_to_admin_add_goods">Доавить товар</a></li>
                <li><a href="ServletPage?command=go_to_admin_delete_edit_goods" class="active">Удалить/Редактировать товар</a></li>
            </ul>

            <div class="box">
                <c:if test="${!empty goods}">
                    <form  action="ServletPage" method="post" onsubmit="return (ValidFormGoods())">
                        <input type="hidden" name="goodsId" value="${goods.goodsId}">
                        <div id="editorder">
                            <fieldset>
                                <legend><span id="span">Информация о товаре:</span></legend>
                                <table>
                                    <tr> 
                                        <td>Название*</td>
                                        <td>            
                                            <textarea name="nameGoods" id="nameGoods" maxlength="30">${goods.nameGoods}</textarea>                                            
                                        </td> 
                                    </tr>
                                    <tr>
                                        <td>Категория</td>
                                        <td>
                                            <input type="text" name="category" id="category"  value="${goods.category.nameCategory}" disabled="true"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Клуб</td>
                                        <td>
                                            <input type="text" name="club" id="club" value="${goods.club.nameClub}" disabled="true"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Цена*</td>
                                        <td><input type="text" name="price" id="price" value="${goods.priceGoods}"
                                                   pattern="[0-9]{1,10}" title="Только числа"/></td>
                                    </tr>
                                    <tr>
                                        <td>Информация*</td>                                          
                                        <td><textarea  name="inf" id="inf" maxlength="60">${goods.information}</textarea>   </td>
                                    </tr>
                                </table>           
                            </fieldset >
                            <br>
                            <p id="message" style="color: red">Поля с * должны быть заполнены!</p>
                        </div>


                        <div style="text-align: center">
                            <button type="submit" class="checkoutButton"name="command" value="save_changes_to_the_goods">Сохранить</button>                       

                        </div>
                    </form>
                </c:if>               

            </div>
        </div>

    </body>
</html>
