package backend;

import frontend.Home;

public class Main {
    
    public static void main(String[] args) {
        Handler handler = new Handler();
        handler.addVuelosFijosExistentes();
        handler.addClientesExistentes();
        handler.addAdminsExistentes();
        handler.addVuelosPrivadosExistentes();
        handler.addVuelosSolicitudesExistentes();
        //codigo para prubas
        handler.test();
        Home window = new Home();
        window.setVisible(true);
    }
}
