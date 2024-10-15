# Conversor de Monedas

Este es un proyecto en Java que realiza la conversión entre diferentes divisas utilizando una API externa para obtener las tasas de cambio en tiempo real.

## Descripción del Proyecto

El programa ofrece la funcionalidad de convertir valores entre diferentes divisas predefinidas, tales como dólares, pesos argentinos, reales brasileños y pesos colombianos. Además, permite realizar conversiones personalizadas; para ello, el usuario debe ingresar el código ISO de tres letras de cada divisa correspondiente al país y moneda que desea convertir. En esta opción, el programa proporciona una lista con las 20 divisas más comunes. De esta manera, el usuario puede seleccionar una conversión predefinida o ingresar manualmente las monedas que desea convertir. La aplicación interactúa con la API [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener los datos de conversión.

### Funcionalidades

1. Conversión entre dólares y varias divisas de América Latina.
2. Opción para ingresar monedas personalizadas.
3. Manejo de excepciones para entradas inválidas.
4. Validación del código de moneda ingresado.
5. Integración con la API de ExchangeRate-API.

## Estructura del Código

El proyecto está dividido en varias clases:

- **Main**: Contiene el menú principal y la lógica para interactuar con el usuario.
- **ConversionMonedas**: Maneja las entradas personalizadas y las conversiones estándar.
- **Moneda**: Representa los datos de la moneda, incluyendo la tasa de conversión y el resultado.
- **MonedaApi**: Clase que modela la respuesta JSON recibida de la API.
- **ConexionAPI**: Clase que se encarga de realizar la consulta HTTP a la API y devolver los resultados.

## Uso del Programa

1. **Seleccionar una conversión predefinida**: El menú principal te permitirá elegir entre las opciones disponibles para convertir dólares a otras monedas y viceversa.
2. **Conversión personalizada**: Permite al usuario ingresar el código de las monedas que desea convertir de forma manual.

### Ejemplo de Ejecución:

```plaintext
Bienvenid@ al conversor de moneda
Elija una opcion
1. Dolar =>> peso Argentino
2. peso Argentino =>> Dolar
3. Dolar =>> Real Brasileño
4. Real Brasileño =>> Dolar
5. Dolar =>> peso Colombiano
6. peso Colombiano =>> Dolar
7. Coversion Personalizada
8. Salir

Opción seleccionada: 1
Ingrese el valor (monto) que desea convertir:
100

_______________________________________________________________________________________________________

El valor: 100.00 [USD] corresponde al valor final de ==> 34,000.00 [ARS]
_______________________________________________________________________________________________________
```
Si eliges la opción 7 (conversión personalizada), el programa pedirá los códigos de las monedas que deseas convertir:
```
Aquí tienes 20 de las divisas más utilizadas como sugerencia

USD  - Dólar estadounidense    |  EUR  - Euro                    |  JPY  - Yen japonés             |  GBP  - Libra esterlina       
AUD  - Dólar australiano        |  CAD  - Dólar canadiense         |  CHF  - Franco suizo            |  CNY  - Yuan chino             
SEK  - Corona sueca             |  NZD  - Dólar neozelandés        |  MXN  - Peso mexicano           |  SGD  - Dólar de Singapur      
HKD  - Dólar de Hong Kong       |  NOK  - Corona noruega           |  KRW  - Won surcoreano          |  TRY  - Lira turca             
INR  - Rupia india              |  RUB  - Rublo ruso               |  BRL  - Real brasileño          |  ZAR  - Rand sudafricano       

Ingrese el código (ISO de 3 letras) de la divisa que desea convertir:
USD
Ingrese el código (ISO de 3 letras) de la divisa a la cual quiere convertir:
EUR
Ingrese el monto que desea convertir:
150

_______________________________________________________________________________________________________

El valor: 150.00 [USD] corresponde al valor final de ==> 137.00 [EUR]
_______________________________________________________________________________________________________
```
## Instalación y Ejecución
### Requisitos
- **JDK 17 o superior**
- **Dependencias para utilizar Gson para el parseo de JSON.**
- **Conexión a Internet.**
- **Clave de API de ExchangeRate  (puedes obtenerla gratuitamente [Aquí](https://www.exchangerate-api.com/) ).**

### Clonar el repositorio

Para clonar el repositorio, usa el siguiente comando en tu terminal:

```bash
git clone https://github.com/Michaeltronik/Conversor-de-moneda.git
```
## Mejoras futuras
- **Adaptar el codigo para conectar con otras API**
- **añadir un historial de conversiones.**
- **Crear una interfaz gráfica para mejorar la experiencia del usuario.**

