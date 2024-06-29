package PROYECTO_COLABORATIVO.POO5_1P_MORENO_MENDEZ_ARAUJO.Usuarios;

public class Usuario {
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected TipoUsuario tipoUsuario;
    

    public Usuario(String nombre, String apellido, String correo, TipoUsuario tipoUsuario){
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.tipoUsuario = tipoUsuario;
    }

    //Getter and Setters
    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }


    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    //método toString
    @Override
    public String toString(){
        return this.apellido + " " + this.nombre + " .Correo: " + this.correo;
    }
    

}
