package filosofos;

import java.util.concurrent.*;
import java.util.Random;

/*Clase Principal del programa*/
 
public class Main{
    
    public static void main( String args[] ) {
        
        Tenedor tenedor[]=new Tenedor[5];
        
        /*Instancias de los 5 tenedores */
        tenedor[0]=new Tenedor(1);
        tenedor[1]=new Tenedor(2);
        tenedor[2]=new Tenedor(3);
        tenedor[3]=new Tenedor(4);
        tenedor[4]=new Tenedor(5);
        
        Filosofo filosofo[]=new Filosofo[5];
 
        /*instancias de los cinco filosofos*/
        filosofo[0]=new Filosofo(1,tenedor[0],tenedor[4]);
        filosofo[1]=new Filosofo(2,tenedor[1],tenedor[0]);
        filosofo[2]=new Filosofo(3,tenedor[2],tenedor[1]);
        filosofo[3]=new Filosofo(4,tenedor[3],tenedor[2]);
        filosofo[4]=new Filosofo(5,tenedor[4],tenedor[3]);

        /*Comienza la ejecucion de los filosofos*/
        filosofo[0].start();
        filosofo[1].start();
        filosofo[2].start();
        filosofo[3].start();
        filosofo[4].start();
    } 
}
 

