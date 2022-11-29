import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static BufferedReader br;
    public static Jogo vetorJogos[] = new Jogo[1000];
    public static Jogo vetorOrdenado[] = new Jogo[1000];

    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");

        abreArquivo();

        carregaVetorJogos();

        int n = MyIO.readInt();

        for (int i = 0; i < n; i++) {
            String input = MyIO.readLine();

            pesquisaJogo(input);
        }

        doInsertionSort();

        for (int i = 0; i < vetorOrdenado.length; i++) {
            if (vetorOrdenado[i] != null) {
                vetorOrdenado[i].print();
            }
        }
    }

    public static boolean test(int in, Jogo temp) {
        if (vetorOrdenado[in - 1].getAno() > temp.getAno()) {
            return true;
        } else if (vetorOrdenado[in - 1].getAno() == temp.getAno()) {
            if (vetorOrdenado[in - 1].getMes() > temp.getMes()) {
                return true;
            } else if (vetorOrdenado[in - 1].getMes() == temp.getMes()) {
                if (vetorOrdenado[in - 1].getDia() > temp.getDia()) {
                    return true;
                } else if (vetorOrdenado[in - 1].getDia() == temp.getDia()) {
                    int comparador = vetorOrdenado[in - 1].getSelecao1().compareTo(temp.getSelecao1());
                    if (comparador > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void doInsertionSort() {

        int in, out;

        for (out = 1; out < vetorOrdenado.length; out++)
        {
            Jogo temp = vetorOrdenado[out];
            if (temp != null) {

                in = out;

                while(in > 0 && test(in, temp))
                {
                    vetorOrdenado[in] = vetorOrdenado[in-1];
                    --in;
                }
                vetorOrdenado[in] = temp;
            }
        }
    }


    public static String lerLinhaArquivo() {
        String entrada = null;
        try {
            entrada = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entrada;
    }

    public static void abreArquivo() {
        try {
            br = new BufferedReader(new FileReader("/tmp/partidas.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
            e.printStackTrace();
        }
    }

    public static void carregaVetorJogos() {
        for (int j = 0; j < vetorJogos.length; j++) {
            vetorJogos[j] = new Jogo();
        }

        String entrada = lerLinhaArquivo();

        for (int index = 0; entrada != null; index++) {
            vetorJogos[index].setGame(entrada);
            entrada = lerLinhaArquivo();
        }
    }

    public static void pesquisaJogo(String input) {
        Jogo jogoPesquisado = new Jogo();
        for (int i = 0; i < vetorJogos.length; i++) { // Pode ter condição diferente
            String[] diaMes = new String[3];
            diaMes = input.split("/");

            String[] anoLocal = new String[2];
            anoLocal = diaMes[2].split(";");

            if (vetorJogos[i].getDia() == Integer.valueOf(diaMes[0]) &&
                    vetorJogos[i].getMes() == Integer.valueOf(diaMes[1]) &&
                    vetorJogos[i].getAno() == Integer.valueOf(anoLocal[0]) &&
                    vetorJogos[i].getSelecao1().equals(anoLocal[1])) {

                jogoPesquisado = vetorJogos[i];

                int parar = 0;
                for (int j = 0; j < vetorOrdenado.length && parar == 0; j++) {
                    if (vetorOrdenado[j] == null) {
                        vetorOrdenado[j] = jogoPesquisado;
                        parar = 1;
                    }
                }
            }
        }
    }
}

class Jogo {

    private int dia;
    private int mes;
    private int ano;
    private int placarSelecao1;
    private int placarSelecao2;

    private String etapa;
    private String local;
    private String selecao1;
    private String selecao2;

    public Jogo(int dia, int mes, int ano, int placarSelecao1, int placarSelecao2, String etapa, String local, String selecao1, String selecao2) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.placarSelecao1 = placarSelecao1;
        this.placarSelecao2 = placarSelecao2;
        this.etapa = etapa;
        this.local = local;
        this.selecao1 = selecao1;
        this.selecao2 = selecao2;
    }

    // Caso não haja entrada de jogo, esse metodo é chamado.
    public Jogo() {
        this.dia = 0;
        this.mes = 0;
        this.ano = 0;
        this.etapa = "";
        this.selecao1 = "";
        this.selecao2 = "";
        this.placarSelecao1 = 0;
        this.placarSelecao2 = 0;
        this.local = "";
    }

    // GETS //

    public int getDia() {
        return this.dia;
    }

    public int getMes() {
        return this.mes;
    }

    public int getAno() {
        return this.ano;
    }

    public int getPlacarSelecao1() {
        return this.placarSelecao1;
    }

    public int getPlacarSelecao2() {
        return this.placarSelecao2;
    }

    public String getEtapa() {
        return this.etapa;
    }

    public String getLocal() {
        return this.local;
    }

    public String getSelecao1() {
        return this.selecao1;
    }

    public String getSelecao2() {
        return this.selecao2;
    }

    // SETS //

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setPlacarSelecao1(int placarSelecao1) {
        this.placarSelecao1 = placarSelecao1;
    }

    public void setPlacarSelecao2(int placarSelecao2) {
        this.placarSelecao2 = placarSelecao2;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setSelecao1(String selecao1) {
        this.selecao1 = selecao1;
    }

    public void setSelecao2(String selecao2) {
        this.selecao2 = selecao2;
    }

    // METODOS //

    // Entrada: Ano, Etapa, Dia, Mes, Selecao1, PlacarSelecao1, PlacarSelecao2, Selecao2, Local

    public void clone(Jogo jogo) {
        this.dia = jogo.dia;
        this.mes = jogo.mes;
        this.ano = jogo.ano;
        this.etapa = jogo.etapa;
        this.selecao1 = jogo.selecao1;
        this.selecao2 = jogo.selecao2;
        this.placarSelecao1 = jogo.placarSelecao1;
        this.placarSelecao2 = jogo.placarSelecao2;
        this.local = jogo.local;
    }

    public void setGame(String dados) {

        // Dessa forma os 9 dados do jogo vão ser quebrados em 9 posições de um vetor de String
        String tempVet[] = new String[9];
        tempVet = dados.split("#");

        // isso aqui converte um Integer String pra um Integer int
        this.ano = Integer.valueOf(tempVet[0]);
        this.etapa = tempVet[1];
        this.dia = Integer.valueOf(tempVet[2]);
        this.mes = Integer.valueOf(tempVet[3]);
        this.selecao1 = tempVet[4];
        this.placarSelecao1 = Integer.valueOf(tempVet[5]);
        this.placarSelecao2 = Integer.valueOf(tempVet[6]);
        this.selecao2 = tempVet[7];
        this.local = tempVet[8];
    }

    public void print() {
        System.out.print("[COPA " + this.ano + "] ");
        System.out.print("[" + this.etapa + "] ");
        System.out.print("[" + this.dia + "/" + this.mes + "] ");
        System.out.print("[" + this.selecao1 + " (" + this.placarSelecao1 + ") x (" + this.placarSelecao2 + ") " + this.selecao2 + "] ");
        System.out.print("[" + this.local + "]\n");
    }
}
