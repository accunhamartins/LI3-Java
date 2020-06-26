import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CatCliente implements Serializable {
    private Set<String> catalogoClientes;

    /**
     * Construtores para objetos da classe CatCliente.
     */
    public CatCliente(){
        this.catalogoClientes = new TreeSet<>();
    }

    public CatCliente(Set<String> catalogo){
        setCatalogoClientes(catalogo);
    }

    public CatCliente(CatCliente a){
        setCatalogoClientes(a.getCatalogoClientes());
    }

    public Set<String> getCatalogoClientes() {
        return this.catalogoClientes.stream().collect(Collectors.toSet());
    }

    public void setCatalogoClientes(Set<String> catalogoProdutos) {
        this.catalogoClientes = new TreeSet<>();
        for(String s: catalogoProdutos){
            this.catalogoClientes.add(s);
        }
    }

    /**
     * Implementação do método de clonagem de um CatCliente.
     *
     * @return Objeto do tipo CatCliente
     */
    public CatCliente clone(){
        return (new CatCliente(this));
    }

    /**
     * Implementação do método de igualdade entre dois CatCliente.
     *
     * @param obj CatCliente que é comparado com o recetor
     * @return boolean true ou false
     */
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        CatProd c = (CatProd) obj;
        return this.catalogoClientes.equals(c);
    }

    /**
     * Implementação do método toString para a classe CatCliente.
     *
     * @return String com a informação textoal do objeto CatCliente
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Códigos dos Clientes: ").append("\n");
        this.catalogoClientes.forEach(s -> sb.append(s).append("\n"));
        return sb.toString();
    }

    /**
     * Método que permite verificar se um dado cliente pertence ao objeto CatCliente.
     *
     * @param s Cliente a verificar a sua existencia
     * @return boolean true ou false
     */
    public boolean existe(String s){
        return this.catalogoClientes.contains(s);
    }

    /**
     * Implementação do método hashCode para a classe CatCliente.
     *
     * @return Valor int gerado pelo algoritmo
     */
    public int hashCode(){
        return Arrays.hashCode(new Object[]{this.catalogoClientes});
    }

}
