import java.io.Serializable;
import java.util.Comparator;

public class ComparaCliente implements Comparator<Venda>, Serializable {
    /**
     * Método que compara dois clientes.
     *
     * @param v1 Primeiro argumento da comparação
     * @param v2 Segundo arumento da comparação
     * @return Devolve o valor 0 se forem iguais, -1 se v1 for mais pequeno e 1 se v1 for o maior
     */
    public int compare(Venda v1, Venda v2){
        return (v1.getCliente().compareTo(v2.getCliente()));
    }
}
