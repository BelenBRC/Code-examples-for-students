import java.util.Scanner;

//Ejemplo de programa modular en Java
//Ejercicio que permite ejecutar un menú indefinidamente
//Acciones disponibles:
//  1. Suma de dos números reales
//  2. Comprobar si un número es primo
//  3. Salir del programa

// Se muestra cómo modularizar el código en funciones y procedimientos
// Se muestra cómo captar datos por teclado con gestión de errores
// Se muestra cómo comprobar si un número es primo

// Se muestran ejemplos de comentarios de documentación Javadoc

public class Modular {
    /******************************************************************
     ***************** Variables globales del programa ****************
    ******************************************************************/
    //Objeto de tipo Scanner para captar datos por teclado
    private static Scanner scan = new Scanner(System.in);


    /******************************************************************
     ***************** Métodos y funciones auxiliares *****************
    ******************************************************************/

    /**
     * Método para captar un número entero por teclado con gestión de errores
     * @return (int) Número entero captado por teclado
     * @pre Debe haber un objeto de tipo Scanner llamado scan inicializado y accesible como variable global
     * @post Se habrá captado un número entero por teclado
     */
    private static int captarEntero(){
        int numero = 0;
        boolean error = false;

        do{
            try {
                numero = scan.nextInt();
                error = false;
            } catch (Exception e) {
                System.err.println("Error. Introduzca un número entero.");
                scan.nextLine();
                error = true;
            }
        } while (error);

        return numero;
    }

    /**
     * Método para captar un número entero positivo por teclado con gestión de errores
     * @return (int) Número entero positivo captado por teclado
     * @pre Debe haber un objeto de tipo Scanner llamado scan inicializado y accesible como variable global
     * @post Se habrá captado un número entero positivo por teclado
     * @see captarEntero
     */
    private static int captarEnteroPositivo(){
        int numero = 0;

        do{
            numero = captarEntero();
            if(numero <= 0){
                System.err.println("Error. Introduzca un número entero positivo.");
            }
        } while(numero <= 0);

        return numero;
    }


    /******************************************************************
     **************** Métodos y funciones ejercicio suma **************
    ******************************************************************/

    /**
     * Método para sumar dos números reales
     * @param a Número real a sumar
     * @param b Número real a sumar
     * @return (double) Suma de los dos números reales
     * @pre a y b deben ser números reales
     * @post Se habrá devuelto la suma de los dos números reales
     */
    private static double suma(double a, double b){
        return a + b;
    }

    /**
     * Procedimiento para sumar dos números reales
     * @pre Debe haber un objeto de tipo Scanner llamado scan inicializado y accesible como variable global
     * @post Se habrá ejecutado el ejercicio de suma y mostrado el resultado
     */
    public static void sumar(){
        //Declaración de variables
        double numero1=0, numero2=0, resultado=0;

        //Bienvenida
        System.out.println("Bienvenido a sumatrón.");

        //Solicitud de números
        System.out.print("Introduzca un número: ");
        numero1 = scan.nextDouble();
        System.out.print("Introduzca otro número: ");
        numero2 = scan.nextDouble();

        //Realizar el cálculo
        resultado = suma(numero1, numero2);

        //Mostramos el resultado
        System.out.println(numero1 + "+" + numero2 + "=" + resultado);
    }


    /******************************************************************
     **************** Métodos y funciones ejercicio primos ************
    ******************************************************************/

    /**
     * Método para comprobar si un número es primo
     * @param numero    Número a comprobar
     * @return  (boolean)   Devuelve true si el número es primo, false en caso contrario
     * @pre numero debe ser un número entero positivo
     * @post Se habrá comprobado si el número es primo
     * @see https://es.wikipedia.org/wiki/N%C3%BAmero_primo
     */
    public static boolean esPrimo(int numero){
        if(numero < 2){
            return false;
        }
        else{
            for(int i = 2; i <= Math.sqrt(numero); i++){
                if(numero % i == 0){
                    return false;
                }
            }
        }

        return true;
    }
    
    /**
     * Procedimiento para comprobar si un número es primo
     * @pre Debe haber un objeto de tipo Scanner llamado scan inicializado y accesible como variable global
     * @post Se habrá ejecutado el ejercicio de números primos y mostrado el resultado
     */
    public static void primos(){
        //Declaración de variables
        int numero = 0;

        //Bienvenida
        System.out.println("Bienvenido al ejercicio de números primos.\nLe indicaré si el número que ha introducido es o no primo.");

        //Solicitud de datos
        System.out.println("¿Qué número quiere comprobar?: ");
        numero = captarEnteroPositivo();

        //Comprobar y mostrar el resultado
        if(esPrimo(numero)){
            System.out.println(numero + " es un número primo.");
        }
        else{
            System.out.println(numero + " no es primo.");
        }
    }

    
    /******************************************************************
     ********************** Método principal **************************
    ******************************************************************/

    /**
     * Método principal del programa
     * @param args Argumentos pasados por línea de comandos (no se utilizan)
     * @pre No tiene
     * @post Se habrá ejecutado el programa Modular
     */
    public static void main(String[] args) {
        //Declaración de variables
        int opcion = 0;
        boolean salir = false;

        //Dar la bienvenida al programa
        System.out.println("¡Bienvenido al programa Modular!");

        //Bucle principal de ejecución
        do{
            //Imprimimos las opciones
            System.out.println("1. Suma de dos números");
            System.out.println("2. Número primo");
            System.out.println("3. Salir");

            //Leer la opción del usuario
            opcion = Integer.parseInt(System.console().readLine());

            //Ejecutar la opción seleccionada
            switch (opcion) {
                case 1:
                    sumar();
                    break;

                case 2:
                    primos();
                    break;
                
                case 3:
                    System.out.println("¡Hasta pronto!\n");
                    salir = true;
                    break;
            
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        } while(!salir);

        //Cerrar el scanner
        scan.close();
    }
}
