import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int menuOption; String insertName; int insertAge; int searchId; boolean whileoop = true;

        UsuarioCRUD dao = new UsuarioCRUD();
        Usuario usuario1 = new Usuario();
        Scanner sc = new Scanner(System.in);
        
        while(whileoop){

            System.out.println("1: Agregar usuario" + "\n2: Listar usuarios" + "\n3: Modificar usuarios" + 
            "\n4: Buscar usuarios" + "\n5: Eliminar usuario" + "\n6: Salir");
            menuOption = sc.nextInt();

            switch (menuOption) {
                case 1:
                System.out.print("Ingrese el Nombre: ");
                insertName = sc.next();
                System.out.print("Ingrese la edad: ");
                insertAge = sc.nextInt();
                usuario1.setNombre(insertName);
                usuario1.setEdad(insertAge);
                dao.guardar(usuario1);
                    break;

                case 2:
                List<Usuario> usuarios = dao.listar();
                System.out.println("Número de usuarios: " + usuarios.size());
                    for (Usuario user : usuarios) {
                        System.out.println("ID: " + user.getId() + "  ||  " + 
                        "Nombre: " + user.getNombre() + "  ||  " + "Edad:" + user.getEdad());
                    }
                    break;
                case 3:
                System.out.print("Ingrese la Id para actualizar la info: ");
                searchId = sc.nextInt();
                System.out.print("Ingrese el Nombre: ");
                insertName = sc.next();
                System.out.print("Ingrese la edad: ");
                insertAge = sc.nextInt();
                usuario1.setId(searchId);
                usuario1.setNombre(insertName);
                usuario1.setEdad(insertAge);
                dao.actualizar(usuario1);
                    break;
                case 4:
                System.out.print("Ingrese la Id: ");
                searchId = sc.nextInt();
                Usuario usuario2 = dao.buscarPorId(searchId);
                System.out.println(usuario2
                .getId() + " " + usuario2.getNombre() + " " + usuario2.getEdad());
                    break;
                case 5:
                System.out.print("Ingrese la Id: ");
                searchId = sc.nextInt();
                dao.eliminar(searchId);
                    break;
                case 6:
                whileoop = false;
                    break; 
                    
                default: System.out.println("Escriba una opcion correcta");
                    break;
                
                
            }       
        }
      
        /*
        //buscar usuario por id
        Usuario usuario1 = dao.buscarPorId(1);
        System.out.println(usuario1.getId() + " " + usuario1.getNombre() + " " + usuario1.getEdad());

        // guardar usuario
        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Juan");
        usuario2.setEdad(30);
        boolean resultado1 = dao.guardar(usuario2);
        System.out.println(resultado1);

        // actualizar usuario
        Usuario usuario3 = new Usuario();
        usuario3.setId(2);
        usuario3.setNombre("Pedro");
        usuario3.setEdad(25);
        boolean resultado2 = dao.actualizar(usuario3);
        System.out.println(resultado2);

        // eliminar usuario
        boolean resultado3 = dao.eliminar(3);
        System.out.println(resultado3);
     
        //listar usuario
        List<Usuario> usuarios = dao.listar();
        for (Usuario usuario : usuarios) {
            System.out.println(usuario.getId() + " " + usuario.getNombre() + " " + usuario.getEdad());
        }
        */
    
    }
    
}
