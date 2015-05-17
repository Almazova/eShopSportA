<%-- 
    Document   : adminEdditOrder
    Created on : 16.05.2015, 17:40:55
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
                        <input type="hidden" name="ordersId" value="${order.ordersId}">

                        <div id="editorder">
                            <fieldset>
                                <legend><span id="span">Контактная информация:</span></legend>
                                <table>
                                    <tr>                                

                                        <td>Имя*</td>
                                        <td>
                                            <input type="hidden" name="clientId" value="${order.client.clientId}">                       
                                            <input type="text" name="name" id="name" maxlength="15" value="${order.client.nameClient}" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Фамилия*</td>
                                        <td>
                                            <input type="text" name="surname" id="surname" maxlength="20" value="${order.client.surnameClient}"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>E-mail</td>
                                        <td>
                                            <input type="text" name="email" id="email"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Моб. телефон*</td>
                                        <td><input type="text" name="phone" id="phone" value="${order.client.phoneClient}"/></td>
                                    </tr>
                                    <tr>
                                        <td>Aдрес</td>
                                        <td><input type="text" name="address" maxlength="40" value="${order.client.addressClient}"/></td>
                                    </tr>
                                </table>           
                            </fieldset >
                            <br>
                            <fieldset >
                                <legend> <span id="span">Способ доставки и оплаты:</span> </legend>
                                <table>
                                    <tr>
                                        <td >Способ доставки</td>
                                        <td>
                                            <select name="delivery"  >
                                                <option id="export" value="${order.deliveryMethod.nameDm}"> ${order.deliveryMethod.nameDm}</option>
                                                <c:choose>
                                                <c:when test="${order.deliveryMethod.nameDm == 'Самовывоз'}">
                                                    <option id="courier" value="Курьером"> Курьером (50000 бел.руб)</option> 
                                                </c:when>
                                                <c:when test="${order.deliveryMethod.nameDm == 'Курьером'}">
                                                    <option id="export" value="Самовывоз"> Самовывоз </option>
                                                </c:when>
                                                    </c:choose>
                                                
                                            </select>

                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Способ оплаты</td>
                                        <td>
                                            <select name="payment">
                                                <option value="${order.paymentMethod.namePm}"> ${order.paymentMethod.namePm} </option>                                                     
                                            </select>
                                        </td>
                                    </tr>

                                </table>           
                            </fieldset>
                            <p id="message" style="color: red">Поля с * должны быть заполнены!</p>
                        </div>


                        <div style="text-align: center">
                            <button type="submit" class="checkoutButton"name="command" value="save_changes_to_the_order">Сохранить</button>                       
                            
                        </div>
                    </form>
                </c:if> 

                <div class="tablediv">
                    <table class="table-orders">
                        <thead>
                            <tr>
                                <th width="25%"></th>
                                <th width="35%">Название</th>
                                <th width="35%">Цена, бел.руб.</th>                                 
                                <th width="5%">Количество</th>
                                <th width="10%">Удалить</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${empty oGoods && empty order}">
                                <tr>
                                    <th colspan="5"><center><h2>Заказ был онулирован, так как все тоавры были удалены!</h2></center></th>
                            </tr>
                        </c:if>
                        <c:forEach  var ="oGoods" items="${orderedGoods}" varStatus="iter">

                            <c:set var="goods" value="${oGoods.goods}"/>

                            <tr>
                                <td>
                                    <img src="${goods.image}"
                                         alt="${goods.nameGoods}" width="100px">
                                </td>

                                <td>${goods.nameGoods}</td>

                                <td>                        
                                    <c:out value="${oGoods.price * oGoods.amount}"/>              
                                    <br>
                                    <span>( ${goods.priceGoods} / шт. )</span>
                                </td>                   
                                <td><form action="ServletPage" method="post">
                                        <div>

                                            <input type="hidden"
                                                   name="goodsId"
                                                   value="${oGoods.orderedGoodId}">
                                            <input type="text"
                                                   maxlength="3"
                                                   size="2"
                                                   value="${oGoods.amount}"
                                                   name="quantity"
                                                   style="margin:5px" 
                                                   pattern="[0-9]{1,3}"
                                                   title="Только числа"
                                                   >
                                            <button type="submit"
                                                    name="command" 
                                                    value="update_quantity_by_admin"> Изменить
                                                <img src="${pageContext.request.contextPath}/img/icon/update.png" width="30px">
                                            </button>   


                                        </div> 
                                    </form>
                                </td>
                                <td><form action="ServletPage" method="post">                                

                                        <input type="hidden"
                                               name="goodsId"
                                               value="${oGoods.orderedGoodId}">
                                        <button type="submit"
                                                name="command"                                     
                                                value="delete_goods_from_order_by_admin" > 
                                            <img src="${pageContext.request.contextPath}/img/icon/delete.png" width="40px">
                                        </button>                             
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>
                </div>

            </div>
        </div>

    </body>
</html>
