
package practica2ipc;

import javax.swing.JLabel;
import static practica2ipc.Practica2IPC.detener;
import static practica2ipc.Practica2IPC.milisegundos;
import static practica2ipc.Practica2IPC.segundos;
import static practica2ipc.Practica2IPC.minutos;


/**
 *
 * @author Fernando
 */
    public class Cronometro extends Thread {
    public JLabel temporizador;

    public Cronometro(JLabel temporizador) {
        this.temporizador = temporizador;
    }
    
    
    @Override
    public void run() {
        detener = false;
        while (!detener) {
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
            temporizador.setText(String.valueOf(minutos) + ":" + String.valueOf(segundos) + ":" + String.valueOf(milisegundos));
        }
    }
    
  }

