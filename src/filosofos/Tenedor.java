package filosofos;

/* Clase Tenedor */ 
public class Tenedor {
 
    private boolean ocupado=false;
    private int identificativo;
    
    Tenedor(int identificativo_){ 
        identificativo = identificativo_;
    }
    
    public int  obtenerTenedor() {   
        return identificativo;
    }
 
    /*Accion de soltar tenedor*/   
    synchronized void dejar(){
        ocupado=false;
        notify();
    } 
    
    /*Comprobar si el tenedor esta ocupado*/ 
    synchronized boolean esocupado(){
        if(ocupado){
            return true;
        }else{
            return false;
        }
    }

    /*Accion de coger el tenedor*/
    synchronized void tomar(){
        ocupado=true;
    }
    
    void soltar(){
        ocupado=false;
    }
}