/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package backend.admin;

import javax.swing.JOptionPane;

/**
 *
 * @author ulacit
 */
public class ArbolAdmin {
    
    private NodoAdmin raiz;
    private String msjHojas = "";
    private String msjNiveles = "";
    
    public void inserta(Admin a) {                                              //Metodo para insertar admins al arbol.
        if (raiz == null) {                                                     //En caso de que la raiz sea nula, se asigna el admin ingresado como nueva raiz.
            raiz = new NodoAdmin(a);
        } else {
            insertaRec(a, raiz);                                                //De lo contrario se llama al metodo recursivo para que lo posicione en lugar correcto.
        }
    }
    
    private void insertaRec(Admin a, NodoAdmin n) {                             //Se decide si se posiciona a la izquiera o derecha en caso de que ya exista una raiz.
        if (a.getNivelAcceso() <= n.getDato().getNivelAcceso()) {               //izq.         su posicion dependera del valor (menor o igual a la izquierda, mayor a la derecha)
            if (n.getHijoIzq() == null) {                                       //Tengo campo.
                n.setHijoIzq(new NodoAdmin(a));
            } else {
                insertaRec(a, n.getHijoIzq());                                  //En caso de no tener campo se vuelve a llamar a si mismo para poder encontrarlo.
            }
        } else {                                                                //derecha.
            if (n.getHijoDer() == null) {                                       //Tengo campo.
                n.setHijoDer(new NodoAdmin(a));
            } else {
                insertaRec(a, n.getHijoDer());
            }
        }
    }
    
    boolean acceso = false;
    public boolean iniciarSesion (String user, String pass){  //Metodo para el inicio de sesion, se llama al metodo recursivo inOrdenRec para
        acceso = false;                                       //verificar si existe o no algun match a los parametros del metodo.
        if (raiz != null){
            acceso = inOrdenRec(raiz, user, pass);
        }
        return acceso;
    }
    
    private boolean inOrdenRec(NodoAdmin n, String user, String pass){          //Metodo recursivo que recorre al arbol en orden de menor a mayor.
        if (n != null){                                                         //y ayuda al metodo de iniciar sesion porque recorre todo el arbol.
            inOrdenRec(n.getHijoIzq(), user, pass);
            if(n.getDato().getNombre().equals(user) && n.getDato().getPassword().equals(pass)){
                this.acceso = true;                                             //En caso de encontrar un match con los parametros del metodo iniciarSesion,
                return true;                                                    //el booleano acceso se vuelve verdadero, dando asi acceso al admin.
            }
            inOrdenRec(n.getHijoDer(), user, pass);
        }
        return acceso;
    }
    
    private int nivel;
    public int getNivel(String nombre){          //Metodo para obtener el nivel de un usuario por su nombre
        int nivelAct = -1;
        this.nivel = 0;
        if (raiz != null){
            getNivelRec(raiz, nivelAct, nombre);
        }
        return nivel;
    }
    
    private void getNivelRec(NodoAdmin nodo, int nivelAct, String nombre){      //Metodo recursivo de getNivel.
        nivelAct++;
        if (nodo != null){
            getNivelRec(nodo.getHijoIzq(), nivelAct, nombre);
            if(nodo.getDato().getNombre().equals(nombre)){                      // Cuando el nombre coincide guarda el nivel en una variable
                this.nivel = nivelAct;
            }
            getNivelRec(nodo.getHijoDer(), nivelAct, nombre);
        }
    }
    
    public void cambiarContrasena(String usuario, String contrAct, String contrNue){ //Metodo para el cambio de contrasena de admins.
        if (raiz != null){
            cambiarContrasenaRec(raiz, usuario, contrAct, contrNue);             //Llamado al metodo recursivo.
        }
    }
    
    private void cambiarContrasenaRec(NodoAdmin nodo, String usuario, String contrAct, String contrNue){
        if (nodo != null){
            cambiarContrasenaRec(nodo.getHijoIzq(), usuario, contrAct, contrNue); //Va a revisar todo el arbol, en caso de que encuentre el mismo nombre y contrasena actual
            if(nodo.getDato().getNombre().equals(usuario)){                       //se podra cambiar por la nueva.
                if (nodo.getDato().getPassword().equals(contrAct)){
                    nodo.getDato().setPassword(contrNue);
                    JOptionPane.showMessageDialog(null, "Contraseña actualizada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "La contraseña actual no coincide.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            cambiarContrasenaRec(nodo.getHijoDer(), usuario, contrAct, contrNue);
        }
    }
    private boolean existe;
    public boolean existe(String usuario){
        existe = false;
        if (raiz != null){
            existeRec(raiz, usuario);
        }
        return existe;
    }
    
    private void existeRec(NodoAdmin n, String usuario){
        if (n != null){
            existeRec(n.getHijoIzq(), usuario);
            if (n.getDato().getNombre().equals(usuario)){
                this.existe = true;
            }
            existeRec(n.getHijoDer(), usuario);
        }
    }
}
