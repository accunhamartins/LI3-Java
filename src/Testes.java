import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Testes {

    /**
     * Método que testa a leitura de um file txt usando a classe bufferedreader.
     *
     * @param file Fiheiro a ser a objeto no teste
     * @return List das vendas lidas do ficheiro
     * @throws FileNotFoundException
     */
    public static List<String> readFileBR(String file) throws FileNotFoundException{
        BufferedReader br = null;
        String line;
        List<String> ret = new ArrayList<>();
        int total = 0;
        try{
            br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){
                ret.add(line);

            }
        } catch (IOException e){
            System.out.println("Erro no load");
        }
        return ret;
    }

    /**
     * Método que testa a leitura e parsing com bufferedreader.
     *
     * @param file Ficheiro a ser objeto no teste
     * @return Número de linhas lidas do ficheiro
     * @throws FileNotFoundException
     */
    public static int readFileParsingBR(String file) throws FileNotFoundException{
        BufferedReader br = null;
        String line;
        int total = 0;
        try{
            br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){
                String[] campos = line.split(" ");
                String produto = campos[0];
                Double preco = Double.parseDouble(campos[1]);
                int quantidade = Integer.parseInt(campos[2]);
                char promo = campos[3].charAt(0);
                String cliente = campos[4];
                int mes = Integer.parseInt(campos[5]);
                int filial = Integer.parseInt(campos[6]);
                total++;
            }
        } catch (IOException e){
            System.out.println("Erro no load");
        }
        return total;
    }

    /**
     * Método que testa a leitura, parsing e validação das linhas de venda com bufferedreader.
     *
     * @param file Fiheiro a ser a objeto no teste
     * @return Número de linhas de vendas válidas
     * @throws FileNotFoundException
     */
    public static int parsingNValidationBR(String file) throws FileNotFoundException{
        BufferedReader br = null;
        String line;
        int validos = 0;
        ClientReader cr = new ClientReader();
        ProductReader pr = new ProductReader();
        pr.readFile();
        cr.readFile();
        CatProd cp = new CatProd(pr.getCp());
        CatCliente cc = new CatCliente((cr.getCc()));

        try{
            br = new BufferedReader(new FileReader(file));
            while((line = br.readLine()) != null){
                String[] campos = line.split(" ");
                String produto = campos[0];
                Double preco = Double.parseDouble(campos[1]);
                int quantidade = Integer.parseInt(campos[2]);
                char promo = campos[3].charAt(0);
                String cliente = campos[4];
                int mes = Integer.parseInt(campos[5]);
                int filial = Integer.parseInt(campos[6]);

                if(cp.existe(produto) && cc.existe(cliente)){
                    new Venda(produto, preco, quantidade, promo, cliente, mes, filial);
                    validos++;
                }
            }
        } catch (IOException e){
            System.out.println("Erro no load");
        }
        return validos;
    }

    /**
     * Método que testa a leitura de um file txt usando a classe files.
     *
     * @param file Ficheiro a ser objeto no teste
     * @return List das vendas lidas do ficheiro
     * @throws FileNotFoundException
     */
    public static List<String> readFileFiles(String file) throws FileNotFoundException{
        List<String> lines = new ArrayList<>();
        try { lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8); }
        catch(IOException exc) { System.out.println("Erro ao dar load dos logs."); }
        return lines;
    }

    /**
     * Método que testa a leitura e parsing com files
     *
     * @param file Ficheiro a ser objeto no teste
     * @return Número de linhas lidas do ficheiro
     * @throws FileNotFoundException
     */
    public static int readFileParsingFile(String file) throws FileNotFoundException{
        List<String> lines = readFileFiles(file);
        for(String s: lines){
            String[] campos = s.split(" ");
            String produto = campos[0];
            Double preco = Double.parseDouble(campos[1]);
            int quantidade = Integer.parseInt(campos[2]);
            char promo = campos[3].charAt(0);
            String cliente = campos[4];
            int mes = Integer.parseInt(campos[5]);
            int filial = Integer.parseInt(campos[6]);
        }
        return lines.size();
    }

    /**
     * Método que testa a leitura, parsing e validação das linhas de venda com files.
     *
     * @param file Ficheiro a ser objeto no teste
     * @return Número de linhas lidas do ficheiro
     * @throws FileNotFoundException
     */
    public static int parsingNValidationFiles(String file) throws FileNotFoundException {
        int validosF = 0;
        ClientReader crF = new ClientReader();
        ProductReader prF = new ProductReader();
        prF.readFile();
        crF.readFile();
        CatProd cp = new CatProd(prF.getCp());
        CatCliente cc = new CatCliente((crF.getCc()));
        List<String> lines = readFileFiles(file);
        for (String s : lines) {
            String[] campos = s.split(" ");
            String produto = campos[0];
            Double preco = Double.parseDouble(campos[1]);
            int quantidade = Integer.parseInt(campos[2]);
            char promo = campos[3].charAt(0);
            String cliente = campos[4];
            int mes = Integer.parseInt(campos[5]);
            int filial = Integer.parseInt(campos[6]);

            if (cp.existe(produto) && cc.existe(cliente)) {
                new Venda(produto, preco, quantidade, promo, cliente, mes, filial);
                validosF++;

            }
        }
        return validosF;
    }

    /**
     * Método que tranforma um ficheiro de clientes numa List.
     *
     * @return List com os clientes lidos
     */
    public static List<String> readClientFiles(){
        List<String> lines = new ArrayList<>();
        try { lines = Files.readAllLines(Paths.get("input_files/Clientes.txt"), StandardCharsets.UTF_8); }
        catch(IOException exc) { System.out.println("Erro ao dar load dos logs."); }
        return lines;
    }


    /**
     * Método que tranforma um ficheiro de produtos numa List.
     *
     * @return List com os produtos lidos
     */
    public static List<String> readProductFiles(){
        List<String> lines = new ArrayList<>();
        try { lines = Files.readAllLines(Paths.get("input_files/Produtos.txt"), StandardCharsets.UTF_8); }
        catch(IOException exc) { System.out.println("Erro ao dar load dos logs."); }
        return lines;
    }

    /**
     * Método que testa o load completo usando files
     *
     * @param file Ficheiro com as vendas a ser objeto de teste
     * @return MainStruct com os dados de todos os ficheiros, devidamente organizados
     * @throws FileNotFoundException
     */
    public static MainStruct completLoadFiles(String file) throws FileNotFoundException {
        List<String> cc1 = readClientFiles();
        List<String> cp1 = readProductFiles();
        Set<String> aux1 = new TreeSet<>();
        Set<String> aux2 = new TreeSet<>();
        for(String s: cp1){
            aux1.add(s);
        }

        for(String s: cc1){
            aux2.add(s);
        }

        CatProd cp = new CatProd(aux1);
        CatCliente cc = new CatCliente(aux2);

        List<Venda> vendas = new ArrayList<>();
        List<String> lines = readFileFiles(file);
        for (String s : lines) {
            String[] campos = s.split(" ");
            String produto = campos[0];
            Double preco = Double.parseDouble(campos[1]);
            int quantidade = Integer.parseInt(campos[2]);
            char promo = campos[3].charAt(0);
            String cliente = campos[4];
            int mes = Integer.parseInt(campos[5]);
            int filial = Integer.parseInt(campos[6]);

            if (cp.existe(produto) && cc.existe(cliente)) {
                vendas.add(new Venda(produto, preco, quantidade, promo, cliente, mes, filial));
            }
        }

        List<Venda> t = vendas.stream().map(Venda::clone).collect(Collectors.toList());

        Faturacao faturacao = new Faturacao();
        Map<String, List<Venda>> fp = faturacao.colocaVendasProduto(t);
        faturacao = new Faturacao(fp);
        Filial filial = new Filial();
        Map<String, List<Venda>> fc = filial.colocaVendasCliente(t);
        Map<Integer, List<Venda>> fil = filial.colocaVendas(t);
        filial = new Filial(fil, fc);

        System.out.println("Foram validadas " + t.size() + " linhas");

        return new MainStruct(cp.clone(), cc.clone(), faturacao.clone(), filial.clone());

    }

    /**
     * Método que testa o load completo usando bufferedreader
     *
     * @param file Ficheiro com as vendas a ser objeto de teste
     * @return MainStruct com os dados de todos os ficheiros, devidamente organizados
     * @throws FileNotFoundException
     */
    public static MainStruct completLoadBR(String file) throws FileNotFoundException{
        int validos = 0;
        ClientReader cr = new ClientReader();
        ProductReader pr = new ProductReader();
        pr.readFile();
        cr.readFile();
        CatProd cp = new CatProd(pr.getCp());
        CatCliente cc = new CatCliente((cr.getCc()));
        List<String> lines = readFileBR(file);
        List<Venda> vendas = new ArrayList<>();
        for(String s: lines) {
            String[] campos = s.split(" ");
            String produto = campos[0];
            Double preco = Double.parseDouble(campos[1]);
            int quantidade = Integer.parseInt(campos[2]);
            char promo = campos[3].charAt(0);
            String cliente = campos[4];
            int mes = Integer.parseInt(campos[5]);
            int filial = Integer.parseInt(campos[6]);

            if (cp.existe(produto) && cc.existe(cliente)) {
                vendas.add(new Venda(produto, preco, quantidade, promo, cliente, mes, filial));
                validos++;
            }
        }

        Faturacao faturacao = new Faturacao();
        Map<String, List<Venda>> fp = faturacao.colocaVendasProduto(vendas);
        faturacao = new Faturacao(fp);
        Filial filial = new Filial();
        Map<String, List<Venda>> fc = filial.colocaVendasCliente(vendas);
        Map<Integer, List<Venda>> fil = filial.colocaVendas(vendas);
        filial = new Filial(fil, fc);

        System.out.println("Foram validadas " + vendas.size() + " linhas");

        return new MainStruct(cp.clone(), cc.clone(), faturacao.clone(), filial.clone());
    }


    /**
     * Método main dos testes.
     *
     * @throws FileNotFoundException
     * @throws NoClienteFoundException
     * @throws NoProductFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, NoClienteFoundException, NoProductFoundException{
        String ficheiroBase = "input_files/Vendas_1M.txt";
        String teste3M = "/home/andre141/Desktop/Vendas_3M.txt";
        String teste5M = "/home/andre141/Desktop/Vendas_5M.txt";

        /* Teste de load usando as Classes BufferedReader e Files*/
        System.out.println("TESTE PARA LEITURA DE FILE TXT USANDO A CLASSE BUFFEREDREADER");
        Crono.start();
        int lido = readFileBR(ficheiroBase).size();
        Crono.stop();
        System.out.println(Crono.getTImeString());
        System.out.println("Foram lidas " + lido + " linhas");

        System.out.println("\nTESTE PARA LEITURA DE FILE TXT USANDO A CLASSE FILES");
        Crono.start();
        List<String> test = readFileFiles(ficheiroBase);
        Crono.stop();
        System.out.println(Crono.getTImeString());
        System.out.println("Foram lidas " + test.size() + " linhas");

        /* Teste para leitura e parsing */
        System.out.println("\nTESTE PARA LEITURA E PARSING COM BUFFEREDREADER");
        Crono.start();
        int lidoParsing = readFileParsingBR(ficheiroBase);
        Crono.stop();
        System.out.println(Crono.getTImeString());
        System.out.println("Foram lidas " + lidoParsing + " linhas");

        System.out.println("\nTESTE PARA LEITURA E PARSING COM FILES");
        Crono.start();
        int lidoParsingFiles = readFileParsingFile(ficheiroBase);
        Crono.stop();
        System.out.println(Crono.getTImeString());
        System.out.println("Foram lidas " + lidoParsingFiles + " linhas");

        /*Parsing e validação */
        System.out.println("\nTESTE PARA LEITURA, PARSING E VALIDAÇÃO DAS LINHAS DE VENDA COM BUFFEREDREADER");
        Crono.start();
        int lidoValido = parsingNValidationBR(ficheiroBase);
        Crono.stop();
        System.out.println(Crono.getTImeString());
        System.out.println("Foram validadas " + lidoValido + " linhas");


        System.out.println("\nTESTE PARA LEITURA, PARSING E VALIDAÇÃO DAS LINHAS DE VENDA COM FILES");
        Crono.start();
        int lidoValidoF = parsingNValidationFiles(ficheiroBase);
        Crono.stop();
        System.out.println(Crono.getTImeString());
        System.out.println("Foram validadas " + lidoValidoF + " linhas");


        /*Teste para load completo dos ficheiros txt para as estruturas de dados */
        System.out.println("\nTESTE PARA O LOAD COMPLETO USANDO BUFFEREDREADER");
        Crono.start();
        MainStruct ms = completLoadBR(ficheiroBase);
        Crono.stop();
        System.out.println(Crono.getTImeString());

        System.out.println("\nTESTE PARA O LOAD COMPLETO USANDO FILES");
        Crono.start();
        MainStruct ms1 = completLoadFiles(ficheiroBase);
        Crono.stop();
        System.out.println(Crono.getTImeString());

        GestVendas teste = new GestVendas(ms.clone());

        /*Teste para query 5 */
        System.out.println("\n TESTE PARA A QUERY 5");
        Crono.start();
        teste.mostBoughtByClient("F2916");
        Crono.stop();
        System.out.println(Crono.getTImeString());

        /*Teste para query 6 */
        System.out.println("\n TESTE PARA A QUERY 6");
        Crono.start();
        teste.getDiferentsBuyers();
        Crono.stop();
        System.out.println(Crono.getTImeString());

        /*Teste para query 7 */
        System.out.println("\n TESTE PARA A QUERY 7");
        Crono.start();
        teste.Biggest3ClientsBranch();
        Crono.stop();
        System.out.println(Crono.getTImeString());

        /*Teste para query 8 */
        System.out.println("\n TESTE PARA A QUERY 8");
        Crono.start();
        teste.XClientsDiffProducts();
        Crono.stop();
        System.out.println(Crono.getTImeString());

        /*Teste para query 9 */
        System.out.println("\n TESTE PARA A QUERY 9");
        Crono.start();
        teste.getXBetterClientsOfProductY("KR1583");
        teste.getXBetterClientsOfProductYFat("KR1583");
        Crono.stop();
        System.out.println(Crono.getTImeString());
    }
}
