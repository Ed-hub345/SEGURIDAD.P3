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
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido");
                opcion = 0;
                continue;
            }

            switch(opcion){
                case 1:
                    String ced = "";
                    String nom = "";

                    // Bucle para cédula
                    boolean cedulaValida = false;
                    while (!cedulaValida) {
                        System.out.print("Cédula: ");
                        ced = sc.nextLine();
                        try {
                            // Validar formato de cédula (sin agregar empleado aún)
                            if (ced == null || ced.trim().isEmpty()) {
                                System.out.println("Error: La cédula no puede estar vacía");
                                continue;
                            }
                            if (ced.length() != 10) {
                                System.out.println("Error: La cédula debe tener exactamente 10 dígitos");
                                continue;
                            }
                            for (int i = 0; i < ced.length(); i++) {
                                if (!Character.isDigit(ced.charAt(i))) {
                                    System.out.println("Error: La cédula solo puede contener números");
                                    continue;
                                }
                            }
                            if (ced.startsWith("-")) {
                                System.out.println("Error: La cédula no puede ser negativa");
                                continue;
                            }

                            // Validar que no exista ya
                            if (util.buscarEmpleado(ced) != -1) {
                                System.out.println("Error: Ya existe un empleado con esta cédula");
                                break; // Salir del bucle si la cédula ya existe
                            }

                            cedulaValida = true;
                        } catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }

                    if (!cedulaValida) break; // Si salió por cédula duplicada, volver al menú

                    // Bucle para nombre
                    boolean nombreValido = false;
                    while (!nombreValido) {
                        System.out.print("Nombre: ");
                        nom = sc.nextLine();
                        if (nom == null || nom.trim().isEmpty()) {
                            System.out.println("Error: El nombre no puede estar vacío");
                        } else {
                            nombreValido = true;
                        }
                    }

                    // Agregar empleado
                    try {
                        util.agregarEmpleado(ced, nom);
                        System.out.println("Empleado agregado con éxito");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    if (util.empleados.size() == 0) {
                        System.out.println("No hay empleados registrados");
                        break;
                    }

                    // Bucle para cédula
                    ced = "";
                    boolean cedulaEncontrada = false;
                    while (!cedulaEncontrada) {
                        System.out.print("Cédula: ");
                        ced = sc.nextLine();
                        try {
                            if (util.buscarEmpleado(ced) == -1) {
                                System.out.println("Error: El empleado no existe");
                            } else {
                                cedulaEncontrada = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Error: Cédula inválida");
                        }
                    }

                    // Bucle para nivel de seguridad
                    int ns = 0;
                    boolean nivelValido = false;
                    while (!nivelValido) {
                        System.out.print("Nivel seguridad(1-10): ");
                        try {
                            ns = Integer.parseInt(sc.nextLine());
                            if (ns < 1 || ns > 10) {
                                System.out.println("Error: El nivel de seguridad debe estar entre 1 y 10");
                            } else {
                                nivelValido = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Debe ingresar un número válido");
                        }
                    }

                    // Bucle para patrón token
                    String token = "";
                    boolean tokenValido = false;
                    while (!tokenValido) {
                        System.out.print("Patrón token: ");
                        token = sc.nextLine();
                        if (token == null || token.trim().isEmpty()) {
                            System.out.println("Error: El patrón token no puede estar vacío");
                        } else {
                            tokenValido = true;
                        }
                    }

                    // Agregar token
                    try {
                        util.agregarAutentificacionToken(ced, ns, token);
                        System.out.println("Token agregado con éxito");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    if (util.empleados.size() == 0) {
                        System.out.println("No hay empleados registrados");
                        break;
                    }

                    // Bucle para cédula
                    ced = "";
                    cedulaEncontrada = false;
                    while (!cedulaEncontrada) {
                        System.out.print("Cédula: ");
                        ced = sc.nextLine();
                        try {
                            if (util.buscarEmpleado(ced) == -1) {
                                System.out.println("Error: El empleado no existe");
                            } else {
                                cedulaEncontrada = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Error: Cédula inválida");
                        }
                    }

                    // Bucle para nivel de seguridad
                    ns = 0;
                    nivelValido = false;
                    while (!nivelValido) {
                        System.out.print("Nivel seguridad (1-10): ");
                        try {
                            ns = Integer.parseInt(sc.nextLine());
                            if (ns < 1 || ns > 10) {
                                System.out.println("Error: El nivel de seguridad debe estar entre 1 y 10");
                            } else {
                                nivelValido = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Debe ingresar un número válido");
                        }
                    }

                    // Bucle para mapa rostro
                    String rostro = "";
                    boolean rostroValido = false;
                    while (!rostroValido) {
                        System.out.print("Mapa rostro: ");
                        rostro = sc.nextLine();
                        if (rostro == null || rostro.trim().isEmpty()) {
                            System.out.println("Error: El mapa de rostro no puede estar vacío");
                        } else {
                            rostroValido = true;
                        }
                    }

                    try {
                        util.agregarAutentificacionRostro(ced, ns, rostro);
                        System.out.println("Reconocimiento Facial agregado con éxito");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    if (util.empleados.size() == 0) {
                        System.out.println("No hay empleados registrados");
                        break;
                    }

                    // Bucle para cédula
                    ced = "";
                    cedulaEncontrada = false;
                    while (!cedulaEncontrada) {
                        System.out.print("Cédula: ");
                        ced = sc.nextLine();
                        try {
                            if (util.buscarEmpleado(ced) == -1) {
                                System.out.println("Error: El empleado no existe");
                            } else {
                                cedulaEncontrada = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Error: Cédula inválida");
                        }
                    }

                    // Bucle para nivel de seguridad
                    ns = 0;
                    nivelValido = false;
                    while (!nivelValido) {
                        System.out.print("Nivel seguridad (1-10): ");
                        try {
                            ns = Integer.parseInt(sc.nextLine());
                            if (ns < 1 || ns > 10) {
                                System.out.println("Error: El nivel de seguridad debe estar entre 1 y 10");
                            } else {
                                nivelValido = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Debe ingresar un número válido");
                        }
                    }

                    // Bucle para patrón huella
                    String huella = "";
                    boolean huellaValida = false;
                    while (!huellaValida) {
                        System.out.print("Patrón huella: ");
                        huella = sc.nextLine();
                        if (huella == null || huella.trim().isEmpty()) {
                            System.out.println("Error: El patrón de huella no puede estar vacío");
                        } else {
                            huellaValida = true;
                        }
                    }

                    try {
                        util.agregarAutentificacionHuella(ced, ns, huella);
                        System.out.println("Huella agregada con éxito");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    if (util.empleados.size() == 0) {
                        System.out.println("No hay empleados registrados");
                        break;
                    }
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
                    ced = "";
                    cedulaEncontrada = false;
                    int indice = -1;  // INICIALIZAR AQUÍ
                    while (!cedulaEncontrada) {
                        System.out.print("Cédula: ");
                        ced = sc.nextLine();
                        try {
                            indice = util.buscarEmpleado(ced);
                            if (indice == -1) {
                                System.out.println("Error: El empleado no existe");
                            } else {
                                cedulaEncontrada = true;
                                Empleado e = util.empleados.get(indice);
                                System.out.println("\nCédula: " + e.getCedula());
                                System.out.println("Nombre: " + e.getNombre());
                                System.out.println("Autenticaciones:");
                                for (MetodoAutentificacion ma : e.getAutentificaciones()) {
                                    System.out.println(ma);
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("Error: Cédula inválida");
                        }
                    }
                    break;

                case 7:
                    if (util.empleados.size() == 0) {
                        System.out.println("No hay empleados registrados");
                        break;
                    }
                    ced = "";
                    cedulaEncontrada = false;
                    indice = -1;  // INICIALIZAR AQUÍ
                    while (!cedulaEncontrada) {
                        System.out.print("Cédula: ");
                        ced = sc.nextLine();
                        try {
                            indice = util.buscarEmpleado(ced);
                            if (indice == -1) {
                                System.out.println("Error: El empleado no existe");
                            } else {
                                cedulaEncontrada = true;
                                System.out.println("Total métodos: " + util.empleados.get(indice).getAutentificaciones().size());
                            }
                        } catch (Exception e) {
                            System.out.println("Error: Cédula inválida");
                        }
                    }
                    break;

                case 8:
                    if (util.empleados.size() == 0) {
                        System.out.println("No hay empleados registrados");
                        break;
                    }

                    // Bucle para cédula
                    ced = "";
                    cedulaEncontrada = false;
                    indice = -1;  // INICIALIZAR AQUÍ
                    while (!cedulaEncontrada) {
                        System.out.print("Cédula: ");
                        ced = sc.nextLine();
                        try {
                            indice = util.buscarEmpleado(ced);
                            if (indice == -1) {
                                System.out.println("Error: El empleado no existe");
                            } else {
                                cedulaEncontrada = true;
                                System.out.println("Total huellas: " + util.empleados.get(indice).contarAutenticacionesHuella());
                            }
                        } catch (Exception e) {
                            System.out.println("Error: Cédula inválida");
                        }
                    }
                    break;

                case 9:
                    if (util.empleados.size() == 0) {
                        System.out.println("No hay empleados registrados");
                        break;
                    }
                    ced = "";
                    cedulaEncontrada = false;
                    indice = -1;  // INICIALIZAR AQUÍ
                    while (!cedulaEncontrada) {
                        System.out.print("Cédula: ");
                        ced = sc.nextLine();
                        try {
                            indice = util.buscarEmpleado(ced);
                            if (indice == -1) {
                                System.out.println("Error: El empleado no existe");
                            } else {
                                cedulaEncontrada = true;
                                System.out.println("Total tokens: " + util.empleados.get(indice).contarAutenticacionesToken());
                            }
                        } catch (Exception e) {
                            System.out.println("Error: Cédula inválida");
                        }
                    }
                    break;

                case 10:
                    if (util.empleados.size() == 0) {
                        System.out.println("No hay empleados registrados");
                        break;
                    }

                    // Bucle para cédula
                    ced = "";
                    cedulaEncontrada = false;
                    indice = -1;  // INICIALIZAR AQUÍ
                    while (!cedulaEncontrada) {
                        System.out.print("Cédula: ");
                        ced = sc.nextLine();
                        try {
                            indice = util.buscarEmpleado(ced);
                            if (indice == -1) {
                                System.out.println("Error: El empleado no existe");
                            } else {
                                cedulaEncontrada = true;
                                System.out.println("Total faciales: " + util.empleados.get(indice).contarAutenticacionesReconocimientoFacial());
                            }
                        } catch (Exception e) {
                            System.out.println("Error: Cédula inválida");
                        }
                    }
                    break;

                case 11:
                    if (util.empleados.size() == 0) {
                        System.out.println("No hay empleados registrados");
                        break;
                    }

                    // Bucle para cédula
                    ced = "";
                    cedulaEncontrada = false;
                    indice = -1;  // INICIALIZAR AQUÍ
                    while (!cedulaEncontrada) {
                        System.out.print("Cédula: ");
                        ced = sc.nextLine();
                        try {
                            indice = util.buscarEmpleado(ced);
                            if (indice == -1) {
                                System.out.println("Error: El empleado no existe");
                            } else {
                                cedulaEncontrada = true;
                            }
                        } catch (Exception e) {
                            System.out.println("Error: Cédula inválida");
                        }
                    }

                    // Bucle para umbral
                    int um = 0;
                    boolean umbralValido = false;
                    while (!umbralValido) {
                        System.out.print("Umbral(1-10): ");
                        try {
                            um = Integer.parseInt(sc.nextLine());
                            if (um < 1 || um > 10) {
                                System.out.println("Error: El umbral debe estar entre 1 y 10");
                            } else {
                                umbralValido = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Debe ingresar un número válido");
                        }
                    }

                    if (indice != -1) {
                        String metodos = util.empleados.get(indice).autenticacionesUmbral(um);
                        if (metodos.isEmpty()) {
                            System.out.println("No hay métodos con nivel mayor a " + um);
                        } else {
                            System.out.println(metodos);
                        }
                    } else {
                        System.out.println("El empleado no existe");
                    }
                    break;

                case 12:
                    if (util.empleados.size() == 0) {
                        System.out.println("No hay empleados registrados");
                        break;
                    }
                    ced = "";
                    cedulaEncontrada = false;
                    indice = -1;  // INICIALIZAR CON VALOR POR DEFECTO
                    while (!cedulaEncontrada) {
                        System.out.print("Cédula: ");
                        ced = sc.nextLine();
                        try {
                            int ind = util.buscarEmpleado(ced);
                            if (ind == -1) {
                                System.out.println("Error: El empleado no existe");
                            } else {
                                cedulaEncontrada = true;
                                indice = ind;
                            }
                        } catch (Exception e) {
                            System.out.println("Error: Cédula inválida");
                        }
                    }

                    System.out.print("Tipo: ");
                    String tipo = sc.nextLine();
                    System.out.print("Valor: ");
                    String valor = sc.nextLine();

                    if (indice != -1) {
                        boolean ok = util.empleados.get(indice).autenticar(ced, tipo, valor);
                        System.out.println(ok ? "Autenticación exitosa" : "Falló autenticación");
                    } else {
                        System.out.println("El empleado no existe");
                    }
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