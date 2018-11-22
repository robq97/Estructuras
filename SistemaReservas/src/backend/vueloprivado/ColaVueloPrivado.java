/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.vueloprivado;

import backend.vueloprivado.VueloPrivado;
import backend.vueloprivado.NodoVueloPrivado;

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
            if (id.contains(aux.getDato().getIdVuelo())) {                 //Se busca en el dato auxiliar actual el destino para compararlo con el ingresado por parametro. 
                temp.setAtras(aux.getAtras());                                  //Se brinca el dato con el match de aux y se le asigna como dato siguiente al nodo temp.
            }
            temp = aux;                                                         //Se guarda temporalmente el dato actual de aux antes de pasar al siguiente de aux.
            aux = aux.getAtras();
        }
    }
}
