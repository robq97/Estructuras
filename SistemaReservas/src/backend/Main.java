package backend;

import frontend.Home;

public class Main {

    public static void main(String[] args) {
        Home window = new Home();
        window.setVisible(true);

        Handler handler = new Handler();
        handler.addVuelosFijosExistentes();
        handler.addVuelosPrivadosExistentes();
        handler.addAdminsExistentes();
        handler.test();
    }
}
