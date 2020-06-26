import java.io.*;
import java.util.*;

public class GestVendas implements GestVendasInterface, Serializable {
    private MainStruct mainStruct;
    private Loader loader;

    /**
     * Construtores para objetos da classe CatCliente.
     */
    public GestVendas (){
        this.mainStruct = new MainStruct();
        this.loader = new Loader();
    }

    public GestVendas (MainStruct mainStruct){
        this.mainStruct = mainStruct.clone();
    }

    public GestVendas (GestVendas a){
        this.mainStruct = a.getMainStruct();
    }

    public MainStruct getMainStruct() {
        return mainStruct.clone();
    }

    public Loader getLoader() {
        return loader;
    }

    public void load(String path) throws FileNotFoundException {
        this.loader = new Loader();
        this.mainStruct = this.loader.loadFiles(path);
    }

    /**
     * Método que dá como resultado a estrutura que é resultado da resolução da Query 1.
     *
     * @return Set com os produtos que nunca foram comprados
     */
    public Set<String> getNoneBoughtProducts(){
        Query1 res = new Query1();
        return res.getNoneBoughtProducts(this.mainStruct);
    }

    /**
     * Método que dá como resultado a estrutura que é resultado da resolução da Query 2.
     *
     * @param mes    Mês dado pelo utilizador a analisar
     * @param filial Filial dada pelo utilizador a analisar
     * @return Map em que as keys são os diferentes clientes que efetuaram compras na filial e como values a quantidade de compras efetuadas pelos clientes da key correspondente
     * @throws WrongBranchException
     * @throws WrongMonthException
     */
    public Map<String,Integer> getSellsByMonthAndFilial(int mes, int filial) throws WrongBranchException, WrongMonthException{
        Query2 res = new Query2();
        return res.getSellsByMonthAndFilial(mes, filial, this.mainStruct);
    }

    /**
     * Método que dá como resultado a estrutura que é resultado da resolução da Query 3.
     *
     * @param cliente Código do cliente dado pelo utilizador
     * @return List com a informação para cada mês sobre o cliente dado
     * @throws NoClienteFoundException
     */
    public List<Q3MonthInfo> monthlyCostumerInformation(String cliente) throws NoClienteFoundException{
        Query3 res = new Query3();
        return  res.monthlyCostumerInformation(cliente, this.mainStruct);
    }

    /**
     * Método que dá como resultado a estrutura que é resultado da resolução da Query 4.
     *
     * @param cod Código do produto dado pelo uitlizador
     * @return Map que possui como key os meses e como values a informação pedida para a Querie 4 sobre o produto referente ao mês da key correspondente
     * @throws NoProductFoundException
     */
    public Map<Integer, Q4MonthInfo> productBougthByMonth(String cod) throws NoProductFoundException{
        Query4 res = new Query4();
        return res.productBougthByMonth(this.mainStruct, cod);
    }

    /**
     * Método que dá como resultado a estrutura que é resultado da resolução da Query 5.
     *
     * @param cliente Código do cliente a analisar
     * @return Lista com os códigos dos produtos mais comprados pelo cliente dado ordenados de forma decrescente
     * @throws NoClienteFoundException
     */
    public List<Venda> mostBoughtByClient(String cliente) throws NoClienteFoundException{
        Query5 res = new Query5();
        return res.mostBoughtByClient(this.mainStruct, cliente);
    }

    /**
     * Método que dá como resultado a estrutura que é resultado de parte da resolução da Query 6.
     *
     * @return SortedSet com os produtos mais vendidos
     */
    public  SortedSet<Map.Entry<String, Integer>> getProductsMostSells(){
        Query6 res = new Query6();
        return res.getProductsMostSells(this.mainStruct);
    }

    /**
     * Método que dá como resultado a estrutura que é resultado de parte da resolução da Query 6.
     *
     * @return Map com os produtos como keys e com os clientes que compram o produto correspondente como values
     */
    public Map<String, Set<String>> getDiferentsBuyers (){
        Query6 res = new Query6();
        return res.getDiferentsBuyers(this.mainStruct);
    }

