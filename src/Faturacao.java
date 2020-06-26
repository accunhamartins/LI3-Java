import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Faturacao implements Serializable {
    private Map<String, List<Venda>> vendasPorProduto;

    /**
     * Construtores para objetos da classe Faturacao.
     */
    public Faturacao(){
        this.vendasPorProduto = new TreeMap<>();

    }

    public Faturacao(Map<String,List<Venda>> vendasPorProduto){
        setVendasPorProduto(vendasPorProduto);
    }

    public Faturacao(Faturacao a){

        setVendasPorProduto(a.getVendasPorProduto());
    }

    public Map<String,List<Venda>> getVendasPorProduto() {
        return this.vendasPorProduto.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
    }


    public void setVendasPorProduto(Map<String,List<Venda>> vendas){
        this.vendasPorProduto = new TreeMap<>();
        vendas.entrySet().forEach(e -> this.vendasPorProduto.put(e.getKey(), e.getValue()));
    }


    /**
     * Implementação do método de clonagem de uma Faturacao.
     *
     * @return Objeto do tipo Faturacao
     */
    public Faturacao clone(){
        return (new Faturacao(this));
    }

    /**
     * Implementação do método de igualdade entre dois Faturacao.
     *
     * @param obj Faturacao que é comparado com o recetor
     * @return boolean true ou false
     */
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Faturacao f = (Faturacao) obj;
        return this.vendasPorProduto.equals(f);
    }


    /**
     * Implementação do metodo toString para a classe Faturacao.
     *
     * @return String com a informação textoal do objeto Faturacao
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Total de vendas efetuadas: ").append("\n");
        sb.append(this.vendasPorProduto.toString());

        return sb.toString();
    }

    /**
     * Método que transforma a lista de vendas num Map que possui como key cada produto e como value a lista de vendas dos produtos correspondentes.
     *
     * @param vendas List das vendas a serem colocadas no map
     * @return map com as vendas organizadas por produtos
     */
    public Map<String, List<Venda>> colocaVendasProduto(List<Venda> vendas){
        Map<String, List<Venda>> ret = new TreeMap<>();
        for(Venda v: vendas){
            String prod = v.getProduto();
            if(!ret.containsKey(prod)){
                List<Venda> aux = new ArrayList<>();
                aux.add(v.clone());
                ret.put(prod, aux);
            }
            else{
                List<Venda> aux = ret.get(prod);
                aux.add(v.clone());
                ret.put(prod, aux);
            }
        }
        return ret;
    }

    /**
     * Implementação do método hashCode para a classe Faturacao.
     *
     * @return Valor int gerado pelo algoritmo
     */
    public int hashCode(){
        return Arrays.hashCode(new Object[]{this.vendasPorProduto});
    }

}
