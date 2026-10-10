public class Main {
    public static void main(String[] args) {
        Mazo modelo = new Mazo();
        JuegoView vista = new JuegoView();
        JuegoController controlador = new JuegoController(modelo, vista);

        controlador.iniciarJuego();
    }
} 
