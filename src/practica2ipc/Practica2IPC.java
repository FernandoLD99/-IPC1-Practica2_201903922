
package practica2ipc;

import javax.swing.JLabel;
import static practica2ipc.Burbuja.arr;

public class Practica2IPC {

   public static float[] ArrayDatosY;
   public static String[] ArrayDatosX;
   public static int milisegundos;
   public static int segundos;
   public static int minutos;
   public static boolean detener;
   public static int pasos;
   public static String imagenIn;
   public static String imagenOut;
   
  
    
    public static void main(String[] args) {
        int[] arreglo = {1,2,3,4,5,6,7,8,9,2};
        arr = arreglo;     
        
        milisegundos = 0;
        segundos = 0;
        minutos = 0;
        
        Pantalla p = new Pantalla();
        p.setVisible(true);
        
        
        
        
    }
   
    
    
}
