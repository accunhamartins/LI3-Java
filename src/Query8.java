import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Query8 implements Serializable, Query8Interface {

    /**
     * Método que trata da Query 8.
     *
     * @param mainStruct Objeto que possui os dados a analisar
     * @return Set de Pair's em que o primeiro elemento do par é o cliente e o segundo é o número de produtos diferentes comprados por esse cliente
     */
    public Set<Pair> XClientsDiffProducts (MainStruct mainStruct){
        List<Venda> vendas = mainStruct.getFilial().getVendas().get(0);
        Set<Pair> lista = new TreeSet<>(new ComparaQuantidadePair());
        Map<String, Set<String>> res = new HashMap<>();
        for(Venda v: vendas){
            if (!res.containsKey(v.getCliente())) res.put(v.getCliente(), new TreeSet<>());
            res.get(v.getCliente()).add(v.getProduto());
        }

        for(String s: res.keySet()){
            Pair aux = new Pair();
            aux.setFst(s);
            aux.setSecond(res.get(s).size());
            lista.add(aux.clone());
        }
        return lista;
    }


}
