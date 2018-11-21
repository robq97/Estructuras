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
public class VueloPublico {

    private String origen, destino, modeloAvion, idVuelo, privacidad;
    private int mesSalida, diaSalida, mesEntrada, diaEntrada, paxPriClase, paxEcon;
    private double costoPaxPriClase, costoPaxEcon;

    public VueloPublico(String origen, String destino, String modeloAvion, String idVuelo, 
            String privacidad, int mesSalida, int diaSalida, int mesEntrada, int diaEntrada, 
            int paxPriClase, int paxEcon, double costoPaxPriClase, double costoPaxEcon) {
        this.origen = origen;
        this.destino = destino;
        this.modeloAvion = modeloAvion;
        this.idVuelo = idVuelo;
        this.privacidad = privacidad;
        this.mesSalida = mesSalida;
        this.diaSalida = diaSalida;
        this.mesEntrada = mesEntrada;
        this.diaEntrada = diaEntrada;
        this.paxPriClase = paxPriClase;
        this.paxEcon = paxEcon;
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

    public int getMesSalida() {
        return mesSalida;
    }

    public void setMesSalida(int mesSalida) {
        this.mesSalida = mesSalida;
    }

    public int getDiaSalida() {
        return diaSalida;
    }

    public void setDiaSalida(int diaSalida) {
        this.diaSalida = diaSalida;
    }

    public int getMesEntrada() {
        return mesEntrada;
    }

    public void setMesEntrada(int mesEntrada) {
        this.mesEntrada = mesEntrada;
    }

    public int getDiaEntrada() {
        return diaEntrada;
    }

    public void setDiaEntrada(int diaEntrada) {
        this.diaEntrada = diaEntrada;
    }

    public int getPaxPriClase() {
        return paxPriClase;
    }

    public void setPaxPriClase(int paxPriClase) {
        this.paxPriClase = paxPriClase;
    }

    public int getPaxEcon() {
        return paxEcon;
    }

    public void setPaxEcon(int paxEcon) {
        this.paxEcon = paxEcon;
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

    public String getPrivacidad() {
        return privacidad;
    }

    public void setPrivacidad(String privacidad) {
        this.privacidad = privacidad;
    }

    @Override
    public String toString() {
        return "Origen: " + origen + ", Destino: " + destino + ", Modelo del Avion: " + modeloAvion
                + ", ID del Vuelo: " + idVuelo + ", Mes de Salida: " + mesSalida + ", Dia de Salida: "
                + diaSalida + ", Mes de Entrada: " + mesEntrada + ", Dia de Entrada: " + diaEntrada
                + ", Campos Primera Clase: " + paxPriClase + ", Campos Economicos: " + paxEcon
                + ", Precio Primera Clase: " + costoPaxPriClase + ", Precio Clase Economica: " + costoPaxEcon;
    }
}
