import java.io.Serializable;
import java.util.Comparator;

public class ComparaQuantidade implements Comparator<Venda>, Serializable {

    /**
     * Método que compara duas vendas na dimensão quantidade.
     *
     * @param v1 Primeiro argumento da comparação
     * @param v2 Segundo argumento da comparação
     * @return Diferença entre a quantidade das duas vendas
     */
    public int compare(Venda v1, Venda v2) {
        if(v1.getQuantidade() == v2.getQuantidade()) return (v1.getProduto().compareTo(v2.getProduto()));
        else return v2.getQuantidade() - v1 .getQuantidade();
    }
}
