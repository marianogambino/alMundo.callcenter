package almundo.com.callcenter.model;

import java.util.Random;

/**
 * Clase que representa una llamada telefonica.
 */
public class Call implements Runnable {

    private final String descripcion;
    private final String nroTelefono;

    private Random ran = new Random();

    public Call(String descripcion, String nroTelefono){
        this.descripcion = descripcion;
        this.nroTelefono = nroTelefono;
    }



    /**
     * Obtiene el nro de telefono.
     * @return un nro de telefono.
     */
    public String getNroTelefono() {
        return nroTelefono;
    }

    public String getDescripcion() {
        return descripcion;
    }



    public void run() {
        try {
            int x = (ran.nextInt(6) + 5 ) * 1000;
            Thread.sleep(x);
            System.out.print("Call " + this.descripcion + " finished ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "Call{" +
                "descripcion='" + descripcion + '\'' +
                ", nroTelefono='" + nroTelefono + '\'' +
                '}';
    }
}
