// Código de ejemplo para explicar una clase en Java

// Una clase es una plantilla para crear objetos
// En Java, una clase es un bloque de código que define un objeto
// Una clase puede contener campos (variables) y métodos (funciones)

// La palabra clave "class" se utiliza para definir una clase
// El nombre de la clase debe comenzar con una letra mayúscula
// El nombre de la clase debe ser único dentro del paquete

/**
 * Clase de ejemplo Java en la que representaremos un perfil de usuario
 */
public class Clase {
    // Campos (variables) de la clase
    // Los campos representan el estado de un objeto
    // Los campos también se conocen como variables de instancia
    // Los campos pueden ser de cualquier tipo de datos, incluidos tipos primitivos y objetos
    // Los campos pueden ser públicos, privados o protegidos

    //Es buena práctica que todos los campos sean privados y se accedan a través de métodos públicos (getters y setters)

    // Declaración de los campos de la clase
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private int edad;
    private String claveAcceso;
    private String telefono;

    // Getters y setters
    // Los getters y setters son métodos que se utilizan para acceder y modificar los campos de una clase
    // Los getters se utilizan para obtener el valor de un campo
    // Los setters se utilizan para establecer el valor de un campo

    // Por lo general, casi todos los getters son públicos y los setters son públicos o protegidos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        // La palabra clave "this" se utiliza para hacer referencia al objeto actual
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    // Se pueden utilizar los setters para validar los valores de los campos
    public void setEdad(int edad) {
        // Validar que la edad sea mayor o igual a 0
        if (edad >= 0) {
            this.edad = edad;
        } else {
            System.out.println("La edad no puede ser negativa");
        }
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }   

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    // Constructores
    // Un constructor es un método especial que se utiliza para inicializar un objeto
    // Un constructor tiene el mismo nombre que la clase
    // Un constructor no tiene tipo de retorno
    // Un constructor se invoca utilizando la palabra clave "new" seguida del nombre de la clase

    // Un constructor por defecto (sin argumentos) se crea automáticamente si no se define ningún constructor en la clase
    // Inicializa los campos de la clase con valores predeterminados

    // Declaración de un constructor por defecto
    private Clase() {
        // Inicializar los campos de la clase con valores predeterminados
        // Es preferible hacerlo con setters para poder validar los valores
        this.setNombre("");
        this.setApellido1("");
        this.setApellido2("");
        this.setEmail("");
        this.setEdad(0);
        this.setClaveAcceso("");
        this.setTelefono("");
    }

    // Se pueden declarar varios constructores en una clase, siempre y cuando tengan diferentes listas de argumentos
    // Esto se conoce como sobrecarga de constructores

    // Declaración de un constructor con todos los argumentos
    public Clase(String nombre, String apellido1, String apellido2, String email, int edad, String claveAcceso, String telefono) {
        // Inicializar los campos de la clase con los valores proporcionados
        this.setNombre(nombre);
        this.setApellido1(apellido1);
        this.setApellido2(apellido2);
        this.setEmail(email);
        this.setEdad(edad);
        this.setClaveAcceso(claveAcceso);
        this.setTelefono(telefono);
    }

    //Declaración de un constructor con los argumentos mínimos
    public Clase(String nombre, String apellido1, String email, String claveAcceso) {
        // Inicializar los campos de la clase con los valores proporcionados
        // El resto de campos se inicializan con valores predeterminados
        this.setNombre(nombre);
        this.setApellido1(apellido1);
        this.setApellido2("");
        this.setEmail(email);
        this.setEdad(0);
        this.setClaveAcceso(claveAcceso);
        this.setTelefono("");
    }

    // Efectivamente, si decimos que existen argumentos mínimos, es porque no se pueden dejar campos vacíos
    // Se puede hacer que el constructor por defecto sea privado, de esta forma no se podrá crear un objeto sin los campos mínimos



    // Métodos
    // Los métodos son funciones que se utilizan para realizar operaciones en un objeto
    // Los métodos pueden acceder y modificar los campos de la clase
    // Los métodos pueden ser públicos, privados o protegidos

    // Los métodos que siempre suelen declararse son los métodos toString() y equals()

    // Método toString()
    // El método toString() se utiliza para devolver una representación de cadena del objeto
    // Se utiliza para imprimir o mostrar el objeto de una manera legible para los humanos

    // Declaración del método toString()
    @Override
    public String toString() {
        // Para acceder a los campos de la clase, se utilizan los getters
        return "Nombre: " + this.getNombre() + "\n" +
               "Apellido1: " + this.getApellido1() + "\n" +
               "Apellido2: " + this.getApellido2() + "\n" +
               "Email: " + this.getEmail() + "\n" +
               "Edad: " + this.getEdad() + "\n" +
               "Clave de acceso: " + this.getClaveAcceso() + "\n" +
               "Teléfono: " + this.getTelefono();
    }

    // Se pueden declarar distintos toString() si se sobrecargan, es decir, si tienen diferentes listas de argumentos
    public String toString(boolean formatoTabla){
        if (formatoTabla){
            return this.getNombre() + 
                "\t" + this.getApellido1() + 
                "\t" + this.getApellido2() + 
                "\t" + this.getEmail() + 
                "\t" + this.getEdad() + 
                "\t" + this.getClaveAcceso() + 
                "\t" + this.getTelefono();
        } else {
            return toString();
        }
    }


    // Método equals()
    // El método equals() se utiliza para comparar dos objetos
    // Se utiliza para verificar si dos objetos son iguales o no

    // Declaración del método equals()
    @Override
    public boolean equals(Object obj) {
        boolean iguales = false;

        // Aquí podemos hacer la comprobación que queramos
        // Por ejemplo, podemos decir que si el email es el mismo, los objetos son iguales

        if (obj instanceof Clase){
            if (this.getEmail().equals(obj.getEmail())){
                iguales = true;
            }
        }
        else {
            iguales = false;
        }

        // Usamos instanceof para comprobar si el objeto es de la clase Clase
        // Si es así, compararemos los emails
        // En otro caso, devolvemos false
    }

    // Otros métodos para trabajar con la clase
    // Por ejemplo, un método para loguear al usuario
    public boolean loginCorrecto(String email, String claveAcceso){
        if (this.getEmail().equals(email) && this.getClaveAcceso().equals(claveAcceso)){
            return true;
        } else {
            return false;
        }
    }

    
}
