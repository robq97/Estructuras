/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package backend.admin;

/**
 *
 * @author robq9
 */
public class Admin {
    
    private String nombre, password;                 //instancias que comparten todos los admins.
    private int nivelAcceso;
    
    public Admin(String nombre, String password, int nivelAcceso) {   //Constructor para todos los admins.
        this.nombre = nombre;
        this.password = password;
        this.nivelAcceso = nivelAcceso;
    }
    
    public String getNombre() {     //Respectivos setters, getters y toString.
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getNivelAcceso() {
        return nivelAcceso;
    }
    
    public void setNivelAcceso(int nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n";
    }
}
