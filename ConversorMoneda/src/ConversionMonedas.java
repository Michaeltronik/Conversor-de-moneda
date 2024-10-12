import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversionMonedas  {

    public ConversionMonedas() {

    }

    public void entradaPersonalizada(Scanner teclado) throws IOException, InterruptedException {

        while (true) {
            System.out.println("Aquí tienes 20 de las divisas mas utilizadas como sugerencia\n");
            mostrarMonedasSugeridas();
            System.out.println("ingrese el codigo (ISO de 3 letras)de la divisa que desea convertir");

            String monedaBase = validarEntrada(teclado);


            System.out.println("ingrese el codigo (ISO de 3 letras)de la divisa a la cual quiere convertir: ");

            String monedaObjetivo = validarEntrada(teclado);


            while (true) {
                System.out.println("ingrese el monto que desa convertir:");
                try {
                    // Intentar leer un número entero
                    double cantidad = teclado.nextDouble();

                    if (cantidad>0){
                        Main.mostrarInfo(monedaBase, monedaObjetivo, cantidad);

                        break; // Salir del bucle si la entrada es válida
                    }

                } catch (InputMismatchException e) {
                    // Si ocurre un InputMismatchException, se captura aquí
                    System.out.println("Error: entrada no válida. Por favor, ingresa un número entero.");
                    teclado.nextLine(); // Limpiar el buffer de entrada
                }
            }
break;
        }
    }
    public static String validarEntrada(Scanner teclado) {
        String regex = "^[a-zA-Z]{3}$"; // Expresión regular para verificar 3 letras
        String moneda;

        while (true) {
            moneda = teclado.nextLine(); // Leer nueva entrada del usuario

            if (moneda.matches(regex)) { // Validar la entrada
                moneda = moneda.toUpperCase(); // Convertir a mayúsculas
                System.out.println("Entrada válida: " + moneda);
                return moneda; // Retornar la entrada válida
            } else {
                System.out.println("Error: El código debe contener exactamente 3 letras.");
                System.out.println("Por favor intente de nuevo:");
            }
        }
    }

    public static void mostrarMonedasSugeridas(){
        HashMap<String, String> monedas = new HashMap<>();

        // Agregar monedas al HashMap
        monedas.put("USD", "Dólar estadounidense");
        monedas.put("EUR", "Euro");
        monedas.put("JPY", "Yen japonés");
        monedas.put("GBP", "Libra esterlina");
        monedas.put("AUD", "Dólar australiano");
        monedas.put("CAD", "Dólar canadiense");
        monedas.put("CHF", "Franco suizo");
        monedas.put("CNY", "Yuan chino");
        monedas.put("SEK", "Corona sueca");
        monedas.put("NZD", "Dólar neozelandés");
        monedas.put("MXN", "Peso mexicano");
        monedas.put("SGD", "Dólar de Singapur");
        monedas.put("HKD", "Dólar de Hong Kong");
        monedas.put("NOK", "Corona noruega");
        monedas.put("KRW", "Won surcoreano");
        monedas.put("TRY", "Lira turca");
        monedas.put("INR", "Rupia india");
        monedas.put("RUB", "Rublo ruso");
        monedas.put("BRL", "Real brasileño");
        monedas.put("ZAR", "Rand sudafricano");

        // Definir el número de columnas para la impresión
        int columnas = 4;
        int contador = 0;

        // Recorrer el HashMap y imprimir las monedas
        for (String codigo : monedas.keySet()) {
            System.out.printf("%-5s - %-25s", codigo, monedas.get(codigo));
            contador++;
            if (contador % columnas == 0) {
                System.out.println(); // Salto de línea después de cada fila
            } else {
                System.out.print("  |  "); // Separador entre columnas
            }
        }
    }
}
