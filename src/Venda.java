import java.io.Serializable;

public class Venda implements Serializable {
  private String produto;
  private double preco;
  private int quantidade;
  private char compra;
  private String cliente;
  private int mes;
  private int filial;

  /**
   * Construtores para objetos da classe Venda.
   */
  public Venda(){
    this.produto = " ";
    this.preco = 0;
    this.quantidade = 0;
    this.compra = ' ';
    this.cliente = " ";
    this.mes = 0;
    this.filial = 0;
  }

  public Venda(String produto, double preco, int quantidade, char compra, String cliente,int mes, int filial){
    this.produto = produto;
    this.preco = preco;
    this.quantidade = quantidade;
    this.compra = compra;
    this.cliente = cliente;
    this.mes = mes;
    this.filial = filial;
  }

  public Venda(Venda v){
    this.produto = v.getProduto();
    this.preco = v.getPreco();
    this.quantidade = v.getQuantidade();
    this.compra = v.getCompra();
    this.cliente = v.getCliente();
    this.mes = v.getMes();
    this.filial = v.getFilial();
  }

  public String getProduto(){
    return this.produto;
  }

  public int getMes() {
    return this.mes;
  }

  public double getPreco(){
    return this.preco;
  }

  public int getQuantidade(){
    return this.quantidade;
  }

  public char getCompra(){
    return this.compra;
  }

  public String getCliente(){
    return this.cliente;
  }

  public int getFilial(){
    return this.filial;
  }

  public void setProduto(String produto){
    this.produto = produto;
  }

  public void setPreco(double preco){
    this.preco = preco;
  }

  public void setQuantidade(int quantidade){
    this.quantidade = quantidade;
  }

  public void setCompra(char compra){
    this.compra = compra;
  }

  public void setCliente(String cliente){
    this.cliente = cliente;
  }

  public void setMes(int mes) {
    this.mes = mes;
  }

  public void setFilial(int filial){
    this.filial = filial;
  }

  /**
   * Implementação do método de clonagem de um Venda.
   *
   * @return Objeto do tipo Venda
   */
  public Venda clone(){
    return new Venda(this);
  }

  /**
   * Método que permite obter o valor total da Venda.
   *
   * @return Valor total da venda, ou seja, preço x quantidade
   */
  public double getTotal(){
    return this.getPreco()*this.getQuantidade();
  }

  /**
   * Implementação do método de igualdade entre dois Venda.
   *
   * @param obj Venda que é comparado com o recetor
   * @return boolean true ou false
   */
  public boolean equals(Object obj){
    if (this == obj) return true;
    if (obj == null || this.getClass() != obj.getClass()) return false;
    Venda v = (Venda) obj;
    return this.produto.equals(v.getProduto()) &&
           this.preco == v.getPreco() &&
           this.quantidade == v.getQuantidade() &&
           this.compra == v.getCompra() &&
           this.cliente.equals(v.getCliente()) &&
           this.mes == v.getMes() &&
           this.filial == v.getFilial();
  }

  /**
   * Implementação do metodo toString para a classe Venda.
   *
   * @return String com a informação textoal do objeto Venda
   */
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("Produto: ").append(this.produto).append("\n");
    sb.append("Preço: ").append(this.preco).append("\n");
    sb.append("Quantidade: ").append(this.quantidade).append("\n");
    sb.append("Compra: ").append(this.compra).append("\n");
    sb.append("Cliente: ").append(this.cliente).append("\n");
    sb.append("Mês: ").append(this.mes).append("\n");
    sb.append("Filial: ").append(this.filial).append("\n");

    return sb.toString();
  }

  /**
   * Método que nos permite obter o valor total (lucro) de uma venda
   *
   * @param venda Venda a calcular o lucro
   * @return Valor do lucro da venda
   */
  public static double fazLucro(Venda venda){
    return (venda.getPreco() * venda.getQuantidade());
  }

}
