import java.io.Serializable;

public class Q3MonthInfo implements Serializable, Q3MonthInfoInterface {
    private int compras;
    private int produtos;
    private double total;

    public double getTotal() {
        return total;
    }

    public void setCompras(int compras) {
        this.compras = compras;
    }

    public void setProdutos(int produtos) {
        this.produtos = produtos;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCompras() {
        return compras;
    }

    public int getProdutos() {
        return produtos;
    }

    /**
     * Implementação do método toString para a classe Q3MonthInfo.
     *
     * @return String com a informação textoal do objeto Q3MonthInfo
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Número de compras: ").append(this.compras+"\n");
        sb.append("Número de produtos: ").append(this.produtos+"\n");
        sb.append("Total gasto: ").append(this.total+"\n");
        return sb.toString();
    }
}


