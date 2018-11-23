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
public class NodoVueloPublico {

    private NodoVueloPublico next, back;
    private VueloPublico dato;

    public NodoVueloPublico(VueloPublico dato) {
        this.dato = dato;
    }

    public NodoVueloPublico getNext() {
        return next;
    }

    public void setNext(NodoVueloPublico next) {
        this.next = next;
    }

    public NodoVueloPublico getBack() {
        return back;
    }

    public void setBack(NodoVueloPublico back) {
        this.back = back;
    }

    public VueloPublico getDato() {
        return dato;
    }

    public void setDato(VueloPublico dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "" + dato;
    }
}
