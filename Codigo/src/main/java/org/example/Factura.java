package org.example;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Servicio> servicios;
    private double total;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.servicios = new ArrayList<>();
        this.total = 0.0;
    }

    public void agregarServicio(Servicio servicio) {
        servicios.add(servicio);
        total += servicio.getPrecio();
    }

    public double getTotal() {
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void pagar(double monto) {
        if (monto > 0.0 && monto <= total) {
            total -= monto;
        }
    }

    public boolean estaPagada() {
        return total == 0.0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Factura para ").append(cliente.toString()).append("\n");
        sb.append("Servicios:\n");
        for (Servicio s : servicios) {
            sb.append("- ").append(s.toString()).append("\n");
        }
        sb.append("Total: $").append(String.format("%.2f", total)).append("\n");
        return sb.toString();
    }
}
