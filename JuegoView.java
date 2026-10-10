import java.util.List;
import java.util.Scanner;

public class JuegoView {
    private Scanner scanner;

    public JuegoView() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n=== UVG CARD BATTLE ===");
        System.out.println("1. Listar todas las cartas del mazo");
        System.out.println("2. Buscar carta por ID");
        System.out.println("3. Buscar carta por Nombre");
        System.out.println("4. Ordenar mazo por costo de energía");
        System.out.println("5. Jugar una carta");
        System.out.println("6. Pasar turno / Tomar carta");
        System.out.println("7. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public void mostrarCartas(List<Carta> cartas) {
        if (cartas.isEmpty()) {
            System.out.println("El mazo está vacío.");
        } else {
            System.out.println("\n--- CARTAS EN EL MAZO ---");
            for (Carta c : cartas) {
                System.out.println(c.toString());
            }
        }
    }

    public void mostrarEstado(int energia, int turno) {
        System.out.println("\n==========================================");
        System.out.println(" TURNO ACTUAL: " + turno + " | ENERGÍA DISPONIBLE: " + energia + " pts ");
        System.out.println("==========================================");
    }

    public int pedirEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada no válida. Ingrese un número entero.");
            scanner.next();
            System.out.print(mensaje);
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    public String pedirTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}  