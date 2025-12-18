package abstractas.negocio;
public abstract class MetodoAutentificacion {
    int nivelSeguridad;
    String tipo;

    public MetodoAutentificacion(int nivelSeguridad, String tipo) {
        this.nivelSeguridad = nivelSeguridad;
        this.tipo = tipo;
    }

    public int getNivelSeguridad() {
        return nivelSeguridad;
    }

    public void setNivelSeguridad(int nivelSeguridad) {
        this.nivelSeguridad = nivelSeguridad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Nivel seguridad: "+nivelSeguridad+"\nTipo: "+tipo;
    }

    public abstract boolean autenticar(String dato);
}
