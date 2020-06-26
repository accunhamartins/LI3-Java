import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ProductReader implements Serializable {

    private Set<String> cp;

    /**
     * Construtores para objetos da classe ProductReader.
     */
    public ProductReader(){
        this.cp = new TreeSet<>();
    }

    public ProductReader(Set<String> cp){
        setCp(cp);
    }

    public ProductReader(ProductReader pr){
        setCp(pr.getCp());
    }

    public void setCp(Set<String> cp) {
        this.cp = new TreeSet<>();
        for(String s: cp) this.cp.add(s);
    }

    public Set<String> getCp() {
        return this.cp.stream().collect(Collectors.toSet());
    }

    /**
     * Método que passa um ficheiro com os produtos para um Set<String>.
     *
     * @return int com o numero de produtos que foram copiados
     * @throws FileNotFoundException
     */
    public int readFile() throws FileNotFoundException {
        BufferedReader br = null;
        Set<String> catalogo = new TreeSet<>();
        String line;
        try {
            br = new BufferedReader(new FileReader("input_files/Produtos.txt"));
            while ((line = br.readLine()) != null) {
                catalogo.add(line);
            }
            setCp(catalogo);
        } catch (IOException e) {
            System.out.println("Erro ao dar load");
        }
        return catalogo.size();
    }

    /**
     * Implementação do método hashCode para a classe ProductReader.
     *
     * @return Valor int gerado pelo algoritmo
     */
    public int hashCode(){
        return Arrays.hashCode(new Object[]{this.cp});
    }
}
