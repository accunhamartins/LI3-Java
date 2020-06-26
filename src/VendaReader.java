import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class VendaReader implements Serializable {

    private CatProd cpAux;
    private CatCliente ccAux;
    private List<Venda> vendas;
    private int produtosDiferentes;
    private int produtosNaoComprados;
    private int totalErrados;
    private int clientes;
    private double faturacaoTotal;
    private int vendaA0;
    private int clientesSemCompras;

    /**
     * Construtores para objetos da classe ClientReader.
     */
    public VendaReader(){
        this.ccAux = new CatCliente();
        this.cpAux = new CatProd();
        this.vendas = new ArrayList<>();
        this.produtosDiferentes = 0;
        this.produtosNaoComprados = 0;
        this.totalErrados = 0;
        this.clientes = 0;
        this.faturacaoTotal = 0.0;
        this.vendaA0 = 0;
        this.clientesSemCompras = 0;
    }

    public VendaReader(Set<String> cp,Set<String> cc, List<Venda> aux, int a, int b, int c, int d, double e, int f, int g){
       setCpAux(cp);
       setCcAux(cc);
       setVendas(aux);
       this.produtosDiferentes = a;
       this.produtosNaoComprados = b;
       this.totalErrados = c;
       this.clientes = d;
       this.faturacaoTotal = e;
       this.vendaA0 = f;
       this.clientesSemCompras = g;

    }

    public VendaReader(VendaReader a){
        setCpAux(a.getCpAux());
        setCcAux(a.getCcAux());
        setVendas(a.getVendas());
    }

    public int getClientes() {
        return clientes;
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

    public List<Venda> getVendas() {
        return this.vendas.stream().map(Venda::clone).collect(Collectors.toList());
    }

    public Set<String> getCcAux() {
        return this.ccAux.getCatalogoClientes().stream().collect(Collectors.toSet());
    }

    public Set<String> getCpAux() {
        return this.cpAux.getCatalogoProdutos().stream().collect(Collectors.toSet());
    }

    public void setCcAux(Set<String> ccAux) {
        this.ccAux = new CatCliente();
        Set<String> aux = new TreeSet<>();
        for(String s: ccAux) aux.add(s);

        this.ccAux.setCatalogoClientes(aux);


    }

    public void setCpAux(Set<String> cpAux) {
        this.cpAux = new CatProd();
        Set<String> aux = new TreeSet<>();
        for(String s: cpAux) aux.add(s);

        this.cpAux.setCatalogoProdutos(aux);
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = new ArrayList<>();
        for(Venda v: vendas) this.vendas.add(v.clone());
    }

    /**
     * Método que lê um ficheiro e divide os diferentes dados pelas diferentes estruturas correspondentes.
     *
     * @param saleFile Ficheiro a ser analisado
     * @throws FileNotFoundException
     */
    public void readFile(String saleFile) throws FileNotFoundException {
        BufferedReader br = null;
        Set<String> produtos = new HashSet<>();
        Set<String> clientes = new HashSet<>();
        List<Venda> aux = new ArrayList<>();
        String line;
        int total = 0;
        try {
            br = new BufferedReader(new FileReader(saleFile));
            while ((line = br.readLine()) != null) {
                String campos[] = line.split(" ");
                if (this.cpAux.existe(campos[0]) && this.ccAux.existe(campos[4])) {
                    aux.add(new Venda(campos[0], Double.parseDouble(campos[1]), Integer.parseInt(campos[2]), campos[3].charAt(0), campos[4], Integer.parseInt(campos[5]), Integer.parseInt(campos[6])));
                    produtos.add(campos[0]);
                    clientes.add(campos[4]);
                    this.faturacaoTotal += Double.parseDouble(campos[1]) * Integer.parseInt(campos[2]);
                }
                if(Double.parseDouble(campos[1]) == 0) this.vendaA0++;
                total++;
            }

            setVendas(aux);

        } catch (IOException e) {
            System.out.println("Erro ao dar load");
        }

        this.produtosDiferentes = produtos.size();
        this.clientes = clientes.size();
        this.totalErrados = total - aux.size();
        this.clientesSemCompras = (this.ccAux.getCatalogoClientes().size() - clientes.size());
        this.produtosNaoComprados = (this.cpAux.getCatalogoProdutos().size() - produtos.size());
    }

    /**
     * Implementação do método hashCode para a classe VendaReader.
     *
     * @return Valor int gerado pelo algoritmo
     */
    public int hashCode(){
        return Arrays.hashCode(new Object[]{this.cpAux, this.ccAux, this.vendas});
    }

}
