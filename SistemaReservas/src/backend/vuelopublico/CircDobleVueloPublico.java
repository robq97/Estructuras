/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.vuelopublico;

import javax.swing.JOptionPane;

/**
 *
 * @author robq9
 */
public class CircDobleVueloPublico {

    private NodoVueloPublico cabeza, ultimo;

    public void insertar(VueloPublico v) {
        if (cabeza == null) {
            cabeza = new NodoVueloPublico(v);
            ultimo = cabeza;
        } else {
            if (conseguirHora(v.getFechaSalida()) <= conseguirHora(cabeza.getDato().getFechaSalida())) {
                cabeza.setBack(new NodoVueloPublico(v)); //no se crea auxiliar por que se tiene puntero que indica que esta antes de cabeza
                cabeza.getBack().setNext(cabeza);
                cabeza = cabeza.getBack();
            } else {
                if (conseguirHora(v.getFechaSalida()) >= conseguirHora(ultimo.getDato().getFechaSalida())) {
                    ultimo.setNext(new NodoVueloPublico(v));
                    ultimo.getNext().setBack(ultimo);
                    ultimo = ultimo.getNext();
                } else {
                    NodoVueloPublico aux = cabeza;
                    while (conseguirHora(v.getFechaSalida()) > conseguirHora(aux.getNext().getDato().getFechaSalida())) {
                        aux = aux.getNext();
                    }
                    NodoVueloPublico temp = new NodoVueloPublico(v);
                    temp.setNext(aux.getNext());
                    temp.setBack(aux);
                    aux.setNext(temp);
                    temp.getNext().setBack(temp);
                }
            }
        }
        ultimo.setNext(cabeza); //se crea puntero para senalar hacia el siguiente
        cabeza.setBack(ultimo); //se crea puntero para senalar el de atras
    }

    public String toString() {
        NodoVueloPublico aux = cabeza;
        String msj = "Lista: \n";
        if (aux != null) {
            msj += aux;
            aux = aux.getNext();
            while (aux != cabeza) {
                msj += aux;
                aux = aux.getNext();
            }
        }
        return msj;
    }

    public void elimina(String id) {
        NodoVueloPublico aux = cabeza;                                          //Se crea una copia del nodo cabeza.
        NodoVueloPublico temp = aux;                                            //Se crea una copia del nodo aux (cabeza).

        while (true) {                                                          //Ciclo que con la ayuda de aux = aux.getNext(), nos permite recorrer todos los datos de la lista. 
            if (aux.getDato().getIdVuelo().equals(id)) {                        //Se busca en el dato auxiliar actual el nombre para compararlo con el ingresado por parametro. 
                temp.setNext(aux.getNext());                                    //Se brinca el dato con el match de aux y se le asigna como dato siguiente al nodo temp.
                System.out.println(toString());                                 //Imprime la lista para ver los cambios.
                String msj = aux.getDato().toString();                          //Se guarda la serie que tuvo un match con el parametro ingresado en el metodo.
                JOptionPane.showMessageDialog(null, "El vuelo elimando fue: \n " + msj);
            }
            temp = aux;                                                         //Se guarda temporalmente el dato actual de aux antes de pasar al siguiente de aux.
            aux = aux.getNext();                                                //Nos permite pasar al siguiente dato de la lista.
            if (aux == cabeza) {                                                //Si el auxiliar equivale a cabeza, el ciclo se termina.
                break;
            }
        }
    }

    private int conseguirHora(int fecha) {
        int hora = (fecha % 10000);
        return hora;
    }

    public boolean isLleno(int idVuelo) {
        NodoVueloPublico aux = cabeza;
        boolean status = false;
        while (true) {
            if (aux.getDato().getIdVuelo().equals(idVuelo)) {
                if (aux.getDato().getPaxPriClase() <= 5 && aux.getDato().getPaxEcon() <= 5) {
                    status = true;
                }
            }
            aux = aux.getNext();                                                //Nos permite pasar al siguiente dato de la lista.
            if (aux == cabeza) {                                                //Si el auxiliar equivale a cabeza, el ciclo se termina.
                break;
            }
        }
        return status;
    }

    public double reservaExistentes(String categoria, int espacios, String idVuelo) { //Unicamente para clientes ya existentes.
        NodoVueloPublico aux = cabeza;
        double total = 0;
        while (true) {
            if (aux.getDato().getIdVuelo().equals(idVuelo)) {
                if (categoria.equals("primera")) {
                    if (aux.getDato().getPaxPriClase() >= espacios) {
                        total = aux.getDato().getCostoPaxPriClase() * espacios;
                        int cantActual = aux.getDato().getPaxPriClase() - espacios;
                        aux.getDato().setPaxPriClase(cantActual);
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay espacios suficientes.");
                    }
                } else if (categoria.equals("economica")) {
                    if (aux.getDato().getPaxEcon() >= espacios) {
                        int cantActual = aux.getDato().getPaxEcon() - espacios;
                        aux.getDato().setPaxEcon(cantActual);
                        total = aux.getDato().getCostoPaxEcon() * espacios;
                    }
                }
            }
            aux = aux.getNext();                                                //Nos permite pasar al siguiente dato de la lista.
            if (aux == cabeza) {                                                //Si el auxiliar equivale a cabeza, el ciclo se termina.
                break;
            }
        }
        return total;
    }
}
