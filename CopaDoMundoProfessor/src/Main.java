import java.util.Vector;

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

    public Jogo() { // construtor vazio

    }

    public Jogo(int ano, String etapa, int dia, int mes, String selecao1, int placarSelecao1, int placarSelecao2, String selecao2, String local) { // completo
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


    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");
        Vector<Jogo> vetorJogos = new Vector<Jogo>();


        // faz a leitura dos jogos, até a palavra fim ser lida
        while (true) {
            String linha = MyIO.readLine();
            if (linha.equals("FIM"))
                break;
            criaJogo(vetorJogos, linha);
        }


        int numBuscas = MyIO.readInt(); //  numero de buscas feitas
        // faz a leitura dos jogos a serem buscados, o valor numBuscas
        for (int i = 0; i < numBuscas; i++) {
            String linha = MyIO.readLine();
            imprimeBusca(vetorJogos, linha);
        }

    }

    private static void imprimeBusca(Vector<Jogo> vetorJogos, String busca) {
        int dia, mes, ano;

        String[] textoSeparado = busca.split(";");
        String pais = textoSeparado[1];
        textoSeparado = textoSeparado[0].split("/");

        dia = Integer.valueOf(textoSeparado[0]);
        mes = Integer.valueOf(textoSeparado[1]);
        ano = Integer.valueOf(textoSeparado[2]);

        imprimeBusca(vetorJogos, pais, dia, mes, ano);
    }


    private static void imprimeBusca(Vector<Jogo> vetorJogos, String pais, int dia, int mes, int ano) {
        for (int i = 0; i < vetorJogos.size(); i++)
            if (dia == vetorJogos.get(i).getDia() && mes == vetorJogos.get(i).getMes() && ano == vetorJogos.get(i).getAno() && pais.equals(vetorJogos.get(i).getSelecao1()))
                toString(vetorJogos.get(i));
    }

    private static void toString(Jogo j) {
        System.out.println("[Copa " + j.getAno() + "] [" + j.getEtapa() + "] [" + j.getDia() + "/" + j.getMes() + "] [" + j.getSelecao1() + " (" + j.getPlacarSelecao1() + ") x (" + j.getPlacarSelecao2() + ") " + j.getSelecao2() + "] [" + j.getLocal() + "]");
    }

    private static void criaJogo(Vector<Jogo> vetorJogos, String a) {
        String[] textoSeparado = a.split("#");// quebra o vetor nas posições marcadas péeplo #
        Jogo j = new Jogo(
                Integer.valueOf(textoSeparado[0]), //data
                textoSeparado[1], // fase
                Integer.valueOf(textoSeparado[2]), //dia
                Integer.valueOf(textoSeparado[3]), // mes
                textoSeparado[4], // time 1
                Integer.valueOf(textoSeparado[5]), // palacar 1
                Integer.valueOf(textoSeparado[6]), // placar 2
                textoSeparado[7], // time 2
                textoSeparado[8]); // local
        vetorJogos.add(j);

    }

}
