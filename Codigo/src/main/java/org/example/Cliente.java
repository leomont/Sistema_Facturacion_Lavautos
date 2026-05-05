package org.example;

public class Cliente {
    private String nombre;
    private String vehiculo;

    public Cliente(String nombre, String vehiculo) {
        this.nombre = nombre;
        this.vehiculo = vehiculo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + ", Vehículo: " + vehiculo;
    }
}
