package src;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ConsultaMoneda consulta = new ConsultaMoneda();
        try{
            Moneda primeraConversion = consulta.hacerConversion("USD","ARS", 1);
            System.out.println(primeraConversion);
        }   catch (Exception e){
            System.out.println("Error en la conversion o en la solicitud de la API: "+e.getMessage());
        }


    }
}