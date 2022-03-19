function validarn(e){
    var teclado=(document.all)?e.keyCode: e.which;
    if(teclado==8) return true;
    var patron=/[0-9\d.]/;
    var codigo=String.fromCharCode(teclado);
    return patron.test(codigo);
}
function interes(){
    var plazo=parseFloat(document.formulario.plazo.value);
    var valor=document.formulario.cantidad.value;
    var resul=parseInt(valor);
    var interes=(resul*0.037*plazo)/12;
    var total=interes+resul;
    if(!Number.isInteger(plazo)){
        alert("No valido");
    }else{
        if(plazo<0){
            alert("El plazo que ingresaste no es valido.");
        }if(plazo<=48){
            document.formulario.sueldoI.value="$"+total;
        }else{
            alert("El plazo debe ser menor a 48 meses");
        }
    }    
}
function borrard(){
    document.formulario.cantidad.value="";
    document.formulario.sueldoI.value="";
    document.formulario.plazo.value="";
}
function borrard2(){
    document.form2.v1.value="";
    document.form2.v2.value="";
    document.form2.v3.value="";
    document.form2.sb.value="";
    document.form2.st.value="";
}
function borrard3(){
    document.form3.total.value="";
    document.form3.desc.value="";
    document.form3.tap.value="";
}
function borrard4(){
    document.form4.p1.value="";
    document.form4.p2.value="";
    document.form4.p3.value="";
    document.form4.cef.value="";
    document.form4.ctf.value="";
    document.form4.cf.value="";
}
function borrard5(){
    document.form5.h.value="";
    document.form5.m.value="";
    document.form5.ph.value="";
    document.form5.pm.value="";
}
function borrard6(){
    document.form6.d.value="";
    document.form6.select.value="Select";
    document.form6.a.value="";
    document.getElementById("salida").value="";
}
function validar_ventas(){
    var venta1=parseInt(document.form2.v1.value);
    var venta2=parseInt(document.form2.v2.value);
    var venta3=parseInt(document.form2.v3.value);
    var sb=parseInt(document.form2.sb.value);
    if(venta1<0 || venta2<0 || venta3<0 || sb<0){
        alert("Verifica los valores introducidos");
    }else{
        var comision=0.1*(venta1+venta2+venta3);
        document.form2.st.value="$"+(comision+sb);
    }
}
function validar_compra(){
    var compra=parseInt(document.form3.total.value);
    if(compra<0){
        alert("Verifica el valor de la compra");
    }else{
        var desc=0.15*compra;
        document.form3.desc.value="$"+desc;
        document.form3.tap.value="$"+(compra-desc);
    }
}
function validar_cals(){
    var p1=parseFloat(document.form4.p1.value);
    var p2=parseFloat(document.form4.p2.value);
    var p3=parseFloat(document.form4.p3.value);
    var cef=parseFloat(document.form4.cef.value);
    var ctf=parseFloat(document.form4.ctf.value);
    if(p1<0 || p2<0 || p3<0 || cef<0 || 
        ctf<0 || p1>10 || p2>10 || p3>10 || cef>10 || ctf>10){
        alert("Verifica la informacion introducida");
    }else{
        document.form4.cf.value=0.55*((p1+p2+p3)/3)+0.3*cef+0.15*ctf;
    }
}
function validar_c(){
    var hombres=parseFloat(document.form5.h.value);
    var mujeres=parseFloat(document.form5.m.value);
    var total=hombres+mujeres;
    if(hombres<0||mujeres<0||!Number.isInteger(hombres)||!Number.isInteger(mujeres)){
        alert("Verifica la informacion introducida");
    }else{
        document.form5.ph.value=(100*hombres)/total + "%";
        document.form5.pm.value=(100*mujeres)/total + "%";
    }
}
function validar_n(){
    var dia=parseFloat(document.form6.d.value);
    var año=parseFloat(document.form6.a.value);
    var mes=parseFloat(document.form6.select.value);
    var todoesvalido=true;
    fecha_actual=new Date();
    fecha_nac=new Date(año,mes-1,dia);
    if(!Number.isInteger(dia)||!Number.isInteger(mes)
    ||!Number.isInteger(año)||fecha_actual<fecha_nac){
        alert("No valido");
    }else{
        if(mes==1 && dia>=32){//enero
            alert("No valido");
            todoesvalido=false;
        }if(mes==2 && dia>=29 && año%4!=0){//febrero sin ser bisiesto
            alert("No valido");
            todoesvalido=false;
        }if(mes==2 && dia==29 && año%4==0 && año<=fecha_actual.getFullYear()){
            var años_cumplidos=0;
            //alert(años_bisiestos());
            if(fecha_actual.getMonth()==1
            && fecha_actual.getDate()==29){
                años_cumplidos=años_bisiestos();               
            }if(fecha_actual.getMonth()==1
            && fecha_actual.getDate()<29){
                años_cumplidos=años_bisiestos()-1;
            }if(fecha_actual.getMonth()>1){
                años_cumplidos=años_bisiestos();
                //alert(años_cumplidos);
            }if(fecha_actual.getMonth()<1){
                años_cumplidos=años_bisiestos()-1;
            }
            if(fecha_actual.getMonth()>fecha_nac.getMonth()){
                var meses=fecha_actual.getMonth()-fecha_nac.getMonth();
            }else if(fecha_actual.getMonth()<fecha_nac.getMonth()){
                var meses=12-(fecha_nac.getMonth()-fecha_actual.getMonth());
            }else if(fecha_actual.getMonth()==fecha_nac.getMonth()
            &&fecha_actual.getDate()>fecha_nac.getDate()
            ){
                var meses=0;
            }else{
                var meses=11;
            }
            document.form6.salida.value="Años: "+años_cumplidos+" Meses: "+meses
            +" Dias: "+fecha_actual.getDate();
            todoesvalido=false;
        }if(mes==2 && dia>29 && año%4==0){//febrero siendo bisiesto
            alert("No valido");
            todoesvalido=false;
        }if(mes==3 && dia>=32){//marzo
            alert("No valido");
            todoesvalido=false;
        }if(mes==4 && dia>=31){//abril
            alert("No valido");
            todoesvalido=false;
        }if(mes==5 && dia>=32){//mayo
            alert("No valido");
            todoesvalido=false;
        }if(mes==6 && dia>=31){//junio
            alert("No valido");
            todoesvalido=false;
        }if(mes==7 && dia>=32){//julio
            alert("No valido");
            todoesvalido=false;
        }if(mes==8 && dia>=32){//agosto
            alert("No valido");
            todoesvalido=false;
        }if(mes==9 && dia>=31){//sept
            alert("No valido");
            todoesvalido=false;
        }if(mes==10 && dia>=32){//oct
            alert("No valido");
            todoesvalido=false;
        }if(mes==11 && dia>=31){//nov
            alert("No valido");
            todoesvalido=false;
        }if(mes==12 && dia>=32){//dic
            alert("No valido");
            todoesvalido=false;
        }if(todoesvalido==true){
            //alert(fecha_actual.getMonth());
            //calcular años cumplidos
            var dif_años=fecha_actual.getFullYear()-fecha_nac.getFullYear();
            if(fecha_actual.getMonth()>fecha_nac.getMonth()){
                //alert(años);
                var años_cumplidos=dif_años;
            }if(fecha_actual.getMonth()<fecha_nac.getMonth()){
                //alert(años-1);
                var años_cumplidos=dif_años-1;
            }if(fecha_actual.getMonth()==fecha_nac.getMonth()
            &&fecha_actual.getDate()==fecha_nac.getDate()){
                //alert(años);
                var años_cumplidos=dif_años;
            }if(fecha_actual.getMonth()==fecha_nac.getMonth()
            &&fecha_actual.getDate()>fecha_nac.getDate()){
                //alert(años);
                var años_cumplidos=dif_años;
            }if(fecha_actual.getMonth()==fecha_nac.getMonth()
            &&fecha_actual.getDate()<fecha_nac.getDate()){
                //alert(años-1);
                var años_cumplidos=dif_años-1;
            }
            //calcular meses cumplidos
            if(fecha_actual.getMonth()>fecha_nac.getMonth()){
                var meses=fecha_actual.getMonth()-fecha_nac.getMonth();
            }else if(fecha_actual.getMonth()<fecha_nac.getMonth()){
                var meses=12-(fecha_nac.getMonth()-fecha_actual.getMonth());
            }else if(fecha_actual.getMonth()==fecha_nac.getMonth()
            &&fecha_actual.getDate()>fecha_nac.getDate()
            ){
                var meses=0;
            }else{
                var meses=11;
            }
            //calcular dias cumplidos
            var contador=0;
            for(i=fecha_nac.getFullYear();i<=fecha_actual.getFullYear();i++){
                if(i%4==0){
                    contador++;
                }else{}
            }
            var dias_meses=[31,28,31,30,31,30,31,31,30,31,30,31]
            var dias_cumplidos=dias_meses[fecha_actual.getMonth()]-fecha_nac.getDate()+fecha_actual.getDate()+contador;
            document.form6.salida.value="Tienes "+años_cumplidos+" años cumplidos, "+meses
            +" meses cumplidos, "+dias_cumplidos+" dias cumplidos contando años bisiestos";
           //alert(años_cumplidos+"/"+meses+"/"+(fecha_actual.getDate()+contador));
        }
    }
}
function años_bisiestos(){
    var contador=0;
    for(i=fecha_nac.getFullYear();i<=fecha_actual.getFullYear();i++){
        if(i%4==0){
            contador++;
        }
    }
    return contador;
}