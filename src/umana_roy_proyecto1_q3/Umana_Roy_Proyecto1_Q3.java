/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package umana_roy_proyecto1_q3;

//LIBRERIAS
import java.util.Scanner;

/**
 *
 * @author royum
 */
public class Umana_Roy_Proyecto1_Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // uso del Scanner para ingresar informacion al programa
        // uso del useDelimiter para ingresar mas informacion despues de un espacio desde el teclado.
        Scanner lea = new Scanner(System.in).useDelimiter("\n");

        // la bienvenida a la tienda.
        System.out.println("Bienvenido a la tienda Roy's aqui vendemos los siguientes productos: Azucar, Avena, Trigo, Maiz.");

        // variable para ingresar al menu
        int opcionMenu = 0;
        double caja = 0; // variable para caja inicilizada en 0
        double monto; // variable del monto.
        double subTotalVenta = 0; // en esta variable se actualizara en cada iteracion para reflejar el costo total de todos los productos agregados en su momento.
        double PrecioProducto = 0; // variable del precio del producto.
        boolean poderComprar = false; // usamos un bolean donde se sepa si se puede comprar o no.
        int CodigoProductoVenta; // este es para poner el codigo del producto 
        double CantidadKiloCompra; // este seria la cantidad de kilogramos.
        double CantidadKiloVenta;
        double Descuento = 0; // Variable del descuento.
        int CodigoProductoCompra; // Variable para acceder al Codigo del Producto de la seccion Compra.
        double Impuesto = 0.07; // Variable del impuesto del 7%.

        // variable como espacio en memoria para el numero de ventas.
        int numeroVentas = 0;
        // variable como espacio en memoria para el numero de compras.
        int numeroCompras = 0;

        // variables para calcular el volumen de la venta y la compra.
        double VolumenTotalCompra = 0;
        double VolumenTotalVenta = 0;

        // variables para calcular el valor medio de las ventas y de la compras.
        double ValorMedioVentas = 0;
        double ValorMedioCompras = 0;

        // variables para a venta con mayor ganancia realizada y la compra con más gasto efectuada. 
        double MayorGananciaVenta = 0;
        double MayorGastoCompra = 0;

        // este es el kilo de los productos inicializado en 0.
        double InventarioAzucar = 0;
        double InventarioAvena = 0;
        double InventarioTrigo = 0;
        double InventarioMaiz = 0;

        // variables declaradas para el productos estrella.
        double maxKilos = 0;
        // aqui se guarda el con un string vacio el nombre del producto estrella, el que mas se vendio.
        String productoEstrella = "";

        // varibles declaradas en 0 para el ranking.
        double VentasAzucarRanking = 0;
        double VentasAvenaRanking = 0;
        double VentasTrigoRanking = 0;
        double VentasMaizRanking = 0;

        // variable que se hace el deposito al banco.
        double deposito;
        // este boolean nos ayuda a detectar si la caja esta abierta true y si la caja de esta cerrada false.
        boolean cajaAbierta = false;

        // primer inicio, esta variable me ayuda a que despues de abrir la caja por primera vez,
        // este sale true, despues de una segunda entrada se convera en falso, entonces ya no pedira cuanto hay que ingresar en caja.
        boolean primerInicio = true;

        // uso del while con 6 opciones
        while (opcionMenu != 6) {

            System.out.println("\nMenu Principal");
            System.out.println("1. Abrir Caja");
            System.out.println("2. Ventas");
            System.out.println("3. Compras");
            System.out.println("4. Reportes");
            System.out.println("5. Cierre de caja");
            System.out.println("6. Salir de sistema");
            opcionMenu = lea.nextInt();

            // si eliges una opcion que no este en el menu saldra un error.
            if (opcionMenu < 1 || opcionMenu > 6) {
                System.out.println("\n");
                System.out.println("Error: debe seleccionar una opcion valida, vuelva a intentarlo porfavor.!!!");
                primerInicio = true;
            }

// ---------------------- 1. ENTRAR A LA CAJA------------------------------------------------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------------------------------------------------------------------
// ----------------------------------------------------------------------------------------------------------------------------------------------------
            if (opcionMenu == 1) {
                System.out.println("----------------------------------------------------------");
                // es true por que la caja abre.
                cajaAbierta = true;
                // metemos el primer inicio con una condicional.
                if (primerInicio) {

                    System.out.println("Caja: " + caja);
                    System.out.println("Ingrese la cantidad de efectivo para guardar en la caja: ");
                    monto = lea.nextDouble();

                    while (monto <= 0) {
                        System.out.println("No puede ingresar el numero 0 o un numero menor, porfavor ingresa de nuevo la cantidad: ");
                        monto = lea.nextDouble();
                    }
                    //aqui use el operador += para sumar el monto ingresando en caja, esto se hace para actualizar el valor de caja con el nuevo monto
                    //ingresando por el usuario esto es equivalente a escribir: caja = caja + monto
                    caja += monto;
                    primerInicio = false; //el primer inicio cambia a falso

                }
                System.out.println("Caja abierta con: " + caja + " Lps.");
                System.out.println("----------------------------------------------------------");

// ------------------2. ENTRAR A VENTAS------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            } else if (opcionMenu == 2) {

                // se abre la caja con una condicional.
                if (cajaAbierta) {

                    // pongo un error, porque sin a ver comprado no puede venderse. 
                    if (InventarioAzucar == 0 && InventarioAvena == 0 && InventarioTrigo == 0 && InventarioMaiz == 0) {
                        System.out.println("\nNo tenemos productos disponibles por ahora vuelva mas tarde!!!");
                        continue; // este continue nos ayuda forzar el la terminacion del ciclo  y forza la siguiente iteracion.
                        // y salta a al siguiente codigo entre medias. En este caso muestra el error y vuelve al menu principal.
                    }

                    // hacemos un String vacio de TipoClienteVenta porque, cuando el usuario ha ingresado por primera vez
                    // en la seccion de ventas o compras la variable TipoClienteVenta esta vacia, la condicion
                    // isEmpty se cumple, y por lo tanto, se solicita al usuario que ingrese el tipo de proveedor
                    // Una vez que el usuario ingrese el proveedor las variable TipoClienteVenta ya no esta vacia
                    // por lo tanto, la condicion isEmpty no se cumple y no se vuelve a pedir el tipo de proveedor en las siguientes iteraciones del bucle
                    // en resumen isEmpty se utiliza para asegurarse de que la solicitud del tipo de proveedor se realice solo una vez por sesión de ventas y compras.  
                    String TipoclienteVenta = "";

                    int ContinuarVenta = 1; // no ponerlo fuera del menu ventas y si no, despues de una venta ya no se puede volver a ingresar de nuevo a ventas.

                    // este sera un string vacio para almacenar los productos que se van comprando
                    String ProductosCompradosVenta = "";

                    // ahora vamos usar un while, para las ventas, para que el cliente se le permite hacer diferentes compras en la misma sesion, sin necesidad de volver al menu principal
                    while (ContinuarVenta == 1) {

                        // uso de isEmpty en una condicional.
                        if (TipoclienteVenta.isEmpty()) {
                            System.out.println("-----------------------------------------------------------------------------------");
                            System.out.println("Usted a seleccionado ventas.");
                            System.out.println("A. - El tipo (a) puede comprar todos los productos.");
                            System.out.println("B. - El tipo (b) solo puede comprar a los codigos 1 (Azucar), 2 (Avena) y 3(Trigo).");
                            System.out.println("C. - El tipo (c) solo puede comprar a losS codigos 4 (Maiz).");
                            System.out.println("-----------------------------------------------------------------------------------");
                            System.out.println("Ingrese el tipo de proveedor que se ve en pantalla (A),(B) o (C): ");
                            TipoclienteVenta = lea.next().toUpperCase();

                            // usare un bucle while donde si el usuario no ingresa una opcion valida entre A,B,C
                            // seguira repitiendose que ingrese el tipo de cliente hasta que ingrese la letra Valida.
                            while (!TipoclienteVenta.equals("A") && !TipoclienteVenta.equals("B") && !TipoclienteVenta.equals("C")) {
                                System.out.println("\nERROR: Acaba de selecionar una opcion invalida, favor ingrese la opcion de nuevo: ");
                                TipoclienteVenta = lea.next().toUpperCase();
                            }
                        }

                        // aqui se muestra el proveedor que eligio el usuario y la informacion detalla de los productos.
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.println("El proveedor que selecciono es: " + TipoclienteVenta);
                        System.out.println(" ______________________________________________________________________________________\n"
                                + "|____Codigo____|__________Producto__________|_____Precio Venta_____|____kilogramos_____|\n"
                                + "|       1      |           AZUCAR           |       LPS. 30        |    " + InventarioAzucar + "           |\n"
                                + "|       2      |           AVENA            |       LPS. 25        |    " + InventarioAvena + "           |\n"
                                + "|       3      |           TRIGO            |       LPS. 32        |    " + InventarioTrigo + "           |\n"
                                + "|       4      |            MAIZ            |       LPS. 20        |    " + InventarioMaiz + "           |");
                        System.out.println("-------------------------------------------------------------------------------------------");
                        System.out.println("Ingrese el codigo del Producto: ");
                        CodigoProductoVenta = lea.nextInt();
                        String NombreProductoVenta = ""; // aqui agregamos un producto string vacio, y se llena 
                        // al elegir un producto.

                        // aqui pongo un bucle por si el usuario escoge un numero que no esta en la seccion
                        // el bucle se repitara hasta que el usuario elija una opcion dada.
                        while (CodigoProductoVenta < 1 || CodigoProductoVenta > 4) {
                            System.out.println("Error: debe ingresar una opcion valida, porfavor ingrese una opcion valida: .");
                            CodigoProductoVenta = lea.nextInt();
                        }

                        // condicionales, donde si elige el puede comprar cualquier producto
                        if (TipoclienteVenta.equals("A")) {
                            poderComprar = true;
                            // si elige proveedor b, puede seleccionar el producto 1,2 y 3.
                        } else if (TipoclienteVenta.equals("B")) {
                            if (CodigoProductoVenta >= 1 && CodigoProductoVenta <= 3) {
                                poderComprar = true;
                            }
                            // si elige el tipo c, solo puede comprar el pruducto 4.
                        } else if (TipoclienteVenta.equals("C")) {
                            if (CodigoProductoVenta == 4) {
                                poderComprar = true;
                            }
                        }

                        // condicionales por si no se vende el producto azcucar, 
                        // si el kilo es = 0, saldra el mensaje y regresa donde estaba antes
                        if (poderComprar) {
                            if (CodigoProductoVenta == 1) {
                                NombreProductoVenta = "Azucar";
                                PrecioProducto = 30;
                                if (InventarioAzucar == 0) {
                                    System.out.println("\nLo sentimos el producto Azucar no lo tenemos disponible por ahora.");
                                    continue; // en este caso el continue, despues de motrar el error, que no tenemos
                                    // el producto por ahora, vuelve a preguntar  que otro producto quiere.
                                }
                            } else if (CodigoProductoVenta == 2) {
                                NombreProductoVenta = "Avena";
                                PrecioProducto = 25;
                                // si el kilo es = 0, saldra el mensaje y regresa donde estaba antes
                                if (InventarioAvena == 0) {
                                    System.out.println("\nLo sentimos el producto Avena no lo tenemos disponible por ahora.");
                                    continue;// en este caso el continue, despues de motrar el error, que no tenemos
                                    // el producto por ahora, vuelve a preguntar  que otro producto quiere.
                                }
                            } else if (CodigoProductoVenta == 3) {
                                NombreProductoVenta = "Trigo";
                                PrecioProducto = 32;
                                // si el kilo es = 0, saldra el mensaje y regresa donde estaba antes
                                if (InventarioTrigo == 0) {
                                    System.out.println("\nLo sentimos el producto Trigo no lo tenemos disponible por ahora.");
                                    continue;// en este caso el continue, despues de motrar el error, que no tenemos
                                    // el producto por ahora, vuelve a preguntar  que otro producto quiere.
                                }
                            } else if (CodigoProductoVenta == 4) {
                                NombreProductoVenta = "Maiz";
                                PrecioProducto = 20;
                                // si el kilo es = 0, saldra el mensaje y regresa donde estaba antes
                                if (InventarioMaiz == 0) {
                                    System.out.println("\nLo sentimos el prodicto Maiz no lo tenmos disponible por ahora.");
                                    continue;// en este caso el continue, despues de motrar el error, que no tenemos
                                    // el producto por ahora, vuelve a preguntar  que otro producto quiere.
                                }
                            }

                            // aqui se muestra el nombre del producto que selecciono
                            // y se pide que cantidad de kilo gramos quiere del producto.
                            System.out.println("El producto que selecciona es: " + NombreProductoVenta);
                            System.out.println("Ingrese la cantidad de kilogramos que desea comprar: ");
                            CantidadKiloVenta = lea.nextDouble();

                            // si el usuario elige un numero entre 0 y un numero negativo le saldra este mensaje un bucle
                            // el bucle se repetira hasta que elija un numero mayor a 0.
                            while (CantidadKiloVenta <= 0) {
                                System.out.println("Error: como vas a ingresar a kilogramos un cero o un numero negativo??, favor ingresaa un numero mayor a cero.");
                                CantidadKiloVenta = lea.nextDouble();
                            }

                            // condicionales por si el ususario ingresa mas de los kilogramos que se tienen en venta
                            if (CodigoProductoVenta == 1 && CantidadKiloVenta > InventarioAzucar) {
                                System.out.println("\nUna disculpa solo tenemos " + InventarioAzucar + " kilogramos de " + NombreProductoVenta);
                                continue; // en este caso el continue, despues de motrar el error, que no tenemos
                                // suficientes kilogramos por ahora, vuelve a preguntar que otro producto quiere 

                            } else if (CodigoProductoVenta == 2 && CantidadKiloVenta > InventarioAvena) {
                                System.out.println("\nUna disculpa solo tenemos " + InventarioAvena + " kilogramos de " + NombreProductoVenta);
                                continue;// en este caso el continue, despues de motrar el error, que no tenemos
                                // suficientes kilogramos por ahora, vuelve a preguntar que otro producto quiere 
                            } else if (CodigoProductoVenta == 3 && CantidadKiloVenta > InventarioTrigo) {
                                System.out.println("\nUna disculpa solo tenemos " + InventarioTrigo + " kilogramos de " + NombreProductoVenta);
                                continue;// en este caso el continue, despues de motrar el error, que no tenemos
                                // suficientes kilogramos por ahora, vuelve a preguntar que otro producto quiere 

                            } else if (CodigoProductoVenta == 4 && CantidadKiloVenta > InventarioMaiz) {
                                System.out.println("\nUna disculpa solo tenemos " + InventarioMaiz + " Kilogramos de " + NombreProductoVenta);
                                continue;// en este caso el continue, despues de motrar el error, que no tenemos
                                // suficientes kilogramos por ahora, vuelve a preguntar que otro producto quiere 
                            }

                            // condicional para el descuento.
                            // si el subtotal sale con 1000, tendra un descuento del 5%
                            if (subTotalVenta >= 1000) {
                                Descuento = 0.05;
                                // si el subtotal sale con 5000, tendra un descuento del 10%
                            } else if (subTotalVenta > 5000) {
                                Descuento = 0.10;
                            } else {
                                // si no, no tendra ningun descuento.
                                Descuento = 0.0;
                            }

                            // aqui se hace los calculos  de los descuentos, impuestos y del subtotal.
                            double TotalProductoVenta = CantidadKiloVenta * PrecioProducto;
                            subTotalVenta = TotalProductoVenta;
                            double DescuentoAplicado = subTotalVenta * Descuento;
                            double SubtotalDespuesDescuento = subTotalVenta - DescuentoAplicado;
                            double ImpuestoAplicado = SubtotalDespuesDescuento * Impuesto;
                            double TotalaPagar = SubtotalDespuesDescuento + ImpuestoAplicado;

                            if (!ProductosCompradosVenta.isEmpty()) {
                                // aqui se agrega una coma en productoscompradoscompra.
                                // el proposito de la coma es para separar los produdctos de los demas productos.
                                // la funcionalidad del operador de concatenacion "+=" es que aniade la coma y el espacio al final de la cadena existente.
                                ProductosCompradosVenta += ", ";
                            }

                            // aqui se agrega el nombre del nuevo producto que se agrega  la cadena de ProductosCompradosCompra
                            // el += concatena el nuevo producto NombreProductoCompra al final de la cadena ProductosCompradosCompra
                            ProductosCompradosVenta += NombreProductoVenta;

                            // se muestran los detalles de la venta.
                            System.out.println("\n-----------------------------Detalles de la venta--------------------------------");
                            System.out.println("Lista de productos vendidos: " + ProductosCompradosVenta);
                            System.out.println("Producto Agregado: " + NombreProductoVenta);
                            System.out.println("Cantidad de kilogramo " + CantidadKiloVenta + " Kg.");
                            System.out.println("Precio por Kg " + PrecioProducto + " Lps.");
                            System.out.println("Subtotal: " + subTotalVenta + " Lps.");
                            System.out.println("Descuento: " + DescuentoAplicado + "Lps.");
                            System.out.println("Subtotal despues de descuento: " + SubtotalDespuesDescuento + " Lps.");
                            System.out.println("Impuesto (7%): " + ImpuestoAplicado + " Lps.");
                            System.out.println("Total a Pagar. " + TotalaPagar + " Lps.");
                            System.out.println("-----------------------------------------------------------------------------------");

                            // si el codigoproductovneta es 1, entonces el inventarioazcuar se resta a la cantidadKiloventa
                            // y las ventasAzucar se suma con la cantidadkiloventa.
                            if (CodigoProductoVenta == 1) {
                                InventarioAzucar -= CantidadKiloVenta;
                                VentasAzucarRanking += CantidadKiloVenta;
                                // si el codigoproductovneta es 2, entonces el inventarioavena se resta a la cantidadKiloventa
                                // y las ventasAvena se suma con la cantidadkiloventa.
                            } else if (CodigoProductoVenta == 2) {
                                InventarioAvena -= CantidadKiloVenta;
                                VentasAvenaRanking += CantidadKiloVenta;
                                // si el codigoproductovneta es 3, entonces el inventarioTrigo se resta a la cantidadKiloventa
                                // y las ventasTrigo se suma con la cantidadkiloventa.
                            } else if (CodigoProductoVenta == 3) {
                                InventarioTrigo -= CantidadKiloVenta;
                                VentasTrigoRanking += CantidadKiloVenta;
                                // si el codigoproductovneta es 4, entonces el inventarioMaiz se resta a la cantidadKiloventa
                                // y las ventasmaiz se suma con la cantidadkiloventa.
                            } else if (CodigoProductoVenta == 4) {
                                InventarioMaiz -= CantidadKiloVenta;
                                VentasMaizRanking += CantidadKiloVenta;
                            }

                            // se suma lo que tenemos en caja por vender.
                            caja += TotalProductoVenta;

                            // aqui se calcula lo del volumen de venta
                            VolumenTotalVenta += TotalaPagar;

                            // el valor medio de ventas es igual Volumenmedioventas entre el numero de ventas que se hizo.
                            ValorMedioVentas = VolumenTotalVenta / numeroVentas;

                            // aqui se calcula con un condicional, si el TotalaPagar es mayor al mayorGananciaVenta,
                            // entonces MayorGananciaventa es igual al TotalaPagar.
                            if (TotalaPagar > MayorGananciaVenta) {
                                MayorGananciaVenta = TotalaPagar;
                            }

                            // condiciones para el producto Estrella.
                            if (CantidadKiloVenta > maxKilos) { // si el kg de venta, es mayor, entonces maxkilos es igual al Nombre del Producto de venta
                                maxKilos = CantidadKiloVenta;
                                productoEstrella = NombreProductoVenta;
                            } else if (CantidadKiloVenta > maxKilos) {
                                maxKilos = CantidadKiloVenta;
                                productoEstrella = NombreProductoVenta;
                            } else if (CantidadKiloVenta > maxKilos) {
                                maxKilos = CantidadKiloVenta;
                                productoEstrella = NombreProductoVenta;
                            } else if (CantidadKiloVenta > maxKilos) {
                                maxKilos = CantidadKiloVenta;
                                productoEstrella = NombreProductoVenta;
                            }

                            numeroVentas++; // aqui se cuenta el numero de ventas que se han hecho.

                            // no puede comprar si el usuario elige un proveedor que no pueda comprar un producto en especifico.
                        } else {
                            System.out.println("EL PROVEEDOR NO PUEDE COMPRAR DICHO PRODUCTO.");
                        }

                        // condicional por si ya no hay mas productos que vender.
                        if (InventarioAzucar == 0 && InventarioAvena == 0 && InventarioTrigo == 0 && InventarioMaiz == 0) {
                            System.out.println("\nNo hay mas productos disponibles para vender.");
                            break; // Salir del bucle de ventas y regresar al menú principal
                        }

                        // eleccion si desea comprar otro producto si o no.
                        System.out.println("caja actualizada con: " + caja);
                        System.out.println("Desea comprar otro producto? 1. (si) / 2. (no)");
                        ContinuarVenta = lea.nextInt();
                        // si el usuario elige un numero que no sea 1 o 2 le saldra este mensaje con un bucle
                        // se repetira este bucle hasta que que elija la opcion correcta.
                        while (ContinuarVenta < 1 || ContinuarVenta > 2) {
                            System.out.println("Error: Acaba de seleccionar una opcion invalida, favor seleccione una opcion valida: ");
                            ContinuarVenta = lea.nextInt();
                        }

                    }

                } else {
                    System.out.println("\nLa Caja esta cerrada, no se puede realizar compras.");
                }

// ---------------------3. ENTRAR A COMPRAS-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------             
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            } else if (opcionMenu == 3) {

                if (cajaAbierta) {

                    String TipoclienteCompra = "";
                    int ContinuarCompra = 1; // Inicializar ContinuarCompra para controlar el bucle
                    // este sera un string vacio para almacenar los productos que se van comprando
                    String ProductosCompradosCompra = "";
                    // aqui es pasa lo mismo como en la parte de ventas.
                    while (ContinuarCompra == 1) {

                        if (TipoclienteCompra.isEmpty()) {
                            System.out.println("\nUsted a seleccionado compras.");
                            System.out.println("Primeramente se le va pedir que elija un proveedor.");
                            System.out.println("-----------------------------------------------------------------------------------");
                            System.out.println("A. - El tipo (a) solo puede comprar a los codigos 1 (Azucar) y 4 (Maiz).");
                            System.out.println("B. - El tipo (b) solo puede comprar a los codigos 2 (Avena) y 3 (Trigo).");
                            System.out.println("C. - El tipo (c) solo puede comprar al codigo 2 (Avena).");
                            System.out.println("-----------------------------------------------------------------------------------");
                            System.out.println("Ingrese el tipo de proveedor que se ve en pantalla (A),(B) o (C): ");
                            TipoclienteCompra = lea.next().toUpperCase();

                            // error con un bucle, que su el usuario no elige una de las tres letras que estas en seleccion mostrara
                            // este mensaje de error, el bucle finalizara cuando el usuario ingrese una opcion valida.
                            while (!TipoclienteCompra.equals("A") && !TipoclienteCompra.equals("B") && !TipoclienteCompra.equals("C")) {
                                System.out.println("\nError: debe ingresar una opcion valida, favor debe ingresar una opcion valida:  ");
                                TipoclienteCompra = lea.next().toUpperCase();
                            }
                        }

                        // se ve en consola lo que eligio el usuario.
                        System.out.println("\nEl proveedor que usted seleciono es: " + TipoclienteCompra);
                        // Mostrar solo los productos que el cliente puede comprar
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.println(" _______________________________________________________________________\n"
                                + "|____Codigo____|__________Producto__________|_______Precio Compra_______|\n"
                                + "|       1      |           AZUCAR           |       LPS. 25             |\n"
                                + "|       2      |           AVENA            |       LPS. B(20) C(22)    |\n"
                                + "|       3      |           TRIGO            |       LPS. 30             |\n"
                                + "|       4      |            MAIZ            |       LPS. 18             |             ");
                        System.out.println("-----------------------------------------------------------------------------------");
                        System.out.println("Ingrese el codigo del Producto:");
                        CodigoProductoCompra = lea.nextInt();
                        String NombreProductoCompra = ""; // aqui guardamos con un String el nombre del producto

                        // error con bucle, si el usuario no elige una de los 4 numeros que muestre en pantalla, se mostrar este mensaje.
                        // el bucle terminara cuando el usuario ingrese una opcion valida.
                        while (CodigoProductoCompra < 1 || CodigoProductoCompra > 4) {
                            System.out.println("\nError: debe ingresar una opcion valida, favor debe ingresar una opcion valida: ");
                            CodigoProductoCompra = lea.nextInt();
                        }

                        poderComprar = false; // reiniciamos poderComprar para cada selección de producto

                        // si el usuario elige "A" el usuario solo podra comprar los productos con codigo 1 y 4.
                        if (TipoclienteCompra.equals("A")) {
                            if (CodigoProductoCompra == 1 || CodigoProductoCompra == 4) {
                                poderComprar = true;
                            }
                            // si no si, elige "b" el usuario solo podra comprar los producto con codigo 2 y 3.
                        } else if (TipoclienteCompra.equals("B")) {
                            if (CodigoProductoCompra == 2 || CodigoProductoCompra == 3) {
                                poderComprar = true;
                            }
                            // si no si, elige "c" el usuario solo podra comprar el producto 2
                        } else if (TipoclienteCompra.equals("C")) {
                            if (CodigoProductoCompra == 2) {
                                poderComprar = true;
                            }
                        }

                        // aqui se define los precios de los productos.
                        if (poderComprar) {
                            // si el codigo de producto es 1, el nombre de producto es "Azucar"
                            // y su precio del producto de comptra es de 25.
                            if (CodigoProductoCompra == 1) {
                                NombreProductoCompra = "Azucar";
                                PrecioProducto = 25;
                                // si no si el codigo de producto es 2, el nombre de producto es "Avena"
                            } else if (CodigoProductoCompra == 2) {
                                NombreProductoCompra = "Avena";
                                // si para el tipo de cliente que es "B" el precio del producto de compra es de 20.
                                if (TipoclienteCompra.equals("B")) {
                                    PrecioProducto = 20;
                                    // si no si el tipo cliente es "C" el precio del producto es 22
                                } else if (TipoclienteCompra.equals("C")) {
                                    PrecioProducto = 22;
                                    // si no el precio de compra es de  25.
                                } else {
                                    PrecioProducto = 25;
                                }
                                // si no si el codigo del producto es 3, el nombre del producto es "Trigo".
                                // y su precio de compra es de 32.
                            } else if (CodigoProductoCompra == 3) {
                                NombreProductoCompra = "Trigo";
                                PrecioProducto = 32;
                                // si no si el codigo de producto es 4, el nombre del producto es "Maiz"
                                // y su precio de compra es de 18.
                            } else if (CodigoProductoCompra == 4) {
                                NombreProductoCompra = "Maiz";
                                PrecioProducto = 18;
                            }

                            // se muestra en pantalla el producto que selecciono el usuario con su respectivo codigo.
                            System.out.println("\n-----------------------------------------------------------------------------------");
                            System.out.println("El producto que usted selecciono es: " + CodigoProductoCompra + " " + NombreProductoCompra);
                            // aqui se ingresa por el usuario la cantidad de kilogramos que desea comprar
                            System.out.println("-----------------------------------------------------------------------------------");
                            System.out.println("Ingrese la cantidad de kilogramos que desea comprar: ");
                            CantidadKiloCompra = lea.nextDouble();
                            System.out.println("-----------------------------------------------------------------------------------");

                            // error en compras por si el usuario elige un 0 o un numero menor, el bucle
                            // se repetira hasta que se un numero mayotr a 0.
                            while (CantidadKiloCompra <= 0) {
                                System.out.println("Error: como vas a ingresar en kilogramos un cero o un numero negativo??, favor ingresa un numero mayor a cero.");
                                CantidadKiloCompra = lea.nextDouble();
                            }

                            double TotalProductoCompra = CantidadKiloCompra * PrecioProducto; // Calcular el total del producto

                            // Verificar si hay suficiente dinero en la caja
                            if (caja >= TotalProductoCompra) {

                                // uso la funcion isEmpty que significa esta vacio, yo implemento una lista de productos que se han comprado,
                                // ProductosCompradosCompra es un cadena de string que se actuliza cada vez que se agrega un nuevo producto a la compra.
                                // se usa una condicion su proposito es para verificar si ProductosCompradosCompra ya tiene algun producto
                                // la  funcionalidad de isEmpty es metodo de la clase string que devuelve true si la cadena esta vacia y false si contiene algun texto
                                // su funcion en esta condicion: !ProductosCompradosCompra.isEmpty devuelve true si la cadena no esta vacia,
                                // osea que ya tiene productos agregados.
                                if (!ProductosCompradosCompra.isEmpty()) {
                                    // aqui se agrega una coma en productoscompradoscompra.
                                    // el proposito de la coma es para separar los produdctos de los demas productos.
                                    // la funcionalidad del operador de concatenacion "+=" es que aniade la coma y el espacio al final de la cadena existente.
                                    ProductosCompradosCompra += ", ";
                                }

                                // aqui se agrega el nombre del nuevo producto que se agrega  la cadena de ProductosCompradosCompra
                                // el += concatena el nuevo producto NombreProductoCompra al final de la cadena ProductosCompradosCompra
                                ProductosCompradosCompra += NombreProductoCompra;

                                /*
                            Proceso: 
                            inicialmente esta asi String ProductosCompradosCompra = "";
                            
                            con el nuevo productoAgregado queda asi String ProductosCompradosCompra = "Azucar";
                            
                            el proceso del la condicion es asi if(!ProductosCompradosCompra.isEmpty()) sera falso porque la cadena esta vacia 
                            
                            ProductosCompradosCompra += NombreProductoCompra; ejecuta ProductosCompradosCompra = "Azucar";.
                            
                            Resultado: ProductosCompradosCompra = "Azucar";
                            
                            cuando se grega un nuevo producto queda asi NombreProductoCompra = "Trigo";
                            
                            cuando pasa esto la condicion if(!ProductosCompradosCompra.isEmpty()) sera verdadera porque la cadena ya contiene "Azucar"
                            
                            ProductosCompradosCompra += ", "; ejecuta ProductosCompradosCompra = "Azucar, ";.
                            ProductosCompradosCompra += NombreProductoCompra; ejecuta ProductosCompradosCompra = "Azucar, Trigo";.
                            
                            Resumiendo en esta partecita del codigo asegura que los productos comprados que hace el usuario se agregue a lista de productos
                                 */
                                // aqui se muestra los detalles de la compra.
                                System.out.println("\n-------------------------------Detalles de la compra-----------------------------");
                                System.out.println("Lista de productos comprados: " + ProductosCompradosCompra);
                                System.out.println("Producto Agregado: " + NombreProductoCompra);
                                System.out.println("Cantidad de Kilogramo: " + CantidadKiloCompra + " Kg");
                                System.out.println("Precio por Kg: " + PrecioProducto + " Lps.");
                                System.out.println("Total Producto: " + TotalProductoCompra + " Lps.");
                                System.out.println("-----------------------------------------------------------------------------------");

                                // el volumencompra es igual a volumencompra mas TotalProductoCompra.
                                VolumenTotalCompra += TotalProductoCompra;

                                // aqui se calcula con un condicional, si el TotalProductoCompra es mayor al gasto compra,
                                // entonces  el mayor gastocompra es igual al TotalProductoCompra
                                if (TotalProductoCompra > MayorGastoCompra) {
                                    MayorGastoCompra = TotalProductoCompra;
                                }

                                numeroCompras++; // aqui se cuentan el numero de compras que se han hecho.

                                // el valor medio de compras es igual al volumen total de compras entre el numero de compras que se hizo.
                                ValorMedioCompras = VolumenTotalCompra / numeroCompras;

                                // Esta compra disminuirá el efectivo en caja.
                                caja -= TotalProductoCompra;

                                // despues de comprar kg los kg se incrementan y ya no estan en 0, con estas condiciones hacen que se incrementen.
                                // si el codigoProductoCompta es igual a 1 entonces el InverioAzucar es igual a InverioAzucar mas CantidadKiloComra
                                if (CodigoProductoCompra == 1) {
                                    InventarioAzucar += CantidadKiloCompra;
                                    //  si el codigoProductoCompta es igual a 2 entonces el InverioAvena es igual a InverioAvena     mas CantidadKiloComra
                                } else if (CodigoProductoCompra == 2) {
                                    InventarioAvena += CantidadKiloCompra;
                                    //  si el codigoProductoCompta es igual a 3 entonces el InverioTrigo es igual a InverioTrigo mas CantidadKiloComra
                                } else if (CodigoProductoCompra == 3) {
                                    InventarioTrigo += CantidadKiloCompra;
                                    //  si el codigoProductoCompta es igual a 4 entonces el InverioMaiz es igual a InverioMaiz mas CantidadKiloComra
                                } else if (CodigoProductoCompra == 4) {
                                    InventarioMaiz += CantidadKiloCompra;
                                }

                                // aqui la caja se actuliza
                                System.out.println("Caja actualizada con: " + caja + " Lps.");
                            } else {
                                // si no hay suficiente dinero en la caja, no se peude comprar.
                                System.out.println("\nNo se puede pagar compra, por insufisiencia monetaria.");
                            }
                        } else {
                            // proveedor no vende dicho producto, y el poderComprar se vuelve falso.
                            System.out.println("\nPROVEEDOR NO VENDE DICHO PRODUCTO");
                        }

                        // aqui dejo la opcion si quiere o no volver a comprar un producto.
                        System.out.println("----------------------------------------------------------");
                        System.out.println("Desea comprar otro producto? (1 para si / 2 para no): ");
                        ContinuarCompra = lea.nextInt();
                        // si el usuario elige un numero que no sea 1 o 2 le saldra este mensaje con un bucle
                        // se repetira este bucle hasta que que elija la opcion correcta.
                        while (ContinuarCompra < 1 || ContinuarCompra > 2) {
                            System.out.println("Error: Acaba de seleccionar una opcion invalida, favor seleccione una opcion valida: ");
                            ContinuarCompra = lea.nextInt();
                        }

                    }

                } else {
                    System.out.println("\nLa caja esta cerrada. Espera aque la caja vuelva abrir.");
                }

// ---------------4. ENTRAR A REPORTES-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------                
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            } else if (opcionMenu == 4) {
                // aqui se muestra en consola lo que es los reportes.
                System.out.println("-----------------------Reportes-----------------------");
                System.out.println("Cantidad Actual en caja : " + caja + " Lps.");
                System.out.println("Numero de compras realizadas durante el dia: " + numeroCompras);
                System.out.println("Numero de ventas realizadas durante el dia: " + numeroVentas);
                System.out.println("Volumen total gastado en compras: " + VolumenTotalCompra + " Lps.");
                System.out.println("Volumen efectuadas en ventas: " + VolumenTotalVenta + " Lps.");
                System.out.println("Margen de ganancia: " + (VolumenTotalVenta - VolumenTotalCompra + " Lps."));
                System.out.println("Volumen medio de compras: " + ValorMedioCompras + " Lps.");
                System.out.println("Volumen medio de ventas: " + ValorMedioVentas + " Lps.");
                System.out.println("La venta con mayor ganancia realizada: " + MayorGananciaVenta + " Lps.");
                System.out.println("La compra con menor ganancia realizada: " + MayorGastoCompra + " Lps.");
                System.out.println("Producto Estrella: " + productoEstrella + " " + maxKilos + " kg.");

                System.out.println("\nRanking de la lista de productos mas vendidos.");
                // si la venta de azucar es mayor o igual a la ventas de Avena y las venta de azucar es mayor o igual las ventas de Trigo y venta de azucar es mayor o igual a las ventas de maiz
                // entonces el azucar el azucar sera el primero del ranking.
                if (VentasAzucarRanking >= VentasAvenaRanking && VentasAzucarRanking >= VentasTrigoRanking && VentasAzucarRanking >= VentasMaizRanking) {
                    System.out.println("1. Azucar: " + VentasAzucarRanking + " kg.");
                    // si la venta de avena es mayor igual a las ventas de trigo y la venta de avena es mayor igual a las ventas de avena es mayor igual a las ventas de maiz
                    // entonces la avena sera el segundo lugar del ranking.
                    if (VentasAvenaRanking >= VentasTrigoRanking && VentasAvenaRanking >= VentasMaizRanking) {
                        System.out.println("2. Avena: " + VentasAvenaRanking + "kg.");
                        // si la ventas de trigo es mayor igual a las ventas de maiz 
                        // entonces el trigo sera el 3 lugar del ranking y el maiz sera 4 lugar.
                        if (VentasTrigoRanking >= VentasMaizRanking) {
                            System.out.println("3. Trigo: " + VentasTrigoRanking + " kg.");
                            System.out.println("4. Maiz: " + VentasMaizRanking + " kg.");
                        } else {
                            // si no es el trigo 3 lugar y el maiz 4 lugar entones, el maiz sera 3 lugar y el trigo sera 4 lugar.
                            System.out.println("3. Maiz: " + VentasMaizRanking + " kg.");
                            System.out.println("4. Trigo: " + VentasTrigoRanking + " kg.");
                        }
                        // si no si, la avena es segundo lugar entonces, las ventas de trigo es mayor igual a las ventas de avena y las ventas de trigo son mayor igual a las ventas  de maiz
                        // entonces el trigo sera el 2 lugar.
                    } else if (VentasTrigoRanking >= VentasAvenaRanking && VentasTrigoRanking >= VentasMaizRanking) {
                        System.out.println("2. Trigo: " + VentasTrigoRanking + " kg.");
                        // si las ventas de avena son mayor igual a las ventas de maiz 
                        // entonces la avena sera el 3 lugar y el maiz sera 4 lugar.
                        if (VentasAvenaRanking >= VentasMaizRanking) {
                            System.out.println("3. Avena: " + VentasAvenaRanking + " kg.");
                            System.out.println("4. Maiz: " + VentasMaizRanking + " kg.");
                        } else {
                            // si no es la avena 3 lugar y el maiz 4 lugar entonces, el maiz sera 3 lugar y la avena sera 4 lugar.
                            System.out.println("3. Maiz: " + VentasMaizRanking + " kg.");
                            System.out.println("4. Avena: " + VentasAvenaRanking + " kg.");
                        }
                    } else {
                        // si no es el trigo 2 lugar entonces, sera el maiz 2 lugar.
                        System.out.println("2. Maiz: " + VentasMaizRanking + " kg.");
                        // si las ventas de avena son mayor igual a las ventas de trigo
                        // entonces la avena sera 3 lugar y el trigo sera 4 lugar.
                        if (VentasAvenaRanking >= VentasTrigoRanking) {
                            System.out.println("3. Avena: " + VentasAvenaRanking + " kg.");
                            System.out.println("4. Trigo: " + VentasTrigoRanking + " kg.");
                        } else {
                            // si no es la avena 3 lugar y la avena 4 lugar entonces, el trigo sera 3 lugar y la avena sera 4 lugar.
                            System.out.println("3. Trigo: " + VentasTrigoRanking + " kg.");
                            System.out.println("4. Avena: " + VentasAvenaRanking + " kg.");
                        }
                    }
                    // si no si, el azucar es 1 lugar, entonces, sera la avena, si las ventas de avena son mayor igual a las ventas de azucar, y las ventas de avena son mayor igual a las ventas de trigo, y las ventas de avena son mayor igual a las ventas de maiz,
                    // entonces la avena es 1 lugar.
                } else if (VentasAvenaRanking >= VentasAzucarRanking && VentasAvenaRanking >= VentasTrigoRanking && VentasAvenaRanking >= VentasMaizRanking) {
                    System.out.println("1. Avena: " + VentasAvenaRanking + " kg.");
                    // si las ventas de azucar son mayor igual a las ventas de trigo, y las ventas de azucar son mayor igual a las ventas de maiz,
                    // entonces la azucar sera 2 lugar.
                    if (VentasAzucarRanking >= VentasTrigoRanking && VentasAzucarRanking >= VentasMaizRanking) {
                        System.out.println("2. Azucar: " + VentasAzucarRanking + " kg.");
                        // si las ventas de trigo son mayor igual a las ventas de maiz,
                        // entonces el trigo sera 3 lugar y el maiz sera 4 lugar.
                        if (VentasTrigoRanking >= VentasMaizRanking) {
                            System.out.println("3. Trigo: " + VentasTrigoRanking + " kg.");
                            System.out.println("4. Maiz: " + VentasMaizRanking + " kg.");
                        } else {
                            // si no es el trigo 3 lugar y el maiz 4 lugar,
                            // entonces el maiz sera 3 lugar y el trigo sera 4 lugar.
                            System.out.println("3. Maiz: " + VentasMaizRanking + " kg.");
                            System.out.println("4. Trigo: " + VentasTrigoRanking + " kg.");
                        }
                        // si no si el azucar es 2 lugar, entonces sera el trigo, si las ventas de trigo son mayor igual a las de azucar, y las ventas de trigo son mayor igual a las ventas de maiz,
                        // entonces sera el trigo 2 lugar.
                    } else if (VentasTrigoRanking >= VentasAzucarRanking && VentasTrigoRanking >= VentasMaizRanking) {
                        System.out.println("2. Trigo: " + VentasTrigoRanking + " kg.");
                        // si las ventas de azucar son mayores o igual a las ventas de maiz,
                        // entonces el azucar sera 3 lugar y el maiz sera 4 lugar.
                        if (VentasAzucarRanking >= VentasMaizRanking) {
                            System.out.println("3. Azucar: " + VentasAzucarRanking + "kg.");
                            System.out.println("4. Maiz: " + VentasMaizRanking + " kg.");
                        } else {
                            // si no es el azucar 3 lugar y el maiz 4 lugar,
                            // entonces sera el maiz sera 3 lugar y el azucar sera 4 lugar.
                            System.out.println("3. Maiz: " + VentasMaizRanking + " kg.");
                            System.out.println("4. Azucar: " + VentasAzucarRanking + " kg.");
                        }
                    } else {
                        // si no es trigo 2 lugar, entonces sera el maiz.
                        System.out.println("2. Maiz: " + VentasMaizRanking + " kg.");
                        // si las ventas de azucar son mayores o iguales a las ventas de trigo,
                        // entonces azucar sera 3 lugar y el trigo sera 4 lugar.
                        if (VentasAzucarRanking >= VentasTrigoRanking) {
                            System.out.println("3. Azucar: " + VentasAzucarRanking + " kg.");
                            System.out.println("4. Trigo: " + VentasTrigoRanking + " kg.");
                        } else {
                            // si no es azucar el 3 lugar y trigo 4 lugar,
                            // entonces 3 sera 3 lugar y el azucar sera 4.
                            System.out.println("3. Trigo: " + VentasTrigoRanking + " kg.");
                            System.out.println("4. Azucar: " + VentasAzucarRanking + " kg.");
                        }
                    }
                    // si no si es avena 1 lugar, entonces sera trigo, entonces,
                    // si las ventas de trigo son mayor o igual a las ventas de Azucar, y si las ventas de trigo son mayor o igual a las ventas de avena, y si las ventas de trigo son mayor o igual a las ventas de maiz
                    // entonces trigo sera el 1 lugar del ranking.
                } else if (VentasTrigoRanking >= VentasAzucarRanking && VentasTrigoRanking >= VentasAvenaRanking && VentasTrigoRanking >= VentasMaizRanking) {
                    System.out.println("1. Trigo: " + VentasTrigoRanking + " kg");
                    // si las ventas de azucar son mayor o igual a las ventas de avena y  si las ventas de azucar son mayor o igual a las ventas del maiz,
                    // entonces el azucar sera el 2 lugar del ranking.
                    if (VentasAzucarRanking >= VentasAvenaRanking && VentasAzucarRanking >= VentasMaizRanking) {
                        System.out.println("2. Azucar: " + VentasAzucarRanking + " kg");
                        // si las ventas de Avena mayor o igual a las ventas del maiz,
                        // entonces la avena sera 3 lugar y el maiz sera el 4 lugar del ranking.
                        if (VentasAvenaRanking >= VentasMaizRanking) {
                            System.out.println("3. Avena: " + VentasAvenaRanking + " kg");
                            System.out.println("4. Maiz: " + VentasMaizRanking + " kg");
                        } else {
                            // si no es la avena 3 lugar y el maiz 4 lugar, entonces,
                            // entonces sera el maiz 3 lugar y la vena 4 lugar.
                            System.out.println("3. Maiz: " + VentasMaizRanking + " kg");
                            System.out.println("4. Avena: " + VentasAvenaRanking + " kg");
                        }
                        // si no si el azucar es el 2 lugar, entonces sera la avena el 2 lugar, si las ventas de avena es mayor igual que las de ventas de azucar y, si las ventas de avena es mayor igual que las de ventas de maiz,
                        // entonces sera la avena sera el 2 lugar.
                    } else if (VentasAvenaRanking >= VentasAzucarRanking && VentasAvenaRanking >= VentasMaizRanking) {
                        System.out.println("2. Avena: " + VentasAvenaRanking + " kg");
                        // si la ventas de azucar es mayor igual que las ventas de maiz,
                        // entonces azucar sera el 3 lugar y el maiz sera el 4 lugar.
                        if (VentasAzucarRanking >= VentasMaizRanking) {
                            System.out.println("3. Azucar: " + VentasAzucarRanking + " kg");
                            System.out.println("4. Maiz: " + VentasMaizRanking + " kg");
                        } else {
                            // si no es asi, que la azucar queda en 3 lugar y el maiz en 4,
                            // entonces el maiz que da en 3 lugar y el azucar en 4 lugar.
                            System.out.println("3. Maiz: " + VentasMaizRanking + " kg");
                            System.out.println("4. Azucar: " + VentasAzucarRanking + " kg");
                        }
                    } else {
                        //si no si, la avena es 2 lugar, entonces el maiz sera el 2 lugar,
                        System.out.println("2. Maiz: " + VentasMaizRanking + " kg");
                        // si las ventas de azucar son mayores de las ventas de avena,
                        // entonces la azucar sera el 3 lugar y la avena sera el 4 lugar.
                        if (VentasAzucarRanking >= VentasAvenaRanking) {
                            System.out.println("3. Azucar: " + VentasAzucarRanking + " kg");
                            System.out.println("4. Avena: " + VentasAvenaRanking + " kg");
                        } else {
                            // si no es asi, que la azucar sea 3 lugar y la avena 4 lugar,
                            // entonces la avena sera 3 lugar, y la azucar sera 4 lugar.
                            System.out.println("3. Avena: " + VentasAvenaRanking + " kg");
                            System.out.println("4. Azucar: " + VentasAzucarRanking + " kg");
                        }
                    }
                } else {
                    // si no es asi, que el trigo sea el 1 lugar del ranking, entonces el maiz sera el 1 lugar.
                    System.out.println("1. Maiz: " + VentasMaizRanking + " kg");
                    // si las ventas de azucar son mayor o igual a las ventas de avena y,  si las ventas de azucar son mayor o igual a las ventas de trigo,
                    // entonces el azucar sera el 2 lugar.
                    if (VentasAzucarRanking >= VentasAvenaRanking && VentasAzucarRanking >= VentasTrigoRanking) {
                        System.out.println("2. Azucar: " + VentasAzucarRanking + " kg");
                        if (VentasAvenaRanking >= VentasTrigoRanking) {
                            // si las ventas de avena son mayor igual a las de trigo,
                            // entonces el avena sera el 3 lugar y el trigo, sera el 4 lugar.
                            System.out.println("3. Avena: " + VentasAvenaRanking + " kg");
                            System.out.println("4. Trigo: " + VentasTrigoRanking + " kg");
                        } else {
                            // si no es asi que, la avena sea 3 lugar y el trigo 4,
                            // entonces sera el trigo 3 lugar y la avena ultimo lugar.
                            System.out.println("3. Trigo: " + VentasTrigoRanking + " kg");
                            System.out.println("4. Avena: " + VentasAvenaRanking + " kg");
                        }
                        // si no si que el azucar sea 2 lugar, entonces avena sera 2 lugar, 
                        // asi que si las ventas de avena son mayor igual que las ventas de azucar y, si las ventas de avena son mayor igual que las ventas de trigo,
                        // entonces la avena sera el 2 lugar.
                    } else if (VentasAvenaRanking >= VentasAzucarRanking && VentasAvenaRanking >= VentasTrigoRanking) {
                        System.out.println("2. Avena: " + VentasAvenaRanking + " kg");
                        // si las ventas de azucar son mayor igual a las ventas de trigo,
                        // entonces el azucar sera 3 lugar y el trigo sera el 4 lugar.
                        if (VentasAzucarRanking >= VentasTrigoRanking) {
                            System.out.println("3. Azucar: " + VentasAzucarRanking + " kg");
                            System.out.println("4. Trigo: " + VentasTrigoRanking + " kg");
                        } else {
                            // si no es asi, que el azucar sea 3 lugar y el trigo sea 4 lugar,
                            // entonces el trigo sera 3 y el azucar 4.
                            System.out.println("3. Trigo: " + VentasTrigoRanking + " kg");
                            System.out.println("4. Azúcar: " + VentasAzucarRanking + " kg");
                        }
                    } else {
                        // si no es asi que, la avena este en el segundo puesto del ranking,
                        // entonces, lo sera el trigo.
                        System.out.println("2. Trigo: " + VentasTrigoRanking + " kg");
                        // si las ventas de azucar son mayores o iguales a las ventas de avena,
                        // entonces, azucar quedara en 3 lugar, y la avena quedara en 4 puesto.
                        if (VentasAzucarRanking >= VentasAvenaRanking) {
                            System.out.println("3. Azucar: " + VentasAzucarRanking + " kg");
                            System.out.println("4. Avena: " + VentasAvenaRanking + " kg");
                        } else {
                            // si no es asi que, el azucar quede en 3 puesto y el avena en 4,
                            // entonces, sera lo opuesto avena de 3 lugar y el Azuca de ultimo.
                            System.out.println("3. Avena: " + VentasAvenaRanking + " kg");
                            System.out.println("4. Azucar: " + VentasAzucarRanking + " kg");
                        }
                    }
                }

// ----------------5. CIERRE DE CAJA-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------                
// ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            } else if (opcionMenu == 5) {

                System.out.println("\nTotal de Ganancia del dia: " + caja);
                System.out.println("Cuanto de este efectivo quiere depositar en el Banco? (Maximo 60%): ");
                deposito = lea.nextDouble();

                // error por si el usuario ingresa el 0 o un numero menor.
                while (deposito <= 0) {
                    System.out.println("No puedes ingresar un numero 0 o menor, favor ingresa de nuevo la cantidad que ingresara al banco.");
                    deposito = lea.nextDouble();
                }

                // si el deposito que se ingreso es mayor a la caja por el 60%
                // entonces saldra este mensaje.
                if (deposito > caja * 0.60) {
                    System.out.println("No puede depositar mas del 60% de la caja.");
                } else { // si no, el deposito se realizara.
                    caja = caja - deposito;
                    System.out.println("Deposito realizado, efectivo restante en caja: " + caja);
                }

                // la caja se cierra = a falso.
                cajaAbierta = false;
                System.out.println("Caja Cerrada.");

                // aqui se llaman de vuelta a todas la variables inicializadas en cero
                // para que todos los contadores se reinicien y vuelvan a cero.
                subTotalVenta = 0;
                PrecioProducto = 0;
                Descuento = 0;
                numeroVentas = 0;
                numeroCompras = 0;
                VolumenTotalCompra = 0;
                VolumenTotalVenta = 0;
                ValorMedioVentas = 0;
                ValorMedioCompras = 0;
                MayorGananciaVenta = 0;
                MayorGastoCompra = 0;
                InventarioAzucar = 0;
                InventarioAvena = 0;
                InventarioTrigo = 0;
                InventarioMaiz = 0;
                maxKilos = 0;
                productoEstrella = "";
                VentasAzucarRanking = 0;
                VentasAvenaRanking = 0;
                VentasTrigoRanking = 0;
                VentasMaizRanking = 0;

// -------------------6. SALIDA, DESPEDIDA-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------                
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            } else if (opcionMenu == 6) {
                // mensaje de despedida.
                System.out.println("Gracias por comprar en la tienda de Roy's.");
            }
        }
    }
}
