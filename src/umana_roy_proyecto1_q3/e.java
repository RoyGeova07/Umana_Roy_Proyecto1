/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package umana_roy_proyecto1_q3;

/**
 *
 * @author royum
 */
public class e {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     // Datos para 4 productos
        String producto1 = "Azucar";
        String producto2 = "Avena";
        String producto3 = "Trigo";
        String producto4 = "Maiz";

        int cantidad1 = 50;
        int cantidad2 = 30;
        int cantidad3 = 50;
        int cantidad4 = 30;

        // Variables temporales para el intercambio
        String tempProducto;
        int tempCantidad;

        // Variable para producto estrella
        String productoEstrella = "";

        // Ordenar producto 1 y 2
        if (cantidad1 < cantidad2) {
            tempProducto = producto1;
            producto1 = producto2;
            producto2 = tempProducto;

            tempCantidad = cantidad1;
            cantidad1 = cantidad2;
            cantidad2 = tempCantidad;
        }

        // Ordenar producto 2 y 3
        if (cantidad2 < cantidad3) {
            tempProducto = producto2;
            producto2 = producto3;
            producto3 = tempProducto;

            tempCantidad = cantidad2;
            cantidad2 = cantidad3;
            cantidad3 = tempCantidad;
        }

        // Ordenar producto 3 y 4
        if (cantidad3 < cantidad4) {
            tempProducto = producto3;
            producto3 = producto4;
            producto4 = tempProducto;

            tempCantidad = cantidad3;
            cantidad3 = cantidad4;
            cantidad4 = tempCantidad;
        }

        // Repetir para garantizar el orden correcto
        if (cantidad1 < cantidad2) {
            tempProducto = producto1;
            producto1 = producto2;
            producto2 = tempProducto;

            tempCantidad = cantidad1;
            cantidad1 = cantidad2;
            cantidad2 = tempCantidad;
        }

        if (cantidad2 < cantidad3) {
            tempProducto = producto2;
            producto2 = producto3;
            producto3 = tempProducto;

            tempCantidad = cantidad2;
            cantidad2 = cantidad3;
            cantidad3 = tempCantidad;
        }

        if (cantidad1 < cantidad2) {
            tempProducto = producto1;
            producto1 = producto2;
            producto2 = tempProducto;

            tempCantidad = cantidad1;
            cantidad1 = cantidad2;
            cantidad2 = tempCantidad;
        }

        // Determinar el producto estrella con la máxima cantidad de kilos vendidos
        int maxCantidad = cantidad1;
        productoEstrella = producto1;

        if (cantidad2 == maxCantidad) {
            productoEstrella += ", " + producto2;
        } else if (cantidad2 > maxCantidad) {
            maxCantidad = cantidad2;
            productoEstrella = producto2;
        }

        if (cantidad3 == maxCantidad) {
            productoEstrella += ", " + producto3;
        } else if (cantidad3 > maxCantidad) {
            maxCantidad = cantidad3;
            productoEstrella = producto3;
        }

        if (cantidad4 == maxCantidad) {
            productoEstrella += ", " + producto4;
        } else if (cantidad4 > maxCantidad) {
            maxCantidad = cantidad4;
            productoEstrella = producto4;
        }

        // Mostrar el ranking de productos
        System.out.println("Ranking de productos:");

        int rank = 1;
        System.out.print(rank + ". " + producto1 + " - Kilos Vendidos: " + cantidad1);

        if (cantidad1 == cantidad2) {
            System.out.print(", " + producto2 + " - Kilos Vendidos: " + cantidad2);
        } else {
            rank++;
            System.out.println();
            System.out.print(rank + ". " + producto2 + " - Kilos Vendidos: " + cantidad2);
        }

        if (cantidad2 == cantidad3) {
            System.out.print(", " + producto3 + " - Kilos Vendidos: " + cantidad3);
        } else {
            rank++;
            System.out.println();
            System.out.print(rank + ". " + producto3 + " - Kilos Vendidos: " + cantidad3);
        }

        if (cantidad3 == cantidad4) {
            System.out.print(", " + producto4 + " - Kilos Vendidos: " + cantidad4);
        } else {
            rank++;
            System.out.println();
            System.out.print(rank + ". " + producto4 + " - Kilos Vendidos: " + cantidad4);
        }

        // Mostrar los productos estrella
        System.out.println("\nProducto(s) Estrella: " + productoEstrella + " - Kilos Vendidos: " + maxCantidad);
    }
}