package appmoviles.com.clientejson;

public class Usuario {

    private String nombre;
    private String correo;
    private String username;


    public Usuario(String nombre, String correo, String username) {
        this.nombre = nombre;
        this.correo = correo;
        this.username = username;
    }

    public Usuario() {
        //Es un requerimiento para GSON -> Google de JSON
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
