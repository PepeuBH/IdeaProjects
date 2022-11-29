
public class Alunos {
    public int numero;
    public String [] respostas = new String[8];
    public int nota;

    public void setRespostas(int pos, String resposta) {
        respostas[pos] = resposta;
    }

    public String[] getRespostas() {
        return respostas;
    }


}
