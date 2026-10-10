public abstract class Carta {
    protected int id;
    protected String nombre;
    protected int costoEnergia;
    protected String descripcion;
public Carta(int id, String nombre, int costoEnergia, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.costoEnergia = costoEnergia;
        this.descripcion = descripcion;
    }

    public abstract void jugarCarta();

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCostoEnergia() {
        return costoEnergia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + nombre + " [Costo: " + costoEnergia + " E] - " + descripcion;
    }
} 