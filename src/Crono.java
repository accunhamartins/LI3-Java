
import java.io.Serializable;

import static java.lang.System.nanoTime;

public class Crono implements Serializable {

    private static long inicio = 0L;
    private static long fim = 0L;

    /**
     * Método que dá inicio a uma contagem de tempo.
     */
    public static void start() {
        fim = 0L; inicio = nanoTime();
    }

    /**
     * Método que para a contagem do tempo e o contabiliza.
     *
     * @return Tempo que passou desde que o início foi dado, em segundos
     */
    public static double stop() {
        fim = nanoTime();
        long elapsedTime = fim - inicio;
        // segundos
        return elapsedTime / 1.0E09;
    }

    /**
     * Método que passa o tempo passado para uma String.
     *
     * @return String do empo que passou
     */
    public static String getTime() {
        return "" + stop();
    }

    /**
     * Mensagem a ser mostrada ao utilizador do tempo que cada querie demorou a ser executada.
     *
     * @return String com o resultado do tempo
     */
    public static String getTImeString() {
        return "-------RESULTS-------\nElapsed Time: " + getTime() + " s";
    }
}