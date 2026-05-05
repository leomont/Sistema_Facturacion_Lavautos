package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Cliente> clientes;
    private List<Servicio> serviciosDisponibles;
    private List<Factura> facturas;
    private Scanner scanner;

    public Menu() {
        clientes = new ArrayList<>();
        serviciosDisponibles = new ArrayList<>();
        facturas = new ArrayList<>();
        scanner = new Scanner(System.in);

        // Servicios predeterminados
        serviciosDisponibles.add(new Servicio("Lavado Básico", 5.00));
        serviciosDisponibles.add(new Servicio("Lavado Premium", 10.00));
        serviciosDisponibles.add(new Servicio("Lavado Deluxe", 15.00));
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Sistema de Facturación Lava Autos ---");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Crear Factura");
            System.out.println("3. Ver Facturas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir newline

            switch (opcion) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    crearFactura();
                    break;
                case 3:
                    verFacturas();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
    }

    private void registrarCliente() {
        System.out.print("Nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Vehículo: ");
        String vehiculo = scanner.nextLine();
        Cliente cliente = new Cliente(nombre, vehiculo);
        clientes.add(cliente);
        System.out.println("Cliente registrado: " + cliente);
    }

    private void crearFactura() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados. Registre un cliente primero.");
            return;
        }

        System.out.println("Clientes disponibles:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i));
        }
        System.out.print("Seleccione cliente (número): ");
        int clienteIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (clienteIndex < 0 || clienteIndex >= clientes.size()) {
            System.out.println("Cliente inválido.");
            return;
        }

        Cliente cliente = clientes.get(clienteIndex);
        Factura factura = new Factura(cliente);

        System.out.println("Servicios disponibles:");
        for (int i = 0; i < serviciosDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + serviciosDisponibles.get(i));
        }

        int servicioOpcion;
        do {
            System.out.print("Seleccione servicio (número, 0 para terminar): ");
            servicioOpcion = scanner.nextInt() - 1;
            scanner.nextLine();

            if (servicioOpcion >= 0 && servicioOpcion < serviciosDisponibles.size()) {
                factura.agregarServicio(serviciosDisponibles.get(servicioOpcion));
                System.out.println("Servicio agregado.");
            } else if (servicioOpcion != -1) {
                System.out.println("Servicio inválido.");
            }
        } while (servicioOpcion != -1);

        System.out.println("Factura creada:");
        System.out.println(factura);

        System.out.print("Ingrese monto a pagar: ");
        double pago = scanner.nextDouble();
        scanner.nextLine();
        factura.pagar(pago);

        if (factura.estaPagada()) {
            System.out.println("Factura pagada completamente.");
        } else {
            System.out.println("Saldo pendiente: $" + String.format("%.2f", factura.getTotal()));
        }

        facturas.add(factura);
    }

    private void verFacturas() {
        if (facturas.isEmpty()) {
            System.out.println("No hay facturas.");
            return;
        }

        for (Factura f : facturas) {
            System.out.println(f);
        }
    }
}
