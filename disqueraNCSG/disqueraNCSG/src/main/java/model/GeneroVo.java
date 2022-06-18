package model;

public class GeneroVo {

    //Atributos Género
        private int idGenero;
        private String nombreGenero;
        private Boolean estadoGenero;

    //Método constructor
    public GeneroVo(){
    }

    //Metodo Constructor con parametros
    public GeneroVo(int idGenero, String nombreGenero, Boolean estadoGenero){}

    //getters y setter género
    public int getidGenero(){
        return this.idGenero;
    }

    public void setidGenero(int idGenero){
        this.idGenero = idGenero;
    }

    public String getnombreGenero(){
        return this.nombreGenero;
    }

    public void setnombreGenero(String string){
        this.nombreGenero = string;
    }

    public Boolean getestadoGenero() {
        return estadoGenero;
    }

    public void setestadoGenero(Boolean estadoGenero) {
        this.estadoGenero = estadoGenero;
    }
    
}
