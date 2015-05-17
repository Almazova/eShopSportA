<%-- 
    Document   : cart
    Created on : 03.05.2015, 23:45:19
    Author     : asus
--%>

<div id="left">    

    <div id="actionBar">
        <%-- clear cart widget --%>
        <c:if test="${!empty cart && cart.numberOfItems != 0}">
            <a href="ServletPage?command=clear_cart" class="bubble hMargin">Отчистить корзину</a> &ensp;&ensp;
        </c:if>   

        <a href="ServletPage?command=continue_view" class="bubble hMargin" style="color: #00868B">
            Продолжить просмотр каталога</a>&ensp;&ensp;

        <%-- checkout widget --%>
        <c:if test="${!empty cart && cart.numberOfItems != 0}">

            <a href="ServletPage?command=go_to_checkout" class="bubble hMargin">Перейти к оформлению заказа &#x279f;</a>
        </c:if>
    </div>

    <c:if test="${!empty cart && cart.numberOfItems != 0}">

        <h4 id="subtotal">Итого: ${cart.subtotal} бел. руб.</h4>

        <table id="cartTable">

            <tr class="headertable">
                <th></th>
                <th>Название</th>
                <th>Цена, бел. руб.</th>
                <th>Количество</th>
                <th>Удалить</th>
            </tr>

            <c:forEach var="cartItem" items="${cart.items}" varStatus="iter">

                <c:set var="goods" value="${cartItem.goods}"/>

                <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                    <td>
                        <img src="${goods.image}"
                             alt="${product.nameGoods}" width="150px">
                    </td>

                    <td>${goods.nameGoods}</td>

                    <td>
                        ${cartItem.total}
                        <br>
                        <span class="smallText">( ${goods.priceGoods} / шт. )</span>
                    </td>                   
                    <td>
                        <form action="ServletPage" method="post" style="padding-left: 20%">
                            <input type="hidden"
                                   name="goodsId"
                                   value="${goods.goodsId}">
                            <input type="text"
                                   maxlength="3"
                                   size="2"
                                   value="${cartItem.quantity}"
                                   name="quantity"
                                   style="margin:5px" 
                                   pattern="[0-9]{1,3}"
                                   title="Только числа"
                                   >
                            <button type="submit"
                                    name="command" 
                                    value="update_quantity"> Изменить
                                <img src="${pageContext.request.contextPath}/img/icon/update.png" width="30px">
                            </button>   

                        </form>
                    </td>
                    <td>
                        <form action="ServletPage" method="post" style="padding-left: 40%">
                            <input type="hidden"
                                   name="goodsId"
                                   value="${goods.goodsId}">
                            <button type="submit"
                                    name="command"                                     
                                    value="delete_goods_from_cart" > 
                                <img src="${pageContext.request.contextPath}/img/icon/delete.png" width="30px">
                            </button>                             
                        </form>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty cart || cart.numberOfItems == 0}">
        <h2 style="padding-left: 35%">Корзина пуста...</h2>
    </c:if>
</div>