public class CartaCurso extends Carta {
    private int creditos;
    private int dificultad;

    public CartaCurso(int id, String nombre, int costoEnergia, String descripcion, int creditos, int dificultad) {
        super(id, nombre, costoEnergia, descripcion);
        this.creditos = creditos;
        this.dificultad = dificultad;
    }

    @Override
    public void jugarCarta() {
        System.out.println("Has cursado " + nombre + " (Dificultad: " + dificultad + "/10). ¡Aportó " + creditos + " créditos a tu historial!");
    }

    public int getCreditos() {
        return creditos;
    }

    public int getDificultad() {
        return dificultad;
    }

    @Override
    public String toString() {
        return super.toString() + " | Créditos: " + creditos + " | Dificultad: " + dificultad;
    }
}  
