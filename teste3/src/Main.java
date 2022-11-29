import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Main {
    static class Jogo {
        // atributos para representar cada partida
        private static int dia;
        private static int mes;
        private static int ano;
        private static String etapa;
        private static String selecao1;
        private static String selecao2;
        private static int placarSelecao1;
        private static int placarSelecao2;
        private static String local;

        public Jogo() {
        }

        public static int getDia() {
            return dia;
        }

        public static void setDia(int dia) {
            Jogo.dia = dia;
        }

        public static int getMes() {
            return mes;
        }

        public static void setMes(int mes) {
            Jogo.mes = mes;
        }

        public static int getAno() {
            return ano;
        }

        public static void setAno(int ano) {
            Jogo.ano = ano;
        }

        public static String getEtapa() {
            return etapa;
        }

        public static void setEtapa(String etapa) {
            Jogo.etapa = etapa;
        }

        public static String getSelecao1() {
            return selecao1;
        }

        public static void setSelecao1(String selecao1) {
            Jogo.selecao1 = selecao1;
        }

        public static String getSelecao2() {
            return selecao2;
        }

        public static void setSelecao2(String selecao2) {
            Jogo.selecao2 = selecao2;
        }

        public static int getPlacarSelecao1() {
            return placarSelecao1;
        }

        public static void setPlacarSelecao1(int placarSelecao1) {
            Jogo.placarSelecao1 = placarSelecao1;
        }

        public static int getPlacarSelecao2() {
            return placarSelecao2;
        }

        public static void setPlacarSelecao2(int placarSelecao2) {
            Jogo.placarSelecao2 = placarSelecao2;
        }

        public static String getLocal() {
            return local;
        }

        public static void setLocal(String local) {
            Jogo.local = local;
        }

        //===Construtor completo===
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


            private static void toStringJogos(Jogo j) {
                System.out.println(j);
            }

    }




    //-------------------Classe Fila--------------------------------------

    static class Fila {
        Jogo item[];
        int frente, tras;

        Fila(int tam) {
            item = new Jogo[tam];
            frente = 0;
            tras = 0;
        }



        public double SaldoGols(int tam) {
            int soma = 0;
            double media = 0;
            int cont = 0;

            for (int i = frente; i != tras; i = (i + 1) % tam){
                soma += item[i].getPlacarSelecao1() + item[i].getPlacarSelecao2();
                cont++;
            }
            media = soma / cont;
            return media;
       }



        boolean vazia() {
            return (frente == tras);
        }


        boolean cheia(int tam) {
            return((tras + 1) % tam == frente);
        }

        void enfileira(Jogo x, int tam) {
            if ((tras + 1) % tam == frente) {
                System.out.println("Erro: A fila esta cheia");
                return;
            }

            item[tras] = x;
            tras = (tras + 1) % tam;

        }

        Jogo desenfileira(int tam) {
            Jogo itemRetorno = item[frente];

            if (vazia()) {
                System.out.println("Erro: A fila esta vazia");
            }

            itemRetorno = item[frente];
            frente = (frente + 1) % tam;
            return itemRetorno;
        }

    }



    //--------------------Classe leitura texto-------------------------------------

    static class ArquivoTextoLeitura {

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



    //===Métodos===

    //===========================================================

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

//===========================================================

    private static Jogo busca(Vector<Jogo> vetorJogos, String pais, int dia, int mes, int ano) {
        for (int i = 0; i < vetorJogos.size(); i++)
            if (dia == vetorJogos.get(i).getDia() && mes == vetorJogos.get(i).getMes()
                    && ano == vetorJogos.get(i).getAno() && pais.equals(vetorJogos.get(i).getSelecao1()))
                return vetorJogos.get(i);

        return null;
    }

//===========================================================

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

    //===========================================================





//===MAIN===

    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");
        ArquivoTextoLeitura texto = new ArquivoTextoLeitura("partidas.txt");// caminho do arquivo na plataforma																					// VERDE
        // ArquivoTextoLeitura texto = new ArquivoTextoLeitura("partidas.txt");// no UBUNTU

        Vector<Jogo> vetorJogos = new Vector<Jogo>();// vetor para alocar jogos lidos do arquivo

        int tam = 101;// tamanho da fila, 1 a mais, pois celual centinela ocupa espaço
        Fila fila = new Fila(tam);


        /*-----Leitura de arquivos dos Jogos--------*/
        while (true) {
            String linha = texto.ler();
            if (linha == null) {// Leitura feita a última linha - retorna null
                texto.fecharArquivo();
                break;
            }
            criaJogo(vetorJogos, linha);
        }
        texto.fecharArquivo();
        /*-----------------------------------------*/


        /*---------Entrada dados pelo verde, de jogos a serem enfileirados------------*/
        while (true) {
            String linha = MyIO.readLine();
            if (linha.equals("FIM"))
                break;

            Jogo temp = buscaJogoParse(vetorJogos, linha);

            if (fila.cheia(tam))
                fila.desenfileira(tam);

            fila.enfileira(temp, tam);

            System.out.println(fila.SaldoGols(tam));
        }
        /*-------------Jogos já enfileirados---------------------------*/



        /*---------Entrada dados pelo verde, ações de enfileirar e desenfileirar------------*/
        int numBuscas = MyIO.readInt();// verde

        for (int i = 0; i < numBuscas; i++) {
            String linha = MyIO.readLine(); // verde

            if (linha.charAt(0) == 'E') {// se começar com letra E, enfileirar, se D desenfileirar
                if (fila.cheia(tam))
                    fila.desenfileira(tam);

                String newStr = linha.substring(2);// remove "E " da linha (dois caracteres iniciais)
                Jogo temp = buscaJogoParse(vetorJogos, newStr);
                fila.enfileira(temp, tam);

                System.out.println(fila.SaldoGols(tam));// média de gols ---- implementar média de GOLS
            } else
                fila.desenfileira(tam).toStringJogos();// implementar desenfileirar e implementar toStringJogos
        }



        // ações de esvaziar Fila
        while (!fila.vazia())
            fila.desenfileira(tam).toStringJogos(); //imprime jogos na tela

    }
}