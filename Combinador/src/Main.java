import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        String entrada = sc.nextLine();

        while (!entrada.equals("FIM")) {

            String[] divide = entrada.split(" ");
            String[] parte1 = new String[divide[0].length()];
            String[] parte2 = new String[divide[1].length()];

            for (int i = 0; i < divide[0].length(); i++) {
                parte1[i] = divide[0].substring(i, i + 1);
            }

            for (int i = 0; i < divide[1].length(); i++) {
                parte2[i] = divide[1].substring(i, i + 1);
            }

            String saida = "";

            if (parte1.length < parte2.length) {

                for (int i = 0; i < parte1.length; i++) {
                    String aux = parte1[i] + parte2[i];
                    saida += aux;
                }

                int restante = parte2.length - parte1.length;
                for (int i = parte2.length - restante; i <
                        parte2.length; i++) {
                    saida += parte2[i];
                }

            } else {

                for (int i = 0; i < parte2.length; i++) {
                    String aux = parte1[i] + parte2[i];
                    saida += aux;
                }

                int restante = parte1.length - parte2.length;

                for (int i = parte1.length - restante; i < parte1.length; i++) {
                    saida += parte1[i];
                }
            }
            System.out.println(saida);
            entrada = sc.nextLine();
        }

        sc.close();
    }


}


