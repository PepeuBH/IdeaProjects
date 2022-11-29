import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main { //JEITO NERDOLA DE FAZER - TESTE

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

        //sort
        int mid = 0;
        for (int i = 0; mid == 0; i++) {
            if (vetorOrdenado[i] == null) {
                mid = i-1;
            }
        }

        mergeSort(vetorOrdenado, 0, mid);

        for (int i = 0; i < vetorOrdenado.length; i++) {
            if (vetorOrdenado[i] != null) {
                vetorOrdenado[i].print();
            }
        }
    }

    public static void mergeSort(Jogo[] a, int from, int to) {
        if (from == to) {
            return;
        }
        int mid = (from + to) / 2;

        mergeSort(a, from, mid);
        mergeSort(a, mid + 1, to);
        merge(a, from, mid, to);
    }

    public static void merge(Jogo[] a, int from, int mid, int to) {
        int n = to - from + 1;
        Jogo[] b = new Jogo[n];
        int i1 = from;
        int i2 = mid + 1;
        int j = 0;


        while (i1 <= mid && i2 <= to) {
            if (test(a, i1, i2)) {
                b[j] = a[i2];
                i2++;
            } else {
                b[j] = a[i1];
                i1++;
            }
            j++;
        }


        while (i1 <= mid) {
            b[j] = a[i1];
            i1++;
            j++;
        }


        while (i2 <= to) {
            b[j] = a[i2];
            i2++;
            j++;
        }


        for (j = 0; j < n; j++) {
            a[from + j] = b[j];
        }
    }


    public static boolean test(Jogo a[], int i1, int i2) {
        if (a[i1] != null && a[i2] != null) {
            int comparador = a[i1].getLocal().compareTo(a[i2].getLocal());
            if (comparador > 0) {
                return true;
            } else if (comparador == 0) {
                if (a[i1].getAno() > a[i2].getAno()) {
                    return true;
                } else if (a[i1].getAno() == a[i2].getAno()) {
                    if (a[i1].getMes() > a[i2].getMes()) {
                        return true;
                    } else if (a[i1].getMes() == a[i2].getMes()) {
                        if (a[i1].getDia() > a[i2].getDia()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
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


        String tempVet[] = new String[9];
        tempVet = dados.split("#");


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
