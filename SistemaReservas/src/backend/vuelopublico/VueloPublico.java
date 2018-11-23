/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.vuelopublico;

/**
 *
 * @author robq9
 */
public class VueloPublico {

    private String origen, destino, modeloAvion, idVuelo, tipo, estado;
    private int fechaSalida, fechaEntrada, disponiblePriClase, disponibleEcon;
    private double costoPaxPriClase, costoPaxEcon;

    public VueloPublico(String origen, String destino, String modeloAvion, String idVuelo, String tipo, String estado, int fechaSalida, int fechaEntrada, int paxPriClase, int paxEcon, double costoPaxPriClase, double costoPaxEcon) {
        this.origen = origen;
        this.destino = destino;
        this.modeloAvion = modeloAvion;
        this.idVuelo = idVuelo;
        this.tipo = tipo;
        this.estado = estado;
        this.fechaSalida = fechaSalida;
        this.fechaEntrada = fechaEntrada;
        this.disponiblePriClase = paxPriClase;
        this.disponibleEcon = paxEcon;
        this.costoPaxPriClase = costoPaxPriClase;
        this.costoPaxEcon = costoPaxEcon;
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

    public String getModeloAvion() {
        return modeloAvion;
    }

    public void setModeloAvion(String modeloAvion) {
        this.modeloAvion = modeloAvion;
    }

    public String getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(int fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(int fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public int getPaxPriClase() {
        return disponiblePriClase;
    }

    public void setPaxPriClase(int paxPriClase) {
        this.disponiblePriClase = paxPriClase;
    }

    public int getPaxEcon() {
        return disponibleEcon;
    }

    public void setPaxEcon(int paxEcon) {
        this.disponibleEcon = paxEcon;
    }

    public double getCostoPaxPriClase() {
        return costoPaxPriClase;
    }

    public void setCostoPaxPriClase(double costoPaxPriClase) {
        this.costoPaxPriClase = costoPaxPriClase;
    }

    public double getCostoPaxEcon() {
        return costoPaxEcon;
    }

    public void setCostoPaxEcon(double costoPaxEcon) {
        this.costoPaxEcon = costoPaxEcon;
    }

    public String toString() {
        return "Origen: " + origen + ", Destino: " + destino + ", Modelo del Avion: " + modeloAvion
                + ", ID del Vuelo: " + idVuelo + ", Fecha de Salida: " + fechaSalida + ", Fecha de Entrada: "
                + fechaEntrada + ", Disponible Primera Clase: " + disponiblePriClase + ", Disponible Economicos: " + disponibleEcon
                + ", Precio Primera Clase: " + costoPaxPriClase + ", Precio Clase Economica: " + costoPaxEcon + "\n";
    }
}
