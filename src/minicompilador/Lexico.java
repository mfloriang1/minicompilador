/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minicompilador;

import java.util.ArrayList;
import java.util.LinkedList;

public class Lexico {
     String Recorrer=" ";
     String Error=" ";
              LinkedList <String> tokens =new LinkedList<>();//da la posibilidad de aggregar algo en tal posisicon como el arraylist 

    public String Lexico (String codigo){
        
    GRL gramatica= new GRL();
        codigo=codigo.replace('\n', ' ');
        int contador=0;
        int posicion=0; //posision de la lista
     
        do {
            String aux="";
            if(contador!=codigo.length()){
            for(contador=contador; contador<codigo.length() && codigo.charAt(contador)!=' '; contador++)//si encuentra un caracter recorre hasta encotrar un espacio
            {
               
               aux+=codigo.charAt(contador);//auxiliar se concatena con la siguiente letra
               
            }
            
            tokens.add(aux);
            }
       
            while(contador<codigo.length()&& codigo.charAt(contador)==' '){
            contador++;
        }
        }while(contador<codigo.length());
        //String finalx="";
        for(String recorrer: tokens){
          
            System.out.println("objeto  "+recorrer);
           if(gramatica.PalReservadas(recorrer)){
               Recorrer+=recorrer+"-- palabra reservada reconocida por el lenguaje\n";
           }else if(gramatica.OPArit(recorrer)){
             Recorrer+=recorrer+"-- operador aritmetico reconocido por el lenguaje\n";       
           }else if(gramatica.OPre(recorrer)){
            Recorrer+=recorrer+"-- operador relacional reconocido por el lenguaje\n";
           }else if(gramatica.ASIGNA(recorrer)){
            Recorrer+=recorrer+"-- asignacion reconocida por el lenguaje\n" ;
           }else if(gramatica.DELIMITADORMOI(recorrer)){
               Recorrer+=recorrer+"-- delimitador reconocido por el lenguaje\n";  
           }else if(gramatica.Numeros(recorrer)){
                 Recorrer+=recorrer+"-- constante numerica reconocida por el lenguaje\n";
           }else if(gramatica.abrircon(recorrer)){
                 Recorrer+=recorrer+"-- parentesis para abrir condicion reconocida por el lenguaje\n";     
        }else if(gramatica.cerrarcon(recorrer)){
                 Recorrer+=recorrer+"-- parentesis para cerrar condicion reconocida por el lenguaje\n";     
        }else if(gramatica.COMILLAS.equals(recorrer)){
                Recorrer+=recorrer+"-- simbolo reconocido por el lenguaje\n"; 
           }else if(gramatica.Identificador(recorrer)){
            Recorrer+=recorrer+"-- identificador reconocido por el lenguaje\n";
           }
        }
        return Recorrer;
        
    }
    
    
}
