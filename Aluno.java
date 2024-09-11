public class Aluno {
    private String nome;
    private int idade;
    private float altura;
    private float peso;
    private float imc;

    public Aluno(String nome){
        this.nome = name;
        this.idade = id;
        this.imc = imc;
    }
    public void IMC(){
        imc = this.peso/(this.altura*this.altura);
    }
}
