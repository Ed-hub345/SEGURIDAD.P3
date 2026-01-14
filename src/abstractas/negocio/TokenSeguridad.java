package abstractas.negocio;
public class TokenSeguridad extends MetodoAutentificacion {
    private String patronToken;
    public TokenSeguridad(int nivelSeguridad, String patronToken) {
        super(nivelSeguridad, "Token Seguridad");
        this.patronToken = patronToken;
    }
    public void setPatronToken(String patronToken) {
        this.patronToken = patronToken;
    }
    @Override
    public String toString() {
        return super.toString() + "\nPatrón Token: " + patronToken; }
    @Override
    public boolean autenticar(String dato){
        if(patronToken.equals(dato))
            return true;
        return false;
    }
}
