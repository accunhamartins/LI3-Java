import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class GestAppController implements Serializable {
    private GestVendas mainStruct;
    private GestAppView view;

    /**
     * Construtores para objetos da classe Filial.
     */
    public void setView(GestAppView view) {
        this.view = view;
    }

    public void setMainStruct(String path) throws FileNotFoundException {
        this.mainStruct = new GestVendas();
        mainStruct.load(path);
    }

    /**
     * Método que reune os dados necessários para a resolução da Query 1 e os reorganiza de uma forma adequada.
     *
     * @return Set ordenado devidamente e com o conteudo adaptados há Query 1
     */
    public Set<String> flowQuery1(){
        Set<String> ret;
        ret = mainStruct.getNoneBoughtProducts();
        return ret;
    }

    /**
     * Método que reune os dados necessários para a resolução da Query 2 e os reorganiza de uma forma adequada.
     *
     * @return Map ordenado devidamente e com o conteudo adaptados há Query 2
     */
    public Map<String, Integer> flowQuery2(int mes, int filial) throws WrongBranchException, WrongMonthException{
        Map<String, Integer> ret;
        ret = mainStruct.getSellsByMonthAndFilial(mes,filial);
        return ret;
    }

    /**
     * Método que reune os dados necessários para a resolução da Query 3 e os reorganiza de uma forma adequada.
     *
     * @return List ordenada devidamente e com o conteudo adaptados há Query 3
     */
    public List<Q3MonthInfo> flowQuery3(String cliente) throws NoClienteFoundException {
        List<Q3MonthInfo> res = new ArrayList<>();
        try {
           res = mainStruct.monthlyCostumerInformation(cliente);

        } catch (NoClienteFoundException e) {
            System.out.println("O cliente é inválido");
        }
        return res;
    }

    /**
     * Método que reune os dados necessários para a resolução da Query 4 e os reorganiza de uma forma adequada.
     *
     * @return Map ordenado devidamente e com o conteudo adaptados há Query 4
     */
    public Map<Integer, Q4MonthInfo> flowQuery4(String produto) throws NoProductFoundException{
        Map<Integer, Q4MonthInfo> ret = new HashMap<>();
        try {
            ret = mainStruct.productBougthByMonth(produto);
        }
        catch (NoProductFoundException e){
            System.out.println("O produto é inválido");

        }
        return ret;
    }

    /**
     * Método que reune os dados necessários para a resolução da Query 5 e os reorganiza de uma forma adequada.
     *
     * @return List ordenado devidamente e com o conteudo adaptados há Query 5
     */
    public List<Venda> flowQuery5(String cliente) throws NoClienteFoundException{
        try {
            List<Venda> res = mainStruct.mostBoughtByClient(cliente);
            return res;
       } catch (NoClienteFoundException e){
            System.out.println("O cliente é inválido");
            return null;
        }
    }

    /**
     * Método que reune os dados necessários para a resolução da Query 6 e os reorganiza de uma forma adequada.
     *
     * @return SortedSet ordenado devidamente e com o conteudo adaptados há Query 6
     */
    public SortedSet<Map.Entry<String, Integer>> flowQuery6(){
        SortedSet<Map.Entry<String, Integer>> ret = mainStruct.getProductsMostSells();
        return ret;
    }

    /**
     * Método adicional que reune os dados necessários para a resolução da Query 6 e os reorganiza de uma forma adequada.
     *
     * @return Map ordenado devidamente e com o conteudo adaptados há Query 6
     */
    public Map<String, Set<String>> flowQuery6V2(){
        return mainStruct.getDiferentsBuyers();
    }

    /**
     * Método que reune os dados necessários para a resolução da Query 7 e os reorganiza de uma forma adequada.
     *
     * @return List ordenado devidamente e com o conteudo adaptados há Query 7
     */
    public List<Map<String,Double>> flowQuery7(){
        List<Map<String,Double>> ret = this.mainStruct.Biggest3ClientsBranch();
        return ret;
    }

    /**
     * Método que reune os dados necessários para a resolução da Query 8 e os reorganiza de uma forma adequada.
     *
     * @return Set ordenado devidamente e com o conteudo adaptados há Query 8
     */
    public Set<Pair> flowQuery8(){
        Set<Pair> ret = this.mainStruct.XClientsDiffProducts();
        return ret;
    }

    /**
     * Método que reune os dados necessários para a resolução da Query 9 e os reorganiza de uma forma adequada.
     *
     * @return Map ordenado devidamente e com o conteudo adaptados há Query 9
     */
    public Map<String, Double> flowQuery9(String produto) throws NoProductFoundException{
        Map<String,Double> ret = this.mainStruct.getXBetterClientsOfProductY(produto);
        return ret;
    }

    /**
     * Método que reune os dados necessários para a resolução da Query 9 e os reorganiza de uma forma adequada.
     *
     * @return Map com o conteudo adaptados há Query 9
     */
    public Map<String, Double> flowQuery9V2(String produto) throws NoProductFoundException{
        Map<String,Double> ret = this.mainStruct.getXBetterClientsOfProductYFat(produto);
        return ret;
    }

    /**
     * Método que reune os dados necessários para a resolução da Query 10 e os reorganiza de uma forma adequada.
     *
     * @return Map ordenado devidamente e com o conteudo adaptados há Query 10
     */
    public List<List<Map<String,Double>>> flowQuery10(){
        List<List<Map<String,Double>>> ret = new ArrayList<>();
        ret = this.mainStruct.BillingByBranch();
        return ret;
    }

    /**
     * Método que reune os dados necessários para a resolução da colsuta estatística referente ao total de vendas por mês.
     *
     * @return Map com os meses como keys e como values a quantidade de vendas referentes ao mês da key
     */
    public Map<Integer, Integer> flowStat1(){
        Map<Integer, Integer> ret = this.mainStruct.totalBuysPerMonth();
        return ret;
    }

    /**
     * Método que reune os dados necessários para a resolução da colsuta estatística referente ao total de lucro para uma determinada filial.
     *
     * @return Map com os meses como keys e como values o lucro da filial dada referentes ao mês da key
     */
    public Map<Integer, Double> flowStat2(int filial){
        Map<Integer, Double> ret = this.mainStruct.totalProfit(filial);
        return ret;
    }

    /**
     * Método que reune os dados necessários para a resolução da colsuta estatística referente ao total de clientes que efetuaram compras numa determinada filial.
     *
     * @return Map com os meses como keys e como values o numero de clientes diferentes que efetuaram compras na filial dada referentes ao mês da key
     */
    public Map<Integer, Set<String>> flowStat3(int filial){
        Map<Integer, Set<String>> ret = this.mainStruct.differentBuyers(filial);
        return ret;
    }

    /**
     * Método que limpa o ecrâ do utilizador.
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Método que trata da escolha do ficheiro a ser utilizado.
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void fileChoice() throws IOException, ClassNotFoundException {
        int op;
        Input input = new Input();
        clearScreen();
        this.view.printMensagemInicial();
        do{
            op = input.lerInt();
            switch (op){
                case 1:
                    Crono.start();
                    setMainStruct("input_files/Vendas_1M.txt");
                    Crono.stop();
                    System.out.println(Crono.getTImeString());
                    return;
                case 2:
                    String aux;
                    System.out.println("Insira a nova path");
                    aux = input.lerString();
                    Crono.start();
                    setMainStruct(aux);
                    Crono.stop();
                    System.out.println(Crono.getTImeString());
                    return;
                case 3:
                    System.out.println("\n");
                    System.out.println("Insira o ficheiro a carregar");
                    String aux1 = input.lerString();
                    Crono.start();
                    try {
                        this.mainStruct = new GestVendas();
                        this.mainStruct = new GestVendas(this.mainStruct.lerFicheiro(aux1));
                        Crono.stop();
                        System.out.println(Crono.getTImeString());
                    } catch (FileNotFoundException e){
                        System.out.println("Erro ao dar load");
                    }
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        } while (op != 0);
    }

    /**
     * Método que trata do flow do programa.
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void mainFlow() throws IOException, ClassNotFoundException {
        int op;
        Input input = new Input();
        this.view.printHeader();
        this.view.escolheMenu();
        do{
            op = input.lerInt();
            switch(op){
                case 0:
                    return;
                case 1:
                    clearScreen();
                    statsFlow();
                    break;
                case 2:
                    clearScreen();
                    startFlow();
                    break;
                case 3:
                    clearScreen();
                    if(this.mainStruct.getLoader() == null){
                        System.out.println("Não foi lido nenhum ficheiro txt\n");
                        this.view.escolheMenu();
                    }
                    else fileFlow();
                    break;
                case 4:
                    System.out.println("\n");
                    System.out.println("Insira o nome do ficheiro a carregar");
                    String aux = input.lerString();
                    try {
                        Crono.start();
                        this.mainStruct = new GestVendas(this.mainStruct.lerFicheiro(aux));
                        Crono.stop();
                        System.out.println("Done!");
                        System.out.println(Crono.getTImeString());
                    } catch (FileNotFoundException e){
                        System.out.println("Erro ao dar load");
                    }
                    this.view.escolheMenu();
                    break;
                case 5:
                    System.out.println("\n");
                    System.out.println("Insira o nome com que pretende guardar");
                    String aux1 = input.lerString();
                    Crono.start();
                    this.mainStruct.gravarFicheiro(aux1);
                    Crono.stop();
                    System.out.println("Done!");
                    System.out.println(Crono.getTImeString());
                    this.view.escolheMenu();
                    break;
                case 6:
                    clearScreen();
                    System.out.println("Insira a path do novo ficheiro de vendas para ler: ");
                    String aux2 = input.lerString();
                    try {
                        Crono.start();
                        this.mainStruct.load(aux2);
                        Crono.stop();
                        System.out.println(Crono.getTImeString());
                    } catch (FileNotFoundException e){
                        System.out.println("Erro ao dar load");
                    }
                    this.view.escolheMenu();
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
        while (op != 0);
    }

    /**
     * Método que trata da flow da analise de um determinado ficheiro.
     */
    public void fileFlow() {
        int op = -1;
        Input input = new Input();
        while (op != 0) {
            this.view.viewFilePath(this.mainStruct.getLoader().getFilePath());
            this.view.viewTotalErrado(this.mainStruct.getLoader().getTotalErrados());
            this.view.viewTotalProdutos(this.mainStruct.getLoader().getProdutos());
            this.view.viewProdutosDiferentes(this.mainStruct.getLoader().getProdutosDiferentes());
            this.view.viewNaoComprados(this.mainStruct.getLoader().getProdutosNaoComprados());
            this.view.viewClientes(this.mainStruct.getLoader().getClientes());
            this.view.viewClienteSemCompra(this.mainStruct.getLoader().getClientesSemCompras());
            this.view.viewVenda0(this.mainStruct.getLoader().getVendaA0());
            this.view.viewLucro(this.mainStruct.getLoader().getFaturacaoTotal());
            op = input.lerInt();
        }
        clearScreen();
        this.view.escolheMenu();
    }

    /**
     * Método que trata das flows das diferentes Queries ou de limpar o ecrâ e mostrar novamente o menu.
     */
    public void startFlow(){
        int op;
        Input input = new Input();
        this.view.printHeader();
        this.view.printMenu();
        do{
            op = input.lerInt();
            switch(op){
                case 0:
                    clearScreen();
                    this.view.escolheMenu();
                    return;
                case 1:
                    Crono.start();
                    this.view.flowQuery1(flowQuery1());
                    Crono.stop();
                    System.out.println(Crono.getTImeString());
                    this.view.inserirNovaOpcao();
                    break;
                case 2:
                    this.view.headQuery2();
                    this.view.escolheMes();
                    int mes2 = input.lerInt();
                    this.view.escolheFilial();
                    int filialq2 = input.lerInt();
                    try {
                        Crono.start();
                        Map<String, Integer> ret = flowQuery2(mes2, filialq2);
                        this.view.flowQuery2(ret);
                        Crono.stop();
                        System.out.println(Crono.getTImeString());
                    } catch (WrongMonthException e){
                        System.out.println("Mês inválido");
                    } catch (WrongBranchException e){
                        System.out.println("Filial inválida");
                    }
                    this.view.inserirNovaOpcao();
                    break;
                case 3:
                    this.view.headQuery3();
                    this.view.escolheCliente();
                    String cliente3 = input.lerString();
                    try {
                        Crono.start();
                        this.view.flowQuery3(flowQuery3(cliente3));
                        Crono.stop();
                        System.out.println(Crono.getTImeString());
                    } catch (NoClienteFoundException e) {
                        System.out.println("O cliente é inválido");
                    }
                    this.view.inserirNovaOpcao();
                    break;
                case 4:
                    this.view.headQuery4();
                    this.view.escolheProduto();
                    String produto = input.lerString();
                    try {
                        Crono.start();
                        this.view.flowQuery4(flowQuery4(produto));
                        Crono.stop();
                        System.out.println(Crono.getTImeString());
                    }
                    catch (NoProductFoundException e){
                        System.out.println("O produto é inválido");
                    }
                    this.view.inserirNovaOpcao();
                    break;
                case 5:
                    this.view.headQuery5();
                    this.view.escolheCliente();
                    String cliente5 = input.lerString();
                    try {
                        Crono.start();
                        this.view.flowQuery5(flowQuery5(cliente5));
                        Crono.stop();
                        System.out.println(Crono.getTImeString());
                    } catch (NoClienteFoundException e){
                        System.out.println("O cliente é inválido");
                    }
                    this.view.inserirNovaOpcao();
                    break;
                case 6:
                    this.view.headQuery6();
                    this.view.escolheNrProduto();
                    int x6 = input.lerInt();
                    Crono.start();
                    this.view.flowQuery6(flowQuery6(), x6, flowQuery6V2());
                    Crono.stop();
                    System.out.println(Crono.getTImeString());
                    this.view.inserirNovaOpcao();
                    break;
                case 7:
                    this.view.headQuery7();
                    Crono.start();
                    this.view.flowQuery7(flowQuery7());
                    Crono.stop();
                    System.out.println(Crono.getTImeString());
                    this.view.inserirNovaOpcao();
                    break;
                case 8:
                    this.view.headQuery8();
                    this.view.escolheNrCliente();
                    int x8 = input.lerInt();
                    Crono.start();
                    this.view.flowQuery8(flowQuery8(), x8);
                    Crono.stop();
                    System.out.println(Crono.getTImeString());
                    this.view.inserirNovaOpcao();
                    break;
                case 9:
                    this.view.headQuery9();
                    this.view.escolheNrCliente();
                    int x9 = input.lerInt();
                    this.view.escolheProduto();
                    String produto9 = input.lerString();
                    Crono.start();
                    try {
                        this.view.flowQuery9(flowQuery9(produto9), x9, flowQuery9V2(produto9));
                    } catch (NoProductFoundException e){
                        System.out.println("Produto inválido");
                    }
                    Crono.stop();
                    System.out.println(Crono.getTImeString());
                    this.view.inserirNovaOpcao();
                    break;
                case 10:
                    this.view.headQuery10();
                    this.view.escolheMes();
                    int mes10 = input.lerInt();
                    this.view.escolheFilial10();
                    int fil10 = input.lerInt();
                    Crono.start();
                    try {
                        this.view.flowQuery10(flowQuery10(), mes10, fil10);
                    } catch (WrongMonthException e){
                        System.out.println("Mês inválido");
                    } catch (WrongBranchException e){
                        System.out.println("Filial inválida");
                    }
                    Crono.stop();
                    System.out.println(Crono.getTImeString());
                    this.view.inserirNovaOpcao();
                    break;
                case 11:
                    clearScreen();
                    this.view.printMenu();
                    break;
                default:
                    System.out.println("Opcao Invalida.");
                    break;
            }
        }
        while(op != 0);
    }

    /**
     * Método que trata do flow das estatisticas de um ficheiro.
     */
    public void statsFlow(){
        int op;
        Input input = new Input();
        this.view.printMenuStats();
        do {
            op = input.lerInt();
            switch (op) {
                case 0:
                    clearScreen();
                    this.view.escolheMenu();
                    return;
                case 1:
                    this.view.headStat1();
                    Crono.start();
                    this.view.flowStat1(flowStat1());
                    Crono.stop();
                    System.out.println(Crono.getTImeString());
                    this.view.inserirNovaOpcao();
                    break;
                case 2:
                    this.view.headStat2();
                    Crono.start();
                    this.view.imprimeFilial1();
                    this.view.flowStat2(flowStat2(1));
                    this.view.imprimeFilial2();
                    this.view.flowStat2(flowStat2(2));
                    this.view.imprimeFilial3();
                    this.view.flowStat2(flowStat2(3));
                    Crono.stop();
                    System.out.println(Crono.getTImeString());
                    this.view.inserirNovaOpcao();
                    break;
                case 3:
                    this.view.headStat3();
                    Crono.start();
                    this.view.imprimeFilial1();
                    this.view.flowStat3(flowStat3(1));
                    this.view.imprimeFilial2();
                    this.view.flowStat3(flowStat3(2));
                    this.view.imprimeFilial3();
                    this.view.flowStat3(flowStat3(3));
                    Crono.stop();
                    System.out.println(Crono.getTImeString());
                    this.view.inserirNovaOpcao();
                    break;
                default:
                    System.out.println("Opcao inválida");
                    break;
            }
        }
        while (op != 0);
    }
}
