import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    static Scanner sc = new Scanner(System.in);
    
    public static void librosToString(PreparedStatement sentencia, ResultSet rs){
        try {
            rs = sentencia.executeQuery();
            System.out.println("Libros encontrados:");
            while (rs.next()) {
            System.out.println(ANSI_RED + rs.getString(1) + " | " + rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getBoolean(4) + " | " + rs.getInt(5) + " | " + rs.getString(6) + " | " + rs.getDouble(7) + "€ | " + rs.getString(8) + " | " + rs.getString(9) + ANSI_RESET);
        }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void altaLibro(Connection conexion){
        try {
            System.out.println("Introduzca el titulo:");
            String titulo = sc.nextLine();
            System.out.println("Introduzca el autor:");
            String autor = sc.nextLine();
            System.out.println("Introduzca la editorial:");
            String editorial = sc.nextLine();
            System.out.println("Introduzca la ubicación (pasillo numérico):");
            int ubicacion = sc.nextInt();
            sc.nextLine();
            System.out.println("Introduzca el ISBN:");
            String ISBN = sc.nextLine();
            System.out.println("Introduzca el precio:");
            BigDecimal precio = sc.nextBigDecimal();
            sc.nextLine();

            String sentenciaSQL = "INSERT INTO libros VALUES(?, ?, ?, 'false',?, ?, ?, null, null)";
            PreparedStatement sentencia = null;
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, titulo);
            sentencia.setString(2, autor);
            sentencia.setString(3, editorial);
            sentencia.setInt(4, ubicacion);
            sentencia.setString(5, ISBN);
            sentencia.setBigDecimal(6, precio);

            sentencia.executeUpdate();

            sentencia.close();
            
            System.out.println("Libro añadido");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error en dar el alta del libro");
        }
    }

    public static void menuBusquedaLibro(Connection conexion, Statement st){
        try {
            int x = 1;
            System.out.println("Parámetros de Búsqueda: \n 1. Título \n 2. Autor \n 3. Editorial \n 4. Ubicación \n 5. ISBN \n 6. Nombre del empleado que ha prestado el libro \n 7. Estado préstamo \n 8. Nombre usuario que ha alquilado el libro \n 9. Salir");
            System.out.print("Introduzca un nº:");
            int eleccionBusquedaLibro = sc.nextInt();
            sc.nextLine();
            if (eleccionBusquedaLibro!=9) {
                PreparedStatement sentencia = null;
                ResultSet rs = null;
                String sentenciaSQL = null;
                switch (eleccionBusquedaLibro) {
                    case 1:
                        System.out.println("Introduzca el título del libro que desea buscar:");
                        String busquedaTitulo = sc.nextLine();

                        sentenciaSQL = "SELECT * FROM libros WHERE titulo = ?";
                        
                        sentencia = conexion.prepareStatement(sentenciaSQL);
                        sentencia.setString(1, busquedaTitulo);
                        librosToString(sentencia, rs);           
                        break;
                    case 2:
                        System.out.println("Introduzca el autor del libro que desea buscar:");
                        String busquedaAutor = sc.nextLine();
                        sentenciaSQL = "SELECT * FROM libros WHERE autor = ?";
                        sentencia = conexion.prepareStatement(sentenciaSQL);
                        sentencia.setString(1, busquedaAutor);
                        librosToString(sentencia, rs);
                        break;
                    case 3:
                        System.out.println("Introduzca la editorial del libro que desea buscar:");
                        String busquedaEditorial = sc.nextLine();
                        sentenciaSQL = "SELECT * FROM libros WHERE editorial = ?";
                        sentencia = conexion.prepareStatement(sentenciaSQL);
                        sentencia.setString(1, busquedaEditorial);
                        librosToString(sentencia, rs);
                        break;
                    case 4:
                        System.out.println("Introduzca la ubicación del libro que desea buscar:");
                        int busquedaUbicacion = sc.nextInt();
                        sentenciaSQL = "SELECT * FROM libros WHERE ubicacion_biblioteca = ?";
                        sentencia = conexion.prepareStatement(sentenciaSQL);
                        sentencia.setInt(1, busquedaUbicacion);
                        librosToString(sentencia, rs);
                        break;
                    case 5:
                        System.out.println("Introduzca el ISBN del libro que desea buscar:");
                        String busquedaISBN = sc.nextLine();
                        sentenciaSQL = "SELECT * FROM libros WHERE ISBN = ?";
                        sentencia = conexion.prepareStatement(sentenciaSQL);
                        sentencia.setString(1, busquedaISBN);
                        librosToString(sentencia, rs);
                        break;
                    case 6:
                        System.out.println("Introduzca el nombre del empleado que desea buscar:");
                        String busquedaEmpleado = sc.nextLine();
                        sentenciaSQL = "SELECT * FROM libros WHERE bibliotecario_prestamo = ?";
                        sentencia = conexion.prepareStatement(sentenciaSQL);
                        sentencia.setString(1, busquedaEmpleado);
                        librosToString(sentencia, rs);
                        break;
                    case 7:
                        System.out.println("Introduzca el estado del prestamo (true | false) que desea buscar:");
                        Boolean busquedaPrestamo = sc.nextBoolean();
                        sentenciaSQL = "SELECT * FROM libros WHERE estado_prestamo = ?";
                        sentencia = conexion.prepareStatement(sentenciaSQL);
                        sentencia.setBoolean(1, busquedaPrestamo);
                        librosToString(sentencia, rs);
                        break;
                    case 8:
                        System.out.println("Introduzca el nombre del usuario que desea buscar:");
                        String busquedaUsuario = sc.nextLine();
                        sentenciaSQL = "SELECT * FROM libros WHERE usuario_prestamo = ?";
                        sentencia = conexion.prepareStatement(sentenciaSQL);
                        sentencia.setString(1, busquedaUsuario);
                        librosToString(sentencia, rs);
                        break;
                    case 9:
                        System.out.println("Saliendo al menú principal");
                        break;
                    default:
                        System.out.println("Nº Incorrecto");
                        break;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error en la busqueda de libros");
        }
    }

    public static void eliminarLibro(Connection conexion){
        try {
            String sentenciaSQL = "DELETE FROM libros WHERE titulo = ?";
            PreparedStatement sentencia = null;
            sentencia = conexion.prepareStatement(sentenciaSQL);

            System.out.println("Introduzca el título del libro listado a eliminar:");
            String eliminar = sc.nextLine();
            sentencia.setString(1, eliminar);
            
            sentencia.executeUpdate();

            System.out.println("Libro " + eliminar + " eliminado correctamente.");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error en la eliminación del libro");
        }
    }

    public static void alquilarLibro(Connection conexion, Statement st){
        try {
            System.out.println("Mostrando libros disponibles:");
            //Mostrando libros no alquilados            
            ResultSet estado = st.executeQuery("SELECT * FROM libros WHERE estado_prestamo = false");
            while (estado.next()) {
                System.out.println(ANSI_RED + estado.getString(1) + " | " + estado.getString(2) + " | " + estado.getString(3) + " | " + estado.getBoolean(4) + " | " + estado.getInt(5) + " | " + estado.getString(6) + " | " + estado.getDouble(7) + "€ | " + estado.getString(8) + " | " + estado.getString(9) + ANSI_RESET);
            }
            
            estado.close();
            
            System.out.println("Introduzca el título del libro a alquilar:");
            String libroAlquilado = sc.nextLine();

            //Mostrando usuarios            
            System.out.println("Mostrando usuarios:");
            ResultSet usuarios = st.executeQuery("SELECT * FROM usuarios");
            while (usuarios.next()) {
                System.out.println(ANSI_RED + usuarios.getString(1) + ANSI_RESET);
            }
            usuarios.close();
            System.out.println("Elige su usuario:");
            String usuarioAlquiler = sc.nextLine();

            //Mostrando empleados            
            System.out.println("Mostrando empleados:");
            ResultSet empleados = st.executeQuery("SELECT * FROM empleados");
            while (empleados.next()) {
                System.out.println(ANSI_RED + empleados.getString(1) + ANSI_RESET);
            }
            empleados.close();
            System.out.println("Elige el nombre del empleado que le a atendido:");
            String empleadoAlquiler = sc.nextLine();

            //Modificando estado_prestamo del libro alquilado a true en la BD
            String sentenciaSQL = "UPDATE libros SET estado_prestamo = 'true', bibliotecario_prestamo = ?, usuario_prestamo = ? WHERE titulo = ?";
            PreparedStatement sentencia = null;
            sentencia = conexion.prepareStatement(sentenciaSQL);
            sentencia.setString(1, empleadoAlquiler);
            sentencia.setString(2, usuarioAlquiler);
            sentencia.setString(3, libroAlquilado);
            sentencia.executeUpdate();
            sentencia.close();
            
            System.out.println("Libro Alquilado");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error al alquilar el libro");
        }
    }

    public static void devolucionLibro(Connection conexion, Statement st){
        try {
            ArrayList<String> titulos = new ArrayList<>();
            //Consulta a la BD de los libros que están alquilados
            System.out.println("Mostrando libros alquilados:");
            ResultSet alquilado = st.executeQuery("SELECT * FROM libros WHERE estado_prestamo = 'true'");
            while (alquilado.next()) {
                System.out.println(ANSI_RED + alquilado.getString(1) + " | " + alquilado.getString(2) + " | " + alquilado.getString(3) + " | " + alquilado.getBoolean(4) + " | " + alquilado.getInt(5) + " | " + alquilado.getString(6) + " | " + alquilado.getDouble(7) + "€ | " + alquilado.getString(8) + " | " + alquilado.getString(9) + ANSI_RESET);
                titulos.add(alquilado.getString(1));
                
            }
            alquilado.close();
            System.out.println("Introduzca el título del libro a devolver:");
            String libroDevuelto = sc.nextLine();
            int x = 0;
            for (String comprobar : titulos) {
                if (comprobar.equalsIgnoreCase(libroDevuelto)) {
                    String sentenciaSQL = "UPDATE libros SET estado_prestamo = 'false', bibliotecario_prestamo = null, usuario_prestamo = null WHERE titulo = ?";
                    PreparedStatement sentencia = null;
                    sentencia = conexion.prepareStatement(sentenciaSQL);
                    sentencia.setString(1, libroDevuelto);
                    sentencia.executeUpdate();
                    System.out.println("Devolución Completada");
                    x = 1;
                }
            }
            if (x == 0) {
                System.out.println("El libro introducido no está registrado como prestado en el sistema, por favor, revise si los datos se han introducido correctamentente");
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error en la devolución del libro");
        }
    }

    public static void menuGestionEmpleados(Connection conexion){
        try {
            int eleccion;
            do {
                System.out.println("Menú de Gestión de Empleados: \n 1. Listar Empleados \n 2. Dar de alta nuevo empleado \n 3. Dar de baja a empleado \n 4. Salir");
                eleccion = sc.nextInt();
                sc.nextLine();
                PreparedStatement sentencia = null;
                String sentenciaSQL;
                switch (eleccion) {
                    case 1:

                        sentenciaSQL = "SELECT * FROM empleados";
                        sentencia = conexion.prepareStatement(sentenciaSQL);
                        ResultSet rt = sentencia.executeQuery();
                        System.out.println("Mostrando Empleados:");
                        while (rt.next()) {
                            System.out.println(ANSI_RED + rt.getString(1) + ANSI_RESET);
                        }
                        break;
                    case 2:
                        System.out.println("Inserte el nombre del nuevo empleado:");
                        String nuevoEmp = sc.nextLine();
                        sentenciaSQL = "INSERT INTO empleados VALUES(?)";
                        sentencia = conexion.prepareStatement(sentenciaSQL);
                        sentencia.setString(1, nuevoEmp);
                        sentencia.executeUpdate();
                        System.out.println("Empleado " + nuevoEmp + " añadido correctamente");
                        break;
                    case 3:
                        System.out.println("Inserte el nombre del empleado a eliminar:");
                        String eliminarEmp = sc.nextLine();
                        sentenciaSQL = "DELETE FROM empleados WHERE nombre_emp = ?";
                        sentencia = conexion.prepareStatement(sentenciaSQL);
                        sentencia.setString(1, eliminarEmp);
                        sentencia.executeUpdate();
                        System.out.println("Empleado " + eliminarEmp + " eliminado correctamente");
                        break;
                    case 4:
                        System.out.println("Saliendo al menú principal");
                        break;
                    default:
                        System.out.println("Nº Incorrecto");
                        break;
                }
            } while (eleccion!=4);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error en la gestión de empleados");
        }
    }

    public static void menuGestionUsuarios(Connection conexion){
        try {
            int eleccion;
            do {
                System.out.println("Menú de Gestión de Usuarios: \n 1. Listar Usuarios \n 2. Dar de alta nuevo usuario \n 3. Dar de baja a empleado \n 4. Salir");
                eleccion = sc.nextInt();
                sc.nextLine();
                PreparedStatement sentencia = null;
                String sentenciaSQL;
                switch (eleccion) {
                    case 1:

                        sentenciaSQL = "SELECT * FROM usuarios";
                                
                        sentencia = conexion.prepareStatement(sentenciaSQL);
                        ResultSet rt = sentencia.executeQuery();
                        System.out.println("Mostrando Usuarios:");
                        while (rt.next()) {
                            System.out.println(ANSI_RED + rt.getString(1) + ANSI_RESET);
                        }
                        break;
                    case 2:
                        System.out.println("Inserte el nombre del nuevo usuario:");
                        String nuevoUsu = sc.nextLine();
                        sentenciaSQL = "INSERT INTO usuarios VALUES(?)";
                        sentencia = conexion.prepareStatement(sentenciaSQL);
                        sentencia.setString(1, nuevoUsu);
                        sentencia.executeUpdate();
                        System.out.println("Usuario " + nuevoUsu + " añadido correctamente");
                        break;
                    case 3:
                        System.out.println("Inserte el nombre del usuario a eliminar:");
                        String eliminarUsu = sc.nextLine();
                        sentenciaSQL = "DELETE FROM Usuarios WHERE nombre_usu = ?";
                        sentencia = conexion.prepareStatement(sentenciaSQL);
                        sentencia.setString(1, eliminarUsu);
                        sentencia.executeUpdate();
                        System.out.println("Usuario " + eliminarUsu + " eliminado correctamente");
                        break;
                    case 4:
                        System.out.println("Saliendo al menú principal");
                        break;
                    default:
                        System.out.println("Nº Incorrecto");
                        break;
                }
            } while (eleccion!=4);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error en la gestión de usuarios");
        }
        
    }
    public static void main(String[] args) throws Exception {
        //Conexión BD
        try {
            Class.forName("org.postgresql.Driver"); 
            } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error al registrar el driver de PostgresQL");
        }
        
        try { 
            Connection conexion = null;
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Biblioteca", "dam", "dam");
            Statement st = conexion.createStatement();

            int eleccion = 0;
            do {
                //Menú Principal
                System.out.println("Bienvenido al sistema gestor de la biblioteca: \n 1. Dar de alta un libro \n 2. Búsqueda de libro \n 3. Dar de baja un libro \n 4. Alquilar libro \n 5. Devolución libro \n 6. Gestión de emplead@s \n 7. Gestión de usuari@s \n 8. Salir del sistema");
                eleccion = sc.nextInt();
                sc.nextLine();
                switch (eleccion) {
                    case 1:
                        altaLibro(conexion);
                        break;
                    case 2:
                        menuBusquedaLibro(conexion, st);
                        break;
                    case 3:
                        menuBusquedaLibro(conexion, st);
                        eliminarLibro(conexion);
                        break;
                    case 4:
                        alquilarLibro(conexion, st);
                        break;
                    case 5:
                        devolucionLibro(conexion, st);
                        break;
                    case 6:
                        menuGestionEmpleados(conexion);
                        break;
                    case 7:
                        menuGestionUsuarios(conexion);
                        break;
                    case 8:
                        System.out.println("Programa finalizado");
                        break;
                    default:
                        System.out.println("Nº Incorrecto");
                        break;
                } 
            } while (eleccion!=8);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error en el main");
        }
    }
}