    /**
     * Método que dá como resultado a estrutura que é resultado da resolução da Query 7.
     *
     * @return List com os Map respetivas de cada filial ao total gasto por cada cliente ordenados decrescentemente
     */
    public List<Map<String,Double>> Biggest3ClientsBranch(){
        Query7 res = new Query7();
        return res.Biggest3ClientsBranch(this.mainStruct);
    }

    /**
     * Método que dá como resultado a estrutura que é resultado da resolução da Query 8.
     *
     * @return Set de Pair's em que o primeiro elemento do par é o cliente e o segundo é o número de produtos diferentes comprados por esse cliente
     */
    public Set<Pair> XClientsDiffProducts(){
        Query8 res = new Query8();
        return res.XClientsDiffProducts(this.mainStruct);
    }

    /**
     * Método que dá como resultado a estrutura que é resultado de parte da resolução da Query 9.
     *
     * @param produto Código do produto dado pelo utilizador
     * @return Map ordenado de forma decrescente dos values em que as key são os clientes e o value a quantidade de unidades compradas pelo cliente correspondente
     * @throws NoProductFoundException
     */
    public Map<String, Double> getXBetterClientsOfProductY(String produto) throws NoProductFoundException{
        Query9 res = new Query9();
        return res.getXBetterClientsOfProductY(this.mainStruct, produto);
    }

    /**
     * Método que dá como resultado a estrutura que é resultado de parte da resolução da Query 9.
     *
     * @param produto Código do produto dado pelo utilizador
     * @return Map que tem como key os clientes e como value o total gasto na compra do produto dado pelo cliente correspondente
     * @throws NoProductFoundException
     */
    public Map<String, Double> getXBetterClientsOfProductYFat(String produto) throws NoProductFoundException{
        Query9 res = new Query9();
        return res.getXBetterClientsOfProductYFat(this.mainStruct, produto);
    }

    /**
     * Método que dá como resultao a estrutura que é resultado de parte da resolução da Query 10.
     *
     * @return List das List's de cada mês com os Map de cada filial com os produtos como keys e o total faturado como values
     */
    public List<List<Map<String,Double>>> BillingByBranch(){
        Query10 res = new Query10();
        return res.BillingByBranch(this.mainStruct);
    }

    /**
     * Método que dá como resultado a estrutura que é resultado da resolução da estatística do número total de compras por mês.
     *
     * @return Map em que as key são so meses e os values as compras efetuadas no mês correspondente
     */
    public Map<Integer, Integer> totalBuysPerMonth(){
       return Stats.totalBuysPerMonth(this.mainStruct);
    }

    /**
     * Método que dá como resultado a estrutura que é resultado da estatística sobre a faturação total por mês de uma determinada filial.
     *
     * @param filial Filial a ter em consideração
     * @return Map em que as key são os meses e os values a faturação no mês correspondente da filial indicada
     */
    public Map<Integer, Double> totalProfit(int filial){
        return Stats.totalProfit(this.mainStruct, filial);
    }

    /**
     * Método que dá como resultado a estrutura que é resultado da estatística sobre o número de clientes distintos que efetuaram compras por mês numa determinada filial.
     *
     * @param filial Filial a ter em consideração
     * @return Map em que as key são os meses e os values o número e clientes distintos que efetuaram compras no mês correspondente da filial indicada
     */
    public Map<Integer, Set<String>> differentBuyers(int filial){
        return Stats.differentBuyers(this.mainStruct, filial);
    }

    /**
     * Implementação do método de clonagem de um GestVendas.
     *
     * @return Objeto do tipo GestVendas
     */
    public GestVendas clone(){
        return new GestVendas(this);
    }

    /**
     * Método que grava um ficheiro.
     *
     * @param filename Ficheiro onde vai ser guardado o Objeto
     * @throws IOException
     * @throws FileNotFoundException
     */
    public void gravarFicheiro(String filename) throws IOException, FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    /**
     * Método que lê um ficheiro.
     *
     * @param filename Ficheiro que vai ser lido
     * @return GestVendas com a informação do ficheiro lido
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public GestVendas lerFicheiro(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        GestVendas d = (GestVendas) ois.readObject();
        ois.close();
        return d;
    }

}