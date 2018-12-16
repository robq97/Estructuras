/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

import backend.admin.Admin;
import backend.admin.ArbolAdmin;
import backend.clientes.Cliente;
import backend.clientes.ListaOrdenadaCliente;
import backend.vueloprivado.ColaVueloPrivado;
import backend.vueloprivado.VueloPrivado;
import backend.vuelopublico.CircDobleVueloPublico;
import backend.vuelopublico.VueloPublico;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author robq9
 */
public class Handler {                                                          //En este clase estan los metodos relacionados al manejo de datos de todas las diferentes estucturas de datos. 

    public static CircDobleVueloPublico pub = new CircDobleVueloPublico();      //Instancias estaticas para poder manejar las estructuras de datos en diferentes clases.
    public static ColaVueloPrivado priv = new ColaVueloPrivado();
    public static ArbolAdmin admin = new ArbolAdmin();
    public static ListaOrdenadaCliente cliente = new ListaOrdenadaCliente();

    public void addVuelosFijosExistentes() {//Metodo que agrega vuelos pre-hechos a la estructura de datos para que los clientes tengan opciones de vuelos.
        //Las variables son: origen, destino, modelo, id, tipo, estado, fechaSalida, fechaLlegada, paxPrimeraClase, paxEconomico, precioPrimeraClase, precioEconomico.
        Handler.pub.insertar(new VueloPublico("San Jose, Costa Rica", "Miami, USA", "B737-800", "240", "fijo", "disponible", 1810050230, 1810060500, 40, 120, 750, 380));
        Handler.pub.insertar(new VueloPublico("San Jose, Costa Rica", "Los Angeles, USA", "B757-200", "245", "fijo", "disponible", 1810060330, 1810090500, 50, 200, 845, 582));
        Handler.pub.insertar(new VueloPublico("San Jose, Costa Rica", "Nueva York, USA", "A320", "250", "fijo", "disponible", 1810070400, 1810100500, 45, 140, 990, 620));
        Handler.pub.insertar(new VueloPublico("Ciudad de Panama, Panama", "San Jose, Costa Rica", "B767-300", "255", "fijo", "disponible", 1810141230, 1810050030, 80, 250, 1760, 1020));
        Handler.pub.insertar(new VueloPublico("Ciudad de Panama, Panama", "Managua, Nicaragua", "B787", "260", "fijo", "disponible", 1810091430, 1814050645, 60, 180, 2100, 1190));
        Handler.pub.insertar(new VueloPublico("Ciudad de Panama, Panama", "Bogota, Colombia", "B787", "265", "fijo", "disponible", 1810121645, 1817051830, 60, 180, 2100, 1190));
        Handler.pub.insertar(new VueloPublico("Managua, Nicaragua", "San Jose, Costa Rica", "B737-800", "270", "fijo", "disponible", 1810151100, 1810200500, 30, 110, 478, 290));
        Handler.pub.insertar(new VueloPublico("Managua, Nicaragua", "Ciudad de Panama, Panama", "B787", "275", "fijo", "disponible", 1810172315, 1810230500, 60, 180, 566, 310));
        Handler.pub.insertar(new VueloPublico("Managua, Nicaragua", "Bogota, Colombia", "B737-800", "280", "fijo", "disponible", 1810200725, 1810270500, 30, 130, 750, 447));
        Handler.pub.insertar(new VueloPublico("Liberia, Costa Rica", "Ciudad de Panama, Panama", "B737-800", "285", "fijo", "disponible", 1810251440, 1810270500, 40, 130, 515, 260));
        Handler.pub.insertar(new VueloPublico("Liberia, Costa Rica", "Managua, Nicaragua", "B737-800", "290", "fijo", "disponible", 1810271600, 1810300500, 40, 120, 470, 225));
        Handler.pub.insertar(new VueloPublico("Liberia, Costa Rica", "Bogota, Colombia", "B787", "295", "fijo", "disponible", 1810301735, 1811052000, 40, 200, 640, 300));
    }

    public void addVuelosSolicitudesExistentes() {//Metodo que agrega solicitudes a la estructura de datos, de nuevo, para que los clientes tengan opciones. (Utiliza los mismos parametros de vuelos fijos).
        Handler.pub.insertar(new VueloPublico("San Jose, Costa Rica", "Ciudad de Panama, Panama", "B737-800", "305", "solicitud", "disponible", 1810032230, 1810052300, 3, 10, 515, 265));
        Handler.pub.insertar(new VueloPublico("San Jose, Costa Rica", "Miami, USA", "A320", "310", "solicitud", "disponible", 1810070100, 1810120100, 0, 7, 770, 400));
        Handler.pub.insertar(new VueloPublico("Liberia, Costa Rica", "Ciudad de Panama, Panama", "B737-800", "315", "solicitud", "disponible", 1811040830, 1811090830, 3, 8, 520, 285));
        Handler.pub.insertar(new VueloPublico("Ciudad de Panama, Panama", "San Jose, Costa Rica", "A320", "320", "solicitud", "disponible", 1811030430, 1811070430, 7, 10, 500, 240));
        Handler.pub.insertar(new VueloPublico("Ciudad de Panama, Panama", "Miami, USA", "B737-800", "325", "solicitud", "disponible", 1812061900, 1812151900, 0, 12, 820, 410));
    }

