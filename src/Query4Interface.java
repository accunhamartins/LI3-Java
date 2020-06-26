import java.util.Map;

public interface Query4Interface {
    Map<Integer, Q4MonthInfo> productBougthByMonth(MainStruct mainStruct, String cod) throws NoProductFoundException;
}

