package modelo.vo;

public class Requerimiento_1Vo {
    //Para recorrer se usa el wrapper no el primitivo
    //Si en SQLite es un real se usa acá un tipo double
    private String ciudadResidencia;
    private Double promedio;


    //Getter and Setter
    public String getCiudadResidencia() {
        return ciudadResidencia;
    }
    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }
    public Double getPromedio() {
        return promedio;
    }
    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }
    
}
