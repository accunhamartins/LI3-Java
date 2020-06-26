import java.io.Serializable;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CatProd implements Serializable {
   private Set<String> catalogoProdutos;

    /**
     * Construtores para objetos da classe CatProd.
     */
   public CatProd(){
       this.catalogoProdutos = new TreeSet<>();
   }

   public CatProd(Set<String> catalogo){
       setCatalogoProdutos(catalogo);
   }

   public CatProd(CatProd a){
       setCatalogoProdutos(a.getCatalogoProdutos());
   }

    public Set<String> getCatalogoProdutos() {
        return this.catalogoProdutos.stream().collect(Collectors.toSet());
    }

    public void setCatalogoProdutos(Set<String> catalogoProdutos) {
        this.catalogoProdutos = new TreeSet<>();
        for(String s: catalogoProdutos){
            this.catalogoProdutos.add(s);
        }
    }

    /**
     * Implementação do método de clonagem de um CatProd.
     *
     * @return Objeto do tipo CatProd
     */
    public CatProd clone(){
       return (new CatProd(this));
    }

    /**
     * Implementação do método de igualdade entre dois CatProd.
     *
     * @param obj CatProd que é comparado com o recetor
     * @return boolean true ou false
     */
    public boolean equals(Object obj){
       if(obj == this) return true;
       if(obj == null || obj.getClass() != this.getClass()) return false;
       CatProd c = (CatProd) obj;
       return this.catalogoProdutos.equals(c);
    }

    /**
     * Implementação do metodo toString para a classe CatProd.
     *
     * @return String com a informação textoal do objeto CatProd
     */
    public String toString(){
       StringBuilder sb = new StringBuilder();
       sb.append("Códigos dos produtos: ").append("\n");
       this.catalogoProdutos.forEach(s -> sb.append(s).append("\n"));
       return sb.toString();
    }

    /**
     * Método que permite verificar se um dado produto pertence ao objeto CatProd.
     *
     * @param s Produto a verificar a sua existencia
     * @return boolean true ou false
     */
    public boolean existe(String s){
       return this.catalogoProdutos.contains(s);
    }

    /**
     * Implementação do método hashCode para a classe CatProd.
     *
     * @return Valor int gerado pelo algoritmo
     */
    public int hashCode(){
        return Arrays.hashCode(new Object[]{this.catalogoProdutos});
    }
}
