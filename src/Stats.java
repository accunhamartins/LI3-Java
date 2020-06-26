import java.io.Serializable;
import java.util.*;

public class Stats implements Serializable {

    /**
     * Método que trata da estatística sobre o total de comprars efetuadas por mês.
     *
     * @param mainStruct Objeto que possui os dados a analisar
     * @return Map em que as key são so meses e os values as compras efetuadas no mês correspondente
     */
    public static Map<Integer, Integer> totalBuysPerMonth(MainStruct mainStruct){
        Map<Integer, Integer> comprasPorMes = new HashMap<>();

        for(int i = 1; i <= 12; i++){
            comprasPorMes.put(i, 0);
        }

        List<Venda> totais = mainStruct.getFilial().getVendas().get(0);

        for(Venda v: totais){
            int quantidade = comprasPorMes.get(v.getMes()) + 1;
            comprasPorMes.put(v.getMes(), quantidade);
        }
        return comprasPorMes;
    }

    /**
     * Método que trata da estatística sobre a faturação total por mês de uma determinada filial.
     *
     * @param mainStruct Objeto que possui os dados a analisar
     * @param filial     Filial a ter em consideração
     * @return Map em que as key são os meses e os values a faturação no mês correspondente da filial indicada
     */
    public static Map<Integer, Double> totalProfit(MainStruct mainStruct, int filial){
        Map<Integer, Double> lucroPorMes = new HashMap<>();
        for(int i = 1; i <= 13; i++){
            lucroPorMes.put(i, 0.0);
        }
        List<Venda> totais = mainStruct.getFilial().getVendas().get(filial);

        for(Venda v: totais){
            double lucroMes = lucroPorMes.get(v.getMes()) + (v.getPreco() * v.getQuantidade());
            double lucroTotal = lucroPorMes.get(13) + (v.getPreco() * v.getQuantidade());
            lucroPorMes.put(v.getMes(), lucroMes);
            lucroPorMes.put(13, lucroTotal);
        }
        return lucroPorMes;
    }

    /**
     * Método que trata da estatística sobre o número de clientes distintos que efetuaram compras por mês numa determinada filial.
     *
     * @param mainStruct Objeto que possui os dados a analisar
     * @param filial     Filial a ter em consideração
     * @return Map em que as key são os meses e os values o número e clientes distintos que efetuaram compras no mês correspondente da filial indicada
     */
    public static Map<Integer, Set<String>> differentBuyers(MainStruct mainStruct,int filial){
        Map<Integer, Set<String>> clientes = new HashMap<>();
        for (int i = 1; i <= 12; i++){
            clientes.put(i, new HashSet<>());
        }
        List<Venda> totais = mainStruct.getFilial().getVendas().get(filial);

        for(Venda v: totais){
            String aux = v.getCliente();
            Set<String> cl = clientes.get(v.getMes());
            cl.add(aux);
            clientes.put(v.getMes(), cl);
        }
        return clientes;
    }

}
