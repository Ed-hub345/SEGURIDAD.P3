package abstractas.utilitario;

import abstractas.negocio.Empleado;
import abstractas.negocio.HuellaDigital;
import abstractas.negocio.ReconocimientoFacial;
import abstractas.negocio.TokenSeguridad;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public List<Empleado> empleados;

    public Util(){
        empleados = new ArrayList<>();
    }

    // Métodos de validación
    private void validarCedula(String cedula) throws IllegalArgumentException {
        if (cedula == null || cedula.trim().isEmpty()) {
            throw new IllegalArgumentException("La cédula no puede estar vacía");
        }
        if (cedula.length() != 10) {
            throw new IllegalArgumentException("La cédula debe tener exactamente 10 dígitos");
        }
        for (int i = 0; i < cedula.length(); i++) {
            if (!Character.isDigit(cedula.charAt(i))) {
                throw new IllegalArgumentException("La cédula solo puede contener números");
            }
        }
    }

    private void validarNivelSeguridad(int nivelSeguridad) throws IllegalArgumentException {
        if (nivelSeguridad < 1 || nivelSeguridad > 10) {
            throw new IllegalArgumentException("El nivel de seguridad debe estar entre 1 y 10");
        }
    }

    private void validarPatron(String patron, String tipoPatron) throws IllegalArgumentException {
        if (patron == null || patron.trim().isEmpty()) {
            throw new IllegalArgumentException("El " + tipoPatron + " no puede estar vacío");
        }
    }

    private void validarNombre(String nombre) throws IllegalArgumentException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }

    private void validarEmpleadoNoExiste(String cedula) throws IllegalArgumentException {
        if (buscarEmpleado(cedula) != -1) {
            throw new IllegalArgumentException("Ya existe un empleado con esta cédula");
        }
    }

    private void validarEmpleadoExiste(String cedula) throws IllegalArgumentException {
        if (buscarEmpleado(cedula) == -1) {
            throw new IllegalArgumentException("El empleado no existe");
        }
    }

    public void agregarEmpleado(String cedula, String nombre){
        try {
            validarCedula(cedula);
            validarNombre(nombre);
            validarEmpleadoNoExiste(cedula);

            empleados.add(new Empleado(cedula, nombre));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error al agregar empleado: " + e.getMessage());
        }
    }

    public int buscarEmpleado(String cedula){
        try {
            validarCedula(cedula);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return -1;
        }

        for(int i = 0; i < empleados.size(); i++){
            if (empleados.get(i).getCedula().equals(cedula))
                return i;
        }
        return -1;
    }

    public void agregarAutentificacionHuella(String cedula, int nivelSeguridad, String patronHuella){
        try {
            validarCedula(cedula);
            validarNivelSeguridad(nivelSeguridad);
            validarPatron(patronHuella, "patrón de huella");
            validarEmpleadoExiste(cedula);

            int indice = buscarEmpleado(cedula);
            empleados.get(indice).agregarAutentificacion(new HuellaDigital(nivelSeguridad, patronHuella));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error al agregar huella digital: " + e.getMessage());
        }
    }

    public void agregarAutentificacionToken(String cedula, int nivelSeguridad, String patronToken){
        try {
            validarCedula(cedula);
            validarNivelSeguridad(nivelSeguridad);
            validarPatron(patronToken, "patrón token");
            validarEmpleadoExiste(cedula);

            int indice = buscarEmpleado(cedula);
            empleados.get(indice).agregarAutentificacion(new TokenSeguridad(nivelSeguridad, patronToken));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error al agregar token de seguridad: " + e.getMessage());
        }
    }

    public void agregarAutentificacionRostro(String cedula, int nivelSeguridad, String mapaRostro){
        try {
            validarCedula(cedula);
            validarNivelSeguridad(nivelSeguridad);
            validarPatron(mapaRostro, "mapa de rostro");
            validarEmpleadoExiste(cedula);

            int indice = buscarEmpleado(cedula);
            empleados.get(indice).agregarAutentificacion(new ReconocimientoFacial(nivelSeguridad, mapaRostro));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error al agregar reconocimiento facial: " + e.getMessage());
        }
    }

    public int contarAuntentificacionesHuella(String cedula){
        try {
            validarCedula(cedula);
            validarEmpleadoExiste(cedula);

            int indice = buscarEmpleado(cedula);
            return empleados.get(indice).contarAutenticacionesHuella();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return -1;
        }
    }

    public String metodosAuntentificacionMayorUmbral(String cedula, int umbral){
        try {
            validarCedula(cedula);
            validarNivelSeguridad(umbral);
            validarEmpleadoExiste(cedula);

            int indice = buscarEmpleado(cedula);
            return empleados.get(indice).autenticacionesUmbral(umbral);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public  void menu(){
        System.out.println("\n===== MENU =====");
        System.out.println("1. Agregar empleado");
        System.out.println("2. Agregar Token Seguridad");
        System.out.println("3. Agregar Reconocimiento Facial");
        System.out.println("4. Agregar Huella Digital");
        System.out.println("5. Mostrar datos de todos los empleados");
        System.out.println("6. Buscar empleado y mostrar datos");
        System.out.println("7. Total métodos autenticación empleado");
        System.out.println("8. Total métodos huella empleado");
        System.out.println("9. Total métodos token empleado");
        System.out.println("10. Total métodos facial empleado");
        System.out.println("11. Métodos mayor a umbral de empleado");
        System.out.println("12. Autenticar empleado");
        System.out.println("14. Salir");
        System.out.print("Seleccione opción: ");
    }
}