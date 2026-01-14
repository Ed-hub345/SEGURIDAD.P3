package abstractas.negocio;
import java.util.ArrayList;
import java.util.List;
public class Empleado {
    private String cedula;
    private String nombre;
    private List<MetodoAutentificacion> autentificaciones;
    public Empleado(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        autentificaciones = new ArrayList<>();
    }
    public List<MetodoAutentificacion> getAutentificaciones() {
        return autentificaciones;
    }
    public String getCedula() {
        return cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void agregarAutentificacion(MetodoAutentificacion ma){
        autentificaciones.add(ma);
    }

    public int contarAutenticacionesToken(){
        int cont = 0;
        for(MetodoAutentificacion ma :autentificaciones){
            if(ma instanceof TokenSeguridad)
                cont++;
        }
        return cont;
    }
    public int contarAutenticacionesHuella(){
        int cont = 0;
        for(MetodoAutentificacion ma :autentificaciones){
            if(ma instanceof HuellaDigital)
                cont++;
        }
        return cont;
    }
    public int contarAutenticacionesReconocimientoFacial(){
        int cont = 0;
        for(MetodoAutentificacion ma :autentificaciones){
            if(ma instanceof ReconocimientoFacial)
                cont++;
        }
        return cont;
    }
    public boolean autenticar(String dato, String tipo){
        boolean resultado = false;
        for(MetodoAutentificacion ma: autentificaciones){
            if (tipo.equalsIgnoreCase("huella digital")){
                if (ma instanceof HuellaDigital)
                    if (ma.autenticar(dato)){
                        resultado = true;
                        break;
                    }
            }else if(tipo.equalsIgnoreCase("Reconomiento Facial")){
                if(ma instanceof ReconocimientoFacial)
                    if (ma.autenticar(dato)){
                        resultado = true;
                        break;
                    }
            }else
                if (ma.autenticar(dato)){
                    resultado = true;
                    break;
                }
        }
        return resultado;
    }
    public String autenticacionesUmbral(int umbral){
        String metodos ="";
        for(MetodoAutentificacion ma: autentificaciones){
            if(ma.getNivelSeguridad() > umbral)
                metodos += ma.getTipo()+"\n";
        }
        return metodos;
    }
    public boolean autenticar(String cedula, String tipo, String valor){
        if(!this.cedula.equals(cedula))
            return false;

        for(MetodoAutentificacion ma : autentificaciones){
            if(tipo.equalsIgnoreCase(ma.getTipo())){
                if(ma.autenticar(valor))
                    return true;
            }
        }
        return false;
    }
}
