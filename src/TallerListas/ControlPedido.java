/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TallerListas;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ANDRES
 */
public class ControlPedido {

    ArrayList registro = new ArrayList();
    Scanner in = new Scanner(System.in);

    void agregarpedido() {
        System.out.println("Digite el Nombre del Cliente");
        String nombre = in.nextLine();
        System.out.println("Digite el barrio de Destino");
        String barrio = in.nextLine();
        System.out.println("Digite la direccion de Pedido");
        String direccion = in.nextLine();
        System.out.println("Digite el celular del cliente");
        String celular = in.nextLine();
        System.out.println("Digite el codigo del Pedido");
        String codigo = in.nextLine();

        Pedido pedido = new Pedido();
        pedido.setNombre(nombre);
        pedido.setBarrio(barrio);
        pedido.setDireccion(direccion);
        pedido.setCelular(celular);
        pedido.setCodigo(codigo);
        
        registro.add(pedido);

        System.out.println("Los datos del pedido han sido registrados Exitosamente!!");
    }

    void listarPedidos() {
        if (registro.isEmpty()) {
            System.out.println("No hay pedidos registrados");
        } else {
            System.out.println("Listando...");
            for (int i = 0; i < registro.size(); i++) {
                Pedido pedidoRecuperado = (Pedido) registro.get(i);
                System.out.println("Pedido "+(i+1));
                System.out.println("El nombre del Cliente es: "+pedidoRecuperado.getNombre());
                System.out.println("El barrio de la entrega es: "+pedidoRecuperado.getBarrio());
                System.out.println("La direccion de entrega es: "+pedidoRecuperado.getDireccion());
                System.out.println("El celulra del cliente es: "+pedidoRecuperado.getCelular());
                System.out.println("El codigo del pedido es: "+pedidoRecuperado.getCodigo());
            }
        }
    }

    void eliminarPedido() {
        System.out.println("Digite el codigo del pedido a eliminar");
        String codigoBuscar = in.nextLine();
        boolean bandera=false;
        for (int i = 0; i < registro.size(); i++) {
            Pedido pedido = (Pedido) registro.get(i);
            if (pedido.getCodigo().equals(codigoBuscar)) {
                registro.remove(i);
                bandera=true;
            }
        }
        if (bandera==true){
            System.out.println("Pedido eliminado");
        }
    }

    void eliminarPedidos() {
        if (!registro.isEmpty()) {
            registro.clear();
            System.out.println("Se han eliminado todos los pedidos");
        } else {
            System.out.println("No hay pedidos registrados");
        }
    }

    void consultarPedidoPorBarrio() {
        System.out.println("Digite el Barrio del pedido a buscar");
        String barrioBuscar = in.nextLine();
        boolean bandera=false;
        for (int i = 0; i < registro.size(); i++) {
            Pedido pedido = (Pedido) registro.get(i);
            if (pedido.getBarrio().equals(barrioBuscar)) {
                Pedido pedidoRecuperado = (Pedido) registro.get(i);
                System.out.println("Pedido "+(i+1));
                System.out.println("El nombre del Cliente es: "+pedidoRecuperado.getNombre());
                System.out.println("El barrio de la entrega es: "+pedidoRecuperado.getBarrio());
                System.out.println("La direccion de entrega es: "+pedidoRecuperado.getDireccion());
                System.out.println("El celulra del cliente es: "+pedidoRecuperado.getCelular());
                System.out.println("El codigo del pedido es: "+pedidoRecuperado.getCodigo());
                bandera=true;
            }
        }
        if(bandera==false){
            System.out.println("No hay barrios registrados con el nombre de: "+barrioBuscar);
        }
    }

    void menu() {
        int opcion = 0;
        do {
            System.out.println("""
                               
                           *******Menu de opciones*******
                           
                           1.Registrar Pedido
                           2.Listar todos los Pedidos
                           3.Eliminar un Pedido
                           4.Eliminar todos los Pedidos
                           5.Consultar pedido por Barrio
                           6.Salir
                           
                           opcion: """);
            opcion = in.nextInt();
            in.nextLine();
            switch (opcion) {
                case 1:
                    this.agregarpedido();
                    break;
                case 2:
                    this.listarPedidos();
                    break;
                case 3:
                    this.eliminarPedido();
                    break;
                case 4:
                    this.eliminarPedidos();
                    break;
                case 5:
                    this.consultarPedidoPorBarrio();
                    break;
                case 6:
                    System.out.println("Saliendo del Programa...");
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
                    break;
            }
        } while (opcion !=7);
    }
}
