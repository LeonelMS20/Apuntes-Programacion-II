import java.time.LocalDate;
import java.util.Scanner;

public class Widget implements IMenuSalir {
    private String dmNombre;
    private LocalDate dmFechaActual;
    FanPremium dmFp = new FanPremium();
    Scanner sc = new Scanner(System.in);

    public String dmGetNombre() {
        return dmNombre;
    }

    public void dmSetNombre(String dmNombre) {
        this.dmNombre = dmNombre;
    }

    public LocalDate dmGetFechaActual() {
        return dmFechaActual;
    }

    public void dmSetFechaActual(LocalDate dmFechaActual) {
        this.dmFechaActual = dmFechaActual;
    }

    public Widget() {
        this.dmNombre = "Elegir sala";
        this.dmFechaActual = LocalDate.now();
    }

    public void dmUnirseSalas() {
        System.out.println("Widget: " + dmGetNombre());
        dmFp.dmUnirseSalas();
        dmMostrarMenu();
    }

    public void dmMostrarMenu() {
        int dmOpcion = 0;
        while (dmOpcion != 4) {
            System.out.println("1. Volver a unirse a una sala");
            System.out.println("2. Salir del widget");
            System.out.println("3. Salir del programa");
            System.out.print("Escoja una opcion: ");
            try {
                dmOpcion = Integer.parseInt(System.console().readLine());
                switch (dmOpcion) {
                    case 1:
                        dmUnirseSalas();
                        break;
                    case 2:
                        return;
                    case 3:
                        dmSalirPrograma();
                        break;
                    default:
                        System.out.println("No existe esa opcion");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Solo numeros por favor");
            }

        }
        return;
    }

    public void dmSalirPrograma() {
        dmFp.dmCrearArchivoDeRegistro();
        dmFp.dmEscribirRegistro();
        System.exit(0);
    }
}
