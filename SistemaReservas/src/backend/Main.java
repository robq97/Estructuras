package backend;

import frontend.Home;

public class Main {
    
    public static void main(String[] args) {
        
        //codigo para prubas
        Handler handler = new Handler();
        handler.addVuelosFijosExistentes();
        handler.addClientesExistentes();
        handler.addAdminsExistentes();
        handler.addVuelosPrivadosExistentes();
        handler.addVuelosSolicitudesExistentes();
        String nombre = "Mariana";
        int nivel = handler.obtenerNivel(nombre);
        System.out.println(nivel);
//        handler.test();
    Home window = new Home();
    window.setVisible(true);
    }
}
