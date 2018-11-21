/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd;

/**
 *
 * @author robq9
 */
public class Handler {

    CircDobleVueloPublico vueloPub = new CircDobleVueloPublico();
    ColaVueloPrivado vueloPriv = new ColaVueloPrivado();

    public void vuelosExistentes() {//origen,destino, modelo, id, privacidad, mesSalida, mesLlegada, diaSalida, diaLlegada, paxPrimeraClase, paxEconomico, precioPrimeraClase, precioEconomico.
        vueloPub.insertar(new VueloPublico("San Jose, Costa Rica", "Miami, USA", "B737-800", "240", "publico", 1, 2, 3, 4, 40, 120, 750, 380));
        vueloPub.insertar(new VueloPublico("San Jose, Costa Rica", "Los Angeles, USA", "B757-200", "245", "publico", 1, 1, 4, 5, 50, 200, 845, 582));
        vueloPub.insertar(new VueloPublico("San Jose, Costa Rica", "Nueva York, USA", "A320", "250", "publico", 2, 2, 9, 20, 45, 140, 990, 620));
        vueloPub.insertar(new VueloPublico("Ciudad de Panama, Panama", "San Jose, Costa Rica", "B767-300", "255", "publico", 2, 3, 19, 1, 80, 250, 1760, 1020));
        vueloPub.insertar(new VueloPublico("Ciudad de Panama, Panama", "Managua, Nicaragua", "B787", "260", "publico", 1, 2, 26, 3, 60, 180, 2100, 1190));
        vueloPub.insertar(new VueloPublico("Ciudad de Panama, Panama", "Bogota, Colombia", "B787", "265", "publico", 1, 2, 30, 5, 60, 180, 2100, 1190));
        vueloPub.insertar(new VueloPublico("Managua, Nicaragua", "San Jose, Costa Rica", "B737-800", "270", "publico", 2, 2, 14, 18, 30, 110, 478, 290));
        vueloPub.insertar(new VueloPublico("Managua, Nicaragua", "Ciudad de Panama, Panama", "B787", "275", "publico", 2, 3, 25, 4, 60, 180, 566, 310));
        vueloPub.insertar(new VueloPublico("Managua, Nicaragua", "Bogota, Colombia", "B737-800", "280", "publico", 1, 1, 28, 2, 30, 130, 750, 447));
        vueloPub.insertar(new VueloPublico("Liberia, Costa Rica", "Ciudad de Panama, Panama", "B737-800", "285", "publico", 1, 2, 29, 1, 40, 130, 515, 260));
        vueloPub.insertar(new VueloPublico("Liberia, Costa Rica", "Managua, Nicaragua", "B737-800", "290", "publico", 2, 2, 7, 10, 40, 120, 470, 225));
        vueloPub.insertar(new VueloPublico("Liberia, Costa Rica", "Bogota, Colombia", "B787", "295", "publico", 1, 2, 23, 10, 40, 200, 640, 300));
    }
}
