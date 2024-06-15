import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Persona {
    Scanner sc = new Scanner(System.in);
    private String dmNombre;
    private List<SalaAudio> dmListaSalas = new ArrayList<SalaAudio>();

    /*public Persona() {

    }*/

    public Persona(String dmNombre) {
        this.dmNombre = dmNombre;
    }

    public String dmGetNombre() {
        return dmNombre;
    }

    public void dmSetNombre(String dmNombre) {
        this.dmNombre = dmNombre;
    }

    public List<SalaAudio> dmGetListaSalas() {
        return dmListaSalas;
    }

    public void dmSetListaSalas(List<SalaAudio> dmListaSalas) {
        this.dmListaSalas = dmListaSalas;
    }

    public void dmCrearSalas() {
        String dmNombreSala = null, dmTematica = null;
        do {
            System.out.println("Ingresa el nombre de la sala: ");
            dmNombreSala = sc.nextLine();
            System.out.println("Ingresa la tematica de la sala: ");
            dmTematica = sc.nextLine();
            if (dmNombreSala.equals(null) && dmTematica.equals(null)) {
                System.out.println("Por favor ingresa los campos solicitados");
            }
        } while (dmNombreSala.equals(null) && dmTematica.equals(null));
        dmListaSalas.add(new SalaAudio(dmListaSalas.size() + 1, dmNombreSala, dmTematica));
    }

    public void dmUnirseSalas() {
        if (dmListaSalas.size() != 0) {
            int dmOpcionSala = 0;
            System.out.println("Estas son las salas disponibles");
            for (SalaAudio dmSalaAudio : dmListaSalas) {
                System.out.println(dmSalaAudio.dmGetIdSala() + " " + dmSalaAudio.dmGetNombreSala() + " "
                        + dmSalaAudio.dmGetTematica());
            }
            System.out.print("\nIngrese el numero de la sala a la que quiere ingresar");
            try {
                dmOpcionSala = Integer.parseInt(sc.nextLine());
                System.out.println("Entrando a la sala " + dmListaSalas.get(dmOpcionSala - 1).dmGetNombreSala());
            } catch (Exception e) {
                System.out.println("Error en formato de entrada");
            }
        } else {
            System.out.println("No hay registros de salas");
        }

    }

    public void dmBuscarSala() {
        if (dmListaSalas.size() != 0) {
            System.out.println("Que tematica estas buscando: ");
            String dmPalabraClave = sc.nextLine();
            System.out.println("Estas son las salas que encontramos: ");
            for (SalaAudio dmSalaAudio : dmListaSalas) {
                if (dmSalaAudio.dmGetTematica().equalsIgnoreCase(dmPalabraClave)) {
                    System.out.println(dmSalaAudio.dmGetIdSala() + " " + dmSalaAudio.dmGetNombreSala() + " "
                            + dmSalaAudio.dmGetTematica());
                }
            }
        } else {
            System.out.println("No hay registros de salas");
        }

    }

    public void dmCrearArchivoDeRegistro() {
        Path path = Paths.get("listaSalaAudio.cvs");
        try {
            if (Files.notExists(path)) {
                Files.createFile(path);
            } else {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dmEscribirRegistro() {
        try (FileWriter writer = new FileWriter("listaSalaAudio.cvs", true)) {
            for (SalaAudio dmSalasAudio : dmListaSalas) {
                writer.write(dmSalasAudio.dmGetIdSala() + "," + dmSalasAudio.dmGetNombreSala() + ","
                        + dmSalasAudio.dmGetTematica() + "\n");
            }
            writer.flush();
            System.out.println("Se añadió texto al archivo exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dmLeerRegistro() {
        try (BufferedReader reader = new BufferedReader(new FileReader("listaSalaAudio.cvs"))) {
            System.out.println("Contenido del archivo:");
            String line;
            String nombre = "", tematica = "";
            String[] datos = new String[3];
            int idSala;
            while ((line = reader.readLine()) != null) {
                datos = line.split(",");
                idSala = Integer.parseInt(datos[0]);
                nombre = datos[1];
                tematica = datos[2];
                dmListaSalas.add(new SalaAudio(idSala, nombre, tematica));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


