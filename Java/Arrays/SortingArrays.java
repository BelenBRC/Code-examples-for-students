// Ejemplo de algoritmos de ordenación en Java
import java.util.Arrays;

public class SortingArrays {
    // Algoritmo de ordenación por selección
    // Recorre el array buscando el menor elemento y lo intercambia con el primer elemento
    // Luego busca el segundo menor elemento y lo intercambia con el segundo elemento, y así sucesivamente
    // Complejidad: O(n^2)
    // Intercambios: O(n)
    // Comparaciones: O(n^2)
    // Recursivo: No
    // Espacio: O(1)
    // Estable: No
    public static void selectionSort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    // Algoritmo de ordenación por inserción
    // Recorre el array insertando cada elemento en su posición correcta
    // Complejidad: O(n^2)
    // Intercambios: O(n^2)
    // Comparaciones: O(n^2)
    // Recursivo: No
    // Espacio: O(1)
    // Estable: Sí
    public static void insertionSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // Algoritmo de ordenación por burbuja
    // Recorre el array comparando elementos adyacentes y los intercambia si están en el orden incorrecto
    // Complejidad: O(n^2)
    // Intercambios: O(n^2)
    // Comparaciones: O(n^2)
    // Recursivo: No
    // Espacio: O(1)
    // Estable: Sí
    public static void bubbleSort(int[] array){
        boolean cambiado = false;
        boolean continuar = true;
        for (int i = 0; i < array.length - 1 && continuar; i++) {
            continuar = true;
            cambiado = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                    cambiado = true;
                }
            }
            if (!cambiado) {
                continuar = false;
            }
        }
    }

    public static void main(String[] args) {
        // Aquí mostramos el uso de la función Arrays.sort() para ordenar arrays
        // Recordar que Arrays.sort() ordena los elementos de un array en orden ascendente
        // Si se trata de un array de Strings, se ordenan alfabéticamente
        // Necesitamos añadir la librería java.util.Arrays

        // Números
        int[] numbers = { 5, 2, 9, 1, 5, 6 };
        System.out.println("Array sin ordenar: " + Arrays.toString(numbers));
        Arrays.sort(numbers);   // Ordena el array
        System.out.println("Array ordenado: " + Arrays.toString(numbers));

        // Strings
        String[] names = { "Ana", "Juan", "Pedro", "Luis", "Maria" };
        System.out.println("Array sin ordenar: " + Arrays.toString(names));
        Arrays.sort(names);     // Ordena el array
        System.out.println("Array ordenado: " + Arrays.toString(names));

        // Char
        char[] caracteres = { 'c', 'e', '1', '.', 'A', '\'', 'F', '!', '9', ':', '_' };
        System.out.println("Array sin ordenar: " + Arrays.toString(caracteres));
        Arrays.sort(caracteres); // Ordena el array por valor ASCII
        System.out.println("Array ordenado: " + Arrays.toString(caracteres));
    }
}
