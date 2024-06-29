package Interfaz;
import java.util.Scanner;
import java.util.ArrayList;

public class Editorial {
    private Usuario usuario;

    public Editorial(){
        System.out.println("Bienvenido a la Editorial POO - GRUPO 2");
    }

    public ArrayList<String> iniciarSesion(){
        ArrayList<String> nombreApellido = new ArrayList<>();
        System.out.println(" Por favor ingrese su nombre: ");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        nombreApellido.add(nombre);
        System.out.println("Por favor, ingrese su apellido: ");
        String apellido = sc.nextLine();
        nombreApellido.add(apellido);

        return nombreApellido;
    }

    public TipoUsuario validarUsuario(ArrayList <String> nombreApellido){
        // aqui falta validar si el usuario está en la base de datos y en base a esto poder devolver, si es que está en la base de datos, su tipo de usuario. Por el momento, se creará un usuario ficticio.
        Usuario user = new Usuario("Miguel", "Bastos","mb@homail.com",TipoUsuario.AUTOR);
        return user.getTipoUsuario; 
    }

    public String mostrarMenu(Usuario user){
        if(user.getTipoUsuario == TipoUsuario.AUTOR){
            System.out.println("Bienvenido ;" + user.toString());
            //Se muestra un String de lo referente a lo que usará el autor en el editorial.
        }
        if (user.getTipoUsuarioipoUsuario != TipoUsuario.AUTOR){
            System.out.println("Bienvenido, este es el menú de " + user.getTipoUsuario.toString());
            //Se muestra un String de lo referente a lo que usará el Revisor o Editor.
        }
    }

}
