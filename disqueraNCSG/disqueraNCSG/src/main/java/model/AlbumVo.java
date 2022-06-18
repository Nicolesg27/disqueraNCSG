package model;

public class AlbumVo {

    //Atributos Álbum
    private int idAlbum;
    private String nombreAlbum;
    private int anioPublicacion;
    private boolean estadoAlbum;
    
    //Metodo constructor vacio
    public AlbumVo() {
    }

    //Método constructor 
    public AlbumVo(int idAlbum, String nombreAlbum, int anioPublicacion, boolean estadoAlbum){

        //Método constructor álbum
        this.idAlbum = idAlbum;
        this.nombreAlbum = nombreAlbum;
        this.anioPublicacion = anioPublicacion;
        this.estadoAlbum = estadoAlbum;
    }

    //getters y setter álbum
    public int getidAlbum(){
        return this.idAlbum;
    }

    public void setidAlbum(int idAlbum){
        this.idAlbum = idAlbum;
    }

    public int getanioPublicacion(){
        return this.anioPublicacion;
    }

    public void setanioPublicacion(int anioPublicacion){
        this.anioPublicacion = anioPublicacion;
    }

    public String getnombreAlbum(){
        return this.nombreAlbum;
    }

    public void setnombreAlbum(String nombreAlbum){
        this.nombreAlbum = nombreAlbum;
    }

    public boolean isestadoAlbum(){
        return this.estadoAlbum;
    }

    public void setestadoAlbum(boolean estadoAlbum){
        this.estadoAlbum = estadoAlbum;
    }
}
