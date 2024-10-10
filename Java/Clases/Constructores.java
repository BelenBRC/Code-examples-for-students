public class Constructores {
    //Variables
    private String nombre;
    private String apellidos;
    private int edad;

    //Constructores

    //Constructor por defecto
    //Si lo establecemos como privado, no se podrá crear una instancia de la clase sin parámetros
    private Constructores(){
        setNombre("");
        setApellidos("");
        setEdad(0);
    }

    //Constructor con todos los parámetros
    public Constructores(String nombre, String apellidos, int edad){
        setNombre(nombre);
        setApellidos(apellidos);
        setEdad(edad);
    }

    //Constructor con nombre y edad
    public Constructores(String nombre, int edad){
        setNombre(nombre);
        setApellidos("");  //No es necesario, pero es recomendable inicializar todas las variables
        setEdad(edad);
    }

    //Setters y getters
    public String getNombre(){
        return this.nombre;
    }
    private void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getApellidos(){
        return this.apellidos;
    }
    private void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    public int getEdad(){
        return this.edad;
    }
    //Podemos usar los setters para validar los valores
    private void setEdad(int edad){
        if(edad >= 0 && edad <= 120){
            this.edad = edad;
        }
    }


    //Main para probar la clase
    public static void main(String[] args){
        //Creamos una instancia de la clase con el constructor por defecto
        //Recordemos que si el constructor es privado, no se podrá crear una instancia sin parámetros desde fuera de la clase
        Constructores instancia1 = new Constructores();
        System.out.println(instancia1.getNombre());
        System.out.println(instancia1.getApellidos());
        System.out.println(instancia1.getEdad());

        //Creamos una instancia de la clase con el constructor con todos los parámetros
        Constructores instancia2 = new Constructores("Juan", "Pérez", 30);
        System.out.println(instancia2.getNombre());
        System.out.println(instancia2.getApellidos());
        System.out.println(instancia2.getEdad());

        //Creamos una instancia de la clase con el constructor con nombre y edad
        Constructores instancia3 = new Constructores("María", 25);
        System.out.println(instancia3.getNombre());
        System.out.println(instancia3.getApellidos());
        System.out.println(instancia3.getEdad());
    }

}
