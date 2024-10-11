import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String monedaBase = "" ;
        String monedaDestino = "";
        double cantidad = 0;
        Scanner teclado = new Scanner(System.in);
        int opcion = -1;
        System.out.println("Bienvenid@ al conversor de moneda");
        while(opcion != 7) {

            System.out.println("Elija una opcion");
            System.out.println("1. Dolar =>> peso Argentino \n" +
                    "2. peso Argentino =>> Dolar\n" +
                    "3. Dolar =>> Real Brasileño\n" +
                    "4. Real Brasileño =>> Dolar\n" +
                    "5. Dolar =>> peso Colombiano\n" +
                    "6. peso Colombiano =>> Dolar\n");
            opcion = teclado.nextInt();
            teclado.nextLine();
            System.out.println("Ingrese el valor (monto) que desea convertir");
            cantidad = teclado.nextDouble();
            teclado.nextLine();

            switch (opcion){
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
                case 7:
                    System.out.println("Gracias, vuelve pronto");
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }


            mostrarInfo(monedaBase,monedaDestino,cantidad);

        }
    }
    public static void mostrarInfo(String monedaBase, String monedaDestino, double cantidad) throws IOException, InterruptedException {
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
    }
}