import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public interface Query6Interface {
    SortedSet<Map.Entry<String, Integer>> getProductsMostSells(MainStruct mainStruct);
    Map<String, Set<String>> getDiferentsBuyers (MainStruct mainStruct);
}
