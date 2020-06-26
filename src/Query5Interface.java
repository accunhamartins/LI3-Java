import java.util.List;

public interface Query5Interface {
    List<Venda> mostBoughtByClient(MainStruct mainStruct, String cod) throws NoClienteFoundException;
}
