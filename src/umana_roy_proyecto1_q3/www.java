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
public class www {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner leer = new Scanner(System.in);
        leer.useDelimiter("\n");
        
        //Definicion de variables
        double dinerocaja = 0, ingresardinero = 0, cantidadkgventa = 0, subtotalventa = 0, descuentoventas = 0, totalventas = 0;
        double cantidadmaizventa = 0, cantidadazucarventa = 0, cantidadavenaventa = 0, cantidadtrigoventa = 0;
        int estadoventa = 0, tipocliente = 0;
        String producto = "";
        int contadorerror = 0, tipoproveedor = 0, tipocompra = 0, repetircompras = 1;
        double compraazucar = 0, compramaiz = 0, compratrigo = 0, cantidadkg = 0, compraavena = 0;
        double cantidadazucar = 0, cantidadmaiz = 0, cantidadtrigo = 0, cantidadavena = 0;
        double totalcompras = 0;
        double contadorventatrigo = 0, contadorventamaiz = 0, contadorventaavena = 0, contadorventaazucar = 0;
        double contadorcompratrigo = 0, contadorcompramaiz = 0, contadorcompraavena = 0, contadorcompraazucar = 0;
        double contadorventastotal = 0, contadorcomprastotal = 0, contadorventas = 0, contadorcompras = 0;
        double mayorventa = 0, mayorcompra = 0, mayorcantidadkgvendidos = 0;
        String productoestrella = "";

       
        int opcion = 0;
        String estadocaja = "cerrada";
        double dineroadepositar = 0;
        double dinerodepositado = 0;
        
         // Variables para el ranking
        String primerNombre = "";
        double primerVentas = 0;
        String segundoNombre = "";
        double segundoVentas = 0;
        String tercerNombre = "";
        double tercerVentas = 0;
        String cuartoNombre = "";
        double cuartoVentas = 0;

