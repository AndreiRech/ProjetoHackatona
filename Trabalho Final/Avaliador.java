public class Avaliador {
    private double nota;
    public Avaliador(double nota){
        if(nota > 0 && nota < 5){
            this.nota = nota;
        }
    }

    public void setNota(double nota){
        if(nota > 0 && nota < 5){
            this.nota = nota;
        }
    }

    public double getNota(){
        return nota;
    }

    public String toString(){
        return "Nota: " + nota;
    }
}
