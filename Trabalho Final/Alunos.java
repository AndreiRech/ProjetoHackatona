public class Alunos{
    private String matricula;
    private String nome;
    private String curso;
    private String email;
    public Alunos(String matricula, String nome, String curso, String email){
            this.matricula = matricula;
        if(!nome.trim().isEmpty()){
            this.nome = nome.toUpperCase();
        }
        if(curso.equals("ES") || curso.equals("CC") || curso.equals("SI") || curso.equals("EC") || curso.equals("CDIA")){
            this.curso = curso;
        }
            this.email = email;
    }

    public void setMatricula(String matricula){
            this.matricula = matricula;
        
    }
    public void setNome(String nome){
        if(!nome.trim().isEmpty()){
            this.nome = nome.toUpperCase();
        }
    }
    public void setCurso(String curso){
        if(curso.equals("ES") || curso.equals("CC") || curso.equals("SI") || curso.equals("EC") || curso.equals("CDIA")){
            this.curso = curso;
        }
    }
    public void setEmail(String email){
            this.email = email;
        }

    public String getMatricula(){
        return matricula;
    }
    public String getNome(){
        return nome;
    }
    public String getCurso(){
        return curso;
    }
    public String getEmail(){
        return email;
    }

    public String toString(){
        return "Nome: " + nome + "\nMatrícula: " + matricula + "\nCurso: " + curso + "\nEmail: " + email;
    }
}
