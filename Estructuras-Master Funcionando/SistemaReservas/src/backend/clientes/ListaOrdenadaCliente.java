/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package backend.clientes;

import javax.swing.JOptionPane;

/**
 *
 * @author robq9
 */
public class ListaOrdenadaCliente {
    
    private NodoCliente cabeza;
    
    public void insertar(Cliente c) {                                           //Metodo para agregar clientes
        if (cabeza == null) {                                                   //En caso de que la cabeza sea nula, el dato sera el primero de la lista.
            cabeza = new NodoCliente(c);
        } else {
            if (c.getEspacios() <= cabeza.getDato().getEspacios()) {            //Con ayuda de la condicion "if" y "else" de abajo, se orden los datos por espacios reservados,
                NodoCliente aux = new NodoCliente(c);                           //de menor a mayor.
                aux.setNext(cabeza);
                cabeza = aux;
            } else {
                if (cabeza.getNext() == null) {
                    cabeza.setNext(new NodoCliente(c));
                } else {
                    NodoCliente aux = cabeza;
                    while (aux.getNext() != null && c.getEspacios() > aux.getNext().getDato().getEspacios()) {
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
    public String toString() {                                                  //Metodo para poder imprimir cada dato del cliente.
        String s = "";                                                          //Comienza con un string vacio, y se le va a agregando cada cliente por medio de un ciclo.
        NodoCliente aux = cabeza;
        while (aux != null) {
            s += aux + "\n";
            aux = aux.getNext();
        }
        return s;
    }
    
    public void eliminarCliente(String cedula) {
        NodoCliente aux = cabeza;
        NodoCliente temp = aux;

        while (aux != null) {                                           // Ciclo para pasar por cada dato
            if ((aux.getDato().getCedula().replaceAll("\\D", "").equals(cedula.replaceAll("\\D", "")))) {                // si un dato hace match al parametro ingresado
                if (aux == cabeza) {
                    cabeza = cabeza.getNext();                         //En caso de que haya un match, y el nodo con el match sea el de cabeza, cabeza se convierte en el dato trasero, para asi ser eliminado.
                } else {
                    temp.setNext(aux.getNext());                      //En caso que el nodo con el match no sea cabeza, se usa la variable temp, para obtener el siguiente dato, eliminando el actual.
                }
                JOptionPane.showMessageDialog(null, "El cliente con cedula " + aux.getDato().getCedula() + " ha sido eliminado exitosamente.");
            }
            temp = aux;                                                 //Finalmente se iguala el nodo aux al temp, para que la eliminacion se de (en caso de que hubiera match).
            aux = aux.getNext();                                       //Se utiliza para poder recorrer con ayuda del while, toda la estructura.
        }
    }
}
