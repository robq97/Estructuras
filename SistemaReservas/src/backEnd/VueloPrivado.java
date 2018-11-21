/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd;

/**
 *
 * @author robq9
 */
public class VueloPrivado {

    private String modeloAvion, origen, destino, idVuelo;
    private int mesSalida, mesLlegada, diaSalida, diaEntrada, pax;
    private double costo;

    public VueloPrivado(String modeloAvion, String origen, String destino, String idVuelo, int mesSalida, int mesLlegada, int diaSalida, int diaEntrada, int pax, double costo) {
        this.modeloAvion = modeloAvion;
        this.origen = origen;
        this.destino = destino;
        this.idVuelo = idVuelo;
        this.mesSalida = mesSalida;
        this.mesLlegada = mesLlegada;
        this.diaSalida = diaSalida;
        this.diaEntrada = diaEntrada;
        this.pax = pax;
        this.costo = costo;
    }

    public String getModeloAvion() {
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

    public int getMesSalida() {
        return mesSalida;
    }

    public void setMesSalida(int mesSalida) {
        this.mesSalida = mesSalida;
    }

    public int getMesLlegada() {
        return mesLlegada;
    }

    public void setMesLlegada(int mesLlegada) {
        this.mesLlegada = mesLlegada;
    }

    public int getDiaSalida() {
        return diaSalida;
    }

    public void setDiaSalida(int diaSalida) {
        this.diaSalida = diaSalida;
    }

    public int getDiaEntrada() {
        return diaEntrada;
    }

    public void setDiaEntrada(int diaEntrada) {
        this.diaEntrada = diaEntrada;
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

    public String getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    @Override
    public String toString() {
        return "Modelo de Avion" + modeloAvion + ", Origen: " + origen + ", Destino: "
                + destino + ", Mes de Salida: " + mesSalida + ", Mes de Llegada: "
                + mesLlegada + ", Dia de Salida: " + diaSalida + ", Dia de Entrada: "
                + diaEntrada + ", Cantidad de pasajeros: " + pax + ", Costo: " + costo + ", Vuelo: " + idVuelo;
    }
}
