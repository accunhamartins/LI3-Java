import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public interface GestVendasInterface {
    void load(String path) throws FileNotFoundException;
    Set<String> getNoneBoughtProducts();
    Map<String,Integer> getSellsByMonthAndFilial(int mes, int filial) throws WrongMonthException, WrongBranchException;
    List<Q3MonthInfo> monthlyCostumerInformation(String cliente) throws NoClienteFoundException;
    Map<Integer, Q4MonthInfo> productBougthByMonth(String cod) throws NoProductFoundException;
    List<Venda> mostBoughtByClient(String cliente) throws NoClienteFoundException;
    SortedSet<Map.Entry<String, Integer>> getProductsMostSells();
    Map<String, Set<String>> getDiferentsBuyers ();
    List<Map<String,Double>> Biggest3ClientsBranch();
    Set<Pair> XClientsDiffProducts();
    Map<String, Double> getXBetterClientsOfProductY(String produto) throws NoProductFoundException;
    Map<String, Double> getXBetterClientsOfProductYFat(String produto) throws NoProductFoundException;
    List<List<Map<String,Double>>> BillingByBranch();
    Map<Integer, Integer> totalBuysPerMonth();
    Map<Integer, Double> totalProfit(int filial);
    Map<Integer, Set<String>> differentBuyers(int filial);
    GestVendas clone();
    void gravarFicheiro(String filename) throws IOException, FileNotFoundException;
    GestVendas lerFicheiro(String filename) throws IOException, ClassNotFoundException;
}