        while (opcion != 6) {
            System.out.println("----------------------------------------BIENVENIDO----------------------------------------"
                    + "\nIngrese que accion desea realizar "
                    + "\n1)Apertura de caja"
                    + "\n2)Ventas"
                    + "\n3)Compras"
                    + "\n4)Reportes"
                    + "\n5)Cierre de caja"
                    + "\n6)Salir del sistema"
                    + "\n------------------------------------------------------------------------------------------");
            opcion = leer.nextInt();

            while (opcion <= 0 || opcion >= 7) {
                System.out.println("Error: Ingrese una de las opciones mostradas en pantalla");
                opcion = leer.nextInt();
            }
            //Seccion de Apertura caja 
            if (opcion == 1) {

                if (estadocaja.equals("abierto") || ingresardinero == 0) {
                    System.out.println("Ingrese la cantidad a depositar en caja:");
                    ingresardinero = leer.nextDouble();
                    while (ingresardinero < 0) {
                        System.out.println("Error: Ingrese una cantidad valida de dinero");
                        ingresardinero =     leer.nextDouble();
                    }
                    dinerocaja = dinerocaja + ingresardinero;
                }
 
                if (estadocaja.equals("cerrada")) {
                    System.out.println("Se ha abierto caja");
                }
                estadocaja = "abierto";
                //dinerocaja=dinerocaja+1;
                System.out.println("La cantidad de dinero actual en caja es de: " + dinerocaja + " Lps");
            }
            //Seccion de apartado de ventas 
            /*
                Esta parte permite que si no hay productos en el inventario que el estado de la venta sea nulo, es decir no deje vender
             */
            if (cantidadavena <= 0 && cantidadazucar <= 0 && cantidadtrigo <= 0 && cantidadmaiz <= 0) {
                estadoventa = 0;
            }
            if (cantidadavena > 0 || cantidadazucar > 0 || cantidadtrigo > 0 || cantidadmaiz > 0) {
                estadoventa = 1;
            }

                if (opcion == 2 && estadocaja.equals("abierto") && estadoventa == 1) {
                contadorerror = 0;
                producto = "";
                cantidadazucarventa = 0;
                cantidadmaizventa = 0;
                cantidadtrigoventa = 0;
                cantidadavenaventa = 0;
                repetircompras = 1;
                producto = "";

                System.out.println("Ingrese su tiplo de cliente"
                        + "\n---------------------------------------------------"
                        + "\n|N|Tipo cliente|                    Productos disponibles                  |"
                        + "\n|1|Cliente A   |->Azucar 30 Lp ->Avena 25 Lps -> Trigo 32 Lps ->Maiz 20 Lps|"
                        + "\n|2|Cliente B   |->Azucar 30 Lp ->Avena 25 Lps -> Trigo 32 Lps              |"
                        + "\n|3|Cliente C   |->Maiz 20 Lps                                              |");
                tipocliente = leer.nextInt();
                while (tipocliente < 0 || tipocliente > 3) {
                    System.out.println("Error: Eliga una de las opciones en pantalla");
                    tipocliente = leer.nextInt();
                }
                while (repetircompras == 1) {
                    System.out.println("Inventario"
                            + "\n|Producto| cantidad de KG disponibles       "
                            + "\n|Avena   | " + cantidadavena + "  KG disponibles"
                            + "\n|Maiz    | " + cantidadmaiz + "  KG disponibles "
                            + "\n|Trigo   | " + cantidadtrigo + "  KG disponibles"
                            + "\n|Azucar  | " + cantidadazucar + " KG disponibles");
                    if (tipocliente == 1) {
                        System.out.println("*Cliente A   \n->Azucar 30 Lp ->Avena 25 Lps \n-> Trigo 32 Lps ->Maiz 20 Lps");
                    }
                    if (tipocliente == 2) {
                        System.out.println("*Cliente B   \n->Azucar 30 Lp ->Avena 25 Lps \n-> Trigo 32 Lps              ");
                    }
                    if (tipocliente == 3) {
                        System.out.println("*Cliente C   \n->Maiz 20 Lps                                              ");
                    }
                    producto = "";
                    contadorerror = 0;
                    System.out.println("Escriba el producto que desea adquirir");

                    //Restricciones en la seleccion de productos segun el tipo de cliente 
                    if (tipocliente == 1) {
                        while (!producto.equals("AZUCAR") && !producto.equals("MAIZ") && !producto.equals("AVENA") && !producto.equals("TRIGO")) {
                            producto = leer.nextLine().toUpperCase();
                            if (producto.equals("AZUCAR") || producto.equals("MAIZ") || producto.equals("AVENA") || producto.equals("TRIGO")) {
                                contadorerror = 0;
                            }
                            if (contadorerror == 1) {
                                System.out.println("Error durante su seleccion ingrese un producto valido segun su tipo de cliente");
                            }
                            contadorerror = 1;
                        }
                    }

                    if (tipocliente == 2) {
                        while (!producto.equals("AZUCAR") && !producto.equals("AVENA") && !producto.equals("TRIGO")) {
                            producto = leer.nextLine().toUpperCase();
                            if (producto.equals("AZUCAR") || producto.equals("AVENA") || producto.equals("TRIGO")) {
                                contadorerror = 0;
                            }
                            if (contadorerror == 1) {
                                System.out.println("Error durante su seleccion ingrese un producto valido segun su tipo de cliente");
                            }
                            contadorerror = 1;
                        }
                    }
                    if (tipocliente == 3) {
                        while (!producto.equals("MAIZ")) {
                            producto = leer.nextLine().toUpperCase();
                            if (producto.equals("MAIZ")) {
                                contadorerror = 0;
                            }
                            if (contadorerror == 1) {
                                System.out.println("Error durante su seleccion ingrese un producto valido segun su tipo cliente");
                            }
                            contadorerror = 1;
                        }
                    }
                    //Validacion de kg si el producto seleccion es mayor que 0 (es decir si hay productos)
                    if (producto.equals("AZUCAR") && cantidadazucar > 0) {
                        System.out.println("Ingrese la cantidad de KG a vender ");
                        cantidadkgventa = leer.nextDouble();

                    } else if (producto.equals("MAIZ") && cantidadmaiz > 0) {
                        System.out.println("Ingrese la cantidad de KG a vender ");
                        cantidadkgventa = leer.nextDouble();

                    } else if (producto.equals("AVENA") && cantidadavena > 0) {
                        System.out.println("Ingrese la cantidad de KG a vender ");
                        cantidadkgventa = leer.nextDouble();

                    } else if (producto.equals("TRIGO") && cantidadtrigo > 0) {
                        System.out.println("Ingrese la cantidad de KG a vender ");
                        cantidadkgventa = leer.nextDouble();
                    } else {
                        System.out.println("Error: No se han encontrado productos en stock");
                    }

                    //Restriccion 
                    while (cantidadkgventa < 0) {
                        System.out.println("Error: Ingrese una cantidad valida");

                        cantidadkgventa = leer.nextDouble();
                    }

                    //Venta avena 
                    if (producto.equals("AVENA") && cantidadavena > 0) {
                        //Restriccion
                        while (cantidadkgventa > cantidadavena) {
                            System.out.println("Error: Productos en stock insuficientes para la venta");
                            cantidadkgventa = leer.nextDouble();
                        }
                        //Proceso
                        cantidadavena = cantidadavena - cantidadkgventa;
                        cantidadavenaventa = cantidadavenaventa + cantidadkgventa;
                    }

                    //Venta Maiz 
                    if (producto.equals("MAIZ") && cantidadmaiz > 0) {
                        //Restriccion
                        while (cantidadkgventa > cantidadmaiz) {
                            System.out.println("Error: Productos en stock insuficientes para la venta");
                            cantidadkgventa = leer.nextDouble();
                        }
                        //Proceso
                        cantidadmaiz = cantidadmaiz - cantidadkgventa;
                        cantidadmaizventa = cantidadmaizventa + cantidadkgventa;
                    }

                    //Venta Trigo
                    if (producto.equals("TRIGO") && cantidadtrigo > 0) {
                        //Restriccion
                        while (cantidadkgventa > cantidadtrigo) {
                            System.out.println("Error: Productos en stock insuficientes para la venta");
                            cantidadkgventa = leer.nextDouble();
                        }
                        //Proceso
                        cantidadtrigo = cantidadtrigo - cantidadkgventa;
                        cantidadtrigoventa = cantidadtrigoventa + cantidadkgventa;
                    }

                    //Venta Azucar 
                    if (producto.equals("AZUCAR") && cantidadazucar > 0) {
                        //Restriccion
                        while (cantidadkgventa > cantidadazucar) {
                            System.out.println("Error: Productos en stock insuficientes para la venta");
                            cantidadkgventa = leer.nextDouble();
                        }
                        //Proceso
                        cantidadazucar = cantidadazucar - cantidadkgventa;
                        cantidadazucarventa = cantidadazucarventa + cantidadkgventa;
                    }
                    if (cantidadazucarventa == 0 && cantidadavenaventa == 0 && cantidadtrigoventa == 0 && cantidadmaizventa == 0) {
                        repetircompras = 2;
                    }
                    if (cantidadazucarventa > 0 || cantidadtrigoventa > 0 || cantidadavenaventa > 0 || cantidadmaizventa > 0) {
                        System.out.println("Desea comprar otro producto?"
                                + "\n|1|Si"
                                + "\n|2|No");
                        repetircompras = leer.nextInt();
                        while (repetircompras < 0 && repetircompras > 2) {
                            System.out.println("Error: ingrese una de las opciones en pantalla");
                            repetircompras = leer.nextInt();
                        }
                    }
                }
                //Factura
                subtotalventa = (cantidadazucarventa * 30) + (cantidadavenaventa * 25) + (cantidadtrigoventa * 32) + (cantidadmaizventa * 20);
                if (subtotalventa >= 1000) {
                    descuentoventas = 0.05;
                }
                if (subtotalventa >= 5000) {
                    descuentoventas = 0.10;
                }
                if (subtotalventa < 1000) {
                    descuentoventas = 0;
                }
                totalventas = (subtotalventa - (subtotalventa * descuentoventas) + (subtotalventa * 0.07));

                if (totalventas > 0) {
                    System.out.println("|----------------------------Facutra Comercial----------------------------|");
                    if (cantidadazucarventa > 0) {
                        System.out.println("|Azucar| " + cantidadazucarventa + "KG | 30 LPS C/U |" + (cantidadazucarventa * 30) + " Lps |");
                    }
                    if (cantidadavenaventa > 0) {
                        System.out.println("|Avena | " + cantidadavenaventa + "KG | 25 LPS C/U |" + (cantidadavenaventa * 25) + " Lps |");
                    }
                    if (cantidadmaizventa > 0) {
                        System.out.println("|Maiz  | " + cantidadmaizventa + "KG | 20 LPS C/U |" + (cantidadmaizventa * 20) + " Lps |");
                    }
                    if (cantidadtrigoventa > 0) {
                        System.out.println("|Trigo | " + cantidadtrigoventa + "KG | 32 LPS C/U |" + (cantidadtrigoventa * 32) + " Lps |");
                    }
                    System.out.println("|--------------------------------------------------------------------------|"
                            + "\nSubtotal    | " + subtotalventa + " Lps"
                            + "\nDescuento " + (descuentoventas * 100) + "%| " + (subtotalventa * descuentoventas) + " Lps"
                            + "\nImpuesto  7%| " + (subtotalventa * 0.07) + " Lps"
                            + "\n|--------------------------------------------------------------------------|"
                            + "\n Total    | " + totalventas + " Lps");
                    dinerocaja = dinerocaja + totalventas;

                    //Contadores
                    if (totalventas > mayorventa) {
                        mayorventa = totalventas;
                    }
                    contadorventastotal = contadorventastotal + totalventas;
                    contadorventaavena = contadorventaavena + cantidadavenaventa;
                    contadorventaazucar = contadorventaazucar + cantidadazucarventa;
                    contadorventamaiz = contadorventamaiz + cantidadmaizventa;
                    contadorventatrigo = contadorventatrigo + cantidadtrigoventa;
                    contadorventas = contadorventas + 1;
                }
                //Seccion errores de Opcion 2
            } else if (opcion == 2 && estadocaja.equals("cerrada")) {
                System.out.println("Error: Caja cerrada");
            } else if (opcion == 2 && estadoventa == 0) {
                System.out.println("Error: No hay productos en stock");
            }

            //Seccion de apartado de Compras
            if (opcion == 3 && estadocaja.equals("abierto") && dinerocaja > 0) {
                //ciclo
                System.out.println("Apartado de compras");
                System.out.println("Ingrese el tipo de proveedor al que desea comprar"
                        + "\n---------------------------------------------------"
                        + "\n|1|Proveedor A   | Azucar: 25 Lps |Maiz :18 Lps |"
                        + "\n|2|Proveedor B   | Avena : 20 Lps |Trigo:30 Lps |"
                        + "\n|3|Proveedor C   | Avena : 22 Lps |             |"
                        + "\n---------------------------------------------------");
                tipoproveedor = leer.nextInt();
                while (tipoproveedor < 1 || tipoproveedor > 3) {
                    System.out.println("Error: Ingrese un tipo de Proveedor valido");
                    tipoproveedor = leer.nextInt();
                }

                compraazucar = 0;
                compramaiz = 0;
                compratrigo = 0;
                compraavena = 0;
                //Proveedor tipo 1
                if (tipoproveedor == 1) {
                    System.out.println("Ingrese el producto que desea comprar \n->|1|Azucar| 25 Lps \n->|4|Maiz| 18 Lps");
                    tipocompra = leer.nextInt();
                    //Restriccion
                    while (tipocompra != 1 && tipocompra != 4) {
                        System.out.println("Error: Eliga una de las opciones mostradas en pantalla");
                        tipocompra = leer.nextInt();
                    }
                    System.out.println("Ingrese la cantidad de KG que desea comprar");
                    cantidadkg = leer.nextDouble();
                    //Restriccion
                    while (cantidadkg <= 0) {
                        System.out.println("Error: Ingrese una cantidad valida");
                        cantidadkg = leer.nextDouble();
                    }
                    //Azucar 
                    if (tipocompra == 1) {
                        compraazucar = cantidadkg * 25;
                        if (dinerocaja > compraazucar) {
                            cantidadazucar = cantidadazucar + cantidadkg;
                            contadorcompraazucar = contadorcompraazucar + cantidadkg;
                            System.out.println("Usted ha comprado un total de " + cantidadkg + "KG de Azucar" + "\nSu total es de: " + compraazucar);
                            dinerocaja = dinerocaja - compraazucar;
                            contadorcomprastotal = contadorcomprastotal + compraazucar;
                            contadorcompras = contadorcompras + 1;
                            if (compraazucar > mayorcompra) {
                                mayorcompra = compraazucar;
                            }
                        } else if (dinerocaja < compraazucar) {
                            System.out.println("Error: No se puede pagar la compra, fondos insuficientes");
                            cantidadazucar = cantidadazucar + 0;
                        }
                    }
                    //Maiz
                    if (tipocompra == 4) {
                        compramaiz = cantidadkg * 18;
                        if (dinerocaja > compramaiz) {
                            cantidadmaiz = cantidadmaiz + cantidadkg;
                            contadorcompramaiz = contadorcompramaiz + cantidadkg;
                            System.out.println("Usted ha comprado un total de " + cantidadkg + "KG de maiz" + "\nSu total es de: " + compramaiz);
                            dinerocaja = dinerocaja - compramaiz;
                            contadorcomprastotal = contadorcomprastotal + compramaiz;
                            contadorcompras = contadorcompras + 1;
                            if (compramaiz > mayorcompra) {
                                mayorcompra = compramaiz;
                            }
                        } else if (dinerocaja < compramaiz) {
                            System.out.println("Error: No se puede pagar la compra, fondos insuficientes");
                            cantidadmaiz = cantidadmaiz + 0;
                        }
                    }
                }
                //Proveedor tipo 2
                if (tipoproveedor == 2) {
                    System.out.println("Ingrese el producto que desea comprar \n->|2|Avena| 20 Lps \n->|3|Trigo| 30 Lps");
                    tipocompra = leer.nextInt();
                    //Restriccion
                    while (tipocompra != 2 && tipocompra != 3) {
                        System.out.println("Error: Eliga una de las opciones mostradas en pantalla");
                        tipocompra = leer.nextInt();
                    }
                    System.out.println("Ingrese la cantidad de KG que desea comprar");
                    cantidadkg = leer.nextDouble();
                    //Restriccion
                    while (cantidadkg <= 0) {
                        System.out.println("Error: Ingrese una cantidad valida");
                        cantidadkg = leer.nextDouble();
                    }
                    //Trigo
                    if (tipocompra == 3) {
                        compratrigo = cantidadkg * 30;
                        if (dinerocaja > compratrigo) {
                            cantidadtrigo = cantidadtrigo + cantidadkg;
                            contadorcompratrigo = contadorcompratrigo + cantidadkg;
                            System.out.println("Usted ha comprado un total de " + cantidadkg + "KG de Trigo" + "\nSu total es de: " + compratrigo);
                            dinerocaja = dinerocaja - compratrigo;
                            contadorcompras = contadorcompras + 1;
                            contadorcomprastotal = contadorcomprastotal + compratrigo;
                            if (compratrigo > mayorcompra) {
                                mayorcompra = compratrigo;
                            }
                        } else if (dinerocaja < compratrigo) {
                            System.out.println("Error: No se puede pagar la compra, fondos insuficientes");
                            cantidadtrigo = cantidadtrigo + 0;
                        }
                    }
                    //Avena
                    if (tipocompra == 2) {
                        compraavena = cantidadkg * 20;
                        if (dinerocaja > compraavena) {
                            cantidadavena = cantidadavena + cantidadkg;
                            contadorcompraavena = contadorcompraavena + cantidadkg;
                            System.out.println("Usted ha comprado un total de " + cantidadkg + "KG de Avena" + "\nSu total es de: " + compraavena);
                            dinerocaja = dinerocaja - compraavena;
                            contadorcomprastotal = contadorcomprastotal + compraavena;
                            contadorcompras = contadorcompras + 1;
                            if (compraavena > mayorcompra) {
                                mayorcompra = compraavena;
                            }
                        } else if (dinerocaja < compraavena) {
                            System.out.println("Error: No se puede pagar la compra, fondos insuficientes");
                            cantidadtrigo = cantidadtrigo + 0;
                        }
                    }
                }
                //Proveedor tipo 3
                if (tipoproveedor == 3) {
                    System.out.println("Ingrese el producto que desea comprar \n->|2|Avena| 22 Lps");
                    tipocompra = leer.nextInt();
                    //Restriccion
                    while (tipocompra != 2) {
                        System.out.println("Error: Eliga una de las opciones mostradas en pantalla");
                        tipocompra = leer.nextInt();
                    }
                    System.out.println("Ingrese la cantidad de KG que desea comprar");
                    cantidadkg = leer.nextDouble();
                    //Restriccion
                    while (cantidadkg <= 0) {
                        System.out.println("Error: Ingrese una cantidad valida");
                        cantidadkg = leer.nextDouble();
                    }
                    //Avena
                    if (tipocompra == 2) {
                        compraavena = cantidadkg * 22;
                        if (dinerocaja > compraavena) {
                            contadorcompraavena = contadorcompraavena + cantidadkg;
                            cantidadavena = cantidadavena + cantidadkg;
                            System.out.println("Usted ha comprado un total de " + cantidadkg + "KG de Avena" + "\nSu total es de: " + compraavena);
                            dinerocaja = dinerocaja - compraavena;
                            contadorcomprastotal = contadorcomprastotal + compraavena;
                            contadorcompras = contadorcompras + 1;
                            if (compraavena > mayorcompra) {
                                mayorcompra = compraavena;
                            }
                        } else if (dinerocaja < compraavena) {
                            System.out.println("Error: No se puede pagar la compra, fondos insuficientes");
                            cantidadavena = cantidadavena + 0;
                        }
                    }
                }
            }
            if (opcion == 3 && estadocaja.equals("cerrada")) {
                System.out.println("Error: Caja cerrada\nPrimero abra la caja para acceder a mas opciones :)");
            }
            

            //Seccion de apartado de Reportes
            //Selector de producto estrella 
            if (opcion == 4 && estadocaja.equals("abierto")) {    
                productoestrella = "Ninguno";
                if (contadorventamaiz > contadorventatrigo && contadorventamaiz > contadorventaavena && contadorventamaiz > contadorventaazucar) {
                    productoestrella = "Maiz";
                    mayorcantidadkgvendidos = contadorventamaiz;
                }
                if (contadorventatrigo > contadorventamaiz && contadorventatrigo > contadorventaazucar && contadorventatrigo > contadorventaavena) {
                    productoestrella = "Trigo";
                    mayorcantidadkgvendidos = contadorventatrigo;
                }
                if (contadorventaavena > contadorventatrigo && contadorventaavena > contadorventamaiz && contadorventaavena > contadorventaazucar) {
                    productoestrella = "Avena";
                    mayorcantidadkgvendidos = contadorventaavena;
                }
                if (contadorventaazucar > contadorventaavena && contadorventaazucar > contadorventatrigo && contadorventaazucar > contadorventamaiz) {
                    productoestrella = "Azucar";
                    mayorcantidadkgvendidos = contadorventaazucar;
                }

                System.out.println("Apartado de reportes");
                System.out.println("->Caja "
                        + "\n|Cantidad de dinero en caja| " + dinerocaja + " Lps");
                System.out.println("\n ->Apartado de Ventas"
                        + "\n|Cantidad de ventas         | " + contadorventas
                        + "\n|Cantidad de Maiz vendido   | " + contadorventamaiz + " KG "
                        + "\n|Cantidad de Trigo vendido  | " + contadorventatrigo + " KG "
                        + "\n|Cantidad de Azucar vendida | " + contadorventaazucar + " KG "
                        + "\n|Cantidad de Avena vendida  | " + contadorventaavena + " KG \n"
                        + "\n->Apartado de Compras"
                        + "\n|Cantidad de compras        | " + contadorcompras
                        + "\n|Cantidad de Maiz comprado  | " + contadorcompramaiz + " KG "
                        + "\n|Cantidad de Avena comprada | " + contadorcompraavena + " KG"
                        + "\n|Cantidad de Azucar comprada| " + contadorcompraazucar + " KG"
                        + "\n|Cantidad de Trigo comprado | " + contadorcompratrigo + " KG\n"
                        + "\n->Reporte total de Compras y Ventas"
                        + "\n|Ventas totales             | " + contadorventastotal + " Lps"
                        + "\n|Compras totales            | " + contadorcomprastotal + " Lps"
                        + "\n|Ganancia obtenida          | " + (contadorventastotal - ((contadorventamaiz * 18) + (contadorventatrigo * 30) + (contadorventaazucar * 25) + (contadorventaavena * 22))) + " Lps\n"
                        + "\n -> Promedio de Compras y ventas ");
                if (contadorventas > 0) {
                    System.out.println(""
                            + "\n|Promedio de ventas             | " + (contadorventastotal / contadorventas) + " Lps");
                } else {
                    System.out.println("No se han registrado ventas momentaneamente");
                }
                if (contadorcompras > 0) {
                    System.out.println(""
                            + "\n|Promedio de compras            | " + (contadorcomprastotal / contadorcompras) + " Lps");
                } else {
                    System.out.println("No se han registrado compras momentaneamente");
                }
                System.out.println("\n->Venta con mayor Ganancia \n"
                        + mayorventa + " Lps"
                        + "\n->Compra con mas Gasto \n"
                        + mayorcompra + " Lps"
                        + "\n->Producto Estrella "
                        + "\nEl Producto mas vendido en el dia es " + productoestrella);
                if (!productoestrella.equals("Ninguno")) {
                    System.out.print(" con un total de " + mayorcantidadkgvendidos + "KGS vendidos");
                }
                
                
             // Primer lugar
        if (contadorventamaiz >= contadorventatrigo && contadorventamaiz >= contadorventaavena && contadorventamaiz >= contadorventaazucar) {
            primerNombre = "Maiz";
            primerVentas = contadorventamaiz;
        } else if (contadorventatrigo >= contadorventamaiz && contadorventatrigo >= contadorventaavena && contadorventatrigo >= contadorventaazucar) {
            primerNombre = "Trigo";
            primerVentas = contadorventatrigo;
        } else if (contadorventaavena >= contadorventamaiz && contadorventaavena >= contadorventatrigo && contadorventaavena >= contadorventaazucar) {
            primerNombre = "Avena";
            primerVentas = contadorventaavena;
        } else if (contadorventaazucar >= contadorventamaiz && contadorventaazucar >= contadorventatrigo && contadorventaazucar >= contadorventaavena) {
            primerNombre = "Azucar";
            primerVentas = contadorventaazucar;
        } 

        // Segundo lugar
        if ((contadorventamaiz >= contadorventatrigo && contadorventamaiz >= contadorventaavena && contadorventamaiz >= contadorventaazucar) && !primerNombre.equals("Maiz")) {
            segundoNombre = "Maiz";
            segundoVentas = contadorventamaiz;
        } else if ((contadorventatrigo >= contadorventamaiz && contadorventatrigo >= contadorventaavena && contadorventatrigo >= contadorventaazucar ) && !primerNombre.equals("Trigo")) {
            segundoNombre = "Trigo";
            segundoVentas = contadorventatrigo;
        } else if ((contadorventaavena >= contadorventamaiz && contadorventaavena >= contadorventatrigo && contadorventaavena >= contadorventaazucar ) && !primerNombre.equals("Avena")) {
            segundoNombre = "Avena";
            segundoVentas = contadorventaavena;
        } else if ((contadorventaazucar >= contadorventamaiz && contadorventaazucar >= contadorventatrigo && contadorventaazucar >= contadorventaavena) && !primerNombre.equals("Azucar")) {
            segundoNombre = "Azucar";
            segundoVentas = contadorventaazucar;
        }
        // Tercer lugar
        if ((contadorventamaiz >= contadorventatrigo && contadorventamaiz >= contadorventaavena && contadorventamaiz >= contadorventaazucar) && !primerNombre.equals("Maiz") && !segundoNombre.equals("Maiz")) {
            tercerNombre = "Maiz";
            tercerVentas = contadorventamaiz;
        } else if ((contadorventatrigo >= contadorventamaiz && contadorventatrigo >= contadorventaavena && contadorventatrigo >= contadorventaazucar) && !primerNombre.equals("Trigo") && !segundoNombre.equals("Trigo")) {
            tercerNombre = "Trigo";
            tercerVentas = contadorventatrigo;
        } else if ((contadorventaavena >= contadorventamaiz && contadorventaavena >= contadorventatrigo && contadorventaavena >= contadorventaazucar) && !primerNombre.equals("Avena") && !segundoNombre.equals("Avena")) {
            tercerNombre = "Avena";
            tercerVentas = contadorventaavena;
        } else if ((contadorventaazucar >= contadorventamaiz && contadorventaazucar >= contadorventatrigo && contadorventaazucar >= contadorventaavena) && !primerNombre.equals("Azucar") && !segundoNombre.equals("Azucar")) {
            tercerNombre = "Azucar";
            tercerVentas = contadorventaazucar;
        } 

        // Cuarto lugar
        if ((contadorventamaiz >= contadorventatrigo && contadorventamaiz >= contadorventaavena && contadorventamaiz >= contadorventaazucar) && !primerNombre.equals("Maiz") && !segundoNombre.equals("Maiz") && !tercerNombre.equals("Maiz")) {
            cuartoNombre = "Maiz";
            cuartoVentas = contadorventamaiz;
        } else if ((contadorventatrigo >= contadorventamaiz && contadorventatrigo >= contadorventaavena && contadorventatrigo >= contadorventaazucar) && !primerNombre.equals("Trigo") && !segundoNombre.equals("Trigo") && !tercerNombre.equals("Trigo")) {
            cuartoNombre = "Trigo";
            cuartoVentas = contadorventatrigo;
        } else if ((contadorventaavena >= contadorventamaiz && contadorventaavena >= contadorventatrigo && contadorventaavena >= contadorventaazucar) && !primerNombre.equals("Avena") && !segundoNombre.equals("Avena") && !tercerNombre.equals("Avena")) {
            cuartoNombre = "Avena";
            cuartoVentas = contadorventaavena;
        } else if ((contadorventaazucar >= contadorventamaiz && contadorventaazucar >= contadorventatrigo && contadorventaazucar >= contadorventaavena) && !primerNombre.equals("Azucar") && !segundoNombre.equals("Azucar") && !tercerNombre.equals("Azucar")) {
            cuartoNombre = "Azucar";
            cuartoVentas = contadorventaazucar;
        } 
                
        System.out.println("Ranking de Productos Más Vendidos:");
        System.out.println("1. " + primerNombre + " - Ventas: " + primerVentas);
        System.out.println("2. " + segundoNombre + " - Ventas: " + segundoVentas);
        System.out.println("3. " + tercerNombre + " - Ventas: " + tercerVentas);
        System.out.println("4. " + cuartoNombre + " - Ventas: " + cuartoVentas);
  

            } else if (opcion == 4 && estadocaja.equals("cerrada")) {
                System.out.println("Error: Caja cerrada");
            }
            //Cierre de sesion
            if (opcion == 5) {

                if (estadocaja == "cerrada") {
                    System.out.println("Error: Actualmente la caja ya se encuentra cerrada");
                }

                if (dinerocaja == 0 && !estadocaja.equals("cerrada")) {
                    System.out.println("|----------Caja Cerrada----------|");
                }

                estadocaja = "cerrada";
                if (dinerocaja > 0) {
                    System.out.println("|----------Caja Cerrada----------|"
                            + "\nActualmente hay un total de " + dinerocaja + " Lps en caja"
                            + "\nIngrese cuanto dinero desea depositar en el banco (Cantidad maxima a depositar: " + ((dinerocaja * 60) / 100) + ")");
                    dineroadepositar = leer.nextDouble();
                    while (dineroadepositar < 0) {
                        System.out.println("Error: Ingrese un numero valido");
                        dineroadepositar = leer.nextDouble();
                    }

                    dinerodepositado = (dineroadepositar * 100) / dinerocaja;
                    if (dinerodepositado >= 60) {
                        dineroadepositar = ((dinerocaja * 60) / 100);
                    }
                    dinerocaja = dinerocaja - dineroadepositar;

                    System.out.println("Dinero depositado: " + dineroadepositar + " Lps"
                            + "\n Dinero restante en caja:" + dinerocaja + " Lps");
                }

                //Reinicio de contadores
                contadorventatrigo = 0;
                contadorventamaiz = 0;
                contadorventaavena = 0;
                contadorventaazucar = 0;
                contadorcompratrigo = 0;
                contadorcompramaiz = 0;
                contadorcompraavena = 0;
                contadorcompraazucar = 0;
                contadorventastotal = 0;
                contadorcomprastotal = 0;
                contadorventas = 0;
                contadorcompras = 0;
                mayorventa = 0;
                mayorcompra = 0;
                productoestrella = "";
            }

        } //fin del ciclo que repite todo el sistema
            System.out.println("Cierre de sesion");
            //finalgoritmo
        }

    
}
