import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String monedaBase = "";
        String monedaDestino = "";
        double cantidad = 0;
        Scanner teclado = new Scanner(System.in);
        int opcion = -1;

        System.out.println("Bienvenid@ al conversor de moneda");

        while (opcion != 7) {

            System.out.println("Elija una opcion");
            System.out.println("1. Dolar =>> peso Argentino \n" +
                    "2. peso Argentino =>> Dolar\n" +
                    "3. Dolar =>> Real Brasileño\n" +
                    "4. Real Brasileño =>> Dolar\n" +
                    "5. Dolar =>> peso Colombiano\n" +
                    "6. peso Colombiano =>> Dolar\n" +
                    "7. Salir");
            try {
                opcion = teclado.nextInt();
                teclado.nextLine();
                if (opcion == 7) {
                    System.out.println("Gracias, vuelve pronto");
                    break;
                }
                if (opcion >= 1 && opcion <= 7) {

                    System.out.println("Ingrese el valor (monto) que desea convertir");
                    cantidad = teclado.nextDouble();
                    teclado.nextLine();
                    if (cantidad <= 0){
                        System.out.println("ha ingresado una cantidad incorrecta, vuelva a intentarlo");
                        continue;
                    }
                }
                        switch (opcion) {
                            case 1:
                                monedaBase = "USD";
                                monedaDestino = "ARS";
                                break;
                            case 2:
                                monedaBase = "ARS";
                                monedaDestino = "USD";
                                break;
                            case 3:
                                monedaBase = "USD";
                                monedaDestino = "BRL";
                                break;
                            case 4:
                                monedaBase = "BRL";
                                monedaDestino = "USD";
                                break;
                            case 5:
                                monedaBase = "USD";
                                monedaDestino = "COP";
                                break;
                            case 6:
                                monedaBase = "COP";
                                monedaDestino = "USD";
                                break;
                            case 8:
                                break;
                            default:
                                System.out.println("Opción no valida");
                                break;
                        }



            } catch (InputMismatchException | IllegalStateException e) {
                System.out.println("Error! Dato no válido");
                teclado.nextLine();
                continue;
            }


            mostrarInfo(monedaBase, monedaDestino, cantidad);


        }
    }

    public static void mostrarInfo(String monedaBase, String monedaDestino, double cantidad) throws IOException, InterruptedException {

        try {
            ConexionAPI consulta = new ConexionAPI(monedaBase, monedaDestino, cantidad);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            String respuestaJson = consulta.consultaAPI();
            MonedaApi monedaApi = gson.fromJson(respuestaJson, MonedaApi.class);
            //System.out.println(monedaApi);
            Moneda moneda = new Moneda(monedaApi, cantidad);
            if (moneda.getResultado().equalsIgnoreCase("error")) {
                System.out.println("ALERTA!!! No se ha podido proceder con la conversion, existe un dato no valido\n" +
                        "_____________________________________________________________________________________________");
            } else {
                System.out.println(moneda);
            }
        } catch (Exception e) {
            System.out.println("Error!! no se pudo realizar la conversion, Ingresó una opcion no válida");
        }
    }
}