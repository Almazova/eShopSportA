function down_up()
{
    var form = document.getElementById('checkoutMinsk');
    var city = document.getElementById('city');
    var delivery = document.getElementById('delivery'); 
    var deliveryExport = document.getElementById('export');
    var deliveryCourier = document.getElementById('courier');
    var deliveryPost = document.getElementById('post');
  
    

    if (form.style.display === 'none')
    {
        form.style.display = 'block';
    }

    else if (form.style.display === 'block' && city.options[city.selectedIndex].value === 'nothing')
        form.style.display = 'none';


    if (city.options[city.selectedIndex].value === 'Minsk')
    {

        deliveryExport.style.display = "block";
        deliveryCourier.style.display = "block";
        deliveryPost.style.display = "none";

    }
    else if (city.options[city.selectedIndex].value === 'Other')
    {
        deliveryExport.style.display = "none";
        deliveryCourier.style.display = "none";
        deliveryPost.style.display = "block";
    }
    delivery.options[0].selected=true;
}

function showInfAboutChelsea()
{
    var chelsea = document.getElementById('chelsea');
    var mu = document.getElementById('mu');
    var arsenal = document.getElementById('arsenal');
    if (chelsea.style.display === 'none')
    {
        chelsea.style.display = 'block';
        mu.style.display = 'none';
        arsenal.style.display = 'none';
    } else
        chelsea.style.display = 'none';
}

function showInfAboutMU()
{
    var chelsea = document.getElementById('chelsea');
    var mu = document.getElementById('mu');
    var arsenal = document.getElementById('arsenal');
    if (mu.style.display === 'none')
    {
        mu.style.display = 'block';
        chelsea.style.display = 'none';
        arsenal.style.display = 'none';

    } else
        mu.style.display = 'none';
}
function showInfAboutArsenal()
{
    var chelsea = document.getElementById('chelsea');
    var mu = document.getElementById('mu');
    var arsenal = document.getElementById('arsenal');
    if (arsenal.style.display === 'none')
    {
        arsenal.style.display = 'block';
        chelsea.style.display = 'none';
        mu.style.display = 'none';
    } else
        arsenal.style.display = 'none';
}
function ValidMail() {
    var re = /^[\w-\.]+@[\w-]+\.[a-z]{2,4}$/i;
    var myMail = document.getElementById('email').value;
    var valid = re.test(myMail);
    document.getElementById('email').style.border = '1px solid black';
    output = '';
    if (!valid && myMail !== '') {
        output = '<br />Адрес электронной почты введен неправильно!';
        document.getElementById('email').style.border = '1px solid red';
    }
    else
        return true;
    document.getElementById('message').innerHTML = output;

    return valid;
}
function ValidForm() {
    var flag = true;
    var name = document.getElementById('name').value;
    var delivery = document.getElementById('delivery'); 
    document.getElementById('name').style.border = '1px solid black';
    document.getElementById('surname').style.border = '1px solid black';
    document.getElementById('phone').style.border = '1px solid black';
    delivery.style.border = '1px solid black';
    if (!name.replace(/^\s+|\s+$/g, '')) {
        flag = false;
        document.getElementById('name').style.border = '1px solid red';

    }
    var surname = document.getElementById('surname').value;
    if (!surname.replace(/^\s+|\s+$/g, '')) {
        flag = false;
        document.getElementById('surname').style.border = '1px solid red';
    }
    var phone = document.getElementById('phone').value;
    if (!phone.replace(/^\s+|\s+$/g, '')) {
        flag = false;
        document.getElementById('phone').style.border = '1px solid red';
    }
    
    if (delivery.value === "empty" ) {
        flag = false;
        document.getElementById('delivery').style.border = '1px solid red';
    }
    output = '';
    if (!flag)
        output = '<br />Заполните обязательные поля!';
    document.getElementById('message').innerHTML = output;
    return flag;
}
function ValidFormGoods() {
    var flag = true;
    var name = document.getElementById('nameGoods');
    var price = document.getElementById('price'); 
    var inf = document.getElementById('inf'); 
    name.style.border = '1px solid black';
    price.style.border = '1px solid black';
    inf.style.border = '1px solid black';   
    if (!name.value.replace(/^\s+|\s+$/g, '')) {
        flag = false;
        name.style.border = '1px solid red';

    }
   
    if (!price.value.replace(/^\s+|\s+$/g, '')) {
        flag = false;
        price.style.border = '1px solid red';
    }
   
    if (!inf.value.replace(/^\s+|\s+$/g, '')) {
        flag = false;
        inf.style.border = '1px solid red';
    }      
    output = '';
    if (!flag)
        output = '<br />Заполните обязательные поля!';
    document.getElementById('message').innerHTML = output;
    return flag;
}
function show(state, id) {

    document.getElementById(id).style.display = state;
    document.getElementById('wrap').style.display = state;
}

