import java.time.LocalDate;
import java.util.Scanner;

public class AudioFan implements IMenuSalir {
    private String dmNombreApp;
    private Persona dmUsuarioActual;
    private LocalDate dmFechaActual;
    Scanner sc = new Scanner(System.in);
    FanPremium dmFp;
    Fan dmF;


    public AudioFan() {
        this.dmNombreApp = "Audio Fan";
        this.dmFechaActual = LocalDate.now();
    }

    public String dmGetNombreApp() {
        return dmNombreApp;
    }

    public void dmSetNombreApp(String dmNombreApp) {
        this.dmNombreApp = dmNombreApp;
    }

    public LocalDate dmGetFechaActual() {
        return dmFechaActual;
    }

    public void dmSetFechaActual(LocalDate dmFechaActual) {
        this.dmFechaActual = dmFechaActual;
    }

    public void dmMostrarMenu() {
        int dmOpcion = 0;
        while (dmOpcion != 5) {
            System.out.println("Fecha de acceso: " + dmGetFechaActual());
            System.out.println("Menú de " + dmGetNombreApp());
            System.out.println("1. Registrarse");
            System.out.println("2. Crear sala de audio");
            System.out.println("3. Entrar a una sala de audio");
            System.out.println("4. Buscar salas de audio por tematica");
            System.out.println("5. Salir del programa");
            System.out.print("\nIngrese la opción deseada: ");
            try {
                dmOpcion = Integer.parseInt(System.console().readLine());
                switch (dmOpcion) {
                    case 1:
                        System.out.println("************************");
                        System.out.println("      Registradose      ");
                        dmRegistrarse();
                        break;
                    case 2:
                        System.out.println("************************");
                        System.out.println("      Creando Sala      ");
                        if (!(dmUsuarioActual instanceof Fan) && !(dmUsuarioActual instanceof FanPremium)) {
                            System.out.println("Registrate antes: ");
                            dmRegistrarse();
                        } else {
                            if (dmUsuarioActual instanceof Fan) {
                                dmF.dmCrearSalas();
                            } else {
                                dmFp.dmCrearSalas();
                            }

                        }
                        break;
                    case 3:
                        System.out.println("************************");
                        System.out.println("      Entrando Sala     ");
                        if (!(dmUsuarioActual instanceof Fan) && !(dmUsuarioActual instanceof FanPremium)) {
                            System.out.println("Registrate antes: ");
                            dmRegistrarse();
                        } else {
                            if (dmUsuarioActual instanceof Fan) {
                                dmF.dmUnirseSalas();
                            } else {
                                dmFp.dmUnirseSalas();
                            }
                        }
                        break;
                    case 4:
                        System.out.println("************************");
                        System.out.println("      Buscando Sala     ");
                        if (!(dmUsuarioActual instanceof Fan) && !(dmUsuarioActual instanceof FanPremium)) {
                            System.out.println("Registrate antes: ");
                            dmRegistrarse();
                        } else {
                            if (dmUsuarioActual instanceof Fan) {
                                dmF.dmBuscarSala();
                            } else {
                                dmFp.dmBuscarSala();
                            }
                        }
                        break;
                    case 5:
                        System.out.println("************************");
                        System.out.println("      Muchas gracias    ");
                        dmSalirPrograma();
                        break;
                    default:
                        System.out.println("Opcion inexistente, por favor verifique");
                        break;
                }
                if (dmUsuarioActual instanceof FanPremium) {
                    dmMenuPremium();
                }
            } catch (Exception e) {
                System.out.println("Ingresar solo numeros");
            }
        }
    }

    public void dmMenuPremium() {
        int dmOpcion = 0;
        while (dmOpcion != 3) {
            System.out.println("1. Aplicacion normal");
            System.out.println("2. Widget");
            System.out.println("3. Salir");
            System.out.print("\nIngrese una opcion: ");
            try{
                 dmOpcion = Integer.parseInt(System.console().readLine());
            switch (dmOpcion) {
                case 1:
                    int dmVecesFalladas =0;
                    while (dmVecesFalladas<3) {
                        String username, password;
                        System.out.print("Ingresa tu username: ");
                        username = sc.nextLine();
                        System.out.print("Ingresa tu password: ");
                        password = sc.nextLine();
                        if (username.equals(dmFp.dmGetUsername())&&password.equals(dmFp.dmGetPassword())) {
                            dmMostrarMenu();
                            dmVecesFalladas = 5;
                        }else{
                            dmVecesFalladas++;
                        }
                    }
                    if (dmVecesFalladas==3) {
                        System.out.println("Fallaste, cuenta borrada por seguridad");
                        dmSalirPrograma();
                    }
                    break;
                case 2:
                    dmFp.dmConfigurarWidget();
                    break;
                case 3:
                    dmSalirPrograma();
                    break;
                default:
                    System.out.println("No existe esa opcion");
                    break;
            }
            }catch(Exception e){
                System.out.println("Solo numero por favor");
            }
           
        }

    }

    public void dmRegistrarse() {
        String dmNombre, dmIsPremium = "";
        System.out.print("Ingresa por favor tu nombre: ");
        dmNombre = sc.nextLine();
        System.out.print("Quieres ser usuario premium(y/n): ");
        dmIsPremium = sc.nextLine();
        if (dmIsPremium.equalsIgnoreCase("y")) {
            String dmUserName, dmPassword, dmApellido, dmDescripcion = "";
            System.out.print("Ingresa tu username: ");
            dmUserName = sc.nextLine();
            System.out.println("Ingresa tu password: ");
            dmPassword = sc.nextLine();
            System.out.println("**********************");
            System.out.println("    Personalizando    ");
            System.out.print("Ingresa tu apellido: ");
            dmApellido = sc.nextLine();
            sc.nextLine();
            System.out.print("Ingresa una breve descripcion: ");
            dmFp = new FanPremium(dmNombre, dmUserName, dmPassword, dmApellido, dmDescripcion);
            dmFp.dmCrearTC();
            dmUsuarioActual = dmFp;
        } else {
            dmF = new Fan(dmNombre);
            dmUsuarioActual = dmF;
        }
        dmUsuarioActual.dmCrearArchivoDeRegistro();
        dmUsuarioActual.dmLeerRegistro();
    }

    public void dmSalirPrograma() {
        dmUsuarioActual.dmCrearArchivoDeRegistro();
        dmUsuarioActual.dmEscribirRegistro();
        System.exit(0);
    }
}
