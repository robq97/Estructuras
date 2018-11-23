/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.clientes;

/**
 *
 * @author robq9
 */
public class Cliente {

    private String nombre, telefono, email, categoria, idVuelo;
    private int espacios, cedula;
    private double total;

    public Cliente(String nombre, String telefono, String email, String categoria, int espacios, int cedula, String idVuelo, double total) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.categoria = categoria;
        this.espacios = espacios;
        this.total = total;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getEspacios() {
        return espacios;
    }

    public void setEspacios(int espacios) {
        this.espacios = espacios;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    @Override
    public String toString() {
        return "Vuelo: " + idVuelo + ", Cedula: " + cedula + ", Nombre: " + nombre + ", Telefono: " + telefono + ", Email: " + email + ", Categoria: "
                + categoria + ", Espacios: " + espacios + ", Total: " + total;
    }

}
