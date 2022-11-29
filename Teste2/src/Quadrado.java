public class Quadrado {
    public double ladoA;


    public double diagonal(){
        return ladoA * (Math.sqrt(2));
    }

    public double perimetro(){
        return ladoA*4;
    }

    public double area(){
        return Math.pow(ladoA, 2);
    }

}
