package Java.PasoPorValor;

//Ejemplo de comportamiento de paso de variables en Java

//En Java, las variables primitivas se pasan por valor, es decir, se pasa una copia de la variable
//y no la variable en sí. Por tanto, si se modifica la variable dentro de un método, no se modifica
//la variable original. 

//Sin embargo, si se pasa un objeto, se pasa una referencia al objeto, por lo
//que si se modifica el objeto dentro de un método, se modifica el objeto original.

//En este ejemplo, se muestra cómo se comportan las variables primitivas y los objetos al pasar los
//valores a un método.

public class PasoDeVariables {
    /**
     * Método que modifica el valor de un número entero
     * @param numero    Número entero a modificar
     * @pre             Número entero
     * @post            Se habrá modificado el valor del número entero dentro del método, pero no fuera
     */
    private static void modificarInt(int numero){
        numero = 10;
        System.out.println("Valor de número dentro de modificarInt: " + numero);
    }

    /**
     * Método que modifica el valor de un número entero encapsulado en un objeto Integer
     * @param numero    Número entero a modificar
     * @pre             Número entero encapsulado en un objeto Integer
     * @post            Se habrá modificado el valor del número entero dentro del método, pero no fuera
     */
    private static void modificarInteger(Integer numero){
        numero = 8;
        System.out.println("Valor de númeroObjeto dentro de modificarInteger: " + numero);
    }

    /**
     * Método que modifica el valor de un array de enteros
     * @param array     Array de enteros a modificar
     * @pre             Array de enteros
     * @post            Se habrá modificado el valor del array de enteros dentro del método y fuera
     */
    private static void modificarArray(int[] array){
        array[0] = 10;
        System.out.println("Valor de array[0] dentro de modificarArray: " + array[0]);
    }

    /**
     * Método que modifica el valor de una cadena de texto
     * @param cadena    Cadena de texto a modificar
     * @pre             Cadena de texto
     * @post            Se habrá modificado el valor de la cadena de texto dentro del método, pero no fuera
     */
    private static void modificarString(String cadena){
        cadena = "Hola";
        System.out.println("Valor de cadena dentro de modificarString: " + cadena);
    }

    /**
     * Método que modifica el valor de un objeto StringBuilder
     * @param cadena    Objeto StringBuilder a modificar
     * @pre             Objeto StringBuilder
     * @post            Se habrá modificado el valor del objeto StringBuilder dentro del método y fuera
     */
    private static void modificarStringBuilder(StringBuilder cadena){
        cadena.append(" Mundo");
        System.out.println("Valor de cadena dentro de modificarStringBuilder: " + cadena);
    }

    public static void main(String[] args) {
        // Prueba con int
        int numero = 5;
        System.out.println("Valor de número antes de modificarInt: " + numero);
        modificarInt(numero);
        System.out.println("Valor de número después de modificarInt: " + numero + "\n");
        // Resultado: 5 (no se modifica)
        
        // Prueba con Integer
        Integer numeroObjeto = 6;
        System.out.println("Valor de númeroObjeto antes de modificarInteger: " + numeroObjeto);
        modificarInteger(numeroObjeto);
        System.out.println("Valor de númeroObjeto después de modificarInteger: " + numeroObjeto + "\n");
        // Resultado: 6 (no se modifica)

        // Prueba con array
        int[] array = {1, 2, 3};
        System.out.println("Valor de array[0] antes de modificarArray: " + array[0]);
        modificarArray(array);
        System.out.println("Valor de array[0] después de modificarArray: " + array[0] + "\n");
        // Resultado: 10 (se modifica)

        // Prueba con String
        String cadena = "Adiós";
        System.out.println("Valor de cadena antes de modificarString: " + cadena);
        modificarString(cadena);
        System.out.println("Valor de cadena después de modificarString: " + cadena + "\n");
        // Resultado: Adiós (no se modifica)

        // Prueba con StringBuilder
        StringBuilder cadenaBuilder = new StringBuilder("Hola");
        System.out.println("Valor de cadena antes de modificarStringBuilder: " + cadenaBuilder);
        modificarStringBuilder(cadenaBuilder);
        System.out.println("Valor de cadena después de modificarStringBuilder: " + cadenaBuilder + "\n");
        // Resultado: Hola Mundo (se modifica)
    }

}

//Observamos que:
//  - Si se pasa un número entero (int), no se modifica el valor original
//  - Si se pasa un número entero (Integer), NO se modifica el valor original
//  - Si se pasa una cadena de texto (String), NO se modifica el valor original
//  - Si se pasa un array de enteros, se modifica el valor original
//  - Si se pasa un objeto StringBuilder, se modifica el valor original

//Conclusión:
//  - Las variables primitivas se pasan por valor
//  - Los objetos inmutables se pasan por valor (como String o Integer)
//  - Los objetos mutables se pasan por referencia (como StringBuilder)

//¿Qué es un objeto inmutable?
//Un objeto inmutable es un objeto cuyo estado no puede ser modificado después de su creación.
//Por ejemplo, una cadena de texto (String) es un objeto inmutable, ya que no se puede modificar
//su contenido una vez creada. Si se modifica, se crea un nuevo objeto.

//Para crear un objeto inmutable, se deben seguir las siguientes reglas:
//  - Declarar la clase como final
//  - Declarar los atributos como privados y finales
//  - No proporcionar métodos que modifiquen los atributos (los setters)
//  - Si se devuelven objetos, devolver una copia del objeto, no el objeto original