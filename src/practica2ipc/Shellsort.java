/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


public class Shellsort extends Thread {
  
    public JLabel Pasos;
    public boolean descendente;

    public Shellsort(JLabel Pasos, boolean descendente) {
        this.Pasos = Pasos;
        this.descendente = descendente;
    }
    
    
    
    int sort(float arr[], String arr2[]) throws InterruptedException
    {
        int n = arr.length;
 
        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {
         
            for (int i = gap; i < n; i += 1)
            {
                float temp = arr[i];
                String temp2 = arr2[i];
 
               
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap){
                    arr[j] = arr[j - gap];
                    arr2[j] = arr2[j - gap];
                }
                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
                arr2[j] = temp2;
                 Thread.sleep(1000);
                    pasos++;
                    Pasos.setText(pasos+"");
                    Redibujar();
                    for(float numero: arr){
                     System.out.print(numero + " ");
                 }System.out.println("");
            }
        }
        return 0;
    }
    
    int sort2(float arr[], String arr2[]) throws InterruptedException
    {
        int n = arr.length;

        for (int gap = n/2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i += 1)
            {
                float temp = arr[i];
                String temp2 = arr2[i];
 
                int j;
                for (j = i; j <= gap && arr[j - gap] < temp; j -= gap){
                    arr[j] = arr[j - gap];
                    arr2[j] = arr2[j - gap];
                }
 
                arr[j] = temp;
               arr2[j] = temp2;
                 Thread.sleep(1000);
                 pasos++;
                 Pasos.setText(pasos+"");
                 Redibujar();
                 for(float numero: arr){
                     System.out.print(numero + " ");
                 }System.out.println("");
            }
        }
        return 0;
    }
  
   
    @Override
    public void run()
    {
        
       pasos = 0;

        
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
    
       
    }

    
    
}
