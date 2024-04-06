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
        int ISBN = sc.nextInt();
        System.out.println("Introduzca el precio:");
        double precio = sc.nextDouble();

        Libro lib = new Libro(titulo, autor, editorial, ubicacion, ISBN, precio);

    }
    public static void main(String[] args) throws Exception {
        int eleccion = 0;
        do {
            System.out.println("Bienvenido al sistema gestor de la biblioteca:");
            System.out.println("1. Dar de alta un libro");
            System.out.println("2. Búsqueda de libro");
            System.out.println("3. Dar de baja un libro");
            System.out.println("4. Alquilar libro");
            System.out.println("5. Devolución libro");
            System.out.println("6. Gestión de emplead@s");
            System.out.println("7. Gestión de usuari@s");
            System.out.println("8. Salir del sistema");
            eleccion = sc.nextInt();
            switch (eleccion) {
                case 1:
                    altaLibro();
                    break;
                case 2:
                    
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
