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
            msj += aux;                                                         //Se comienza con un String vacio, se recorre toda la cola por medio de un ciclo, y se van agregando
            aux = aux.getNext();                                                //todos los datos como strings a la variable "msj".
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
        
        while (aux != null) {                                                   // Ciclo para pasar por cada dato
            if (aux.getDato().getIdVuelo().equals(id)) {                        // si un dato hace match al parametro ingresado
                if (aux == cabeza) {
                    cabeza = cabeza.getNext();                                  //En caso de que haya un match, y el nodo con el match sea el de frente, el frente se convierte en el dato trasero, para asi ser eliminado.
                } else {
                    temp.setNext(aux.getNext());                                //En caso que el nodo con el match no sea Frente, se usa la variable temp, para obtener el siguiente dato, eliminando el actual.
                }
                JOptionPane.showMessageDialog(null, "El vuelo " + aux.getDato().getIdVuelo() + " ha sido eliminado exitosamente.");; // mensaje para yo saber que el ciclo estaba en uso
            }
            temp = aux;                                                         //Finalmente se iguala el nodo aux al temp, para que la eliminacion se de (en caso de que hubiera match).
            aux = aux.getNext();                                                //Se utiliza para poder recorrer con ayuda del while, toda la estructura.
            if (aux == cabeza) {                                                //Condicion para terminar el ciclo.
                break;
            }
        }
    }
    
    private int conseguirHora(int fecha) {                                      //Metodo para extraer la hora del int con toda la fecha.
        int hora = (fecha % 10000);                                             //Se utiliza la operacion de remanente, para obtener los ultimos 4 ints correspodientes a la hora. 
        return hora;
    }
    
    public boolean isLleno(String idVuelo) {                                    //Metodo para saber si un vuelo esta lleno o no.
        NodoVueloPublico aux = cabeza;
        boolean status = false;
        while (true) {
            if (aux.getDato().getIdVuelo().equals(idVuelo)) {                   //En caso de que el vuelo le queden 5 o menos espacios en cada clase, se considera lleno.
                if (aux.getDato().getPaxPriClase() <= 5 && aux.getDato().getPaxEcon() <= 5) {
                    status = true;
                }
            }
            aux = aux.getNext();                                                //Nos permite pasar al siguiente dato de la lista.
            if (aux == cabeza) {                                                //Si el auxiliar equivale a cabeza, el ciclo se termina.
                break;
            }
        }
        return status;                                                          //Se devuelve un booleano dependiendo de si esta lleno o no.
    }
    
    public double reservaVueloPublico(String categoria, int espacios, String idVuelo, boolean tipo) { //el booblean para clientes no existentes tiene que ser TRUE.
        NodoVueloPublico aux = cabeza;                                          //Metodo para hacer la reserva en un vuelo.
        double total = 0;
        while (true) {
            if (aux.getDato().getIdVuelo().equals(idVuelo)) {                   //Primero se busca por id el vuelo que se quiere reservar.
                if (categoria.equals("primera")) {                              //Si el cliente escogio primera clase, se busca que existan suficientes espacios.
                    if (aux.getDato().getPaxPriClase() >= espacios) {           
                        total = aux.getDato().getCostoPaxPriClase() * espacios; 
                        if (tipo == true) {
                            int decision = JOptionPane.showConfirmDialog(null,  //Si existieran suficientes espacios, se le muestra al cliente el id del vuelo, numero de espacios, categoria y total.
                                    "El total para el vuelo " + idVuelo + ", con " + espacios + " espacios de " + categoria + " clase es de: " + total + "\n¿Desea realizar la reserva?", "Reservacion", JOptionPane.YES_NO_OPTION);
                            if (decision == JOptionPane.YES_OPTION) {           //Si elige realizar la reserva se actualizan el numero de asientos disponibles del vuelo.
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
                            int cantActual = aux.getDato().getPaxPriClase() - espacios; //Esto es para agregar los clientes ya pre-creados por nosotros, se agregan sin necesidad de confirmar nada.
                            aux.getDato().setPaxPriClase(cantActual);
                            return total;
                        }
                    } else {                                                    //Se muestra en caso de que no existan campos suficientes.
                        JOptionPane.showMessageDialog(null, "No hay espacios suficientes.");
                        break;
                    }
                } else if (categoria.equals("economica")) {                     //Exactamente el mismo funcionamiento de la "Primera Clase", solo que el esto se corre cuando se eliga "clase economica", puesto que los campos y precios disponibles son diferentes.
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
    
    public void modificarPrecioPrimera(String id, double costo) {               //Metodo para que los admins puedan modificar el precio de primera clase.
        NodoVueloPublico aux = cabeza;
        while (aux != null) {
            if (aux.getDato().getIdVuelo().equals(id)) {                        //Se buscan matches al ID ingresado por parametro, y en caso de econtrarse se le asigna el nuevo precio.
                aux.getDato().setCostoPaxPriClase(costo);
                JOptionPane.showMessageDialog(null, "Éxito al modificar el precio.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
            aux = aux.getNext();
            if (aux == cabeza) {                                                //Si el auxiliar equivale a cabeza, el ciclo se termina.
                break;
            }
        }
    }
    
    public void modificarPrecioEconomica(String id, double costo) {             //Metodo para que los admins puedan modificar el precio de la clase economica.
        NodoVueloPublico aux = cabeza;
        while (aux != null) {
            if (aux.getDato().getIdVuelo().equals(id)) {                        //Se buscan matches al ID ingresado por parametro, y en caso de econtrarse se le asigna el nuevo precio.
                aux.getDato().setCostoPaxEcon(costo);
                JOptionPane.showMessageDialog(null, "Éxito al modificar el precio.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
            aux = aux.getNext();
            if (aux == cabeza) {                                                //Si el auxiliar equivale a cabeza, el ciclo se termina.
                break;
            }
        }
    }
    
    public boolean verificarDuplicados(String id) {                             //Metodo para buscar si ya existe un vuelo con el mismo id antes de agregarse.
        NodoVueloPublico aux = cabeza;
        boolean existe = false;
        while (aux != null) {                                                   //Se buscan matches al parametro ingresado por el metodo, en caso de encontrarlo, vuelve el booleano verdadero.
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
    
    public DefaultTableModel modeloPub() throws ParseException {                //Creacion de tabla de modelo, para la ser usada por la UI.
        DefaultTableModel modelo = new DefaultTableModel();
        NodoVueloPublico aux = cabeza;
        modelo.setColumnIdentifiers(new Object[]{"Id de Vuelo", "Origen", "Destino", "Fecha de Salida", "Fecha de Llegada", "Costo Economico", "Costo Primera Clase"}); //Creacion del modelo de las columnas con los parametros que van a ser mostrados.
        if (aux != null) {
            SimpleDateFormat origFormat = new SimpleDateFormat("yyMMddHHmm");   //Se le da el formate de las fechas, y como queremos que se vean.
            SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            
            int fechaSalidaOrig = aux.getDato().getFechaSalida();
            Date dateSalida = origFormat.parse(Integer.toString(fechaSalidaOrig)); //Se pasa el int que contiene año, mes, dia y hora (todo pegado), a una fecha legible por el usuario.
            String fechaSalidaNueva = newFormat.format(dateSalida);
            
            int fechaLlegadaOrig = aux.getDato().getFechaEntrada();
            Date dateLlegada = origFormat.parse(Integer.toString(fechaLlegadaOrig)); //Se pasa el int que contiene año, mes, dia y hora (todo pegado), a una fecha legible por el usuario.
            String fechaLlegadaNueva = newFormat.format(dateLlegada);
            
            modelo.addRow(new Object[]{aux.getDato().getIdVuelo(), aux.getDato().getOrigen(), aux.getDato().getDestino(), fechaSalidaNueva, fechaLlegadaNueva, //Creacion del modelo de las hileras con los datos que van a ser mostrados.
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
                aux = aux.getNext(); //Se agrega a la tabla los datos ya convertidos al formato nuevo.
            }
        }
        return modelo;
    }
}
