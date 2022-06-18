package model;

public class CancionVo {

    //Atributos Canción
    private int idCancion;
    private String nombreCancion;
    private int fechaGrabacion;
    private int duracionCancion;
    private Boolean estadoCancion;

    //Método constructor
    public CancionVo(){
       
    }
    // metodo constructor con parametros

    public CancionVo(int idCancion, String nombreCancion, int fechaGrabacion, int duracionCancion, Boolean estadoCancion ){
        this.idCancion=idCancion;
        this.nombreCancion=nombreCancion;
        this.fechaGrabacion=fechaGrabacion;
        this.duracionCancion=duracionCancion;
        this.estadoCancion=estadoCancion;
    }

    //getters y setter canción
    public int getidCancion(){
        return this.idCancion;
    }

    public void setidCancion(int idCancion){
        this.idCancion = idCancion;
    }

    public String getnombreCancion(){
        return this.nombreCancion;
    }

    public void setnombreCancion(String nombreCancion){
        this.nombreCancion = nombreCancion;
    }

    public int getfechaGrabacion(){
        return this.fechaGrabacion;
    }

    public void setfechaGrabacion(int fechaGrabacion){
        this.fechaGrabacion = fechaGrabacion;
    }

    public int getduracionCancion(){
        return this.duracionCancion;
    }

    public void setduracionCancion(int duracionCancion){
        this.duracionCancion = duracionCancion;
    }

    public Boolean isestadoCancion() {
        return estadoCancion;
    }

    public void setestadoCancion(Boolean estadoCancion) {
        this.estadoCancion = estadoCancion;
    }

  
}
