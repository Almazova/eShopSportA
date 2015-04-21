<%-- 
    Document   : DataPage
    Created on : 21.04.2015, 15:17:03
    Author     : asus
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.entity.Goods"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <title>Каталог спортивной атрибутики</title>
        <link rel="stylesheet" type="text/css" href="indexcss.css">
    </head>
    
    <body>
        <div id="header" ><p align="center" ><h1>Сайт спортивной атрибутики</h1>  </p> </div>
    <div id="middle">
        <div id="content">
            <div id="menu">
                <input style="background: #F63" type="submit" value="Главная" class="menu" />
                    <input  type="submit" value="Элементы одежды" class="menu" />
                    <input type="submit" value="Сувениры" class="menu" />
                    <input  type="submit" value="Звуковые атрибуты" class="menu" />
                    <input type="submit" value="Книги и мультимедиа" class="menu" />
                    <input  type="submit" value="Флаги и вымпелы" class="menu" />
            </div>
        </div>
        <div id="left">  
            <table>              

                <%  List<Goods> goodsList = (ArrayList) request.getAttribute("data");
                    int i = goodsList.size() - 1;
                    while (i > -1) {
                %>
                <tr>
                    <td>
                        <table id="tableGoods">
                            <tr>
                                <td colspan="2"><%=goodsList.get(i).getNameGoods()%></td>
                            </tr>
                            <tr>
                                <td rowspan="2"></td>
                                <td><%=goodsList.get(i).getInfomation()%></td>
                            </tr>
                            <tr>
                                <td><%=goodsList.get(i).getPriceGoods()%></td>
                            </tr>
                            <tr>
                                <td colspan="2"><input type="submit" value="В корзину" name=<%=goodsList.get(i).getGoodsId()%>></td>
                            </tr>
                        </table>
                    </td>
                    <td>
                        <% if (i > 0) {
                                    --i;%>
                        <table id="tableGoods">

                            <tr>
                                <td colspan="2"><%=goodsList.get(i).getNameGoods()%></td>
                            </tr>
                            <tr>
                                <td rowspan="2"></td>
                                <td><%=goodsList.get(i).getInfomation()%></td>
                            </tr>
                            <tr>
                                <td><%=goodsList.get(i).getPriceGoods()%></td>
                            </tr>
                            <tr>
                                <td colspan="2"><input type="submit" value="В корзину" name=<%=goodsList.get(i).getGoodsId()%>></td>
                            </tr>
                        </table>
                        <%}%>
                    </td>

                </tr>
                <% --i;
                    }%>
            </table>
        </div>
        <div class="left"></div>
    </div>
    <div id="footer"><p>Сайт спортивной атрибутики</p></div>
</body>
</html>

