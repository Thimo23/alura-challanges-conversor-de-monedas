package src;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al conversor de monedas del challange Alura!");
        boolean continuar = true;

        while(continuar){

            System.out.println("\nQue operación desea realizar?: ");
            System.out.println(
                    """
                            1) Dólar a peso argentino
                            2)Peso argentino a Dólar
                            3)Dólar a Real brasileño
                            4)Real brasileño a Dólar
                            5)Dólar a Peso colombiano
                            6)Peso colombiano a Dólar
                            7)Salir"""+"\n");

            Scanner scannerOpcion = new Scanner(System.in);
            Scanner scannerMonto = new Scanner(System.in);

            int opcion = scannerOpcion.nextInt();
            float monto;

            switch (opcion){
                case 1:
                    System.out.println("Ingrese la cantidad a convertir: ");
                    monto= scannerMonto.nextFloat();
                    conversion("USD","ARS",monto);
                    break;
                case 2:
                    System.out.println("Ingrese la cantidad a convertir: ");
                    monto= scannerMonto.nextFloat();
                    conversion("ARS","USD",monto);
                    break;
                case 3:
                    System.out.println("Ingrese la cantidad a convertir: ");
                    monto= scannerMonto.nextFloat();
                    conversion("USD","BRL",monto);
                    break;
                case 4:
                    System.out.println("Ingrese la cantidad a convertir: ");
                    monto= scannerMonto.nextFloat();
                    conversion("BRL","USD",monto);
                    break;
                case 5:
                    System.out.println("Ingrese la cantidad a convertir: ");
                    monto= scannerMonto.nextFloat();
                    conversion("USD","COP",monto);
                    break;
                case 6:
                    System.out.println("Ingrese la cantidad a convertir: ");
                    monto= scannerMonto.nextFloat();
                    conversion("COP","USD",monto);
                    break;
                case 7:
                    continuar=false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
                    break;

            }
        }

        System.out.println("Fin del programa.");



    }
    public static void conversion(String monedaPrincipal,String monedaAcambiar,float cant){
        ConsultaMoneda consulta = new ConsultaMoneda();
        try{
            Moneda miConversion = consulta.hacerConversion(monedaPrincipal,monedaAcambiar,cant);
            System.out.println("La cantidad de "+ cant + " " + monedaPrincipal + " equivale a " + miConversion.conversion_result() + " " + monedaAcambiar);
        }   catch (Exception e){
            System.out.println("Error en la conversion o en la solicitud de la API: "+e.getMessage());
        }
    }
}