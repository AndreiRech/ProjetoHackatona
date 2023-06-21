import java.util.Arrays;

public class Times {
    private String nome;
    private Alunos[] alunos;
    private double[] notas;
    private int numAlunos;
    private int numNotas;
    private double soma = 0;
    private int numAvaliadores;
    private double[] notasAvaliadores;
    
    public Times(String nome){
        this.nome = nome.toUpperCase();
        this.alunos = new Alunos[6];
        this.notas = new double[5];
        this.numAlunos = 0;
        this.numNotas = 0;
        this.notasAvaliadores = new double[5];
        this.numAvaliadores = 0;
    }

    public void addAlunos(Alunos aluno){
        if (numAlunos < 6){
            alunos[numAlunos] = aluno;
            numAlunos++;
        }
    }
    public void addNota(double nota){
        if (numNotas < 5){
            notas[numNotas] = nota;
            numNotas++;
        }
    }

    public String getNome(){
        return nome;
    }
    public Alunos[] getAlunos(){
        return alunos;
    }
    public double[] getNotas(){
    return Arrays.copyOf(notas, numNotas);
    }

    public double notaFinal(){
        soma = 0;
        for (int i = 0; i < numAvaliadores; i++) {
            soma = soma + notasAvaliadores[i];
        }
        return soma;
    }
    public int getNumAlunos(){
        return numAlunos;
    }

    public double getNumNotas () {
        return numNotas;
    }

    public double[] getNotasAvaliadores() {
        return notasAvaliadores;
    }
    
    public void addNotaAvaliador(double nota) {
        if (numAvaliadores < notasAvaliadores.length) {
            notasAvaliadores[numAvaliadores] = nota;
            numAvaliadores++;
        }
    }

    public void mostrarNotas() {
        System.out.println("Notas do time " + getNome() + ":");
        double[] notasAvaliadores = getNotasAvaliadores();
        for (int i = 0; i < numAvaliadores; i++) {
            System.out.println("Avaliador " + (i + 1) + ": " + notasAvaliadores[i]);
        }
    }

    public boolean verificarCursosDiferentes() {
    String primeiroCurso = alunos[0].getCurso();
    for (int i = 1; i < numAlunos; i++) {
        String cursoAtual = alunos[i].getCurso();
        if (!cursoAtual.equals(primeiroCurso)) {
            return true; 
        }
    }
    return false;
    }

}
