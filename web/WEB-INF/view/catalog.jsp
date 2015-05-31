<%-- 
    Document   : DataPage
    Created on : 21.04.2015, 15:17:03
    Author     : Katya Omelyashchik
--%>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/valid.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/popup.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        PopUp($('#obj'), $('#trigg'));
    });
</script>

<div id="left">  
    <table id ="catalog">              
        <c:set var="flag" value="0"/>
        <c:forEach var="goods" items="${data}" varStatus="iter">

            <c:if test="${flag == '0'}">
                <tr>                           
                </c:if>
                <td>
                    <form action="ServletPage" method="post">
                        <table id="tableGoods">
                            <tr >
                                <td colspan="2">
                                    <input type="hidden" name="goodsId" value="${goods.goodsId}"/>
                                    ${goods.nameGoods}
                                </td>
                            </tr>
                            <tr>
                                <td rowspan="2"><img src="${goods.image}" onclick="show('block',${goods.goodsId})"></td>
                                <td><center><a onclick="show('block',${goods.goodsId})" href="#">Подробнее...</a></center>	</td>
                            </tr>
                            <tr>
                                <td>${goods.priceGoods} бел. руб.</td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <c:if test="${!goods.deleted}">
                                        <button type="submit" name="command" value="add_to_cart" id="addgoods" > В корзину </button>   
                                        <c:if test="${ goodsAdd == goods.goodsId}">                             

                                            <img src="img\icon\ok.png" width="20px">                                        
                                        </c:if>
                                    </c:if>
                                    <c:if test="${goods.deleted}">
                                        <button type="submit" disabled="true"id="nogoods" width="200px" >Нет в наличии </button>
                                    </c:if>


                                </td>

                            </tr>                       
                        </table>
                    </form>
                </td>
                <c:choose>
                    <c:when test="${flag == '1'}">
                    </tr>
                    <c:set var="flag" value="0"/>   
                </c:when>
                <c:when test="${flag == '0'}">                   
                    <c:set var="flag" value="1"/>
                </c:when>
            </c:choose>

            <div onclick="show('none')" id="wrap"></div>      
            <div class="window" id ="${goods.goodsId}">           
                <img class="close" onclick="show('none', ${goods.goodsId})" src="${pageContext.request.contextPath}/img/icon/close.png">
                <center>                    
                    <h2>${goods.nameGoods}</h2>
                    <img  src="${goods.image}" width="70%"><br>
                    <h2>${goods.information}</h2>
                </center>
            </div>

        </c:forEach>
    </table>

</div>
