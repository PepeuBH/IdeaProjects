public class Produto {
    public String nome;
    public double preco;
    public int quant;


    public double totalValueInStock(){
        return preco * quant;
    }

    public void addProduto(int quant){
        this.quant  += quant;
    }

    public void removeProduto(int quant){
        this.quant -= quant;
    }

}
