public class Encapsulamiento {
    /*
    //Variable privada (solo accesible desde la misma clase)
    private String contrasenia = "password1";

    //Variable protegida (solo accesible desde la misma clase y sus subclases)
    protected int numeroAccesos = 0;

    //Variable publica (accesible desde cualquier clase)
    public String nombre = "Juan";

    //Variable por defecto (accesible desde cualquier clase del mismo paquete)
    int edad = 20;

    //Realmente no es buena práctica acceder directamente a las variables.
    //Lo ideal es que todas las variables sean privadas y se accedan mediante 
    //  métodos con distintos niveles de acceso.
    */

    //Variables
    private String contrasenia = "password1";
    private int numeroAccesos = 0;
    private String nombre = "Juan";
    private int edad = 20;

    //Métodos de acceso
    private String getContrasenia(){
        return this.contrasenia;
    }
    private void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }
    //Métodos de la clase
    private boolean usuarioValido(String contrasenia){
        boolean valido = false;
        if(this.getContrasenia().equals(contrasenia)){
            valido = true;
        }
        return valido;
    }
    //Método público para cambiar la contraseña
    public void cambiarContrasenia(String contraseniaAntigua, String contraseniaNueva){
        if(usuarioValido(contraseniaAntigua)){
            this.setContrasenia(contraseniaNueva);
        }
    }
}
