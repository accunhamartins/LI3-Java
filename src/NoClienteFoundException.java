import java.io.Serializable;

public class NoClienteFoundException extends Exception implements Serializable {
    public NoClienteFoundException() {
        super("O cliente inserido é inválido");
    }
}