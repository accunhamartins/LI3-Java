import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import static javax.swing.UIManager.put;

public class Query7 implements Serializable, Query7Interface {

    /**
     * Método que pega numa list de vendas e transofrma num map.
     *
     * @param f List com as vendas a
     * @return Map em que as key são os clientes e os values são o toal gasto por esse cliente.
     */
    private static Map<String, Double> branchSalesMap(List<Venda> f) {
        Map<String, Double> res = new HashMap<>();

        for (Venda v : f) {
            if (!res.containsKey(v.getCliente()))
                res.put(v.getCliente(), 0.0);
            res.computeIfPresent(v.getCliente(), (k, w) -> w + v.getTotal());
        }
        return res;
    }

    /**
     * Método que trata da Query 7.
     *
     * @param mainStruct Objeto que possui os dados a analisar
     * @return List com os Map respetivas de cada filial ao total gasto por cada cliente ordenados decrescentemente
     */
    public List<Map<String,Double>> Biggest3ClientsBranch(MainStruct mainStruct) {
        Map<Integer,List<Venda>> vendas = mainStruct.getFilial().getVendas();
        List<Map<String,Double>> filiais = new Vector<>();
        List<Map<String,Double>> filiais2 = new Vector<>();
        Map<String, Double> res;

        for(int i=1; i<=3; i++){
            res = branchSalesMap(vendas.get(i));
            filiais.add(res);
        }

        Map<String, Double> res2 = new HashMap<>();
        for(Map<String,Double> fil: filiais){
            res2 = sortByValues(fil);
            filiais2.add(res2);
        }

        return filiais2;
    }

    /**
     * Método que organiza um Map por ordem decrescente dos values.
     *
     * @param map Map a ser organizado
     * @param <K> Tipo das key
     * @param <V> Tipo dos values
     * @return Map organizado pelos values de forma decrescente
     */
    public static <K, V extends Comparable<V>> Map<K, V>
    sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator =
                new Comparator<K>() {
                    public int compare(K k1, K k2) {
                        int compare =
                                map.get(k1).compareTo(map.get(k2));
                        if (compare == 0)
                            return 1;
                        else
                            return -compare;
                    }
                };

        Map<K, V> sortedByValues =
                new TreeMap<>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }
}
