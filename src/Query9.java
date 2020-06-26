import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Query9 implements Serializable, Query9Interface {

    public Query9(){}

    /**
     * Método que trata de parte da Query 9.
     *
     * @param mainStruct Objeto que possui os dados a analisar
     * @param y          Código do produto a analisar dado pelo utilizador
     * @return Map ordenado de forma decrescente dos values em que as key são os clientes e o value a quantidade de unidades compradas pelo cliente correspondente
     * @throws NoProductFoundException
     */
    public Map<String, Double> getXBetterClientsOfProductY(MainStruct mainStruct, String y) throws NoProductFoundException {
        Map<String, List<Venda>> aux = mainStruct.getFaturacao().getVendasPorProduto();
        if (!aux.containsKey(y)) return null;
        else {
            List<Venda> vendas = aux.get(y).stream().sorted(new ComparaCliente()).collect(Collectors.toList());

            Map<String, Double> res = new TreeMap<>();
            for (Venda v : vendas) {
                if (!res.containsKey(v.getCliente())) res.put(v.getCliente(), 0.0);
                res.computeIfPresent(v.getCliente(), (k, w) -> w + v.getQuantidade());
            }

            Map<String, Double> clientes = sortByValues(res);
            return clientes;
        }
    }


    /**
     * Método que trata de parte da Query 9.
     *
     * @param mainStruct Objeto que possui os dados a analisar
     * @param y          Código do produto a analisar dado pelo utilizador
     * @return Map que tem como key os clientes e como value o total gasto na compra do produto dado pelo cliente correspondente
     * @throws NoProductFoundException
     */
    public Map<String, Double> getXBetterClientsOfProductYFat(MainStruct mainStruct, String y) throws NoProductFoundException {
        Map<String, List<Venda>> aux = mainStruct.getFaturacao().getVendasPorProduto();
        if (!aux.containsKey(y)) return null;
        else {
            List<Venda> vendas = aux.get(y).stream().sorted(new ComparaCliente()).collect(Collectors.toList());

            Map<String, Double> res = new TreeMap<>();
            for (Venda v : vendas) {
                if (!res.containsKey(v.getCliente())) res.put(v.getCliente(), 0.0);
                res.computeIfPresent(v.getCliente(), (k, w) -> w + v.getTotal());
            }

            return res;
        }
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
