import java.util.Map;

public interface Query9Interface {
    Map<String, Double> getXBetterClientsOfProductY(MainStruct mainStruct, String y) throws NoProductFoundException;
    Map<String, Double> getXBetterClientsOfProductYFat(MainStruct mainStruct, String y) throws NoProductFoundException;
}
