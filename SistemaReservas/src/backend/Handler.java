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

/**
 *
 * @author robq9
 */
public class Handler {

    CircDobleVueloPublico pub = new CircDobleVueloPublico();
    ColaVueloPrivado priv = new ColaVueloPrivado();
    ArbolAdmin admin = new ArbolAdmin();
    ListaOrdenadaCliente cliente = new ListaOrdenadaCliente();

    public void addVuelosFijosExistentes() {//origen, destino, modelo, id, privacidad, disponibilidad, fechaSalida, fechaLlegada, paxPrimeraClase, paxEconomico, precioPrimeraClase, precioEconomico.
        pub.insertar(new VueloPublico("San Jose, Costa Rica", "Miami, USA", "B737-800", "240", "fijo", "disponible", 1810050230, 1810060500, 40, 120, 750, 380));
        pub.insertar(new VueloPublico("San Jose, Costa Rica", "Los Angeles, USA", "B757-200", "245", "fijo", "disponible", 1810060330, 1810090500, 50, 200, 845, 582));
        pub.insertar(new VueloPublico("San Jose, Costa Rica", "Nueva York, USA", "A320", "250", "fijo", "disponible", 1810070400, 1810100500, 45, 140, 990, 620));
        pub.insertar(new VueloPublico("Ciudad de Panama, Panama", "San Jose, Costa Rica", "B767-300", "255", "fijo", "disponible", 1810141230, 18100500, 80, 250, 1760, 1020));
        pub.insertar(new VueloPublico("Ciudad de Panama, Panama", "Managua, Nicaragua", "B787", "260", "fijo", "disponible", 1810091430, 18140500, 60, 180, 2100, 1190));
        pub.insertar(new VueloPublico("Ciudad de Panama, Panama", "Bogota, Colombia", "B787", "265", "fijo", "disponible", 1810121645, 18170500, 60, 180, 2100, 1190));
        pub.insertar(new VueloPublico("Managua, Nicaragua", "San Jose, Costa Rica", "B737-800", "270", "fijo", "disponible", 1810151100, 1810200500, 30, 110, 478, 290));
        pub.insertar(new VueloPublico("Managua, Nicaragua", "Ciudad de Panama, Panama", "B787", "275", "fijo", "disponible", 1810172315, 1810230500, 60, 180, 566, 310));
        pub.insertar(new VueloPublico("Managua, Nicaragua", "Bogota, Colombia", "B737-800", "280", "fijo", "disponible", 1810200725, 1810270500, 30, 130, 750, 447));
        pub.insertar(new VueloPublico("Liberia, Costa Rica", "Ciudad de Panama, Panama", "B737-800", "285", "fijo", "disponible", 1810251440, 1810270500, 40, 130, 515, 260));
        pub.insertar(new VueloPublico("Liberia, Costa Rica", "Managua, Nicaragua", "B737-800", "290", "fijo", "disponible", 1810271600, 1810300500, 40, 120, 470, 225));
        pub.insertar(new VueloPublico("Liberia, Costa Rica", "Bogota, Colombia", "B787", "295", "fijo", "disponible", 1810301735, 18110500, 40, 200, 640, 300));
    }

    public void addVuelosSolicitudesExistentes() {
        pub.insertar(new VueloPublico("San Jose, Costa Rica", "Ciudad de Panama, Panama", "B737-800", "305", "solicitud", "disponible", 1810032230, 1810052300, 3, 10, 515, 265));
        pub.insertar(new VueloPublico("San Jose, Costa Rica", "Miami, USA", "A320", "310", "solicitud", "disponible", 1810070100, 1810120100, 0, 7, 770, 400));
        pub.insertar(new VueloPublico("Liberia, Costa Rica", "Ciudad de Panama, Panama", "B737-800", "315", "solicitud", "disponible", 1811040830, 1811090830, 3, 8, 520, 285));
        pub.insertar(new VueloPublico("Ciudad de Panama, Panama", "San Jose, Costa Rica", "A320", "320", "solicitud", "disponible", 1811030430, 1811070430, 7, 10, 500, 240));
        pub.insertar(new VueloPublico("Ciudad de Panama, Panama", "Miami, USA", "B737-800", "325", "solicitud", "disponible", 1812061900, 1812151900, 0, 12, 820, 410));
    }

