import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class GestAppView implements Serializable {

    public GestAppView (){}

    /**
     * Método que imprime no ecrã o menu inicial.
     */
    public void printMensagemInicial(){
        System.out.println("Pretende ler o ficheiro default (1 Milhão) ou ler um novo ficheiro de vendas");
        System.out.println("1. Ficheiro 1 milhão de vendas");
        System.out.println("2. Ler outro ficheiro de vendas");
        System.out.println("3. Carregar ficheiro de memória");
    }

    /**
     * Método que imprime no ecrã a mensagem de "Boas vindas" ao programa.
     */
    public void printHeader(){
        System.out.println("\nBem vindo ao nosso Sistema de Gestão de Vendas\n");
    }

    /**
     * Método que imprime no ecrã o menu das estatísticas.
     */
    public void printMenuStats(){
        System.out.println("Consultas estatísticas");
        System.out.println("1. Número total de compras por mês");
        System.out.println("2. Faturação total por mês para cada filial ou 0 para dados gerais");
        System.out.println("3. Número de clientes diferentes que compraram em cada mês, filial a filial");
    }

    /**
     * Método que imprime no ecrã o menu das queries.
     */
    public void printMenu(){
        System.out.println("Escolha uma das seguintes queries para ser executada:\n");
        System.out.println("1. Produtos nunca comprados e respetivo total\n");
        System.out.println("2. Número total de vendas realizadas e número de clientes distintos que as fizeram(por filial)\n");
        System.out.println("3. Compras, produtos e total gasto de um dado cliente por mês\n");
        System.out.println("4. Número de vendas, total faturado e clientes que compraram um dado produto\n");
        System.out.println("5. Produtos mais comprados por um dado cliente\n");
        System.out.println("6. X produtos mais vendidos em todo o ano e número de clientes que os compraram\n");
        System.out.println("7. 3 maiores compradores de cada filial\n");
        System.out.println("8. X clientes que compraram mais produtos diferentes\n");
        System.out.println("9. X clientes que compram um dado produto e valor gasto\n");
        System.out.println("10. Faturação total com cada produto, filial a filial, mês a mês\n");
        System.out.println("11. Limpar ecrã\n ");
        System.out.println("0. Menu inicial\n");
    }

    /**
     * Método que imprime no ecrã o menu inicial depois de ter sido escolhido o ficheiro.
     */
    public void escolheMenu(){
        System.out.println("Escolha que tipo de consulta pretende fazer: ");
        System.out.println("1. Consultas estatísticas ");
        System.out.println("2. Consultas interativas (QUERIES) ");
        System.out.println("3. Estatísticas do ficheiro txt lido");
        System.out.println("4. Carregar ficheiro");
        System.out.println("5. Guardar ficheiro");
        System.out.println("6. Ler novo ficheiro de vendas (TXT)");
        System.out.println("0. Sair do programa ");
    }

    /**
     * Método que imprime no ecrã o caminho do ficheiro lido.
     *
     * @param path Caminho do ficheiro inserido
     */
    public void viewFilePath(String path) {
        System.out.println("Dados estatísticos do ficheiro de venda lido\n");
        System.out.println("Ficheiro lido: " + path);
    }

    /**
     * Método que imprime no ecrã o número total de registo de venda errados.
     *
     * @param errado Total de registo de vend errados
     */
    public void viewTotalErrado(int errado) {
        System.out.println("Número total de registo de venda errados: " + errado);
    }

    /**
     * Método que imprime no ecrã o número total de produtos.
     *
     * @param produtos número total de produtos.
     */
    public void viewTotalProdutos(int produtos) {
        System.out.println("Número total de produtos: " + produtos);
    }

    /**
     * Método que imprime no ecrã o número total de produtos diferentes.
     *
     * @param diferentes Número toal de produtos diferentes
     */
    public void viewProdutosDiferentes(int diferentes) {
        System.out.println("Número total de produtos diferentes: " + diferentes);
    }

    /**
     * Método que imprime no ecrã o número total de produtos não comprados.
     *
     * @param naoComprados Número total de produtos não comprados
     */
    public void viewNaoComprados(int naoComprados) {
        System.out.println("Número total de produtos não comprados: " + naoComprados);
    }

    /**
     * Método que imprime no ecrã o número total de clientes.
     *
     * @param clientes Número total de clientes
     */
    public void viewClientes(int clientes) {
        System.out.println("Número total de clientes: " + clientes);
    }

    /**
     * Método que imprime no ecrã o número de clientes sem compras.
     *
     * @param semCompra Número total de clientes sem compras.
     */
    public void viewClienteSemCompra(int semCompra) {
        System.out.println("Número de clientes sem compras: " + semCompra);
    }

    /**
     * Método que imprime no ecrã o número de vendas com o valor igual a 0.
     *
     * @param venda0 Número toal de vendas com valor igual a 0
     */
    public void viewVenda0(int venda0) {
        System.out.println("Número total de vendas com valor igual a 0: " + venda0);
    }

    /**
     * Método que imprime no ecrã o lucro.
     *
     * @param lucro Total de lucro
     */
    public void viewLucro(double lucro){
        System.out.println("Faturação total: " + lucro + " u.m");
        System.out.println("\n");
        System.out.println("Prima 0 para voltar ao menu inicial");

    }

    /**
     * Método que imprime no ecrã "FILIAL1".
     */
    public void imprimeFilial1(){
        System.out.println("\nFILIAL 1\n");
    }

    /**
     * Método que imprime no ecrã "FILIAL2".
     */
    public void imprimeFilial2(){
        System.out.println("\nFILIAL 2\n");
    }

    /**
     * Método que imprime no ecrã "FILIAL3".
     */
    public void imprimeFilial3(){
        System.out.println("\nFILIAL 3\n");
    }

    /**
     * Método que imprime no ecrã o que o utilizador deve inserir.
     */
    public void escolheFilial() {
        System.out.println("Insira a filial que pretende ver: ");
    }

    /**
     * Método que imprime no ecrã o que o utilizador deve inserir.
     */
    public void escolheMes() {
        System.out.println("Introduza um mês: ");
    }

    /**
     * Método que imprime no ecrã o que o utilizador deve inserir.
     */
    public void escolheCliente() {
        System.out.println("Insira o código de um cliente: ");
    }

    /**
     * Método que imprime no ecrã o que o utilizador deve inserir.
     */
    public void escolheNrCliente() {
        System.out.println("Insira o número de clientes que pretende ver: ");
    }

    /**
     * Método que imprime no ecrã o que o utilizador deve inserir.
     */
    public void escolheProduto() {
        System.out.println("Insira o produto que pretende analisar: ");
    }

    /**
     * Método que imprime no ecrã o que o utilizador deve inserir.
     */
    public void escolheNrProduto() {
        System.out.println("Insira o número de produtos que pretende ver: ");
    }

    /**
     * Método que imprime no ecrã o que o utilizador deve inserir.
     */
    public void escolheFilialGeral() {
        System.out.println("Insira a filial que pretende ver ou 0 para dados gerais: ");
    }

    public void escolheFilial10() {
        System.out.println("Insira a filial que pretende ver: ");
    }

    /**
     * Método que imprime no ecrã o que o utilizador deve inserir.
     */
    public void inserirNovaOpcao(){
        System.out.print("Insira uma nova opção ou 0 para voltar ao menu inicial -> ");
    }

    /**
     * Método que imprime no ecrã a consulta estatística a ser executada.
     */
    public void headStat3() {
        System.out.println("Consulta estatística: Número diferente de clientes por mês: ");
    }

    /**
     * Método que imprime no ecrã a consulta estatística a ser executada.
     */
    public void headStat2() {
        System.out.println("Consulta estatística: Lucro total por mês ");
    }

    /**
     * Método que imprime no ecrã a consulta estatística a ser executada.
     */
    public void headStat1() {
        System.out.println("Consulta estatística: Total de compras por mês");
    }

    /**
     * Método que imprime no ecrã a informação do que se trata a Query 2.
     */
    public void headQuery2() {
        System.out.println("Query 2 -----> Número total de vendas realizadas e número de clientes distintos que as fizeram(por filial)");
    }

    /**
     * Método que imprime no ecrã a informação do que se trata a Query 3.
     */
    public void headQuery3() {
        System.out.println("Query 3 -----> Compras, produtos e total gasto de um dado cliente por mês\n");
    }

    /**
     * Método que imprime no ecrã a informação do que se trata a Query 4.
     */
    public void headQuery4() {
        System.out.println("Query 4 ------> Número de vendas, total faturado e clientes que compraram um dado produto");
    }

    /**
     * Método que imprime no ecrã a informação do que se trata a Query 5.
     */
    public void headQuery5() {
        System.out.println("Query 5 ------> Produtos mais comprados por um dado cliente");
    }

    /**
     * Método que imprime no ecrã a informação do que se trata a Query 6.
     */
    public void headQuery6() {
        System.out.println("Query 6 ------> X produtos mais vendidos em todo o ano e número de clientes que os compraram");
    }

    /**
     * Método que imprime no ecrã a informação do que se trata a Query 7.
     */
    public void headQuery7() {
        System.out.println("Query 7 -------> 3 maiores compradores de cada filial: ");
    }

    /**
     * Método que imprime no ecrã a informação do que se trata a Query 8.
     */
    public void headQuery8() {
        System.out.println("Query 8 -----> X clientes que compraram mais produtos diferentes");
    }

    /**
     * Método que imprime no ecrã a informação do que se trata a Query 9.
     */
    public void headQuery9() {
        System.out.println("Query 9 -------> X clientes que compram um dado produto e valor gasto");
    }

    /**
     * Método que imprime no ecrã a informação do que se trata a Query 10.
     */
    public void headQuery10() {
        System.out.println("Query 10 -----> Faturação total com cada produto, filial a filial, mês a mês");
    }

    /**
     * Método que imprime no ecrã o resultado da Query 1.
     *
     * @param ret Dados já devidamente tratados para a Query 1
     */
    public void flowQuery1(Set<String> ret){
        ret.forEach(e -> System.out.println(e));
        System.out.println("Query 1 -------> Produtos nunca comprados e respetivo total\n");
        System.out.println("Número de produtos que não foram comprados ----> " + ret.size());
    }

    /**
     * Método que imprime no ecrã o resultado da Query 2.
     *
     * @param ret Dados já devidamente tratados para a Query 2
     */
    public void flowQuery2(Map<String, Integer> ret){
            Integer soma = ret.values().stream().mapToInt(Integer::valueOf).sum();
            System.out.println("Número de clientes diferentes no mês dado ---> " + ret.size());
            System.out.println("Número total de vendas executadas no mês dado ---> " + soma + "\n");
    }

    /**
     * Método que imprime no ecrã o resultado da Query 3.
     *
     * @param ret Dados já devidamente tratados para a Query 3
     */
    public void flowQuery3(List<Q3MonthInfo> ret) {
       int i = 1 ;
        for(Q3MonthInfo q: ret){
           PrintMonth(i);
           System.out.println(q.toString());
           i++;
       }
    }

    /**
     * Método que imprime no ecrã o resultado da Query 4.
     *
     * @param aux Dados já devidamente tratados para a Query 4
     */
    public void flowQuery4(Map<Integer, Q4MonthInfo> aux) throws NoProductFoundException {
        StringBuilder sb = new StringBuilder();

        if (aux == null) throw new NoProductFoundException();
        else {
            sb.append("\nJANEIRO:\n\n");
            sb.append(aux.get(1).toString());
            sb.append("\n");
            sb.append("FEVEREIRO\n\n");
            sb.append(aux.get(2).toString());
            sb.append("\n");
            sb.append("MARÇO\n\n");
            sb.append(aux.get(3).toString());
            sb.append("\n");
            sb.append("ABRIL\n\n");
            sb.append(aux.get(4).toString());
            sb.append("\n");
            sb.append("MAIO\n\n");
            sb.append(aux.get(5).toString());
            sb.append("\n");
            sb.append("JUNHO\n\n");
            sb.append(aux.get(6).toString());
            sb.append("\n");
            sb.append("JULHO\n\n");
            sb.append(aux.get(7).toString());
            sb.append("\n");
            sb.append("AGOSTO\n\n");
            sb.append(aux.get(8).toString());
            sb.append("\n");
            sb.append("SETEMBRO\n\n");
            sb.append(aux.get(9).toString());
            sb.append("\n");
            sb.append("OUTUBRO\n\n");
            sb.append(aux.get(10).toString());
            sb.append("\n");
            sb.append("NOVEMBRO\n\n");
            sb.append(aux.get(11).toString() + "\n");
            sb.append("DEZEMBRO\n" + "\n");
            sb.append(aux.get(12).toString());

            sb.toString();
        }
        System.out.println(sb);
    }

    /**
     * Método que imprime no ecrã o resultado da Query 5.
     *
     * @param vendas Dados já devidamente tratados para a Query 5
     */
    public void flowQuery5(List<Venda> vendas) throws NoClienteFoundException {
        if (vendas == null) throw new NoClienteFoundException();
        else {
            for (Venda v : vendas) {
                System.out.println(v.getProduto() + " ----> " + v.getQuantidade());
            }
        }
    }

    /**
     * Método que imprime no ecrã o resultado da Query 6.
     *
     * @param ret  Dados já devidamente tratados para a Query 6
     * @param x    Quantidade de dados que o utilizador pretende que sejam apresentados
     * @param ret2 Dados adicionais já devidamente tratados para a Query 6
     */
    public void flowQuery6(SortedSet<Map.Entry<String, Integer>> ret, int x, Map<String, Set<String>> ret2){
        Set set = ret;
        Iterator i = set.iterator();
        int p = 1;
            while (i.hasNext() && p <= x) {
                Map.Entry me = (Map.Entry) i.next();
                System.out.println(p + "º : " + me.getKey() + ": " + me.getValue() + " --> " + ret2.get(me.getKey()).size() + " clientes diferentes compraram o produto.");
                p++;
            }
    }

    /**
     * Método que imprime no ecrã o resultado da Query 7.
     *
     * @param filiais Dados já devidamente tatados para a Query 7
     */
    public void flowQuery7(List<Map<String,Double>> filiais){
        int i=1;
        for(Map<String,Double> fil: filiais){
            System.out.println("\nFilial " + i + "\n");
            PrintXBiggestD(fil, 3);
            i++;
        }
    }

    /**
     * Método que imprime no ecrã o resultado da Query 8.
     *
     * @param ret Dados já devidamente tratados para a Query 8
     * @param x   Quantidade de dados que o utilizador pretende que sejam exibidos
     */
    public void flowQuery8(Set<Pair> ret, int x){
        List<String> print = ret.stream().limit(x).map(Pair::toStringClientes).collect(Collectors.toList());
        print.forEach(e -> System.out.println(e));
    }

    /**
     * Método que imprime no ecrã o resultado da Query 9.
     *
     * @param clientes Dados já devidamente tratados para a Query 9
     * @param x        Quantidade de dados que o utilizador pretende que sejam exibidos
     * @param fat      Dados já devidamente tratados para a Query 9
     * @throws NoProductFoundException
     */
    public void flowQuery9(Map<String, Double> clientes, int x, Map<String, Double> fat) throws NoProductFoundException {
        if (clientes == null || fat == null) throw new NoProductFoundException();
        else {
            PrintXBiggestI(clientes, x, fat);
        }
    }

    /**
     * Método que impriem no ecrã o resultado da Query 10.
     *
     * @param ret Dados já devidamente tratados para a Query 10
     */
    public void flowQuery10(List<List<Map<String,Double>>> ret, int mes, int filial) throws WrongBranchException, WrongMonthException{
        int i = 0;
        if(mes    < 1 || mes > 12) throw new WrongMonthException();
        if(filial < 1 || filial > 3) throw new WrongBranchException();
        else{
                List<Map<String,Double>> test = ret.get(mes - 1);
                Map<String,Double> teste2 = test.get(filial - 1);
                    while(i < 50) {
                        for(String produto: teste2.keySet()){
                        System.out.println(produto + " -----> " + teste2.get(produto) + " u.m");
                        i++;
                        if(i == 49){
                            System.out.println("Pretende continuar a imprimir? ");
                            System.out.println("0 -> NÃO || 1 -> SIM");
                            int choice = Input.lerInt();
                            if(choice == 1) i = 0;
                            else if(choice == 0) i = 50;
                        }
                        if(i == 50) break;
                    }
                }
        }
    }

    /**
     * Método que impriem no ecrã o resultado da estatítica sobre o número total de compras por mês.
     *
     * @param ret Dados tratados para esta estatística
     */
    public void flowStat1(Map<Integer, Integer> ret){
        System.out.println("JANEIRO   -----> " + ret.get(1));
        System.out.println("FEVEREIRO -----> " + ret.get(2));
        System.out.println("MARÇO     -----> " + ret.get(3));
        System.out.println("ABRIL     -----> " + ret.get(4));
        System.out.println("MAIO      -----> " + ret.get(5));
        System.out.println("JUNHO     -----> " + ret.get(6));
        System.out.println("JULHO     -----> " + ret.get(7));
        System.out.println("AGOSTO    -----> " + ret.get(8));
        System.out.println("SETEMBRO  -----> " + ret.get(9));
        System.out.println("OUTUBRO   -----> " + ret.get(10));
        System.out.println("NOVEMBRO  -----> " + ret.get(11));
        System.out.println("DEZEMBRO  -----> " + ret.get(12));
    }

    /**
     * Método que impriem no ecrã o resultado da estatítica sobre a faturação de uma determinada filial por mês.
     *
     * @param ret Dados tratados para esta estatística
     */
    public void flowStat2(Map<Integer, Double> ret){
        System.out.println("JANEIRO   -----> " + ret.get(1));
        System.out.println("FEVEREIRO -----> " + ret.get(2));
        System.out.println("MARÇO     -----> " + ret.get(3));
        System.out.println("ABRIL     -----> " + ret.get(4));
        System.out.println("MAIO      -----> " + ret.get(5));
        System.out.println("JUNHO     -----> " + ret.get(6));
        System.out.println("JULHO     -----> " + ret.get(7));
        System.out.println("AGOSTO    -----> " + ret.get(8));
        System.out.println("SETEMBRO  -----> " + ret.get(9));
        System.out.println("OUTUBRO   -----> " + ret.get(10));
        System.out.println("NOVEMBRO  -----> " + ret.get(11));
        System.out.println("DEZEMBRO  -----> " + ret.get(12));
        System.out.println("TOTAL     -----> " + ret.get(13));
    }

    /**
     * Método que impriem no ecrã o resultado da estatítica sobre o número total de clientes diferentes que compraram numa determinada filial por mês.
     *
     * @param ret Dados tratados para esta estatística
     */
    public void flowStat3(Map<Integer, Set<String>> ret){
        System.out.println("JANEIRO   -----> " + ret.get(1).size());
        System.out.println("FEVEREIRO -----> " + ret.get(2).size());
        System.out.println("MARÇO     -----> " + ret.get(3).size());
        System.out.println("ABRIL     -----> " + ret.get(4).size());
        System.out.println("MAIO      -----> " + ret.get(5).size());
        System.out.println("JUNHO     -----> " + ret.get(6).size());
        System.out.println("JULHO     -----> " + ret.get(7).size());
        System.out.println("AGOSTO    -----> " + ret.get(8).size());
        System.out.println("SETEMBRO  -----> " + ret.get(9).size());
        System.out.println("OUTUBRO   -----> " + ret.get(10).size());
        System.out.println("NOVEMBRO  -----> " + ret.get(11).size());
        System.out.println("DEZEMBRO  -----> " + ret.get(12).size());
    }

    /**
     * Método que imprime no ecrã um map de uma determinda maneira.
     *
     * @param fi Map a ser impresso
     * @param x  Quantidade de valores a imprimir
     */
    private static void PrintXBiggestD(Map<String, Double> fi, int x) {
        int f = 1;
        for (Map.Entry<String, Double> entry : fi.entrySet()) {
            if (f <= x) System.out.println(f+"º"+entry.getKey() + ": " + entry.getValue().toString() + " u.m.");
            f++;
        }
    }

    /**
     * Método que imprime no ecrã dois map de uma determinda maneira.
     *
     * @param fi  Um dos map a ser impresso
     * @param x   Quantidade de valores a imprimir
     * @param ret Outro map que faz parte da impressão
     */
    private static void PrintXBiggestI(Map<String, Double> fi, int x, Map<String,Double> ret) {
        int f = 1;
        for (Map.Entry<String, Double> entry : fi.entrySet()) {
            if (f <= x) System.out.println(f+"º"+entry.getKey() + ": " + entry.getValue().toString() + " unidades / "+ret.get(entry.getKey())+" u.m");
            f++;
        }
    }

    /**
     * Método que imprime no ecrã o mês referente ao número do mesmo.
     *
     * @param i Número referente ao mẽs a imprimir
     */
    private static void PrintMonth(int i){
        if      (i == 1)  System.out.println("Janeiro: ");
        else if (i == 2)  System.out.println("Fevereiro: ");
        else if (i == 3)  System.out.println("Março: ");
        else if (i == 4)  System.out.println("Abril: ");
        else if (i == 5)  System.out.println("Maio: ");
        else if (i == 6)  System.out.println("Junho: ");
        else if (i == 7)  System.out.println("Julho: ");
        else if (i == 8)  System.out.println("Agosto: ");
        else if (i == 9)  System.out.println("Setembro: ");
        else if (i == 10) System.out.println("Outubro: ");
        else if (i == 11) System.out.println("Novembro: ");
        else if (i == 12) System.out.println("Dezembro: ");
    }

}
