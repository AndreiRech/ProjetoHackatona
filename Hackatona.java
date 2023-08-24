import java.util.*;

public class Hackatona {
    private Times[] times;
    private Avaliador[] avaliadores;

    public Hackatona(Times[] times, Avaliador[] avaliadores){
        this.times = times;
        this.avaliadores = avaliadores;
    }

    public void setAvaliadores(Avaliador[] avaliadores){
        this.avaliadores = avaliadores;
    }
    
    public Times[] getTimes(){
        return times;
    }

    public Avaliador[] getAvaliadores(){
        return avaliadores;
    }
    
    public Times[] identificadorTimeVencedor() {
        Times vencedor = null;
        double maiorNota = -1;
    
        for (Times time : times) {
            double notaFinal = time.notaFinal();
            if (notaFinal > maiorNota) {
                maiorNota = notaFinal;
                vencedor = time;
            }
        }
    
        return new Times[] { vencedor };
    }
    
    public Alunos[] listarAlunos(){
        List<Alunos> alunosParticipantes = new ArrayList<>();

        for(Times time : times){
            Alunos[] alunos = time.getAlunos();
            for(int i = 0; i < time.getNumAlunos(); i++){
                alunosParticipantes.add(alunos[i]);
            }
        }
        return alunosParticipantes.toArray(new Alunos[0]);
    }

    
    public void timesAcimaDe20() {
        
        for (Times time : times) {
           
            if (time.notaFinal() > 20) {
                System.out.println("Equipe: " + time.getNome());
                System.out.println("Soma das notas: " + time.notaFinal());
            }
        }
    
    }
    
    public void timeEspecifico(String nomeTime) {
        for (Times time : times) {
            if (time.getNome().equalsIgnoreCase(nomeTime)) {
                System.out.println("Nome do time: " + time.getNome());
                System.out.println("Alunos do time: ");
                Alunos[] alunos = time.getAlunos();
                for (int i = 0; i < time.getNumAlunos(); i++) {
                    System.out.println(alunos[i]);
                }
                System.out.println("Notas recebidas: ");
                double[] nota = time.getNotas();

                for (int i = 0; i < time.getNumNotas(); i++) {
                    System.out.println(nota[i]);
                }

                time.mostrarNotas();

                return;
            }
        }
        System.out.println("Time não encontrado!");
    }

    public void listarTimes() {
        for (Times time : times) {
            System.out.println("Nome do time: " + time.getNome());
            System.out.println("Alunos do time: ");
            
            Alunos[] alunos = time.getAlunos();

            for (int i = 0; i < time.getNumAlunos(); i++) {
                System.out.println(alunos[i]);
            }
        }
    }

    public void listarAvaliadores() {
        System.out.println("Avaliadores:");
        for (Avaliador avaliador : avaliadores) {
            System.out.println(avaliador);
        }
    }

    public void atribuirNotas(){
        Scanner in = new Scanner (System.in);
        for (int i = 0; i < times.length; i++) {
            Times time = times[i];

            System.out.println("Atribuir notas para o time " + time.getNome() + ":");

            List<Avaliador> avaliadores = new ArrayList<>();

            for (int j = 0; j < 5; j++) {
                System.out.print("Digite a nota (0 a 5) atribuída pelo Avaliador " + (j+1) + ": ");
                double nota = in.nextDouble();

                Avaliador avaliador = new Avaliador(nota);
                avaliadores.add(avaliador);

                time.addNotaAvaliador(nota);
            }

            setAvaliadores(avaliadores.toArray(new Avaliador[0]));

        }
    }
        

}
