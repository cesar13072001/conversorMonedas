package org.caz;

import org.caz.api.ConsultaAPI;
import org.caz.model.ConversionResponse;
import org.caz.util.HistorialConversiones;
import org.caz.util.ObtenerHora;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ObtenerHora hora = new ObtenerHora();
        HistorialConversiones historialConversiones = new HistorialConversiones();

        ConsultaAPI api = new ConsultaAPI();
        ArrayList<ArrayList<String>> codigoResponse = api.consultaMonedas();

        int menuOpcion = 0;
        int opcionBase;
        int opcionDestino;
        double monto;
        String mensajeError = "Opción inválida. Debe estar entre 1 y " + (codigoResponse.size() - 1) + ".";

        System.out.println("***********************************************************************");
        System.out.println("                 BIENVENIDO AL CONVERSOR DE MONEDAS                     ");
        System.out.println("***********************************************************************");


        while (menuOpcion != 3) {
            System.out.print("Seleccione una opción:\n 1) Realizar una conversión\n 2) Consultar el historial de conversiones\n 3) Salir\nIngrese su opción: ");
            String captura = scanner.nextLine().trim();

            try {
                menuOpcion = Integer.parseInt(captura);
                if (menuOpcion < 1 || menuOpcion > 3) {
                    System.out.println("Opción invalida, debe estar entre 1 y 3.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Ingrese un número.");
            }


            if (menuOpcion == 1) {
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("A continuación, se muestran las monedas disponibles para la conversión:");
                System.out.println("-----------------------------------------------------------------------");


                for (int i = 0; i < codigoResponse.size() - 1; i++) {
                    System.out.println((i + 1) + ") " + codigoResponse.get(i).get(0) + ": " + codigoResponse.get(i).get(1)
                    );
                }

                System.out.println("..................................................................");
                while (true) {
                    System.out.print("Ingrese el número correspondiente a la moneda base: ");
                    String input = scanner.nextLine().trim();

                    try {
                        opcionBase = Integer.parseInt(input);
                        if (opcionBase >= 1 && opcionBase <= codigoResponse.size()) {
                            break;
                        } else {
                            System.out.println(mensajeError);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada no válida. Ingrese un número.");
                    }
                }
                System.out.println("..................................................................");
                System.out.println("..................................................................");
                while (true) {
                    System.out.print("Ingrese el número correspondiente a la moneda destino: ");
                    String input = scanner.nextLine().trim();

                    try {
                        opcionDestino = Integer.parseInt(input);
                        if (opcionDestino >= 1 && opcionDestino <= codigoResponse.size()) {
                            break;
                        } else {
                            System.out.println(mensajeError);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada no válida. Ingrese un número.");
                    }
                }
                System.out.println("..................................................................");
                System.out.println("..................................................................");
                while (true) {
                    System.out.print("Ingrese el monto a convertir: ");
                    String input = scanner.nextLine().trim();

                    try {
                        monto = Double.parseDouble(input);
                        if (monto > 0) {
                            break;
                        } else {
                            System.out.println("El monto debe ser mayor a 0.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada no válida. Ingrese un número válido (ej: 100.10).");
                    }
                }
                System.out.println("..................................................................");
                ConversionResponse response = api.consultaConversion(codigoResponse.get(opcionBase - 1).get(0), codigoResponse.get(opcionDestino - 1).get(0), monto);
                if (response != null && "success".equals(response.getResult())) {
                    String registro = "Moneda base: " + response.getBase_code() + "\n" +
                            "Moneda destino: " + response.getTarget_code() + "\n" +
                            "Tipo de cambio: " + response.getConversion_rate() + "\n" +
                            "Resultado: " + response.getConversion_result() + "\n" +
                            "Fecha consulta: " + hora.ObtenerFechaHora() + "\n" +
                            "--------------------------------------------------";

                    System.out.println(registro);
                    historialConversiones.guardarConversion(registro);

                    menuOpcion = menuPregunta(scanner);

                } else {
                    System.out.println("Volviendo al menú principal.");
                }
            } else if (menuOpcion == 2) {
                historialConversiones.mostrarHistorial();
                menuOpcion = menuPregunta(scanner);

            } else if (menuOpcion == 3) {
                System.exit(0);
            }
        }
    }


    private static int menuPregunta(Scanner scanner) {
        System.out.println("........................................................................");
        while (true) {
            System.out.print("Desea regresar al menú anterior (0) o terminar el programa (1): ");
            String input = scanner.nextLine().trim();

            try {
                int seleccion = Integer.parseInt(input);
                if (seleccion == 0) {
                    System.out.println("........................................................................");
                    return 0;
                } else if (seleccion == 1) {
                    System.out.println("........................................................................");
                    return 3;
                } else {
                    System.out.println("Opción inválida. Ingrese 0 o 1.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Ingrese un número.");
            }
        }
    }

}





