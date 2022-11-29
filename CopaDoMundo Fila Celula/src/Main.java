
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.util.Collections;

// --------------------------------------------

class Jogo {
    private int dia;
    private int mes;
    private int ano;
    private String etapa;
    private String selecao1;
    private String selecao2;
    private int placarSelecao1;
    private int placarSelecao2;
    private String local;

    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");
        ArquivoTextoLeitura texto = new ArquivoTextoLeitura("partidas.txt");// endereço para acesso do arquivo no VERDE

        Vector<Jogo> vetorJogos = new Vector<Jogo>();

        FilaD fila = new FilaD(); // construtor Fila dinamica

        /*----------- Leitura dados abertos do arquivo -------------------*/
        while (true) {
            String linha = texto.ler();
            if (linha == null) {
                texto.fecharArquivo();
                break;
            }
            criaJogo(vetorJogos, linha);

        }
        texto.fecharArquivo();



        /* ------- entrada de dados Pelo verde ---------------------------------- */
        while (true) {
            String linha = MyIO.readLine(); // verde

            if (linha.equals("FIM"))
                break;

            Jogo temp = buscaJogoParse(vetorJogos, linha);

            fila.enfileira(temp);

            System.out.println(fila.SaldoGols());
        }
        /* -----------------Jogos enfileirados - OK ------------------ */



        /*Ações de enfileirar e desenfileirar --------------------------*/
        int numBuscas = MyIO.readInt();// leitura numeros de Jogos a serem enfileirados
        for (int i = 0; i < numBuscas; i++) {
            String linha = MyIO.readLine(); // verde

            if (linha.charAt(0) == 'E') {// se começar com letra E

                String newStr = linha.substring(2);// remove "E " da linha (dois caracteres iniciais)
                Jogo temp = buscaJogoParse(vetorJogos, newStr);
                fila.enfileira(temp);

                System.out.println(fila.SaldoGols());

            } else
                fila.desenfileira().toStringJogos();

        }

        // ações de esvaziar Fila
        while (!fila.vazia())
            fila.desenfileira().toStringJogos();

    }

    private void toStringJogos() {
       //=============================================Como Faz isso????????????????????????????????????======================================
    }

    private static Jogo buscaJogoParse(Vector<Jogo> vetorJogos, String busca) {
        int dia, mes, ano;

        String[] textoSeparado = busca.split(";");
        String pais = textoSeparado[1];
        textoSeparado = textoSeparado[0].split("/");

        dia = Integer.valueOf(textoSeparado[0]);
        mes = Integer.valueOf(textoSeparado[1]);
        ano = Integer.valueOf(textoSeparado[2]);

        return busca(vetorJogos, pais, dia, mes, ano);
    }

    private static Jogo busca(Vector<Jogo> vetorJogos, String pais, int dia, int mes, int ano) {
        Celula aux;
        aux = fil
        for(int i = 0; i < vetorJogos.size(); i++){
            if()
        }

        return null;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getSelecao1() {
        return selecao1;
    }

    public void setSelecao1(String selecao1) {
        this.selecao1 = selecao1;
    }

    public String getSelecao2() {
        return selecao2;
    }

    public void setSelecao2(String selecao2) {
        this.selecao2 = selecao2;
    }

    public int getPlacarSelecao1() {
        return placarSelecao1;
    }

    public void setPlacarSelecao1(int placarSelecao1) {
        this.placarSelecao1 = placarSelecao1;
    }

    public int getPlacarSelecao2() {
        return placarSelecao2;
    }

    public void setPlacarSelecao2(int placarSelecao2) {
        this.placarSelecao2 = placarSelecao2;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    Jogo(int ano, String etapa, int dia, int mes, String selecao1, int placarSelecao1, int placarSelecao2,
         String selecao2, String local) { // completo
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;

        this.etapa = etapa;
        this.selecao1 = selecao1;
        this.selecao2 = selecao2;

        this.placarSelecao1 = placarSelecao1;
        this.placarSelecao2 = placarSelecao2;
        this.local = local;
    }

    private static void criaJogo(Vector<Jogo> vetorJogos, String a) {
        String[] textoSeparado = a.split("#");// quebra o vetor nas posições marcadas péeplo #
        Jogo j = new Jogo(Integer.valueOf(textoSeparado[0]), // data
                textoSeparado[1], // fase
                Integer.valueOf(textoSeparado[2]), // dia
                Integer.valueOf(textoSeparado[3]), // mes
                textoSeparado[4], // time 1
                Integer.valueOf(textoSeparado[5]), // palacar 1
                Integer.valueOf(textoSeparado[6]), // placar 2
                textoSeparado[7], // time 2
                textoSeparado[8]); // local
        vetorJogos.add(j);

    }
}


/*-----------------Fila Dinamica --------------------------------------*/
class FilaD {
    Celula frente;
    Celula tras;

    FilaD() {
        frente = new Celula();// alocação de memoria
        tras = frente;
        frente.prox = null;
    }

    boolean vazia() {
        return (frente == tras);
    }

    void enfileira(Jogo x) {
        tras.prox = new Celula();// alocação de memoria
        tras = tras.prox;
        tras.item = x;
        tras.prox = null;
    }

    Jogo desenfileira() {
        Jogo item = null;

        if (vazia()) {
            System.out.println("Erro: A fila esta vazia");
            return item;
        }

        frente = frente.prox;
        item = frente.item;
        return item;
    }

    public int SaldoGols() {
        int gols = 0;
        /* Implementar este metodo-------------- */

        return gols;
    }

}

/*--------------Classe Célula----------------------------------*/
class Celula {// pode ser uma classe interna
    // Trata-se de uma classe que só faz sentido em conjunto com a classe externa.
    Jogo item;
    Celula prox;
}



//----------------Casse para lidar com arquivos -----------------------------------------

class ArquivoTextoLeitura {

    private BufferedReader entrada;

    public ArquivoTextoLeitura(String nomeArquivo) {

        try {
            entrada = new BufferedReader(new FileReader(nomeArquivo));
        } catch (FileNotFoundException excecao) {
            System.out.println("Arquivo nao encontrado");
        }
    }

    public void fecharArquivo() {

        try {
            entrada.close();
        } catch (IOException excecao) {
            System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);
        }
    }

    @SuppressWarnings("finally")
    public String ler() {

        String textoEntrada = null;

        try {
            textoEntrada = entrada.readLine();
        } catch (EOFException excecao) { // Excecao de final de arquivo.
            textoEntrada = null;
        } catch (IOException excecao) {
            System.out.println("Erro de leitura: " + excecao);
            textoEntrada = null;
        } finally {
            return textoEntrada;
        }
    }
}
