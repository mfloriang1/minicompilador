/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minicompilador;

public  class GRL  {
    String error = " ";
     final String IF="si";
     final String ELSE="sino";
     final String VARIABLE="definir";
     final String INT="entero";
     final String STRING = "texto";
     final String FLOAT = "mft";
     final String BOOLEAN="bool";
     final String READ="leer";
     final String CHAR="caracter";
     final String COUT="imprimir";
     final String SWITCH = "Seleccion";
     final String CASE = "opciones";
     final String WHILE = "simientras";
     final String FOR = "repetir_hasta_que"; 
     final String ASIGN="=";
     final String OPENSENT="{";
     final String CLOSESENT="}";
     final String OPENCON="(";
     final String CLOSECON=")";
     final String PLUS="+";
     final String MIN="-";
     final String IGIG="==";
     final String MyrIgual="<=";
     final String MnrIgual=">=";
     final String DELIMITADOR="#";
     final String COMILLAS="@";
      final String Menor="<";
     final String Mayor=">";
     
 
 public  boolean PalReservadas (String Palabras){
       
        switch(Palabras){
            case IF :return true; //1
            case ELSE: return true;//2
            case INT: return true;//3
            case STRING: return true;//4
            case COUT: return true;//5
            case SWITCH: return true;//6
            case CASE: return true;//7
            case WHILE: return true;//8
            case FOR: return true;//9
            case CHAR: return true;//10
            case BOOLEAN: return true;//11
            case FLOAT: return true;//12
            case READ: return true;//13
           
        }
        return false;
    }
  public boolean Numeros (String num){
        for(int i = 0; i < num.length(); i++){
            switch(num.charAt(i)){
                case '0' :
                    break;
                case '1' :
                    break;
                case '2' :
                    break;
                case '3' :
                    break;
                case '4' :
                    break;
                case '5' :
                    break;
                case '6' :
                    break;
                case '7' :
                    break;
                case '8' :
                    break;
                case '9' :
                    break;
                default :
                        return false;
            }
        }        
        return true;
    }
  public boolean ASIGNA(String asignacion){
      switch(asignacion){
          case ASIGN: return true;
      }
      return false;
  }
   public boolean OPArit (String operadores){
      switch(operadores){
          case PLUS: return true;
          case MIN: return true;
                  
      } 
       return false;
   }
    public boolean LetrasMinusculas (String letra){
        for(int i = 0; i < letra.length(); i++){
            switch(letra.charAt(i)){
                case 'a' :
                    break;
                case 'b' :
                    break;
                case 'c' :
                    break;
                case 'd' :
                    break;
                case 'e' :
                    break;
                case 'f' :
                    break;
                case 'g' :
                    break;
                case 'h' :
                    break;
                case 'i' :
                    break;
                case 'j' :
                    break;
                case 'k' :
                    break;
                case 'l' :
                    break;
                case 'm' :
                    break;
                case 'n' :
                    break;
                case 'o' :
                    break;
                case 'p' :
                    break;
                case 'q' :
                    break;
                case 'r' :
                    break;
                case 's' :
                    break;
                case 't' :
                    break;
                case 'u' :
                    break;
                case 'v' :
                    break;
                case 'w' :
                    break;
                case 'x' :
                    break;
                case 'y' :
                    break;
                case 'z' :
                    break;
                default :
                        return false;
            }
        }        
        return true;
    }
    
    public boolean LetrasMayusculas (String letra){
        for(int i = 0; i < letra.length(); i++){
            switch(letra.charAt(i)){
                case 'A' :
                    break;
                case 'B' :
                    break;
                case 'C' :
                    break;
                case 'D' :
                    break;
                case 'E' :
                    break;
                case 'F' :
                    break;
                case 'G' :
                    break;
                case 'H' :
                    break;
                case 'I' :
                    break;
                case 'J' :
                    break;
                case 'K' :
                    break;
                case 'L' :
                    break;
                case 'M' :
                    break;
                case 'N' :
                    break;
                case 'O' :
                    break;
                case 'P' :
                    break;
                case 'Q' :
                    break;
                case 'R' :
                    break;
                case 'S' :
                    break;
                case 'T' :
                    break;
                case 'U' :
                    break;
                case 'V' :
                    break;
                case 'W' :
                    break;
                case 'X' :
                    break;
                case 'Y' :
                    break;
                case 'z' :
                    break;
                default :
                        return false;
            }
        }        
        return true;
    }
     public boolean Identificador(String iden){
         error=" ";
         if(iden.length()<=20){
             if(!Numeros(""+iden.charAt(0))){
          for(int i=0;i<iden.length();i++){
             if(LetrasMayusculas(""+iden.charAt(i))||LetrasMinusculas(""+iden.charAt(i))&&Numeros(""+iden.charAt(i))){
                 
             }else{
                 //error+=("Lexico");
                 //error+=("El identificador Contiene Simbolos no aceptados por el lenguaje");
                 
                 return true;
             }
         }
           
          return true;
             }else{
                  
                     //error+=("Lexico");
                    
                     //error+=(" Identificador no valido porque la primera letra no puede ser un numero");
                     
                
                 return true;
             }
         }else{
             //error+=("Lexico");
             //error+=("El identificador se pasa del tamaño que es aceptado");
            
             
                 
             return true;
         }
     }
     public boolean abrircon(String open){
         switch(open){
           case OPENCON: return true;
       }
         return false;
     }
      public boolean cerrarcon(String close){
         switch(close){
           case CLOSECON: return true;
       }
         return false;
     }
   public boolean DELIMITADORMOI (String delimitador){
       switch(delimitador){
           case DELIMITADOR: return true;
       }
       return false;
   }
   public boolean OPre (String operadores){
       switch(operadores){
           case IGIG:return true;
           case MyrIgual:return true;
           case MnrIgual:return true;
           case Menor:return true;
           case Mayor:return true;
       }
       return false;
   }
    }
 


