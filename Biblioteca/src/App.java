import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);

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

        Libro lib1 = new Libro(titulo, autor, editorial, ubicacion, ISBN, precio);
    }

    public static void menuBusquedaLibro(){
        System.out.println("Que va a introducir para la búsqueda: \n 1. Título \n 2. Autor \n 3. Editorial \n 4. Ubicación \n 5. ISBN \n 6. Nombre del empleado que ha prestado el libro \n 7. Estado préstamo \n 8. Nombre usuario que ha alquilado el libro \n 9. Salir");
        int eleccionBusquedaLibro = sc.nextInt();
        sc.nextLine();
        if (eleccionBusquedaLibro!=9) {
            switch (eleccionBusquedaLibro) {
                case 1:
                    
                    break;
            
                default:
                    break;
            }
            
        }
    }
    public static void main(String[] args) throws Exception {
        int eleccion = 0;
        do {
            //Objetos Anti-Hardcoding
            Libro prueba = new Libro("El Mentalista", "Camilla Läckberg", "Editorial Planeta", false, 1, "978-84-08-25519-2", 1, 14,99, null);
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
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
            }
        } while (eleccion!=8);
    }
}