    public void addVuelosPrivadosExistentes() { //origen, destino, modelo, ID vuelo, fechaSalida, fechaEntrada, pax, precioTotal.
        priv.encola(new VueloPrivado("San Jose, Costa Rica", "Paris, Francia", "G650", "VP120", 1811270530, 1811282200, 3, priv.calcTotal(1811270530, 1811282200)));
        priv.encola(new VueloPrivado("San Jose, Costa Rica", " Ginebra, Suiza", "Challenger 300", "VP125", 1811281230, 1812010800, 5, priv.calcTotal(1811281230, 1812010800)));
        priv.encola(new VueloPrivado("Ciudad de Panama, Panama", "Dubai, EAU", "Phenom 100EV", "VP130", 1811301820, 1812051700, 2, priv.calcTotal(1811301820, 1812051700)));
        priv.encola(new VueloPrivado("San Jose, Costa Rica", "Sao Paulo, Brazil", "Challenger 300", "VP135", 1812020400, 1812072200, 4, priv.calcTotal(1812020400, 1812072200)));
        priv.encola(new VueloPrivado("Ciudad de Panama, Panama", "Moscu, Russia", "G650", "VP140", 1812021115, 1812081445, 7, priv.calcTotal(1812021115, 1812081445)));
    }

    public void addClientesExistentes() {//nombre, cel, email, clase, # de asientos, cedula, id de vuelo, costo por medio del metodo
        cliente.insertar(new Cliente("Daniela", "8712-6443", "daniela@gmail.com", "primera", 1, 116840022, "240", pub.reservaExistentes("primera", 1, "240")));
        cliente.insertar(new Cliente("Bryan", "5643-6566", "bryan@ulacit.com", "economica", 10, 113443443, "245", pub.reservaExistentes("economica", 10, "245")));
        cliente.insertar(new Cliente("Irene", "6654-1128", "irene@yahoo.com", "economica", 8, 13328422, "240", pub.reservaExistentes("economica", 8, "240")));
        cliente.insertar(new Cliente("Andres", "7832-0935", "andres@hotmail.com", "primera", 3, 198624434, "275", pub.reservaExistentes("primera", 3, "275")));
        cliente.insertar(new Cliente("Marco", "7637-8834", "marco@gmail.com", "economica", 3, 116435342, "280", pub.reservaExistentes("economica", 3, "280")));
        cliente.insertar(new Cliente("Sofia", "8276-7654", "sofia@outlook.com", "primera", 2, 119543444, "290", pub.reservaExistentes("primera", 2, "290")));
        cliente.insertar(new Cliente("Alejandro", "5453-3223", "alejandro@destinos.com", "economica", 7, 116300734, "255", pub.reservaExistentes("economica", 7, "255")));
        cliente.insertar(new Cliente("Gloriana", "2956-5543", "gloriana@hotmail.com", "economica", 4, 12309454, "295", pub.reservaExistentes("economica", 4, "295")));
        cliente.insertar(new Cliente("Brandon", "4523-6575", "brandon@yahoo.com", "economica", 6, 112454695, "265", pub.reservaExistentes("economica", 6, "265")));

    }

    public void addAdminsExistentes() { //Usuario, password, privilegios (0 tiene todos los privilegios)
        admin.inserta(new Admin("Roberto", "1234", 0));
        admin.inserta(new Admin("Bryan", "1234", 1));
        admin.inserta(new Admin("Mariana", "1234", -1));
        admin.inserta(new Admin("Daniel", "1234", 2));
        admin.inserta(new Admin("Gabriela", "1234", -2));
    }

    public void test() {
        System.out.println(priv);
        admin.imprimeTodos();
    }
}
