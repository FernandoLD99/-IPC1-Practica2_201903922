
package practica2ipc;

import static practica2ipc.Practica2IPC.milisegundos;
import static practica2ipc.Practica2IPC.segundos;
import static practica2ipc.Practica2IPC.minutos;
import static practica2ipc.Practica2IPC.tiempo;

/**
 *
 * @author Fernando
 */
    public class Cronometro extends Thread {
    
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            milisegundos++;
            if (milisegundos > 1000) {
                segundos++;
                milisegundos = 0;
            }
            if (segundos > 60) {
                minutos++;
                segundos = 0;
            }
            tiempo.setText(String.valueOf(minutos) + ":" + String.valueOf(segundos) + ":" + String.valueOf(milisegundos));
        }
    }
    
  }

