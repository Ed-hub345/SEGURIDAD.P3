package abstractas.interfaz;
import abstractas.negocio.*;
import abstractas.utilitario.Util;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Util util = new Util();
        int opcion;

        do {
            util.menu();
            opcion = Integer.parseInt(sc.nextLine());
            switch(opcion){

                case 1:
                    System.out.print("Cédula: ");
                    String ced = sc.nextLine();
                    System.out.print("Nombre: ");
                    String nom = sc.nextLine();
                    util.agregarEmpleado(ced, nom);
                    break;

                case 2:
                    if (util.empleados.size() == 0) {
                        System.out.println("No hay empleados registrados");
                        break; }
                    System.out.print("Cédula: ");
                    ced = sc.nextLine();
                    System.out.print("Nivel seguridad: ");
                    int ns = sc.nextInt(); sc.nextLine();
                    System.out.print("Patrón token: ");
                    String token = sc.nextLine();
                    util.agregarAutentificacionToken(ced, ns, token);
                    System.out.println("Token agregado con éxito");
                    break;

                case 3:
                    if (util.empleados.size() == 0) {
                        System.out.println("No hay empleados registrados");
                        break; }
                    System.out.print("Cédula: ");
                    ced = sc.nextLine();
                    System.out.print("Nivel seguridad: ");
                    ns = sc.nextInt(); sc.nextLine();
                    System.out.print("Mapa rostro: ");
                    String rostro = sc.nextLine();
                    util.agregarAutentificacionRostro(ced, ns, rostro);
                    System.out.println("Huella Reconomiento Facial agregado con éxito");
                    break;

                case 4:
                    if (util.empleados.size() == 0) {
                        System.out.println("No hay empleados registrados");
                        break; }
                    System.out.print("Cédula: ");
                    ced = sc.nextLine();
                    System.out.print("Nivel seguridad: ");
                    ns = sc.nextInt(); sc.nextLine();
                    System.out.print("Patrón huella: ");
                    String huella = sc.nextLine();
                    util.agregarAutentificacionHuella(ced, ns, huella);
                    System.out.println("Huella agregada con éxito");
                    break;

                case 5:
                    if (util.empleados.size() == 0) {
                        System.out.println("No hay empleados registrados");
                        break; }
                    for (int i = 0; i < util.empleados.size(); i++) {
                        Empleado e = util.empleados.get(i);
                        System.out.println("\nCédula: " + e.getCedula());
                        System.out.println("Nombre: " + e.getNombre());
                        System.out.println("Autenticaciones:");
                        for (MetodoAutentificacion ma : e.getAutentificaciones()) {
                            System.out.println(ma);
                        }
                        System.out.println("------------------------");
                    }
                    break;

                case 6:
                    if (util.empleados.size() == 0) {
                        System.out.println("No hay empleados registrados");
                        break;
                    }
                    System.out.print("Cédula: ");
                    ced = sc.nextLine();
                    int indice = util.buscarEmpleado(ced);
                    if (indice != -1) {
                        Empleado e = util.empleados.get(indice);
                        System.out.println("\nCédula: " + e.getCedula());
                        System.out.println("Nombre: " + e.getNombre());
                        System.out.println("Autenticaciones:");
                        for (MetodoAutentificacion ma : e.getAutentificaciones()) {
                            System.out.println(ma);
                        }
                    } else { System.out.println("El empleado no existe");
                    } break;

                case 7:
                    if (util.empleados.size() == 0) {
                        System.out.println("No hay empleados registrados");
                        break;
                    }
                    System.out.print("Cédula: ");
                    ced = sc.nextLine();
                    indice = util.buscarEmpleado(ced);
                    if (indice != -1) {
                        System.out.println("Total métodos: " + util.empleados.get(indice).getAutentificaciones().size());
                    } else System.out.println("El empleado no existe");
                    break;

                case 8:
                    if (util.empleados.size() == 0) {
                        System.out.println("No hay empleados registrados");
                        break;
                    }
                    System.out.print("Cédula: ");
                    ced = sc.nextLine();
                    indice = util.buscarEmpleado(ced);
                    if (indice != -1) {
                        System.out.println("Total huellas: " + util.empleados.get(indice).contarAutenticacionesHuella());
                    } else
                        System.out.println("El empleado no existe");
                    break;

                case 9:
                    if (util.empleados.size() == 0) {
                        System.out.println("No hay empleados registrados");
                        break;
                    }
                    System.out.print("Cédula: ");
                    ced = sc.nextLine();
                    indice = util.buscarEmpleado(ced);
                    if (indice != -1) {
                        System.out.println("Total tokens: " + util.empleados.get(indice).contarAutenticacionesToken());
                    } else
                        System.out.println("El empleado no existe");
                    break;

                case 10:
                    if (util.empleados.size() == 0) {
                        System.out.println("No hay empleados registrados");
                        break;
                    }
                    System.out.print("Cédula: ");
                    ced = sc.nextLine();
                    indice = util.buscarEmpleado(ced);
                    if (indice != -1) {
                        System.out.println("Total faciales: " + util.empleados.get(indice).contarAutenticacionesReconocimientoFacial());
                    } else System.out.println("El empleado no existe");
                    break;

                case 11:
                    if (util.empleados.size() == 0) {
                        System.out.println("No hay empleados registrados");
                        break;
                    }
                    System.out.print("Cédula: ");
                    ced = sc.nextLine();
                    System.out.print("Umbral: ");
                    int um = sc.nextInt();
                    sc.nextLine();
                    indice = util.buscarEmpleado(ced);
                    if (indice != -1) {
                        System.out.println(util.empleados.get(indice).autenticacionesUmbral(um));
                    } else
                        System.out.println("El empleado no existe");
                    break;

                case 12:
                    if (util.empleados.size() == 0) {
                        System.out.println("No hay empleados registrados");
                        break;
                    }
                    System.out.print("Cédula: ");
                    ced = sc.nextLine();
                    System.out.print("Tipo: ");
                    String tipo = sc.nextLine();
                    System.out.print("Valor: ");
                    String valor = sc.nextLine();
                    indice = util.buscarEmpleado(ced);
                    if (indice != -1) {
                        boolean ok = util.empleados.get(indice).autenticar(ced, tipo, valor);
                        System.out.println(ok ? "Autenticación exitosa" : "Falló autenticación");
                    } else
                        System.out.println("El empleado no existe");
                    break;

                case 14:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while(opcion != 14);
    }
}
