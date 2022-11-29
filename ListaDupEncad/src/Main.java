
import java.io.*;
import java.util.Vector;

public class Main {
    static class Jogo {
        public int dia;
        public int mes;
        public int ano;
        public String etapa;
        public String selecao1;
        public String selecao2;
        public int placarSelecao1;
        public int placarSelecao2;
        public String local;


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


        Jogo(int ano, String etapa, int dia, int mes, String selecao1, int placarSelecao1, int placarSelecao2, String selecao2, String local) {
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


    }


    //====================================================================


    //===LISTA===
    static class Lista {
        Celula primeiro;
        Celula ultimo;

        Lista() {                       //CONSTRUTOR
            primeiro = new Celula();
            ultimo = primeiro;
            primeiro.prox = null;
            primeiro.prev = null;

        }

        boolean vazia() {
            return (primeiro == ultimo);
        }

        void insereUltimo(Jogo item) {
            ultimo.prox = new Celula();
            ultimo.prox.item = item;
            ultimo.prox.prox = null;
            ultimo.prox.prev = ultimo;
            ultimo = ultimo.prox;
        }


        void insereInicio(Jogo item) {
            Celula aux = primeiro.prox;

            boolean flag = false;
            if (vazia())                    //lista vazia, tratar ultimo elemento
                flag = true;

            primeiro.prox = new Celula();
            primeiro.prox.item = item;
            primeiro.prox.prox = aux;
            primeiro.prox.prev = primeiro;

            if (!flag)
                primeiro.prox.prox.prev = primeiro.prox;

            if (flag)
                ultimo = primeiro.prox;
        }


        void imprimeInicioFim() {                   //imprime do inicio ao fim
            Celula aux = primeiro.prox;
            while (aux != null) {
                System.out.println("[Copa " + aux.item.ano + "] [" + aux.item.etapa + "] [" + aux.item.dia + "/" + aux.item.mes + "] [" + aux.item.selecao1 + " (" + aux.item.placarSelecao1 + ") x (" + aux.item.placarSelecao2 + ") " + aux.item.selecao2 + "] [" + aux.item.local + "]");
                aux = aux.prox;
            }


        }

        void imprimeFimInicio() {           //imprime do fim ao inicio
            Celula aux = ultimo;
            while (aux.prev != null) {
                System.out.print("[Copa " + aux.item.ano + "] [" + aux.item.etapa + "] [" + aux.item.dia + "/" + aux.item.mes + "] [" + aux.item.selecao1 + " (" + aux.item.placarSelecao1 + ") x (" + aux.item.placarSelecao2 + ") " + aux.item.selecao2 + "] [" + aux.item.local + "]");
                aux = aux.prev;
            }


        }


        void InsereMeio(Jogo item, int pos) {           //insere na posicao do meio
            Celula aux = new Celula();
            aux.item = item;
            aux.prox = null;

            // acha posição de inserir
            Celula auxTras = primeiro;
            Celula auxFrente = primeiro.prox;

            while (auxFrente != null) {
                if (pos == 0) {
                    aux.prox = auxFrente;
                    auxFrente.prev = aux;

                    aux.prev = auxTras;
                    auxTras.prox = aux;
                    return;
                }
                auxTras = auxTras.prox;
                auxFrente = auxFrente.prox;
                pos--;
            }
        }


//        void InsereEmPos(Jogo item, int pos){
//            Celula aux = new Celula();
//            aux.item = item;
//            aux.prox = null;
//
//            aux.prox = primeiro.prox;
//            aux.prev = p
//        }


//        int pesquisa(Jogo chave) {
//            if (vazia() || chave < 0) {
//                System.out.println("\n Lista vazia!");
//                return -1;
//            }
//
//            Celula aux = primeiro;
//            while (aux.prox != null) {
//                if (aux.prox.item == chave)
//                    return 1;
//                aux = aux.prox;
//            }
//            return -1;
//        }


//        Jogo retira(Jogo chave) {
//            if (vazia() || chave < 0) {
//                System.out.println("\n Lista vazia!");
//                return -1;
//            }
//
//            Celula aux = primeiro;
//            while (aux.prox != null && aux.prox.item != chave)
//                aux = aux.prox;
//
//            if (aux.prox == null)
//                return -1; //Chave não encontrada
//
//
//            Jogo item = aux.prox.item;
//
//            aux.prox = aux.prox.prox;
//
//            if (aux.prox == null)
//                ultimo = aux;
//
//            return item;
//        }


//        Jogo retiraPrimeiro() {
//            if (vazia()) {
//                System.out.println("\n Lista vazia!");
//                return -1;
//            }
//
//            Celula aux = primeiro;
//            Jogo item = aux.prox.item;
//            aux.prox.prox.prev = aux;
//            aux.prox = aux.prox.prox;
//
//
//            if (aux.prox == null)
//                ultimo = aux;
//            return item;
//        }


//        Jogo retiraUltimo() {
//            if (vazia()) {
//                System.out.println("\n Lista vazia!");
//                return -1;
//            }
//
//            // acha posição de inserir
//            Celula aux = ultimo;
//
//            Jogo item = aux.item;
//            ultimo = ultimo.prev;
//            ultimo.prox = null;
//            return item;
//        }
    }
    //====================================================================

