<%-- 
    Document   : checkout
    Created on : 06.05.2015, 0:30:22
    Author     : asus
--%>
<script>
    function down_up()
    {

        var a = document.getElementById('checkoutMinsk');
        if (a.style.display == 'none')
            a.style.display = 'block';
        else if (a.style.display == 'block')
            a.style.display = 'none';
    }
</script>
<div id="left">
    <fieldset>
        <legend><span id="span">Выберите город:</span></legend>
        <select name="city" onchange="down_up()">
            <option value="">  </option>
            <option value="Minsk"> Минск </option>
            <option value="Other"> Другой город РБ </option>                  
        </select></p>
    </fieldset >
    <form id="checkoutMinsk" action="ServletPage" method="post" style="display:none">
        <fieldset >
            <legend><span id="span">Контактная информация:</span></legend>
            <table>
                <tr>
                    <td>Имя*</td>
                    <td><input type="text" name="name" /></td>
                </tr>
                <tr>
                    <td>Фамилия*</td>
                    <td><input type="text" name="surname" /></td>
                </tr>
                <tr>
                    <td>E-mail</td>
                    <td><input type="email" name="email" /></td>
                </tr>
                <tr>
                    <td>Моб. телефон*</td>
                    <td><input type="text" name="phone" /></td>
                </tr>
                <tr>
                    <td>Aдрес</td>
                    <td><input type="text" name="address" /></td>
                </tr>
            </table>           
        </fieldset >
        <fieldset >
            <legend> <span id="span">Способ доставки и оплаты:</span> </legend>
            <table>
                <tr>
                    <td>Способ доставки</td>
                    <td>
                        <select name="delivery">
                            <option value="Самовывоз"> Самовывоз </option>
                            <option value="Курьером"> Курьером </option>                  
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Способ оплаты</td>
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
            <button type="submit" class="checkoutButton"name="command" value="add_order">Сделать заказ</button>
            <button type="reset" class="checkoutButton">Сбросить</button></div>
    </form>
</div>