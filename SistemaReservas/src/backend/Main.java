package backend;

import frontend.Home;

public class Main {

    public static void main(String[] args) {
        Handler handler = new Handler();         //Creacion del objeto handler y se agregan todos los datos pre-existentes a las estructuras.
        handler.addVuelosFijosExistentes();
        handler.addClientesExistentes();
        handler.addAdminsExistentes();
        handler.addVuelosPrivadosExistentes();
        handler.addVuelosSolicitudesExistentes();
        //handler.test();
        Home window = new Home();                 
        window.setVisible(true);                //El UI se vuelve visible.
    }
}
