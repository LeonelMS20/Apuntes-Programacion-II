import java.util.Scanner;

public class FanPremium extends Persona {
    private String dmUsername;
    private String dmPassword;
    private String dmApellido;
    private String dmDescripcion;
    Scanner sc = new Scanner(System.in);
    public FanPremium(){

    }
    
    public FanPremium(String dmNombre, String dmUsername, String dmPassword, String dmApellido, String dmDescripcion) {
        super(dmNombre);
        this.dmUsername = dmUsername;
        this.dmPassword = dmPassword;
        this.dmApellido = dmApellido;
        this.dmDescripcion = dmDescripcion;
    }

    public String dmGetUsername() {
        return dmUsername;
    }
    public void dmSetUsername(String dmUsername) {
        this.dmUsername = dmUsername;
    }
    public String dmGetPassword() {
        return dmPassword;
    }
    public void dmSetPassword(String dmPassword) {
        this.dmPassword = dmPassword;
    }
    public String dmGetApellido() {
        return dmApellido;
    }
    public void setDmApellido(String dmApellido) {
        this.dmApellido = dmApellido;
    }
    public String dmSetDescripcion() {
        return dmDescripcion;
    }
    public void dmSetDescripcion(String dmDescripcion) {
        this.dmDescripcion = dmDescripcion;
    }

    public void dmConfigurarWidget(){
        Widget dmWidget = new Widget();
        dmWidget.dmUnirseSalas();
    }

    public void dmCrearTC(){
        String dmNumeroTarjeta, dmCvv;
        System.out.println("Ingresa numero de la tarjeta: ");
        dmNumeroTarjeta=sc.nextLine();
        System.out.println("Ingrese el cvv");
        dmCvv = sc.nextLine();
        TarjetaCredito tc = new TarjetaCredito(dmNumeroTarjeta, dmCvv);
        tc.dmPagar();
        dmCrearAvatares();
    }

    public void dmCrearAvatares(){
        System.out.println("Avatar creado");
    }

}
