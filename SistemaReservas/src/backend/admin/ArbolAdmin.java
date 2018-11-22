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
public class ArbolAdmin {

    private NodoAdmin raiz;
    private String msjHojas = "";
    private String msjNiveles = "";

    public void inserta(Admin a) {                                              //Metodo para insertar ints al arbol.
        if (raiz == null) {                                                     //En caso de que la raiz sea nula, se asigna el valor ingresado como nueva raiz.
            raiz = new NodoAdmin(a);
        } else {
            insertaRec(a, raiz);                                                //De lo contrario se llama al metodo recursivo para que lo posicione en lugar correcto.
        }
    }

    private void insertaRec(Admin a, NodoAdmin n) {                             //Se decide si se posiciona a la izquiera o derecha en caso de que ya exista una raiz.
        if (a.getNivelAcceso() <= n.getDato().getNivelAcceso()) {               //izq.         su posicion dependera del valor (menor o igual a la izquierda, mayor a la derecha)
            if (n.getHijoIzq() == null) {                                       //Tengo campo.
                n.setHijoIzq(new NodoAdmin(a));
            } else {
                insertaRec(a, n.getHijoIzq());                                  //En caso de no tener campo se vuelve a llamar a si mismo para poder encontrarlo.
            }
        } else {                                                                //derecha.
            if (n.getHijoDer() == null) {                                       //Tengo campo.
                n.setHijoDer(new NodoAdmin(a));
            } else {
                insertaRec(a, n.getHijoDer());
            }
        }
    }

    private String imprimeNivelRec(NodoAdmin aux, int n) {                      //Metodo recursivo que almacena los nodos por nivel.
        if (aux != null) {                                                      //Siempre y cuando el nodo ingresado por parametro no sea nulo, se va almacenando en la variable msjNiveles
            if (n == 0) {
                msjNiveles += " " + aux.getDato().toString();
            } else if (n >= 1) {
                imprimeNivelRec(aux.getHijoIzq(), n - 1);                       //Se llama al metodo recursivo y restandole 1 al numero de nivel ingresado para eventualmente llegar al nivel 0 y conseguir sus respectivos datos del nivel.
                imprimeNivelRec(aux.getHijoDer(), n - 1);
            }
        }
        return msjNiveles;
    }

    public void imprimeNivel(int n) {                                           //Imprime el valor encontrado en el metodo recursivo de nodos por nivel.
        System.out.print("Adminstradores del nivel " + n + ":\n" + imprimeNivelRec(raiz, n) + ".\n");
    }
}