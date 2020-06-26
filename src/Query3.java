
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Query3 implements Serializable, Query3Interface {

    /**
     * Método que trata da Query 3.
     *
     * @param x          Código do cliente a analisar
     * @param mainStruct Objeto que possui os dados a analisar
     * @return Lista que possui as informações pedidas sobre o cliente para os diferentes meses
     * @throws NoClienteFoundException
     */
    public List<Q3MonthInfo> monthlyCostumerInformation(String x, MainStruct mainStruct) throws NoClienteFoundException{
        Map<String, List<Venda>> aux = mainStruct.getFilial().getVendasPorCliente();
        List<Q3MonthInfo> res = new ArrayList<>();

        if (aux.containsKey(x)){
            List<Venda> vendasCliente = aux.get(x);

            for(int i=1; i <= 12; i++){
                Q3MonthInfo aux2 = new Q3MonthInfo();
                int finalI = i;
                List<Venda> ret = vendasCliente.stream().filter(a -> a.getMes() == finalI).collect(Collectors.toList());
                aux2.setCompras((int) ret.stream().count());
                aux2.setTotal(ret.stream().mapToDouble(Venda::fazLucro).sum());
                Set<String> prods = ret.stream().map(Venda::getProduto).collect(Collectors.toSet());
                aux2.setProdutos(prods.size());
                res.add(aux2);
            }
        }

        else throw new NoClienteFoundException();

        return res;
    }
}