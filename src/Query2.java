import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Query2 implements Serializable, Query2Interface {

    public Query2(){
    }

    /**
     * Método que trata da Query 2.
     *
     * @param mes          Mes a ter em conta na análise
     * @param filial       Filial a ter em conta na análise, 0 corresponde aos valores gerais
     * @param mainStruct   Objeto que possui os dados a analisar
     * @return Map em que as keys são os diferentes clientes que efetuaram compras na filial e como values a quantidade de compras efetuadas pelos clientes da key correspondente
     * @throws WrongMonthException
     * @throws WrongBranchException
     */
    public Map<String, Integer> getSellsByMonthAndFilial(int mes, int filial, MainStruct mainStruct) throws WrongMonthException, WrongBranchException {
        Map<String, Integer> res = new HashMap<>();
        Map<Integer, List<Venda>> aux = mainStruct.getFilial().getVendas();
        List<Venda> vendasMesFilial;

        if (mes < 1 || mes > 12) throw new WrongMonthException();

        else if (filial < 1 || filial > 3) throw new WrongBranchException();

        else {

            if (filial != 0) {
                List<Venda> vendasFilial = aux.get(filial);
                vendasMesFilial = vendasFilial.stream().filter(a -> a.getMes() == mes).collect(Collectors.toList());

                for (Venda v : vendasMesFilial) {
                    String cliente = v.getCliente();
                    if (!res.containsKey(cliente)) {
                        res.put(cliente, 1);
                    } else {
                        Integer qtd = res.get(cliente);
                        res.put(cliente, qtd + 1);
                    }
                }
            } else {
                List<Venda> vendasTotais = aux.get(0);

                for (Venda v : vendasTotais) {
                    String cliente = v.getCliente();
                    if (!res.containsKey(cliente) && v.getMes() == mes) {
                        res.put(cliente, 1);
                    } else if (res.containsKey(cliente) && v.getMes() == mes) {
                        Integer qtd = res.get(cliente);
                        qtd += 1;
                        res.put(cliente, qtd);
                    }
                }
            }
            return res;
        }
    }
}