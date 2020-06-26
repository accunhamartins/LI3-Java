import java.io.Serializable;

public class MainStruct implements Serializable {
    private CatProd catalogoProduto;
    private CatCliente catalogoCliente;
    private Faturacao faturacao;
    private Filial filial;

    /**
     * Construtores para objetos da classe MainStruct.
     */
    public MainStruct(){
        this.catalogoProduto = new CatProd();
        this.catalogoCliente = new CatCliente();
        this.faturacao = new Faturacao();
        this.filial = new Filial();
    }

    public MainStruct(CatProd a, CatCliente b, Faturacao c, Filial d){
        this.catalogoProduto = new CatProd(a);
        this.catalogoCliente = new CatCliente(b);
        this.faturacao = new Faturacao(c);
        this.filial = new Filial(d);
    }

    public MainStruct(MainStruct a){
        this.catalogoCliente = a.getCatalogoCliente();
        this.catalogoProduto = a.getCatalogoProduto();
        this.faturacao = a.getFaturacao();
        this.filial = a.getFilial();
    }

    public CatCliente getCatalogoCliente() {
        return new CatCliente(this.catalogoCliente.clone());
    }

    public CatProd getCatalogoProduto() {
        return new CatProd(this.catalogoProduto.clone());
    }

    public Faturacao getFaturacao() {
        return new Faturacao(this.faturacao.clone());
    }

    public Filial getFilial() {
        return new Filial(this.filial.clone());
    }

    public void setCatalogoCliente(CatCliente catalogoCliente) {
        this.catalogoCliente = new CatCliente(catalogoCliente);
    }

    public void setCatalogoProduto(CatProd catalogoProduto) {
        this.catalogoProduto = new CatProd(catalogoProduto);
    }

    public void setFaturacao(Faturacao faturacao) {
        this.faturacao = new Faturacao(faturacao);
    }

    public void setFilial(Filial filial) {
        this.filial = new Filial(filial);
    }

    /**
     * Implementação do método de clonagem de um MainStruct.
     *
     * @return Objeto do tipo MainStruct
     */
    public MainStruct clone(){
        return (new MainStruct(this));
    }

    /**
     * Implementação do método de igualdade entre dois MainStruct.
     *
     * @param obj MainStruct que é comparado com o recetor
     * @return boolean true ou false
     */
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj != null || obj.getClass() != this.getClass()) return false;
        MainStruct ms = (MainStruct) obj;
        return this.faturacao.equals(ms.getFaturacao()) &&
                this.filial.equals(ms.getFilial()) &&
                this.catalogoProduto.equals(ms.getCatalogoProduto()) &&
                this.getCatalogoCliente().equals(ms.getCatalogoCliente());

    }

    /**
     * Implementação do método toString para a classe MainStruct.
     *
     * @return String com a informação textoal do objeto MainStruct
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.catalogoCliente.toString()).append("\n");
        sb.append(this.catalogoProduto.toString()).append("\n");
        sb.append(this.faturacao.toString()).append("\n");
        sb.append(this.filial.toString()).append("\n");

        return sb.toString();
    }


}
