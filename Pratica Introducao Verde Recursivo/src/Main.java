import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String linha = null;

        linha = sc.nextLine();

        while (!linha.equals("FIM")) {
            System.out.println(isUpper(linha, 0));
            linha = sc.nextLine();
        }

        sc.close();
    }


    public static int isUpper(String palavra, int i) {

        int numM;

        if (i == palavra.length())
            return 0;

        if (palavra.charAt(i) >= 'a' && palavra.charAt(i) <= 'z')
            numM = isUpper(palavra, i + 1);
        else if (palavra.charAt(i) >= 'A' && palavra.charAt(i) <= 'z')
            numM = 1 + isUpper(palavra, i + 1);
        else
            numM = isUpper(palavra, i + 1);

        return numM;
    }

}
