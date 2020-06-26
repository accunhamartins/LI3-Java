import java.util.List;

public interface Query3Interface {
    List<Q3MonthInfo> monthlyCostumerInformation(String x, MainStruct mainStruct) throws NoClienteFoundException;
}

