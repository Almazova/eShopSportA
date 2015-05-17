<%-- 
    Document   : readyOrder
    Created on : 11.05.2015, 19:09:07
    Author     : asus
--%>

<div id="left">    
    <div id="actionBar">
        ${orderedGoods[0].order.client.nameClient}, ваш заказ на сумму ${total}  бел. руб. принят.<br>
        Через некоторое время вам перезвонят для подтверждения заказа.<br><br><br>
        Ваш заказ:
    </div>

    <table id="cartTable">
        <tr class="headertable">
            <th></th>
            <th>Название</th>
            <th>Цена, бел. руб.</th>
            <th>Количество</th>               
        </tr>

        <c:forEach  var ="oGoods" items="${orderedGoods}" varStatus="iter">

            <c:set var="goods" value="${oGoods.goods}"/>

            <tr class="${((iter.index % 2) == 0) ? 'lightBlue' : 'white'}">
                <td>
                    <img src="${goods.image}"
                         alt="${product.nameGoods}" width="150px">
                </td>

                <td>${goods.nameGoods}</td>

                <td>                        
                    <c:out value="${goods.priceGoods * oGoods.amount}"/>              
                    <br>
                    <span class="smallText">( ${goods.priceGoods} / шт. )</span>
                </td>                   
                <td>
                    <div style="padding-left: 40%">${oGoods.amount}</div> 
                </td>
            </tr>
        </c:forEach>
    </table>

        <br> <br> <br>
        <table style="padding-left: 25%">
        <tr class="headertable">
            <th colspan="2">Информация о заказе</th>
                    
        </tr>
        <tr class="lightBlue">
            <td>Имя</td>
            <td>${orderedGoods[0].order.client.nameClient}</td>
        </tr>
        <tr class="white">
            <td>Фамилия</td>
            <td>${orderedGoods[0].order.client.surnameClient}</td>
        </tr>
        <tr class="lightBlue">
            <td>E-mail</td>
            <td>${orderedGoods[0].order.client.emailClient}</td>
        </tr>
        <tr class=" white">
            <td>Моб. телефон</td>
            <td>${orderedGoods[0].order.client.phoneClient}</td>
        </tr>
        <tr class="lightBlue">
            <td>Aдрес</td>
            <td>${orderedGoods[0].order.client.addressClient}</td>
        </tr>

        <tr class="  white">
            <td >Способ доставки</td>
            <td>${orderedGoods[0].order.deliveryMethod.nameDm}</td>                        
        </tr>
        <tr class="lightBlue ">
            <td>Способ оплаты</td>
            <td>${orderedGoods[0].order.paymentMethod.namePm}</td>
        </tr>

    </table>           


</div>