/*
Vamos a hacer una funcion que se encarge de validar la entrada de numeros
por medio de una expresion regular
*/
function validar(e){
    var teclado=(document.all)?e.keyCode: e.which;
    if(teclado==8) return true;
    var patron=/[0-9\d.]/;
    var codigo=String.fromCharCode(teclado);
    return patron.test(codigo);
}