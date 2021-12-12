$(document).ready(function () {

    var myList = [{"goFrom" : "addres1", "goTo" : "addres11", "distance": "15", "price" : "75", "created": "20.12.12"},
        {"goFrom" : "addres2", "goTo" : "addres22", "distance": "15", "price" : "75", "created": "20.12.12"},
        {"goFrom" : "addres3", "goTo" : "addres33", "distance": "15", "price" : "75", "created": "20.12.12"},
        {"goFrom" : "addres4", "goTo" : "addres33", "distance": "15", "price" : "75", "created": "20.12.12"},
        {"goFrom" : "addres5", "goTo" : "addres33", "distance": "15", "price" : "75", "created": "20.12.12"},
        {"goFrom" : "addres6", "goTo" : "addres33", "distance": "15", "price" : "75", "created": "20.12.12"},
        {"goFrom" : "addres7", "goTo" : "addres33", "distance": "15", "price" : "75", "created": "20.12.12"},
        {"goFrom" : "addres8", "goTo" : "addres33", "distance": "15", "price" : "75", "created": "20.12.12"},
        {"goFrom" : "addres9", "goTo" : "addres33", "distance": "15", "price" : "75", "created": "20.12.12"},
        {"goFrom" : "addres10", "goTo" : "addres33", "distance": "15", "price" : "75", "created": "20.12.12"},
        {"goFrom" : "addres11", "goTo" : "addres33", "distance": "15", "price" : "75", "created": "20.12.12"},
        {"goFrom" : "addres12", "goTo" : "addres33", "distance": "15", "price" : "75", "created": "20.12.12"},
        {"goFrom" : "addres13", "goTo" : "addres33", "distance": "15", "price" : "75", "created": "20.12.12"},
        {"goFrom" : "addres14", "goTo" : "addres33", "distance": "15", "price" : "75", "created": "20.12.12"},
        {"goFrom" : "addres15", "goTo" : "addres33", "distance": "15", "price" : "75", "created": "20.12.12"},
        {"goFrom" : "addres16", "goTo" : "addres33", "distance": "15", "price" : "75", "created": "20.12.12"},
        {"goFrom" : "addres17", "goTo" : "addres33", "distance": "15", "price" : "75", "created": "20.12.12"},
        {"goFrom" : "addres18", "goTo" : "addres33", "distance": "15", "price" : "75", "created": "20.12.12"},
        {"goFrom" : "addres19", "goTo" : "addres33", "distance": "15", "price" : "75", "created": "20.12.12"}
    ];
    loadOrders(myList);
     $("tr").click(function (){
        chooseOrder($(this));
    });
    
});

function loadOrders(orderList) {

    for (var i = 0; i< orderList.length; i++){
        var row$ = $('<tr/>');
        row$.append($('<td/>').html(orderList[i].goFrom));
        row$.append($('<td/>').html(orderList[i].goTo));
        row$.append($('<td/>').html(orderList[i].distance));
        row$.append($('<td/>').html(orderList[i].price));
        row$.append($('<td/>').html(orderList[i].created));
        $("#order-table").append(row$);
    }
}

function chooseOrder(row$) {

    alert(row$.children().first().text());

}
    