package aplicativos.Registro;

public class Piloto extends Pessoa {
    private String breve;
    private int matricula;    
    public String getBreve() {
        return breve;
    }
    public void setBreve(String breve) {
        this.breve = breve;
    }
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
}
