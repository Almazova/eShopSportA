<%-- 
    Document   : index
    Created on : 20.04.2015, 20:25:58
    Author     : asus
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <title>Сайт спортивной атрибутики</title>
        <link rel="stylesheet" type="text/css" href="indexcss.css">
    </head>
    <body>
        <div id="header" ><p align="center" ><h1>Сайт спортивной атрибутики</h1>  </p> </div>
    <div id="middle">
        <form action="ServletPage" method="post">
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


            <div id="quote"><a >Порой просто нужно взять паузу.<br> Чай и уют.<br> И несколько дней наедине с мыслями.</a> </div>  <br>    

            <div class="left">
                <table>
                    <tr>
                        <td> <img src="img/chelsea.jpg"></td>
                        <td><input type="checkbox" name="club" value="Chelsea" checked>Chelsea<Br></td>
                        <td><img  src="img/manchester.png"></td>
                        <td><input type="checkbox" name="club" value="ManchesterUnited">Manchester United<Br></td>
                        <td><img src="img/arsenal.jpg"</td>
                        <td><input type="checkbox" name="club" value="Arsenal">Arsenal<Br> </td>                   
                    </tr>
                </table>    
            </div>
        </form>
    </div>
</form>
</div>
</div>
<div id="footer"><p>Сайт спортивной атрибутики</p></div>
</body>
</html>


