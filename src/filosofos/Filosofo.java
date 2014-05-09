package filosofos;
 
 import java.lang.*;
 import java.util.Random;
 
public class Filosofo extends Thread {
     private int identificativo;
     private Tenedor izquierda;
     private Tenedor derecha;
     private Random random;
     private boolean izquierdatomado;
     private boolean derechatomado;
     private int elegido;
     private boolean flag;
     private boolean hambriento;
     private boolean quiereComer;
 
     //Constructor del objeto filosofo
     Filosofo(int identificativo_, Tenedor izquierda_, Tenedor derecha_) {
         identificativo=identificativo_;
         izquierda=izquierda_;
         derecha=derecha_;
         random = new Random();
         hambriento = false;
         quiereComer = false;
     }
     
     //metodo en el que el filosofo piensa de manera aleatoria
    public void pensar(){
        try{
            //mosttramos por pantalla el/los filosofos que se encuentra pensando
            System.out.println("Filosofo "+identificativo+" pensando...");
            System.out.println ("Esto es una prueba");
            this.sleep(10000); //para que el theard tenga un intervalo de 10 segundos
            hambriento = true; //variable que se sirve para que tiene hambre
            quiereComer = true; //variable que sirve para constar que quiere comer
        }catch(InterruptedException ie) {
        }
    }
    //metodo en el que el filosofo intenta comer
    public void hambriento(){
        try{
            // mostramos por pantalla el/los filosofos que se encuentra con hambre
             System.out.println("Filosofo "+identificativo+" hambriento...");

             this.sleep(10000); //el thread tiene un intervalo de 10 segundos
        }catch(InterruptedException ie) {
        }
    }
    //metodo en el que el filosofo se muestra comiendo y terminando
    public void comer(){
        try{
            //muestra por pantalla el/los filosofos que estan comiendo
            System.out.println("Filosofo "+identificativo+" comiendo...");

            this.sleep(10000); //el thread tiene intervalos de 10 segundos
            // muestra por pantalla el/los filosofos que han terminado de comer y los palillos libres
            System.out.println("Filosofo "+identificativo+" terminando de comer, libres palillos:"+izquierda.obtenerTenedor()+","+derecha.obtenerTenedor());

            hambriento = false; // variable booleana que recoge que ya no esta ambriento
            quiereComer = false; //variable booleana que recoge que no quiere comer

            }catch(InterruptedException ie){
            }
    }
    // metodo que consta con un bucle infinito
    public void run(){
        while(true){

            //si el filosofo no quuiere comer y no esta ambriento entonces pasara a pensar
            //en el caso contrario estara ambriento
            if(!quiereComer) {
                if(!hambriento) {
                    this.pensar();
                } 
                this.hambriento();   
            }

            flag=false;
            elegido=random.nextInt(2);

            if(elegido==0){
                //si no esta ocupado el tenedor de la izquierda lo cogera la variable
                //izquierdatomado pasara a verdadero
                if(!izquierda.esocupado()){
                    izquierda.tomar();
                    izquierdatomado=true;
                //si no esta ocupado el tenedor de la derecha el filosofo lo cogera 
                //la variable  booleana derechatomado pasara a verdadero
                } else if(!derecha.esocupado()){
                    derecha.tomar();
                    derechatomado=true;
                }
            //si no esta ocupado el tenedor de la derecha el filosofo lo cogera 
           //la variable  booleana derechatomado pasara a verdadero
            } else if(elegido==1){
                if(!derecha.esocupado()){
                    derecha.tomar();
                    derechatomado=true;
                }
                //si no esta ocupado el tenedor de la izquierda lo cogera la variable
                //izquierdatomado pasara a verdadero
                else if(!izquierda.esocupado()){
                    izquierda.tomar();
                    izquierdatomado=true;
                }
            }
            //si el tenedor de la izquierda es cogido y el de la derecha no esta ocupado
            //entonces cogerlo
            if(izquierdatomado==true){
            if(!derecha.esocupado()){
                derecha.tomar();
                derechatomado=true;
                flag=true;
            }else{
                izquierda.soltar();
                izquierdatomado=false;
            }
        }
            if(derechatomado==true && !flag){

                if(!izquierda.esocupado()){
                    izquierda.tomar();
                    izquierdatomado=true;
                }else{
                    derecha.soltar();
                    derechatomado=false;
                }
            }
            // si el tenedor de la derecha y izquierda los ha cogido el mismo filosofo
            // entonces come
            if(derechatomado && izquierdatomado){
                this.comer();
                elegido=random.nextInt(2);

                //despues de comer por el intervalo de 10 segundos el filosofo suelta los tenedores
                //tanto el izquierdo como el derecho
                if(elegido==0){
                    izquierda.soltar();
                    izquierdatomado=false;
                    derecha.soltar();
                    derechatomado=false;
                }else{
                    derecha.soltar();
                    derechatomado=false;
                    izquierda.soltar();
                    izquierdatomado=false;
                }
            }
        }
    }
}
 