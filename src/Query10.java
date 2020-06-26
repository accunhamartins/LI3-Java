import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Query10 implements Serializable, Query10Interface {

    public Query10(){}

    /**
     * Método que trata da Query 10.
     *
     * @param mainStruct Objeto que possui os dados a analisar
     * @return List das List's de cada mês com os Map de cada filial com os produtos como keys e o total faturado como values
     */
    public List<List<Map<String,Double>>> BillingByBranch(MainStruct mainStruct){
        List<Venda> aux = mainStruct.getFilial().getVendas().get(0);
        List<List<Map<String,Double>>> ret = new ArrayList<>();

        for(int i = 1; i <= 12; i++)
            ret.add(MonthInfo(aux, i));

        return ret;
    }

    /**
     * Método que tranforma a lista de vendas num map.
     *
     * @param vendas List de vendas
     * @return Map com as key como os produtos e como values o total faturado com o produto respetivo
     */
    private static Map<String,Double> SetMap(List<Venda> vendas) {
        Map<String, Double> res = new TreeMap<>();
        for (Venda v : vendas) {
            if (!res.containsKey(v.getProduto())) res.put(v.getProduto(), 0.0);
            res.computeIfPresent(v.getProduto(), (k, w) -> w + v.getTotal());
        }
        return res;
    }

    /**
     * Método que coloca as vendas todas de um dado mes numa List de Map onde o Map tem como key
     * os produtos e como values o total fatorado do produto respetivo, cada map esta associado a uma filial diferente.
     *
     * @param aux List de vendas
     * @param i   Mês a analisar
     * @return List dos Map's das filiais com o conteudo respetivo
     */
    private static List<Map<String,Double>> MonthInfo(List<Venda> aux, int i){
        List<Venda> month = aux.stream().filter(v -> v.getMes() == i).collect(Collectors.toList());
        List<Venda> month1 = month.stream().filter(v -> v.getFilial() == 1).collect(Collectors.toList());
        List<Venda> month2 = month.stream().filter(v -> v.getFilial() == 2).collect(Collectors.toList());
        List<Venda> month3 = month.stream().filter(v -> v.getFilial() == 3).collect(Collectors.toList());

        List<Map<String,Double>> ret = new ArrayList<>();

        Map<String,Double> p1 = SetMap(month1);
        Map<String,Double> p2 = SetMap(month2);
        Map<String,Double> p3 = SetMap(month3);

        ret.add(p1);
        ret.add(p2);
        ret.add(p3);



        return ret;
    }

}
