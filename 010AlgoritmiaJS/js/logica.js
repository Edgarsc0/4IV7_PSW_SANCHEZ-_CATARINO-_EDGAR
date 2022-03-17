function problema1(){
    var p1_input=document.querySelector('#p1-input').value;
    var palabra=p1_input.split(" ");
    cadena_invertida=[];
    for(i=0;i<palabra.length;i++){
        cadena_invertida.push(invertir(palabra[i]));
    }
    document.querySelector('#p1-output').textContent="";
    for(i=0;i<cadena_invertida.length;i++){
        document.querySelector('#p1-output').textContent+='Palabra: '+palabra[i]+'= '+cadena_invertida[i]+'\n';
    }
    //alert(cadena_invertida);
    function invertir(cadena){
        return cadena.split("").reverse().join("");
    }
    //alert(invertir(p1_input));
}
function problema3(){
    var alfabeto=['A','B','C','D','E','F','G'
    ,'H','I','J','K','L','M','N','Ñ','O','P','Q','R','S'
    ,'T','U','V','W','X','Y','Z']
    var p3_input=document.querySelector('#p3-input').value;
    var p3_palabras=p3_input.split(',');
    p3_palabras=p3_palabras.map(function (palabra){
        return palabra.replace(/\s/g,'').toUpperCase();
    });
    var p3_res='';
    p3_palabras.forEach(function (palabra,i){
        var letras_unicas=[];
        var palabra_array=palabra.split('');
        alfabeto.forEach(function (letra,j){
            palabra_array.forEach(function (letra_palabra,k){
                if(letra_palabra==letra){
                    if(letras_unicas.indexOf(letra)<0){
                        letras_unicas.push(letra);
                    }
                }
            });
        });
        p3_res+='Palabra: '+palabra+'='+letras_unicas.length+'\n';
    });
    document.querySelector('#p3-output').textContent=p3_res;
}
function problema2(){
    var x1=parseInt(document.querySelector('#p2-x1').value);
    var x2=parseInt(document.querySelector('#p2-x2').value);
    var x3=parseInt(document.querySelector('#p2-x3').value);
    var x4=parseInt(document.querySelector('#p2-x4').value);
    var x5=parseInt(document.querySelector('#p2-x5').value);
    var y1=parseInt(document.querySelector('#p2-y1').value);
    var y2=parseInt(document.querySelector('#p2-y2').value);
    var y3=parseInt(document.querySelector('#p2-y3').value);
    var y4=parseInt(document.querySelector('#p2-y4').value);
    var y5=parseInt(document.querySelector('#p2-y5').value);
    var A=[x1,x2,x3,x4,x5];
    var B=[y1,y2,y3,y4,y5];
    var ppAB=0;
    var ppab=0;
    var suma1=0;
    for(i=0;i<=4;i++){
        suma1+=A[i]*B[i];
    }
    ppAB=suma1;
    var C=A.reverse();
    var suma2=0;
    for(i=0;i<=4;i++){
        suma2+=C[i]*B[i];
    }
    ppab=suma2;
    if(ppab>ppAB){
        document.querySelector('#p2-output').textContent="El menor producto escalar es: X.Y= "+ppAB;
    }else{
        document.querySelector('#p2-output').textContent="El menor producto escalar es: X^-1 . Y= "+ppab;
    }
}
