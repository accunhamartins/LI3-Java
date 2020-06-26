import java.io.IOException;
import java.io.Serializable;

public class GestVendasMVCApp implements Serializable {

    /**
     * Método main do programa.
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        GestAppController controller = new GestAppController();
        GestAppView view = new GestAppView();
        controller.setView(view);
        controller.fileChoice();
        controller.mainFlow();
        System.out.println("Saindo do programa...");
    }
}
