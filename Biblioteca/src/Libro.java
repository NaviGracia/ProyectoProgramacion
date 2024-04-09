public class Libro {
    private String titulo;
    private String autor;
    private String editorial;
    private boolean estadoPrestamo;
    private int ubicacionBiblioteca;
    private String ISBN;
    private double precio;
    private String bibliotecarioPrestado;
    private String usuarioLibro;
    
    public Libro() {}

    public Libro(String titulo, String autor, String editorial, int ubicacionBiblioteca, String iSBN, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.ubicacionBiblioteca = ubicacionBiblioteca;
        ISBN = iSBN;
        this.precio = precio;
    }
    
    public Libro(String titulo, String autor, String editorial, boolean estadoPrestamo, int ubicacionBiblioteca,
            String iSBN, double precio, String bibliotecarioPrestado, String usuarioLibro) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.estadoPrestamo = estadoPrestamo;
        this.ubicacionBiblioteca = ubicacionBiblioteca;
        ISBN = iSBN;
        this.precio = precio;
        this.bibliotecarioPrestado = bibliotecarioPrestado;
        this.usuarioLibro = usuarioLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public boolean isEstadoPrestamo() {
        return estadoPrestamo;
    }

    public void setEstadoPrestamo(boolean estadoPrestamo) {
        this.estadoPrestamo = estadoPrestamo;
    }

    public int getUbicacionBiblioteca() {
        return ubicacionBiblioteca;
    }

    public void setUbicacionBiblioteca(int ubicacionBiblioteca) {
        this.ubicacionBiblioteca = ubicacionBiblioteca;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int iSBN) {
        ISBN = iSBN;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getBibliotecarioPrestado() {
        return bibliotecarioPrestado;
    }

    public void setBibliotecarioPrestado(String bibliotecarioPrestado) {
        this.bibliotecarioPrestado = bibliotecarioPrestado;
    }

    public String getUsuarioLibro() {
        return usuarioLibro;
    }

    public void setUsuarioLibro(String usuarioLibro) {
        this.usuarioLibro = usuarioLibro;
    }

}
