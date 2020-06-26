import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Query5 implements Serializable, Query5Interface {

    public Query5(){}

    /**
     * Método que trata da Querie 5.
     *
     * @param mainStruct Objeto que possui os dados a analisar
     * @param cod        Código do cliente a analisar
     * @return Lista com os códigos dos produtos mais comprados pelo cliente dado ordenados de forma decrescente
     * @throws NoClienteFoundException
     */
    public List<Venda>  mostBoughtByClient(MainStruct mainStruct, String cod) throws NoClienteFoundException {
        Map<String, List<Venda>> aux = mainStruct.getFilial().getVendasPorCliente();
        if (!aux.containsKey(cod)) return null;
        else {
            List<Venda> vendas = aux.get(cod).stream().sorted(new ComparaQuantidade()).collect(Collectors.toList());
            return vendas;
        }
    }
}
