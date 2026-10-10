public class CartaEvento extends Carta {
    private String tipoEvento;

    public CartaEvento(int id, String nombre, int costoEnergia, String descripcion, String tipoEvento) {
        super(id, nombre, costoEnergia, descripcion);
        this.tipoEvento = tipoEvento;
    }

    @Override
    public void jugarCarta() {
        System.out.println("¡Evento de tipo " + tipoEvento + " activado!: " + nombre + " - " + descripcion);
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    @Override
    public String toString() {
        return super.toString() + " | Evento: " + tipoEvento;
    }
}  