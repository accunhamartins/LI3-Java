import java.util.Map;

public interface Query2Interface {
    Map<String, Integer> getSellsByMonthAndFilial(int mes, int filial, MainStruct mainStruct) throws WrongMonthException, WrongBranchException;
}
