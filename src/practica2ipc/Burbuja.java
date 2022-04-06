
package practica2ipc;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static practica2ipc.Pantalla.Redibujar;
import static practica2ipc.Pantalla.crearImagenOut;
import static practica2ipc.Practica2IPC.ArrayDatosX;
import static practica2ipc.Practica2IPC.ArrayDatosY;
import static practica2ipc.Practica2IPC.detener;
import static practica2ipc.Practica2IPC.pasos;


public class Burbuja extends Thread{
    
    public JLabel Pasos;
    public boolean descendente;
    
    
    public Burbuja(JLabel Pasos, boolean descendente) {
        this.Pasos = Pasos;
        this.descendente = descendente;
    }
    
    
     void bubbleSort(float arr[], String arr2[]) throws InterruptedException
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    float temp = arr[j];
                    String temp2 = arr2[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    arr2[j] = arr2[j+1];
                    arr2[j+1] = temp2;
                    Thread.sleep(500);
                    pasos++;
                    Pasos.setText(pasos+"");
                    Redibujar();
                    
                }
    }
     
     
      void bubbleSort2(float arr[], String arr2[]) throws InterruptedException
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] < arr[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    float temp = arr[j];
                    String temp2 = arr2[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    arr2[j] = arr2[j+1];
                    arr2[j+1] = temp2;
                    Thread.sleep(1000);
                    pasos++;
                    Pasos.setText(pasos+"");
                    Redibujar();
                    
                }
    } 
     void printArray(float arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
     
    public static int arr[] = new int[10];
    
     @Override
    public void run()
    {
        pasos = 0;

        
         try {
             if(!descendente){
             bubbleSort(ArrayDatosY, ArrayDatosX);
             }else{
             bubbleSort2(ArrayDatosY, ArrayDatosX);
             }
             
         } catch (InterruptedException ex) {
             Logger.getLogger(Burbuja.class.getName()).log(Level.SEVERE, null, ex);
         }
         detener = true;
         crearImagenOut();
        //System.out.println("Sorted array");
        //printArray(ArrayDatosY);
    }
}
