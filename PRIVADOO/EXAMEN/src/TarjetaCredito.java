public class TarjetaCredito {
    private String dmNumeroTarjeta;
    private String dmCvv;

    public TarjetaCredito(String dmNumeroTarjeta, String dmCvv){
        this.dmCvv = dmCvv;
        this.dmNumeroTarjeta = dmNumeroTarjeta;
    }
    public String dmGetNumeroTarjeta() {
        return dmNumeroTarjeta;
    }
    public void dmSetNumeroTarjeta(String dmNumeroTarjeta) {
        this.dmNumeroTarjeta = dmNumeroTarjeta;
    }
    public String dmGetCvv() {
        return dmCvv;
    }
    public void dmSetCvv(String dmCvv) {
        this.dmCvv = dmCvv;
    }

    public void dmPagar(){
        System.out.println("Suscripcion pagada....");
    }
}
