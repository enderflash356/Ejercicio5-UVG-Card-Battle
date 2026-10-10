import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Mazo {
    private ArrayList<Carta> cartas;
    private int energiaJugador;
    private int turnoActual;

    public Mazo() {
        this.cartas = new ArrayList<>();
        this.energiaJugador = 5;
        this.turnoActual = 1;
        generarMazoInicial();
    }

    public void generarMazoInicial() {
        cartas.clear();

        cartas.add(new CartaCatedratico(1, "Lic. Morales", 3, "Exigente con la impuntualidad", "Matemática", 2, 15));
        cartas.add(new CartaCatedratico(2, "Ing. Pérez", 4, "Revisa minuciosamente el código", "Computación", 3, 20));
        cartas.add(new CartaCatedratico(3, "Dra. Rodríguez", 2, "Realiza preguntas sorpresa", "Física", 1, 10));

        cartas.add(new CartaCurso(4, "POO", 3, "Aprende herencia y polimorfismo", 5, 8));
        cartas.add(new CartaCurso(5, "Cálculo 1", 4, "Límites y derivadas complejas", 6, 9));
        cartas.add(new CartaCurso(6, "Física 1", 2, "Leyes de Newton y cinemática", 4, 7));
        cartas.add(new CartaCurso(7, "Algoritmos", 3, "Estructuras de datos básicas", 5, 6));

        cartas.add(new CartaEvento(8, "Semana de Parciales", 2, "Aumenta la tensión en el ambiente", "Académico"));
        cartas.add(new CartaEvento(9, "Feria de Clubes", 1, "Recuperas el ánimo interactuando", "Social"));
        cartas.add(new CartaEvento(10, "Entrega de Proyecto", 5, "Noche en vela para terminar", "Evaluación"));
    } 

    public void ordenarPorEnergia() {
        Collections.sort(cartas, Comparator.comparingInt(Carta::getCostoEnergia));
    }

    public Carta buscarCarta(int id) {
        for (Carta c : cartas) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public Carta buscarCarta(String nombre) {
        for (Carta c : cartas) {
            if (c.getNombre().equalsIgnoreCase(nombre) || c.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                return c;
            }
        }
        return null;
    }

    public boolean usarCarta(Carta carta) {
        if (carta != null && energiaJugador >= carta.getCostoEnergia()) {
            energiaJugador -= carta.getCostoEnergia();
            carta.jugarCarta();
            cartas.remove(carta);
            return true;
        }
        return false;
    }

    public void pasarTurno() {
        turnoActual++;
        energiaJugador = 5 + turnoActual;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public int getEnergiaJugador() {
        return energiaJugador;
    }

    public int getTurnoActual() {
        return turnoActual;
    }
} 
