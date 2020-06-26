
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Query4 implements Serializable, Query4Interface {

    public Query4(){}

    /**
     * Método que trata da Query 4.
     *
     * @param mainStruct Objeto que possui os dados a analisar
     * @param cod        Código do produto a analisar
     * @return Map que possui como key os meses e como values a informação pedida para a Querie 4 sobre o produto referente ao mês da key correspondente
     * @throws NoProductFoundException
     */
    public Map<Integer, Q4MonthInfo> productBougthByMonth(MainStruct mainStruct, String cod) throws NoProductFoundException {
        Map<String, List<Venda>> aux = mainStruct.getFaturacao().getVendasPorProduto();
        Map<Integer, Q4MonthInfo> ret = new TreeMap<>();
        
        for(int i = 1; i <= 12; i++){
            ret.put(i, new Q4MonthInfo());
        }

        if (!aux.containsKey(cod)) return null;

        else {
            for (Venda v : aux.get(cod)) {
                if (v.getProduto().equals(cod)) {
                    int quantidade = v.getQuantidade();
                    double lucro = quantidade * v.getPreco();
                    String cliente = v.getCliente();
                    Q4MonthInfo monthAux = ret.get(v.getMes());
                    monthAux.addCliente(cliente);
                    monthAux.addLucro(lucro);
                    monthAux.addQuantidade(1);

                    ret.put(v.getMes(), monthAux);
                }
            }
            return ret;
        }
    }
}
