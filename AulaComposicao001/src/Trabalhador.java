import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trabalhador {
    private String nome;
    private NivelTrabalhador nivel;
    private double salarioBase;

    private Departamento departamento;  // 1 trabalhador pode ter apenas 1 departamento

    private List<ContratoHora> contratos = new ArrayList<>(); // 1 trabalhador pode ter muitos contratos
    //===Uma COMPOSICAO do tipo "TEM MUITOS", não pode fazer parte do CONSTRUTOR===

    public Trabalhador() {
    } //construtor vazio


    public Trabalhador(String nome, NivelTrabalhador nivel, double salarioBase, Departamento departamento) { //construtor sem a lista, pois ela é iniciada logo na declaração.
        this.nome = nome;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }


    //===get e set===
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelTrabalhador getNivel() {
        return nivel;
    }

    public void setNivel(NivelTrabalhador nivel) {
        this.nivel = nivel;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<ContratoHora> getContratos() {
        return contratos;
    }

//    public void setContratos(List<ContratoHora> contratos) { //este método nao pode existir, pois substitui a lista ja criada por outra
//        this.contratos = contratos;
//    }


    public void adicionarContrato(ContratoHora contrato) {
        contratos.add(contrato);
    }

    public void removerContrato(ContratoHora contrato) {
        contratos.remove(contrato);
    }

    public double income(int year, int month) {

        double sum = salarioBase; //variável soma com valor inicial = salarioBase

        Calendar calendar = Calendar.getInstance(); //cria calendário


        for (ContratoHora c : contratos) {
            calendar.setTime(c.getData()); //define a data do contrato como data do calendário
            int contrato_year = calendar.get(Calendar.YEAR);
            int contrato_month = 1 + calendar.get(Calendar.MONTH); // (+ 1) pois começa em 0
            if (year == contrato_year && month == contrato_month) {
                sum += c.valorTotal();
            }
        }
        return sum;
    }
}
