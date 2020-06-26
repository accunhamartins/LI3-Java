import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Query1 implements Serializable, Query1Interface {

    public Query1() {
    }

    /**
     * Método que trata da Query 1.
     *
     * @param mainStruct Objeto que possui os dados a analisar
     * @return Lista ordenada alfabeticamente dos produtos não comprados
     */
    public Set<String> getNoneBoughtProducts(MainStruct mainStruct) {
        Set<String> produtosNComprados = new TreeSet<>();
        Set<String> produtos = mainStruct.getCatalogoProduto().getCatalogoProdutos();
        Map<String,List<Venda>> venda = mainStruct.getFaturacao().getVendasPorProduto();



        for (String s : produtos) {
            if (!venda.containsKey(s)) produtosNComprados.add(s);
        }

        return produtosNComprados;
    }
}