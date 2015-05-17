<%-- 
    Document   : adminEditGoods
    Created on : 17.05.2015, 17:24:47
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
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/valid.js"></script>
    </head>
    <body>
        <div id="container">
            <ul id="nav-bar">
                <li><a href="ServletPage?command=go_to_admin_main">Главная</a></li>
                <li><a href="ServletPage?command=go_to_admin_orders_received">Поступившие заказы</a></li>
                <li><a href="ServletPage?command=go_to_executes_orders">Выполняющиеся заказы</a></li>
                <li><a href="#">Доавить товар</a></li>
                <li><a href="ServletPage?command=go_to_admin_delete_edit_goods">Удалить/Редактировать товар</a></li>
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
