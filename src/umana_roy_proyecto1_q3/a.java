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
public class a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);

        int Menu = 0, ProductoCompra = 0, ProductoVenta = 0, CantidadProducto = 0, ContadorCaja = 0;
        String EstadoDeCaja = "Cerrado", TipoDeCliente = "", Proveedor = "", ContinuarComprando = "", LlevarDeTodosModos = "";
        double DineroBanco = 0, DineroCaja = 0, DineroRestante = 0;
        int StockAzucar = 0, StockAvena = 0, StockTrigo = 0, StockMaiz = 0;
        boolean SePuedeComprar = true;
        double VentaMasAlta = 0, CompraMasAlta = 0, DescuentoLps = 0;
        int NumeroDeCompras = 0, NumeroDeVentas = 0, TotalVentas = 0, TotalCompras = 0;
        int VentasAzucar = 0, VentasAvena = 0, VentasTrigo = 0, VentasMaiz = 0;

        //Tipo Portadada
        System.out.println("|------------------------------------------------------|");
        System.out.println("|                 ****PORTADA****                      |");
        System.out.println("|PROGRAMA CREADO POR: Steve David Valladares Hernandez |");
        System.out.println("|Projecto Primer Parcial: Tienda                       |");
        System.out.println("|Numero de Cuenta: 22341344                            |");
        System.out.println("|Docente: Ing. Erick Amaya                             |");
        System.out.println("|Clase: Programacion I (CCC104)                        |");
        System.out.println("|Seccion: 106 (2:40pm)                                 |");
        System.out.println("|Fecha de Entrega: Semana: 5 | 13/8/2024               |");
        System.out.println("|------------------------------------------------------|");

        do {
            System.out.println(""); //Los Sout indentados representan que estan ahi por estetica del Programa
            System.out.println("|----------------------|");
            System.out.println("|       **MENU**       |");
            System.out.println("| 1) Abir Caja         |");
            System.out.println("| 2) Ventas            |");
            System.out.println("| 3) Compras           |");
            System.out.println("| 4) Reportes          |");
            System.out.println("| 5) Cierre de Caja    |");
            System.out.println("| 6) Salir del Sistema |");
            System.out.println("|----------------------|");
            System.out.println("");
            System.out.println("Ingrese Un Numero Acorde a la Tabla");
            Menu = lea.nextInt();
            System.out.println("");
            while (Menu >= 7 || Menu <= 0) {
                System.out.println("ERROR: ingrese un numero entre 1 y 6");
                Menu = lea.nextInt();
                System.out.println("");
            }

            if (Menu == 1) { //Abir Caja
                if (EstadoDeCaja.equals("Abierto")) {
                    System.out.println("Elija una Cantidad de Efectico (Lps.) para Agregar a la Caja");
                    DineroCaja += lea.nextInt();
                }

                if (EstadoDeCaja.equals("Cerrado") && ContadorCaja == 1) {

                    System.out.println("*La Caja se Ha Abierto*");
                    System.out.println("");
                    System.out.println("-----------------------------");
                    System.out.println("Dinero en Caja: " + DineroCaja + " Lps.");
                    System.out.println("");
                    System.out.println("Inventario Restante:");
                    System.out.println("Azucar: " + StockAzucar + " kg");
                    System.out.println("Avena: " + StockAvena + " kg");
                    System.out.println("Trigo: " + StockTrigo + " kg");
                    System.out.println("Maiz: " + StockMaiz + " kg");
                    System.out.println("-----------------------------");
                    EstadoDeCaja = "Abierto";
                }

                if (EstadoDeCaja.equals("Cerrado") && ContadorCaja == 0) {
                    System.out.println("Bienvenido!!");
                    System.out.println("*La Caja se Ha Abierto*");
                    System.out.println("");
                    EstadoDeCaja = "Abierto";
                    System.out.println("Elija una Cantidad de Efectico (Lps.) para Agregar a la Caja");
                    DineroCaja += lea.nextInt();
                    ContadorCaja = 1; // unicamente leera esta condicion la primera vez, luego ira a la otra.
                }
            }

            if (Menu == 2 && EstadoDeCaja.equals("Abierto")) { //Ventas
                int CantidadAzucar = 0, CantidadAvena = 0, CantidadTrigo = 0, CantidadMaiz = 0; //Iniciar y reiniciar Variables
                String ProductoSalida = "";
                double Subtotal = 0, Total = 0;
                double Descuento = 0, Impuesto = 0;

                System.out.println("Ingrese que Tipo de Cliente es Usted (A,B,C)");
                TipoDeCliente = lea.next().toUpperCase();
                while (!TipoDeCliente.equals("A") && !TipoDeCliente.equals("B") && !TipoDeCliente.equals("C")) {
                    System.out.println("ERROR, elija un tipo de Cliente Correcto (A, B, C)");
                    TipoDeCliente = lea.next().toUpperCase();
                }

                do {
                    if (TipoDeCliente.equals("A")) {
                        System.out.println("");
                        System.out.println("| Codigo | Producto | Precio Venta |");
                        System.out.println("|   1    | Azucar   |    Lps. 30   |");
                        System.out.println("|   2    | Avena    |    Lps. 25   |");
                        System.out.println("|   3    | Trigo    |    Lps.32    |");
                        System.out.println("|   4    | Maiz     |    Lps.20    |");
                    }
                    if (TipoDeCliente.equals("B")) {
                        System.out.println("");
                        System.out.println("| Codigo | Producto | Precio Venta |");
                        System.out.println("|   1    | Azucar   |    Lps. 30   |");
                        System.out.println("|   2    | Avena    |    Lps. 25   |");
                        System.out.println("|   3    | Trigo    |    Lps.32    |");
                    }
                    if (TipoDeCliente.equals("C")) {
                        System.out.println("");
                        System.out.println("|   4    | Maiz     |    Lps.20    |");
                    }

                    System.out.println("");
                    System.out.println("Elija el Producto que desea comprar acorde a Su Numero en la Tabla");
                    ProductoVenta = lea.nextInt();

                    while (ProductoVenta <= 0 || ProductoVenta >= 5) {
                        System.out.println("ERROR, ingrese un producto Valido acorde a la Tabla");
                        ProductoVenta = lea.nextInt();
                    }

                    //Igualar el Codigo Numeral con un String el nombre del producto que le Corresponde
                    if (ProductoVenta == 1) {
                        ProductoSalida = "Azucar";
                    } else if (ProductoVenta == 2) {
                        ProductoSalida = "Avena";
                    } else if (ProductoVenta == 3) {
                        ProductoSalida = "Trigo";
                    } else if (ProductoVenta == 4) {
                        ProductoSalida = "Maiz";
                    }

                    if (TipoDeCliente.equals("A")) {
                        SePuedeComprar = true;
                        //Se reinicia a ser True, en caso de que quede guardada la variable como "false" por una compra previa, ya que el Clietne tipo A puede comprar todos los Productos
                    }

                    if (TipoDeCliente.equals("B")) {
                        if (ProductoVenta == 1 || ProductoVenta == 2 || ProductoVenta == 3) {
                            SePuedeComprar = true;

                        } else {
                            if (ProductoVenta == 4) {
                                SePuedeComprar = false;
                            }
                            System.out.println("El tipo de Cliente: " + TipoDeCliente + " no puede Comprar el Producto: " + ProductoSalida);

                        }

                    }

                    if (TipoDeCliente.equals("C")) {
                        if (ProductoVenta == 4) {
                            SePuedeComprar = true;

                        } else {
                            if (ProductoVenta == 1 || ProductoVenta == 2 || ProductoVenta == 3) {
                                SePuedeComprar = false;
                            }
                            System.out.println("El tipo de Cliente: " + TipoDeCliente + " no puede Comprar el Producto: " + ProductoSalida);

                        }

                    }

                    //Pedir Cuanto va a Comprar
                    if (SePuedeComprar == true) {
                        System.out.println("Ingrese la Cantidad en Kilogramos de " + ProductoSalida + " que desea Comprar");
                        CantidadProducto = lea.nextInt();
                        while (CantidadProducto < 0) {
                            System.out.println("Seleccione un Numero Valido de Producto a Comprar");
                            CantidadProducto = lea.nextInt();
                        }

                        //COMPARAR lo pedido con el Usuario, con nuestro Inventario
                        if (ProductoVenta == 1) {
                            if (StockAzucar == 0) {
                                System.out.println("No se tiene " + ProductoSalida + " en el Inventario");
                                SePuedeComprar = false;
                            }
                            if (CantidadProducto > StockAzucar && StockAzucar != 0) {
                                System.out.println("En inventario hay unicamente: " + StockAzucar + " Kg de " + ProductoSalida);
                                System.out.println("Desea Llevar los " + StockAzucar + " Kg (Si), o desea no realizar la compra (No)");
                                LlevarDeTodosModos = lea.next().toUpperCase();
                                while (!LlevarDeTodosModos.equals("SI") && !LlevarDeTodosModos.equals("NO")) {
                                    System.out.println("Porfavor Ingrese una opcion valida, (Si, o No)");
                                    LlevarDeTodosModos = lea.next().toUpperCase();
                                }
                                if (LlevarDeTodosModos.equals("SI")) {
                                    CantidadProducto = StockAzucar;

                                } else if (LlevarDeTodosModos.equals("No")) {
                                    SePuedeComprar = false;
                                    CantidadProducto = 0;
                                }

                            }
                        }

                        if (ProductoVenta == 2) {
                            if (StockAvena == 0) {
                                System.out.println("No se tiene " + ProductoSalida + " en el Inventario");
                                SePuedeComprar = false;
                            }
                            if (CantidadProducto > StockAvena && StockAvena != 0) {
                                System.out.println("En inventario hay unicamente: " + StockAvena + " Kg de " + ProductoSalida);
                                System.out.println("Desea Llevar los " + StockAvena + " Kg (Si), o desea no realizar la compra (No)");
                                LlevarDeTodosModos = lea.next().toUpperCase();
                                while (!LlevarDeTodosModos.equals("SI") && !LlevarDeTodosModos.equals("NO")) {
                                    System.out.println("Porfavor Ingrese una opcion valida, (Si, o No)");
                                    LlevarDeTodosModos = lea.next().toUpperCase();
                                }
                                if (LlevarDeTodosModos.equals("SI")) {
                                    CantidadProducto = StockAvena;

                                } else if (LlevarDeTodosModos.equals("No")) {
                                    SePuedeComprar = false;
                                    CantidadProducto = 0;
                                }

                            }
                        }

                        if (ProductoVenta == 3) {
                            if (StockTrigo == 0) {
                                System.out.println("No se tiene " + ProductoSalida + " en el Inventario");
                                SePuedeComprar = false;
                            }
                            if (CantidadProducto > StockTrigo && StockTrigo != 0) {
                                System.out.println("En inventario hay unicamente: " + StockTrigo + " Kg de " + ProductoSalida);
                                System.out.println("Desea Llevar los " + StockTrigo + " Kg (Si), o desea no realizar la compra (No)");
                                LlevarDeTodosModos = lea.next().toUpperCase();
                                while (!LlevarDeTodosModos.equals("SI") && !LlevarDeTodosModos.equals("NO")) {
                                    System.out.println("Porfavor Ingrese una opcion valida, (Si, o No)");
                                    LlevarDeTodosModos = lea.next().toUpperCase();
                                }
                                if (LlevarDeTodosModos.equals("SI")) {
                                    CantidadProducto = StockTrigo;

                                } else if (LlevarDeTodosModos.equals("No")) {
                                    SePuedeComprar = false;
                                    CantidadProducto = 0;
                                }

                            }

                        }

                        if (ProductoVenta == 4) {
                            if (StockMaiz == 0) {
                                System.out.println("No se tiene " + ProductoSalida + " en el Inventario");
                                SePuedeComprar = false;
                            }
                            if (CantidadProducto > StockMaiz && StockMaiz != 0) {
                                System.out.println("En inventario hay unicamente: " + StockMaiz + " Kg de " + ProductoSalida);
                                System.out.println("Desea Llevar los " + StockMaiz + " Kg (Si), o desea no realizar la compra (No)");
                                LlevarDeTodosModos = lea.next().toUpperCase();
                                while (!LlevarDeTodosModos.equals("SI") && !LlevarDeTodosModos.equals("NO")) {
                                    System.out.println("Porfavor Ingrese una opcion valida, (Si, o No)");
                                    LlevarDeTodosModos = lea.next().toUpperCase();
                                }

                                if (LlevarDeTodosModos.equals("SI")) {
                                    CantidadProducto = StockMaiz;

                                } else if (LlevarDeTodosModos.equals("No")) {
                                    SePuedeComprar = false;
                                    CantidadProducto = 0;

                                }

                            }
                        }

                    }

                    //Sumar la Cantidad de Productos Comprados para realizar Facturacion
                    //Sumar las veces que se compra cada Producto para Ranking (Unicamente si comprar=true, osea solo si se realiza la venta
                    if (SePuedeComprar == true) {
                        if (ProductoVenta == 1) {
                            CantidadAzucar += CantidadProducto;
                            VentasAzucar++;
                            StockAzucar -= CantidadProducto;
                        } else if (ProductoVenta == 2) {
                            CantidadAvena += CantidadProducto;
                            VentasAvena++;
                            StockAvena -= CantidadProducto;
                        } else if (ProductoVenta == 3) {
                            CantidadTrigo += CantidadProducto;
                            VentasTrigo++;
                            StockTrigo -= CantidadProducto;
                        } else if (ProductoVenta == 4) {
                            CantidadMaiz += CantidadProducto;
                            VentasMaiz++;
                            StockMaiz -= CantidadProducto;
                        }
                    }

                    System.out.println("Desea comprar otro producto? (si o no)");
                    ContinuarComprando = lea.next().toUpperCase();
                    while (!ContinuarComprando.equals("SI") && !ContinuarComprando.equals("NO")) {
                        System.out.println("Porfavor Ingrese una opcion valida, (Si, o No)");
                        ContinuarComprando = lea.next().toUpperCase();
                    }
                } while (!ContinuarComprando.equals("NO"));

                //Calculos Subtotal - Impuestos - Etc
                Subtotal = (CantidadAzucar * 30) + (CantidadAvena * 25) + (CantidadTrigo * 32) + (CantidadMaiz * 20);
                Impuesto = Subtotal * 0.07;

                //Descuentos
                if (Subtotal >= 1000) { //Si el subtotal es mayor o igual que 1000 lps  | Descuento: 5% 
                    Descuento = 0.05;
                }
                if (Subtotal > 5000) { //Si el subtotal es mayor que 5000 lps         | Descuento: 10% 
                    Descuento = 0.1;
                }
                if (Subtotal < 1000) { //Menor que 1000 lps                            | No aplica Descuento
                    Descuento = 0;
                }
                DescuentoLps = Subtotal * Descuento;

                //Redondeos
                double Redondeo = Math.pow(10, 2);
                Impuesto = Math.ceil(Impuesto * Redondeo) / Redondeo;
                DescuentoLps = Math.ceil(DescuentoLps * Redondeo) / Redondeo;

                Total = Subtotal + Impuesto - DescuentoLps;

                if (Total > 0) { //Unicamente Muestra la factura si se compro algun producto (Si el total es 0, osea no compro, no lo muestra).
                    //Facturacion
                    NumeroDeVentas++;
                    System.out.println("--------------------------------------");
                    System.out.println("            ***FACTURA***");
                    System.out.println("Tipo de Cliente: " + TipoDeCliente);
                    System.out.println("");
                    System.out.println("Azucar");
                    System.out.println("   Cantidad: " + CantidadAzucar);
                    System.out.println("   Precio Unitario: Lps. 30");
                    System.out.println("Avena");
                    System.out.println("   Cantidad: " + CantidadAvena);
                    System.out.println("   Precio Unitario: Lps. 25");
                    System.out.println("Trigo");
                    System.out.println("   Cantidad: " + CantidadTrigo);
                    System.out.println("   Precio Unitario: Lps. 32");
                    System.out.println("Maiz");
                    System.out.println("   Cantidad: " + CantidadMaiz);
                    System.out.println("   Precio Unitario: Lps. 20");
                    System.out.println("");
                    System.out.println("Subtotal: Lps. " + Subtotal);
                    System.out.println("Impuesto 7%: Lps. " + Impuesto);
                    System.out.println("Descuento: " + Descuento * 100 + "%");
                    System.out.println("Descuento en Lempiras: Lps. " + DescuentoLps);
                    System.out.println("Total: " + Total);
                    System.out.println("-------------------------------------");
                    DineroCaja += Total;
                    NumeroDeVentas++;
                    TotalVentas += Total;
                }
                //Registro Para Ranking 

                if (Total > VentaMasAlta) {
                    VentaMasAlta = Total;
                }

            }

            if (Menu == 3 && EstadoDeCaja.equals("Abierto")) { // Compras
                String ProductoSalida = "";
                int PrecioCompra = 0;
                int Total = 0;
                System.out.println("-----------------------------");
                System.out.println("Dinero en Caja: " + DineroCaja + " Lps.");
                System.out.println("----------------------------");
                System.out.println("");
                System.out.println("| Codigo |   Producto   |  Precio Compra  |");
                System.out.println("|   1    | Azucar (A)   |     Lps. 25     |");
                System.out.println("|   2    | Avena  (B/C) | Lps.(B)20 (C)22 |");
                System.out.println("|   3    | Trigo  (B)   |     Lps.30      |");
                System.out.println("|   4    | Maiz   (A)   |     Lps.18      |");
                System.out.println("");
                System.out.println("Ingrese a que Tipo de Proveedor desesa comprarle (A,B,C)");
                Proveedor = lea.next().toUpperCase();
                while (!Proveedor.equals("A") && !Proveedor.equals("B") && !Proveedor.equals("C")) {
                    System.out.println("ERROR, elija un Proveedor Correcto (A, B, C)");
                    Proveedor = lea.next().toUpperCase();
                }

                System.out.println("Seleccione que Producto desea comprar acorde su codigo");
                ProductoCompra = lea.nextInt();
                while (ProductoCompra < 1 && ProductoCompra > 4) {
                    System.out.println("Seleccione un Codigo de Producto acorde a la tabla (del 1 al 4)");
                    ProductoCompra = lea.nextInt();
                }

                //Igualar el Codigo Numeral con un String el nombre del producto que le Corresponde
                if (ProductoCompra == 1) {
                    ProductoSalida = "Azucar";
                } else if (ProductoCompra == 2) {
                    ProductoSalida = "Avena";
                } else if (ProductoCompra == 3) {
                    ProductoSalida = "Trigo";
                } else if (ProductoCompra == 4) {
                    ProductoSalida = "Maiz";
                }

                //A - 1 4 | B 2 3 | C 2 | 
                if (Proveedor.equals("A")) {
                    if (ProductoCompra == 1 || ProductoCompra == 4) {
                        SePuedeComprar = true;

                    } else {
                        if (ProductoCompra == 3 || ProductoCompra == 2) {
                            SePuedeComprar = false;
                        }
                        System.out.println("El Proveedor " + Proveedor + " no posee el Producto: " + ProductoSalida);
                    }
                } else if (Proveedor.equals("B")) {
                    if (ProductoCompra == 2 || ProductoCompra == 3) {
                        SePuedeComprar = true;

                    } else {
                        if (ProductoCompra == 4 || ProductoCompra == 1) {
                            SePuedeComprar = false;
                        }
                        System.out.println("El Proveedor " + Proveedor + " no posee el Producto: " + ProductoSalida);
                    }
                } else if (Proveedor.equals("C")) {
                    if (ProductoCompra == 2) {
                        SePuedeComprar = true;

                    } else {
                        if (ProductoCompra == 4 || ProductoCompra == 2 || ProductoCompra == 1) {
                            SePuedeComprar = false;
                        }
                        System.out.println("El Proveedor " + Proveedor + " no vende el producto: " + ProductoSalida);
                    }
                }

                if (SePuedeComprar == true) {
                    System.out.println("Ingrese la Cantidad en Kilogramos de " + ProductoSalida + " que desea comprarle al Proveedor: " + Proveedor);
                    CantidadProducto = lea.nextInt();
                    while (CantidadProducto < 1) {
                        System.out.println("Seleccione un Numero Valido de Producto a Comprar");
                        CantidadProducto = lea.nextInt();
                    }

                    //Calcular las Variables de las Compras
                    if (ProductoCompra == 1) {
                        PrecioCompra = 25;
                    } else if (ProductoCompra == 2 && Proveedor.equals("B")) {
                        PrecioCompra = 20;
                    } else if (ProductoCompra == 2 && Proveedor.equals("C")) {
                        PrecioCompra = 22;
                    } else if (ProductoCompra == 3) {
                        PrecioCompra = 30;
                    } else if (ProductoCompra == 4) {
                        PrecioCompra = 18;
                    }

                    Total = PrecioCompra * CantidadProducto;

                    if (Total <= DineroCaja) {
                        System.out.println("-----------------------------");
                        System.out.println("         **FACTURA**");
                        System.out.println("Proveedor: " + Proveedor);
                        System.out.println("   Producto: " + ProductoSalida);
                        System.out.println("   Cantidad: " + CantidadProducto + " kg");
                        System.out.println("   Precio Unitario: Lps. " + PrecioCompra);
                        System.out.println("Total: " + Total);
                        System.out.println("-----------------------------");

                        DineroCaja -= Total;
                        NumeroDeCompras++;
                        TotalCompras += Total;

                        //Sumar lo comprado al Stock que tenemos
                        if (ProductoCompra == 1) {
                            StockAzucar += CantidadProducto;
                        }
                        if (ProductoCompra == 2) {
                            StockAvena += CantidadProducto;
                        }
                        if (ProductoCompra == 3) {
                            StockTrigo += CantidadProducto;
                        }
                        if (ProductoCompra == 4) {
                            StockMaiz += CantidadProducto;
                        }

                    } else {
                        System.out.println("DINERO INSUFICIENTE: No se puede Pagar la Compra");
                    }

                }

                if (Total > CompraMasAlta) {
                    CompraMasAlta = Total;
                }

            }

            if (Menu == 4) { //Reportes

                //RANKING (Rank 1 = Producto Estrella)
                int Ranking1, Ranking2, Ranking3, Ranking4;
                String ProducRank1 = "", ProducRank2 = "", ProducRank3 = "", ProducRank4 = "";
                if (VentasAzucar > VentasAvena && VentasAzucar > VentasTrigo && VentasAzucar > VentasMaiz) {
                    Ranking1 = VentasAzucar;
                    ProducRank1 = "Azucar";
                    if (VentasAvena > VentasTrigo && VentasAvena > VentasMaiz) {
                        Ranking2 = VentasAvena;
                        ProducRank2 = "Avena";
                        if (VentasTrigo > VentasMaiz) {
                            Ranking3 = VentasTrigo;
                            ProducRank3 = "Trigo";
                            Ranking4 = VentasMaiz;
                            ProducRank4 = "Maiz";
                        } else {
                            Ranking3 = VentasMaiz;
                            ProducRank3 = "Maiz";
                            Ranking4 = VentasTrigo;
                            ProducRank4 = "Trigo";
                        }
                    } else if (VentasTrigo > VentasAvena && VentasTrigo > VentasMaiz) {
                        Ranking2 = VentasTrigo;
                        ProducRank2 = "Trigo";
                        if (VentasAvena > VentasMaiz) {
                            Ranking3 = VentasAvena;
                            ProducRank3 = "Avena";
                            Ranking4 = VentasMaiz;
                            ProducRank4 = "Maiz";
                        } else {
                            Ranking3 = VentasMaiz;
                            ProducRank3 = "Maiz";
                            Ranking4 = VentasAvena;
                            ProducRank4 = "Avena";
                        }
                    } else {
                        Ranking2 = VentasMaiz;
                        ProducRank2 = "Maiz";
                        if (VentasAvena > VentasTrigo) {
                            Ranking3 = VentasAvena;
                            ProducRank3 = "Avena";
                            Ranking4 = VentasTrigo;
                            ProducRank4 = "Trigo";
                        } else {
                            Ranking3 = VentasTrigo;
                            ProducRank3 = "Trigo";
                            Ranking4 = VentasAvena;
                            ProducRank4 = "Avena";
                        }
                    }
                } else if (VentasAvena > VentasAzucar && VentasAvena > VentasTrigo && VentasAvena > VentasMaiz) {
                    Ranking1 = VentasAvena;
                    ProducRank1 = "Avena";
                    if (VentasAzucar > VentasTrigo && VentasAzucar > VentasMaiz) {
                        Ranking2 = VentasAzucar;
                        ProducRank2 = "Azucar";
                        if (VentasTrigo > VentasMaiz) {
                            Ranking3 = VentasTrigo;
                            ProducRank3 = "Trigo";
                            Ranking4 = VentasMaiz;
                            ProducRank4 = "Maiz";
                        } else {
                            Ranking3 = VentasMaiz;
                            ProducRank3 = "Maiz";
                            Ranking4 = VentasTrigo;
                            ProducRank4 = "Trigo";
                        }
                    } else if (VentasTrigo > VentasAzucar && VentasTrigo > VentasMaiz) {
                        Ranking2 = VentasTrigo;
                        if (VentasAzucar > VentasMaiz) {
                            Ranking3 = VentasAzucar;
                            ProducRank3 = "Azucar";
                            Ranking4 = VentasMaiz;
                            ProducRank4 = "Maiz";
                        } else {
                            Ranking3 = VentasMaiz;
                            ProducRank3 = "Maiz";
                            Ranking4 = VentasAzucar;
                            ProducRank4 = "Azucar";
                        }
                    } else {
                        Ranking2 = VentasMaiz;
                        ProducRank2 = "Maiz";
                        if (VentasAzucar > VentasTrigo) {
                            Ranking3 = VentasAzucar;
                            ProducRank3 = "Azucar";
                            Ranking4 = VentasTrigo;
                            ProducRank4 = "Trigo";
                        } else {
                            Ranking3 = VentasTrigo;
                            ProducRank3 = "Trigo";
                            Ranking4 = VentasAzucar;
                            ProducRank4 = "Azucar";
                        }
                    }
                } else if (VentasTrigo > VentasAzucar && VentasTrigo > VentasAvena && VentasTrigo > VentasMaiz) {
                    Ranking1 = VentasTrigo;
                    ProducRank1 = "Trigo";
                    if (VentasAzucar > VentasAvena && VentasAzucar > VentasMaiz) {
                        Ranking2 = VentasAzucar;
                        ProducRank2 = "Azucar";
                        if (VentasAvena > VentasMaiz) {
                            Ranking3 = VentasAvena;
                            ProducRank3 = "Avena";
                            Ranking4 = VentasMaiz;
                            ProducRank4 = "Maiz";
                        } else {
                            Ranking3 = VentasMaiz;
                            ProducRank3 = "Maiz";
                            Ranking4 = VentasAvena;
                            ProducRank4 = "Avena";
                        }
                    } else if (VentasAvena > VentasAzucar && VentasAvena > VentasMaiz) {
                        Ranking2 = VentasAvena;
                        ProducRank2 = "Avena";
                        if (VentasAzucar > VentasMaiz) {
                            Ranking3 = VentasAzucar;
                            ProducRank3 = "Azucar";
                            Ranking4 = VentasMaiz;
                            ProducRank4 = "Maiz";
                        } else {
                            Ranking3 = VentasMaiz;
                            ProducRank3 = "Maiz";
                            Ranking4 = VentasAzucar;
                            ProducRank4 = "Azucar";
                        }
                    } else {
                        Ranking2 = VentasMaiz;
                        ProducRank2 = "Maiz";
                        if (VentasAzucar > VentasAvena) {
                            Ranking3 = VentasAzucar;
                            ProducRank3 = "Azucar";
                            Ranking4 = VentasAvena;
                            ProducRank4 = "Avena";
                        } else {
                            Ranking3 = VentasAvena;
                            ProducRank3 = "Avena";
                            Ranking4 = VentasAzucar;
                            ProducRank4 = "Azucar";
                        }
                    }
                } else {
                    Ranking1 = VentasMaiz;
                    ProducRank1 = "Maiz";
                    if (VentasAzucar > VentasAvena && VentasAzucar > VentasTrigo) {
                        Ranking2 = VentasAzucar;
                        ProducRank2 = "Azucar";
                        if (VentasAvena > VentasTrigo) {
                            Ranking3 = VentasAvena;
                            ProducRank3 = "Avena";
                            Ranking4 = VentasTrigo;
                            ProducRank4 = "Trigo";
                        } else {
                            Ranking3 = VentasTrigo;
                            ProducRank3 = "Trigo";
                            Ranking4 = VentasAvena;
                            ProducRank4 = "Avena";
                        }
                    } else if (VentasAvena > VentasAzucar && VentasAvena > VentasTrigo) {
                        Ranking2 = VentasAvena;
                        ProducRank2 = "Avena";
                        if (VentasAzucar > VentasTrigo) {
                            Ranking3 = VentasAzucar;
                            ProducRank3 = "Azucar";
                            Ranking4 = VentasTrigo;
                            ProducRank4 = "Trigo";
                        } else {
                            Ranking3 = VentasTrigo;
                            ProducRank3 = "Trigo";
                            Ranking4 = VentasAzucar;
                            ProducRank4 = "Azucar";
                        }
                    } else {
                        Ranking2 = VentasTrigo;
                        ProducRank2 = "Trigo";
                        if (VentasAzucar > VentasAvena) {
                            Ranking3 = VentasAzucar;
                            ProducRank3 = "Azucar";
                            Ranking4 = VentasAvena;
                            ProducRank4 = "Avena";
                        } else {
                            Ranking3 = VentasAvena;
                            ProducRank3 = "Avena";
                            Ranking4 = VentasAzucar;
                            ProducRank4 = "Azucar";
                        }
                    }
                }

                double Ganancia = TotalVentas - TotalCompras;

                System.out.println("-------------------------------------------------------------");
                System.out.println("                    ***REPORTES***");
                System.out.println("------");
                System.out.println("DINERO");
                System.out.println("------");
                System.out.println("  Dinero Actual en Caja: " + DineroCaja + " Lps.");
                System.out.println("  Dinero Almacenado en el Banco: " + DineroBanco + " Lps.");

                System.out.println("");

                System.out.println("--------------------------");
                System.out.println("COMPRAS Y VENTAS EN EL DIA");
                System.out.println("--------------------------");
                System.out.println("Numero de Compras Realizadas: " + NumeroDeCompras);
                System.out.println("Numero de Ventas Realizadas:  " + NumeroDeVentas);

                System.out.println("");

                System.out.println("------------------------------");
                System.out.println("VOLUMEN TOTAL COMPRAS & VENTAS");
                System.out.println("------------------------------");
                System.out.println("Dinero Ingresado por Ventas: " + TotalVentas);
                System.out.println("Dinero Invertido en Compras: " + TotalCompras);
                if (Ganancia >= 0) {
                    System.out.println("Margen de Ganancia: " + Ganancia);
                } else {
                    System.out.println("Margen de Perdida: " + Ganancia);
                }

                System.out.println("");

                System.out.println("---------------");
                System.out.println("MAYORES TOTALES");
                System.out.println("---------------");
                System.out.println("  La venta que Mayor Ganancia recaudo " + VentaMasAlta + " Lps.");
                System.out.println("  La compra con Mayor dinero invertido fue de: " + CompraMasAlta + " Lps.");

                System.out.println("");

                System.out.println("-----------------");
                System.out.println("PRODUCTO ESTRELLA");
                System.out.println("-----------------");
                System.out.println("  El Producto Estrella fue: " + ProducRank1);
                System.out.println("  Con: " + Ranking1 + " ventas realizadas en el dia.");

                System.out.println("");

                System.out.println("----------------------------");
                System.out.println("RANKING");
                System.out.println("1) " + ProducRank1 + ": Numero de Ventas " + Ranking1);
                System.out.println("2) " + ProducRank2 + ": Numero de Ventas " + Ranking2);
                System.out.println("3) " + ProducRank3 + ": Numero de Ventas " + Ranking3);
                System.out.println("4) " + ProducRank4 + ": Numero de Ventas " + Ranking4);
                System.out.println("----------------------------");
                System.out.println("");

                System.out.println("-------------------------------------------------------------");

            }

            //En Caso de Tener Caja Cerrada
            //Colocado Arriba del Cierre de caja, para que al cerrar la caja no lea este codigo, y haga la salida de pantalla unicamente cuanto este previamente cerrada
            if (Menu == 2 || Menu == 3 || Menu == 5) {
                if (EstadoDeCaja.equals("Cerrado")) {
                    System.out.println("|--------------------------------------------------------|");
                    System.out.println("| No se puede Realizar esta Accion, la Caja esta Cerrada |");
                    System.out.println("|--------------------------------------------------------|");
                }
            }

            if (Menu == 5 && EstadoDeCaja.equals("Abierto")) { //Cierre de Caja
                EstadoDeCaja = "Cerrado"; //Cambiar el estado de Caja
                double DepositoBanco = 0;
                NumeroDeCompras = 0;
                NumeroDeVentas = 0;
                TotalVentas = 0;
                TotalCompras = 0; //Reioniciar Variables de Reportes
                VentasAzucar = 0;
                VentasAvena = 0;
                VentasTrigo = 0;
                VentasMaiz = 0;
                VentaMasAlta = 0;
                CompraMasAlta = 0;

                System.out.println("Se posee: " + DineroCaja + " Lps. en caja");
                System.out.println("Se posee: " + DineroBanco + " Lps. en el Banco");
                System.out.println("");
                System.out.println("Ingrese la Cantidad que desea Depositar en el Banco");
                DepositoBanco = lea.nextDouble();
                while (DepositoBanco > DineroCaja * 0.6) {
                    System.out.println("*Lo maximo que puede ingresar es el 60% del Dinero en la Caja, lo cual representan: " + DineroCaja * 0.6 + " Lps*");
                    System.out.println("Ingrese una Cantidad permitida para depositar en el Banco");
                    DepositoBanco = lea.nextDouble();
                }
                DineroBanco += DepositoBanco; //Sumar el deposito al registro del banco
                DineroCaja -= DepositoBanco; //Restar el deposito al dinero de la caja

                System.out.println("Se Ha Cerrado la Caja");

            }

            if (Menu == 6) { //Salir del Sistema
                System.out.println("Fin del Dia, Cerrando el Sistema");

            }

        } while (Menu != 6);
    }

}
