package almundo.com.callcenter.util;

/**
 * Clase encargada acumular la cantidad de llamadas.
 */
public class CallCounter {

    private static int countCall = 0;

    /**
     * Suma uno al contador.
     */
    public static void add(){
        countCall++;
    }

    /**
     * Resta uno al contador.
     */
    public static void sustract(){
        countCall--;
    }

    /**
     * Obtiene la cantidad de llamadas.
     * @return cantidad de llamadas
     */
    public static int count(){
        return countCall;
    }
}
