function validarn(e){
    var teclado=(document.all)?e.keyCode: e.which;
    if(teclado==8) return true;
    var patron=/[0-9\d.]/;
    var codigo=String.fromCharCode(teclado);
    return patron.test(codigo);
}
function interes(){
    var plazo=document.formulario.plazo.value;
    var valor=document.formulario.cantidad.value;
    var resul=parseInt(valor);
    var interes=(resul*0.037*plazo)/12;
    var total=interes+resul;
    if(plazo<0){
        alert("El plazo que ingresaste no es valido.");
    }if(plazo<=48){
        document.formulario.sueldoI.value="$"+total;
    }else{
        alert("El plazo debe ser menor a 48 meses");
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
    var p1=parseInt(document.form4.p1.value);
    var p2=parseInt(document.form4.p2.value);
    var p3=parseInt(document.form4.p3.value);
    var cef=parseInt(document.form4.cef.value);
    var ctf=parseInt(document.form4.ctf.value);
    if(p1<0 || p2<0 || p3<0 || cef<0 || 
        ctf<0 || p1>10 || p2>10 || p3>10 || cef>10 || ctf>10){
        alert("Verifica la informacion introducida");
    }else{
        document.form4.cf.value=0.55*((p1+p2+p3)/3)+0.3*cef+0.15*ctf;
    }
}
function validar_c(){
    var hombres=parseInt(document.form5.h.value);
    var mujeres=parseInt(document.form5.m.value);
    var total=hombres+mujeres;
    if(hombres<0 || mujeres<0){
        alert("Verifica la informacion introducida");
    }else{
        document.form5.ph.value=(100*hombres)/total + "%";
        document.form5.pm.value=(100*mujeres)/total + "%";
    }
}
function validar_n(){
    var dia=parseInt(document.form6.d.value);
    var año=parseInt(document.form6.a.value);
    var mes=parseInt(document.form6.select.value);
    fecha_actual=new Date();
    if(dia<0||dia>31||año<0||año>fecha_actual.getFullYear){
        alert("Verifica la informacion introducida");
    }else{
        fecha_nac=new Date(año,mes,dia);
        if(fecha_actual<fecha_nac){
            alert("Introduza datos validos");
        }else{
            var años=fecha_actual.getFullYear()-fecha_nac.getFullYear();
            var meses=0;
            if(fecha_actual.getMonth()>fecha_nac.getMonth()){
                meses=fecha_actual.getMonth()-fecha_nac.getMonth();
            }else if(fecha_actual.getMonth()<fecha_nac.getMonth()){
                meses=12-(fecha_nac.getMonth()-fecha_actual.getMonth());
            }else if(fecha_actual.getMonth()==fecha_nac.getMonth() && 
            fecha_actual.getDate()>fecha_nac.getDate()){
                if(fecha_actual.getMonth()-fecha_nac.getMonth()==0){
                    meses=0;
                }else{
                    meses=11;
                }
            }
        }
        var m=parseInt(meses);
        var cuenta=0;
        for(i=fecha_nac.getFullYear();i<=fecha_actual.getFullYear();i++){
            if((i%4==0 && i%100!=0)||i%400==0){
                cuenta++;
                i+=3;
            }
        }
        var d=parseInt(fecha_actual.getDate());
        alert("A"+años+"/"+"M"+(m+1)+"/"+"D"+(d+cuenta));
    }
}