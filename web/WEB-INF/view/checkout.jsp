<%-- 
    Document   : checkout
    Created on : 06.05.2015, 0:30:22
    Author     : Katya Omelyashchik
--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/valid.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.maskedinput.js"></script>
<script type="text/javascript">
  jQuery(function($) {
    $("#phone").mask("8-(099) 999-99-99");
});
</script>
<div id="left">
    <form  action="ServletPage" method="post" onsubmit="return (ValidMail()&& ValidForm())">

        <fieldset>
            <legend><span id="span">Выберите город:</span></legend>
            <select id ="city" name="city" onchange="down_up()">
                <option value="nothing">  </option>
                <option value="Minsk"> Минск </option>
                <option value="Other"> Другой город РБ </option>                  
            </select>
        </fieldset >

        <div id="checkoutMinsk" style="display:none">
            <fieldset >
                <legend><span id="span">Контактная информация:</span></legend>
                <table>
                    <tr>
                        <td>Имя*</td>
                        <td><input type="text" name="name" id="name" maxlength="15" /></td>
                    </tr>
                    <tr>
                        <td>Фамилия*</td>
                        <td><input type="text" name="surname" id="surname" maxlength="20"/></td>
                    </tr>
                    <tr>
                        <td>E-mail</td>
                        <td><input type="text" name="email" id="email"/></td>
                    </tr>
                    <tr>
                        <td>Моб. телефон*</td>
                        <td><input type="text" name="phone" id="phone"  /></td>
                    </tr>
                    <tr>
                        <td>Aдрес</td>
                        <td><input type="text" name="address" maxlength="40"/></td>
                    </tr>
                </table>           
            </fieldset >
            <fieldset >
                <legend> <span id="span">Способ доставки и оплаты:</span> </legend>
                <table>
                    <tr>
                        <td >Способ доставки*</td>
                        <td>
                            <select name="delivery" id="delivery" >
                                <option id="empty" value="empty"></option>
                                <option id="export" value="Самовывоз" style="display: none"> Самовывоз </option>
                                <option id="courier" value="Курьером" style="display: none"> Курьером (50000 бел.руб)</option>  
                                <option id="post"value="Почта" style="display: none"> Белпочта(40000 бел.руб) </option>   
                            </select>

                        </td>
                    </tr>
                    <tr>
                        <td>Способ оплаты*</td>
                        <td>
                            <select name="payment">
                                <option value="Наличные"> Наличные </option>
                                <option value="Платежная карта"> Платежная карта </option>                  
                            </select>
                        </td>
                    </tr>

                </table>           
            </fieldset>
            <div style="text-align: center">
                <button type="submit" class="checkoutButton"name="command" value="add_order">Оформить заказ</button>
                <button type="reset" class="checkoutButton">Сбросить</button>
                <p id="message" style="color: red">Пожалуйста, обязательно заполните все поля формы с *!</p>
            </div>
           
        </div>
    </form>
</div>