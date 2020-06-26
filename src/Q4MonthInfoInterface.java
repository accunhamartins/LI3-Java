import java.util.Set;

public interface Q4MonthInfoInterface {
    double getTotal();
    void setQuantidade(int quantidade);
    void setClientes(Set<String> clientes);
    void setTotal(double total);
    int getQuantidade();
    Set<String> getClientes();
    void addQuantidade(int x);
    void addCliente(String c);
    void addLucro(double d);
    String toString();
}
