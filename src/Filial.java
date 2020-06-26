import com.sun.source.tree.Tree;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Filial implements Serializable {

    private Map<Integer, List<Venda>> vendasPorFilial;
    private Map<String, List<Venda>> vendasPorCliente;

    /**
     * Construtores para objetos da classe Filial.
     */
    public Filial(){
        this.vendasPorFilial = new TreeMap<>();
        this.vendasPorCliente = new TreeMap<>();
    }

    public Filial(Map<Integer,List<Venda>> vendas, Map<String, List<Venda>> vendasPorCliente){
        setVendas(vendas);
        setVendasPorCliente(vendasPorCliente);

    }

    public Filial(Filial a){
        setVendas(a.getVendas());
        setVendasPorCliente(a.getVendasPorCliente());
    }

    public Map<Integer,List<Venda>> getVendas() {
        return this.vendasPorFilial.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
    }

    public Map<String, List<Venda>> getVendasPorCliente() {
        return this.vendasPorCliente.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
    }


    public void setVendas(Map<Integer,List<Venda>> vendas){
        this.vendasPorFilial = new TreeMap<>();
        vendas.entrySet().forEach(e -> this.vendasPorFilial.put(e.getKey(), e.getValue()));
    }

    public void setVendasPorCliente(Map<String, List<Venda>> vendasPorCliente) {
        this.vendasPorCliente = new TreeMap<>();
        vendasPorCliente.entrySet().forEach(e -> this.vendasPorCliente.put(e.getKey(), e.getValue()));
    }

    /**
     * Implementação do método de clonagem de um Filial.
     *
     * @return Objeto do tipo CatProd
     */
    public  Filial clone(){
        return (new Filial(this));
    }

    /**
     * Implementação do método de igualdade entre dois Filial.
     *
     * @param obj Filial que é comparado com o recetor
     * @return boolean true ou false
     */
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Filial f = (Filial) obj;
        return this.vendasPorFilial.equals(f);
    }


    /**
     * Implementação do metodo toString para a classe Filial.
     *
     * @return String com a informação textoal do objeto Filial
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Total de vendas efetuadas: ").append("\n");
        sb.append(this.vendasPorFilial.toString());

        return sb.toString();
    }

    /**
     * Método que coloca num Map que coloca como key o numero da filial e como value a lista de vendas das filiais correspondentes.
     * A key com o valor 0 possui todas as vendas.
     *
     * @param vendas List das vendas a serem colocadas no map
     * @return map com as vendas organizadas por filial
     */
    public Map<Integer, List<Venda>> colocaVendas(List<Venda> vendas){
        Map<Integer, List<Venda>> ret = new TreeMap<>();
        List<Venda> totais = new ArrayList<>();
        for(Venda v: vendas){
            totais.add(v.clone());
            Integer filial = v.getFilial();
            if(!ret.containsKey(filial)){
                List<Venda> aux = new ArrayList<>();
                aux.add(v.clone());
                ret.put(filial, aux);
            }
            else{
                List<Venda> aux = ret.get(filial);
                aux.add(v.clone());
                ret.put(filial, aux);
            }
            ret.put(0, totais);
        }
        return ret;
    }


    /**
     * Método que transforma a list de vendas num Map que possui como key cada cliente e como value a lista de vendas dos clientes correspondentes.
     *
     * @param vendas List das vendas a serem colocadas no map
     * @return map com as vendas organizadas por clientes
     */
    public Map<String, List<Venda>> colocaVendasCliente(List<Venda> vendas){
        Map<String, List<Venda>> ret = new TreeMap<>();
        for(Venda v: vendas){
            String cliente = v.getCliente();
            if(!ret.containsKey(cliente)){
                List<Venda> aux = new ArrayList<>();
                aux.add(v.clone());
                ret.put(cliente, aux);
            }
            else{
                List<Venda> aux = ret.get(cliente);
                aux.add(v.clone());
                ret.put(cliente, aux);
            }
        }
        return ret;
    }

    /**
     * Implementação do método hashCode para a classe Filial.
     *
     * @return Valor int gerado pelo algoritmo
     */
    public int hashCode(){
        return Arrays.hashCode(new Object[]{this.vendasPorFilial, this.vendasPorCliente});
    }


}
