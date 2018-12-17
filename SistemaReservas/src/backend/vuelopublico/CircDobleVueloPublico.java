/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package backend.vuelopublico;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author robq9
 */
public class CircDobleVueloPublico {
    
    private NodoVueloPublico cabeza, ultimo;
    
    public void insertar(VueloPublico v) {         //Metodo para insertar datos a la lista.
        if (cabeza == null) {                      //En caso de que la cabeza sea nula, el dato ingresado va a ser la nueva cabeza y ultimo dato.
            cabeza = new NodoVueloPublico(v);
            ultimo = cabeza;
        } else {                                   //Los datos son ordenados por hora
            if (conseguirHora(v.getFechaSalida()) <= conseguirHora(cabeza.getDato().getFechaSalida())) {
                cabeza.setBack(new NodoVueloPublico(v));                        //no se crea auxiliar por que se tiene puntero que indica que esta antes de cabeza
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
    
    @Override
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
        System.out.println(msj);
        return msj;
    }
    
    public void elimina(String id) {
        NodoVueloPublico aux = cabeza;
        NodoVueloPublico temp = aux;
        
        while (aux != null) { // condiciones para recorrer la lista
            if (aux.getDato().getIdVuelo().equals(id)) { // condicion de busqueda
                if (aux == cabeza) {
                    cabeza = cabeza.getNext(); // si el valor de busqueda esta en el primer nodo se reasigna el valor de ese nodo por el nodo siguiente
                } else {
                    temp.setNext(aux.getNext()); // si el valor del nodo aux corresponde el que se busca y no es el primero del nodo lo que hace es saltarse el nodo usando el auxiliar
                }
                JOptionPane.showMessageDialog(null, "El vuelo " + aux.getDato().getIdVuelo() + " ha sido eliminado exitosamente.");; // mensaje para yo saber que el ciclo estaba en uso
            }
            temp = aux; // se guarda un valor de referencia del nodo anterior
            aux = aux.getNext(); // se asigna valor a aux para continuar el ciclo
            if (aux == cabeza) {
                break;
            }
        }
    }
    
    private int conseguirHora(int fecha) {
        int hora = (fecha % 10000);
        return hora;
    }
    
    public boolean isLleno(String idVuelo) {
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
    
    public double reservaVueloPublico(String categoria, int espacios, String idVuelo, boolean tipo) { //el booblean para clientes no existentes tiene que ser TRUE.
        NodoVueloPublico aux = cabeza;
        double total = 0;
        while (true) {
            if (aux.getDato().getIdVuelo().equals(idVuelo)) {
                if (categoria.equals("primera")) {
                    if (aux.getDato().getPaxPriClase() >= espacios) {
                        total = aux.getDato().getCostoPaxPriClase() * espacios;
                        if (tipo == true) {
                            int decision = JOptionPane.showConfirmDialog(null,
                                    "El total para el vuelo " + idVuelo + ", con " + espacios + " espacios de " + categoria + " clase es de: " + total + "\n¿Desea realizar la reserva?", "Reservacion", JOptionPane.YES_NO_OPTION);
                            if (decision == JOptionPane.YES_OPTION) {
                                JOptionPane.showMessageDialog(null, "Reserva realizada.");
                                int cantActual = aux.getDato().getPaxPriClase() - espacios;
                                aux.getDato().setPaxPriClase(cantActual);
                                return total;
                            } else {
                                JOptionPane.showMessageDialog(null, "Reserva cancelada.");
                                total = 0;
                                return total;
                            }
                        } else {
                            int cantActual = aux.getDato().getPaxPriClase() - espacios;
                            aux.getDato().setPaxPriClase(cantActual);
                            return total;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay espacios suficientes.");
                        break;
                    }
                } else if (categoria.equals("economica")) {
                    if (aux.getDato().getPaxEcon() >= espacios) {
                        total = aux.getDato().getCostoPaxEcon() * espacios;
                        if (tipo == true) {
                            int decision = JOptionPane.showConfirmDialog(null,
                                    "El total para el vuelo " + idVuelo + ", con " + espacios + " espacios de " + categoria + " clase es de: " + total + "\nDesea realizar la reserva?", "Reservacion", JOptionPane.YES_NO_OPTION);
                            if (decision == JOptionPane.YES_OPTION) {
                                JOptionPane.showMessageDialog(null, "Reserva realizada.");
                                int cantActual = aux.getDato().getPaxEcon() - espacios;
                                aux.getDato().setPaxEcon(cantActual);
                                return total;
                            } else {
                                JOptionPane.showMessageDialog(null, "Reserva cancelada.");
                                total = 0;
                                return total;
                            }
                        } else {
                            int cantActual = aux.getDato().getPaxEcon() - espacios;
                            aux.getDato().setPaxEcon(cantActual);
                            return total;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay espacios suficientes.");
                        break;
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
    
    public void modificarPrecioPrimera(String id, double costo) {
        NodoVueloPublico aux = cabeza;
        while (aux != null) {
            if (aux.getDato().getIdVuelo().equals(id)) {
                aux.getDato().setCostoPaxPriClase(costo);
                JOptionPane.showMessageDialog(null, "Éxito al modificar el precio.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
            aux = aux.getNext();
            if (aux == cabeza) {                                                //Si el auxiliar equivale a cabeza, el ciclo se termina.
                break;
            }
        }
    }
    
    public void modificarPrecioEconomica(String id, double costo) {
        NodoVueloPublico aux = cabeza;
        while (aux != null) {
            if (aux.getDato().getIdVuelo().equals(id)) {
                aux.getDato().setCostoPaxEcon(costo);
                JOptionPane.showMessageDialog(null, "Éxito al modificar el precio.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
            aux = aux.getNext();
            if (aux == cabeza) {                                                //Si el auxiliar equivale a cabeza, el ciclo se termina.
                break;
            }
        }
    }
    
    public boolean verificarDuplicados(String id) {
        NodoVueloPublico aux = cabeza;
        boolean existe = false;
        while (aux != null) {
            if (aux.getDato().getIdVuelo().equals(id)) {
                existe = true;
            }
            aux = aux.getNext();
            if (aux == cabeza) {                                                //Si el auxiliar equivale a cabeza, el ciclo se termina.
                break;
            }
        }
        return existe;
    }
    
    public DefaultTableModel modeloPub() throws ParseException {
        DefaultTableModel modelo = new DefaultTableModel();
        NodoVueloPublico aux = cabeza;
        modelo.setColumnIdentifiers(new Object[]{"Id de Vuelo", "Origen", "Destino", "Fecha de Salida", "Fecha de Llegada", "Costo Economico", "Costo Primera Clase"});
        if (aux != null) {
            SimpleDateFormat origFormat = new SimpleDateFormat("yyMMddHHmm");
            SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            
            int fechaSalidaOrig = aux.getDato().getFechaSalida();
            Date dateSalida = origFormat.parse(Integer.toString(fechaSalidaOrig));
            String fechaSalidaNueva = newFormat.format(dateSalida);
            
            int fechaLlegadaOrig = aux.getDato().getFechaEntrada();
            Date dateLlegada = origFormat.parse(Integer.toString(fechaLlegadaOrig));
            String fechaLlegadaNueva = newFormat.format(dateLlegada);
            
            modelo.addRow(new Object[]{aux.getDato().getIdVuelo(), aux.getDato().getOrigen(), aux.getDato().getDestino(), fechaSalidaNueva, fechaLlegadaNueva,
                aux.getDato().getCostoPaxEcon(), aux.getDato().getCostoPaxPriClase()});
            aux = aux.getNext();
            while (aux != cabeza) {
                fechaSalidaOrig = aux.getDato().getFechaSalida();
                dateSalida = origFormat.parse(Integer.toString(fechaSalidaOrig));
                fechaSalidaNueva = newFormat.format(dateSalida);
                
                fechaLlegadaOrig = aux.getDato().getFechaEntrada();
                dateLlegada = origFormat.parse(Integer.toString(fechaLlegadaOrig));
                fechaLlegadaNueva = newFormat.format(dateLlegada);
                
                modelo.addRow(new Object[]{aux.getDato().getIdVuelo(), aux.getDato().getOrigen(), aux.getDato().getDestino(), fechaSalidaNueva, fechaLlegadaNueva,
                    aux.getDato().getCostoPaxEcon(), aux.getDato().getCostoPaxPriClase()});
                aux = aux.getNext();
            }
        }
        return modelo;
    }
}
