<%-- 
    Document   : DataPage
    Created on : 21.04.2015, 15:17:03
    Author     : asus
--%>



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
                                <td rowspan="2"><img src="${goods.image}"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>${goods.priceGoods}</td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <button type="submit" name="command" value="add_to_cart" id="addgoods"> В корзину </button>   
                                    <button  disabled="true" type="button" name="${goods.goodsId}" value="" >                                        
                                        <c:if test="${ goodsAdd == goods.goodsId}">                                                       
                                           
                                        <img src="img\icon\ok.png" width="20px">
                                         </c:if>
                                    </button>
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
        </c:forEach>
    </table>
</div>
