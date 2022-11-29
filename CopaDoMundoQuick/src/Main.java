
import java.io.*;
import java.util.Vector;
import java.io.FileWriter;
import java.io.IOException;

public class Main {


    //=======================================Classe Jogo================================

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





    //=======================================BABOU SORTE================================


    public static void bubbleSort(Vector<Jogo> vetorJogosOrdenar) {

        int n = vetorJogosOrdenar.size();

        for (int i = (n - 1); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (vetorJogosOrdenar.get(j).getDia() > vetorJogosOrdenar.get(j + 1).getDia()) {
                    Jogo temp = vetorJogosOrdenar.get(j);
                    vetorJogosOrdenar.set(j, vetorJogosOrdenar.get(j + 1));
                    vetorJogosOrdenar.set(j + 1, temp);

                } else if (vetorJogosOrdenar.get(j).getDia() == vetorJogosOrdenar.get(j + 1).getDia()) {
                    if (vetorJogosOrdenar.get(j).getMes() > vetorJogosOrdenar.get(j + 1).getMes()) {
                        Jogo temp = vetorJogosOrdenar.get(j);
                        vetorJogosOrdenar.set(j, vetorJogosOrdenar.get(j + 1));
                        vetorJogosOrdenar.set(j + 1, temp);

                    } else if (vetorJogosOrdenar.get(j).getMes() == vetorJogosOrdenar.get(j + 1).getMes()) {
                        if (vetorJogosOrdenar.get(j).getAno() > vetorJogosOrdenar.get(j + 1).getAno()) {
                            Jogo temp = vetorJogosOrdenar.get(j);
                            vetorJogosOrdenar.set(j, vetorJogosOrdenar.get(j + 1));
                            vetorJogosOrdenar.set(j + 1, temp);

                        } else if (vetorJogosOrdenar.get(j).getAno() == vetorJogosOrdenar.get(j + 1).getAno()) {
                            if (vetorJogosOrdenar.get(j).getSelecao1().compareTo(vetorJogosOrdenar.get(j + 1).getSelecao1()) > 0) {
                                Jogo temp = vetorJogosOrdenar.get(j);
                                vetorJogosOrdenar.set(j, vetorJogosOrdenar.get(j + 1));
                                vetorJogosOrdenar.set(j + 1, temp);
                            }
                        }

                    }
                }
            }
        }
    }








    //=======================================INSERTION SORT================================

    public static void insertionSort(Vector<Jogo> vetorJogosOrdenar) {

        int in, out;

        for (out = 1; out < vetorJogosOrdenar.size(); out++) {
            Jogo temp = vetorJogosOrdenar.get(out);
            if (temp != null) {

                in = out;

                while (in > 0 && test(vetorJogosOrdenar, in, temp)) {
                    vetorJogosOrdenar.set(in, vetorJogosOrdenar.get(in - 1));
                    --in;
                }
                vetorJogosOrdenar.set(in, temp);
            }
        }
    }

    public static boolean test(Vector<Jogo> vetorJogosOrdenar, int in, Jogo temp) {
        if (vetorJogosOrdenar.get(in - 1).getAno() > temp.getAno()) {
            return true;
        } else if (vetorJogosOrdenar.get(in - 1).getAno() == temp.getAno()) {
            if (vetorJogosOrdenar.get(in - 1).getMes() > temp.getMes()) {
                return true;
            } else if (vetorJogosOrdenar.get(in - 1).getMes() == temp.getMes()) {
                if (vetorJogosOrdenar.get(in - 1).getDia() > temp.getDia()) {
                    return true;
                } else if (vetorJogosOrdenar.get(in - 1).getDia() == temp.getDia()) {
                    int comparador = vetorJogosOrdenar.get(in - 1).getSelecao1().compareTo(temp.getSelecao1());
                    if (comparador > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }







    //=======================================SELECTION SORT================================

    static void selectionSort(Vector<Jogo> vetorJogosOrdenar) {
        int n = vetorJogosOrdenar.size();
        for (int i = 0; i < (n - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < n; j++) {
                if (vetorJogosOrdenar.get(menor).getAno() > vetorJogosOrdenar.get(j).getAno()) {
                    menor = j;
                } else if (vetorJogosOrdenar.get(menor).getAno() == vetorJogosOrdenar.get(j).getAno()) {
                    if (vetorJogosOrdenar.get(menor).getDia() > vetorJogosOrdenar.get(j).getDia()) {
                        menor = j;
                    } else if (vetorJogosOrdenar.get(menor).getDia() == vetorJogosOrdenar.get(j).getDia()) {
                        if (vetorJogosOrdenar.get(menor).getMes() > vetorJogosOrdenar.get(j).getMes()) {
                            menor = j;
                        } else if (vetorJogosOrdenar.get(menor).getMes() == vetorJogosOrdenar.get(j).getMes()) {
                            if (vetorJogosOrdenar.get(menor).getSelecao1().compareTo(vetorJogosOrdenar.get(j).getSelecao1()) > 0) {
                                menor = j;
                            }
                        }
                    }
                }
            }

            Jogo temp = vetorJogosOrdenar.get(i);
            vetorJogosOrdenar.set(i, vetorJogosOrdenar.get(menor));
            vetorJogosOrdenar.set(menor, temp);
        }
    }









    //=======================================QUICK SORT 3================================

    public static int partition(Vector<Jogo> vetorJogosOrdenado, int low, int high) {
        Jogo pivot = vetorJogosOrdenado.get(high);
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (vetorJogosOrdenado.get(j).getAno() < pivot.getAno()) { //ATRIBUTO ANO
                i++;

                // swap vetorJogosOrdenado[i] and vetorJogosOrdenado[j]
                Jogo temp = vetorJogosOrdenado.get(i);
                vetorJogosOrdenado.set(i, vetorJogosOrdenado.get(j));
                vetorJogosOrdenado.set(j, temp);

            } else if (vetorJogosOrdenado.get(j).getAno() == pivot.getAno()) {
                if (vetorJogosOrdenado.get(j).getMes() < pivot.getMes()) { //ATRIBUTO MES
                    i++;

                    // swap vetorJogosOrdenado[i] and vetorJogosOrdenado[j]
                    Jogo temp = vetorJogosOrdenado.get(i);
                    vetorJogosOrdenado.set(i, vetorJogosOrdenado.get(j));
                    vetorJogosOrdenado.set(j, temp);

                } else if (vetorJogosOrdenado.get(j).getMes() == pivot.getMes()) {
                    if (vetorJogosOrdenado.get(j).getDia() < pivot.getDia()) { //ATRIBUTO DIA
                        i++;

                        // swap vetorJogosOrdenado[i] and vetorJogosOrdenado[j]
                        Jogo temp = vetorJogosOrdenado.get(i);
                        vetorJogosOrdenado.set(i, vetorJogosOrdenado.get(j));
                        vetorJogosOrdenado.set(j, temp);
                    }
                } else if (vetorJogosOrdenado.get(j).getDia() == pivot.getDia()) {
                    if (vetorJogosOrdenado.get(j).getEtapa().compareTo(pivot.getEtapa()) < 0) { //ATRIBUTO ETAPA
                        i++;

                        // swap vetorJogosOrdenado[i] and vetorJogosOrdenado[j]
                        Jogo temp = vetorJogosOrdenado.get(i);
                        vetorJogosOrdenado.set(i, vetorJogosOrdenado.get(j));
                        vetorJogosOrdenado.set(j, temp);
                    }
                } else if (vetorJogosOrdenado.get(j).getEtapa().compareTo(pivot.getEtapa()) == 0) {
                    if (vetorJogosOrdenado.get(j).getSelecao1().compareTo(pivot.getSelecao1()) < 0) { //ATRIBUTO SELECAO1
                        i++;

                        // swap vetorJogosOrdenado[i] and vetorJogosOrdenado[j]
                        Jogo temp = vetorJogosOrdenado.get(i);
                        vetorJogosOrdenado.set(i, vetorJogosOrdenado.get(j));
                        vetorJogosOrdenado.set(j, temp);
                    }
                }
            }
        }

        // swap vetorJogosOrdenado[i+1] and vetorJogosOrdenado[high] (or pivot)
        Jogo temp = vetorJogosOrdenado.get(i + 1);
        vetorJogosOrdenado.set(i + 1, vetorJogosOrdenado.get(high));
        vetorJogosOrdenado.set(high, temp);

        return i + 1;
    }


    /* The main function that implements QuickSort()
      vetorJogosOrdenado[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public static void sort(Vector<Jogo> vetorJogosOrdenado, int low, int high) {

        if (low < high) {
            /* pi is partitioning index, vetorJogosOrdenado[pi] is
              now at right place */
            int pi = partition(vetorJogosOrdenado, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(vetorJogosOrdenado, low, pi - 1);
            sort(vetorJogosOrdenado, pi + 1, high);
        }

    }







    //=======================================Metódo para dividir a Busca================================
    public static void splitBusca(Vector<Jogo> vetorJogosTXT, String busca, Vector<Jogo> vetorJogosOrdenar) { //divide o Main.Jogo Buscado em 4 partes, dia mes ano e pais, e chama o buscaJogoVetor
        int dia, mes, ano;

        String[] textoSeparado = busca.split(";");
        String pais = textoSeparado[1];
        textoSeparado = textoSeparado[0].split("/");

        dia = Integer.valueOf(textoSeparado[0]);
        mes = Integer.valueOf(textoSeparado[1]);
        ano = Integer.valueOf(textoSeparado[2]);

        buscaJogoVetor(vetorJogosTXT, pais, dia, mes, ano, vetorJogosOrdenar);
    }


    public static void buscaJogoVetor(Vector<Jogo> vetorJogosTXT, String pais, int dia, int mes, int ano, Vector<Jogo> vetorJogosOrdenar) {
        Jogo aux;
        int posVetOrdenar = vetorJogosOrdenar.size();

        for (int i = 0; i < vetorJogosTXT.size(); i++) {
            if (dia == vetorJogosTXT.get(i).getDia() && mes == vetorJogosTXT.get(i).getMes() && ano == vetorJogosTXT.get(i).getAno() && pais.equals(vetorJogosTXT.get(i).getSelecao1())) {
                //aux = vetorJogosTXT.get(i);
                vetorJogosOrdenar.add(posVetOrdenar, vetorJogosTXT.get(i));
                posVetOrdenar++;
            }

        }
    }


    //=======================================Metódo para Criar um novo jogo no vetor de jogos TXT================================

    public static void criaJogo(Vector<Jogo> vetorJogosTXT, String a) {
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
        vetorJogosTXT.add(j);

    }


//=======================================Classe para ler o partidas.txt================================

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



    //=======================================Metódo para substituir o toString() e imprimir os jogos de acordo com a saída padrão================================

    public static void imprimir(Jogo j) {
        System.out.println("[Copa " + j.getAno() + "] [" + j.getEtapa() + "] [" + j.getDia() + "/" + j.getMes() + "] [" + j.getSelecao1() + " (" + j.getPlacarSelecao1() + ") x (" + j.getPlacarSelecao2() + ") " + j.getSelecao2() + "] [" + j.getLocal() + "]");
    }







    //=======================================Metódo para escrever em TXT================================


    public static class ArquivoTextoEscrita {
        private BufferedWriter saida;
        ArquivoTextoEscrita(String nomeArquivo) {
            try {
                saida = new BufferedWriter(new FileWriter(nomeArquivo));
            }
            catch (FileNotFoundException excecao) {
                System.out.println("Arquivo nao encontrado");
            }
            catch (IOException excecao) {
                System.out.println("Erro na abertura do arquivo de escrita: " +
                        excecao);
            }
        }
        public void fecharArquivo() {
            try {
                saida.close();
            }
            catch (IOException excecao) {
                System.out.println("Erro no fechamento do arquivo de escrita: " +
                        excecao);
            }
        }
        public void escrever(String textoEntrada) {
            try {
                saida.write(textoEntrada);
                saida.newLine();
            }
            catch (IOException excecao){
                System.out.println("Erro de entrada/saída " + excecao);
            }
        }
    }






    //=======================================Main================================

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





        /* ------------- Vetor com jogos a serem ordenados --------------------- */
        Vector<Jogo> vetorJogosOrdenar = new Vector<>();


        int numBuscas = MyIO.readInt(); //  numero de buscas feitas


        // faz a leitura dos jogos a serem buscados, o valor numBuscas
        for (int i = 0; i < numBuscas; i++) {
            String linha = MyIO.readLine();// entrada de dados pelo verde
            splitBusca(vetorJogosTXT, linha, vetorJogosOrdenar);
        }




        //=======================================Chamada para os métodos de ordenação================================

        int n = vetorJogosOrdenar.size();


        //bubbleSort(vetorJogosOrdenar);

        //insertionSort(vetorJogosOrdenar);

        //selectionSort(vetorJogosOrdenar);

        long start = System.nanoTime();

        sort(vetorJogosOrdenar, 0, n - 1);

        long finish = System.nanoTime();

        long timeElapsed = finish - start;






        //=======================================Imprimindo================================

        for (int i = 0; i < vetorJogosOrdenar.size(); i++) {
            imprimir(vetorJogosOrdenar.get(i));  //imprime o vetor ordenado com o método
        }




        //==========ESCREVENDO ARQUIVO LOG============
        ArquivoTextoEscrita log = new ArquivoTextoEscrita("749757_quicksort.txt");
        log.escrever(timeElapsed + " NanoSeconds\tComparações: 0" + "\tTrocas: 0");
        log.fecharArquivo();
    }

}
