public class SalaAudio {
    private int dmIdSala;
    private String dmNombreSala;
    private String dmTematica;

    public SalaAudio(){   
    }

    public SalaAudio(int dmIdSala, String dmNombreSala, String dmTematica) {
        this.dmIdSala = dmIdSala;
        this.dmNombreSala = dmNombreSala;
        this.dmTematica = dmTematica;
    }
    public int dmGetIdSala() {
        return dmIdSala;
    }
    public void dmSetIdSala(int dmIdSala) {
        this.dmIdSala = dmIdSala;
    }
    public String dmGetNombreSala() {
        return dmNombreSala;
    }
    public void dmSetNombreSala(String dmNombreSala) {
        this.dmNombreSala = dmNombreSala;
    }
    public String dmGetTematica() {
        return dmTematica;
    }
    public void dmSetTematica(String dmTematica) {
        this.dmTematica = dmTematica;
    }


}
