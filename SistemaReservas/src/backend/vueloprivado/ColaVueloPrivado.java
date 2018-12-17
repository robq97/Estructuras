/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package backend.vueloprivado;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author robq9
 */
public class ColaVueloPrivado {
    
    private NodoVueloPrivado frente, ultimo;
    
    public void encola(VueloPrivado v) {
        
        if (frente == null) {                 //En caso de que el nodo Frente sea nulo, se le asigna el Vuelo Privado a Frente y Ultimo.
            frente = new NodoVueloPrivado(v);
            ultimo = frente;
            
        } else {                              //En caso de que frente no sea nulo, se le asigna al nodo trasero.
            NodoVueloPrivado aux = new NodoVueloPrivado(v);
            ultimo.setAtras(aux);
            ultimo = aux;
        }
    }
    
    public NodoVueloPrivado atiende() {
        NodoVueloPrivado aux = frente;
        if (aux != null) {                //Atiende al primer nodo que se agrego a la estructura y conforme se va atendiendo, se van eliminando los datos.
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
        String s = "";                   //Se comienza con un String vacio, se recorre toda la cola por medio de un ciclo, y se van agregando
        NodoVueloPrivado aux = frente;   //todos los datos como strings a la variable "s".
        while (aux != null) {
            s += aux + "\n";
            aux = aux.getAtras();
        }
        return s;
    }
    
    public void eliminarVuelo(String id) {
        
        NodoVueloPrivado aux = frente;
        NodoVueloPrivado temp = aux;
        
        while (aux != null) {                                           // Ciclo para pasar por cada dato
            if (aux.getDato().getIdVuelo().equals(id)) {                // si un dato hace match al parametro ingresado
                if (aux == frente) {
                    frente = frente.getAtras();                         //En caso de que haya un match, y el nodo con el match sea el de frente, el frente se convierte en el dato trasero, para asi ser eliminado.
                } else {
                    temp.setAtras(aux.getAtras());                      //En caso que el nodo con el match no sea Frente, se usa la variable temp, para obtener el siguiente dato, eliminando el actual.
                }
                JOptionPane.showMessageDialog(null, "El vuelo " + aux.getDato().getIdVuelo() + " ha sido eliminado exitosamente.");
            }
            temp = aux;                                                 //Finalmente se iguala el nodo aux al temp, para que la eliminacion se de (en caso de que hubiera match).
            aux = aux.getAtras();                                       //Se utiliza para poder recorrer con ayuda del while, toda la estructura.
        }
    }
    
    public void cambiarPrecio(String id, double nuevoPrecio) {                  //Metodo para el cambio de precio.
        NodoVueloPrivado aux = frente;                                          //Creacion de una copia del nodo frente.
        while (aux != null) {
            if (id.equals(aux.getDato().getIdVuelo())) {
                aux.getDato().setCosto(nuevoPrecio);
            }
            aux = aux.getAtras();                                               //Con ayuda del ciclo while se revisan todos los datos buscando matches.
        }
    }
    
    public double calcTotal(int fechaSalida, int fechaLlegada) {                //Metodo para calcular el costo total de un vuelo privado, utilizando las fechas de salida y llegada.
        double precioPorDia = 2720;
        double total = 0;
        
        int mesSalida = conseguirMes(fechaSalida);                              //Se llaman a los metodos para conseguir mes y dia de salida/entrada, y se guardan en una variable.
        int mesLlegada = conseguirMes(fechaLlegada);
        int diaSalida = conseguirDia(fechaSalida);
        int diaLlegada = conseguirDia(fechaLlegada);
        
        if (mesSalida == mesLlegada) {
            if (diaSalida == diaLlegada) {                                      //En caso de que la fecha de salida y llegada sean la misma, se cobra por un dia (2720),
                total = precioPorDia;                                           //de lo contraria se resta el dia de llegada con el de salida, y se multiplica por el precio por dia, para obtener el total.
            } else {
                total = (diaLlegada - diaSalida) * precioPorDia;
            }
        } else if (mesSalida < mesLlegada) {                                    //Codigo para tomar en cuenta si se sale en un mes, y se llega en otro.
            total = ((30 - diaSalida) + diaLlegada) * precioPorDia;
        }
        return total;
    }
    
    private int conseguirMes(int fecha) {                                       //Metodo para conseguir el mes.
        int mes = (fecha % 100000000);                                          //Se obtiene por medio de remanente y division.
        mes = (mes / 1000000);
        return mes;
    }
    
    private int conseguirDia(int fecha) {                                       //Metodo para conseguir el dia.
        int dia = (fecha % 1000000);                                            //Se obtiene por medio de remanente y division.
        dia = (dia / 10000);
        return dia;
    }
    
    public boolean verificarDuplicados(String id) {                             //Busca duplicados.
        NodoVueloPrivado aux = frente;
        boolean existe = false;
        while (aux != null) {                                                   //Antes de agregar un vuelo privado, se busca el ID que se quiere utilizar en la estructura,
            if (aux.getDato().getIdVuelo().equals(id)) {                        //para ver si existe o no.
                existe = true;
            }
            aux = aux.getAtras();                                               //Con ayuda del while se revisan todos los datos por matches.
        }
        return existe;
    }
    
    public DefaultTableModel modeloPriv() throws ParseException {               //Creacion de tabla de modelo, para la ser usada por la UI.
        DefaultTableModel modelo = new DefaultTableModel();
        NodoVueloPrivado aux = frente;
        modelo.setColumnIdentifiers(new Object[]{"Id de Vuelo", "Origen", "Destino", "Fecha Salida", "Fecha Llegada"}); //Creacion del modelo con los parametros que van a ser mostrados.
        while (aux != null) {
            SimpleDateFormat origFormat = new SimpleDateFormat("yyMMddHHmm");      //Se le da el formate de las fechas, y como queremos que se vean.
            SimpleDateFormat newFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            
            
            int fechaSalidaOrig = aux.getDato().getFechaSalida();
            Date dateSalida = origFormat.parse(Integer.toString(fechaSalidaOrig)); //Se pasa el int que contiene año, mes, dia y hora (todo pegado), a una fecha legible por el usuario.
            String fechaSalidaNueva = newFormat.format(dateSalida);
            
            int fechaLlegadaOrig = aux.getDato().getFechaLlegada();
            Date dateLlegada = origFormat.parse(Integer.toString(fechaLlegadaOrig)); //Se pasa el int que contiene año, mes, dia y hora (todo pegado), a una fecha legible por el usuario.
            String fechaLlegadaNueva = newFormat.format(dateLlegada);
            
            
            //origen, destino, modelo, ID vuelo, fechaSalida, fechaEntrada, pax, precioTotal.
            modelo.addRow(new Object[]{aux.getDato().getIdVuelo(), aux.getDato().getOrigen(), aux.getDato().getDestino(), fechaSalidaNueva, fechaLlegadaNueva});
            aux = aux.getAtras(); //Se agrega a la tabla los datos ya convertidos al formato nuevo.
        }
        return modelo;
    }
}
