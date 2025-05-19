package modelo;

public class modelo {
    private final String nombre;
    private final String apellido;
    private final String usuario;

    public modelo(String nombre, String apellido, String usuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }


    public String getUsuario() {
        return usuario;
    }
}
