import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ClientReader implements Serializable {

    private Set<String> cc;

    /**
     * Construtores para objetos da classe ClientReader.
     */
    public ClientReader(){
        this.cc = new TreeSet<>();
    }

    public ClientReader(Set<String> cc){
        setCc(cc);
    }

    public ClientReader(ClientReader cr){
        setCc(cr.getCc());
    }

    public void setCc(Set<String> cc) {
        this.cc = new TreeSet<>();
        for(String s: cc) this.cc.add(s);
    }

    public Set<String> getCc() {
        return this.cc.stream().collect(Collectors.toSet());
    }


    /**
     * Método que passa um ficheiro com os clientes para um Set<String>.
     *
     * @return int com o numero de clientes que foram copiados
     * @throws FileNotFoundException
     */
    public int readFile() throws FileNotFoundException {
        BufferedReader br = null;
        Set<String> catalogo = new TreeSet<>();
        String line;
        try {
            br = new BufferedReader(new FileReader("input_files/Clientes.txt"));
            while ((line = br.readLine()) != null) {
                catalogo.add(line);
            }
            setCc(catalogo);

        } catch (IOException e) {
            System.out.println("Erro ao dar load");
        }
        return catalogo.size();
    }

    /**
     * Implementação do método hashCode para a classe ClientReader.
     *
     * @return Valor int gerado pelo algoritmo
     */
    public int hashCode(){
        return Arrays.hashCode(new Object[]{this.cc});
    }
}
