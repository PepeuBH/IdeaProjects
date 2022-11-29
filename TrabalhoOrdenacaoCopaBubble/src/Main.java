
import java.io.*;
import java.util.Vector;

// --------------------------------------------

class Jogo {
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


    private static void imprimir(Jogo j) {
        System.out.println("[Copa " + j.getAno() + "] [" + j.getEtapa() + "] [" + j.getDia() + "/" + j.getMes() + "] [" + j.getSelecao1() + " (" + j.getPlacarSelecao1() + ") x (" + j.getPlacarSelecao2() + ") " + j.getSelecao2() + "] [" + j.getLocal() + "]");
    }



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


    public static void splitBusca(Vector<Jogo> vetorJogosTXT, String busca, Vector<Jogo> vetorJogosOrdenar) { //divide o Jogo Buscado em 4 partes, dia mes ano e pais, e chama o buscaJogoVetor
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

        //for (Jogo j : vetorJogosOrdenar) {
        //   imprimir(j);
        //}


        bubbleSort(vetorJogosOrdenar);


        for (int i = 0; i < vetorJogosOrdenar.size(); i++)
            imprimir(vetorJogosOrdenar.get(i));


    }
}