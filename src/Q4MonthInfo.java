import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Q4MonthInfo implements Serializable, Q4MonthInfoInterface {
    private int quantidade;
    private Set<String> clientes;
    private double total;

    public Q4MonthInfo(){
        this.quantidade = 0;
        this.clientes = new HashSet<>();
        this.total = 0;
    }

    public double getTotal() {
        return total;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setClientes(Set<String> clientes) {
        this.clientes = clientes;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Set<String> getClientes() {
        return clientes;
    }

    /**
     * Método que atualiza o parâmetro quantidade.
     *
     * @param x Valor a adicionar
     */
    public void addQuantidade(int x){
        this.quantidade += x;
    }

    /**
     * Método que adiciona um Cliente à lista de Clientes.
     *
     * @param c Cliente a adicionar
     */
    public void addCliente(String c){
        this.clientes.add(c);
    }

    /**
     * Método que atualiza o parâmetro quantidade.
     *
     * @param d Valor a adicionar
     */
    public void addLucro(double d){
        this.total += d;
    }

    /**
     * Implementação do método toString para a classe Q4MonthInfo.
     *
     * @return String com a informação textoal do objeto Q4MonthInfo
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Número de compras: ").append(this.quantidade+"\n");
        sb.append("Número de clientes: ").append(this.clientes.size()+"\n");
        sb.append("Total gasto: ").append(this.total+"\n");
        return sb.toString();
    }



}