    public boolean isLleno(String idVuelo) { //Para saber si un vuelo publico, esta lleno o no. Si esta lleno devuelve True.
        return Handler.pub.isLleno(idVuelo);
    }

    public void addNuevoVueloPublico(String origen, String destino, String modeloAvion, String idVuelo, String tipo, String estado,   //Metodo para agregar un nuevo vuelo a la estructura de datos.
            int fechaSalida, int fechaLlegada, int paxPrimeraClase, int paxEconomico, int precioPrimeraClase, int precioEconomico) { 
        Handler.pub.insertar(new VueloPublico(origen, destino, modeloAvion, idVuelo, tipo, estado, fechaSalida, fechaLlegada, paxPrimeraClase, paxEconomico, precioPrimeraClase, precioEconomico));
    }
    
    public void eliminarVueloPublico(String idVuelo) { //Metodo para eliminar un vuelo publico por ID.
        Handler.pub.elimina(idVuelo);
    }

    public void addVuelosPrivadosExistentes() { //origen, destino, modelo, ID vuelo, fechaSalida, fechaEntrada, pax, precioTotal.
        Handler.priv.encola(new VueloPrivado("San Jose, Costa Rica", "Paris, Francia", "G650", "VP120", 1811270530, 1811282200, 3, Handler.priv.calcTotal(1811270530, 1811282200)));
        Handler.priv.encola(new VueloPrivado("San Jose, Costa Rica", " Ginebra, Suiza", "Challenger 300", "VP125", 1811281230, 1812010800, 5, Handler.priv.calcTotal(1811281230, 1812010800)));
        Handler.priv.encola(new VueloPrivado("Ciudad de Panama, Panama", "Dubai, EAU", "Phenom 100EV", "VP130", 1811301820, 1812051700, 2, Handler.priv.calcTotal(1811301820, 1812051700)));
        Handler.priv.encola(new VueloPrivado("San Jose, Costa Rica", "Sao Paulo, Brazil", "Challenger 300", "VP135", 1812020400, 1812072200, 4, Handler.priv.calcTotal(1812020400, 1812072200)));
        Handler.priv.encola(new VueloPrivado("Ciudad de Panama, Panama", "Moscu, Russia", "G650", "VP140", 1812021115, 1812081445, 7, Handler.priv.calcTotal(1812021115, 1812081445)));
    }

    public void addNuevoVueloPrivado(String origen, String destino, String modeloAvion, String idVuelo, int fechaSalida, int fechaEntrada, int pax) { //Metodo para agregar un nuevo vuelo privado (solo los admins pueden hacerlo).
        int respuesta = JOptionPane.showConfirmDialog(null, "El total para este vuelo es de: " + Handler.priv.calcTotal(fechaSalida, fechaEntrada) + "\n¿Desea realizar la reserva?", "Confirmacion", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION){                               //Se le da el total y la opcion de reservar o no el vuelo.
            Handler.priv.encola(new VueloPrivado(origen, destino, modeloAvion, idVuelo, fechaSalida, fechaEntrada, pax, Handler.priv.calcTotal(fechaSalida, fechaEntrada)));
            JOptionPane.showMessageDialog(null, "El vuelo con destino ha sido reservadado satisfactoriamente.");
        }
        else {
            JOptionPane.showMessageDialog(null, "El vuelo no fue reservado.");
        }
    }
    
    public void modicaPrecioVueloPrivado(String idVuelo, double nuevoPrecio) { //Metodo para modificar el precio de un vuelo privado por ID de vuelo.
        Handler.priv.cambiarPrecio(idVuelo, nuevoPrecio);
    }
    
    public void eliminaVueloPrivado(String id) { //Metodo para eliminar un vuelo privado por ID.
        Handler.priv.eliminarVuelo(id);
    }

