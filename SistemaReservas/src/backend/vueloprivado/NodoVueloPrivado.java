/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package backend.vueloprivado;

/**
 *
 * @author robq9
 */
public class NodoVueloPrivado {
    
    private VueloPrivado dato;                   //Nodos para el correcto funcionamiento de la estructura de datos.
    private NodoVueloPrivado atras;
    
    public NodoVueloPrivado(VueloPrivado dato) {
        this.dato = dato;
    }
    
    public VueloPrivado getDato() {
        return dato;
    }
    
    public void setDato(VueloPrivado dato) {
        this.dato = dato;
    }
    
    public NodoVueloPrivado getAtras() {
        return atras;
    }
    
    public void setAtras(NodoVueloPrivado atras) {
        this.atras = atras;
    }
    
    @Override
    public String toString() {
        return "" + dato;
    }
}
