package BusinessLayer;

public class Avaliacao {
    private String user;
    private int aval;
    
    public Avaliacao(String user, int av) {
        this.user = user;
        this.aval = av;
    }

    public String getUser() {
        return this.user;
    }

    public int getAval() {
        return this.aval;
    }
    
}
