package backend.handler;

import frontend.Home;
import java.text.ParseException;

public class Main {
    
    public static void main(String[] args) throws ParseException {
        Handler handler = new Handler();         //Creacion del objeto handler y se agregan todos los datos pre-existentes a las estructuras.
        handler.addVuelosFijosExistentes();
        handler.addClientesExistentes();
        handler.addAdminsExistentes();
        handler.addVuelosPrivadosExistentes();
        Home window = new Home();
        window.setVisible(true);                //El UI se vuelve visible.
    }
}
