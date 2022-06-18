package model;

public class ArtistaVo {

     //Atributos propios de la clase
    private int idArtista;
    private int noDocumento;
    private String tipoDocumento;
    private String nombreArtista;
    private String apellidoArtista;
    private String nombreArtistico;
    private int feNacimArtista;
    private String emailArtista;
    private Boolean estadoArtista;


    //Constructor Vacio
     public ArtistaVo(){

     }

    public ArtistaVo(int idArtista, int noDocumento, String tipoDocumento, String nombreArtista, String apellidoArtista, String nombreArtistico, int feNacimArtista, String emailArtista, Boolean estadoArtista){
           this.idArtista=idArtista;
           this.noDocumento=noDocumento;
           this.tipoDocumento=tipoDocumento;
           this.nombreArtista=nombreArtista;
           this.apellidoArtista=apellidoArtista;
           this.nombreArtistico=nombreArtistico;
           this.feNacimArtista=feNacimArtista;
           this.emailArtista=emailArtista;
           this.estadoArtista=estadoArtista;
    }

    //Metodos accesores
    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public int getNoDocumento() {
        return noDocumento;
    }

    public void setNoDocumento(int noDocumento) {
        this.noDocumento = noDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getApellidoArtista() {
        return apellidoArtista;
    }

    public void setApellidoArtista(String apellidoArtista) {
        this.apellidoArtista = apellidoArtista;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }
    
    public int getFeNacimArtista() {
        return feNacimArtista;
    }

    public void setFeNacimArtista(int feNacimArtista) {
        this.feNacimArtista = feNacimArtista;
    }

    public String getEmailArtista() {
        return emailArtista;
    }

    public void setEmailArtista(String emailArtista) {
        this.emailArtista = emailArtista;
    }

    public Boolean isEstadoArtista() {
        return estadoArtista;
    }

    public void setEstadoArtista(Boolean estadoArtista) {
        this.estadoArtista = estadoArtista;
    }
}
