/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.clientes;

/**
 *
 * @author robq9
 */
public class NodoCliente {    //Respesctivos nodos para la correcta funcion de la estructura.

    private Cliente dato;
    private NodoCliente next;

    public NodoCliente(Cliente dato) {
        this.dato = dato;
    }

    public Cliente getDato() {
        return dato;
    }

    public void setDato(Cliente dato) {
        this.dato = dato;
    }

    public NodoCliente getNext() {
        return next;
    }

    public void setNext(NodoCliente next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "" + dato;
    }
}
