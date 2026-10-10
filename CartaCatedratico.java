public class CartaCatedratico extends Carta {
    private String departamento;
    private int llamadasAtencion;
    private int tiempoAtencion;

    public CartaCatedratico(int id, String nombre, int costoEnergia, String descripcion, String departamento, int llamadasAtencion, int tiempoAtencion) {
        super(id, nombre, costoEnergia, descripcion);
        this.departamento = departamento;
        this.llamadasAtencion = llamadasAtencion;
        this.tiempoAtencion = tiempoAtencion;
    }

    @Override
    public void jugarCarta() {
        System.out.println("El catedrático " + nombre + " de " + departamento + " aplica " + llamadasAtencion + " llamada(s) de atención.");
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getLlamadasAtencion() {
        return llamadasAtencion;
    }

    public int getTiempoAtencion() {
        return tiempoAtencion;
    }

    @Override
    public String toString() {
        return super.toString() + " | Dep: " + departamento + " | Llamadas: " + llamadasAtencion + " | Tiempo: " + tiempoAtencion + " min";
    }
} 
