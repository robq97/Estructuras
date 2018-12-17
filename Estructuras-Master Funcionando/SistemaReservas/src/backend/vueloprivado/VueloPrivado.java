/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package backend.vueloprivado;

/**
 *
 * @author robq9
 */
public class VueloPrivado {
    
    private String modeloAvion, origen, destino, idVuelo;                       //Variables de cada vuelo privado.
    private int fechaSalida, fechaLlegada, pax;
    private double costo;
    //Constructor para cada vuelo privado.
    public VueloPrivado(String origen, String destino, String modeloAvion, String idVuelo, int fechaSalida, int fechaLlegada, int pax, double costo) {
        this.modeloAvion = modeloAvion;
        this.origen = origen;
        this.destino = destino;
        this.idVuelo = idVuelo;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.pax = pax;
        this.costo = costo;
    }
    
    public String getModeloAvion() {                                            //Respectivos setters, getters, y toString.
        return modeloAvion;
    }
    
    public void setModeloAvion(String modeloAvion) {
        this.modeloAvion = modeloAvion;
    }
    
    public String getOrigen() {
        return origen;
    }
    
    public void setOrigen(String origen) {
        this.origen = origen;
    }
    
    public String getDestino() {
        return destino;
    }
    
    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    public String getIdVuelo() {
        return idVuelo;
    }
    
    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }
    
    public int getFechaSalida() {
        return fechaSalida;
    }
    
    public void setFechaSalida(int fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
    public int getFechaLlegada() {
        return fechaLlegada;
    }
    
    public void setFechaLlegada(int fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }
    
    public int getPax() {
        return pax;
    }
    
    public void setPax(int pax) {
        this.pax = pax;
    }
    
    public double getCosto() {
        return costo;
    }
    
    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    @Override
    public String toString() {
        return "Vuelo: " + idVuelo + ", Modelo de Avion: " + modeloAvion + ", Origen: " + origen + ", Destino: "
                + destino + ", Fecha de Salida: " + fechaSalida + ", Fecha de Llegada: "
                + fechaLlegada + ", Cantidad de pasajeros: " + pax + ", Costo: " + costo;
    }
}