    //===CELULA===
    static class Celula {
        Jogo item;
        Celula prox;
        Celula prev;
    }

    //====================================================================


    //===splita entrada===
    public static void splitBusca(Vector<Jogo> vetorJogosTXT, String busca, Lista lista) { //divide o Main.Jogo Buscado em 4 partes, dia mes ano e pais, e chama o buscaJogoVetor
        int dia, mes, ano;

        String[] textoSeparado = busca.split(";");
        String pais = textoSeparado[1];
        textoSeparado = textoSeparado[0].split("/");

        dia = Integer.parseInt(textoSeparado[0]);
        mes = Integer.parseInt(textoSeparado[1]);
        ano = Integer.parseInt(textoSeparado[2]);

        buscaJogoVetor(vetorJogosTXT, pais, dia, mes, ano, lista);
    }


//====================================================================


    public static void buscaJogoVetor(Vector<Jogo> vetorJogosTXT, String pais, int dia, int mes, int ano, Lista lista) {


        for (int i = 0; i < vetorJogosTXT.size(); i++) {
            if (dia == vetorJogosTXT.get(i).getDia() && mes == vetorJogosTXT.get(i).getMes() && ano == vetorJogosTXT.get(i).getAno() && pais.equals(vetorJogosTXT.get(i).getSelecao1())) {
                lista.insereInicio(vetorJogosTXT.get(i));
            }
        }
    }


//====================================================================


    public static void criaJogo(Vector<Jogo> vetorJogosTXT, String a) {
        String[] textoSeparado = a.split("#");// quebra o vetor nas posições marcadas péeplo #
        Jogo j = new Jogo(Integer.parseInt(textoSeparado[0]), // data
                textoSeparado[1], // fase
                Integer.parseInt(textoSeparado[2]), // dia
                Integer.parseInt(textoSeparado[3]), // mes
                textoSeparado[4], // time 1
                Integer.parseInt(textoSeparado[5]), // palacar 1
                Integer.parseInt(textoSeparado[6]), // placar 2
                textoSeparado[7], // time 2
                textoSeparado[8]); // local
        vetorJogosTXT.add(j);

    }


//====================================================================


    //===LEITURA DE ARQUIVO===
    static class ArquivoTXTLeitura {
        public BufferedReader arquivo;

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


    //====================================================================


    //===IMPRIMIR===
    public static void imprimir(Jogo j) {
        System.out.println("[Copa " + j.getAno() + "] [" + j.getEtapa() + "] [" + j.getDia() + "/" + j.getMes() + "] [" + j.getSelecao1() + " (" + j.getPlacarSelecao1() + ") x (" + j.getPlacarSelecao2() + ") " + j.getSelecao2() + "] [" + j.getLocal() + "]");
    }


    //====================================================================


    //===MAIN===
    public static void main(String[] args) {

        MyIO.setCharset("UTF-8");
        ArquivoTXTLeitura arquivo = new ArquivoTXTLeitura();
        arquivo.abrirArquivo("partidas.txt");


        Vector<Jogo> vetorJogosTXT = new Vector<>();


        /* - ----- Leitura dos dados do arquivo -------------------*/
        while (true) {
            String linha = arquivo.lerLinhaArquivo();
            if (linha == null) {
                arquivo.fecharArquivo();
                break;
            }
            criaJogo(vetorJogosTXT, linha);
        }
        arquivo.fecharArquivo();
        /*------------------------------------------------------------*/


        //===ENTRADA DE DADOS PELO VERDE===

        Lista lista = new Lista(); //CRIA NOVA LISTA

        //===Preenche a LISTA com os primeiro 680 Jogos===
        while(true){
            String linha = MyIO.readLine();
            if(linha.equals("FIM")){
                break;
            }
            splitBusca(vetorJogosTXT, linha, lista);
        }



        int numComandos = MyIO.readInt(); //número de comandos que serão realizados a seguir


        for(int i = 0; i < numComandos; i++){
            String linha = MyIO.readLine();
            splitLinha(linha, lista);

        }


        //lista.imprimeInicioFim();  teste para ver se a lista está preenchida

    }//===FINAL DA MAIN===


    public static void splitComando(String linha){
        String[] eachElement = linha.split(" ");

        String comando = eachElement[0];

        if(eachElement.length == 3){
            int posicao = Integer.parseInt(eachElement[1]); //posicao para ser retirado ou inserido
            String jogoBuscado = eachElement[2];
            splitJogoBuscado(jogoBuscado, posicao, );

        }else if(eachElement.length == 2){
            String jogoBuscado = eachElement[1];
            splitJogoBuscado(jogoBuscado);
        }







    }

    private static void splitJogoBuscado(String jogoBuscado ) {
        int dia, mes, ano;

        String[] eachElement = jogoBuscado.split(";");
        String pais = eachElement[1];
        eachElement = eachElement[0].split("/");

        dia = Integer.parseInt(eachElement[0]);
        mes = Integer.parseInt(eachElement[1]);
        ano = Integer.parseInt(eachElement[2]);


    }

}
