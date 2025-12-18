package abstractas.negocio;

public class HuellaDigital extends MetodoAutentificacion {
    private String patronHuella;

    public HuellaDigital(int nivelSeguridad, String patronHuella) {
        super(nivelSeguridad, "Huella Digital");
        this.patronHuella = patronHuella;
    }

    public String getPatronHuella() {
        return patronHuella;
    }

    public void setPatronHuella(String patronHuella) {
        this.patronHuella = patronHuella;
    }

    @Override
    public String toString() {
        return super.toString()+"\nPatron Huella: "+patronHuella;

    }

    @Override
    public boolean autenticar(String dato){
        if(patronHuella.contains(dato))
            return true;
        return false;
    }

}
