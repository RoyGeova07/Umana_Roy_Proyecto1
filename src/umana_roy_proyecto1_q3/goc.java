/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package umana_roy_proyecto1_q3;

import java.util.Scanner;

/**
 *
 * @author royum
 */
public class goc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String producto1 = "Azucar";
        String producto2 = "Avena";
        String producto3 = "Trigo";
        String producto4 = "Maiz";
        
        System.out.println("Ingrese la cantidad vendida en kg para " + producto1 + ":");
        double cantidad1 = scanner.nextDouble();
        
        System.out.println("Ingrese la cantidad vendida en kg para " + producto2 + ":");
        double cantidad2 = scanner.nextDouble();
        
        System.out.println("Ingrese la cantidad vendida en kg para " + producto3 + ":");
        double cantidad3 = scanner.nextDouble();
        
        System.out.println("Ingrese la cantidad vendida en kg para " + producto4 + ":");
        double cantidad4 = scanner.nextDouble();
        
        System.out.println("\nRanking de productos por cantidad vendida:");
        
        int puesto = 1;
        
        while (true) {
            double maxCantidad = Math.max(Math.max(cantidad1, cantidad2), Math.max(cantidad3, cantidad4));
            
            if (maxCantidad == 0) break;
            
            System.out.print(puesto + ". ");
            boolean primero = true;
            
            if (Math.abs(cantidad1 - maxCantidad) < 0.000001) {
                System.out.printf("%s: %.2f kg", producto1, cantidad1);
                cantidad1 = 0;
                primero = false;
            }
            if (Math.abs(cantidad2 - maxCantidad) < 0.000001) {
                if (!primero) System.out.print(", ");
                System.out.printf("%s: %.2f kg", producto2, cantidad2);
                cantidad2 = 0;
                primero = false;
            }
            if (Math.abs(cantidad3 - maxCantidad) < 0.000001) {
                if (!primero) System.out.print(", ");
                System.out.printf("%s: %.2f kg", producto3, cantidad3);
                cantidad3 = 0;
                primero = false;
            }
            if (Math.abs(cantidad4 - maxCantidad) < 0.000001) {
                if (!primero) System.out.print(", ");
                System.out.printf("%s: %.2f kg", producto4, cantidad4);
                cantidad4 = 0;
            }
            
            System.out.println();
            puesto++;
        }
    }
    
}
