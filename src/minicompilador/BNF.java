/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minicompilador;

import java.util.LinkedList;

public class BNF {
      String lineaux[];
      String errores= "";
      String mostrar = "";
      Lexico lx = new Lexico();
      GRL gramatica = new GRL();
       LinkedList <String> token=new LinkedList<>();
    public void Sintactico (String codigo){     
       // boolean evaluador=false;
       
       lineaux=codigo.split("\n");
      
       //String reconoce="";
       int cont=0;
        for (int i = 0; i < lineaux.length; i++) {
            do{
                String aux="";
                if(cont!=codigo.length()){
                    for(cont=cont; cont<codigo.length() &&codigo.charAt(cont)!=' ';cont++)
                    {
                    aux+=codigo.charAt(cont);
                    if((cont+1)<codigo.length()&&codigo.charAt(cont)=='"')
                    {
                            aux+=codigo.charAt(cont);
                        }
                        if(cont<codigo.length()&&codigo.charAt(cont)=='"')
                        {
                            aux+=codigo.charAt(cont);
                        }
                        cont++;
                        for(cont=cont;cont<codigo.length()&&codigo.charAt(cont)!='"';cont++)
                        {
                    }
                }
                }
                token.add(aux);
                while(cont<codigo.length()&&codigo.charAt(cont)==' '){
                cont++;
            }
            }while(cont<codigo.length());
            if(escanearVN(token))
                {
                    mostrar+="Linea sintacticamente correcta "+lineaux[i]+"\n";
                }else if(escanearVS(token)){
                     mostrar+="Linea sintacticamente correcta "+lineaux[i]+"\n"; 
                }else if(escanearVE(token)){
               mostrar+="Linea sintacticamente correcta "+lineaux[i]+"\n";
                }
                else if(escanearVC(token)){    
                      mostrar+="Linea sintacticamente correcta "+lineaux[i]+"\n";
                }else if(escanerif(token)){
                      mostrar+="Linea sin\n" +
"    }tacticamente correcta "+lineaux[i]+"\n";
                }else if(imprimirfr(token)){
                     mostrar+="Linea sintacticamente correcta "+lineaux[i]+"\n";
                }
                else{
                errores+="linea sintacticamente incorrecta";
              }
            }
    }
    
      public void limpiartoken(){
          token.clear();
      }         
   
    //Creacion y asignacion de variables de tipo entero,float

   private boolean escanearVE(LinkedList<String> creacion) {
        if(creacion.size()==5){
            if(creacion.get(0).equals(gramatica.INT)||creacion.get(0).equals(gramatica.FLOAT)&&gramatica.Identificador(creacion.get(1))&&gramatica.ASIGNA(creacion.get(2))&&gramatica.Numeros(creacion.get(3))&&gramatica.DELIMITADORMOI(creacion.get(4))){
            
                return true;
            }else{
               // errores+=" sintaxis incorrecta para creacion y asignacion de variables de tipo entero\n";
                return true;
            }
        }  
        return false;
       
    }
   //creacion de variables sin asignar valor
    private boolean escanearVN(LinkedList<String> creacion) {
        if(creacion.size()==3){
            if(creacion.get(0).equals(gramatica.INT)||creacion.get(0).equals(gramatica.FLOAT)&&gramatica.Identificador(creacion.get(1))&&gramatica.DELIMITADORMOI(creacion.get(2))){
            
                return true;
            }else{
               // errores+=" sintaxis incorrecta para creacion y asignacion de variables de tipo entero\n";
                return true;
            }
        }  
        return false;
       
    }
    private boolean escanearVS(LinkedList<String> creacion) {
        if(creacion.size()==3){
            if(creacion.get(0).equals(gramatica.STRING)&&gramatica.Identificador(creacion.get(1))){
            } if(creacion.get(2).equals(gramatica.DELIMITADOR)){
                return true;
            }else{
               // errores+=" sintaxis incorrecta para creacion y asignacion de variables de tipo entero\n";
                return true;
            }
            }
        
        return false;
       
    }
   
   //Creacion de variables de tipo char y asignacion de valores
  private boolean escanearVC(LinkedList<String> creacion){
       if(creacion.size()==5){
            if(creacion.get(0).equals(gramatica.CHAR)&&gramatica.Identificador(creacion.get(1))&&gramatica.ASIGNA(creacion.get(2))&&gramatica.LetrasMinusculas(creacion.get(3))||gramatica.LetrasMayusculas(creacion.get(3))&&gramatica.DELIMITADORMOI(creacion.get(4))){
            
                return true;
            }else{
                //errores+=" sintaxis incorrecta para creacion y asignacion de variables de tipo string\n";
                return true;
            }
        }  
       return false;
   }
   private boolean escanearVSV(LinkedList<String> creacion) {
        if(creacion.size()==7){
            if(creacion.get(0).equals(gramatica.STRING)&&gramatica.Identificador(creacion.get(1))&&gramatica.ASIGNA(creacion.get(2))&&creacion.get(3).equals(gramatica.COMILLAS)&&gramatica.Identificador(creacion.get(4))&&creacion.get(5).equals(gramatica.COMILLAS)&&gramatica.DELIMITADORMOI(creacion.get(6))){
            
                return true;
            }else{
               // errores+=" sintaxis incorrecta para creacion y asignacion de variables de tipo entero\n";
                return true;
            }
        }  
        return false;
       
    }
//creacion de 
   private boolean escanerif(LinkedList<String> creacion){
       if(creacion.size()==6){
           if(creacion.get(0).equals(gramatica.IF)&&gramatica.abrircon(creacion.get(1))){
               return true;
           }
            if(gramatica.Numeros(creacion.get(2))&&gramatica.OPre(creacion.get(3))&&gramatica.Numeros(creacion.get(4))&&gramatica.cerrarcon(creacion.get(5))){
                return true;
            }
            else if(gramatica.LetrasMinusculas(creacion.get(2))&&gramatica.OPre(creacion.get(3))&&gramatica.LetrasMinusculas(creacion.get(4))&&gramatica.cerrarcon(creacion.get(5)))
               return true;
       }
  return false;
   }     
   private boolean imprimirfr(LinkedList<String> creacion){
       if(creacion.size()==5){
            if(creacion.get(0).equals(gramatica.COUT)&&creacion.get(1).equals(gramatica.COMILLAS)&&gramatica.Identificador(creacion.get(2))&&creacion.get(3).equals(gramatica.COMILLAS)&&gramatica.DELIMITADORMOI(creacion.get(4))){
            
                return true;
            }else{
                //errores+=" sintaxis incorrecta para creacion y asignacion de variables de tipo string\n";
                return true;
            }
        }  
       return false;
   }
   private boolean leerfr(LinkedList<String> creacion){
       if(creacion.size()==3){
           if(creacion.get(0).equals(gramatica.READ)&&gramatica.Identificador(creacion.get(1))&&gramatica.DELIMITADORMOI(creacion.get(2)))
               return true;
       }else{
           return true;
       }
       return false;
   }
   }
