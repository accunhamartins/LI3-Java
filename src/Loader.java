import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Loader implements Serializable {
    private String filePath;
    private int produtosDiferentes;
    private int produtosNaoComprados;
    private int totalErrados;
    private int clientes;
    private int produtos;
    private double faturacaoTotal;
    private int vendaA0;
    private int clientesSemCompras;

    public String getFilePath() {
        return filePath;
    }

    public int getClientes() {
        return clientes;
    }

    public int getProdutos() {
        return produtos;
    }

    public double getFaturacaoTotal() {
        return faturacaoTotal;
    }

    public int getProdutosDiferentes() {
        return produtosDiferentes;
    }

    public int getClientesSemCompras() {
        return clientesSemCompras;
    }

    public int getProdutosNaoComprados() {
        return produtosNaoComprados;
    }

    public int getTotalErrados() {
        return totalErrados;
    }

    public int getVendaA0() {
        return vendaA0;
    }

    public void setClientesSemCompras(int clientesSemCompras) {
        this.clientesSemCompras = clientesSemCompras;
    }

    public void setFaturacaoTotal(double faturacaoTotal) {
        this.faturacaoTotal = faturacaoTotal;
    }

    public void setProdutosDiferentes(int produtosDiferentes) {
        this.produtosDiferentes = produtosDiferentes;
    }

    public void setClientes(int clientes) {
        this.clientes = clientes;
    }

    public void setProdutosNaoComprados(int produtosNaoComprados) {
        this.produtosNaoComprados = produtosNaoComprados;
    }

    public void setTotalErrados(int totalErrados) {
        this.totalErrados = totalErrados;
    }

    public void setVendaA0(int vendaA0) {
        this.vendaA0 = vendaA0;
    }

    /**
     * Método que converte um ficheiro de vendas em todas as estruturas da MainStruct
     *
     * @param salesFile Ficheiro de vendas
     * @return MainStruct com os dados do ficheiro de vendas
     * @throws FileNotFoundException
     */
    public MainStruct loadFiles(String salesFile) throws FileNotFoundException {
        ClientReader cr = new ClientReader();
        ProductReader pr = new ProductReader();
        pr.readFile();
        cr.readFile();

        this.setClientes(clientes);

        CatProd cp = new CatProd(pr.getCp());
        CatCliente cc = new CatCliente((cr.getCc()));

        VendaReader vr = new VendaReader(cp.getCatalogoProdutos(), cc.getCatalogoClientes(), new ArrayList<>(), 0,0,0,0,0,0,0);
        vr.readFile(salesFile);

        this.filePath = salesFile;
        this.produtosNaoComprados = vr.getProdutosNaoComprados();
        this.produtosDiferentes = vr.getProdutosDiferentes();
        this.clientes = vr.getClientes();
        this.faturacaoTotal = vr.getFaturacaoTotal();
        this.vendaA0 = vr.getVendaA0();
        this.totalErrados = vr.getTotalErrados();
        this.clientesSemCompras = vr.getClientesSemCompras();
        this.produtos = cp.getCatalogoProdutos().size();

        List<Venda> vendas = vr.getVendas();
        Faturacao faturacao = new Faturacao();
        Map<String, List<Venda>> fp = faturacao.colocaVendasProduto(vendas);
        faturacao = new Faturacao(fp);
        Filial filial = new Filial();
        Map<String, List<Venda>> fc = filial.colocaVendasCliente(vendas);
        Map<Integer, List<Venda>> fil = filial.colocaVendas(vendas);
        filial = new Filial(fil, fc);

       return  new MainStruct(cp.clone(), cc.clone(), faturacao.clone(), filial.clone());
    }
}
