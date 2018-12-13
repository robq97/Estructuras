/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.admin;


/**
 *
 * @author ulacit
 */
public class NodoAdmin {

    private Admin dato;                 //Variables e instancias propias de los nodos de la estructura de arbol.
    private NodoAdmin hijoIzq, hijoDer;

    public NodoAdmin(Admin dato) {
        this.dato = dato;
    }

    public Admin getDato() {
        return dato;
    }

    public void setDato(Admin dato) {
        this.dato = dato;
    }

    public NodoAdmin getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoAdmin hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public NodoAdmin getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(NodoAdmin hijoDer) {
        this.hijoDer = hijoDer;
    }

    @Override
    public String toString() {
        return "" + dato;
    }
}
