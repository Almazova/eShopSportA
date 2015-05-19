<%-- 
    Document   : adminDeleteEditGoods
    Created on : 17.05.2015, 13:14:31
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Администратор: интернет магазин спортивной атрибутики</title>
        <link rel="stylesheet" type="text/css" href="css/admin.css">
        <script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-latest.js"></script> 
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.tablesorter.js"></script> 
        <script>
            $(document).ready(function() {
                $("#tableGoods").tablesorter();
            });
        </script>

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
                <li><a href="ServletPage?command=go_to_admin_main_page" >Главная</a></li>
                <li><a href="ServletPage?command=go_to_admin_orders_received" >Поступившие заказы</a></li>
                <li><a href="ServletPage?command=go_to_executes_orders">Выполняющиеся заказы</a></li>
                <li><a href="ServletPage?command=go_to_admin_add_goods">Доавить товар</a></li>
                <li><a href="ServletPage?command=go_to_admin_delete_edit_goods" class="active">Удалить/Редактировать товар</a></li>
            </ul>

            <div class="box">
                <table id="tableGoods" class="table-orders">
                    <thead>
                        <tr>
                            <th width="15%">Название</th> 
                            <th width="10%">Категория</th> 
                            <th width="10%">Клуб</th> 
                            <th width="10%">Цена, бел.руб</th>
                            <th width="15%">Информация</th>
                            <th width="5%">Редактировать товар</th>
                            <th width="5%">Удалить/Вернуть товар</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:if test="${data[0] != null}">
                            <c:forEach var="goods" items="${data}" varStatus="iter">  
                                <tr>
                                    <td>${goods.nameGoods}</td>
                                    <td>${goods.category.nameCategory}</td>
                                    <td>${goods.club.nameClub}</td>


                                    <td>${goods.priceGoods}</td>
                                    <td>${goods.information}</td>                                    
                                    <td>
                                        <form action="ServletPage" method="post">
                                            <input type="hidden" name="goodsId" value="${goods.goodsId}">                                       
                                            <button type="submit" name="command" value="edit_goos_by_admin" class="button">      
                                                <img src="${pageContext.request.contextPath}/img/icon/editing.png"
                                                     title="Изменить данные о товаре"/>
                                            </button>                                           
                                        </form>
                                    </td>
                                    <td>
                                        <form action="ServletPage" method="post">
                                            <input type="hidden" name="goodsId" value="${goods.goodsId}">
                                            <c:if test="${!goods.deleted}">
                                                <button type="submit" name="command" value="mark_the_order_as_not_available" class="button">      
                                                    <img src="${pageContext.request.contextPath}/img/icon/rejection.png"
                                                         title="Пометить товар как 'нет в наличии'"/>
                                                </button>    
                                            </c:if>
                                            <c:if test="${goods.deleted}">
                                                <button type="submit" name="command" value="mark_the_order_as_in_stock" class="button">      
                                                    <img src="${pageContext.request.contextPath}/img/icon/confirmation.png"
                                                         title="Пометить товар как 'есть в наличии'"/>
                                                </button>    
                                            </c:if>

                                        </form>
                                    </td>
                                    </form>
                                </tr> 
                            </c:forEach>
                        </c:if>
                        <c:if test="${data[0] == null}">
                            <tr><td colspan="9"><h2><center>Товара нет..</center></h2></td></tr>
                                        </c:if>
                    </tbody>
                </table>


            </div>
        </div>
    </body>
</html>
