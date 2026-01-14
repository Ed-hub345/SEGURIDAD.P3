package abstractas.negocio;
public class ReconocimientoFacial extends MetodoAutentificacion {
    private String mapaRostro;
    public ReconocimientoFacial(int nivelSeguridad, String mapaRostro) {
        super(nivelSeguridad,"Reconocimiento Facial" );
        this.mapaRostro = mapaRostro;
    }
    public String getMapaRostro() {
        return mapaRostro;
    }
    public void setMapaRostro(String mapaRostro) {
        this.mapaRostro = mapaRostro;
    }
    @Override
    public String toString() {
        return super.toString()+"\nMapa rostro: "+mapaRostro;
    }
    @Override
    public boolean autenticar(String dato){
        if(mapaRostro.contains(dato))
            return true;
        return false;
    }
}
