public class Main{

    public static void main(String[] args) {
        int soma = somatorio(50);

        System.out.println("O somatorio foi: " + soma);
    }


    public static int somatorio(int n) {
        int soma = 0;
        soma = n * (n  + 1 ) / 2;

        return soma;
    }
}

//public class Main{
//
//    public static void main(String[] args) {
//        int soma = somatorio(50);
//
//        System.out.println("O somatorio foi: "+soma);
//    }
//
//
//    public static int somatorio(int n) {
//        int soma = 0;
//
//        for (int i = 1; i<=n ; i++ )
//            soma = soma + i;
//
//        return soma;
//
//    }
//}
