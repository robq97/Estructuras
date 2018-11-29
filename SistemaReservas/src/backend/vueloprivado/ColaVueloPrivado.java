/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.vueloprivado;

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
        NodoVueloPrivado aux = frente;                                          //Se crea una copia del nodo frente, para no alterar el original.
        NodoVueloPrivado temp = aux;                                            //Se crea una copia del nodo aux (frente), nos ayudara a eliminar el dato que necesitemos.
        while (aux != null) {                                                   //Ciclo que con la ayuda de aux = aux.getAtras(), nos permite recorrer todos los datos de la estructura. 
            if (id.contains(aux.getDato().getIdVuelo())) {                      //Se busca en el dato auxiliar actual el destino para compararlo con el ingresado por parametro. 
                temp.setAtras(aux.getAtras());                                  //Se brinca el dato con el match de aux y se le asigna como dato siguiente al nodo temp.
            }
            temp = aux;                                                         //Se guarda temporalmente el dato actual de aux antes de pasar al siguiente de aux.
            aux = aux.getAtras();
        }
    }
    
    public void cambiarPrecio (String id, double nuevoPrecio) {
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
    
     public DefaultTableModel modeloPub(){
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
