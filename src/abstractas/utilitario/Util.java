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

    public void agregarEmpleado(String cedula, String nombre){
        int indice = buscarEmpleado(cedula);
        if (indice == -1)
            empleados.add(new Empleado(cedula,nombre));
        else
            System.out.println("El empleado ya existe");

    }
    public int buscarEmpleado(String cedula){
        for(int i = 0; i < empleados.size(); i++){
            if (empleados.get(i).getCedula().equals(cedula))
                return  i;
        }
        return -1;
    }

    public void agregarAutentificacionHuella(String cedula, int nivelSeguridad, String patronHuella){
        int indice = buscarEmpleado(cedula);
        if (indice != -1)
            empleados.get(indice).agregarAutentificacion(new HuellaDigital(nivelSeguridad, patronHuella));
        else
            System.out.println("El empleado no existe");

    }

    public void agregarAutentificacionToken(String cedula, int nivelSeguridad, String patronHuella){ // hacer
        int indice = buscarEmpleado(cedula);
        if (indice != -1)
            empleados.get(indice).agregarAutentificacion(new TokenSeguridad(nivelSeguridad, patronHuella));
        else
            System.out.println("El empleado no existe");

    }

    public void agregarAutentificacionRostro(String cedula, int nivelSeguridad, String patronHuella){ // hacer
        int indice = buscarEmpleado(cedula);
        if (indice != -1)
            empleados.get(indice).agregarAutentificacion(new ReconocimientoFacial(nivelSeguridad, patronHuella));
        else
            System.out.println("El empleado no existe");

    }

    public int contarAuntentificacionesHuella(String cedula){
        int indice = buscarEmpleado(cedula);
        if (indice != -1)
            return  empleados.get(indice).contarAutenticacionesToken();
        else{
            System.out.println("El empleado no existe");
            return -1;
        }

    }

    public String metodosAuntentificacionMayorUmbral(String cedula, int umbral){
        int indice = buscarEmpleado(cedula);
        if (indice != -1)
            return empleados.get(indice).autenticacionesUmbral(umbral);
        else{
            System.out.println("El empleado no existe");
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
