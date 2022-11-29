import java.util.List;
import java.util.Vector;
import java.io.*;

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

    //===GETS AND SETS===
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


    //===CONSTRUTOR NORMAL===
    public Jogo(int ano, String etapa, int dia, int mes, String selecao1, int placarSelecao1, int placarSelecao2, String selecao2, String local) {
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

    //===CONSTRUTOR VAZIO===
    public Jogo() {
    }

}


//======================================================================================


//===LEITURA DE ARQUIVO===
class ArquivoTXTLeitura {
    private BufferedReader arquivo;

    public void abrirArquivo(String nomeArquivo) {
        try {
            arquivo = new BufferedReader(new FileReader(nomeArquivo));
        } catch (FileNotFoundException excecao) {
            System.out.println("Arquivo nao encontrado");
        }
    }

    public void fecharArquivo() {
        try {
            arquivo.close();
        } catch (IOException excecao) {
            System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);
        }
    }

    public String lerLinhaArquivo() {
        String linha = null;
        try {
            linha = arquivo.readLine();
        } catch (EOFException excecao) { //Excecao de final de arquivo.
            linha = null;
        } catch (IOException excecao) {
            System.out.println("Erro de leitura: " + excecao);
            linha = null;
        } finally {
            return linha;
        }
    }
}


//======================================================================================


//===ESCRITA DE ARQUIVO===
class ArquivoTextoEscrita {

    private BufferedWriter saida;

    ArquivoTextoEscrita(String nomeArquivo) {

        try {
            saida = new BufferedWriter(new FileWriter(nomeArquivo));
        } catch (FileNotFoundException excecao) {
            System.out.println("Arquivo nao encontrado");
        } catch (IOException excecao) {
            System.out.println("Erro na abertura do arquivo de escrita: " + excecao);
        }
    }

    public void fecharArquivo() {

        try {
            saida.close();
        } catch (IOException excecao) {
            System.out.println("Erro no fechamento do arquivo de escrita: " + excecao);
        }
    }

    public void escrever(String textoEntrada) {

        try {
            saida.write(textoEntrada);
            saida.newLine();
        } catch (IOException excecao) {
            System.out.println("Erro de entrada/saída " + excecao);
        }
    }
}


//======================================================================================


public class Main {


    static class Lista {
        Jogo lista[];
        int primeiro, ultimo, pos;


        Lista(int tam) {
            lista = new Jogo[tam];
            pos = -1;
            primeiro = 0;
            ultimo = 0;
        }


        Lista(){
            //construtor vazio
        }

        boolean vazia() {
            return (primeiro == ultimo);
        }

        void insere(Jogo x) {
            if (ultimo >= lista.length) {
                System.out.println("Erro: A lista esta cheia");
                return;
            }

            lista[ultimo] = x;
            ultimo++;
        }


        void imprime() {
            for (int aux = primeiro; aux < ultimo; aux++)
                imprimirJogo(lista[aux]);
        }


        Jogo pesquisa(Jogo jogoBuscado) {
            for (int p = 0; p < ultimo; p++)
                if (lista[p] == jogoBuscado)
                    return jogoBuscado;

            return jogoBuscado;
        }


        Jogo retiraPrimeiro() {
            if (vazia()) {
                System.out.println("Erro : A lista esta vazia");
                return null;
            }


            Jogo itemRemovido = lista[0];
            ultimo--;
            for (int aux = 0; aux < ultimo; aux++)
                lista[aux] = lista[aux + 1];

            return itemRemovido;
        }


        Jogo retira(Jogo chave) {
            if (vazia()) {
                System.out.println("Erro : A lista esta vazia");
                return null;
            }

            int p = 0;
            while (p < ultimo && lista[p] != chave)
                p++;// acha posição do elelemto a ser removido


            if (p >= ultimo)
                return null; //chave não está na lista

            Jogo itemRemovido = lista[p];
            ultimo--;

            for (int aux = p; aux < ultimo; aux++) // move elementos para tamar espaço vazio
                lista[aux] = lista[aux + 1];

            return itemRemovido;
        }

    }





    static void splitLinhaEntrada(Vector<Jogo> vetorJogosTXT, String busca, Lista listaDeJogos) { //de acordo com a saída padrão
        int dia, mes, ano;

        String[] textoSeparado = busca.split(";"); //separa a saída padrão em dia, mes, ano e uma das seleções que disputou a partida
        String pais = textoSeparado[1];
        textoSeparado = textoSeparado[0].split("/"); //separa a primeira parte em 3 (dia / mes / ano)

        dia = Integer.valueOf(textoSeparado[0]);
        mes = Integer.valueOf(textoSeparado[1]);
        ano = Integer.valueOf(textoSeparado[2]);

        procuraJogoNoVetor(vetorJogosTXT, pais, dia, mes, ano, listaDeJogos);
    }

    static void procuraJogoNoVetor(Vector<Jogo> vetorJogosTXT, String pais, int dia, int mes, int ano, Lista listaDeJogos) { //método para procurar os time no vetor e inserir em outro
        for (int i = 0; i < vetorJogosTXT.size(); i++)
            if (dia == vetorJogosTXT.get(i).getDia() && mes == vetorJogosTXT.get(i).getMes() && ano == vetorJogosTXT.get(i).getAno() && pais.equals(vetorJogosTXT.get(i).getSelecao1())){
               listaDeJogos.insere(vetorJogosTXT.get(i));
            }

    }


    static void criaJogo(Vector<Jogo> vetorJogosTXT, String linha) {

        String[] eachElement = linha.split("#"); //separa cada elemento da entrada padrão por #
        Jogo novoJogo = new Jogo(
                Integer.parseInt(eachElement[0]), //ano
                eachElement[1],//etapa
                Integer.parseInt(eachElement[2]), //dia
                Integer.parseInt(eachElement[3]), //mes
                eachElement[4], //seleção1
                Integer.parseInt(eachElement[5]), //placar seleção1
                Integer.parseInt(eachElement[6]), //placar seleção2
                eachElement[7], //seleção2
                eachElement[8] //local
        );
        vetorJogosTXT.add(novoJogo); // adiciona novo jogo ao fim do vetor

    }


    static void imprimirJogo(Jogo j) { //método toString para imprimir de acordo com a saída padrão
        System.out.println("[Copa " + j.getAno() + "] [" + j.getEtapa() + "] [" + j.getDia() + "/" + j.getMes() + "] [" + j.getSelecao1() + " (" + j.getPlacarSelecao1() + ") x (" + j.getPlacarSelecao2() + ") " + j.getSelecao2() + "] [" + j.getLocal() + "]");
    }


//======================================================================================


    //===MAIN===
    public static void main(String[] args) {
        MyIO.setCharset("UTF-8"); //Muda o charset da aplicação para Português
        ArquivoTXTLeitura arquivo = new ArquivoTXTLeitura();

        arquivo.abrirArquivo("partidas.txt");

        Vector<Jogo> vetorJogosTXT = new Vector<>(); //cria vetor de Objeto de capacidade Dinâmica


        while (true) { //Lê a entrada enquanto != FIM
            String linha = arquivo.lerLinhaArquivo();
            if (linha == null) {
                break;
            }
            criaJogo(vetorJogosTXT, linha); //preenche vetor com dados do TXT
        }
        arquivo.fecharArquivo();


        Lista listaDeJogos = new Lista(650); //cria uma nova lista de tamanho 650


        while (true) {
            String linha = MyIO.readLine(); // verde

            if (linha.equals("FIM"))
                break;

            splitLinhaEntrada(vetorJogosTXT, linha, listaDeJogos);


        }



    }
}

