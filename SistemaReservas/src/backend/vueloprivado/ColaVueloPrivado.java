/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.vueloprivado;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author robq9
 */
public class ColaVueloPrivado {

    private NodoVueloPrivado frente, ultimo;

    public void encola(VueloPrivado v) {

        if (frente == null) {
            frente = new NodoVueloPrivado(v);
            ultimo = frente;

        } else {
            NodoVueloPrivado aux = new NodoVueloPrivado(v);
            ultimo.setAtras(aux);
            ultimo = aux;
        }
    }

    public NodoVueloPrivado atiende() {
        NodoVueloPrivado aux = frente;
        if (aux != null) {
            frente = frente.getAtras();
            aux.setAtras(null);
            if (aux == ultimo) {
                ultimo = null;
            }
        }
        return aux;
    }

    @Override
    public String toString() {
        String s = "";
        NodoVueloPrivado aux = frente;
        while (aux != null) {
            s += aux + "\n";
            aux = aux.getAtras();
        }
        return s;
    }

    public void eliminarVuelo(String id) {
        
        NodoVueloPrivado aux = frente;
        NodoVueloPrivado temp = aux;

                while (aux != null) { // condiciones para recorrer la lista                   
                    if (aux.getDato().getIdVuelo().equals(id)) { // condicion de busqueda
                        if (aux == frente) {
                            frente = frente.getAtras(); // si el valor de busqueda esta en el primer nodo se reasigna el valor de ese nodo por el nodo siguiente
                        } else {
                            temp.setAtras(aux.getAtras()); // si el valor del nodo aux corresponde el que se busca y no es el primero del nodo lo que hace es saltarse el nodo usando el auxiliar
                        }
                        JOptionPane.showMessageDialog(null, "El vuelo " + aux.getDato().getIdVuelo() + " ha sido eliminado exitosamente."); // mensaje para yo saber que el ciclo estaba en uso
                    }
                    temp = aux; // se guarda un valor de referencia del nodo anterior
                    aux = aux.getAtras(); // se asigna valor a aux para continuar el ciclo
                }
    }

    public void cambiarPrecio(String id, double nuevoPrecio) {
        NodoVueloPrivado aux = frente;
        while (aux != null) {
            if (id.equals(aux.getDato().getIdVuelo())) {
                aux.getDato().setCosto(nuevoPrecio);
            }
            aux = aux.getAtras();
        }
    }

    public double calcTotal(int fechaSalida, int fechaLlegada) {
        double precioPorDia = 2500;
        double total = 0;

        int mesSalida = conseguirMes(fechaSalida);
        int mesLlegada = conseguirMes(fechaLlegada);
        int diaSalida = conseguirDia(fechaSalida);
        int diaLlegada = conseguirDia(fechaLlegada);

        if (mesSalida == mesLlegada) {
            if (diaSalida == diaLlegada) {
                total = precioPorDia;
            } else {
                total = (diaLlegada - diaSalida) * precioPorDia;
            }
        } else if (mesSalida < mesLlegada) {
            total = ((30 - diaSalida) + diaLlegada) * precioPorDia;
        }
        return total;
    }

    private int conseguirMes(int fecha) {
        int mes = (fecha % 100000000);
        mes = (mes / 1000000);
        return mes;
    }

    private int conseguirDia(int fecha) {
        int dia = (fecha % 1000000);
        dia = (dia / 10000);
        return dia;
    }

    public boolean verificarDuplicados(String id) {
        NodoVueloPrivado aux = frente;
        boolean existe = false;
        while (aux != null) {
            if (aux.getDato().getIdVuelo().equals(id)) {
                existe = true;
            }
            aux = aux.getAtras();
        }
        return existe;
    }

    public DefaultTableModel modeloPriv() {
        DefaultTableModel modelo = new DefaultTableModel();
        NodoVueloPrivado aux = frente;
        modelo.setColumnIdentifiers(new Object[]{"Id de Vuelo", "Origen", "Salida"});
        while (aux != null) {
            //origen, destino, modelo, ID vuelo, fechaSalida, fechaEntrada, pax, precioTotal.
            modelo.addRow(new Object[]{aux.getDato().getIdVuelo(), aux.getDato().getOrigen(), aux.getDato().getDestino()});
            aux = aux.getAtras();
        }
        return modelo;
    }
}
