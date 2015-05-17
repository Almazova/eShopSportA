<%-- 
    Document   : adminAddGoods
    Created on : 17.05.2015, 17:06:01
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/valid.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.maskedinput.js"></script>
<script type="text/javascript">
    jQuery(function($) {
        $("#phone").mask("8-(099) 999-99-99");
    });
</script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Администратор: интернет магазин спортивной атрибутики</title>
        <link rel="stylesheet" type="text/css" href="css/admin.css">
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
                <c:if test="${!empty order}">
                    <form  action="ServletPage" method="post" onsubmit="return (ValidMail() && ValidForm())">
                        <input type="hidden" name="goodsId" value="${goods.goodsId}">
                        <div id="editorder">
                            <fieldset>
                                <legend><span id="span">Информация о товаре:</span></legend>
                                <table>
                                    <tr> 
                                        <td>Название*</td>
                                        <td>                                                                 
                                            <input type="text" name="name" id="name" maxlength="30" value="${goods.nameGoods}" />
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
                                        <td><input type="text" name="price" id="price" value="${goods.priceGoods}"/></td>
                                    </tr>
                                    <tr>
                                        <td>Информация*</td>
                                        <td><input type="text" name="inf" maxlength="60" value="${goods.information}" height="50px"/></td>
                                    </tr>
                                </table>           
                            </fieldset >
                            <br>
                        </div>


                        <div style="text-align: center">
                            <button type="submit" class="checkoutButton"name="command" value="save_changes_to_the_order">Сохранить</button>                       
                            <button type="submit" class="checkoutButton"name="command" value="add_order">Oтмена</button><br><br>
                        </div>
                    </form>
                </c:if> 

                

            </div>
        </div>

    </body>
</html>
