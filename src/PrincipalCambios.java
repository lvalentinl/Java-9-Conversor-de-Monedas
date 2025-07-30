import java.util.InputMismatchException;
import java.util.Scanner;

public class PrincipalCambios {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decision;
        do {
            String cambio = "";
            String destino = "";
            double cantidad = 0 ;

            MenuPresentacion menu = new MenuPresentacion();
            System.out.println(menu.obtenerMenu());

            System.out.println("Digite la opción del menu que desea utilizar \n ");

            while (true){
                try {
                    decision = scanner.nextInt();
                    break;
                } catch (InputMismatchException e){
                    System.out.println("Error: Ingrese un numero valido");
                    scanner.next();
                }
            }

            if (decision >=1 && decision <= 7){
                switch (decision){
                    case 1 -> {cambio = "USD"; destino ="ARS"; }
                    case 2 -> {cambio = "ARS"; destino ="USD"; }
                    case 3 -> {cambio = "USD"; destino ="BRL"; }
                    case 4 -> {cambio = "BRL"; destino ="USD"; }
                    case 5 -> {cambio = "USD"; destino ="COP"; }
                    case 6 -> {cambio = "COP"; destino ="USD"; }
                    case 7 -> {System.out.println("Digite su tipo de cambio, ejemplo: USD, PEN, ARS");
                        cambio = scanner.next();
                        System.out.println("Digite la moneda de destino");
                        destino = scanner.next();
                    }
                }
            } else {
                System.out.println("Ingrese un valor válido");
                continue;
            }

            System.out.println("Digite el monto que desa cambiar");
            cantidad = scanner.nextDouble();

            TiposDeCambio tipos = HttpAPICliente.obtenerTasaCambio(cambio, destino, cantidad);

            if (tipos != null && tipos.conversion_rate() != null) {
                System.out.println("Tasa de conversión: " + tipos.conversion_rate());
                System.out.println("Moneda base: " + tipos.base_code());
                System.out.println("Cambio: " + destino + " → " + tipos.conversion_result());
            } else {
                System.out.println("Error: No se pudo obtener el tipo de cambio.");
            }

            System.out.println("¿Desea seguir utilizando el conversor? (1: Sí, 0: No)");
            decision = scanner.nextInt();

        } while (decision == 1);

        System.out.println("Gracias por usar el conversor de monedas. ¡Vuelva Pronto!");
        scanner.close();
    }

}
