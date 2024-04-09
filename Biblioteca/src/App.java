import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App extends Libro{
    static ArrayList<String> empleados = new ArrayList<>();
    static ArrayList<String> usuarios = new ArrayList<>();    
    static ArrayList<Libro> libros = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void precargaColecciones(){
        empleados.add("Alberto");
        empleados.add("Encarna");
        empleados.add("Estela");
        empleados.add("Manolo");
        empleados.add("Agustín");
        usuarios.add("usu1");
        usuarios.add("usu2");
        usuarios.add("usu3");
        usuarios.add("usu4");
        usuarios.add("usu5");
    }

    public static void altaLibro(){
        System.out.println("Introduzca el titulo:");
        String titulo = sc.nextLine();
        System.out.println("Introduzca el autor:");
        String autor = sc.nextLine();
        System.out.println("Introduzca la editorial:");
        String editorial = sc.nextLine();
        System.out.println("Introduzca la ubicación (pasillo numérico):");
        int ubicacion = sc.nextInt();
        System.out.println("Introduzca el ISBN:");
        String ISBN = sc.nextLine();
        System.out.println("Introduzca el precio:");
        double precio = sc.nextDouble();
        sc.nextLine();

        libros.add(new Libro(titulo, autor, editorial, ubicacion, ISBN, precio));
    }

    public static void menuBusquedaLibro(){
        int x = 1;
        System.out.println("Que va a introducir para la búsqueda: \n 1. Título \n 2. Autor \n 3. Editorial \n 4. Ubicación \n 5. ISBN \n 6. Nombre del empleado que ha prestado el libro \n 7. Estado préstamo \n 8. Nombre usuario que ha alquilado el libro \n 9. Salir");
        int eleccionBusquedaLibro = sc.nextInt();
        sc.nextLine();
        if (eleccionBusquedaLibro!=9) {
            switch (eleccionBusquedaLibro) {
                case 1:
                    System.out.println("Introduzca el título del libro que desea buscar:");
                    String busquedaTitulo = sc.nextLine();
                    System.out.println("Libros encontrados:");
                    for (Libro lib:libros) {
                        if (lib.getTitulo().equalsIgnoreCase(busquedaTitulo)) {
                            System.out.println(x + ". " + lib.toString());
                            x++;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Introduzca el autor del libro que desea buscar:");
                    String busquedaAutor = sc.nextLine();
                    System.out.println("Libros encontrados:");
                    for (Libro lib:libros) {
                        if (lib.getAutor().equalsIgnoreCase(busquedaAutor)) {
                            System.out.println(x + ". " + lib.toString());
                            x++;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Introduzca el título del libro que desea buscar:");
                    String busquedaEditorial = sc.nextLine();
                    System.out.println("Libros encontrados:");
                    for (Libro lib:libros) {
                        if (lib.getEditorial().equalsIgnoreCase(busquedaEditorial)) {
                            System.out.println(x + ". " + lib.toString());
                            x++;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Introduzca la ubicación del libro que desea buscar:");
                    int busquedaUbicacion = sc.nextInt();
                    System.out.println("Libros encontrados:");
                    for (Libro lib:libros) {
                        if (lib.getUbicacionBiblioteca()==busquedaUbicacion) {
                            System.out.println(x + ". " + lib.toString());
                            x++;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Introduzca el ISBN del libro que desea buscar:");
                    String busquedaISBN = sc.nextLine();
                    System.out.println("Libros encontrados:");
                    for (Libro lib:libros) {
                        if (lib.getISBN().equalsIgnoreCase(busquedaISBN)) {
                            System.out.println(x + ". " + lib.toString());
                            x++;
                        }
                    }
                    break;
                case 6:
                    System.out.println("Introduzca el nombre del empleado que desea buscar:");
                    String busquedaEmpleado = sc.nextLine();
                    System.out.println("Libros encontrados:");
                    for (Libro lib:libros) {
                        if (lib.getBibliotecarioPrestado().equalsIgnoreCase(busquedaEmpleado)) {
                            System.out.println(x + ". " + lib.toString());
                            x++;
                        }
                    }
                    break;
                case 7:
                    System.out.println("Introduzca el estado del prestamo (true | false) que desea buscar:");
                    Boolean busquedaPrestamo = sc.nextBoolean();
                    System.out.println("Libros encontrados:");
                    for (Libro lib:libros) {
                        if (lib.isEstadoPrestamo()==busquedaPrestamo) {
                            System.out.println(x + ". " + lib.toString());
                            x++;
                        }
                    }
                    break;
                case 8:
                    System.out.println("Introduzca el del usuario que desea buscar:");
                    String busquedaUsuario = sc.nextLine();
                    System.out.println("Libros encontrados:");
                    for (Libro lib:libros) {
                        if (lib.getUsuarioLibro().equalsIgnoreCase(busquedaUsuario)) {
                            System.out.println(x + ". " + lib.toString());
                            x++;
                        }
                    }
                    break;
            }
            
        }
    }

    public static void eliminarLibro(){
        System.out.println("Introduzca el título del libro listado a eliminar:");
        String eliminar = sc.nextLine();
        Iterator<Libro> iterador = libros.iterator();
        while (iterador.hasNext()) {
            if (iterador.next().getTitulo().equalsIgnoreCase(eliminar)) {
                libros.remove(iterador.next());
            }
        }
    }

    public static void alquilarLibro(){
        System.out.println("Mostrando libros disponibles:");
        int x = 1;
        for (Libro lib : libros) {
            if (lib.isEstadoPrestamo()==false) {
                System.out.println(x + ".   " + lib.toString());
            }
        }
        System.out.println("Introduzca el título del libro a alquilar:");
        String libroAlquilado = sc.nextLine();
        System.out.println("Elige su usuario:");
        for (String usu : usuarios) {
            System.out.println(usu);
        }
        String usuarioAlquiler = sc.nextLine();
        System.out.println("Elige el nombre del empleado que le a atendido:");
        for (String emp : empleados) {
            System.out.println(emp);
        }
        String empleadoAlquiler = sc.nextLine();
        Iterator<Libro> iterador = libros.iterator();
        while (iterador.hasNext()) {
            if (iterador.next().getTitulo().equalsIgnoreCase(libroAlquilado)) {
                iterador.next().setEstadoPrestamo(true);
                iterador.next().setBibliotecarioPrestado(empleadoAlquiler);
                iterador.next().setUsuarioLibro(usuarioAlquiler);
            }
        }
    }

    public static void devolucionLibro(){
        System.out.println("Mostrando libros alquilados:");
        int x = 1;
        for (Libro lib : libros) {
            if (lib.isEstadoPrestamo()==false) {
                System.out.println(x + ".   " + lib.toString());
            }
        }
        
    }
    public static void main(String[] args) throws Exception {
        //Precargando colección empleados y usuarios
        precargaColecciones();

        int eleccion = 0;
        do {
            //Objetos Anti-Hardcoding
            libros.add(new Libro("El Mentalista", "Camilla Läckberg", "Editorial Planeta", false, 1, "978-84-08-25519-2", 14.99, null, null));
            //Menú Principal
            System.out.println("Bienvenido al sistema gestor de la biblioteca: \n 1. Dar de alta un libro \n 2. Búsqueda de libro \n 3. Dar de baja un libro \n 4. Alquilar libro \n 5. Devolución libro \n 6. Gestión de emplead@s \n 7. Gestión de usuari@s \n 8. Salir del sistema");
            eleccion = sc.nextInt();
            sc.nextLine();
            switch (eleccion) {
                case 1:
                    altaLibro();
                    break;
                case 2:
                    menuBusquedaLibro();
                    break;
                case 3:
                    menuBusquedaLibro();
                    eliminarLibro();
                    break;
                case 4:
                    alquilarLibro();
                    break;
                case 5:
                    
                    break;
            }
        } while (eleccion!=8);
    }
}
