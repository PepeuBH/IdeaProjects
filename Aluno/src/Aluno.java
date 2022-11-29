import org.w3c.dom.ls.LSOutput;

public class Aluno {
    public String nome;
    public double nota1;
    public double nota2;
    public double nota3;


    public double finalGrade(){
        return this.nota1 + this.nota2 + this.nota3;
    }

    public double missing(){
        return 60 -finalGrade();
    }

}
