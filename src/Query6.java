import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Query6 implements Serializable, Query6Interface {

    public Query6(){
    }

    /**
     * Método que trata de parte da Query 6.
     *
     * @param mainStruct Objeto que possui os dados a analisar
     * @return SortedSet com os produtos mais vendidos
     */
    public SortedSet<Map.Entry<String, Integer>> getProductsMostSells(MainStruct mainStruct){
        Map<String,Integer> res = new TreeMap<>();
        Map<String,List<Venda>> vendas = mainStruct.getFaturacao().getVendasPorProduto();
        Set<String> produtos = mainStruct.getCatalogoProduto().getCatalogoProdutos();

        for(String p : produtos) {
            if (vendas.containsKey(p)) {
                for (Venda v : vendas.get(p)) {
                    String produto = v.getProduto();
                    Integer unidadesVendidas = v.getQuantidade();
                    if (!res.containsKey(produto)) {
                        res.put(produto, unidadesVendidas);
                    } else {
                        res.put(produto, res.get(produto) + unidadesVendidas);
                    }
                }
            }
        }

        return sortedByValues(res);
    }

    /**
     * Método que faz com que um Map se reorganize de forma decrescente pelos values num SortedSet.
     *
     * @param map Map a ser reorganizado
     * @param <K> Tipo dos dados das Keys
     * @param <V> Tipo dos dados dos Values
     * @return SortedSet do Map ordenado de forma decrescente pelo conteudo dos values
     */
    static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> sortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<>((e1, e2) -> {
            int res = e2.getValue().compareTo(e1.getValue());
            return res != 0 ? res : 1;
        }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

    /**
     * Método que trata de parte da Query6.
     *
     * @param mainStruct Objeto que possui os dados a analisar
     * @return Map com os produtos como keys e com os clientes que compram o produto correspondente como values
     */
    public Map<String, Set<String>> getDiferentsBuyers (MainStruct mainStruct){
        Map<String,List<Venda>> vendas = mainStruct.getFaturacao().getVendasPorProduto();
        Set<String> produtos = mainStruct.getCatalogoProduto().getCatalogoProdutos();
        Map<String, Set<String>> ret = new TreeMap<>();

        for(String p : produtos) {
            if (vendas.containsKey(p)) {
                for (Venda v : vendas.get(p)) {
                    String produto = v.getProduto();
                    String cliente = v.getCliente();
                    if (!ret.containsKey(produto)) ret.put(produto, new TreeSet<>());

                    ret.get(produto).add(cliente);
                    }
                }
            }

        return ret;
        }
    }

