package src;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Locale;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al conversor de monedas del challange Alura!");
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nQué operación desea realizar?: ");
            System.out.println(
                    """
                            1) Dólar a peso argentino
                            2) Peso argentino a Dólar
                            3) Dólar a Real brasileño
                            4) Real brasileño a Dólar
                            5) Dólar a Peso colombiano
                            6) Peso colombiano a Dólar
                            7) Salir""" + "\n");

            Scanner scannerOpcion = new Scanner(System.in);
            Scanner scannerMonto = new Scanner(System.in).useLocale(Locale.US);

            int opcion = scannerOpcion.nextInt();
            double monto;
            String monedaPrincipal = "";
            String monedaCambio = "";

            switch (opcion) {
                case 1:
                    monedaPrincipal = "USD";
                    monedaCambio = "ARS";
                    break;
                case 2:
                    monedaPrincipal = "ARS";
                    monedaCambio = "USD";
                    break;
                case 3:
                    monedaPrincipal = "USD";
                    monedaCambio = "BRL";
                    break;
                case 4:
                    monedaPrincipal = "BRL";
                    monedaCambio = "USD";
                    break;
                case 5:
                    monedaPrincipal = "USD";
                    monedaCambio = "COP";
                    break;
                case 6:
                    monedaPrincipal = "COP";
                    monedaCambio = "USD";
                    break;
                case 7:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
                    continue;
            }

            if (!continuar) {
                break;
            }

            System.out.println("Ingrese la cantidad a convertir: ");
            try {
                monto = scannerMonto.nextDouble();
                conversion(monedaPrincipal, monedaCambio, monto);
            } catch (InputMismatchException e) {
                System.out.println("Entrada de datos inválida, por favor ingrese un valor numérico.");
                scannerMonto.next();
            }
        }



        System.out.println("Fin del programa.");

    }
    public static void conversion(String monedaPrincipal,String monedaAcambiar,double cant){
        ConsultaMoneda consulta = new ConsultaMoneda();
        try{
            Moneda miConversion = consulta.hacerConversion(monedaPrincipal,monedaAcambiar,cant);
            String cantidadNormalizada = String.format("%.0f", cant);
            String resultadoConversion = String.format("%.0f", miConversion.conversion_result());
            System.out.println("La cantidad de "+ cantidadNormalizada + " " + monedaPrincipal + " equivale a " + resultadoConversion + " " + monedaAcambiar);
        }   catch (Exception e){
            System.out.println("Error en la conversion o en la solicitud de la API: "+e.getMessage());
        }
    }
}