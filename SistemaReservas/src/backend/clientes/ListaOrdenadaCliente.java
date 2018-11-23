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
public class ListaOrdenadaCliente {

    private NodoCliente cabeza;

    public void insertar(Cliente c) {                                           //Metodo para agregar estudiantes
        if (cabeza == null) {                                                   //En caso de que la cabeza sea nula, el dato sera el primero de la lista.
            cabeza = new NodoCliente(c);
        } else {
            if (c.getCedula() <= cabeza.getDato().getCedula()) {                        //Con ayuda de la condicion "if" y "else" de abajo, se orden los datos por califcacion,
                NodoCliente aux = new NodoCliente(c);                           //de menor a mayor.
                aux.setNext(cabeza);
                cabeza = aux;
            } else {
                if (cabeza.getNext() == null) {
                    cabeza.setNext(new NodoCliente(c));
                } else {
                    NodoCliente aux = cabeza;
                    while (aux.getNext() != null && c.getCedula() > aux.getNext().getDato().getCedula()) {
                        aux = aux.getNext();
                    }
                    NodoCliente temp = new NodoCliente(c);
                    temp.setNext(aux.getNext());
                    aux.setNext(temp);
                }
            }
        }
    }

    @Override
    public String toString() {                                                  //Metodo para poder imprimir cada dato del alumno.
        String s = "";                                                          //Comienza con un string vacio, y se le va a agregando cada alumno por medio de un ciclo.
        NodoCliente aux = cabeza;
        while (aux != null) {
            s += aux + "\n";
            aux = aux.getNext();
        }
        return s;
    }

    public void eliminarCliente(int cedula) {
        NodoCliente aux = cabeza;                                               //Se crea una copia del nodo frente, para no alterar el original.
        NodoCliente temp = aux;                                                 //Se crea una copia del nodo aux (frente), nos ayudara a eliminar el dato que necesitemos.
        while (aux != null) {                                                   //Ciclo que con la ayuda de aux = aux.getAtras(), nos permite recorrer todos los datos de la estructura. 
            if (aux.getDato().getCedula() == cedula) {                                  //Se busca en el dato auxiliar actual el destino para compararlo con el ingresado por parametro. 
                temp.setNext(aux.getNext());                                    //Se brinca el dato con el match de aux y se le asigna como dato siguiente al nodo temp.
            }
            temp = aux;                                                         //Se guarda temporalmente el dato actual de aux antes de pasar al siguiente de aux.
            aux = aux.getNext();
        }
    }
}
