
package practica2ipc;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import static practica2ipc.Pantalla.Redibujar;
import static practica2ipc.Pantalla.crearImagenOut;
import static practica2ipc.Practica2IPC.ArrayDatosX;
import static practica2ipc.Practica2IPC.ArrayDatosY;
import static practica2ipc.Practica2IPC.detener;
import static practica2ipc.Practica2IPC.pasos;


public class Insertion extends Thread{
   
    public JLabel Pasos;
    public boolean descendente;

    public Insertion(JLabel Pasos, boolean descendente) {
        this.Pasos = Pasos;
        this.descendente = descendente;
    }
    
    
    
     void sort(float arr[], String arr2[]) throws InterruptedException
    {
        
         int n = arr.length;  
        for (int j = 1; j < n; j++) {  
            float key = arr[j];
            String key2 = arr2[j];
            int i = j-1;  
            while ( (i > -1) && ( arr[i] > key ) ) {  
               // arr2[i+1] = arr2[i]; 
                arr[i+1] = arr[i];
                arr2[i+1] = arr2[i];
                i--;  
                Thread.sleep(1000);
                pasos++;
                Pasos.setText(pasos+"");
            }  
            arr[i+1] = key;
            arr2[i+1] = key2;
        }  
        /*int n = arr.length;
        for (int i = 1; i < n; ++i) {
            float key = arr[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position //
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                arr2[j + 1] = arr2[j];
                j = j - 1;
                 Thread.sleep(1000);
                 pasos++;
                 Pasos.setText(pasos+"");
                 
            }
            arr[j + 1] = key;
        }*/
            Redibujar();
    }
   
 
    
    void sort2(float arr[],String arr2[] ) throws InterruptedException
    {
            int n = arr.length;  
        for (int j = 1; j < n; j++) {  
            float key = arr[j];
            String key2 = arr2[j];
            int i = j-1;  
            while ( (i > -1) && ( arr[i] < key ) ) {  
               
                arr[i+1] = arr[i];
                arr2[i+1] = arr2[i];
                i--;  
                Thread.sleep(1000);
                pasos++;
                Pasos.setText(pasos+"");
            }  
            arr[i+1] = key;
            arr2[i+1] = key2;
            Redibujar();
        }  
        
    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
 
        System.out.println();
    }
    
     public  void run()
    {        
         pasos =0;

        
         try {
             if(!descendente){
             sort(ArrayDatosY, ArrayDatosX);
             }else{
            sort2(ArrayDatosY, ArrayDatosX);
             }
             
         } catch (InterruptedException ex) {
             Logger.getLogger(Burbuja.class.getName()).log(Level.SEVERE, null, ex);
         }
         detener = true;
         crearImagenOut();
 
        //printArray(arr);
    }

}
