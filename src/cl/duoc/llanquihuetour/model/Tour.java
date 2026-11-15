package cl.duoc.llanquihuetour.model;

public class Tour {
    private String nombre;
    private String ubicacion;
    private int valor;
    private String categoria;

    public Tour(String nombre, String ubicacion, int valor, String categoria) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.valor = valor;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    @Override
    public String toString() {
        return """
            ╔══════════════════════════════════════════╗
                      🏞️ %s
            ╠══════════════════════════════════════════╣
              Ubicación  : %s
              Valor      : $%,d CLP
              Categoría  : %s
            ╚══════════════════════════════════════════╝
            """.formatted( nombre, ubicacion, valor, categoria);
    }
}