    public void addClientesExistentes() {  //Se encarga de agregar clientes y crea reservaciones para cada uno. 
                          // Tiene como parametros: nombre, cel, email, clase, # de asientos, cedula, id de vuelo, y el metodo de reserva.              
        Handler.cliente.insertar(new Cliente("Daniela", "8712-6443", "daniela@gmail.com", "primera", 1, "1-1684-0022", "240", Handler.pub.reservaVueloPublico("primera", 1, "240", false)));
        Handler.cliente.insertar(new Cliente("Bryan", "5643-6566", "bryan@ulacit.com", "economica", 10, "1-1344-3443", "245", Handler.pub.reservaVueloPublico("economica", 10, "245", false)));
        Handler.cliente.insertar(new Cliente("Irene", "6654-1128", "irene@yahoo.com", "economica", 8, "1-3328-422", "240", Handler.pub.reservaVueloPublico("economica", 8, "240", false)));
        Handler.cliente.insertar(new Cliente("Andres", "7832-0935", "andres@hotmail.com", "primera", 3, "1-9862-4434", "275", Handler.pub.reservaVueloPublico("primera", 3, "275", false)));
        Handler.cliente.insertar(new Cliente("Marco", "7637-8834", "marco@gmail.com", "economica", 3, "1-1643-5342", "280", Handler.pub.reservaVueloPublico("economica", 3, "280", false)));
        Handler.cliente.insertar(new Cliente("Sofia", "8276-7654", "sofia@outlook.com", "primera", 2, "1-1954-3444", "290", Handler.pub.reservaVueloPublico("primera", 2, "290", false)));
        Handler.cliente.insertar(new Cliente("Alejandro", "5453-3223", "alejandro@destinos.com", "economica", 7, "1-1630-0734", "255", Handler.pub.reservaVueloPublico("economica", 7, "255", false)));
        Handler.cliente.insertar(new Cliente("Gloriana", "2956-5543", "gloriana@hotmail.com", "economica", 4, "1-230-9454", "295", Handler.pub.reservaVueloPublico("economica", 4, "295", false)));
        Handler.cliente.insertar(new Cliente("Brandon", "4523-6575", "brandon@yahoo.com", "economica", 6, "1-1245-4695", "265", Handler.pub.reservaVueloPublico("economica", 6, "265", false)));

    }
    //Agrega nuevos clientes y crea la reservacion solo si el total devuelto por el metodo reservaVueloPublico() es igual o mayor a 1.
    public void addNuevosClientesyReserva(String nombre, String telefono, String email, String categoria, int asientos, String cedula, String idVuelo) {
        if (Handler.pub.reservaVueloPublico(categoria, asientos, idVuelo, true) >= 1) {
            cliente.insertar(new Cliente(nombre, telefono, email, categoria, asientos, cedula, idVuelo, Handler.pub.reservaVueloPublico(categoria, asientos, idVuelo, false)));
        }
    }

    public void addAdminsExistentes() { //Agrega los admins al arbol.
        //Usuario, password, privilegios (0 tiene todos los privilegios, 1 tiene menos privilegios, 2 menos, y asi sucesivamente).
        Handler.admin.inserta(new Admin("Roberto", "1234", 0));
        Handler.admin.inserta(new Admin("Bryan", "1234", 1));
        Handler.admin.inserta(new Admin("Mariana", "1234", -1));
        Handler.admin.inserta(new Admin("Daniel", "1234", 2));
        Handler.admin.inserta(new Admin("Gabriela", "1234", -2));
        Handler.admin.inserta(new Admin("Josue", "1234", 3));
        Handler.admin.inserta(new Admin("Andres", "1234", -3));
    }
    public void agregarAdmin(String nombre, String contrasena, int grado){
        Handler.admin.inserta(new Admin(nombre, contrasena, grado));
    }
    
    public void test() { //metodo para pruebas, puede comentarse
        //System.out.println(cliente);
//        System.out.println(Handler.pub);
//        eliminarVueloPublico("310");
//        System.out.println(Handler.pub);
        //System.out.println(pub);
        //Handler.admin.imprimeTodos();
        //Handler.pub.toString();
    }
    
    public boolean iniciarSesion(String user, String pass){ //Metodo para el inicio de sesion.
        return Handler.admin.iniciarSesion(user, pass);
    }
    
    public int obtenerNivel (String nombre){ //Metodo que por medio del nombre de usuario devuelve el tipo de acceso por medio de un int (0 tiene todos los permisos).
        return Handler.admin.getNivel(nombre);
    }
    
    public void cambiarContrasena(String usuario, String contrAct, String contrNue){ //Metodo para el cambio de contrasena de admins.
        Handler.admin.cambiarContrasena(usuario, contrAct, contrNue);
    }
    
    public void modificarPrecioPrimera(String id, double costo){ //Metodo para modificar el precio de primera clase (en vuelos publicos).
        Handler.pub.modificarPrecioPrimera(id, costo);
    }
    
    public void modificarPrecioEconomica(String id, double costo){ //Metodo para modificar el precio de clase economica (en vuelos publicos).
        Handler.pub.modificarPrecioEconomica(id, costo);
    }
    
    public boolean verificarDuplicadosPub(String id){ //Metodo para verificar si existen vuelos publicos duplicados antes de agregar uno nuevo.
        return Handler.pub.verificarDuplicados(id);
    }
    
    public boolean verificarDuplicadosPriv(String id){ //Metodo para verificar si existen vuelos privados duplicados antes de agregar uno nuevo.
        return Handler.priv.verificarDuplicados(id);
    }
    
    public DefaultTableModel modeloPub() throws ParseException{ //Creacion de los diferentes modelos de tablas para ser visualizados en la UI facilmente.
        DefaultTableModel modelo = Handler.pub.modeloPub();
        return modelo;
    }
    
    public DefaultTableModel modeloPriv() throws ParseException{
        DefaultTableModel modelo = Handler.priv.modeloPriv();
        return modelo;
    }
    
    
}
