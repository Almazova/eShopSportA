/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function passwordcheck() {

    var flag = false;
    var password = $("#password").val();
    if (password !== "") {
        jQuery.post('xmlpassword/data.xml', {}, function(xml) {

            jQuery(xml).find('note').each(function() {

                if ($(this).find("password").text() == password) {
                    alert("Добро пожаловать!!!");
                    flag = true;
                }
                else
                    alert("Неверный ввод!!!");
            });
        }, 'xml');
    }
    else
        alert("Заполните все поля!!!");
    return flag;
}

