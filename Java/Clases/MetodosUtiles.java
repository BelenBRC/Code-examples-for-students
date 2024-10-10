public class MetodosUtiles {
    //Variables
    private String dni; //Esta variable nos sirve de identificador único
    private String nombre;
    private String apellidos;

    //Constructores
    //Constructor por defecto
    private MetodosUtiles(){
        this.dni = setDni("ND");
        this.nombre = setNombre("ND");
        this.apellidos = setApellidos("ND");
    }

    //Constructor con todos los parámetros
    public MetodosUtiles(String dni, String nombre, String apellidos){
        this.dni = setDni(dni);
        this.nombre = setNombre(nombre);
        this.apellidos = setApellidos(apellidos);
    }

    //Constructor con parámetros mínimos
    public MetodosUtiles(String dni){
        this.dni = setDni(dni);
        this.nombre = setNombre("");
        this.apellidos = setApellidos("");  
    }

    //Setters y getters
    public String getDni(){
        return this.dni;
    }
    private void setDni(String dni){
        if(dniValido(dni)){
            this.dni = dni;
        }
    }
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

    //Métodos
    private boolean dniValido(String dni){
        boolean valido = false;
        if(dni.length() == 9){
            try{
                Integer numero = Integer.parseInt(dni.substring(0, 8));
                Character letra = dni.charAt(8);
                valido = letraDNIValida(numero, letra);
            }catch(Exception e){
                valido = false;
            }
        }
        return valido;
    }

    private boolean letraDNIValida(Integer dni, Character letra){
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        
        int resto = dni % 23;
        char letraCalculada = letras.charAt(resto);

        return letra == letraCalculada;
    }

    //Método para mostrar los datos
    @Override
    public String toString() {
        return "DNI: " + this.getDni() + "\n" +
               "Nombre: " + this.getNombre() + "\n" +
               "Apellidos: " + this.getApellidos();
    }

    //Método para imprimir los datos en formato tabla
    public String toString(boolean formatoTabla){
        if (formatoTabla){
            return this.getDni() + 
                "\t" + this.getNombre() + 
                "\t" + this.getApellidos();
        }else{
            return this.toString();
        }
    }

    //Método para comparar dos objetos
    public boolean equals(MetodosUtiles otro){
        return this.getDni().equals(otro.getDni());
    }

    //Main
    public static void main(String[] args){
        //Instancias
        MetodosUtiles persona1 = new MetodosUtiles("12345678Z", "Juan", "Pérez");
        MetodosUtiles persona2 = new MetodosUtiles("12345678Z");
        MetodosUtiles persona3 = new MetodosUtiles("23456789A", "Ana", "Gómez");

        //Probamos el método toString
        System.out.println(persona1); //Ejecutamos el método toString
        System.out.println(persona1.toString()); //Igual que el anterior
        System.out.println(persona1.toString(true)); //Ejecutamos el método toString con formato tabla

        //Probamos el método equals
        System.out.println(persona1.equals(persona2));
        //Devuelve true porque los dos objetos tienen el mismo DNI
        System.out.println(persona1.equals(persona3));
        //Devuelve false porque los dos objetos tienen distinto DNI
    }
}
