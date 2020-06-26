import java.io.Serializable;

public class NoProductFoundException extends Exception implements Serializable {
    public NoProductFoundException(){
        super("O produto é inválido");
    }
}
